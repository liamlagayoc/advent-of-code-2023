package main.java.day2;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameProcessor {
    private final String fileName;

    @Getter
    private List<Game> possibleGameScenarios;

    @Getter
    private List<Game> impossibleGameScenarios;

    private List<Game> gameScenarios;

    public GameProcessor(String fileName) {
        this.fileName = fileName;
        this.possibleGameScenarios = new ArrayList<>();
        this.impossibleGameScenarios = new ArrayList<>();
        this.gameScenarios = new ArrayList<>();
        processGames();
    }

    private void processGames() {
        try {
            List<String> games = FileUtils.readFile(fileName);
            for (String gameDetails : games) {
                String[] gameParts = gameDetails.split(": ");
                int gameId = Integer.parseInt(gameParts[0].replace("Game ", ""));
                Game game = new Game(gameId);

                String[] cubeSets = gameParts[1].split("; ");
                for (String cubeSet : cubeSets) {
                    buildCubeSetForGame(game, cubeSet);
                }
                gameScenarios.add(game);
                if(isValidGame(game)) possibleGameScenarios.add(game);
                else impossibleGameScenarios.add(game);
            }
            System.out.println("Finished processing");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    private boolean isValidGame(Game game) {
        return game.getCubeSets().stream().filter(x -> !x.isValidScenario()).count() == 0;
    }

    private void buildCubeSetForGame(Game game, String cubeSet) {
        CubeSet set = new CubeSet();
        String[] cubes = cubeSet.split(", ");
        for(String cube : cubes) {
            int idx = cube.indexOf(" ");
            set.setCubeData(cube.substring(idx + 1), Integer.parseInt(cube.substring(0, idx)));
        }
        game.addCubeSet(set);
    }

    public int calculateSumIdsOfPossibleGames() {
        if(possibleGameScenarios.isEmpty()) return 0;

        return possibleGameScenarios.stream().mapToInt(Game::getGameId).sum();
    }

    public int calculateSumOfMinValuesPower() {
        if(gameScenarios.isEmpty()) return 0;

        return gameScenarios.stream().mapToInt(Game::calculatePowerOfMinValues).sum();
    }
}
