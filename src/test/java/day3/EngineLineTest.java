package test.java.day3;

import main.java.day3.EngineLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineLineTest {
    @Test
    void returns_correct_info_when_special_character_only_exists() {
        EngineLine line = new EngineLine(".........*.");
        line.buildEngineLineInfo();

        List<Integer> specialCharacterIndexes = new ArrayList<>();
        specialCharacterIndexes.add(9);
        assertEquals(line.getPartNumberList(), List.of());
        assertEquals(line.getSpecialCharacterIndexes(), specialCharacterIndexes);
    }

    @Test
    void returns_correct_info_when_multiple_special_characters_only_exist() {
        EngineLine line = new EngineLine("../......*.");
        line.buildEngineLineInfo();

        List<Integer> specialCharacterIndexes = new ArrayList<>();
        specialCharacterIndexes.add(2);
        specialCharacterIndexes.add(9);
        assertEquals(line.getPartNumberList(), List.of());
        assertEquals(line.getSpecialCharacterIndexes(), specialCharacterIndexes);
    }

    @Test
    void returns_correct_info_when_numbers_only_exists() {
        EngineLine line = new EngineLine("467..114..");
        line.buildEngineLineInfo();

        assertEquals(line.getPartNumberList().size(), 2);
        assertEquals(line.getSpecialCharacterIndexes(), List.of());
    }

    @Test
    void returns_correct_info_when_mixed_with_numbers_and_special_characters() {
        EngineLine line = new EngineLine("617*......");
        line.buildEngineLineInfo();

        List<Integer> specialCharacterIndexes = new ArrayList<>();
        specialCharacterIndexes.add(3);

        assertEquals(line.getPartNumberList().size(), 1);
        assertEquals(line.getSpecialCharacterIndexes(), specialCharacterIndexes);
    }

    @Test
    void returns_true_when_adjacent_characters_exist_on_same_line() {
        EngineLine line = new EngineLine("617*......");
        line.buildEngineLineInfo();

        assertEquals(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void returns_true_when_adjacent_characters_exist_on_same_line_before_value() {
        EngineLine line = new EngineLine("?617......");
        line.buildEngineLineInfo();

        assertEquals(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_part_number_for_row_when_multiple_values_exist() {
        EngineLine line = new EngineLine("617*...428/.");
        line.buildEngineLineInfo();

        assertEquals(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()), 1045);
    }

    @Test
    void calculates_correct_part_number_for_row_when_three_values_exist() {
        EngineLine line = new EngineLine("617*...428/....*900");
        line.buildEngineLineInfo();

        assertEquals(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()), 1945);
    }

    @Test
    void returns_false_when_on_same_line_but_not_adjacent() {
        EngineLine line = new EngineLine("?.....617.");
        line.buildEngineLineInfo();

        assertEquals(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()), 0);
    }

    @Test
    void calculates_correct_value_when_other_lines_have_adjacent_symbols_on_next_line() {
        EngineLine line1 = new EngineLine("?.....617.");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine(".....?..8.");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_value_when_other_lines_have_adjacent_symbols_diagonally_on_next_line() {
        EngineLine line1 = new EngineLine("?.....617.");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine(".........?");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_value_when_next_line_has_special_character_in_same_indexes() {
        EngineLine line1 = new EngineLine("?.....617.");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine("......?...");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_value_when_next_line_has_special_character_underneath_value() {
        EngineLine line1 = new EngineLine("?.....617.");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine(".......?..");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_value_when_next_line_has_special_character_at_end_of_value() {
        EngineLine line1 = new EngineLine("?.....617.");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine("........?.");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 617);
    }

    @Test
    void calculates_correct_value_when_cojoined_values() {
        EngineLine line1 = new EngineLine("?.....617*900");
        line1.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line1.getSpecialCharacterIndexes()), 1517);
    }

    @Test
    void calculates_correct_value_when_cojoined_values_and_multiple_lines() {
        EngineLine line1 = new EngineLine("?.....617*900");
        line1.buildEngineLineInfo();

        EngineLine line2 = new EngineLine(".....?...?");
        line2.buildEngineLineInfo();

        assertEquals(line1.getValueContainingAdjacentSymbol(line2.getSpecialCharacterIndexes()), 1517);
    }
}
