package test.java.day3;

import main.java.day3.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("src/main/resources/input_day3.txt");
        System.out.println("Total sum of part numbers: " + engine.calculatePartNumbers());
    }
}
