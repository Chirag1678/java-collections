package com.bridgelabz.listinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Class to reverse a list of elements using ArrayList and LinkedList
public class ReverseList {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        Integer[] nums = new Integer[n];

        System.out.print("Enter elements of array: ");
        for(int i=0;i<n;i++) {
            nums[i] = input.nextInt();
        }

        input.close();

        // Convert array to ArrayList
        List<Integer> list = new ArrayList<>(Arrays.asList(nums));

        // Convert array to LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(nums));

        // Display the result
        System.out.println("Original ArrayList: " + list);
        System.out.println("Reversed ArrayList: " + reverseArrayList(list));
        System.out.println();
        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkedList));
    }


    // method to reverse an ArrayList
    public static List<Integer> reverseArrayList(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while(left<right) {
            // swap elements
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    // method to reverse a LinkedList
    public static List<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reverseList = new LinkedList<>();
        for(Integer item:list) {
            reverseList.addFirst(item); // Add at the beginning
        }
        return reverseList;
    }
}
// Sample output ->
//Enter number of elements: 5
//Enter elements of array: 1 2 3 4 5
//Original ArrayList: [1, 2, 3, 4, 5]
//Reversed ArrayList: [5, 4, 3, 2, 1]
//
//Original LinkedList: [1, 2, 3, 4, 5]
//Reversed LinkedList: [5, 4, 3, 2, 1]