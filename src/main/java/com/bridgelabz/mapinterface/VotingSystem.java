package com.bridgelabz.mapinterface;

import java.util.*;

// Class to make a voting system
public class VotingSystem {
    public static void main(String[] args) {
        // Create a Scanner Object and VotingSystem object
        Scanner input = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        // loop to take user input
        while(true) {
            System.out.println("\nOptions: ");
            System.out.println("1. Cast Vote");
            System.out.println("2. Display Results");
            System.out.println("3. Display Vote Order");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidate = input.nextLine().trim();
                    votingSystem.castVote(candidate);
                    System.out.println("Vote casted for " + candidate);
                    break;
                case 2:
                    votingSystem.displayResults();
                    break;
                case 3:
                    votingSystem.displayVoteOrder();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for voting!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Attributes
    private final Map<String, Integer> voteMap;  // Stores Candidate -> Votes
    private final LinkedHashMap<String, Integer> voteOrder; // Maintains vote order

    public VotingSystem() {
        this.voteMap = new HashMap<>();
        this.voteOrder = new LinkedHashMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));  // Maintain vote order
    }

    // Display results sorted by votes (Descending order)
    public void displayResults() {
        // Sort using a LinkedHashMap to avoid duplicate removal issues in TreeMap
        LinkedHashMap<String, Integer> sortedVotes = new LinkedHashMap<>();
        voteMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Descending sort
                .forEachOrdered(entry -> sortedVotes.put(entry.getKey(), entry.getValue()));

        System.out.println("\nVoting Results (Sorted by Votes):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display the order in which votes were cast
    public void displayVoteOrder() {
        System.out.println("\nVote Order (Chronological):");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}
// Sample output ->
// Options: 
// 1. Cast Vote
// 2. Display Results
// 3. Display Vote Order
// 4. Exit
// Choose an option: 1
// Enter candidate name: Amit
// Vote casted for Amit

// Options: 
// 1. Cast Vote
// 2. Display Results
// 3. Display Vote Order
// 4. Exit
// Choose an option: 1
// Enter candidate name: Bhanu
// Vote casted for Bhanu

// Options: 
// 1. Cast Vote
// 2. Display Results
// 3. Display Vote Order
// 4. Exit
// Choose an option: 2

// Voting Results (Sorted by Votes):
// Bhanu -> 1 votes
// Amit -> 1 votes

// Options: 
// 1. Cast Vote
// 2. Display Results
// 3. Display Vote Order
// 4. Exit
// Choose an option: 3

// Vote Order (Chronological):
// Amit -> 1 votes
// Bhanu -> 1 votes

// Options: 
// 1. Cast Vote
// 2. Display Results
// 3. Display Vote Order
// 4. Exit
// Choose an option: 4
// Exiting... Thank you for voting!