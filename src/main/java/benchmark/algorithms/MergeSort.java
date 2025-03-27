package benchmark.algorithms;

import java.util.List;
import java.util.ArrayList;
import benchmark.util.SortingAlgorithm;
public class MergeSort implements SortingAlgorithm {

    @Override
    public List<Long> sort(List<Long> array) {
        // If the array is null or has only one element, it is already sorted.
        if (array == null || array.size() <= 1) {
            return array == null ? null : new ArrayList<>(array); // Make a copy of the list to avoid modification
        }

        // Create a copy of the original array to avoid modifying the input
        List<Long> arr = new ArrayList<>(array);
        
        mergeSort(arr, 0, arr.size() - 1);
        return arr; // Return the sorted array
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
