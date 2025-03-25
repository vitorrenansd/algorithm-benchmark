package benchmark;

import benchmark.classes.*;

public class Main {
    public static void main(String[] args) {
        ImageExtractor ie = new ImageExtractor();

        ie.getFileSizes("images");
    }
}