package Student;

import BasicCredentials.AddressInfo;
import BasicCredentials.BasicCredentials;

public class Student extends BasicCredentials {
    // Private fields for student information
    private Integer studentID;
    private Integer roomNo;
    private RentInfo rentInfo = new RentInfo();
    private RentStatus rentStatus;
    private RoomType roomType;

    // Constructor to initialize a Student object
    public Student(String CNIC, String firstName, String lastName, AddressInfo address, Integer studentID, Integer roomNo, RoomType roomType) {
        super(CNIC, firstName, lastName, address);
        this.studentID = studentID;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.rentStatus = RentStatus.pending;
        rentInfo.setRentPending(roomType.getRent());
    }

    // Getter for rentInfo
    public RentInfo getRentInfo() {
        return rentInfo;
    }

    // Getter for roomType
    public RoomType getRoomType() {
        return roomType;
    }

    // Setter for roomType
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    // Getter for rentStatus
    public RentStatus getRentStatus() {
        return rentStatus;
    }

    // Setter for rentStatus
    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    // Private setter for rentInfo
    private void setRentInfo(RentInfo rentInfo) {
        this.rentInfo = rentInfo;
    }

    // Getter for studentID
    public Integer getStudentID() {
        return studentID;
    }

    // Setter for studentID with validation
    public void setStudentID(Integer studentID) {
        // Validate studentID is not null and is a non-negative number
        if (studentID == null || studentID < 0) {
            throw new IllegalArgumentException("Error: StudentID must be a non-negative number.");
        }
        this.studentID = studentID;
    }

    // Getter for roomNo
    public Integer getRoomNo() {
        return roomNo;
    }

    // Setter for roomNo with validation
    public void setRoomNo(Integer roomNo) {
        // Validate roomNo is not null and is a non-negative number
        if (roomNo == null || roomNo < 0) {
            throw new IllegalArgumentException("Error: RoomNo must be a non-negative number.");
        }
        this.roomNo = roomNo;
    }

    // Method to pay rent online
    public void payRentOnline(double amount) {
        rentInfo.setRentPaid(rentInfo.getRentPaid() + amount);
        rentInfo.setRentPending(rentInfo.getRentPending() - amount);
        System.out.println("Rent paid successfully by online.");
        if (rentInfo.getRentPending() == 0.0) {
            this.rentStatus = RentStatus.paid;
        }
    }

    // Method to pay rent by cash
    public void payRentCash(double amount) {
        rentInfo.setRentPaid(rentInfo.getRentPaid() + amount);
        rentInfo.setRentPending(rentInfo.getRentPending() - amount);
        System.out.println("Rent paid successfully by cash.");
        if (rentInfo.getRentPending() == 0.0) {
            this.rentStatus = RentStatus.paid;
        }
    }

    // Method to update rent information
    public void updateRentInfo(double rentPaid, double rentPending) {
        rentInfo.setRentPaid(rentPaid);
        rentInfo.setRentPending(rentPending);
    }

    // Method to display rent information
    public void displayRentInfo() {
        System.out.println("Rent Paid: " + rentInfo.getRentPaid());
        System.out.println("Rent Pending: " + rentInfo.getRentPending());
    }

    // Method to check rent status
    public void checkRentStatus() {
        if (rentStatus == RentStatus.paid) {
            System.out.println("No pending rent.");
        } else {
            System.out.println("Pending rent: " + rentInfo.getRentPending());
        }
    }

    // Inner class for RentInfo
    public class RentInfo {
        private double rentPaid;
        private double rentPending;

        // Constructor for RentInfo
        public RentInfo() {
            this.rentPaid = 0.0;
            this.rentPending = 0.0;
        }

        // Getter for rentPaid
        public double getRentPaid() {
            return rentPaid;
        }

        // Setter for rentPaid
        public void setRentPaid(double rentPaid) {
            this.rentPaid = rentPaid;
        }

        // Getter for rentPending
        public double getRentPending() {
            return rentPending;
        }

        // Setter for rentPending
        public void setRentPending(double rentPending) {
            this.rentPending = rentPending;
        }
    }
}
