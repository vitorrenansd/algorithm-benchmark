package benchmark.util;

import javax.swing.JFrame;

public class ResultChart extends JFrame{

    public ResultChart() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("benchmark-algorithm");
        setSize(800, 600); // 800x600 resolution
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
