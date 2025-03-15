package benchmark.classes;

public class SortingAlgorithms {
    protected SortingAlgorithms() {
    }
    
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // If the array is null or has only one element, it is already sorted.
        }
        mergeSort(array, 0, array.length - 1);
    }
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Finds the middle of array.

            // Ordens the first part.
            mergeSort(array, left, mid);
            // Ordens the second one.
            mergeSort(array, mid + 1, right);
            // Merge both.
            merge(array, left, mid, right);
        }
    }

    // The method to merge.
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy the elements to temporary arrays.
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge the sorted arrays (Absolute Cinema moment)
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from leftArray, if it have one.
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements from rightArray, if it have one. 
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }   
}