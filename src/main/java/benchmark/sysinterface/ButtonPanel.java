package benchmark.sysinterface;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    // Attribute == frame Object
    public JButton benchmarkButton;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // Centralized with gap between

        benchmarkButton = new JButton("Run Benchmark");

        add(benchmarkButton);
    }
}