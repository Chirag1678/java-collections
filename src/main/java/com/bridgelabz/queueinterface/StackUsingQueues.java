package com.bridgelabz.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class to implement Stack using queues
public class StackUsingQueues {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Create a stack object
        StackUsingQueues stack = new StackUsingQueues();

        // loop to take user input
        while(true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = input.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    System.out.println("Popped element: " + stack.pop());
                    break;

                case 3:
                    System.out.println("Top element: " + stack.top());
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is Empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");

            }
        }
    }

    // Attributes
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor
    StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // push element into stack
    public void push(int x) {
        q1.add(x);
    }

    // Remove top element from stack
    public int pop() {
        if(q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move elements except the last one from q1 to q2
        while (q1.size()>1) {
            q2.add(q1.remove());
        }

        // last element is the one to pop
        int element = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return element;
    }

    // method to perform peek operation
    public int top() {
        if(q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move elements except the last one from q1 to q2
        while (q1.size()>1) {
            q2.add(q1.remove());
        }

        // Get last element
        int topElement = q1.peek();
        q2.add(q1.remove()); // Put it back in q2

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
// Sample Output ->
// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 1
// Enter value to push: 10

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 3
// Top element: 10

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 1
// Enter value to push: 20

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 2
// Popped element: 20

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 4
// Stack is not empty.

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Top
// 4. Check if Empty
// 5. Exit
// Choose an option: 5
// Exiting...