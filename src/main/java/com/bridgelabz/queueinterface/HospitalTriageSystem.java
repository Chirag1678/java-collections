package com.bridgelabz.queueinterface;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// Class to represent a patient
class Patient {
    // Attributes
    String name;
    int severity;

    // Constructor
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

// Comparator to prioritize patients with higher severity
class Severity implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity); // Descending order
    }
}
// Class to maintain patients and their priority of disease
public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of patients: ");
        int n = input.nextInt();

        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(new Severity());

        // Adding patients to queue
        for(int i=0;i<n;i++) {
            System.out.print("Enter name of Patient: ");
            String s = input.next();
            System.out.print("Enter severity of Patient: ");
            int severity = input.nextInt();

            patientQueue.add(new Patient(s, severity));
        }

        // Displaying patients based on severity
        System.out.println("\n--- Order of Treatment ---");
        while(!patientQueue.isEmpty()) {
            Patient patient = patientQueue.poll();
            System.out.println(patient.name + "| Severity: " + patient.severity);
        }

        input.close();
    }
}
// Sample Output ->
// Enter number of patients: 3
// Enter name of Patient: John
// Enter severity of Patient: 3
// Enter name of Patient: Alice
// Enter severity of Patient: 1
// Enter name of Patient: Bob
// Enter severity of Patient: 2

// --- Order of Treatment ---
// John| Severity: 3
// Bob| Severity: 2
// Alice| Severity: 1