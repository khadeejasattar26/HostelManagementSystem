package BasicCredentials;

public class AddressInfo {

    // Stores the street number of the address
    private Integer streetNumber;

    // Stores the area name of the address
    private String area;

    // Stores the city name of the address
    private String city;

    // Stores the country name of the address
    private String country;

    // Stores contact information associated with the address
    private ContactInfo contactInfo;

    /**
     * Constructor to initialize the AddressInfo object
     * @param streetNumber The street number of the address
     * @param area The area name of the address
     * @param city The city name of the address
     * @param country The country name of the address
     * @param contactInfo The contact information associated with the address
     * @throws IllegalArgumentException if street number is invalid or
     *  city/country names contain non-alphabetic characters or contact info is not an 11-digit number
     */
    public AddressInfo(Integer streetNumber, String area, String city, String country, ContactInfo contactInfo) {
        setStreetNumber(streetNumber);
        setArea(area);
        setCity(city);
        setCountry(country);
        setContactInfo(contactInfo);
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the street number of the address. Validates if the input is a number.
     * @param streetNumber The street number of the address
     * @throws IllegalArgumentException if the street number is not a valid number
     */
    public void setStreetNumber(Integer streetNumber) {
        if (String.valueOf(streetNumber).matches("\\d+")) {
            this.streetNumber = streetNumber;
        } else {
            System.out.println("Error: Street number should be a valid number");
            throw new IllegalArgumentException("Error: Street number should be a valid number");
        }
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    /**
     * Sets the city name of the address. Validates if the input contains only alphabets.
     * @param city The city name of the address
     * @throws IllegalArgumentException if the city name contains non-alphabetic characters
     */
    public void setCity(String city) {
        if (city.matches("[a-zA-Z]+")) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("Error: City name should contain only alphabets");
        }
    }

    public String getCountry() {
        return country;
    }

    /**
     * Sets the country name of the address. Validates if the input contains only alphabets.
     * @param country The country name of the address
     * @throws IllegalArgumentException if the country name contains non-alphabetic characters
     */
    public void setCountry(String country) {

        if (country.matches("[a-zA-Z]+")) {
            this.country = country;
        } else {
            throw new IllegalArgumentException("Error: Country name should contain only alphabets");
        }
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {

        this.contactInfo = contactInfo;
    }
}
