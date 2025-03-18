package benchmark.classes;

import benchmark.algorithms.*;;

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
        
        MergeSort ms = new MergeSort();

        long startTime = System.nanoTime();

        ms.mergeSort(values);

        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Execution time for MergeSort: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");

    }

    public void benchHeapSorting(int[] values) {
        
        HeapSort hp = new HeapSort();

        long startTime = System.nanoTime();

        hp.heapSort(values);

        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Execution time for HeapSort: " + executionTime + "ns. " + (executionTime / 1000000) + "ms.");

    }


}