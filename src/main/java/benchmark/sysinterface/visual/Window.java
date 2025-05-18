package benchmark.sysinterface.visual;

import javax.swing.*;

import java.awt.*;

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

        setVisible(true);
    }
}
