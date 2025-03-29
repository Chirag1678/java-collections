package com.bridgelabz.mapinterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Class to count frequency of each word in a text file
public class WordFrequency {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/mapinterface/WordFrequencyFile.txt";

        // Read file content and store it in a List
        List<String> lines = readFile(filePath);

        // Check if file is empty
        if(lines.isEmpty()) {
            System.out.println("File is empty or could not be read.");
            System.exit(1);
        }

        // Create a map object to store frequency of strings
        Map<String, Integer> frequencyMap = countFrequency(lines);

        // Display the result
        System.out.println("Word Frequencies: ");
        for(Map.Entry<String, Integer> entry:frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // method to read file and return as list of lines
    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();

        // USe try-catch to handle exception
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line=reader.readLine())!=null) {
                lines.add(line);
            }
        } catch(IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return lines;
    }

    // method to count frequency of each word
    public static Map<String, Integer> countFrequency(List<String> lines) {
        Map<String, Integer> wordCount = new HashMap<>();

        for(String line:lines) {
            // convert lines to lowercase and remove punctuation
            line = line.toLowerCase().replaceAll("[^a-z0-9' ]", "");
            String[] words = line.split("\\s+");

            // Count words and store it in map
            for(String word:words) {
                if(!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordCount;
    }
}
// Sample Output ->
// Word Frequencies: 
// world = 2
// java = 2
// is = 2
// hello = 2
// vast = 1
// great = 1