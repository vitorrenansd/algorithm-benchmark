package benchmark.algorithms;

import java.util.Arrays;
import benchmark.interfaces.*;

import java.io.*;
import java.util.*;
//the class that mergesort the array
public class MergeSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array == null ? null : Arrays.copyOf(array, array.length);
        }
        int[] arr = Arrays.copyOf(array, array.length);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
//the method to split the array into two parts and merge them
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
//the method to merge the two parts of the array
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];//create two arrays to store the two parts
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);//copy the data to the two arrays
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
        //merge the two arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
//the method to sort the file implementing java.io
    public void sortFile(String inputFile, String outputFile) throws IOException {
        List<Integer> dataList = new ArrayList<>();
        //read the file and store the data in the list
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(Integer.parseInt(line.trim()));
            }
        }
        //convert the list to array
        int[] array = dataList.stream().mapToInt(i -> i).toArray();
        int[] sortedArray = sort(array);
        //write the sorted array to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int num : sortedArray) {
                writer.write(num + "\n");
            }
        }
    }
}