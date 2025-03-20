package benchmark.classes;

import benchmark.interfaces.*;

public class TimeStamp {
    public int testsQuantity;

    // Constructor method
    public TimeStamp(int testsQuantity) {
        this.testsQuantity = testsQuantity;
    }

    // Benchmark, iterate N times and print the avg time
    public void benchSorting(int[] values, SortingAlgorithm algorithm, String algorithmName) {

        long startTime = System.nanoTime();
        for (int i = 0; i < this.testsQuantity; i++) { algorithm.sort(values); }
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime);
        System.out.println(algorithmName + " iterating " + this.testsQuantity + "x: TOTAL " + (executionTime / 1000000) + "ms" + " | AVG " + (executionTime / this.testsQuantity / 1000000) + "ms.");
    }
}