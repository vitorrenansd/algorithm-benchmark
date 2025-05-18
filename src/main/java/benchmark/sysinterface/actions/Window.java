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
                int quantity = Integer.parseInt(configPanel.quantity.getText());
                String criteria = (String) configPanel.chooseAlgorithm.getSelectedItem();

                imgExtractor.setImagesPath(path);
                timeStp.setQuantity(quantity);

                System.out.println(imgExtractor.getImagesPath());
                System.out.println(timeStp.getQuantity());

                if (criteria == "Datetime") {
                    long bubbleTime = 
                    timeStp.benchSorting(imgExtractor.pullAllLastModified(), null);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error trying to run benchmark: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
