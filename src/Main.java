import main.java.day1.CalibrationCalculator;
import main.java.day2.GameProcessor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        CalibrationCalculator calculator = new CalibrationCalculator("src/main/resources/input_day1.txt");
//        System.out.println("Calibrated values for input: " + calculator.calculateCalibrationValues());

        GameProcessor processor = new GameProcessor("src/main/resources/input_day2.txt");

        System.out.println("Number of possible game scenarios in file: " + processor.getPossibleGameScenarios().size());
        System.out.println("Game IDs of possible scenarios: " + Arrays.toString(processor.getPossibleGameScenarios().stream().map(i -> i.getGameId()).toArray()));
        System.out.println("######################");
        System.out.println("");
        System.out.println("Number of impossible game scenarios in file: " + processor.getImpossibleGameScenarios().size());
        System.out.println("Game IDs of impossible scenarios: " + Arrays.toString(processor.getImpossibleGameScenarios().stream().map(i -> i.getGameId()).toArray()));
        System.out.println("######################");
        System.out.println("");
        System.out.println("SUM OF IDs for POSSIBLE GAME SCENARIOS: " + processor.calculateSumIdsOfPossibleGames());
        System.out.println("######################");
        System.out.println("");
    }
}
