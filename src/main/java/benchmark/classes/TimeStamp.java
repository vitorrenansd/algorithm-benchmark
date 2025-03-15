package benchmark.classes;

public class TimeStamp extends SortingAlgorithms {


    public TimeStamp() {
    }

    public void benchBubbleSorting(int[] values) {
        SortingAlgorithms so = new SortingAlgorithms();

        // Start measuring
        long startTime = System.nanoTime();

        so.bubbleSort(values);

        // Stop measuring
        long endTime = System.nanoTime();

        // Calculate the execution time
        long executionTime = (endTime - startTime);

        System.out.println("Execution time for BubbleSort: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");
    }

    public void benchMergeSorting(int[] values) {

    }

    public void benchQuickSorting(int[] values) {

    }
}
