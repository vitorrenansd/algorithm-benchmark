package benchmark.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import benchmark.algorithms.BubbleSort;
import benchmark.algorithms.HeapSort;
import benchmark.algorithms.MergeSort;

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
    public Long benchmark(List<Long> values, SortingAlgorithm algorithm) {

        // JVM warm-up
        for (int i = 0; i < 10; i++) {
            algorithm.sort(values);
        }

        // Start benchmark
        Long startTime = System.nanoTime();
        for (int i = 0; i < this.getQuantity(); i++) {
            algorithm.sort(values);
        }
        Long endTime = System.nanoTime();

        Long executionTime = (endTime - startTime);
        return executionTime;
    }

    public Map<String, Long> benchmarkAll(List<Long> values) {
        Map<String, Long> results = new LinkedHashMap<>();

        results.put("BubbleSort", benchmark(new ArrayList<>(values), new BubbleSort()));
        results.put("HeapSort", benchmark(new ArrayList<>(values), new HeapSort()));
        results.put("MergeSort", benchmark(new ArrayList<>(values), new MergeSort()));

        return results;
    }
}