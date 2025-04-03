package benchmark.application;

import java.util.List;

public class TimeStamp {
    private Integer quantity;

    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    // Benchmark, iterate N times and print the avg time
    public Long benchSorting(List<Long> values, SortingAlgorithm algorithm) {

        // Start benchmark
        Long startTime = System.nanoTime();
        for (int i = 0; i < this.getQuantity(); i++) {
            algorithm.sort(values);
        }
        // Stop benchmark
        Long endTime = System.nanoTime();

        Long executionTime = (endTime - startTime);
        return executionTime;
    }
}