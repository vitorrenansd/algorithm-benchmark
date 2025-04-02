package benchmark;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ResultChart extends JFrame{

    public void createBarGraph(Integer mergeTime, Integer heapTime, Integer bubbleTime) {
            DefaultCategoryDataset bar = new DefaultCategoryDataset();

            // Creating bars
            bar.setValue(mergeTime, "MergeSort", "");
            bar.setValue(heapTime, "HeapSort", "");
            bar.setValue(bubbleTime, "BubbleSort", "");

            // Graph config
            JFreeChart graph = ChartFactory.createBarChart("Tempo necessário (ms)", "", "ms", bar, PlotOrientation.HORIZONTAL, true, true, false);

            // Graph add to panel
            ChartPanel panel = new ChartPanel(graph);
            add(panel);
    }
}
