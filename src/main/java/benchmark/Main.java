package benchmark;

import benchmark.util.*;

public class Main {
    public static void main(String[] args) {
        ImageExtractor ie = new ImageExtractor();

        ie.getFileSizes("images");
    }
}