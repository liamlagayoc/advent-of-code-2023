package test.java.day2;

import main.java.day2.CubeSet;
import main.java.day2.Game;
import main.java.day2.InvalidConfigurationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void list_of_cubesets_present() {
        Game game = new Game(1);
        assertEquals(game.getCubeSets(), List.of());
    }

    @Test
    public void successfully_adds_a_cubeset_to_the_list() throws InvalidConfigurationException {
        Game game = new Game(1);
        CubeSet set = new CubeSet();
        set.addCubes("blue", 10);
        set.addCubes("green", 11);
        set.addCubes("red", 2);
        game.addCubeSet(List.of(set));

        assertEquals(game.getCubeSets().stream().findFirst().get(), List.of(set));
    }

    @Test
    public void it_returns_the_correct_game_id() {
        Game game = new Game(120);
        assertEquals(game.getGameId(), 120);
    }
}
