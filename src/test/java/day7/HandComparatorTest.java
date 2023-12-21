package test.java.day7;

import main.java.day7.Hand;
import main.java.day7.HandComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {
    private HandComparator handComparator;

    @BeforeEach
    void setUp() {
       handComparator = new HandComparator();
    }

    @Test
    void it_returns_minus_one_when_hand_type_is_less_in_rank() {
        Hand handOne = new Hand("AAAAA", 10);
        Hand handTwo = new Hand("AAAAK", 10);

        assertEquals(handComparator.compare(handOne, handTwo), -1);
    }

    @Test
    void it_returns_one_when_hand_type_is_greater_in_rank() {
        Hand handOne = new Hand("AAAAA", 10);
        Hand handTwo = new Hand("AAAAK", 10);

        assertEquals(handComparator.compare(handTwo, handOne), 1);
    }

    @Test
    void it_returns_zero_when_hand_type_is_equal_in_rank() {
        Hand handOne = new Hand("AAAAA", 10);
        Hand handTwo = new Hand("AAAAA", 10);

        assertEquals(handComparator.compare(handTwo, handOne), 0);
    }

    @Test
    void it_returns_minus_one_when_hand_is_equal_but_card_one_has_higher_starting_card() {
        Hand handOne = new Hand("AAAAA", 10);
        Hand handTwo = new Hand("KKKKK", 10);

        assertEquals(handComparator.compare(handOne, handTwo), -1);
    }

    @Test
    void it_returns_minus_one_when_hand_is_equal_but_card_two_has_higher_starting_card() {
        Hand handOne = new Hand("AAAAA", 10);
        Hand handTwo = new Hand("KKKKK", 10);

        assertEquals(handComparator.compare(handTwo, handOne), 1);
    }

    @Test
    void it_returns_minus_one_when_hand_is_equal_but_card_one_has_higher_second_card() {
        Hand handOne = new Hand("AKAAA", 10);
        Hand handTwo = new Hand("AJAAA", 10);

        assertEquals(handComparator.compare(handOne, handTwo), -1);
    }

    @Test
    void it_returns_minus_one_when_hand_is_equal_but_card_two_has_higher_second_card() {
        Hand handOne = new Hand("AKAAA", 10);
        Hand handTwo = new Hand("AJAAA", 10);

        assertEquals(handComparator.compare(handTwo, handOne), 1);
    }
}
