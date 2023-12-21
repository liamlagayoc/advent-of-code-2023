package test.java.day5;

import main.java.day5.Almanac;
import main.java.day5.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlmanacTest {
    @Test
    void it_has_a_list_of_seeds() {
        Almanac almanac = new Almanac("foo");
        assertNotNull(almanac.getSeeds());
    }

    @Test
    void it_populates_the_range_of_seeds_correctly() {
        Almanac almanac = new Almanac("src/test/resources/input_day5_test.txt");
        assertEquals(almanac.getSeeds().size(), 2);

        Range firstRange = almanac.getSeeds().get(0);
        assertEquals(firstRange.getRangeLength(), 14);

        Range secondRange = almanac.getSeeds().get(1);
        assertEquals(secondRange.getRangeLength(), 13);
    }

    @Test
    void it_returns_no_seeds_if_an_empty_line() {
        Almanac almanac = new Almanac("foo");
        almanac.populateSeeds("");
        assertEquals(almanac.getSeeds().size(), 0);
    }

    @Test
    void it_gets_the_correct_location_for_a_seed() {
        Almanac almanac = new Almanac("src/test/resources/input_day5_test.txt");

        assertEquals(almanac.getLocationForSeed(79), 82);
        assertEquals(almanac.getLocationForSeed(14), 43);
        assertEquals(almanac.getLocationForSeed(55), 86);
        assertEquals(almanac.getLocationForSeed(13), 35);
    }

    @Test
    void it_calculates_the_minimum_location_for_a_seed() {
        Almanac almanac = new Almanac("src/test/resources/input_day5_test.txt");

        assertEquals(almanac.getMinimumSeedLocation(), 46);
    }
}
