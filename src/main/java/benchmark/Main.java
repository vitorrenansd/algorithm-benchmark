package benchmark;

import benchmark.algorithms.*;
import benchmark.application.ImageExtractor;
import benchmark.application.TimeStamp;

public class Main {
    public static void main(String[] args) {
        // Application instances
        ImageExtractor ie = new ImageExtractor();
        TimeStamp ts = new TimeStamp();

        // Algorithm instances
        BubbleSort bs = new BubbleSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();

        // Necessary settings
        ie.setImagesPath("C:\\Users\\x\\Documents\\GitHubProjects\\algorithm-benchmark\\images");
        ts.setQuantity(200);

        // Tests
        Long bsAvg = ts.benchSorting(ie.pullAllLastModified(), bs) / ts.getQuantity();
        System.out.println("bs:" + bsAvg + "ns");

        Long hsAvg = ts.benchSorting(ie.pullAllLastModified(), hs) / ts.getQuantity();
        System.out.println("hs:" + hsAvg + "ns");

        Long msAvg = ts.benchSorting(ie.pullAllLastModified(), ms) / ts.getQuantity();
        System.out.println("ms:" + msAvg + "ns");
    }
}