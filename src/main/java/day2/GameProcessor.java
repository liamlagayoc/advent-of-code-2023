package main.java.day2;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameProcessor {
    private final String fileName;

    @Getter
    private List<Game> possibleGameScenarios;

    @Getter
    private List<Game> impossibleGameScenarios;

    public GameProcessor(String fileName) {
        this.fileName = fileName;
        this.possibleGameScenarios = new ArrayList<>();
        this.impossibleGameScenarios = new ArrayList<>();
        processGames();
    }

    private void processGames() {
        try {
            List<String> games = FileUtils.readFile(fileName);
            for (String gameDetails : games) {
                String[] gameParts = gameDetails.split(": ");
                int gameId = Integer.parseInt(gameParts[0].replace("Game ", ""));
                Game game = new Game(gameId);

                try {
                    String[] cubeSets = gameParts[1].split("; ");
                    for (String cubeSet : cubeSets) {
                        buildCubeSetForGame(game, cubeSet);
                    }
                    possibleGameScenarios.add(game);
                } catch (InvalidConfigurationException e) {
                    System.out.println("Invalid configuration detected. " +
                            "Adding game id: " + game.getGameId() + " to the impossible scenario list");
                    impossibleGameScenarios.add(game);
                }
            }
            System.out.println("Finished processing");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    private void buildCubeSetForGame(Game game, String cubeSet) throws InvalidConfigurationException {
        CubeSet set = new CubeSet();
        String[] cubes = cubeSet.split(", ");
        for(String cube : cubes) {
            int idx = cube.indexOf(" ");
            set.addCubes(cube.substring(idx + 1), Integer.parseInt(cube.substring(0, idx)));
        }
        game.addCubeSet(List.of(set));
    }

    public int calculateSumIdsOfPossibleGames() {
        if(possibleGameScenarios.isEmpty()) return 0;

        return possibleGameScenarios.stream().mapToInt(id -> id.getGameId()).sum();
    }
}
