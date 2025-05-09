package benchmark.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortTest {

    @Test
    void validSort() {
        BubbleSort bubbleSort = new BubbleSort();
        List<Long> values = new ArrayList<>(List.of(8L, 2L, 1L, 4L, 0L));
        List<Long> expected = new ArrayList<>(List.of(0L, 1L, 2L, 4L, 8L));

        List<Long> sortingResult = bubbleSort.sort(values);

        assertEquals(expected, sortingResult, "List should be sorted in ascending order");
    }

    @Test
    void validSortNegative() {
        BubbleSort bubbleSort = new BubbleSort();
        List<Long> values = new ArrayList<>(List.of(-2L, -5L, 0L, 3L));
        List<Long> expected = new ArrayList<>(List.of(-5L, -2L, 0L, 3L));

        List<Long> sortingResult = bubbleSort.sort(values);

        assertEquals(expected, sortingResult, "List with negative values should be sorted correctly");
    }

    @Test
    void emptyList() {
        BubbleSort bubbleSort = new BubbleSort();
        List<Long> values = new ArrayList<>();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bubbleSort.sort(values);
        });

        assertEquals("Original list can't be empty", exception.getMessage());
    }
}
