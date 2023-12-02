package test.java.day2;

import main.java.day2.CubeSet;
import main.java.day2.InvalidConfigurationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CubeSetTest {
    @Test
    public void invalid_configuration_invalid_colour() {
        CubeSet cubeSet = new CubeSet();
        assertThrows(InvalidConfigurationException.class,
                () -> cubeSet.addCubes("purple", 1));
    }

    @Test
    public void invalid_configuration_blue_colour_invalid_amount () {
        CubeSet cubeSet = new CubeSet();
        assertThrows(InvalidConfigurationException.class,
                () -> cubeSet.addCubes("blue", 15));
    }

    @Test
    public void invalid_configuration_green_colour_invalid_amount() {
        CubeSet cubeSet = new CubeSet();
        assertThrows(InvalidConfigurationException.class,
                () -> cubeSet.addCubes("green", 14));
    }

    @Test
    public void invalid_configuration_red_colour_invalid_amount() {
        CubeSet cubeSet = new CubeSet();
        assertThrows(InvalidConfigurationException.class,
                () -> cubeSet.addCubes("red", 13));
    }

    @Test
    public void valid_configuration_blue_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        assertDoesNotThrow(() -> cubeSet.addCubes("blue", 14));
    }

    @Test
    public void valid_configuration_green_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        assertDoesNotThrow(() -> cubeSet.addCubes("green", 13));
    }

    @Test
    public void valid_configuration_red_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        assertDoesNotThrow(() -> cubeSet.addCubes("red", 12));
    }

    @Test
    public void valid_configuration_added_to_hash_map_correctly() throws InvalidConfigurationException {
        CubeSet cubeSet = new CubeSet();
        cubeSet.addCubes("blue", 2);
        cubeSet.addCubes("red", 5);
        cubeSet.addCubes("green", 9);
        assertEquals(cubeSet.getCubes().get("blue"), 2);
        assertEquals(cubeSet.getCubes().get("red"), 5);
        assertEquals(cubeSet.getCubes().get("green"), 9);
    }
}
