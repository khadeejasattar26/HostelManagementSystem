package BasicCredentials;

public class BasicCredentials {

    // Stores the CNIC (Computerized National Identity Card) number of the person
    private String CNIC;

    // Stores the first name of the person
    private String firstName;

    // Stores the last name of the person
    private String lastName;

    // Stores the address information of the person
    private AddressInfo address;

    /**
     * Constructor to initialize the BasicCredentials object
     * @param CNIC The CNIC number of the person (format: XXXXX-XXXXXXX-X)
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param address The address information of the person
     * @throws IllegalArgumentException if CNIC is null or in an invalid format,
     *  or if first/last name is null or contains non-alphabetic characters,
     *  or if address information is null
     */
    public BasicCredentials(String CNIC, String firstName, String lastName, AddressInfo address) {
        setCNIC(CNIC);
        setFirstName(firstName);
        setLastName(lastName);
        setAddressInfo(address);
    }

    public String getCNIC() {
        return CNIC;
    }

    /**
     * Sets the CNIC number of the person. Validates if the input is not null and in the correct format (XXXXX-XXXXXXX-X).
     * @param CNIC The CNIC number of the person
     * @throws IllegalArgumentException if CNIC is null or in an invalid format
     */
    public void setCNIC(String CNIC) {
        if (CNIC != null) {
            String cnicString = String.valueOf(CNIC); // Convert Integer to String (already a String in this case)
            if (cnicString.matches("\\d{5}-\\d{7}-\\d")) {
                this.CNIC = CNIC;
            } else {
                throw new IllegalArgumentException("Error: CNIC number should be in the format XXXXX-XXXXXXX-X");
            }
        } else {
            throw new IllegalArgumentException("Error: CNIC cannot be null");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person. Validates if the input is not null and contains only alphabets.
     * @param firstName The first name of the person
     * @throws IllegalArgumentException if first name is null or contains non-alphabetic characters
     */
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.matches("[a-zA-Z]+")) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Error: First name should contain only alphabets and cannot be null");
        }
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person. Validates if the input is not null and contains only alphabets.
     * @param lastName The last name of the person
     * @throws IllegalArgumentException if last name is null or contains non-alphabetic characters
     */
    public void setLastName(String lastName) {
        if (lastName != null && lastName.matches("[a-zA-Z]+")) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Error: Last name should contain only alphabets and cannot be null");
        }
    }

    public AddressInfo getAddressInfo() {
        return address;
    }

    /**
     * Sets the address information of the person. Validates if the input is not null.
     * @param address The address information of the person
     * @throws IllegalArgumentException if address information is null
     */
    public void setAddressInfo(AddressInfo address) {
        if (address != null) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Error: Address cannot be null");
        }
    }
}
