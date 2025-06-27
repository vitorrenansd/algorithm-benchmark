package benchmark.sysinterface.actions;

import javax.swing.*;
import org.jfree.chart.JFreeChart;
import java.awt.*;
import java.util.List;
import java.util.Map;

import benchmark.core.*;
import benchmark.sysinterface.visual.*;

public class Window extends JFrame {
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 640;

    public Window() {
        // Window config
        setTitle("Algorithm Benchmark");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null); // Center
        setResizable(false);

        ConfigPanel configPanel = new ConfigPanel();
        BenchmarkPanel benchmarkPanel = new BenchmarkPanel();
        ButtonPanel buttonPanel = new ButtonPanel();

        // Add to frame
        setLayout(new BorderLayout());
        add(configPanel, BorderLayout.NORTH);
        add(benchmarkPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        ImageExtractor imgExtractor = new ImageExtractor();
        TimeStamp timeStp = new TimeStamp();
        ResultChart chartBuilder = new ResultChart();

        // Action when RUN is pressed
        buttonPanel.benchmarkButton.addActionListener(_ -> {
            buttonPanel.loadingLabel.setVisible(true);

            new Thread(() -> {
                try {
                    String path = configPanel.folderPath.getText();
                    String quantityText = configPanel.quantity.getText();
                    String criteria = (String) configPanel.chooseAlgorithm.getSelectedItem();

                    // If user dont set quantity
                    if (quantityText == null || quantityText.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please set a quantity of tests", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // User config
                    int quantity = Integer.parseInt(quantityText);
                    imgExtractor.setImagesPath(path);
                    timeStp.setQuantity(quantity);

                    // List the archives from folder
                    List<Long> values;
                    if ("Datetime".equals(criteria)) {
                        values = imgExtractor.pullAllLastModified();
                    } else if ("Size (bytes)".equals(criteria)) {
                        values = imgExtractor.pullAllSize();
                    } else {
                        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Unknown criteria selected", "ERROR", JOptionPane.ERROR_MESSAGE));
                        return;
                    }

                    // Benchmark them
                    Map<String, Long> results = timeStp.benchmarkAll(values);

                    // Builds using ResultChart class
                    JFreeChart chart = chartBuilder.buildBarGraph(
                        results.get("MergeSort"),
                        results.get("HeapSort"),
                        results.get("BubbleSort")
                    );

                    // Show chart
                    SwingUtilities.invokeLater(() -> benchmarkPanel.showChart(chart));
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE));
                } finally {
                    SwingUtilities.invokeLater(() -> buttonPanel.loadingLabel.setVisible(false)); // Hide "Loading..."
                }
            }).start(); // Run in a new thread
        });
        setVisible(true);
    }
}