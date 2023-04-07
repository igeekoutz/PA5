import java.util.HashMap;

public class Customer extends Person {
    // Attributes
    private int id;
    private double moneyAvailable;
    private int flightsPurchased;
    private boolean maMember;
    private String username;
    private String password;
    private HashMap<Integer, Ticket> tickets;
    private double maFeeTotal;
    private double maSavingsTotal;
    private double securityFeeTotal;

    // Constructors
    /**
     * Default constructor
     */
    public Customer() {

    }
    
    /**
     * Main constructor that assigns all the attributes
     * 
     * @param idIn        ID
     * @param firstNameIn Firstname
     * @param lastNameIn  Last name
     * @param dOBIn       Date of birth
     * @param roleIn      Role
     * @param moneyIn     Money
     * @param flightsIn   Flights
     * @param maMemberIn  Miners Air member
     * @param usernameIn  Username
     * @param passwordIn  Password
     */
    public Customer(String idIn, String firstNameIn, String lastNameIn,
            String dOBIn, String roleIn, String moneyIn,
            String flightsIn, String maMemberIn, String usernameIn,
            String passwordIn) {
        super(firstNameIn, lastNameIn, dOBIn, roleIn);
        try {
            this.id = Integer.parseInt(idIn);
            this.moneyAvailable = Double.parseDouble(moneyIn);
            this.flightsPurchased = Integer.parseInt(flightsIn);
            this.maMember = Boolean.parseBoolean(maMemberIn);
            this.username = usernameIn;
            this.password = passwordIn;
        } catch (NumberFormatException n) {
            System.out.print("Error inputting Customer data:\n" + n);
        }
        // Initialize the tickets Array List
        this.tickets = new HashMap<Integer, Ticket>();
    }

    
    /**
     * Adds tickets for the user
     * 
     * @param tickIn Ticket object
     */
    public void addTicket(Ticket tickIn) {
        this.tickets.put(tickIn.getConfirmationNum(), tickIn);
    }

    /**
     * Removes tickets from the user
     * 
     * @param ticketIn Ticket object
     */
    public void removeTicket(Ticket ticketIn) {
        this.tickets.remove(ticketIn.getConfirmationNum());
    }

    /**
     * Increases the money that a user has
     * 
     * @param moneyIn Money
     */
    public void increaseMoneyAvailable(double moneyIn) {
        this.moneyAvailable = this.moneyAvailable + moneyIn;
    }

    /**
     * Decreases the money that a user has
     * 
     * @param moneyUsed Money
     */
    public void decreaseMoneyAvailable(double moneyUsed) {
        this.moneyAvailable = this.moneyAvailable - moneyUsed;
    }

    /**
     * Increases the amount of flight a user purchased
     */
    public void incFlightsPurchased() {
        this.flightsPurchased++;
    }

    /**
     * Decreases the amount of flights a user purchased
     */
    public void decFlightPurchased() {
        this.flightsPurchased--;
    }

    /**
     * Increases the Miners Airline fee payed
     * 
     * @param maFeeIn Miners Airline Fee
     */
    public void incMaFeeTotal(double maFeeIn) {
        this.maFeeTotal += maFeeIn;
    }

    /**
     * Increases the Miners Airline Savings payed
     * 
     * @param maSavingsIn Miners airline savings
     */
    public void incMaSavingsTotal(double maSavingsIn) {
        this.maSavingsTotal += maSavingsIn;
    }

    /**
     * Decreases the Miners airline savings payed
     * 
     * @param maSavings Miners airline savings
     */
    public void decMaSavingsTotal(double maSavings) {
        this.maSavingsTotal -= maSavings;
    }

    /**
     * Increases the security fee payed
     * 
     * @param securityFeeIn Security fee
     */
    public void incSecurityFeeTotal(double securityFeeIn) {
        this.securityFeeTotal += securityFeeIn;
    }

    // Setters & Getters
    /**
     * Returns the ID
     * 
     * @return int ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID
     * 
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the money available
     * 
     * @return double Money available
     */
    public double getMoneyAvailable() {
        return moneyAvailable;
    }

    /**
     * Sets the money available
     * 
     * @param moneyAvailable Money available
     */
    public void setMoneyAvailable(double moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    /**
     * Returns the flights purchased
     * 
     * @return int Flights purchased
     */
    public int getFlightsPurchased() {
        return flightsPurchased;
    }

    /**
     * Sets the flights purchased
     * 
     * @param flightsPurchased Flights purchased
     */
    public void setFlightsPurchased(int flightsPurchased) {
        this.flightsPurchased = flightsPurchased;
    }

    /**
     * Returns if an employee is a Miners airline member
     * 
     * @return boolean Miners airline member
     */
    public boolean isMaMember() {
        return maMember;
    }

    /**
     * Sets if they are a Miners airline member
     * 
     * @param maMember Miners airline member
     */
    public void setMaMember(boolean maMember) {
        this.maMember = maMember;
    }

    /**
     * Returns the username
     * 
     * @return String Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * 
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the Password
     * 
     * @return String Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the Password
     * 
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a list of all the tickets
     * 
     * @return HashMap<Integer, Ticket> List of Tickets
     */
    public HashMap<Integer, Ticket> getTickets() {
        return tickets;
    }

    /**
     * Sets the list of Tickets
     * 
     * @param tickets Tickets
     */
    public void setTickets(HashMap<Integer, Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Returns the Miners airline fee total
     * 
     * @return double Miners airline fee total
     */
    public double getMaFeeTotal() {
        return maFeeTotal;
    }

    /**
     * Sets the Miners airline fee total
     * 
     * @param maFeeTotal Miners airline fee total
     */
    public void setMaFeeTotal(double maFeeTotal) {
        this.maFeeTotal = maFeeTotal;
    }

    /**
     * Returns the Miners airline savings total
     * 
     * @return double Miners airline savings total
     */
    public double getMaSavingsTotal() {
        return maSavingsTotal;
    }

    /**
     * Sets the Miners airline saving total
     * 
     * @param maSavingsTotal Miners airline savings total
     */
    public void setMaSavingsTotal(double maSavingsTotal) {
        this.maSavingsTotal = maSavingsTotal;
    }

    /**
     * Returns the security fee total
     * 
     * @return double Security fee total
     */
    public double getSecurityFeeTotal() {
        return securityFeeTotal;
    }

    /**
     * Sets the security fee total
     * 
     * @param securityFeeTotal Security fee total
     */
    public void setSecurityFeeTotal(double securityFeeTotal) {
        this.securityFeeTotal = securityFeeTotal;
    }

    
}
