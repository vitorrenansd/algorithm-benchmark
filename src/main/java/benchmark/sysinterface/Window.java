package benchmark.sysinterface;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        // Initial window config
        setTitle("Algorithm Benchmark");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Resolution 800x600
        setLocationRelativeTo(null); // Center
        setResizable(false);

        // Creating components
        String[] algorithms = {"File datetime", "File size (bytes)", "The two's"};
        JLabel chooseAlgorithmLabel = new JLabel("Choose datatype:");
        JComboBox<String> chooseAlgorithm = new JComboBox<>(algorithms);

        JLabel folderPathLabel = new JLabel("Images path:");
        JTextField folderPath = new JTextField();

        JLabel quantityLabel = new JLabel("Tests quantity:");
        JTextField quantity = new JTextField();


        setVisible(true);
    }
}