package benchmark.algorithms;

import java.util.List;

import benchmark.application.SortingAlgorithm;

import java.util.ArrayList;

public class HeapSort implements SortingAlgorithm {
    @Override
    public List<Long> sort(List<Long> array) {
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