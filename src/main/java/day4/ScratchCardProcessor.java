package main.java.day4;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.*;

public class ScratchCardProcessor {
    private final String filename;

    @Getter
    private final List<ScratchCard> scratchCards;

    @Getter
    private final List<ScratchCard> scratchCardsWon;

    public ScratchCardProcessor(String filename) {
        this.filename = filename;
        this.scratchCards = new ArrayList<>();
        this.scratchCardsWon = new ArrayList<>();
        processCards();
        generateScratchCardsWon(this.scratchCards);
    }

    private void processCards() {
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

    private void generateScratchCardsWon(List<ScratchCard> cards) {
        for(ScratchCard card : cards) {
            scratchCardsWon.add(card);

            int numberOfCardsWon = card.numberOfMatchingScorecards();

            if (numberOfCardsWon > 0) {
                int index = scratchCards.indexOf(card);

                List<ScratchCard> wonCards = scratchCards.subList(index + 1, index + numberOfCardsWon + 1);
                generateScratchCardsWon(wonCards);
            }
        }
    }
}
