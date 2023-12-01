package test.java;

import main.java.CalibrationCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationCalculatorTest {
    @Test
    public void it_returns_zero_if_file_not_found() {
        CalibrationCalculator calculator = new CalibrationCalculator("src/test/resources/input_day2_test.txt");
        assertEquals(calculator.calculateCalibrationValues(), 0);
    }

    @Test
    public void it_returns_zero_if_file_contains_no_content() {
        CalibrationCalculator calculator = new CalibrationCalculator("src/test/resources/input_day1_empty_file.txt");
        assertEquals(calculator.calculateCalibrationValues(), 0);
    }

    @Test
    public void it_calculates_correct_calibration_value_when_file_contains_content() {
        CalibrationCalculator calculator = new CalibrationCalculator("src/test/resources/input_day1_test.txt");
        assertEquals(calculator.calculateCalibrationValues(), 142);
    }
}
