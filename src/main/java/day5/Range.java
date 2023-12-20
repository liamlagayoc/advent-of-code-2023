package main.java.day5;

import lombok.Getter;

public class Range {
    private long startValue;

    private long endValue;

    @Getter
    private long rangeLength;

    private long destinationStart;

    public Range(long startValue, long endValue, long rangeLength, long destinationStart) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.rangeLength = rangeLength;
        this.destinationStart = destinationStart;
    }

    public long calculateFinalDestinationValue(long value) {
        return destinationStart + (value - startValue);
    }

    public boolean inRange(long value) {
        return value >= startValue && value <= endValue;
    }

}
