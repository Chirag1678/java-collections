package com.bridgelabz.listinterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

// Class to find the nth element from end in a singly linked list
public class NthElementFromEnd {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        LinkedList<Character> list = new LinkedList<>();
        System.out.print("Enter elements of list: ");
        for(int i=0;i<n;i++) {
            list.add(input.next().charAt(0));
        }

        System.out.print("Enter Nth position from back: ");
        int k = input.nextInt();

        // Display the result
        try{
            System.out.printf("The %dth element from back is: %c", k, findNthElement(list, k));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }

    // method t find nth element
    public static int findNthElement(LinkedList<Character> list, int k) {
        // Make two pointers of head
        Iterator<Character> first = list.iterator();
        Iterator<Character> second = list.iterator();

        // loop first till k
        for(int i=0;i<k;i++) {
            if(first.hasNext()) first.next();
            else throw new IllegalArgumentException(k + " is larger than list size");
        }

        // now loop both first and second until first reaches to end
        while(first.hasNext()){
            first.next();
            second.next();
        }

        return second.next();
    }
}
// Sample output ->
// Enter number of elements: 5
// Enter elements of list: A B C D E
// Enter Nth position from back: 2
// The 2th element from back is: D