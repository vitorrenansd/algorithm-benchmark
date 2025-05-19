package benchmark.core;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ResultChart extends JFrame {

    public JFreeChart buildBarGraph(Long mergeTime, Long heapTime, Long bubbleTime) {
        DefaultCategoryDataset bar = new DefaultCategoryDataset();

        // Creating bars
        bar.setValue(mergeTime, "MergeSort", "");
        bar.setValue(heapTime, "HeapSort", "");
        bar.setValue(bubbleTime, "BubbleSort", "");

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Execution time (ms)", "", "",
            bar,
            PlotOrientation.HORIZONTAL,
            true, true, false
        );

        // Enable value labels on bars
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);

        return chart;
    }
}
