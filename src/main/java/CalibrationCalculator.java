package main.java;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;

public class CalibrationCalculator {
    private final String filename;
    private final LinkedHashMap<String, String> wordsToNumbers;

    public CalibrationCalculator(String filename) {
        this.filename = filename;
        this.wordsToNumbers = buildWordsAndNumbers();
    }

    public int calculateCalibrationValues() {
        int calibratedValue = 0;
        try {
            List<String> fileLines = FileUtils.readFile(filename);
            for(String fileLine : fileLines) {
                CalibrationLine line = new CalibrationLine(fileLine, wordsToNumbers);
                calibratedValue += line.calculateCalibrationValue();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return calibratedValue;
        }
        return calibratedValue;
    }

    private LinkedHashMap buildWordsAndNumbers() {
        LinkedHashMap<String, String> wordsNumbers = new LinkedHashMap<>();
        wordsNumbers.put("one", "1");
        wordsNumbers.put("two", "2");
        wordsNumbers.put("three", "3");
        wordsNumbers.put("four", "4");
        wordsNumbers.put("five", "5");
        wordsNumbers.put("six", "6");
        wordsNumbers.put("seven", "7");
        wordsNumbers.put("eight", "8");
        wordsNumbers.put("nine", "9");
        wordsNumbers.put("1", "1");
        wordsNumbers.put("2", "2");
        wordsNumbers.put("3", "3");
        wordsNumbers.put("4", "4");
        wordsNumbers.put("5", "5");
        wordsNumbers.put("6", "6");
        wordsNumbers.put("7", "7");
        wordsNumbers.put("8", "8");
        wordsNumbers.put("9", "9");

        return wordsNumbers;
    }
}
