package main.java.day4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScratchCard {
    @Getter
    public final int cardId;

    @Getter
    private final List<Integer> winningCards;

    @Getter
    private final List<Integer> playerCards;

    public ScratchCard(int cardId) {
        this.cardId = cardId;
        this.winningCards = new ArrayList<>();
        this.playerCards = new ArrayList<>();
    }

    public void addWinningCards(List<Integer> winningNumbers) {
        winningCards.addAll(winningNumbers);
    }

    public void addPlayerCards(List<Integer> playerNumbers) {
        playerCards.addAll(playerNumbers);
    }

    public int calculateCardScore() {
        int result = 0;
        for(int i = 0; i < getMatchingScorecards().size(); i++) {
            if(i < 2) {
                result += 1;
            }
            else {
                result *= 2;
            }
        }
        return result;
    }

    public int numberOfMatchingScorecards() {
        return getMatchingScorecards().size();
    }

    private List<Integer> getMatchingScorecards() {
        return winningCards.stream()
                .filter(playerCards::contains)
                .collect(Collectors.toList());
    }
}
