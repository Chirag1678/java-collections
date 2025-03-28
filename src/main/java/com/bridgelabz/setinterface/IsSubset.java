package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Class to find if one set is subset of another set
public class IsSubset {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements in set 1: ");
        int n = input.nextInt();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter elements of Set 1: ");
        for(int i=0;i<n;i++) {
            set1.add(input.nextInt());
        }

        System.out.print("Enter number of elements in set 2: ");
        n = input.nextInt();

        System.out.print("Enter elements of Set 2: ");
        for(int i=0;i<n;i++) {
            set2.add(input.nextInt());
        }

        // method to check if set 1 is subset of set 2
        checkSubset(set1, set2);

        input.close();
    }

    // method to check if set 1 is subset of set 2
    public static void checkSubset(Set<Integer> set1, Set<Integer> set2) {
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Is Set 1 subset of Set 2: " + set2.containsAll(set1));
    }
}
// Sample Output ->
// Enter number of elements in set 1: 3
// Enter elements of Set 1: 1 2 3
// Enter number of elements in set 2: 5
// Enter elements of Set 2: 1 2 3 4 5
// Set 1: [1, 2, 3]
// Set 2: [1, 2, 3, 4, 5]
// Is Set 1 subset of Set 2: true