package BasicCredentials;

public class ContactInfo {

    // Stores the country code associated with the phone number (optional)
    private Integer countryCode;

    // Stores the phone line number
    private String lineNumber;

    // Stores the email address
    private String email;

    /**
     * Constructor to initialize the ContactInfo object
     *
     * @param countryCode The country code associated with the phone number (optional)
     * @param lineNumber The phone line number
     * @param email The email address
     * @throws IllegalArgumentException if line number contains non-numeric characters
     */
    public ContactInfo(Integer countryCode, String lineNumber, String email) {
        setCountryCode(countryCode);
        setLineNumber(lineNumber);
        setEmail(email);
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code associated with the phone number. Allows null value (optional).
     * Validates if the input is a number when provided.
     *
     * @param countryCode The country code associated with the phone number
     * @throws IllegalArgumentException if country code is provided and not a number
     */
    public void setCountryCode(Integer countryCode) {

        if (countryCode == null || String.valueOf(countryCode).matches("\\d+")) {
            this.countryCode = countryCode;
        } else {

            throw new IllegalArgumentException("Error: Country code should be a valid number");
        }
    }

    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the phone line number. Validates if the input contains only digits.
     *
     * @param lineNumber The phone line number
     * @throws IllegalArgumentException if line number contains non-numeric characters
     */
    public void setLineNumber(String lineNumber) {

        if (lineNumber == null || lineNumber.matches("\\d+")) {
            this.lineNumber = lineNumber;
        } else {
            throw new IllegalArgumentException("Error: Line number should contain only numbers");
        }
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address. No validation performed on email format in this implementation.
     *
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
