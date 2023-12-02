import main.java.day1.CalibrationCalculator;

public class Main {
    public static void main(String[] args) {
        CalibrationCalculator calculator = new CalibrationCalculator("src/main/resources/input_day1.txt");
        System.out.println("Calibrated values for input: " + calculator.calculateCalibrationValues());
    }
}
