package benchmark.core;

import java.util.List;

/**
 * The TimeStamp class is responsible for performing benchmarking of sorting algorithms.
 * It allows setting the number of iterations for sorting the list of Long values
 * and calculates the total time taken for the execution.
 * 
 * <p>Example usage:</p>
 * <pre>
 *     TimeStamp benchmark = new TimeStamp();
 *     benchmark.setQuantity(5);
 *     Long executionTime = benchmark.benchSorting(values, new BubbleSort());
 *     System.out.println("Execution time: " + executionTime);
 * </pre>
 * 
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
public class TimeStamp {
    private Integer quantity = 1;

    
    public void setQuantity(Integer quantity) {
        if (quantity <= 0 || quantity == null) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
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