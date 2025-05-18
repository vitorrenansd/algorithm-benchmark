// PLACEHOLDER

package benchmark.sysinterface.visual;

import javax.swing.*;

import java.awt.*;

public class BenchmarkPanel extends JPanel {
    public BenchmarkPanel() {
        setPreferredSize(new Dimension(600, 300));
        setBackground(Color.GRAY);
        
        ResultChart graph = new ResultChart();
        graph.createBarGraph(10, 20, 40);
    }
}