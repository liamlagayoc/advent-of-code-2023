package main.java.day7;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CamelCards {
    @Getter
    private List<Hand> hands;

    private final String filename;

    public CamelCards(String filename) {
        this.filename = filename;
        hands = new ArrayList<>();

        processCards();
    }

    private void processCards() {
        try {
            List<String> handData = FileUtils.readFile(filename);
            for(String cardHands : handData) {
                String[] data = cardHands.split(" ");
                Hand hand = new Hand(data[0], Integer.parseInt(data[1]));
                hands.add(hand);
            }
            System.out.println("CARD HANDS PROCESSED SUCCESSFULLY");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND: " + filename);
        }
    }

    public int calculateTotalWinnings() {
        int winnings = 0;
        hands.sort(new HandComparator());
        for(Hand hand : hands) {
            int rank = (hands.size() - hands.indexOf(hand));
            System.out.println("CARD HAND: " + hand.getCardHand() + " - BID: " + hand.getBid() + " - RANK: " + rank);
            winnings = winnings + (hand.getBid() * rank);
            System.out.println("CURRENT TOTAL: " + winnings);
        }
        return winnings;
    }
}
