package com.bridgelabz.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class to generate binary numbers upto n
public class BinaryNumbers {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        input.close();

        // generate and display first n binary numbers
        binaryNumbers(n);
    }

    // method to generate first n binary numbers
    public static void binaryNumbers(int n) {
        // Create a queue of string to store binary numbers as strings
        Queue<String> queue = new LinkedList<>();
        Queue<String> result = new LinkedList<>();

        queue.add("1");

        for(int i=0;i<n;i++) {
            // Remove the front element
            String front = queue.remove();

            // print the binary number
            result.add(front);

            // generate next two binary numbers and add to queue
            queue.add(front + "0");
            queue.add(front + "1");
        }

        System.out.print("First " + n + " binary numbers: " + result);
    }
}
// Sample Output ->
// Enter a number: 5
// First 5 binary numbers: [1, 10, 11, 100, 101]