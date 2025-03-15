package benchmark;

import benchmark.classes.SortingAlgorithms;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithms so = new SortingAlgorithms();

        int[] values = {8, 9, 2, 1, 8, 17, 0, 5, 11};

        so.bubbleSort(values);
    }
}