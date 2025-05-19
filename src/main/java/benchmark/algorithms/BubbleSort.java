package benchmark.algorithms;

import java.util.List;
import java.util.ArrayList;
import benchmark.core.SortingAlgorithm;

/**
 * The BubbleSort class implements the SortingAlgorithm interface 
 * and provides an implementation of the bubble sort algorithm for sorting a list of Long values.
 * 
 * Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly steps through the list,
 * compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated 
 * until the list is sorted.
 * 
 * <p>Example usage:</p>
 * <pre>
 *     SortingAlgorithm bubbleSort = new BubbleSort();
 *     List<Long> sortedValues = bubbleSort.sort(values);
 * </pre>
 * 
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
public class BubbleSort implements SortingAlgorithm {
    @Override
    public List<Long> sort(List<Long> array) {
        if (array.size() == 0) {
            throw new IllegalArgumentException("Original list can't be empty");
        }
        // Create a copy of the original array
        List<Long> arr = new ArrayList<>(array);
        
        // Iterate through the array (n - 1) times
        for (int i = 0; i < arr.size() - 1; i++) {
            boolean swapped = false;
            // Traverse the array up to the last unsorted position
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                // Swap values if the current one is greater than the next
                if (arr.get(j) > arr.get(j + 1)) {
                    long temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
}