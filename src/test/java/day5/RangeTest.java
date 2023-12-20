package test.java.day5;

import main.java.day5.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    @Test
    void it_is_in_range() {
        Range range = new Range(1, 3, 2, 2);
        assertTrue(range.inRange(1));
    }

    @Test
    void it_is_out_of_range() {
        Range range = new Range(1, 3, 2, 2);
        assertFalse(range.inRange(4));
    }

    @Test
    void it_calculates_final_destination_value_when_in_range() {
        Range range = new Range(98, 99, 2, 50);
        assertEquals(range.calculateFinalDestinationValue(98), 50);
    }

    @Test
    void it_calculates_final_destination_value_when_at_end_of_range() {
        Range range = new Range(98, 99, 2, 50);
        assertEquals(range.calculateFinalDestinationValue(99), 51);
    }

    @Test
    void it_calculates_final_destination_value_when_at_end_of_range_two() {
        Range range = new Range(98, 100, 3, 50);
        assertEquals(range.calculateFinalDestinationValue(100), 52);
    }

    @Test
    void it_calculates_final_destination_value_correctly_with_large_range_length() {
        Range range = new Range(50, 97, 48, 52);
        assertEquals(range.calculateFinalDestinationValue(50), 52);
        assertEquals(range.calculateFinalDestinationValue(51), 53);
        assertEquals(range.calculateFinalDestinationValue(52), 54);
        assertEquals(range.calculateFinalDestinationValue(53), 55);
    }
}
