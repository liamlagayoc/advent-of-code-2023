package test.java.day3;

import main.java.day3.Engine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTest {
    @Test
    public void it_contains_a_list_of_engine_lines() {
        Engine engine = new Engine("src/test/resources/input_day3_test_data.txt");
        assertEquals(engine.getLines().size(), 10);
    }

    @Test
    public void it_returns_zero_lines_when_file_not_found() {
        Engine engine = new Engine("src/test/resources/input_day3_test_data_fail.txt");
        assertEquals(engine.getLines().size(), 0);
    }

    @Test
    void it_calculates_the_correct_values_from_file() {
        Engine engine = new Engine("src/test/resources/input_day3_test_data.txt");
        assertEquals(engine.calculatePartNumbers(), 4361);
    }

    @Test
    void it_calculates_the_correct_values_from_extracted_file() {
        Engine engine = new Engine("src/test/resources/input_day3_extract_test.txt");
        assertEquals(engine.calculatePartNumbers(), 12425);
    }
}
