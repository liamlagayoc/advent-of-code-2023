package test.java.day2;

import main.java.day2.CubeSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CubeSetTest {
    @Test
    public void valid_configuration_blue_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("blue", 14);
        assertEquals(cubeSet.getNumberOfBlueCubes(), 14);
        assertEquals(cubeSet.isValidScenario(), true);
    }

    @Test
    public void valid_configuration_green_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("green", 13);
        assertEquals(cubeSet.getNumberOfGreenCubes(), 13);
        assertEquals(cubeSet.isValidScenario(), true);
    }

    @Test
    public void valid_configuration_red_boundary_limits() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("red", 12);
        assertEquals(cubeSet.getNumberOfRedCubes(), 12);
        assertEquals(cubeSet.isValidScenario(), true);
    }

    @Test
    public void invalid_configuration_red_cubes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("red", 13);
        assertEquals(cubeSet.getNumberOfRedCubes(), 13);
        assertEquals(cubeSet.isValidScenario(), false);
    }

    @Test
    public void invalid_configuration_green_cubes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("green", 14);
        assertEquals(cubeSet.getNumberOfGreenCubes(), 14);
        assertEquals(cubeSet.isValidScenario(), false);
    }

    @Test
    public void invalid_configuration_blue_cubes() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("blue", 15);
        assertEquals(cubeSet.getNumberOfBlueCubes(), 15);
        assertEquals(cubeSet.isValidScenario(), false);
    }

    @Test
    public void valid_configuration_added_to_hash_map_correctly() {
        CubeSet cubeSet = new CubeSet();
        cubeSet.setCubeData("blue", 2);
        cubeSet.setCubeData("red", 5);
        cubeSet.setCubeData("green", 9);
        assertEquals(cubeSet.getNumberOfBlueCubes(), 2);
        assertEquals(cubeSet.getNumberOfRedCubes(), 5);
        assertEquals(cubeSet.getNumberOfGreenCubes(), 9);
    }
}
