package benchmark.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeStampTest {

    @Test
    void setQuantityValid() {
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setQuantity(5);

        Integer value = timeStamp.getQuantity();
        Integer expected = 5;

        assertEquals(expected, value, "setQuantity() need to correctly modify TimeStamp.quantity");
    }

    @Test
    void setQuantityNull() {
        TimeStamp timeStamp = new TimeStamp();

        Exception exception = assertThrows(NullPointerException.class, () -> {
            timeStamp.setQuantity(null);
        });

        assertEquals("Cannot invoke \"java.lang.Integer.intValue()\" because \"quantity\" is null", exception.getMessage());
    }

    @Test
    void setQuantityZero() {
        TimeStamp timeStamp = new TimeStamp();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            timeStamp.setQuantity(0);
        });

        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void setQuantityBelowZero() {
        TimeStamp timeStamp = new TimeStamp();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            timeStamp.setQuantity(-2);
        });

        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }
}