package main.java.day4;

import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ScratchCardProcessor {
    private final String filename;

    private final List<ScratchCard> scratchCards;

    public ScratchCardProcessor(String filename) {
        this.filename = filename;
        this.scratchCards = new ArrayList<>();
        processCards();
    }

    public void processCards() {
        try {
            List<String> cards = FileUtils.readFile(filename);
            for(String card : cards) {
                String[] cardDetails = card.split(": ");
                int cardId = Integer.parseInt(cardDetails[0].replace("Card ", "").trim());
                ScratchCard scratchCard = new ScratchCard(cardId);

                String[] cardInfo = cardDetails[1].split("\\|");
                buildWinningCards(scratchCard, cardInfo[0]);
                buildPlayerCards(scratchCard, cardInfo[1]);
                scratchCards.add(scratchCard);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    private void buildPlayerCards(ScratchCard scratchCard, String playerCards) {
        scratchCard.addPlayerCards(cardListToAdd(playerCards));
    }

    private void buildWinningCards(ScratchCard scratchCard, String winningCards) {
        scratchCard.addWinningCards(cardListToAdd(winningCards));
    }

    private List<Integer> cardListToAdd(String cards) {
        List<Integer> cardList = new ArrayList<>();
        for(String card : cards.split(" ")) {
            if(!card.isEmpty()) {
                cardList.add(Integer.parseInt(card));
            }
        }
        return cardList;
    }

    public int calculateTotalScratchCardPoints() {
        return scratchCards.stream().mapToInt(ScratchCard::calculateCardScore).sum();
    }
}
