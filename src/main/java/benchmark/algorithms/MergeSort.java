package benchmark.algorithms;

import java.util.List;
import java.util.ArrayList;
import benchmark.application.SortingAlgorithm;

/**
 * The MergeSort class implements the SortingAlgorithm interface 
 * and provides an implementation of the merge sort algorithm for sorting a list of Long values.
 * 
 * Merge Sort is a divide-and-conquer algorithm that recursively divides the array into two halves, 
 * sorts each half, and then merges the sorted halves to produce the final sorted array.
 * 
 * <p>Example usage:</p>
 * <pre>
 *     SortingAlgorithm mergeSort = new MergeSort();
 *     List<Long> sortedValues = mergeSort.sort(values);
 * </pre>
 * 
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
public class MergeSort implements SortingAlgorithm {

    @Override
    public List<Long> sort(List<Long> array) {
        if (array.size() == 0) {
            throw new IllegalArgumentException("Original list can't be empty");
        }
        // Create a copy of the original array
        List<Long> arr = new ArrayList<>(array);
        
        mergeSort(arr, 0, arr.size() - 1);
        return arr;
    }

    private void mergeSort(List<Long> array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Finds the middle of the array.

            // Sort the first part
            mergeSort(array, left, mid);
            // Sort the second part
            mergeSort(array, mid + 1, right);
            // Merge both parts
            merge(array, left, mid, right);
        }
    }

    // The method to merge.
    private void merge(List<Long> array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Long> leftArray = new ArrayList<>(n1);
        List<Long> rightArray = new ArrayList<>(n2);

        // Copy the elements to temporary lists.
        for (int i = 0; i < n1; i++) {
            leftArray.add(array.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(array.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        // Merge the sorted arrays
        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        // Copy the remaining elements from leftArray, if any.
        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;
        }

        // Copy the remaining elements from rightArray, if any.
        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}
