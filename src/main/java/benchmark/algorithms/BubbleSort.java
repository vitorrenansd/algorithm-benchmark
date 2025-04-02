package benchmark.algorithms;

import java.util.List;

import benchmark.SortingAlgorithm;

import java.util.ArrayList;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public List<Long> sort(List<Long> array) {
        // Create a copy of the original array to avoid modifying the input
        List<Long> arr = new ArrayList<>(array);
        
        // Iterate through the array (n - 1) times
        for (int i = 0; i < arr.size() - 1; i++) {
            // Traverse the array up to the last unsorted position
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                // Swap values if the current one is greater than the next
                if (arr.get(j) > arr.get(j + 1)) {
                    long temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }
}