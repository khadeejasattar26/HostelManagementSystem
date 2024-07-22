package RunProgram;

// Importing necessary classes
import Employee.MethodsEmployee;
import Expense.MethodsExpense;
import Hostel.MethodsHostels;
import Student.MethodsStudents;
import Income.Income;
import java.util.Scanner;

// Main class to run the program
public class Run {

    // Main method
    public static void main(String[] args) {
        // Initializing scanner object for user input
        Scanner input = new Scanner(System.in);
        int menu, menu2 = 0;

        // Main menu loop
        do {
            // Displaying main menu options
            System.out.println("\nPress 1 to Choose Hostels.");
            System.out.println("Press 2 to Choose Students.");
            System.out.println("Press 3 to Choose Employees.");
            System.out.println("Press 4 to Choose Income.");
            System.out.println("Press 5 to Choose Expense.");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();

            // Switch statement to handle main menu choices
            switch (menu) {
                case 1:
                    hostelsFunctions(input, menu2);
                    continue;
                case 2:
                    studentsFunctions(input, menu2);
                    continue;
                case 3:
                    employeesFunctions(input, menu2);
                    continue;
                case 4:
                    incomeFunctions();
                    continue;
                case 5:
                    expenseFunctions(input, menu2);
                    continue;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menu != 0);
    }

    // Function to handle hostel-related operations
    public static void hostelsFunctions(Scanner input, int menu) {
        // Hostel menu loop
        do {
            // Displaying hostel menu options
            System.out.println("\nPress 1 to Add Hostel");
            System.out.println("Press 2 to Remove Hostel");
            System.out.println("Press 3 to Update Hostel");
            System.out.println("Press 4 Display All Hostels");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();

            // Switch statement to handle hostel menu choices
            switch (menu) {
                case 1:
                    MethodsHostels.addHostel();
                    continue;
                case 2:
                    MethodsHostels.removeHostel();
                    continue;
                case 3:
                    MethodsHostels.updateHostel();
                    continue;
                case 4:
                    MethodsHostels.displayAllHostels();
                    continue;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menu != 0);
    }

    // Function to handle student-related operations
    public static void studentsFunctions(Scanner input, int menu) {
        // Student menu loop
        do {
            // Displaying student menu options
            System.out.println("\nPress 1 to Add Student.");
            System.out.println("Press 2 to Remove Student.");
            System.out.println("Press 3 to Search Student.");
            System.out.println("Press 4 Display All Students.");
            System.out.println("Press 5 Display Defaulters.");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();

            // Switch statement to handle student menu choices
            switch (menu) {
                case 1:
                    MethodsStudents.addStudent();
                    continue;
                case 2:
                    MethodsStudents.removeStudent();
                    continue;
                case 3:
                    MethodsStudents.searchStudent();
                    continue;
                case 4:
                    MethodsStudents.displayAllStudents();
                    continue;
                case 5:
                    MethodsStudents.displayDefaulters();
                    continue;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menu != 0);
    }

    // Function to handle employee-related operations
    public static void employeesFunctions(Scanner input, int menu) {
        // Employee menu loop
        do {
            // Displaying employee menu options
            System.out.println("\nPress 1 to Add Employee.");
            System.out.println("Press 2 to Remove Employee.");
            System.out.println("Press 3 to Search Employee.");
            System.out.println("Press 4 Display All Employees.");
            System.out.println("Press 5 Display Unpaid Employees.");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();

            // Switch statement to handle employee menu choices
            switch (menu) {
                case 1:
                    MethodsEmployee.addEmployee();
                    continue;
                case 2:
                    MethodsEmployee.removeEmployee();
                    continue;
                case 3:
                    MethodsEmployee.searchEmployee();
                    continue;
                case 4:
                    MethodsEmployee.displayAllEmployees();
                    continue;
                case 5:
                    MethodsEmployee.displayEmployeesWithPendingSalary();
                    continue;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menu != 0);
    }

    // Function to display income-related information
    public static void incomeFunctions() {
        // Displaying income-related information
        Income.displayExpectedIncome();
        Income.displayRentReceived();
        Income.displayRentPending();
    }

    // Function to handle expense-related operations
    public static void expenseFunctions(Scanner input, int menu) {
        // Expense menu loop
        do {
            // Displaying expense menu options
            System.out.println("\nPress 1 to Add Custom Expense.");
            System.out.println("Press 2 to Remove Custom Expense.");
            System.out.println("Press 3 to Update Custom Expense.");
            System.out.println("Press 4 Display All Expenses.");
            System.out.println("Press 5 Display Custom Expenses.");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();
            // Switch statement to handle expense menu choices
            switch (menu)
            {
                case 1:
                    MethodsExpense.addExpense();
                    continue;
                case 2:
                    MethodsExpense.removeExpense();
                    continue;
                case 3:
                    MethodsExpense.updateExpense();
                    continue;
                case 4:
                    MethodsExpense.displayExpenses();
                    continue;
                case 5:
                    MethodsExpense.displayCustomExpenses();
                    continue;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menu != 0);
    }
}
