package Expense;

import Employee.Employee;
import Employee.MethodsEmployee;
import Employee.PayStatus;

import java.util.Scanner;

import java.util.Scanner;

public class Expense
{

    // Static variables to track total expenses, paid expenses, and pending expenses (protected for inheritance)
    protected static double totalExpenses;
    protected static double expensesPaid;
    protected static double expensesPending;

    // Instance variables for each expense object
    private int expenseID;
    private String expenseType;
    private double expenseAmount;

    // Constructor to initialize an Expense object
    public Expense(int expenseID, String expenseType, double expenseAmount) {
        setExpenseID(expenseID);
        setExpenseAmount(expenseAmount);
        setExpenseType(expenseType);
    }

    // Getters and setters for expense ID, type, and amount
    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    // Getter for total expenses (may be overridden in subclasses)
    public double getTotalExpenses() {
        return totalExpenses;
    }

    // Setter for total expenses (may be overridden in subclasses)
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    // Static method to calculate expected total salary expense based on employee salaries (protected for inheritance)
    protected static double calExpectedExpense() {
        totalExpenses = 0.0; // Reset total expenses before calculation
        for (Employee employee : MethodsEmployee.employees) {
            totalExpenses += employee.getEmployeePosition().getSalary();
        }
        return totalExpenses;
    }

    // Static method to calculate total pending salary expense (protected for inheritance)
    protected static double calExpensesPending() {
        expensesPending = 0.0; // Reset pending expenses before calculation
        for (Employee employee : MethodsEmployee.employees) {
            if (employee.getPayStatus().equals(PayStatus.pending)) {
                expensesPending += employee.getPayInfo().getPayPending();
            }
        }
        return expensesPending;
    }

    // Static method to calculate total paid salary expense (protected for inheritance)
    protected static double calExpensePaid()
    {
        expensesPaid = 0.0; // Reset paid expenses before calculation
        for (Employee employee : MethodsEmployee.employees) {
            if (employee.getPayInfo().getPayPaid() != 0) {
                expensesPaid += employee.getPayInfo().getPayPaid();
            }
        }
        return expensesPaid;
    }
}
