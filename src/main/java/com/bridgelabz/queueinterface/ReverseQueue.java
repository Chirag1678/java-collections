package com.bridgelabz.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class to reverse a Queue
public class ReverseQueue {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("Enter elements of Queue: ");
        for(int i=0;i<n;i++) {
            queue.add(input.nextInt());
        }

        // Display the result
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);

        input.close();
    }

    // method to reverse a queue
    public static void reverseQueue(Queue<Integer> queue) {
        if(queue.isEmpty()) return;

        // Remove front element
        int front = queue.remove();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element back to queue
        queue.add(front);
    }
}
// Sample Output ->
// Enter number of elements: 5
// Enter elements of Queue: 1 2 3 4 5
// Original Queue: [1, 2, 3, 4, 5]
// Reversed Queue: [5, 4, 3, 2, 1]