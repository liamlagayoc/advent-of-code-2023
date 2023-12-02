package test.java.day2;

import main.java.day2.GameProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameProcessorTest {
    @Test
    public void it_returns_zero_if_file_not_found() {
        GameProcessor processor = new GameProcessor("src/test/resources/input_day2_test.txt");
        assertEquals(processor.calculateSumIdsOfPossibleGames(), 0);
    }

    @Test
    public void it_returns_correct_sum_value_of_valid_scenarios_if_file_found() {
        GameProcessor processor = new GameProcessor("src/test/resources/input_day2_test_data.txt");
        assertEquals(processor.calculateSumIdsOfPossibleGames(), 8);
    }

    @Test
    public void it_puts_the_correct_games_in_the_correct_lists() {
        GameProcessor processor = new GameProcessor("src/test/resources/input_day2_test_data.txt");
        assertEquals(processor.getPossibleGameScenarios().size(), 3);
        assertEquals(processor.getImpossibleGameScenarios().size(), 2);
    }
}
