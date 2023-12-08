package main.java.day6;

import lombok.Getter;

public class Race {
    @Getter
    private final long lengthOfRace;

    private final long recordDistance;

    private long distanceCoveredInRace;

    public Race(long lengthOfRace, long recordDistance) {
        this.lengthOfRace = lengthOfRace;
        this.recordDistance = recordDistance;
        this.distanceCoveredInRace = 0;
    }

    public boolean hasWon() {
        return recordDistance < distanceCoveredInRace;
    }

    public void calculateDistanceTravelledByBoat(int lengthOfTimeButtonHeld) {
        this.distanceCoveredInRace = (lengthOfRace - lengthOfTimeButtonHeld) * lengthOfTimeButtonHeld;
    }
}
