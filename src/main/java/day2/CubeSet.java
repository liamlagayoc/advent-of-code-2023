package main.java.day2;

import lombok.Getter;

public class CubeSet {
    @Getter
    private int numberOfBlueCubes;

    @Getter
    private int numberOfGreenCubes;

    @Getter
    private int numberOfRedCubes;

    @Getter
    private boolean validScenario;


    private static final int MAX_NUMBER_OF_BLUE_CUBES = 14;
    private static final int MAX_NUMBER_OF_GREEN_CUBES = 13;
    private static final int MAX_NUMBER_OF_RED_CUBES = 12;

    public void setCubeData(String colour, int numberOfCubes) {
        // Doesn't need default as we validate configuration
        switch(colour) {
            case "blue":
                numberOfBlueCubes = numberOfCubes;
                validScenario = (numberOfCubes <= MAX_NUMBER_OF_BLUE_CUBES);
                break;
            case "green":
                numberOfGreenCubes = numberOfCubes;
                validScenario = (numberOfCubes <= MAX_NUMBER_OF_GREEN_CUBES);
                break;
            case "red":
                numberOfRedCubes = numberOfCubes;
                validScenario = (numberOfCubes <= MAX_NUMBER_OF_RED_CUBES);
                break;
        }
    }
}
