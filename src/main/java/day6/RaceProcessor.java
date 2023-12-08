package main.java.day6;

import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RaceProcessor {
    protected final String filename;

    protected final List<Race> raceList;

    public RaceProcessor(String filename) {
        this.filename = filename;
        this.raceList = new ArrayList<>();
        processRaces();
    }

    protected void processRaces() {
        try {
            List<String> timesAndDistances = FileUtils.readFile(filename);
            String[] raceTimes = timesAndDistances.get(0).split(": ")[1].trim().split("\\s+");
            String[] recordDistances = timesAndDistances.get(1).split(": ")[1].trim().split("\\s+");
            for(int i = 0; i < raceTimes.length; i++) {
                Race race = new Race(Integer.parseInt(raceTimes[i]), Integer.parseInt(recordDistances[i]));
                raceList.add(race);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    private List<Integer> winningScenariosByRace() {
        List<Integer> winningScenariosByRace = new ArrayList<>();
        for(Race race : raceList) {
            int winningScenarios = 0;
            long raceTime = race.getLengthOfRace();

            for(int i = 1; i <= raceTime; i++) {
                race.calculateDistanceTravelledByBoat(i);
                if (race.hasWon()) {
                    winningScenarios += 1;
                }
            }
            winningScenariosByRace.add(winningScenarios);
        }
        return winningScenariosByRace;
    }

    public long maximumNumberOfWinningScenarios() {
        List<Integer> winningScenarios = winningScenariosByRace();
        int winningScenariosByRace = winningScenarios.size();

        if (winningScenariosByRace == 0)  { return winningScenariosByRace; }

        return winningScenarios
                .stream()
                .reduce((firstVal, secondVal) -> firstVal * secondVal)
                .get();
    }
}
