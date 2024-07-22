package Income;

import Student.Student;
import Student.MethodsStudents; // Assuming this class manages the student list
import Student.RentStatus;
import Student.RoomType; // Assuming this class defines room types and rent

public class Income {

    // Stores the total expected income across all students
    private static double totalExpectedIncome = 0;

    // Stores the total rent received across all students
    private static double totalRentReceived = 0;

    // Stores the total rent pending across all students with pending rent
    private static double totalRentPending = 0;

    /**
     * Calculates the total expected income by iterating through all students
     * and summing their room rent.
     *
     * @return The total expected income.
     */
    private static double calculateExpectedRent() {
        totalExpectedIncome = 0; // Reset total before recalculating
        for (Student student : MethodsStudents.students) {
            totalExpectedIncome += student.getRoomType().getRent();
        }
        return totalExpectedIncome;
    }

    /**
     * Calculates the total rent pending by iterating through all students
     * and summing the rent pending for students with pending rent status.
     *
     * @return The total rent pending.
     */
    private static double calculateRentPending() {
        totalRentPending = 0; // Reset total before recalculating
        for (Student student : MethodsStudents.students) {
            if (student.getRentStatus() == RentStatus.pending) {
                totalRentPending += student.getRentInfo().getRentPending();
            }
        }
        return totalRentPending;
    }

    /**
     * Calculates the total rent received by iterating through all students
     * and summing the rent paid for students with non-zero pending rent.
     *
     * @return The total rent received.
     */
    private static double calculateRentReceived() {
        totalRentReceived = 0; // Reset total before recalculating
        for (Student student : MethodsStudents.students) {
            if (student.getRentInfo().getRentPending() != 0) {
                totalRentReceived += student.getRentInfo().getRentPaid();
            }
        }
        return totalRentReceived;
    }

    /**
     * Displays the total expected income on the console.
     */
    public static void displayExpectedIncome() {
        System.out.println("Total Expected Income: " + calculateExpectedRent());
    }

    /**
     * Displays the total rent pending on the console.
     */
    public static void displayRentPending() {
        System.out.println("Total Rent Pending: " + calculateRentPending());
    }

    /**
     * Displays the total rent received on the console.
     */
    public static void displayRentReceived() {
        System.out.println("Total Rent Paid: " + calculateRentReceived());
    }
}
