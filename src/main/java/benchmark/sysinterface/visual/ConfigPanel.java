package benchmark.sysinterface.visual;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    // Attribute == frame Object
    public JComboBox<String> chooseAlgorithm;
    public JTextField folderPath;
    public JTextField quantity;

    public ConfigPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Centralized

        // Algorithms combobox
        String[] algorithms = {"Datetime", "Size (bytes)", "The two's"};
        add(new JLabel("Datatype:"));
        chooseAlgorithm = new JComboBox<>(algorithms);
        chooseAlgorithm.setPreferredSize(new Dimension(150, 25));
        add(chooseAlgorithm);

        // Images path field
        add(new JLabel("Images path:"));
        folderPath = new JTextField();
        folderPath.setPreferredSize(new Dimension(460, 25));
        add(folderPath);

        // Quantity field
        add(new JLabel("Tests quantity:"));
        quantity = new JTextField();
        quantity.setPreferredSize(new Dimension(85, 25));
        add(quantity);
    }
}