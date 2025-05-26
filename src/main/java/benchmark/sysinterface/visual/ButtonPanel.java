package benchmark.sysinterface.visual;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    // Attribute == frame Object
    public JButton benchmarkButton;
    public JLabel loadingLabel;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // Centralized with gap between

        benchmarkButton = new JButton("START");

        loadingLabel = new JLabel("Running benchmark...");
        loadingLabel.setVisible(false);

        add(benchmarkButton);
        add(loadingLabel);
    }
}