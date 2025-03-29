package com.bridgelabz.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to merge two maps and make a single map
public class MergeMaps {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Taking input for Map 1
        System.out.println("Enter values for Map 1 (type 'exit' to stop):");
        Map<String, Integer> map1 = readMapFromUser(input);

        // Taking input for Map 2
        System.out.println("Enter values for Map 2 (type 'exit' to stop):");
        Map<String, Integer> map2 = readMapFromUser(input);

        // Merging both maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Displaying merged map
        System.out.println("Merged Map: " + mergedMap);

        input.close();
    }

    // Function to take user input and create a map
    private static Map<String, Integer> readMapFromUser(Scanner input) {
        Map<String, Integer> map = new HashMap<>();

        while(true) {
            System.out.print("Enter key (or 'exit' to stop): ");
            String key = input.next();

            if(key.equalsIgnoreCase("exit")) {
                break; // Stop taking input
            }

            System.out.print("Enter value: ");
            int value = input.nextInt();

            map.put(key, value); // Add key-value pair to map
        }
        return map;
    }

    // Function to merge two maps
    private static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Copy first map

        // Merge values from second map
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
}
// Sample Output ->
// Enter values for Map 1 (type 'exit' to stop):
// Enter key (or 'exit' to stop): A
// Enter value: 1
// Enter key (or 'exit' to stop): B
// Enter value: 2
// Enter key (or 'exit' to stop): exit
// Enter values for Map 2 (type 'exit' to stop):
// Enter key (or 'exit' to stop): B
// Enter value: 3
// Enter key (or 'exit' to stop): C
// Enter value: 4
// Enter key (or 'exit' to stop): exit
// Merged Map: {A=1, B=5, C=4}