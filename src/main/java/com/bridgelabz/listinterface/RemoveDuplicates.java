package com.bridgelabz.listinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to remove duplicates from a list while maintaining order
public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter elements in list: ");
        for(int i=0;i<n;i++) {
            list.add(input.nextInt());
        }

        // method to remove duplicates from list
        List<Integer> withoutDuplicates = removeDuplicates(list);

        // Display the result
        System.out.println("Original List: " + list);
        System.out.println("List after removing duplicates: " + withoutDuplicates);

        input.close();
    }

    // method to remove duplicates
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> uniques = new ArrayList<>();

        for(Integer i:list) {
            if(!uniques.contains(i)){
                uniques.add(i);
            }
        }

        return uniques;
    }
}
// Sample output ->
// Enter number of elements: 6
// Enter elements in list: 3 1 2 2 3 4
// Original List: [3, 1, 2, 2, 3, 4]
// List after removing duplicates: [3, 1, 2, 4]