package test.java.day2;

import main.java.day2.CubeSet;
import main.java.day2.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void list_of_cubesets_present() {
        Game game = new Game(1);
        assertEquals(game.getCubeSets(), List.of());
    }

    @Test
    public void successfully_adds_a_cubeset_to_the_list() {
        Game game = new Game(1);
        CubeSet set = new CubeSet();
        set.setCubeData("blue", 10);
        set.setCubeData("green", 11);
        set.setCubeData("red", 2);
        game.addCubeSet(set);

        assertEquals(game.getCubeSets().stream().findFirst().get(), set);
    }

    @Test
    public void it_returns_the_correct_game_id() {
        Game game = new Game(120);
        assertEquals(game.getGameId(), 120);
    }

    @Test
    public void it_calculates_power_of_min_values_no_cubeset() {
        Game game = new Game(1);
        assertEquals(game.calculatePowerOfMinValues(), 0);
    }

    @Test()
    public void it_calculates_power_of_min_values_one_cubeset() {
        Game game = new Game(1);

        CubeSet set = new CubeSet();
        set.setCubeData("blue", 6);
        set.setCubeData("green", 2);
        set.setCubeData("red", 4);
        game.addCubeSet(set);

        ArrayList<Integer> minimumValues = new ArrayList<>();
        minimumValues.add(6);
        minimumValues.add(2);
        minimumValues.add(4);
        assertEquals(game.calculatePowerOfMinValues(), 48);
    }

    @Test()
    public void it_calculates_power_of_min_values_multiple_cubesets() {
        Game game = new Game(1);

        CubeSet set = new CubeSet();
        set.setCubeData("blue", 7);
        set.setCubeData("green", 5);
        set.setCubeData("red", 2);
        game.addCubeSet(set);

        CubeSet set2 = new CubeSet();
        set2.setCubeData("red", 1);
        game.addCubeSet(set2);

        CubeSet set3 = new CubeSet();
        set3.setCubeData("blue", 3);
        set3.setCubeData("green", 5);
        game.addCubeSet(set3);

        ArrayList<Integer> minimumValues = new ArrayList<>();
        minimumValues.add(7);
        minimumValues.add(5);
        minimumValues.add(2);
        assertEquals(game.calculatePowerOfMinValues(), 70);
    }
}
