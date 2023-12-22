package test.java.day7;

import main.java.day7.Hand;
import main.java.day7.HandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    void it_returns_the_correct_hand_type_full_house() {
        Hand hand = new Hand("AAAAA", 10);
        assertEquals(hand.getHandType(), HandType.FiveOfAKind);
    }

    @Test
    void it_returns_a_four_of_a_kind() {
        Hand hand = new Hand("AA8AA", 10);
        assertEquals(hand.getHandType(), HandType.FourOfAKind);
    }

    @Test
    void it_returns_a_five_of_a_kind_with_a_joker() {
        Hand hand = new Hand("AAJAA", 10);
        assertEquals(hand.getHandType(), HandType.FiveOfAKind);
    }

    @Test
    void it_returns_a_four_of_a_kind_with_two_jokers() {
        Hand hand = new Hand("KTJJT", 10);
        assertEquals(hand.getHandType(), HandType.FourOfAKind);
    }

    @Test
    void it_returns_a_three_of_a_kind_with_two_pairs_initially() {
        Hand hand = new Hand("KTKJT", 10);
        assertEquals(hand.getHandType(), HandType.FullHouse);
    }

    @Test
    void it_returns_a_five_of_a_kind_if_all_jokers() {
        Hand hand = new Hand("JJJJJ", 10);
        assertEquals(hand.getHandType(), HandType.FiveOfAKind );
    }

    @Test
    void it_returns_a_full_house_with_joker_mixed() {
        Hand hand = new Hand("7799J", 10);
        assertEquals(hand.getHandType(), HandType.FullHouse);
    }

    @Test
    void it_returns_a_three_of_a_kind_with_joker_mixed() {
        Hand hand = new Hand("234JJ", 10);
        assertEquals(hand.getHandType(), HandType.ThreeOfAKind);
    }

    @Test
    void it_returns_a_full_house() {
        Hand hand = new Hand("23332", 10);
        assertEquals(hand.getHandType(), HandType.FullHouse);
    }

    @Test
    void it_returns_a_three_of_a_kind() {
        Hand hand = new Hand("TTT98", 10);
        assertEquals(hand.getHandType(), HandType.ThreeOfAKind);
    }

    @Test
    void it_returns_a_two_pair() {
        Hand hand = new Hand("23432", 10);
        assertEquals(hand.getHandType(), HandType.TwoPair);
    }

    @Test
    void it_returns_a_one_pair() {
        Hand hand = new Hand("A23A4", 10);
        assertEquals(hand.getHandType(), HandType.OnePair);
    }

    @Test
    void it_returns_a_high_card() {
        Hand hand = new Hand("23456", 10);
        assertEquals(hand.getHandType(), HandType.HighCard);
    }
}
