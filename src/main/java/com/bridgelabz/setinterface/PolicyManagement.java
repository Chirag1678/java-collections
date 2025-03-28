package com.bridgelabz.setinterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Class to store details about a policy
class InsurancePolicy implements Comparable<InsurancePolicy> {
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

    // getter methods for policy number, expiry date and coverage type
    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    // Equals & HashCode to ensure uniqueness in Sets based on policyNumber
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare policies based on expiry date for TreeSet
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // method to display policy details
    public void displayPolicy() {
        System.out.println("Policy Number: " + policyNumber + "| Name: " + policyHolderName + "| Expiry: " + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(expiryDate) + "| Coverage: " + coverageType + "| Premium: " + premiumAmount);
    }
}

// Main class to manage different type of policies
public class PolicyManagement {
    // Create set of different type of policies
    private final Set<InsurancePolicy> policyHashSet = new HashSet<>();
    private final Set<InsurancePolicy> policyLinkedHashSet = new LinkedHashSet<>();
    private final Set<InsurancePolicy> policyTreeSet = new TreeSet<>();

    // main method to test policy management
    public static void main(String[] args) {
        // Create an object of PolicyManagement
        PolicyManagement polices = new PolicyManagement();

        // Adding polices to object
        polices.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.of(2022, 12, 31), "Health", 2500));
        polices.addPolicy(new InsurancePolicy("P002", "Jane Doe", LocalDate.of(2022, 11, 30), "Life", 5000));
        polices.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.of(2022, 10, 31), "Health", 3500));
        polices.addPolicy(new InsurancePolicy("P004", "Bob", LocalDate.of(2022, 9, 30), "Vehicle", 4500));

        // display all policies
        polices.displayAllPolicies();

        // display policies expiring in next 30 days
        polices.displayExpiringPolicies();

        // display policies by coverage type
        polices.displayByCoverageType("Vehicle");

        // display duplicate policies
        polices.displayDuplicatePolicies();

        // Compare performance of different sets
        polices.comparePerformance();
    }

    // method to add policy to all sets
    public void addPolicy(InsurancePolicy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }

    // method to retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("\n-- All Policies (Using HashSet -> Unique and unordered) --");
        policyHashSet.forEach(InsurancePolicy::displayPolicy);

        System.out.println("\n-- All Policies (Using LinkedHashSet -> Preserve insertion order) --");
        policyLinkedHashSet.forEach(InsurancePolicy::displayPolicy);

        System.out.println("\n-- All Policies (Using TreeSet -> Sorted by expiry date) --");
        policyTreeSet.forEach(InsurancePolicy::displayPolicy);
    }

    // method to retrieve policies expiring in next 30 days
    public void displayExpiringPolicies() {
        System.out.println("\n--Policies expiring in 30 days --");
        LocalDate date = LocalDate.now();

        policyTreeSet.stream()
                .filter(policy -> policy.getExpiryDate().isBefore(date.plusDays(30)))
                .forEach(InsurancePolicy::displayPolicy);
    }

    // Method to retrieve policies by coverage type
    public void displayByCoverageType(String coverageType) {
        System.out.println("\n-- Policies with Coverage Type: " + coverageType + " --");
        policyHashSet.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(InsurancePolicy::displayPolicy);
    }

    // method to find duplicate policies based on policy number
    public void displayDuplicatePolicies() {
        Set<String> uniquePolicies = new HashSet<>();
        policyHashSet.stream()
                .filter(policy -> !uniquePolicies.add(policy.getPolicyNumber()))
                .forEach(InsurancePolicy::displayPolicy);
    }

    // Compare performance of different sets
    public void comparePerformance() {
        int numPolicies = 15000;
        List<InsurancePolicy> testingPolicies = new ArrayList<>();

        // Generate random policies for testing
        for(int i=0;i<numPolicies;i++) {
            testingPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now(), "Health", 2500));
        }

        long startTime, endTime;

        // Hashset Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> hashSet = new HashSet<>(testingPolicies);
        endTime = System.nanoTime();
        System.out.println("\nHashSet - Insertion Time: " + ((endTime - startTime) / 1e6) + " ms");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>(testingPolicies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet - Insertion Time: " + ((endTime - startTime) / 1e6) + " ms");

        // TreeSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> treeSet = new TreeSet<>(testingPolicies);
        endTime = System.nanoTime();
        System.out.println("TreeSet - Insertion Time: " + ((endTime - startTime) / 1e6) + " ms");
    }
}
// Sample Output ->
// -- All Policies (Using HashSet -> Unique and unordered) --
// Policy Number: P002| Name: Jane Doe| Expiry: 30-11-2022| Coverage: Life| Premium: 5000.0
// Policy Number: P001| Name: John Doe| Expiry: 31-12-2022| Coverage: Health| Premium: 2500.0
// Policy Number: P004| Name: Bob| Expiry: 30-09-2022| Coverage: Vehicle| Premium: 4500.0
// Policy Number: P003| Name: Alice| Expiry: 31-10-2022| Coverage: Health| Premium: 3500.0

// -- All Policies (Using LinkedHashSet -> Preserve insertion order) --
// Policy Number: P001| Name: John Doe| Expiry: 31-12-2022| Coverage: Health| Premium: 2500.0
// Policy Number: P002| Name: Jane Doe| Expiry: 30-11-2022| Coverage: Life| Premium: 5000.0
// Policy Number: P003| Name: Alice| Expiry: 31-10-2022| Coverage: Health| Premium: 3500.0
// Policy Number: P004| Name: Bob| Expiry: 30-09-2022| Coverage: Vehicle| Premium: 4500.0

// -- All Policies (Using TreeSet -> Sorted by expiry date) --
// Policy Number: P004| Name: Bob| Expiry: 30-09-2022| Coverage: Vehicle| Premium: 4500.0
// Policy Number: P003| Name: Alice| Expiry: 31-10-2022| Coverage: Health| Premium: 3500.0
// Policy Number: P002| Name: Jane Doe| Expiry: 30-11-2022| Coverage: Life| Premium: 5000.0
// Policy Number: P001| Name: John Doe| Expiry: 31-12-2022| Coverage: Health| Premium: 2500.0

// --Policies expiring in 30 days --
// Policy Number: P004| Name: Bob| Expiry: 30-09-2022| Coverage: Vehicle| Premium: 4500.0
// Policy Number: P003| Name: Alice| Expiry: 31-10-2022| Coverage: Health| Premium: 3500.0
// Policy Number: P002| Name: Jane Doe| Expiry: 30-11-2022| Coverage: Life| Premium: 5000.0
// Policy Number: P001| Name: John Doe| Expiry: 31-12-2022| Coverage: Health| Premium: 2500.0

// -- Policies with Coverage Type: Vehicle --
// Policy Number: P004| Name: Bob| Expiry: 30-09-2022| Coverage: Vehicle| Premium: 4500.0

// HashSet - Insertion Time: 2.573291 ms
// LinkedHashSet - Insertion Time: 1.859541 ms
// TreeSet - Insertion Time: 1.763792 ms