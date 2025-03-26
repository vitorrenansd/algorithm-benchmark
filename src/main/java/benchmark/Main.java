package benchmark;

import benchmark.util.*;

public class Main {
    public static void main(String[] args) {
        ImageExtractor ie = new ImageExtractor();

        // Now, returns a List<Long>
        System.out.println(ie.pullAllLastModified("images"));
        System.out.println(ie.pullAllSize("images"));
    }
}