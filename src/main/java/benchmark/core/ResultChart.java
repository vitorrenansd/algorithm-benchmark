package benchmark.core;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ResultChart extends JFrame {

    public JFreeChart buildBarGraph(Long mergeTime, Long heapTime, Long bubbleTime) {
            DefaultCategoryDataset bar = new DefaultCategoryDataset();

            // Creating bars
            bar.setValue(mergeTime, "MergeSort", "");
            bar.setValue(heapTime, "HeapSort", "");
            bar.setValue(bubbleTime, "BubbleSort", "");

            // Graph config
            return ChartFactory.createBarChart("Tempo necessário (ms)", "", "ms", bar, PlotOrientation.HORIZONTAL, true, true, false);
    }
}
