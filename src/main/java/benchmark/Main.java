package benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 1500;
        List<Long> testList = new ArrayList<>(size);
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            long randomNum = random.nextLong();
            randomNum = randomNum - (random.nextBoolean() ? 0 : 5000);
            testList.add(randomNum);
        }
    }
}