package test.java.day4;

import main.java.day4.ScratchCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScratchCardTest {
    @Test
    void it_creates_a_scratchcard() {
        ScratchCard card = new ScratchCard(1);
        assertEquals(card.getCardId(), 1);
    }

    @Test
    void it_gives_a_list_of_winner_numbers() {
        ScratchCard card = new ScratchCard(1);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(17);
        numbers.add(23);
        numbers.add(32);

        card.addWinningCards(numbers);

        assertEquals(card.getWinningCards().size(), 3);
    }

    @Test
    void it_gives_a_list_of_player_numbers() {
        ScratchCard card = new ScratchCard(1);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(17);
        numbers.add(23);
        numbers.add(32);

        card.addPlayerCards(numbers);

        assertEquals(card.getPlayerCards().size(), 3);
    }

    @Test
    void it_calculates_the_correct_score_when_no_matching_numbers_exist() {
        ScratchCard card = new ScratchCard(1);

        card.addWinningCards(List.of(87, 83, 26, 28, 32));
        card.addPlayerCards(List.of(88, 30, 70, 12, 93, 22, 82, 36));

        assertEquals(card.calculateCardScore(), 0);
    }

    @Test
    public void it_calculates_the_correct_score_with_one_matching_number() {
        ScratchCard card = new ScratchCard(1);
        card.addWinningCards(List.of(41, 92, 73, 84, 69));
        card.addPlayerCards(List.of(59, 84, 76, 51, 58, 5, 54, 83));

        assertEquals(card.calculateCardScore(), 1);
    }

    @Test
    public void it_calculates_the_correct_score_with_two_matching_numbers() {
        ScratchCard card = new ScratchCard(1);
        card.addWinningCards(List.of(1, 21, 53, 59, 44));
        card.addPlayerCards(List.of(69, 82, 63, 72, 16, 21, 14, 1));

        assertEquals(card.calculateCardScore(), 2);
    }

    @Test
    public void it_calculates_the_correct_score_with_four_correct_numbers_in_a_row() {
        ScratchCard card = new ScratchCard(1);
        card.addWinningCards(List.of(41, 48, 83, 86, 17));
        card.addPlayerCards(List.of(83, 86, 6, 31, 17, 9, 48, 53));

        assertEquals(card.calculateCardScore(), 8);
    }
}
