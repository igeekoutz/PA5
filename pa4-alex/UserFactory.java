public class UserFactory {
    private int idCol;
    private int firstNameCol;
    private int lastNameCol;
    private int dobCol;
    private int roleCol;
    private int usernameCol;
    private int passwordCol;
    private int moneyAvailableCol;
    private int flightsPurchasedCol;
    private int maMemberCol;

    /**
     * Default constructor
     */
    public UserFactory() {

    }

    /**
     * Assigns the cols from the header
     * 
     * @param headerLine Strin array of headers
     * @return Integer Role column
     * @throws HeaderException If a header isn't in the predefined attributes
     */
    public Integer assignCols(String[] headerLine) throws HeaderException {

        for (int i = 0; i < headerLine.length; i++) {
            switch (headerLine[i]) {
                case "ID":
                    this.idCol = i;
                    break;
                case "First Name":
                    this.firstNameCol = i;
                    break;
                case "Last Name":
                    this.lastNameCol = i;
                    break;
                case "DOB":
                    this.dobCol = i;
                    break;
                case "Role":
                    this.roleCol = i;
                    break;
                case "Username":
                    this.usernameCol = i;
                    break;
                case "Password":
                    this.passwordCol = i;
                    break;
                case "Money Available":
                    this.moneyAvailableCol = i;
                    break;
                case "Flights Purchased":
                    this.flightsPurchasedCol = i;
                    break;
                case "MinerAirlines Membership":
                    this.maMemberCol = i;
                    break;
                default:
                    throw new HeaderException("Header not handeled " + headerLine[i]);
            }
        }

        return this.roleCol;
    }

    /**
     * Create a customer object using the column attributes
     * 
     * @param line String array with customer information
     * @return Customer New customer object
     */
    public Customer createCustomer(String[] line) {
        Customer newCustomer = new Customer(line[idCol], line[firstNameCol], line[lastNameCol], line[dobCol],
                line[roleCol], line[moneyAvailableCol], line[flightsPurchasedCol], line[maMemberCol], line[usernameCol],
                line[passwordCol]);

        return newCustomer;
    }

    /**
     * Create an employee object using the column attributes
     * 
     * @param line String array with employee information 
     * @return Employee New employee object
     */
    public Employee creatEmployee(String[] line) {
        Employee newEmployee = new Employee(line[idCol], line[firstNameCol], line[lastNameCol], line[dobCol],
                line[roleCol], line[moneyAvailableCol], line[flightsPurchasedCol], line[maMemberCol], line[usernameCol],
                line[passwordCol]);

        return newEmployee;
    }

    // Getters and setters

    /**
     * Returns the id col
     * 
     * @return int ID col
     */
    public int getIdCol() {
        return idCol;
    }

    /**
     * Sets the id col
     * 
     * @param idCol ID col
     */
    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    /**
     * Returns the First name col
     * 
     * @return int First name col
     */
    public int getFirstNameCol() {
        return firstNameCol;
    }

    /**
     * Sets the first name col
     * 
     * @param firstNameCol First name col
     */
    public void setFirstNameCol(int firstNameCol) {
        this.firstNameCol = firstNameCol;
    }

    /**
     * Returns the last name col
     * 
     * @return int Last name col
     */
    public int getLastNameCol() {
        return lastNameCol;
    }

    /**
     * Sets the last name col
     * 
     * @param lastNameCol Last name col
     */
    public void setLastNameCol(int lastNameCol) {
        this.lastNameCol = lastNameCol;
    }

    /**
     * Return the date of birth col
     * 
     * @return int Date of birth col
     */
    public int getDobCol() {
        return dobCol;
    }

    /**
     * Sets the date of birth col
     * 
     * @param dobCol Date of birth col
     */
    public void setDobCol(int dobCol) {
        this.dobCol = dobCol;
    }

    /**
     * Returns the role col
     * 
     * @return int Role col
     */
    public int getRoleCol() {
        return roleCol;
    }

    
    /**
     * Sets the role col
     * 
     * @param roleCol Role col
     */
    public void setRoleCol(int roleCol) {
        this.roleCol = roleCol;
    }

    /**
     * Returns the username col
     * 
     * @return int Username col
     */
    public int getUsernameCol() {
        return usernameCol;
    }

    /**
     * Sets the username col
     * 
     * @param usernameCol Username col
     */
    public void setUsernameCol(int usernameCol) {
        this.usernameCol = usernameCol;
    }

    /**
     * Returns the password col
     * 
     * @return int Password col
     */
    public int getPasswordCol() {
        return passwordCol;
    }

    /**
     * Sets the password col
     * 
     * @param passwordCol Password col
     */
    public void setPasswordCol(int passwordCol) {
        this.passwordCol = passwordCol;
    }

    /**
     * Return the money available col
     * 
     * @return int Money available col
     */
    public int getMoneyAvailableCol() {
        return moneyAvailableCol;
    }

    /**
     * Sets the money available col
     * 
     * @param moneyAvailableCol Money available col
     */
    public void setMoneyAvailableCol(int moneyAvailableCol) {
        this.moneyAvailableCol = moneyAvailableCol;
    }

    /**
     * Returns the flights purchased col
     * 
     * @return int Flights pruchased col
     */
    public int getFlightsPurchasedCol() {
        return flightsPurchasedCol;
    }

    /**
     * Sets the flights purchased col
     * 
     * @param flightsPurchasedCol Flights purchased col
     */
    public void setFlightsPurchasedCol(int flightsPurchasedCol) {
        this.flightsPurchasedCol = flightsPurchasedCol;
    }

    /**
     * return the Miners Member col
     * 
     * @return int Miners member col
     */
    public int getMaMemberCol() {
        return maMemberCol;
    }

    /**
     * Sets the Miners member col
     * 
     * @param maMemberCol Miners member col
     */
    public void setMaMemberCol(int maMemberCol) {
        this.maMemberCol = maMemberCol;
    }

}
