package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class CalibrationCalculator {
    private final String filename;

    public CalibrationCalculator(String filename) {
        this.filename = filename;
    }

    public int calculateCalibrationValues() {
        int calibratedValue = 0;
        try {
            List<String> fileLines = FileUtils.readFile(filename);
            for(String fileLine : fileLines) {
                CalibrationLine line = new CalibrationLine(fileLine);
                calibratedValue += line.calculateCalibrationValue();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return calibratedValue;
        }
        return calibratedValue;
    }
}
