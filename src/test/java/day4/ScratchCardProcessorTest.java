package test.java.day4;

import main.java.day2.GameProcessor;
import main.java.day4.ScratchCardProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScratchCardProcessorTest {
    @Test
    public void it_returns_zero_if_file_not_found() {
        ScratchCardProcessor processor = new ScratchCardProcessor("src/test/resources/input_day4_test.txt");
        assertEquals(processor.calculateTotalScratchCardPoints(), 0);
    }

    @Test
    public void it_returns_correct_sum_value_of_valid_scenarios_if_file_found() {
        ScratchCardProcessor processor = new ScratchCardProcessor("src/test/resources/input_day4_test_data.txt");
        assertEquals(processor.calculateTotalScratchCardPoints(), 13);
    }
}
