package benchmark.classes;

public class TimeStamp {
    public int testsQuantity;

    // Constructor method
    public TimeStamp(int testsQuantity) {
        testsQuantity = this.testsQuantity;
    }

    // Benchmark, iterate N times and print the avg time
    public void benchSorting(int[] values) {

        for (int i = 0; i < testsQuantity; i++) {

        }
        // Start measuring
        long startTime = System.nanoTime();



        // Stop measuring
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);
        System.out.println("Execution time for: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");
    }

}