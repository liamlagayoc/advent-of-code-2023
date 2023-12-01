package test.java;

import main.java.CalibrationLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationLineTest {
    @Test
    public void it_returns_a_calibration_value_of_zero_when_empty_line() {
        CalibrationLine line = new CalibrationLine("");
        assertEquals(line.calculateCalibrationValue(), 0);
    }

    @Test
    public void it_returns_a_calibration_value_of_zero_when_text_contains_no_digits() {
        CalibrationLine line = new CalibrationLine("foo");
        assertEquals(line.calculateCalibrationValue(), 0);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_one_digit_exists() {
        CalibrationLine line = new CalibrationLine("1foo");
        assertEquals(line.calculateCalibrationValue(), 11);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_two_digits_exist() {
        CalibrationLine line = new CalibrationLine("1foo2");
        assertEquals(line.calculateCalibrationValue(), 12);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_three_digits_exist() {
        CalibrationLine line = new CalibrationLine("1foo3bar4");
        assertEquals(line.calculateCalibrationValue(), 14);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_four_digits_exist() {
        CalibrationLine line = new CalibrationLine("7foo3bar49");
        assertEquals(line.calculateCalibrationValue(), 79);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_five_digits_exist() {
        CalibrationLine line = new CalibrationLine("7foo3bar49wfwekrwenrjnw1efrterte");
        assertEquals(line.calculateCalibrationValue(), 71);
    }
}
