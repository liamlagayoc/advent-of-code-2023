package test.java;

import main.java.CalibrationLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationLineTest {
    private LinkedHashMap<String, String> wordsAndNumbers = new LinkedHashMap<>();

    @BeforeEach
    public void beforeEach() {
        wordsAndNumbers.put("one", "1");
        wordsAndNumbers.put("two", "2");
        wordsAndNumbers.put("three", "3");
        wordsAndNumbers.put("four", "4");
        wordsAndNumbers.put("five", "5");
        wordsAndNumbers.put("six", "6");
        wordsAndNumbers.put("seven", "7");
        wordsAndNumbers.put("eight", "8");
        wordsAndNumbers.put("nine", "9");
        wordsAndNumbers.put("1", "1");
        wordsAndNumbers.put("2", "2");
        wordsAndNumbers.put("3", "3");
        wordsAndNumbers.put("4", "4");
        wordsAndNumbers.put("5", "5");
        wordsAndNumbers.put("6", "6");
        wordsAndNumbers.put("7", "7");
        wordsAndNumbers.put("8", "8");
        wordsAndNumbers.put("9", "9");
    }

    @Test
    public void it_returns_a_calibration_value_of_zero_when_empty_line() {
        CalibrationLine line = new CalibrationLine("", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 0);
    }

    @Test
    public void it_returns_a_calibration_value_of_zero_when_text_contains_no_digits() {
        CalibrationLine line = new CalibrationLine("foo", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 0);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_one_digit_exists() {
        CalibrationLine line = new CalibrationLine("1foo", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 11);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_two_digits_exist() {
        CalibrationLine line = new CalibrationLine("1foo2", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 12);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_three_digits_exist() {
        CalibrationLine line = new CalibrationLine("1foo3bar4", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 14);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_four_digits_exist() {
        CalibrationLine line = new CalibrationLine("7foo3bar49", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 79);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_five_digits_exist() {
        CalibrationLine line = new CalibrationLine("7foo3bar49wfwekrwenrjnw1efrterte", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 71);
    }

    @Test
    public void it_calculates_the_correct_calibration_value_when_words_then_numbers_exist() {
        CalibrationLine line = new CalibrationLine("abc7foo3bar49", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 79);
    }

    @Test
    public void it_calculates_the_correct_value_with_words() {
        CalibrationLine line = new CalibrationLine("two1nine", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 29);
    }

    @Test
    public void it_calculates_the_correct_value_with_mix_of_numbers_and_words() {
        CalibrationLine line = new CalibrationLine("abcone2threexyz", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 13);
    }

    @Test
    public void it_calculates_the_correct_value_with_one_long_word_and_numbers() {
        CalibrationLine line = new CalibrationLine("xtwone3four", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 24);
    }

    @Test
    public void it_calculates_correct_value_numbers_at_start_and_end_including_words() {
        CalibrationLine line = new CalibrationLine("4nineeightseven2", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 42);
    }

    @Test
    public void it_calculates_correct_value_with_word_at_start_and_digit_at_end() {
        CalibrationLine line = new CalibrationLine("zoneight234", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 14);
    }

    @Test
    public void it_calculates_correct_value_with_digit_at_start_and_word_at_end() {
        CalibrationLine line = new CalibrationLine("7pqrstsixteen", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 76);
    }

    @Test
    public void it_calculates_the_correct_value_with_only_words() {
        CalibrationLine line = new CalibrationLine("eightwothree", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 83);
    }

    @Test
    public void it_calculates_the_correct_value_with_matching_words () {
        CalibrationLine line = new CalibrationLine("fourseven5seveneightsvtkcjdrfour", wordsAndNumbers);
        assertEquals(line.calculateCalibrationValue(), 44);
    }


}
