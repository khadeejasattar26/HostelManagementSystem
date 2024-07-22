package Employee;

public class PayInfo {

    // Represents the amount of salary that has been paid to the employee
    private Double payPaid;

    // Represents the amount of salary that is still pending for the employee
    private Double payPending;

    /**
     * Default constructor that initializes both payPaid and payPending to 0.0.
     */
    public PayInfo() {
        this.payPaid = 0.0;
        this.payPending = 0.0;
    }

    /**
     * Getter method to retrieve the amount of salary that has been paid.
     *
     * @return The amount of payPaid.
     */
    public Double getPayPaid() {
        return payPaid;
    }

    /**
     * Setter method to set the amount of salary that has been paid.
     *
     * @param payPaid The amount to be set as payPaid.
     * @throws IllegalArgumentException if the provided payPaid is null or negative.
     */
    public void setPayPaid(Double payPaid) {
        if (payPaid == null || payPaid < 0) {
            throw new IllegalArgumentException("Error: PayPaid must be a non-negative number.");
        }
        this.payPaid = payPaid;
    }

    /**
     * Getter method to retrieve the amount of salary that is still pending.
     *
     * @return The amount of payPending.
     */
    public Double getPayPending() {
        return payPending;
    }

    /**
     * Setter method to set the amount of salary that is still pending.
     *
     * @param payPending The amount to be set as payPending.
     * @throws IllegalArgumentException if the provided payPending is null or negative.
     */
    public void setPayPending(Double payPending) {
        if (payPending == null || payPending < 0) {
            throw new IllegalArgumentException("Error: PayPending must be a non-negative number.");
        }
        this.payPending = payPending;
    }
}
