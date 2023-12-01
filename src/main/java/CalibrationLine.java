package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CalibrationLine {
    private final String lineOfText;
    private final List<String> digits;

    public CalibrationLine(String lineOfText) {
        this.lineOfText = lineOfText;
        this.digits = new ArrayList<>();
        buildDigitList();
    }

    public int calculateCalibrationValue() {
        if (StringUtils.isBlank(lineOfText) || getNumberOfDigits() == 0) {
            return 0;
        }
        return Integer.parseInt(
            digits.get(0).concat(
            digits.get(digits.size() - 1)
            )
        );
    }

    private void buildDigitList() {
        char[] characters = lineOfText.toCharArray();
        for(char c : characters) {
            if(Character.isDigit(c)) {
                digits.add(Character.toString(c));
            }
        }
    }

    private int getNumberOfDigits() {
        return digits.size();
    }
}
