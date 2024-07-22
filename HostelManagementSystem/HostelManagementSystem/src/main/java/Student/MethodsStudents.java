package Student;

import BasicCredentials.AddressInfo;
import BasicCredentials.ContactInfo;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsStudents
{

    // Initialize a Scanner for input
    static Scanner input = new Scanner(System.in);

    // Initialize an ArrayList to store Student objects
    public static ArrayList<Student> students = new ArrayList<>();

    // Method to add a new student
    public static void addStudent() {
        String cnic;
        String fName;
        String lName;
        int studentID;
        int roomNo;
        RoomType roomType = RoomType.Null;

        int roomtype;
        int streetNumber;
        String area;
        String country;
        String city;
        String lineNumber;
        String email;
        int countryCode;

        // Prompt for student CNIC
        System.out.print("Enter Student CNIC: ");
        cnic = input.nextLine();
        studentID = 0;

        // Prompt for student first name
        System.out.print("Enter Student First Name: ");
        fName = input.nextLine();
        fName = fName.toUpperCase();

        // Prompt for student last name
        System.out.print("Enter Student Last Name: ");
        lName = input.nextLine();
        lName = lName.toUpperCase();

        // Loop to get valid room type
        do {
            System.out.println("Enter Student Room Type.");
            System.out.println("Press 1 for Single Sharing.");
            System.out.println("Enter 2 for Double Sharing.");
            roomtype = input.nextInt();
            if (roomtype == 1) {
                roomType = RoomType.SingleSharing;
            } else if (roomtype == 2) {
                roomType = RoomType.DoubleSharing;
            } else {
                System.out.println("Invalid Choice! Please Re-Enter.");
            }
        } while (roomtype != 1 && roomtype != 2);

        // Prompt for student room number
        System.out.print("Enter Student Room Number: ");
        roomNo = input.nextInt();

        // Prompt for student address information
        System.out.println("Enter Student Address");
        input.nextLine();
        System.out.print("Enter Student Country: ");
        country = input.nextLine().toUpperCase();
        System.out.print("Enter Student City: ");
        city = input.nextLine().toUpperCase();
        System.out.print("Enter Student Area: ");
        area = input.nextLine().toUpperCase();
        System.out.print("Enter Student Street Number: ");
        streetNumber = input.nextInt();

        // Prompt for student contact information
        System.out.println("Enter Student Contact Information");
        System.out.print("Enter Student Country Code: ");
        countryCode = input.nextInt();
        input.nextLine();
        System.out.print("Enter Student Line Number: ");
        lineNumber = input.nextLine().toUpperCase();
        System.out.print("Enter Student email: ");
        email = input.nextLine().toUpperCase();

        // Create ContactInfo and AddressInfo objects
        ContactInfo contact = new ContactInfo(countryCode, lineNumber, email);
        AddressInfo address = new AddressInfo(streetNumber, area, city, country, contact);

        // Create a new Student object and add to the list
        Student student = new Student(cnic, fName, lName, address, studentID, roomNo, roomType);
        students.add(student);

        // Set the student ID based on the index in the list
        student.setStudentID(students.indexOf(student) + 1);
    }

    // Method to remove a student by first name
    public static void removeStudent() {
        String fName;
        System.out.print("Enter first Name of the Student you want to remove: ");
        fName = input.nextLine().toUpperCase();

        // Loop through students and remove the matching student
        for (Student student : students) {
            if (student.getFirstName().equals(fName)) {
                students.remove(student);
                break;
            }
        }
    }

    // Method to search for a student by first name
    public static void searchStudent() {
        String fName;
        int menu;
        System.out.print("Enter first Name of the Student you want to search: ");
        fName = input.nextLine().toUpperCase();

        // Loop through students to find the matching student
        for (Student student : students) {
            if (student.getFirstName().equals(fName)) {
                do {
                    // Display menu options for the student
                    System.out.println("Press 1 to Display Credentials.");
                    System.out.println("Press 2 to Pay Rent by Online Payment.");
                    System.out.println("Press 3 to Pay Rent by Cash Payment.");
                    System.out.println("Press 4 to Update Student Entities.");
                    System.out.print("Enter Your Choice: ");
                    menu = input.nextInt();

                    if (menu == 1) {
                        // Display student credentials
                        System.out.println("Student ID: " + student.getStudentID());
                        System.out.println("Student First Name: " + student.getFirstName());
                        System.out.println("Student Last Name: " + student.getLastName());
                        System.out.println("Student CNIC: " + student.getCNIC());
                        System.out.println("Student Room Number: " + student.getRoomNo());
                        System.out.println("Address Information");
                        System.out.println("Student Country: " + student.getAddressInfo().getCountry());
                        System.out.println("Student City: " + student.getAddressInfo().getCity());
                        System.out.println("Student Area: " + student.getAddressInfo().getArea());
                        System.out.println("Student Street Number: " + student.getAddressInfo().getStreetNumber());
                        System.out.println("Contact Information");
                        System.out.println("Student Country Code: " + student.getAddressInfo().getContactInfo().getCountryCode());
                        System.out.println("Student LineNumber: " + student.getAddressInfo().getContactInfo().getLineNumber());
                        System.out.println("Student Email: " + student.getAddressInfo().getContactInfo().getEmail());
                        System.out.println("Student Rent Status: " + student.getRentStatus());
                        break;
                    } else if (menu == 2) {
                        // Pay rent online
                        double amount;
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        student.payRentOnline(amount);
                        System.out.println("Your Pending Rent is " + student.getRentInfo().getRentPending());
                        break;
                    } else if (menu == 3) {
                        // Pay rent by cash
                        double amount;
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        student.payRentCash(amount);
                        System.out.println("Your Pending Rent is " + student.getRentInfo().getRentPending());
                        break;
                    } else if (menu == 4) {
                        int menu2, menu3;
                        do {
                            // Display menu options to update student entities
                            System.out.println("Press 1 to Upgrade Student Room Type.");
                            System.out.println("Press 2 to Change Room Number.");
                            System.out.print("Enter Your Choice: ");
                            menu2 = input.nextInt();

                            if (menu2 == 1) {
                                do {
                                    // Options to change room type
                                    System.out.println("Press 1 to Upgrade to Single Sharing.");
                                    System.out.println("Press 2 to Degrade to Double Sharing.");
                                    menu3 = input.nextInt();
                                    if (menu3 == 1) {
                                        student.setRoomType(RoomType.SingleSharing);
                                        System.out.println("Room Type successfully changed to Single Sharing.");
                                    } else if (menu3 == 2) {
                                        student.setRoomType(RoomType.DoubleSharing);
                                        System.out.println("Room Type successfully changed to Double Sharing.");
                                    } else {
                                        System.out.println("Invalid Choice! Please Re-Enter.");
                                    }
                                } while (menu3 != 1 && menu3 != 2);
                            } else if (menu2 == 2) {
                                // Option to change room number
                                int roomNo;
                                System.out.print("Student's Current Room Number is " + student.getRoomNo() + ".");
                                System.out.print("Enter Student's New Room Number: ");
                                roomNo = input.nextInt();
                                student.setRoomNo(roomNo);
                                System.out.println("Room Number Changed Successfully.");
                            } else {
                                System.out.println("Invalid Choice! Please Re-Enter.");
                            }
                        } while (menu2 != 1 && menu2 != 2);
                        break;
                    } else {
                        System.out.println("Invalid Choice! Please Re-Enter.");
                    }
                } while (true);
            }
            break;
        }
    }

    // Method to display all students
    public static void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Student First Name: " + student.getFirstName());
            System.out.println("Student Last Name: " + student.getLastName());
            System.out.println("Student CNIC: " + student.getCNIC());
            System.out.println("Student Room Number: " + student.getRoomNo());
            System.out.println("Address Information");
            System.out.println("Student Country: " + student.getAddressInfo().getCountry());
            System.out.println("Student City: " + student.getAddressInfo().getCity());
            System.out.println("Student Area: " + student.getAddressInfo().getArea());
            System.out.println("Student Street Number: " + student.getAddressInfo().getStreetNumber());
            System.out.println("Contact Information");
            System.out.println("Student Country Code: " + student.getAddressInfo().getContactInfo().getCountryCode());
            System.out.println("Student LineNumber: " + student.getAddressInfo().getContactInfo().getLineNumber());
            System.out.println("Student Email: " + student.getAddressInfo().getContactInfo().getEmail());
            System.out.println("Student Rent Status: " + student.getRentStatus());
            System.out.println("Student Rent Pending: " + student.getRentInfo().getRentPending());
            System.out.println("Student Rent Paid: " + student.getRentInfo().getRentPaid());
            System.out.println();
        }
    }

    // Method to display students who have pending rent
    public static void displayDefaulters() {
        for (Student student : students) {
            if (student.getRentStatus().equals(RentStatus.pending)) {
                System.out.println();
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Room Number: " + student.getRoomNo());
                System.out.println("Phone Number: " + student.getAddressInfo().getContactInfo().getCountryCode() + " " + student.getAddressInfo().getContactInfo().getLineNumber());
                System.out.println("Email: " + student.getAddressInfo().getContactInfo().getEmail());
                System.out.println("Room Type: " + student.getRoomType());
                System.out.println("Rent Pending: " + student.getRentInfo().getRentPending());
                System.out.println("Rent Paid: " + student.getRentInfo().getRentPaid());
                System.out.println();
                System.out.println();
            }
        }
    }
}

