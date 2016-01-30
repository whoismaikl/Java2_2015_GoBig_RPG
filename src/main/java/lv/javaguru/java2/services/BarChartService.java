package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by AST on 2015.12.05..
 */
@Component
public class BarChartService {

    public File createBarChart(User user) throws IOException {
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
        File barChartFile = new File("BarChart.jpeg");
        //ChartUtilities.saveChartAsJPEG(barChartFile, barChart, width, height);
        return barChartFile;
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
