package benchmark.algorithms;

import java.util.List;
import java.util.ArrayList;
import benchmark.core.SortingAlgorithm;

/**
 * The HeapSort class implements the SortingAlgorithm interface 
 * and provides an implementation of the heap sort algorithm for sorting a list of Long values.
 * 
 * Heap Sort is a comparison-based sorting algorithm that works by building a max-heap from the input data.
 * The largest element is then extracted from the heap and placed at the end of the sorted portion of the array.
 * This process is repeated for the remaining elements, resulting in a sorted array.
 * 
 * <p>Example usage:</p>
 * <pre>
 *     SortingAlgorithm heapSort = new HeapSort();
 *     List<Long> sortedValues = heapSort.sort(values);
 * </pre>
 * 
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
public class HeapSort implements SortingAlgorithm {
    @Override
    public List<Long> sort(List<Long> array) {
        if (array.size() == 0) {
            throw new IllegalArgumentException("Original list can't be empty");
        }
        // Create a copy of the original array
        List<Long> arr = new ArrayList<>(array);
        int n = arr.size();

        // Build a max-heap by rearranging the array
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            long temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return arr;
    }

    // Helper method to maintain the max-heap property
    private void heapify(List<Long> arr, int n, int i) {
        int largest = i;    // Initialize largest as the root
        int l = 2 * i + 1;  // Left child index: 2*i + 1
        int r = 2 * i + 2;  // Right child index: 2*i + 2

        // If the left child is larger than the root
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        // If the right child is larger than the current largest
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;

        // If largest is not the root, swap and continue heapifying
        if (largest != i) {
            long swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}