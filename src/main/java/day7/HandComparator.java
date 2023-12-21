package main.java.day7;

import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {
    @Override
    public int compare(Hand o1, Hand o2) {
        HandType typeOne = o1.getHandType();
        HandType typeTwo = o2.getHandType();

        if(typeOne.getRank() < typeTwo.getRank()) {
            return -1;
        } else if (typeOne.getRank() > typeTwo.getRank()) {
            return 1;
        }

        String cardHandOne = o1.getCardHand();
        String cardHandTwo = o2.getCardHand();

        for(int i = 0; i < cardHandOne.length(); i++) {
            CardStrength cardStrengthOne = CardStrength.getCardStrengthForHandValue(cardHandOne.charAt(i));
            CardStrength cardStrengthTwo = CardStrength.getCardStrengthForHandValue(cardHandTwo.charAt(i));

            if(cardStrengthOne.getOrder() < cardStrengthTwo.getOrder()) {
                return -1;
            } else if (cardStrengthOne.getOrder() > cardStrengthTwo.getOrder()) {
                return 1;
            }
        }
        return 0;
    }
}
