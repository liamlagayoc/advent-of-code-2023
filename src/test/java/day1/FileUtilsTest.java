package test.java.day1;

import main.java.day1.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void it_throws_an_error_if_file_is_not_found() {
        String filename = "src/test/resources/input_day2_test.txt";
        assertThrows(FileNotFoundException.class, () -> FileUtils.readFile(filename));
    }

    @Test
    public void it_returns_an_empty_list_of_lines_if_blank_file() throws FileNotFoundException {
        assertEquals(FileUtils.readFile("src/test/resources/input_day1_empty_file.txt"), List.of());
    }

    @Test
    public void it_returns_an_output_when_file_is_found() throws FileNotFoundException {
        List<String> expectedValues = List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        String filename = "src/test/resources/input_day1_test.txt";
        assertEquals(FileUtils.readFile(filename), expectedValues);
        String outputLogs = outContent.toString();
        assertEquals("File successfully processed\n", outputLogs);
    }
}
