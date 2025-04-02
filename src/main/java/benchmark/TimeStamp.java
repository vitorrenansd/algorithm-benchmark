package benchmark;

import java.util.List;

public class TimeStamp {
    public Integer quantity;

    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    // Benchmark, iterate N times and print the avg time
    // TRANSFORMAR DPS EM UM METODO DE RETURN, PLACEHOLDER
    public void benchSorting(List<Long> values, SortingAlgorithm algorithm) {

        Long startTime = System.nanoTime();
        for (int i = 0; i < this.getQuantity(); i++) {
            algorithm.sort(values);
        }
        Long endTime = System.nanoTime();

        float executionTime = (endTime - startTime);
        // float avgExecutionTime = executionTime / this.getQuantity();

        System.out.println(this.getQuantity() + "x: TOTAL " + executionTime + "ns");
    }
}