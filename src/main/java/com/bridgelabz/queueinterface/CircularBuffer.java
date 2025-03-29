package com.bridgelabz.queueinterface;

import java.util.Scanner;

// Class to maintain a fixed-sized queue of size capacity
public class CircularBuffer {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter buffer size: ");
        int n = input.nextInt();

        // Create an object of CircularBuffer
        CircularBuffer buffer = new CircularBuffer(n);

        // loop to take user input
        while(true) {
            System.out.println("\nCircular Buffer Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = input.nextInt();
                    buffer.insert(value);
                    break;

                case 2:
                    buffer.display();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    // Attributes;
    private final int[] buffer;
    private final int capacity;
    private int front, rear, size;

    // Constructor
    CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
         this.size = 0;
    }

    // insert an element (overwrites the oldest element if full)
    public void insert(int x) {
        buffer[rear] = x;
        rear = (rear+1) % capacity;

        if(size<capacity) {
            size++; // Increase if buffer is not full
        }
        else {
            front = (front+1) % capacity; // overwrites oldest element
        }
    }

    // display queue elements
    public void display() {
        System.out.print("Buffer: [");
        for(int i=0;i<size;i++) {
            System.out.print(buffer[(front+i)%capacity]);
            if(i<size-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
// Sample output ->
// Enter buffer size: 3

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 1
// Enter value to insert: 1

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 1
// Enter value to insert: 2

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 1
// Enter value to insert: 3

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 2
// Buffer: [1, 2, 3]

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 1
// Enter value to insert: 4

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 2
// Buffer: [2, 3, 4]

// Circular Buffer Operations:
// 1. Insert
// 2. Display
// 3. Exit
// Choose an option: 3
// Exiting...