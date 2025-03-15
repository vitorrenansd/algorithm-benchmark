package benchmark.classes;

import java.util.Arrays;

public class TimeStamp extends SortingAlgorithms {


public class TimeStamp {
    public TimeStamp() {
    }

    public void benchBubbleSorting(int[] values) {
        BubbleSort bs = new BubbleSort();

        // Start measuring
        long startTime = System.nanoTime();

        bs.bubbleSort(values);

        // Stop measuring
        long endTime = System.nanoTime();

        // Calculate the execution time
        long executionTime = (endTime - startTime);

        System.out.println("Execution time for BubbleSort: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");
    }

    public void benchMergeSorting(int[] values) {
        SortingAlgorithms so  = new SortingAlgorithms();

        long startTime = System.nanoTime();

        so.mergeSort(values);

        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Sorted array: " + Arrays.toString(values));
        System.out.println("Execution time for MergeSort: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");

    }

    public void benchQuickSorting(int[] values) {

    }
}
