package benchmark.algorithms;

import java.util.Arrays;

import benchmark.SortingAlgorithm;

public class BubbleSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] array) {
        // Create a copy of the original array to avoid modifying the input
        int[] arr = Arrays.copyOf(array, array.length);

        // Iterate through the array (n - 1) times
        for (int i = 0; i < arr.length - 1; i++) {
            
            // Traverse the array up to the last unsorted position
            for (int j = 0; j < arr.length - 1 - i; j++) {
                
                // Swap values if the current one is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
