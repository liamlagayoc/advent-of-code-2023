package main.java.day6;

public class Main {
    public static void main(String[] args) {
        RaceProcessor processor = new RaceProcessor("src/main/resources/input_day6.txt");
        System.out.println("MAX NUMBER OF WINNING SCENARIOS: " + processor.maximumNumberOfWinningScenarios());
    }
}
