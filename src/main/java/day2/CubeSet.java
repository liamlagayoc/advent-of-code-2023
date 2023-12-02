package main.java.day2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CubeSet {
    @Getter
    private final HashMap<String, Integer> cubes;

    private static final int MAX_NUMBER_OF_BLUE_CUBES = 14;
    private static final int MAX_NUMBER_OF_GREEN_CUBES = 13;
    private static final int MAX_NUMBER_OF_RED_CUBES = 12;

    public CubeSet() {
        this.cubes = new HashMap<>();
    }

    public void addCubes(String colour, int numberOfCubes) throws InvalidConfigurationException {
        if (isValidConfiguration(colour, numberOfCubes)) {
            cubes.put(colour, numberOfCubes);
        } else {
            throw new InvalidConfigurationException("Invalid configuration provided");
        }
    }

    private boolean isValidConfiguration(String colour, int numberOfCubes) {
        if (colour.equals("blue") && numberOfCubes <= MAX_NUMBER_OF_BLUE_CUBES) {
            return true;
        } else if (colour.equals("green") && numberOfCubes <= MAX_NUMBER_OF_GREEN_CUBES) {
            return true;
        } else if (colour.equals("red") && numberOfCubes <= MAX_NUMBER_OF_RED_CUBES) {
            return true;
        }
        return false;
    }
}
