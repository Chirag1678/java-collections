package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Class to find union and intersection fo two sets
public class UnionAndIntersection {
    public static void main(String[] args) {
        // Create a Scanner Object
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

        // method to calculate union and intersection of two sets
        findUnionAndIntersection(set1, set2);

        input.close();
    }

    // method to find union and intersection of two sets
    public static void findUnionAndIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union of Sets: " + unionSet);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection of sets: " + intersectionSet);
    }
}
// Sample Output ->
// Enter number of elements: 3
// Enter elements of Set 1: 1 2 3
// Enter elements of Set 2: 3 4 5
// Union of Sets: [1, 2, 3, 4, 5]
// Intersection of sets: [3]