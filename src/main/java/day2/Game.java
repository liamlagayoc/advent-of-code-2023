package main.java.day2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Game {
    @Getter
    private List<List<CubeSet>> cubeSets;

    @Getter
    private int gameId;

    public Game(int gameId) {
        this.gameId = gameId;
        cubeSets = new ArrayList<>();
    }

    public void addCubeSet(List<CubeSet> cubeSet) {
        cubeSets.add(cubeSet);
    }
}
