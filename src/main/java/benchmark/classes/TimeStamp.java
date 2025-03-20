package benchmark.classes;

import benchmark.interfaces.*;

public class TimeStamp {
    public int testsQuantity;

    // Constructor method
    public TimeStamp(int testsQuantity) {
        testsQuantity = this.testsQuantity;
    }

    // Benchmark, iterate N times and print the avg time
    public void benchSorting(int[] values, SortingAlgorithm algorithm, String algorithmName) {
        long startTime = System.nanoTime();
        algorithm.sort(values);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Execution time for " + algorithmName + ": " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");
    }
}