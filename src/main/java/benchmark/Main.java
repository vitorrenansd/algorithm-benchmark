package benchmark;

import benchmark.algorithms.*;
import benchmark.core.*;
import benchmark.sysinterface.visual.Window;

public class Main {
    public static void main(String[] args) {
        new Window();

        // Application instances
        ImageExtractor ie = new ImageExtractor();
        TimeStamp ts = new TimeStamp();

        // Algorithm instances
        BubbleSort bs = new BubbleSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();

        // Necessary settings
        ie.setImagesPath("C:\\Users\\x\\Documents\\GitHubProjects\\algorithm-benchmark\\images");
        ts.setQuantity(20);

        // Tests
        Long bsAvg = ts.benchSorting(ie.pullAllLastModified(), bs) / ts.getQuantity();
        System.out.println("bs:" + bsAvg + "ns");

        Long hsAvg = ts.benchSorting(ie.pullAllLastModified(), hs) / ts.getQuantity();
        System.out.println("hs:" + hsAvg + "ns");

        Long msAvg = ts.benchSorting(ie.pullAllLastModified(), ms) / ts.getQuantity();
        System.out.println("ms:" + msAvg + "ns");
    }
}