package main.java.day2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    @Getter
    private List<CubeSet> cubeSets;

    @Getter
    private int gameId;

    public Game(int gameId) {
        this.gameId = gameId;
        this.cubeSets = new ArrayList<>();
    }

    public void addCubeSet(CubeSet cubeSet) {
        cubeSets.add(cubeSet);
    }

    public int calculatePowerOfMinValues() {
        ArrayList<Integer> minData = calculateMinimumData();
        if (minData.isEmpty()) return 0;

        return minData.stream().mapToInt(x -> x).reduce(   1, Math::multiplyExact);
    }

    public ArrayList<Integer> calculateMinimumData() {
        if(cubeSets.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> minValues = new ArrayList<>();
        Comparator<CubeSet> comparingBlueCubes = Comparator.comparing(CubeSet::getNumberOfBlueCubes);
        Comparator<CubeSet> comparingGreenCubes = Comparator.comparingInt(CubeSet::getNumberOfGreenCubes);
        Comparator<CubeSet> comparingRedCubes = Comparator.comparingInt(CubeSet::getNumberOfRedCubes);

        CubeSet minBlue = cubeSets.stream().filter(a -> a.getNumberOfBlueCubes() > 0).max(comparingBlueCubes).get();
        CubeSet minGreen = cubeSets.stream().filter(a -> a.getNumberOfGreenCubes() > 0).max(comparingGreenCubes).get();
        CubeSet minRed = cubeSets.stream().filter(a -> a.getNumberOfRedCubes() > 0).max(comparingRedCubes).get();

        minValues.add(minBlue.getNumberOfBlueCubes());
        minValues.add(minGreen.getNumberOfGreenCubes());
        minValues.add(minRed.getNumberOfRedCubes());

        return minValues;
    }
}
