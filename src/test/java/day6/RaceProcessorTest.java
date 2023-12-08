package test.java.day6;

import main.java.day6.RaceProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceProcessorTest {
    @Test
    public void it_returns_zero_if_file_not_found() {
        RaceProcessor processor = new RaceProcessor("src/test/resources/input_day6_test.txt");
        assertEquals(processor.maximumNumberOfWinningScenarios(), 0);
    }

    @Test
    public void it_returns_correct_sum_value_of_valid_scenarios_if_file_found() {
        RaceProcessor processor = new RaceProcessor("src/test/resources/input_day6_test_data.txt");
        assertEquals(processor.maximumNumberOfWinningScenarios(), 288);
    }

    @Test
    public void it_returns_correct_sum_value_of_valid_scenarios_if_single_race() {
        RaceProcessor processor = new RaceProcessor("src/test/resources/input_day6_single_race.txt");
        assertEquals(processor.maximumNumberOfWinningScenarios(), 4);
    }
}
