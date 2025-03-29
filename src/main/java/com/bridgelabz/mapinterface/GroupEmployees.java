package com.bridgelabz.mapinterface;

import java.util.*;

// Class to store employee details and department
class Employee {
    String name;
    String department;

    // Constructor
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // method to display employee details
    @Override
    public String toString() {
        return name; // Display only employee name
    }
}

// Main class to group employees by their department
public class GroupEmployees {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // List to store employee objects
        List<Employee> employees = new ArrayList<>();

        // Taking user input for employees
        System.out.println("Enter employee details (type 'exit' as name to stop):");
        while(true) {
            System.out.print("Enter Employee Name: ");
            String name = input.next();

            if(name.equalsIgnoreCase("exit")) {
                break; // Stop input
            }

            System.out.print("Enter Department: ");
            String department = input.next();

            employees.add(new Employee(name, department)); // Add employee to list
        }

        // Group employees by department
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Display grouped employees
        System.out.println("\nEmployees Grouped by Department:");
        for(Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        input.close();
    }

    // Function to group employees by department
    private static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for(Employee emp : employees) {
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return departmentMap;
    }
}
// Sample Output ->
// Enter employee details (type 'exit' as name to stop):
// Enter Employee Name: Amit
// Enter Department: Finance
// Enter Employee Name: Smith
// Enter Department: HR
// Enter Employee Name: John
// Enter Department: Finance
// Enter Employee Name: exit

// Employees Grouped by Department:
// Finance: [Amit, John]
// HR: [Smith]