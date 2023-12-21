package main.java.day7;

public class Main {
    public static void main(String[] args) {
        CamelCards cards = new CamelCards("src/main/resources/input_day7.txt");
        System.out.println("AMOUNT OF WINNINGS: " + cards.calculateTotalWinnings());
    }
}
