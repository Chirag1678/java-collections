package com.bridgelabz.mapinterface;

import java.util.*;

// Class to maintain a banking system storing and retrieving user accounts
public class BankingSystem {
    public static void main(String[] args) {
        // Create a Scanner and BankingSystem object
        Scanner input = new Scanner(System.in);

        BankingSystem bank = new BankingSystem();

        // loop to take user input
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Request Withdrawal");
            System.out.println("4. Process Withdrawals");
            System.out.println("5. Display Sorted Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = input.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double balance = input.nextDouble();
                    bank.addAccount(accNum, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = input.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = input.nextDouble();
                    bank.deposit(accNum, amount);
                    break;

                case 3:
                    System.out.print("Enter Account Number for Withdrawal: ");
                    accNum = input.nextInt();
                    bank.requestWithdrawal(accNum);
                    break;

                case 4:
                    bank.processWithdrawals();
                    break;

                case 5:
                    bank.displaySortedAccounts();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    // Attributes
    private final HashMap<Integer, Double> accounts;  // Stores customer accounts
    private final Queue<Integer> withdrawalQueue;   // Queue for withdrawal requests

    public BankingSystem() {
        this.accounts = new HashMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    // Add a new customer account
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account " + accountNumber + " added with balance: ₹" + initialBalance);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if(!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        System.out.println("Deposited ₹" + amount + " to account " + accountNumber);
    }

    // Request a withdrawal (added to queue)
    public void requestWithdrawal(int accountNumber) {
        if(!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        withdrawalQueue.offer(accountNumber);
        System.out.println("Withdrawal request added for account " + accountNumber);
    }

    // Process withdrawals (FIFO order)
    public void processWithdrawals() {
        if(withdrawalQueue.isEmpty()) {
            System.out.println("No pending withdrawal requests.");
            return;
        }

        while(!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("🔄 Processing withdrawal for account " + accountNumber);
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for(Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for(Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " -> ₹" + entry.getKey());
        }
    }
}
// Sample Output ->
// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 1
// Enter Account Number: 101
// Enter Initial Balance: 5000
// Account 101 added with balance: ₹5000.0

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 1
// Enter Account Number: 102
// Enter Initial Balance: 8500
// Account 102 added with balance: ₹8500.0

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 2
// Enter Account Number: 101
// Enter Deposit Amount: 2500
// Deposited ₹2500.0 to account 101

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 3
// Enter Account Number for Withdrawal: 101
// Withdrawal request added for account 101

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 4
// 🔄 Processing withdrawal for account 101

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 5

// Accounts Sorted by Balance:
// Account 101 -> ₹7500.0
// Account 102 -> ₹8500.0

// Options:
// 1. Add Account
// 2. Deposit Money
// 3. Request Withdrawal
// 4. Process Withdrawals
// 5. Display Sorted Accounts
// 6. Exit
// Choose an option: 6
// Exiting... Thank you!