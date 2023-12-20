package test.java.day5;

import main.java.day5.Almanac;
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
    void it_has_the_correct_maps_to_store_information() {
        Almanac almanac = new Almanac("foo");
//        assertNotNull(almanac.getSeedToSoilMap());
//        assertNotNull(almanac.getSoilToFertilizerMap());
//        assertNotNull(almanac.getFertilizerToWaterMap());
//        assertNotNull(almanac.getWaterToLightMap());
//        assertNotNull(almanac.getLightToTemperatureMap());
//        assertNotNull(almanac.getTemperatureToHumidityMap());
//        assertNotNull(almanac.getHumidityToLocationMap());
    }

    @Test
    void it_populates_the_seeds_correctly() {
        String seeds = "52 74 90 19";
        Almanac almanac = new Almanac("src/test/resources/input_day5_test.txt");
        assertEquals(almanac.getSeeds().size(), 4);
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

        assertEquals(almanac.getMinimumSeedLocation(), 35);
    }
}
