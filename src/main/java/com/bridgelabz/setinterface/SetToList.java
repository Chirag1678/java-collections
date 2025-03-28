package com.bridgelabz.setinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Class to convert a set to sorted list
public class SetToList {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        Set<Integer> set = new HashSet<>();

        System.out.print("Enter elements of set: ");
        for(int i=0;i<n;i++) {
            set.add(input.nextInt());
        }

        // method to convert set to sorted list
        convertSetToList(set);

        input.close();
    }

    // method to convert set to sorted list
    public static void convertSetToList(Set<Integer> set) {
        // Create a list from set
        List<Integer> list = new ArrayList<>(set);

        // Sort the list
        Collections.sort(list);

        System.out.println("Set: " + set);
        System.out.println("List: " + list);
    }
}
// Sample Output ->
// Enter number of elements: 5
// Enter elements of set: 5 4 3 2 1
// Set: [1, 2, 3, 4, 5]
// List: [1, 2, 3, 4, 5]