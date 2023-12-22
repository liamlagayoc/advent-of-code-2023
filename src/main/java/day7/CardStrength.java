package main.java.day7;

import lombok.Getter;

public enum CardStrength {
    Ace('A', 1),
    King('K', 2),
    Queen('Q', 3),
    Ten('T', 4),
    Nine('9', 5),
    Eight('8', 6),
    Seven('7', 7),
    Six('6', 8),
    Five('5', 9),
    Four('4', 10),
    Three('3', 11),
    Two('2', 12),
    Joker('J', 13);

    private final char label;

    @Getter
    private final int order;

    CardStrength(char label, int order) {
        this.label = label;
        this.order = order;
    }

    public static CardStrength getCardStrengthForHandValue(final char value) {
        for(CardStrength strength : CardStrength.values()) {
            if(strength.label == value) {
                return strength;
            }
        }
        return null;
    }
}