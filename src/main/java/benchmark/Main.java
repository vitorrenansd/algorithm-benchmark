package benchmark;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Gera 1500 valores entre -10000 e 10000
        int[] values = new int[1500];
        Random rand = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(20001) - 10000; 
        }

    }
}