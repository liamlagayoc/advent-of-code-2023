package main.java.day4;

public class Main {
    public static void main(String[] args) {
        ScratchCardProcessor processor = new ScratchCardProcessor("src/main/resources/input_day4.txt");
        System.out.println("TOTAL OF SCORECARDS: " + processor.calculateTotalScratchCardPoints());
    }
}
