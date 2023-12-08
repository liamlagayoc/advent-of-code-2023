package main.java.day6;

import lombok.Getter;

public class Race {
    @Getter
    private final int lengthOfRace;

    private final int recordDistance;

    private int distanceCoveredInRace;

    public Race(int lengthOfRace, int recordDistance) {
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
