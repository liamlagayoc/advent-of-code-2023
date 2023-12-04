package main.java.day3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EngineLine {
    private final String engineLine;

    @Getter
    private final List<PartNumber> partNumberList;

    @Getter
    private final List<Integer> specialCharacterIndexes = new ArrayList<>();

    public EngineLine(String engineLine) {
        this.engineLine = engineLine;
        this.partNumberList = new ArrayList<>();
    }

    public void buildEngineLineInfo() {
        String[] numbers = Stream.of(engineLine.split("\\D+")).filter(w -> !w.isEmpty()).toArray(String[]::new);
        for(String number : numbers) {
            OptionalInt latestIndex = partNumberList.stream().mapToInt(PartNumber::getNumberIndex).max();
            int index = latestIndex.isPresent() ? latestIndex.getAsInt() : 0;

            PartNumber partNumber = new PartNumber(number, engineLine.indexOf(number, index));
            partNumberList.add(partNumber);
        }

        Pattern pattern = Pattern.compile("[^0-9.]");
        Matcher matcher = pattern.matcher(engineLine);

        while(matcher.find()) {
            specialCharacterIndexes.add(matcher.start());
        }
    }

    public int getValueContainingAdjacentSymbol(List<Integer> specialCharacterIndexes) {
        int rowValue = 0;
        if(partNumberList.isEmpty()) {
            return rowValue;
        }

        if (!specialCharacterIndexes.isEmpty()) {
            for(PartNumber partNumber : partNumberList) {
                int maxIndexRangeToCheck = partNumber.getNumberIndex() + partNumber.getPartNumber().length();
                int minIndexRangeToCheck = partNumber.getNumberIndex() == 0 ? 0 : partNumber.getNumberIndex() - 1;

                boolean specialCharacterFound = specialCharacterIndexes
                        .stream().anyMatch(a -> ((a >= minIndexRangeToCheck) && (a <= maxIndexRangeToCheck)));
                if(specialCharacterFound) {
                    rowValue += Integer.parseInt(partNumber.getPartNumber());
                }
            }
        }
        return rowValue;
    }
}
