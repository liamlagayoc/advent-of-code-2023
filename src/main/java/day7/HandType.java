package main.java.day7;

import lombok.Getter;

public enum HandType {
    FiveOfAKind(1),
    FourOfAKind(2),
    FullHouse(3),
    ThreeOfAKind(4),
    TwoPair(5),
    OnePair(6),
    HighCard(7);

    @Getter
    private final int rank;

    HandType(int rank) {
        this.rank = rank;
    }
}
