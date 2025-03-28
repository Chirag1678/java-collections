package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Class to check if two sets are equal or not
public class AreSetsEqual {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter elements of Set 1: ");
        for(int i=0;i<n;i++) {
            set1.add(input.nextInt());
        }

        System.out.print("Enter elements of Set 2: ");
        for(int i=0;i<n;i++) {
            set2.add(input.nextInt());
        }

        // Check if two sets are equal
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Are both sets equal: " + set1.equals(set2));

        input.close();
    }
}
// Sample Output ->
// Enter number of elements: 5
// Enter elements of Set 1: 1 2 3 3 1 
// Enter elements of Set 2: 1 2 3 1 2
// Set 1: [1, 2, 3]
// Set 2: [1, 2, 3]
// Are both sets equal: true