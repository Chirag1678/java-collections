package com.bridgelabz.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to find the key with the highest value in map
public class HighestValueKey {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);
        Map<String, Integer> inputMap = new HashMap<>();

        // Taking user input for map entries
        System.out.println("Enter key-value pairs (type 'exit' to stop):");

        // loop to take user input
        while(true) {
            System.out.print("Enter key (or 'exit' to stop): ");
            String key = input.next();

            if(key.equalsIgnoreCase("exit")) {
                break; // Stop taking input
            }

            System.out.print("Enter value: ");
            int value = input.nextInt();

            inputMap.put(key, value); // Add key-value pair to map
        }

        // Find the key with the maximum value
        String maxKey = getMaxKey(inputMap);

        // Print the result
        if(maxKey!=null) {
            System.out.println("Key with Maximum Value: " + maxKey);
        } else {
            System.out.println("The map is empty.");
        }

        input.close();
    }

    // Function to find the key with the maximum value
    public static String getMaxKey(Map<String, Integer> map) {
        if(map.isEmpty()) {
            return null; // Return null if map is empty
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
// Sample output ->
// Enter key-value pairs (type 'exit' to stop):
// Enter key (or 'exit' to stop): A
// Enter value: 10
// Enter key (or 'exit' to stop): B
// Enter value: 20
// Enter key (or 'exit' to stop): C
// Enter value: 15
// Enter key (or 'exit' to stop): exit
// Key with Maximum Value: B