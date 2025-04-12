package benchmark.sysinterface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        // Window config
        setTitle("Algorithm Benchmark");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Resolution 800x600
        setLocationRelativeTo(null); // Center
        setResizable(false); // User can't change window size

        // Creating components
        // First collumn (config)
        String[] algorithms = {"Datetime", "Size (bytes)", "The two's"};
        JLabel chooseAlgorithmLabel = new JLabel("Choose datatype:");
        JComboBox<String> chooseAlgorithm = new JComboBox<>(algorithms);
        chooseAlgorithm.setPreferredSize(new Dimension(150, 25));

        JLabel folderPathLabel = new JLabel("Images path:");
        JTextField folderPath = new JTextField();
        folderPath.setPreferredSize(new Dimension(500, 25));

        JLabel quantityLabel = new JLabel("Tests quantity:");
        JTextField quantity = new JTextField();
        quantity.setPreferredSize(new Dimension(100, 25));

        // Second column (big window benchmark)

        // Third collumn (especific algorithm buttons)


        // Creating layout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Setting layout to application
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(chooseAlgorithmLabel)
                    .addComponent(chooseAlgorithm))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(folderPathLabel)
                    .addComponent(folderPath))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(quantityLabel)
                    .addComponent(quantity))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseAlgorithmLabel)
                    .addComponent(folderPathLabel)
                    .addComponent(quantityLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseAlgorithm)
                    .addComponent(folderPath)
                    .addComponent(quantity))
        );

        add(panel);
        setVisible(true);
    }
}