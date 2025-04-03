package benchmark.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

    @Test
    void validSort() {
        MergeSort mergeSort = new MergeSort();
        List<Long> values = new ArrayList<>(List.of(8L, 2L, 1L, 4L, 0L));
        List<Long> expected = new ArrayList<>(List.of(0L, 1L, 2L, 4L, 8L));

        List<Long> sortingResult = mergeSort.sort(values);

        assertEquals(expected, sortingResult, "List should be sorted in ascending order");
    }
    
    @Test
    void emptyList() {
        MergeSort mergeSort = new MergeSort();
        List<Long> values = new ArrayList<>();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mergeSort.sort(values);
        });

        assertEquals("Original list can't be empty", exception.getMessage());
    }
}
