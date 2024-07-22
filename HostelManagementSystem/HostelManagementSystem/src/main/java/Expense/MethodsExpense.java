package Expense;

import java.util.Scanner;
import java.util.ArrayList;

// MethodsExpense class extends the Expense class
public class MethodsExpense extends Expense {

    // Constructor for MethodsExpense, calls the superclass constructor
    public MethodsExpense(int expenseID, String expenseType, double expenseAmount) {
        super(expenseID, expenseType, expenseAmount);
    }

    // Initialize a Scanner for input
    static Scanner input = new Scanner(System.in);

    // Initialize an ArrayList to store Expense objects
    static ArrayList<Expense> expenses = new ArrayList<>();

    // Method to add a new expense
    public static void addExpense() {
        int expenseID = 0;
        String expenseType;
        double expenseAmount;

        // Prompt for expense amount
        System.out.print("Enter Expense Amount: ");
        expenseAmount = input.nextDouble();
        input.nextLine(); // Consume newline

        // Prompt for expense type
        System.out.print("Enter Expense Type: ");
        expenseType = input.nextLine().toUpperCase();

        // Create a new Expense object and add to the list
        Expense expense = new Expense(expenseID, expenseType, expenseAmount);
        expenses.add(expense);

        // Set the expense ID based on the index in the list
        expense.setExpenseID(expenses.indexOf(expense) + 1);
    }

    // Method to remove an expense by expense ID
    public static void removeExpense() {
        System.out.print("Enter Expense ID of the Custom Expense you want to remove: ");
        int branchID = input.nextInt();

        // Loop through expenses and remove the matching expense
        for (Expense expense : expenses) {
            if (expense.getExpenseID() == branchID) {
                expenses.remove(expense);
                break;
            }
        }
    }

    // Method to update an expense by expense ID
    public static void updateExpense() {
        System.out.print("Enter Branch ID of the Custom Expense you want to update: ");
        int branchID = input.nextInt();
        input.nextLine(); // Consume newline

        // Loop through expenses to find the matching expense
        for (Expense expense : expenses) {
            if (expense.getExpenseID() == branchID) {
                int menu;
                do {
                    // Display menu options to update the expense
                    System.out.println("\nPress 1 to Update Expense Type.");
                    System.out.println("Press 2 to Update Expense Amount.");
                    System.out.println("Press 0 to Exit.");
                    System.out.print("Enter your choice: ");
                    menu = input.nextInt();
                    input.nextLine(); // Consume newline

                    if (menu == 1) {
                        // Update expense type
                        System.out.print("Enter Expense Type: ");
                        String expenseType = input.nextLine().toUpperCase();
                        expense.setExpenseType(expenseType);
                        break;
                    } else if (menu == 2) {
                        // Update expense amount
                        System.out.print("Enter Expense Amount: ");
                        double expenseAmount = input.nextDouble();
                        expense.setExpenseAmount(expenseAmount);
                        break;
                    } else if (menu == 0) {
                        // Exit the menu
                        System.out.println("Exiting...");
                        break;
                    } else {
                        // Handle invalid choice
                        System.out.println("Invalid choice. Please try again.");
                    }
                } while (true);
                break;
            }
        }
    }

    // Method to display various expense summaries
    public static void displayExpenses() {
        System.out.println("Total Salary Expenses: " + calExpectedExpense());
        System.out.println("Salaries Paid: " + calExpensePaid());
        System.out.println("Salaries Pending: " + calExpensesPending());
        System.out.println("Total Custom Expenses: " + calCustomExpenses());
        System.out.println("Overall Expenses: " + (calExpensesPending() + calCustomExpenses()));
    }

    // Method to display all custom expenses
    public static void displayCustomExpenses() {
        for (Expense expense : expenses) {
            System.out.println("Expense ID: " + expense.getExpenseID());
            System.out.println("Expense Type: " + expense.getExpenseType());
            System.out.println("Expense Amount: " + expense.getExpenseAmount());
        }
    }

    // Private method to calculate the total custom expenses
    private static double calCustomExpenses() {
        double customExpenses = 0.0;
        // Sum up the amount of each expense
        for (Expense expense : expenses) {
            customExpenses += expense.getExpenseAmount();
        }
        return customExpenses;
    }
}
