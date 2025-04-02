package benchmark.algorithms;

import java.util.Arrays;

import benchmark.SortingAlgorithm;

public class HeapSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {
        // Create a copy of the original array to avoid modifying it
        int[] arr = Arrays.copyOf(array, array.length);
        int n = arr.length;

        // Build a max-heap by rearranging the array
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root (largest element) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return arr;
    }

    // Helper method to maintain the max-heap property
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as the root
        int l = 2 * i + 1; // Left child index: 2*i + 1
        int r = 2 * i + 2; // Right child index: 2*i + 2

        // If the left child is larger than the root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If the right child is larger than the current largest
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not the root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}