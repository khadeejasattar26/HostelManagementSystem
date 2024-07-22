package Hostel;

import java.util.ArrayList;
import java.util.List;

// Hostel class representing a hostel with various attributes
public class Hostel {
    // Attributes of the Hostel class
    private int branchID;
    private String manager;
    private double rent;
    private double expenses;
    private double income;
    private String location;

    // Static list to store all hostels
    private static List<Hostel> hostelList = new ArrayList<>();

    // Constructor to initialize a Hostel object
    public Hostel(int branchID, String manager, double rent, double expenses, double income, String location) {
        this.branchID = branchID;
        this.manager = manager;
        this.rent = rent;
        this.expenses = expenses;
        this.income = income;
        this.location = location;
    }

    // Getter and setter methods for branchID
    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    // Getter and setter methods for manager
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    // Getter and setter methods for rent
    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    // Getter and setter methods for expenses
    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    // Getter and setter methods for income
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    // Getter and setter methods for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Method to display hostel information
    public void displayHostelInfo() {
        System.out.println("Hostel Information:");
        System.out.println("Branch ID: " + branchID);
        System.out.println("Manager: " + manager);
        System.out.println("Location: " + location);
        System.out.println("Rent: " + rent);
        System.out.println("Expenses: " + expenses);
        System.out.println("Income: " + income);
    }

    // Static method to add a hostel to the list
    public static void addHostel(Hostel hostel) {
        hostelList.add(hostel);
    }

    // Static method to remove a hostel from the list by branch ID
    public static void removeHostel(int branchID) {
        Hostel hostelToRemove = null;

        // Find the hostel with the given branch ID
        for (Hostel hostel : hostelList) {
            if (hostel.getBranchID() == branchID) {
                hostelToRemove = hostel;
                break;
            }
        }

        // Remove the hostel if found
        if (hostelToRemove != null) {
            hostelList.remove(hostelToRemove);
        }
    }

    // Static method to update hostel information by branch ID
    public static void updateHostel(int branchID, String manager, double rent, double expenses, double income, String location) {
        // Find the hostel with the given branch ID
        for (Hostel hostel : hostelList) {
            if (hostel.getBranchID() == branchID) {
                // Update the hostel's attributes
                hostel.setManager(manager);
                hostel.setRent(rent);
                hostel.setExpenses(expenses);
                hostel.setIncome(income);
                hostel.setLocation(location);
                break;
            }
        }
    }
}
