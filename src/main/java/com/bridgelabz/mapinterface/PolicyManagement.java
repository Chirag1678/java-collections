package com.bridgelabz.mapinterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

// Class to store details about a policy
class InsurancePolicy {
    // Attributes
    private final String policyNumber;
    private final String policyHolderName;
    private final LocalDate expiryDate;
    private final String coverageType;
    private final double premiumAmount;

    // Constructor
    InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // getter methods
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyHolderName() { return policyHolderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    // method to display policy details
    public void displayPolicy() {
        System.out.println("Policy Number: " + policyNumber + " | Name: " + policyHolderName + " | Expiry: " + expiryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " | Coverage: " + coverageType + " | Premium: " + premiumAmount);
    }
}

// Main class to manage policies
public class PolicyManagement {
    // Create objects of different type of maps
    private final Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private final Map<String, InsurancePolicy> policyLinkedMap = new LinkedHashMap<>();
    private final TreeMap<LocalDate, InsurancePolicy> policyTreeMap = new TreeMap<>();

    public static void main(String[] args) {
        // Create Object of Policy management
        PolicyManagement policies = new PolicyManagement();

        // Add policies
        policies.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.of(2022, 12, 31), "Health", 2500));
        policies.addPolicy(new InsurancePolicy("P002", "Jane Doe", LocalDate.of(2022, 11, 30), "Life", 5000));
        policies.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.of(2022, 10, 31), "Health", 3500));
        policies.addPolicy(new InsurancePolicy("P004", "Bob", LocalDate.of(2022, 9, 30), "Vehicle", 4500));

        // Display policies
        policies.displayAllPolicies();

        policies.displayExpiringPolicies();

        policies.displayPoliciesByHolder("Alice");

        policies.removeExpiredPolicies();
    }

    // Method to add policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        policyLinkedMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getExpiryDate(), policy);
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("\n-- All Policies (Unordered) --");
        policyMap.values().forEach(InsurancePolicy::displayPolicy);

        System.out.println("\n-- All Policies (Insertion Order) --");
        policyLinkedMap.values().forEach(InsurancePolicy::displayPolicy);

        System.out.println("\n-- All Policies (Sorted by Expiry Date) --");
        policyTreeMap.values().forEach(InsurancePolicy::displayPolicy);
    }

    // Display policies expiring in the next 30 days
    public void displayExpiringPolicies() {
        System.out.println("\n-- Policies Expiring in 30 Days --");
        LocalDate today = LocalDate.now();
        policyTreeMap.subMap(today, today.plusDays(30)).values().forEach(InsurancePolicy::displayPolicy);
    }

    // Display policies by policyholder name
    public void displayPoliciesByHolder(String name) {
        System.out.println("\n-- Policies for " + name + " --");
        policyMap.values().stream()
                .filter(policy -> policy.getPolicyHolderName().equalsIgnoreCase(name))
                .forEach(InsurancePolicy::displayPolicy);
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policyTreeMap.headMap(today).clear();
        System.out.println("\n-- Expired Policies Removed --");
    }
}
// Sample Output ->
// -- All Policies (Unordered) --
// Policy Number: P004 | Name: Bob | Expiry: 30-09-2022 | Coverage: Vehicle | Premium: 4500.0
// Policy Number: P001 | Name: John Doe | Expiry: 31-12-2022 | Coverage: Health | Premium: 2500.0
// Policy Number: P003 | Name: Alice | Expiry: 31-10-2022 | Coverage: Health | Premium: 3500.0
// Policy Number: P002 | Name: Jane Doe | Expiry: 30-11-2022 | Coverage: Life | Premium: 5000.0

// -- All Policies (Insertion Order) --
// Policy Number: P001 | Name: John Doe | Expiry: 31-12-2022 | Coverage: Health | Premium: 2500.0
// Policy Number: P002 | Name: Jane Doe | Expiry: 30-11-2022 | Coverage: Life | Premium: 5000.0
// Policy Number: P003 | Name: Alice | Expiry: 31-10-2022 | Coverage: Health | Premium: 3500.0
// Policy Number: P004 | Name: Bob | Expiry: 30-09-2022 | Coverage: Vehicle | Premium: 4500.0

// -- All Policies (Sorted by Expiry Date) --
// Policy Number: P004 | Name: Bob | Expiry: 30-09-2022 | Coverage: Vehicle | Premium: 4500.0
// Policy Number: P003 | Name: Alice | Expiry: 31-10-2022 | Coverage: Health | Premium: 3500.0
// Policy Number: P002 | Name: Jane Doe | Expiry: 30-11-2022 | Coverage: Life | Premium: 5000.0
// Policy Number: P001 | Name: John Doe | Expiry: 31-12-2022 | Coverage: Health | Premium: 2500.0

// -- Policies Expiring in 30 Days --

// -- Policies for Alice --
// Policy Number: P003 | Name: Alice | Expiry: 31-10-2022 | Coverage: Health | Premium: 3500.0

// -- Expired Policies Removed --