package benchmark.core;

import java.util.List;

/**
 * The SortingAlgorithm interface defines a contract for sorting algorithms.
 * Any class implementing this interface must provide an implementation of the
 * sort() method to sort a list of Long values.
 *
 * <p>Example usage:</p>
 * <pre>
 *     SortingAlgorithm bubbleSort = new BubbleSort();
 *     List<Long> sortedValues = bubbleSort.sort(values);
 * </pre>
 *
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
public interface SortingAlgorithm {
    List<Long> sort(List<Long> values); // Default method for all algorithms
}