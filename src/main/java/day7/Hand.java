package main.java.day7;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hand {
    @Getter
    private final String cardHand;

    @Getter
    private final int bid;

    public Hand(String cardHand, int bid) {
        this.cardHand = cardHand;
        this.bid = bid;
    }

    public HandType getHandType() {
        Map<CardStrength, Integer> handDetails = new LinkedHashMap<>();
        for(char label : cardHand.toCharArray()) {
            CardStrength cardStrength = CardStrength.getCardStrengthForHandValue(label);
            handDetails.put(cardStrength, handDetails.getOrDefault(cardStrength, 0) + 1);
        }

        if(handDetails.size() == 1) {
            return HandType.FiveOfAKind;
        } else if (handDetails.size() == 2) {
            if (matchingNumberOfCardsExist(handDetails, 4)) {
                return HandType.FourOfAKind;
            } else {
                return HandType.FullHouse;
            }
        } else if (handDetails.size() == 3) {
            if(matchingNumberOfCardsExist(handDetails, 3)) {
                return HandType.ThreeOfAKind;
            } else {
                return HandType.TwoPair;
            }
        } else if (handDetails.size() == 4) {
            return HandType.OnePair;
        }
        return HandType.HighCard;
    }

    private boolean matchingNumberOfCardsExist(Map<CardStrength, Integer> handDetails, int value) {
        return handDetails.values().stream().anyMatch(a -> a == value);
    }
}
