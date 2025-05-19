package benchmark.sysinterface.actions;

import javax.swing.*;
import java.awt.*;

import benchmark.core.*;
import benchmark.sysinterface.visual.*;

public class Window extends JFrame {
    public Window() {
        // Window config
        setTitle("Algorithm Benchmark");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 640); // Resolution
        setLocationRelativeTo(null); // Center
        setResizable(false);

        ConfigPanel configPanel = new ConfigPanel();
        BenchmarkPanel benchmarkPanel = new BenchmarkPanel(); // PLACEHOLDER
        ButtonPanel buttonPanel = new ButtonPanel();

        // Add to frame
        setLayout(new BorderLayout());
        add(configPanel, BorderLayout.NORTH);
        add(benchmarkPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        ImageExtractor imgExtractor = new ImageExtractor();
        TimeStamp timeStp = new TimeStamp();

        // Action when RUN is pressed
        buttonPanel.benchmarkButton.addActionListener(e -> {
            try {
                String path = configPanel.folderPath.getText();
                String quantityText = configPanel.quantity.getText();
                String criteria = (String) configPanel.chooseAlgorithm.getSelectedItem();

                // If user dont set quantity
                if (quantityText == null || quantityText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Please set a quantity of tests", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int quantity = Integer.parseInt(quantityText);

                imgExtractor.setImagesPath(path);
                timeStp.setQuantity(quantity);

                if (criteria == "Datetime") {
                    long bubbleTime;
                    long HeapTime;
                    long MergeTime;
                }
                if (criteria == "Size (bytes)") {

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
