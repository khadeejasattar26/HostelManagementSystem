package Employee;

public enum EmployeePosition {

    // Administrative staff position with a salary of 20000.0
    ADMIN(20000.0),

    // Worker position with a salary of 15000.0
    WORKER(15000.0),

    // Guard position with a salary of 15000.0
    GUARD(15000.0),

    // Placeholder for invalid or unassigned positions (salary set to 0.0)
    NULL(0.0);

    private final Double salary; // Use final since it's assigned in constructor

    EmployeePosition(Double salary) {
        if (salary == null) {
            throw new IllegalArgumentException("Error: Salary cannot be null.");
        }
        // Validate salary is a non-negative number
        if (salary < 0) {
            throw new IllegalArgumentException("Error: Salary must be a non-negative number.");
        }
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
