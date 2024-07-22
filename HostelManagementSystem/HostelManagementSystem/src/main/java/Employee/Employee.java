package Employee;

import BasicCredentials.AddressInfo;
import BasicCredentials.BasicCredentials;

public class Employee extends BasicCredentials {

    // Unique identifier for the employee (likely assigned by the system)
    private int employeeID = 0;

    // Job title or position of the employee
    private EmployeePosition employeePosition;

    // Current payment status of the employee (pending, paid, etc.)
    private PayStatus payStatus;

    // Stores information about the employee's pay
    private PayInfo payInfo = new PayInfo();

    /**
     * Constructor to initialize the Employee object
     *
     * @param CNIC The CNIC number of the employee
     * @param firstName The first name of the employee
     * @param lastName The last name of the employee
     * @param address The address information of the employee
     * @param employeePosition The job title or position of the employee
     * @throws IllegalArgumentException Inherited from BasicCredentials constructor
     */
    public Employee(String CNIC, String firstName, String lastName, AddressInfo address, EmployeePosition employeePosition) {
        super(CNIC, firstName, lastName, address);
        this.employeePosition = employeePosition;
        this.payStatus = PayStatus.pending;
        payInfo.setPayPending(employeePosition.getSalary());
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PayStatus payStatus) {
        this.payStatus = payStatus;
    }

    public PayInfo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    /**
     * Pays the employee's salary online
     *
     * @param amount The amount to be paid
     */
    public void paySalaryOnline(double amount) {
        payInfo.setPayPaid(payInfo.getPayPaid() + amount);
        payInfo.setPayPending(payInfo.getPayPending() - amount);
        System.out.println("Salary paid successfully by online.");
        if (payInfo.getPayPending() == 0.0) {
            this.payStatus = PayStatus.paid;
        }
    }

    /**
     * Pays the employee's salary in cash
     *
     * @param amount The amount to be paid
     */
    public void paySalaryCash(double amount) {
        payInfo.setPayPaid(payInfo.getPayPaid() + amount);
        payInfo.setPayPending(payInfo.getPayPending() - amount);
        System.out.println("Salary paid successfully by cash.");
        if (payInfo.getPayPending() == 0.0) {
            this.payStatus = PayStatus.paid;
        }
    }

    /**
     * Updates the employee's salary information (for manual adjustments)
     *
     * @param salaryPaid The total amount paid to the employee so far
     * @param salaryPending The remaining unpaid salary amount
     */
    public void updateSalaryInfo(double salaryPaid, double salaryPending) {
        payInfo.setPayPaid(salaryPaid);
        payInfo.setPayPending(salaryPending);
    }

    /**
     * Displays the employee's current salary information (paid and pending amounts)
     */
    public void displayPayInfo() {
        System.out.println("Salary Paid: " + payInfo.getPayPaid());
        System.out.println("Salary Pending: " + payInfo.getPayPending());
    }

    /**
     * Checks and displays the employee's current pay status (paid or pending)
     */
    public void checkPayStatus() {
        if (payStatus == PayStatus.paid) {
            System.out.println("No pending Salary.");
        } else {
            System.out.println("Pending Salary: " + payInfo.getPayPending());
        }
    }
}