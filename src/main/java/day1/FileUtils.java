package main.java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<String> readFile(String filename) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new File(filename))) {
            List<String> stringLines = new ArrayList<>();
            while(scanner.hasNextLine()) {
                stringLines.add(scanner.nextLine());
            }
            System.out.println("File successfully processed");
            return stringLines;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found: " + filename);
            throw fileNotFoundException;
        }
    }
}
