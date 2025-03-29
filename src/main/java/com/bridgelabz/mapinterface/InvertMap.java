package com.bridgelabz.mapinterface;

import java.util.*;

// Class to invert a map -> Map<K,V> becomes Map<V,K> where if multiple K have same V, they are stored like a list
public class InvertMap {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of entries: ");
        int n = input.nextInt();

        // Create a map and store values in it
        Map<String, Integer> mapInput = new HashMap<>();
        for(int i=0;i<n;i++) {
            System.out.print("Enter the Key(String): ");
            String k = input.next();
            System.out.print("Enter the Value(Integer): ");
            int v = input.nextInt();

            mapInput.put(k, v);
        }

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(mapInput);

        // Display the result
        System.out.println("Original map: " + mapInput);
        System.out.println("Inverted map: " + invertedMap);

        input.close();
    }

    // method to invert a map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for(Map.Entry<K, V> entry:map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Add key's corresponding values
            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }
}
// Sample Output ->
// Enter number of entries: 3
// Enter the Key(String): A
// Enter the Value(Integer): 1
// Enter the Key(String): B
// Enter the Value(Integer): 2
// Enter the Key(String): C
// Enter the Value(Integer): 1
// Original map: {A=1, B=2, C=1}
// Inverted map: {1=[A, C], 2=[B]}