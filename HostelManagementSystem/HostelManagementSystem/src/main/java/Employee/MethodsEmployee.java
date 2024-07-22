package Employee;

import BasicCredentials.AddressInfo;
import BasicCredentials.ContactInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodsEmployee {
    // List to store all employees
    public static ArrayList<Employee> employees = new ArrayList<>();
    // Scanner for user input
    static Scanner input = new Scanner(System.in);

    // Method to add a new employee
    public static void addEmployee() {
        String cnic;
        String fName;
        String lName;
        EmployeePosition employeePosition = EmployeePosition.NULL;
        int position;

        // Getting employee's CNIC
        System.out.print("Enter Employee CNIC: ");
        cnic = input.nextLine();

        // Getting employee's first name and converting to uppercase
        System.out.print("Enter Employee First Name: ");
        fName = input.nextLine();
        fName = fName.toUpperCase();

        // Getting employee's last name and converting to uppercase
        System.out.print("Enter Employee Last Name: ");
        lName = input.nextLine();
        lName = lName.toUpperCase();

        // Getting employee's position through user input
        do {
            System.out.println("Choose Employee Position. ");
            System.out.println("Press 1 for Admin Post. ");
            System.out.println("Press 2 for Worker Post. ");
            System.out.println("Press 3 for Guard Post. ");
            System.out.println("Press 0 to Exit.");
            System.out.print("Enter Your Choice: ");
            position = input.nextInt();

            // Setting position based on user choice
            if (position == 1) {
                employeePosition = EmployeePosition.ADMIN;
                break;
            } else if (position == 2) {
                employeePosition = EmployeePosition.WORKER;
                break;
            } else if (position == 3) {
                employeePosition = EmployeePosition.GUARD;
                break;
            } else if (position == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Choice! Please Re-Enter.");
            }
        } while (position != 1 && position != 2 && position != 3);

        // Getting employee's address information
        AddressInfo address = getAddressInfo(input);

        // Creating new employee object and adding to the list
        Employee employee = new Employee(cnic, fName, lName, address, employeePosition);
        employees.add(employee);
        // Setting employee ID
        employee.setEmployeeID(employees.indexOf(employee) + 1);
    }

    // Method to remove an employee
    public static void removeEmployee() {
        System.out.print("Enter first Name of the Employee you want to remove: ");
        String fName = input.nextLine().toUpperCase();

        // Searching and removing the employee by first name
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(fName)) {
                employees.remove(employee);
                break;
            }
        }
    }

    // Method to search for an employee
    public static void searchEmployee() {
        String fName;
        int menu;

        // Getting the first name to search
        System.out.print("Enter first Name of the Employee you want to search: ");
        fName = input.nextLine();
        fName = fName.toUpperCase();

        // Searching for the employee
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(fName)) {
                // Displaying menu for employee actions
                do {
                    System.out.println("Press 1 to Display Credentials.");
                    System.out.println("Press 2 to Pay Rent by Online Payment.");
                    System.out.println("Press 3 to Pay Rent by Cash Payment.");
                    System.out.println("Press 4 to promote/demote Employee.");
                    System.out.println("Press 0 to Exit.");
                    System.out.print("Enter Your Choice: ");
                    menu = input.nextInt();

                    if (menu == 1) {
                        // Displaying employee credentials
                        System.out.println("Employee CNIC: " + employee.getCNIC());
                        System.out.println("Employee First Name: " + employee.getFirstName());
                        System.out.println("Employee Last Name: " + employee.getLastName());
                        System.out.println("Employee Position: " + employee.getEmployeePosition());
                        System.out.println("Employee Salary: " + employee.getEmployeePosition().getSalary());
                        System.out.println("Address Information:");
                        System.out.println("Employee Country: " + employee.getAddressInfo().getCountry());
                        System.out.println("Employee City: " + employee.getAddressInfo().getCity());
                        System.out.println("Employee Area: " + employee.getAddressInfo().getArea());
                        System.out.println("Employee Street Number: " + employee.getAddressInfo().getStreetNumber());
                        System.out.println("Contact Information:");
                        System.out.println("Employee Country Code: " + employee.getAddressInfo().getContactInfo().getCountryCode());
                        System.out.println("Employee LineNumber: " + employee.getAddressInfo().getContactInfo().getLineNumber());
                        System.out.println("Employee Email: " + employee.getAddressInfo().getContactInfo().getEmail());
                        break;
                    } else if (menu == 2) {
                        // Paying salary online
                        double amount;
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        employee.paySalaryOnline(amount);
                        System.out.println("Pending Salary of " + employee.getFirstName() + " " + employee.getLastName() + " is " + employee.getPayInfo().getPayPending());
                        break;
                    } else if (menu == 3) {
                        // Paying salary by cash
                        double amount;
                        System.out.print("Enter Amount: ");
                        amount = input.nextDouble();
                        employee.paySalaryCash(amount);
                        System.out.println("Pending Salary of " + employee.getFirstName() + " " + employee.getLastName() + " is " + employee.getPayInfo().getPayPending());
                        break;
                    } else if (menu == 4) {
                        // Promoting or demoting an employee
                        int menu2;
                        if (employee.getEmployeePosition().equals(EmployeePosition.WORKER))
                            System.out.println("Press 1 to Upgrade to Admin Post.");
                        else if (employee.getEmployeePosition().equals(EmployeePosition.ADMIN))
                            System.out.println("Press 2 to Degrade to Worker.");
                        System.out.print("Enter Choice: ");
                        menu2 = input.nextInt();
                        do {
                            if (menu2 == 1) {
                                employee.setEmployeePosition(EmployeePosition.ADMIN);
                                System.out.println("Employee successfully Promoted to Admin Post.");
                            } else if (menu2 == 2) {
                                employee.setEmployeePosition(EmployeePosition.WORKER);
                                System.out.println("Employee successfully Demoted to Worker Post.");
                            } else {
                                System.out.println("Invalid Choice! Please Re-Enter.");
                            }
                        } while (menu2 != 1 && menu2 != 2);
                        break;
                    } else if (menu == 0) {
                        // Exiting the menu
                        System.out.println("Exiting...");
                        break;
                    } else {
                        // Invalid choice handling
                        System.out.println("Invalid Choice! Please Re-Enter.");
                    }
                } while (true);
            }
            break;
        }
        input.nextLine();
    }

    // Method to display all employees
    public static void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println("Employee CNIC: " + employee.getCNIC());
            System.out.println("Employee First Name: " + employee.getFirstName());
            System.out.println("Employee Last Name: " + employee.getLastName());
            System.out.println("Employee Position: " + employee.getEmployeePosition());
            System.out.println("Employee Salary: " + employee.getEmployeePosition().getSalary());
            System.out.println("Address Information:");
            System.out.println("Employee Country: " + employee.getAddressInfo().getCountry());
            System.out.println("Employee City: " + employee.getAddressInfo().getCity());
            System.out.println("Employee Area: " + employee.getAddressInfo().getArea());
            System.out.println("Employee Street Number: " + employee.getAddressInfo().getStreetNumber());
            System.out.println("Contact Information:");
            System.out.println("Employee Country Code: " + employee.getAddressInfo().getContactInfo().getCountryCode());
            System.out.println("Employee LineNumber: " + employee.getAddressInfo().getContactInfo().getLineNumber());
            System.out.println("Employee Email: " + employee.getAddressInfo().getContactInfo().getEmail());
            System.out.println();
        }
    }

    // Method to display employees with pending salary
    public static void displayEmployeesWithPendingSalary() {
        for (Employee employee : employees) {
            if (employee.getPayStatus().equals(PayStatus.pending)) {
                System.out.println();
                System.out.println("Employee ID: " + employee.getEmployeeID());
                System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Phone Number: " + employee.getAddressInfo().getContactInfo().getCountryCode() + " " + employee.getAddressInfo().getContactInfo().getLineNumber());
                System.out.println("Email: " + employee.getAddressInfo().getContactInfo().getEmail());
                System.out.println("Salary Pending: " + employee.getPayInfo().getPayPending());
                System.out.println("Salary Paid: " + employee.getPayInfo().getPayPaid());
                System.out.println();
                System.out.println();
            }
        }
    }

    // Private method to get address information from user input
    private static AddressInfo getAddressInfo(Scanner input) {
        int streetNumber;
        String area;
        String country;
        String city;
        String lineNumber;
        String email;
        int countryCode;

        // Getting address details
        System.out.println("Enter Employee Address");
        input.nextLine();
        System.out.print("Enter Employee Country: ");
        country = input.nextLine().toUpperCase();
        System.out.print("Enter Employee City: ");
        city = input.nextLine().toUpperCase();
        System.out.print("Enter Employee Area: ");
        area = input.nextLine().toUpperCase();
        System.out.print("Enter Employee Street Number: ");
        streetNumber = input.nextInt();

        // Getting contact information
        System.out.println("Enter Employee Contact Information");
        System.out.print("Enter Employee Country Code: ");
        countryCode = input.nextInt();
        System.out.print("Enter Employee Line Number: ");
        lineNumber = input.nextLine().toUpperCase();
        lineNumber = input.nextLine().toUpperCase();
        System.out.print("Enter Employee Email: ");
        email = input.nextLine().toUpperCase();

        // Creating contact and address objects
        ContactInfo contact = new ContactInfo(countryCode, lineNumber, email);
        AddressInfo address = new AddressInfo(streetNumber, area, city, country, contact);
        return address;
    }
}
