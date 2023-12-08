package test.java.day6;

import main.java.day6.PartTwoRaceProcessor;
import main.java.day6.RaceProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartTwoRaceProcessorTest {
    @Test
    public void it_returns_correct_sum_value_of_valid_scenarios_if_file_found() {
        RaceProcessor processor = new PartTwoRaceProcessor("src/test/resources/input_day6_test_data.txt");
        assertEquals(processor.maximumNumberOfWinningScenarios(), 71503);
    }
}
