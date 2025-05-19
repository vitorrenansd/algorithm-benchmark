package benchmark.sysinterface.visual;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class BenchmarkPanel extends JPanel {
    public BenchmarkPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 300));
        setBackground(Color.GRAY);
    }

    public void showChart(JFreeChart chart) {
        removeAll(); // Limpa gráficos anteriores
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}