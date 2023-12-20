package main.java.day5;

public class Main {
    public static void main(String[] args) {
        Almanac almanac = new Almanac("src/main/resources/input_day5.txt");
        System.out.println("PART 1 ANSWER - MINIMUM LOCATION FOR SEED NUMBERS: " + almanac.getMinimumSeedLocation());
    }
}
