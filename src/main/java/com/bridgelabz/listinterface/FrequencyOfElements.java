package com.bridgelabz.listinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to count the frequency of each String using HashMap
public class FrequencyOfElements {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of Strings: ");
        int n = input.nextInt();

        String[] strings = new String[n];

        // loop to take string inputs
        for(int i=0;i<n;i++){
            System.out.print("Enter String " + (i+1) + ": ");
            strings[i] = input.next();
        }

        // Create a map to store frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        // method to find frequency of strings
        findFrequency(frequencyMap, strings);

        // Display the result
        System.out.println(frequencyMap);

        input.close();
    }

    // method to find the frequency of each string
    public static void findFrequency(Map<String, Integer> frequencyMap, String[] strings) {
        for(String s:strings) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s,0)+1);
        }
    }
}
// Sample Output ->
// Enter number of Strings: 4
// Enter String 1: apple
// Enter String 2: banana
// Enter String 3: apple
// Enter String 4: orange
// {banana=1, orange=1, apple=2}