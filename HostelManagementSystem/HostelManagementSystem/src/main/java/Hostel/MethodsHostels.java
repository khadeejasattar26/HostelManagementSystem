package Hostel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodsHostels {

    // Scanner object for user input
    private static final Scanner input = new Scanner(System.in);

    // List to store all hostel objects
    private static final List<Hostel> hostelList = new ArrayList<>();

    /**
     * Prompts user for hostel details and adds a new Hostel object to the list.
     */
    public static void addHostel() {
        System.out.println("Enter Hostel Details:");

        int branchID = 0; // Initialize branch ID to 0 (will be set later)
        input.nextLine(); // Clear any leftover newline character

        System.out.print("Manager: ");
        String manager = input.nextLine().toUpperCase();

        System.out.print("Rent: ");
        double rent = input.nextDouble();

        System.out.print("Expenses: ");
        double expenses = input.nextDouble();

        System.out.print("Income: ");
        double income = input.nextDouble();
        input.nextLine(); // Clear any leftover newline character

        System.out.print("Location: ");
        String location = input.nextLine().toUpperCase();

        // Create a new Hostel object with the entered details
        Hostel hostel = new Hostel(branchID, manager, rent, expenses, income, location);

        // Add the hostel to the list
        hostelList.add(hostel);

        // Set the branch ID based on the index in the list ( + 1 for numbering)
        hostel.setBranchID(hostelList.indexOf(hostel) + 1);
    }

    /**
     * Prompts user for branch ID and removes the corresponding hostel from the list.
     */
    public static void removeHostel() {
        System.out.print("Enter Branch ID of the Hostel you want to remove: ");
        int branchID = input.nextInt();

        // Remove hostel objects with matching branch ID using lambda expression
        hostelList.removeIf(hostel -> hostel.getBranchID() == branchID);
    }

    /**
     * Prompts user for branch ID and allows updating details of the corresponding hostel.
     */
    public static void updateHostel() {
        System.out.print("Enter Branch ID of the Hostel you want to update: ");
        int branchID = input.nextInt();
        input.nextLine(); // Clear any leftover newline character

        for (Hostel hostel : hostelList) {
            if (hostel.getBranchID() == branchID) {
                System.out.println("Enter Updated Details:");

                System.out.print("Manager: ");
                String manager = input.nextLine().toUpperCase();

                System.out.print("Rent: ");
                double rent = input.nextDouble();

                System.out.print("Expenses: ");
                double expenses = input.nextDouble();

                System.out.print("Income: ");
                double income = input.nextDouble();
                input.nextLine(); // Clear any leftover newline character

                System.out.print("Location: ");
                String location = input.nextLine().toUpperCase();

                // Update the hostel details
                hostel.setManager(manager);
                hostel.setRent(rent);
                hostel.setExpenses(expenses);
                hostel.setIncome(income);
                hostel.setLocation(location);

                break; // Exit the loop after updating the first matching hostel
            }
        }
    }

    /**
     * Displays information about all hostels in the list.
     */
    public static void displayAllHostels() {
        System.out.println("All Hostels:");
        for (Hostel hostel : hostelList) {
            hostel.displayHostelInfo();
        }
    }
}
