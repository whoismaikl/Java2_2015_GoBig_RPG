package lv.javaguru.java2.services;

import javafx.scene.chart.CategoryAxis;
import lv.javaguru.java2.database.RecordDAO;
import lv.javaguru.java2.domain.Record;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by AST on 2015.12.05..
 */
@Component
public class TimeSeriesChart_image
{
    @Autowired
    @Qualifier("RecordDAO_ORM")
    private RecordDAO recordDAO;
    public static void createChart(List<Record> recordList) throws IOException {
    final TimeSeries series1 = new TimeSeries( "Health" );
    final TimeSeries series2 = new TimeSeries( "Intelligence" );
    final TimeSeries series3 = new TimeSeries( "Communication" );
        long healthVal;
        long inteligenceVal;
        long communicationVal;
    double value;
    for ( Record record: recordList )
    {
        try
        {
            healthVal = record.getHealth();
            inteligenceVal = record.getIntelligence();
            communicationVal = record.getCommunication();
            Date date = record.getDateCompleted();
            Day day = new Day(date);
            series1.add(day, healthVal);
            series2.add(day, inteligenceVal);
            series3.add(day, communicationVal);
        }
        catch ( SeriesException e )
        {
            System.err.println( "Error adding to series" );
        }
    }
        final TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(series1);
        timeSeriesCollection.addSeries(series2);
        timeSeriesCollection.addSeries(series3);

    JFreeChart timechart = ChartFactory.createTimeSeriesChart(
            "Task Statistic",
            "Date",
            "Scores",
            timeSeriesCollection,
            true,
            true,
            false);

        XYPlot plot = (XYPlot) timechart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MMM-yyyy"));
        axis.setVerticalTickLabels(true);
        axis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY,1));

        int width = 640; /* Width of the image */
        int height = 480; /* Height of the image */
        File timeChart = new File( "./src/main/webapp/includes/LineChart.jpeg" );
        ChartUtilities.saveChartAsJPEG(timeChart, timechart, width, height );
}

}
