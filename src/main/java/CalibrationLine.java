package main.java;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class CalibrationLine {
    private final String lineOfText;
    private final LinkedHashMap<String, String> wordsToNumbers;
    private HashMap<Integer, String> numbersFound;

    public CalibrationLine(String lineOfText, LinkedHashMap<String, String> wordsToNumbers) {
        this.lineOfText = lineOfText;
        this.wordsToNumbers = wordsToNumbers;
        this.numbersFound = new HashMap<>();
        buildDigitList();
    }

    public int calculateCalibrationValue() {
        if (StringUtils.isBlank(lineOfText) || getNumberOfDigits() == 0) {
            return 0;
        }

        if (!numbersFound.isEmpty()) {
            Integer[] orderedNumbers = numbersFound.keySet().toArray(new Integer[0]);
            Arrays.sort(orderedNumbers);
            return Integer
                    .parseInt(getValueFromList(orderedNumbers[0])
                    .concat(getValueFromList(orderedNumbers[orderedNumbers.length - 1])));
        }
        return 0;
    }

    private String getValueFromList(Integer value) {
        return wordsToNumbers.get(numbersFound.get(value));
    }

    private void buildDigitList() {
        for(Map.Entry<String, String> entry : wordsToNumbers.entrySet()) {
            for (int index = lineOfText.indexOf(entry.getKey());
                 index >= 0;
                 index = lineOfText.indexOf(entry.getKey(), index + 1))
            {
                numbersFound.put(index, entry.getKey());
            }
        }
    }

    private int getNumberOfDigits() {
        return numbersFound.size();
    }
}
