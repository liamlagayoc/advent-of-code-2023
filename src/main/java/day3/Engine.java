package main.java.day3;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    private final String filename;

    @Getter
    private final List<EngineLine> lines;

    public Engine(String filename) {
        this.filename = filename;
        lines = new ArrayList<>();
        processFile();
    }

    private void processFile() {
        try {
            List<String> engineLines = FileUtils.readFile(filename);
            for(String line : engineLines) {
                EngineLine engineLine = new EngineLine(line);
                engineLine.buildEngineLineInfo();
                lines.add(engineLine);
            }
            System.out.println("File processed");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public int calculatePartNumbers() {
        List<Integer> rowValues = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            EngineLine line = lines.get(i);
            rowValues.add(line.getValueContainingAdjacentSymbol(line.getSpecialCharacterIndexes()));

            if (i < lines.size() - 1) {
                EngineLine nextLine = lines.get(i + 1);
                rowValues.add(line.getValueContainingAdjacentSymbol(nextLine.getSpecialCharacterIndexes()));
            }

            if (i > 0 && i < lines.size()) {
                EngineLine previousLine = lines.get(i - 1);
                rowValues.add(line.getValueContainingAdjacentSymbol(previousLine.getSpecialCharacterIndexes()));
            }
        }
        return rowValues.stream().mapToInt(Integer::valueOf).sum();
     }
}
