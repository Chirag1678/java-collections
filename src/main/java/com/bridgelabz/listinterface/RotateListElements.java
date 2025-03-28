package com.bridgelabz.listinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Class to rotate the elements in a list by given value
public class RotateListElements {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        Integer[] numbers = new Integer[n];

        // loop to take number inputs
        System.out.print("Enter elements of array: ");
        for(int i=0;i<n;i++) {
            numbers[i] = input.nextInt();
        }

        System.out.print("Enter the position for rotation: ");
        int k = input.nextInt();

        // Create a list from array
        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));

        // method to rotate list by k positions
        List<Integer> rotatedList = rotateList(list, k);

        // Display the result
        System.out.println("Original list: " + list);
        System.out.println("Rotated list: " + rotatedList);

        input.close();
    }

    // method to rotate list by k positions
    public static List<Integer> rotateList(List<Integer> list, int k) {
        if(k==0) return list;

        // Create a List Object to store rotated list
        List<Integer> rotatedList = new ArrayList<>();

        // add elements from k->n and 0->k
        rotatedList.addAll(list.subList(k,list.size()));
        rotatedList.addAll(list.subList(0,k));

        return rotatedList;
    }
}
// Sample Output ->
//Enter number of elements: 5
//Enter elements of array: 10 20 30 40 50
//Enter the position for rotation: 2
//Original list: [10, 20, 30, 40, 50]
//Rotated list: [30, 40, 50, 10, 20]