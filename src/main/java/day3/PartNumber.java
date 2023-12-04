package main.java.day3;

import lombok.Getter;

public class PartNumber {
    @Getter
    private final String partNumber;

    @Getter
    private final int numberIndex;

    public PartNumber(String partNumber, int numberIndex) {
        this.partNumber = partNumber;
        this.numberIndex = numberIndex;
    }
}
