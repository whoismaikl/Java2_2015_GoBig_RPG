package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.HistoryRecord;
import lv.javaguru.java2.domain.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
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
public class ChartService
{
    public void createTimeSeriesChart(List<HistoryRecord> historyRecordList) throws IOException {
        final TimeSeries series1 = new TimeSeries("Health");
        final TimeSeries series2 = new TimeSeries("Intelligence");
        final TimeSeries series3 = new TimeSeries("Communication");
        long healthVal;
        long inteligenceVal;
        long communicationVal;
        double value;
        for (HistoryRecord historyRecord : historyRecordList) {
            try {
                healthVal = historyRecord.getHealth();
                inteligenceVal = historyRecord.getIntelligence();
                communicationVal = historyRecord.getCommunication();
                Date date = historyRecord.getDateCompleted();
                Day day = new Day(date);
                series1.add(day, healthVal);
                series2.add(day, inteligenceVal);
                series3.add(day, communicationVal);
            } catch (SeriesException e) {
                System.err.println("Error adding to series");
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
        axis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));

        int width = 920; /* Width of the image */
        int height = 480; /* Height of the image */
        File timeChart = new File("./src/main/webapp/includes/LineChart.jpeg");
        ChartUtilities.saveChartAsJPEG(timeChart, timechart, width, height);
    }

    public void createBarChart(User user) throws IOException {
        final String HEALTH = "Health";
        final String INTELLIGENCE = "Intelligence";
        final String COMMUNICATION = "Communication";
        int healthVal = user.getHealth();
        int inteligenceVal = user.getIntelligence();
        int communicationVal = user.getCommunication();

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(healthVal, HEALTH, HEALTH);
        dataset.addValue(inteligenceVal, INTELLIGENCE, INTELLIGENCE);
        dataset.addValue(communicationVal, COMMUNICATION, COMMUNICATION);

        JFreeChart barChart = ChartFactory.createBarChart(
                "",
                "", "",
                dataset, PlotOrientation.HORIZONTAL,
                false,false,false);

        CategoryPlot categoryPlot= barChart.getCategoryPlot();

        ValueAxis rangeAxis= categoryPlot.getRangeAxis();
        rangeAxis.setVisible(false);
        //double maxRange = getMaxValue(healthVal,inteligenceVal,communicationVal)*1.1;
        //rangeAxis.setRange(0,maxRange);

        BarRenderer barRenderer= (BarRenderer) categoryPlot.getRenderer();
        barRenderer.setShadowVisible(false);
        barRenderer.setItemMargin(-1.5);
        barRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barRenderer.setBaseItemLabelsVisible(true);

        int width = 920; /* Width of the image */
        int height = 100; /* Height of the image */
        File barChartFile = new File("./src/main/webapp/includes/BarChart.jpeg");
        ChartUtilities.saveChartAsJPEG(barChartFile, barChart, width, height);
    }
    public int getMaxValue(int val1,int val2,int val3){
        int maxValue;
        if(val1>val2&&val1>val3)
            return maxValue=val1;
        else if(val2>val3)
            return maxValue=val2;
        return maxValue=val3;
    }

}
