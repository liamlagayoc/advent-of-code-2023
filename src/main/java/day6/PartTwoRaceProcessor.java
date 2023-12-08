package main.java.day6;

import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class PartTwoRaceProcessor extends RaceProcessor {
    public PartTwoRaceProcessor(String filename) {
        super(filename);
    }

    @Override
    protected void processRaces() {
        try {
            List<String> timesAndDistances = FileUtils.readFile(filename);
            String[] raceTimeDigits = timesAndDistances.get(0).split(": ")[1].trim().split("\\s+");
            String[] recordDistanceDigits = timesAndDistances.get(1).split(": ")[1].trim().split("\\s+");
            String raceTime = "";
            String recordDistance = "";
            for(int i = 0; i < raceTimeDigits.length; i++) {
                raceTime = raceTime + "" + raceTimeDigits[i];
                recordDistance = recordDistance + "" + recordDistanceDigits[i];
            }
            Race race = new Race(Long.parseLong(raceTime), Long.parseLong(recordDistance));
            raceList.add(race);
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
