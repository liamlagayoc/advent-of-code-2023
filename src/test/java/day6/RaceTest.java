package test.java.day6;

import main.java.day6.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {
    @Test
    void it_creates_a_race() {
        Race race = new Race(2, 9);
        assertEquals(race.getLengthOfRace(), 2);
    }

    @Test
    void it_determines_whether_race_was_one_one_ms() {
        Race race = new Race(7, 9);
        race.calculateDistanceTravelledByBoat(1);
        assertFalse(race.hasWon());
    }

    @Test
    void it_calculates_the_correct_distance_of_the_boat_two_ms() {
        Race race = new Race(7, 9);
        race.calculateDistanceTravelledByBoat(2);
        assertTrue(race.hasWon());
    }

    @Test
    void it_calculates_the_correct_distance_of_the_boat_three_ms() {
        Race race = new Race(7, 9);
        race.calculateDistanceTravelledByBoat(3);
        assertTrue(race.hasWon());
    }

    @Test
    void it_calculates_the_correct_distance_of_the_boat_four_ms() {
        Race race = new Race(7, 9);
        race.calculateDistanceTravelledByBoat(4);
        assertTrue(race.hasWon());
    }

    @Test
    void it_calculates_the_correct_distance_of_the_boat_seven_ms() {
        Race race = new Race(7, 9);
        race.calculateDistanceTravelledByBoat(7);
        assertFalse(race.hasWon());
    }
}
