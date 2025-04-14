package benchmark.sysinterface;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    // Attribute == frame Object
    public JButton bubbleButton;
    public JButton heapButton;
    public JButton mergeButton;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // Centralized with gap between

        bubbleButton = new JButton("Bubble Sort");
        heapButton = new JButton("Heap Sort");
        mergeButton = new JButton("Merge Sort");

        add(bubbleButton);
        add(heapButton);
        add(mergeButton);
    }
}