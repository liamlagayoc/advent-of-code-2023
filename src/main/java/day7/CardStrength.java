package main.java.day7;

import lombok.Getter;

public enum CardStrength {
    Ace('A', 1),
    King('K', 2),
    Queen('Q', 3),
    Jack('J', 4),
    Ten('T', 5),
    Nine('9', 6),
    Eight('8', 7),
    Seven('7', 8),
    Six('6', 9),
    Five('5', 10),
    Four('4', 11),
    Three('3', 12),
    Two('2', 13);

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