public abstract class Person {
    // Attributes
    private String firstName;
    private String lastName;
    private String DOB;
    private String role;

    // Constructors

    /**
     * Default constructor
     */
    public Person() {

    }

    /**
     * Main constructor that assigns all the attributes
     * 
     * @param firstNameIn First name
     * @param lastNameIn  Last Name
     * @param dobIn       Date of Birth
     * @param roleIn      Role of User
     */
    public Person(String firstNameIn, String lastNameIn, String dobIn, String roleIn) {
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.DOB = dobIn;
        this.role = roleIn;
    }

    // Setters

    /**
     * Sets the First name
     * 
     * @param firstName First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name
     * 
     * @param lastName Last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth
     * 
     * @param dOB Date of birth
     */
    public void setDOB(String dOB) {
        DOB = dOB;
    }

    /**
     * Sets the role
     * 
     * @param role Role
     */
    public void setRole(String role) {
        this.role = role;
    }

    // Getters

    /**
     * Returns the first name
     * 
     * @return String First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name
     * 
     * @return String Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the date of birth
     * 
     * @return String Date of birth
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * Returns the role
     * 
     * @return String Role
     */
    public String getRole() {
        return role;
    }
}
