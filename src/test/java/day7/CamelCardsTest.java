package test.java.day7;

import main.java.day7.CamelCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCardsTest {
    @Test
    public void it_does_not_throw_an_error_if_file_found() {
        assertDoesNotThrow(() -> new CamelCards("src/test/resources/input_day7_test.txt"));
    }

    @Test
    public void it_returns_correct_number_of_hands_in_camel_cards() {
        CamelCards cards = new CamelCards("src/test/resources/input_day7_test.txt");
        assertEquals(cards.getHands().size(), 5);
    }

    @Test
    public void it_returns_no_card_hands_if_file_not_found() {
        CamelCards cards = new CamelCards("foo");
        assertEquals(cards.getHands().size(), 0);
    }

    @Test
    void it_calculates_the_correct_total_winnings() {
        CamelCards cards = new CamelCards("src/test/resources/input_day7_test.txt");
        assertEquals(cards.calculateTotalWinnings(), 6440);
    }
}
