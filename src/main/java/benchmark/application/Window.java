package benchmark.application;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame {
    
    public Window() {
        String[] algorithms = {"File datetime", "File size (bytes)", "The two's"};
        JLabel chooseAlgorithmLabel = new JLabel("Choose datatype:");
        JComboBox<String> chooseAlgorithm = new JComboBox<>(algorithms);

        chooseAlgorithmLabel.setBounds(10, 10, 150, 15);
        chooseAlgorithm.setSelectedIndex(0);
        chooseAlgorithm.setMaximumRowCount(3);
        chooseAlgorithm.setBounds(10, 30, 130, 25);
        add(chooseAlgorithmLabel);
        add(chooseAlgorithm);

        JLabel folderPathLabel = new JLabel("Images path:");
        JTextField folderPath = new JTextField();

        folderPathLabel.setBounds(180, 10, 100, 15);
        folderPath.setBounds(180, 30, 470, 25);
        add(folderPathLabel);
        add(folderPath);

        JLabel quantityLabel = new JLabel("Tests quantity:");
        JTextField quantity = new JTextField();

        quantityLabel.setBounds(680, 10, 100, 15);
        quantity.setBounds(680, 30, 90, 25);
        add(quantityLabel);
        add(quantity);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600); // Resolution 800x600
        setLocationRelativeTo(null); // Center
        setResizable(false);
        setVisible(true);
    }
}