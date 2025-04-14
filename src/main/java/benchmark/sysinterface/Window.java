package benchmark.sysinterface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        // Window config
        setTitle("Algorithm Benchmark");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 640); // Resolution
        setLocationRelativeTo(null); // Center
        setResizable(false); // User can't change window size

        ConfigPanel configPanel = new ConfigPanel();
        ButtonPanel buttonPanel = new ButtonPanel();
        BenchmarkPanel benchmarkPanel = new BenchmarkPanel(); // PLACEHOLDER

        setLayout(new BorderLayout());
        add(configPanel, BorderLayout.NORTH);
        add(benchmarkPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
