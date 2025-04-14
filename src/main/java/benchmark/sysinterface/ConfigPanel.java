package benchmark.sysinterface;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    public JComboBox<String> chooseAlgorithm;
    public JTextField folderPath;
    public JTextField quantity;

    public ConfigPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] algorithms = {"Datetime", "Size (bytes)", "The two's"};

        add(new JLabel("Datatype:"));
        chooseAlgorithm = new JComboBox<>(algorithms);
        chooseAlgorithm.setPreferredSize(new Dimension(150, 25));
        add(chooseAlgorithm);

        add(new JLabel("Images path:"));
        folderPath = new JTextField();
        folderPath.setPreferredSize(new Dimension(460, 25));
        add(folderPath);

        add(new JLabel("Tests quantity:"));
        quantity = new JTextField();
        quantity.setPreferredSize(new Dimension(85, 25));
        add(quantity);
    }
}