package main.java.day5;

import lombok.Getter;
import main.java.day1.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Almanac {
    private final String filename;

    @Getter
    private List<Long> seeds;

    private List<Range> seedToSoilRange;

    private List<Range> soilToFertilizerRange;

    private List<Range> fertilizerToWaterRange;

    private List<Range> waterToLightRange;

    private List<Range> lightToTemperateRange;

    private List<Range> temperatureToHumidityRange;

    private List<Range> humidityToLocationRange;

    public Almanac(String filename) {
        this.filename = filename;
        this.seeds = new ArrayList<>();
        processAlmanac();
    }

    public boolean processAlmanac() {
        try {
            List<String> content = FileUtils.readFile(filename);
            content.removeIf(String::isBlank);

            populateSeeds(content.get(0).split(": ")[1]);
            this.seedToSoilRange = populateRanges("seed-to-soil map:", "soil-to-fertilizer map:", content);
            this.soilToFertilizerRange = populateRanges("soil-to-fertilizer map:", "fertilizer-to-water map:", content);
            this.fertilizerToWaterRange = populateRanges("fertilizer-to-water map:", "water-to-light map:", content);
            this.waterToLightRange = populateRanges("water-to-light map:", "light-to-temperature map:", content);
            this.lightToTemperateRange = populateRanges("light-to-temperature map:", "temperature-to-humidity map:", content);
            this.temperatureToHumidityRange = populateRanges("temperature-to-humidity map:", "humidity-to-location map:", content);
            this.humidityToLocationRange = populateRanges("humidity-to-location map:", content);
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return false;
        }
        return true;
    }

    public long getLocationForSeed(long seed) {
        long soilValue = findLocationOrDefault(seed, this.seedToSoilRange);
        long fertilizerValue = findLocationOrDefault(soilValue, this.soilToFertilizerRange);
        long waterValue = findLocationOrDefault(fertilizerValue, this.fertilizerToWaterRange);
        long lightValue = findLocationOrDefault(waterValue, this.waterToLightRange);
        long temperatureValue = findLocationOrDefault(lightValue, this.lightToTemperateRange);
        long humidityValue = findLocationOrDefault(temperatureValue, this.temperatureToHumidityRange);
        return findLocationOrDefault(humidityValue, this.humidityToLocationRange);
    }

    private long findLocationOrDefault(long value, List<Range> rangesToSearch) {
       for(Range range : rangesToSearch) {
           if (range.inRange(value)) {
               return range.calculateFinalDestinationValue(value);
           }
       }
       return value;
    }

    public void populateSeeds(String seeds) {
        if (!seeds.isEmpty()) {
            long[] seedValues = Arrays.stream(seeds.split(" ")).mapToLong(Long::parseLong).toArray();
            this.seeds.addAll(Arrays.stream(seedValues).boxed().collect(Collectors.toList()));
        }
    }

    private int indexOfText(List<String> content, String contentToFind) {
        return content.indexOf(contentToFind);
    }

    public List<Range> populateRanges(String startText, String finishText, List<String> content) {
        int minIndex = indexOfText(content, startText);
        int maxIndex = indexOfText(content, finishText);
        return populateRange(content.subList(minIndex + 1, maxIndex));
    }

    public List<Range> populateRanges(String startText, List<String> content) {
        int minIndex = indexOfText(content, startText);
        return populateRange(content.subList(minIndex + 1, content.size()));
    }

    private List<Range> populateRange(List<String> subList) {
        List<Range> rangeList = new ArrayList<>();
        for (String instructionInfo : subList) {
            String[] instructions = instructionInfo.split(" ");
            long destinationStart = Long.parseLong(instructions[0]);
            long sourceStart = Long.parseLong(instructions[1]);
            long rangeLength = Long.parseLong(instructions[2]);
            rangeList.add(new Range(sourceStart, (sourceStart + rangeLength) - 1L, rangeLength, destinationStart));
        }
        return rangeList;
    }

    public long getMinimumSeedLocation() {
        List<Long> seedLocations = new ArrayList<>();

        for(long seed : seeds) {
            seedLocations.add(getLocationForSeed(seed));
        }

        return Collections.min(seedLocations);
    }
}
