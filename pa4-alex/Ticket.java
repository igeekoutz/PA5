public class Ticket {
    // TODO: Add all the attributes that are needed for writing an electronic ticket
    // that are described in pa4
    // Attributes
    private int confirmationNum;
    private String username;
    private int flightID;
    private int numOfSeats;
    private String classType;
    private double ticketPrice;
    private double maFee;
    private double maSavings;
    private double securityFee;
    private double salesTax;
    private double totalPrice;
    private boolean ticketCancelled;
    private String notes;

    // Constructors
    /**
     * Default constructor
     */
    public Ticket() {

    }

    /**
     * Main constructor to assign all the attributes of the object
     * 
     * @param confirmationNumIn
     * @param usernameIn
     * @param flightIDIn
     * @param numOfSeatsIn
     * @param classTypeIn
     * @param ticketPriceIn
     * @param maFee
     * @param maSavings
     * @param securityFee
     * @param salesTax
     * @param totalPrice
     */
    public Ticket(int confirmationNumIn, String usernameIn, int flightIDIn,
            int numOfSeatsIn, String classTypeIn, double ticketPriceIn, double maFee,
            double maSavings, double securityFee, double salesTax, double totalPrice) {
        this.confirmationNum = confirmationNumIn;
        this.username = usernameIn;
        this.flightID = flightIDIn;
        this.numOfSeats = numOfSeatsIn;
        this.classType = classTypeIn;
        this.ticketPrice = ticketPriceIn;
        this.maFee = maFee;
        this.maSavings = maSavings;
        this.securityFee = securityFee;
        this.salesTax = salesTax;
        this.totalPrice = totalPrice;
        this.ticketCancelled = false;
        this.notes = null;
    }

    /**
     * Prints the information of the ticket
     */
    public void printTicket() {
        System.out.println("\n \tTicket Information" +
                "\n \t-------------------------" +
                "\n User Name: " + this.username +
                "\n Flight ID: " + this.flightID +
                "\n Number of Ticket: " + this.numOfSeats +
                "\n Class: " + this.classType +
                "\n \tFees and Taxes" +
                "\n \t-------------------" +
                "\nTicket Price: $" + ticketPrice +
                "\nMinersAirlines Member Savings: $" + maSavings +
                "\nMinersAirline Fee: $ " + maFee +
                "\nSecurity Fee: $" + securityFee +
                "\nSales Tax: $" + salesTax +
                "\nTotal: $" + totalPrice +
                "\n \t-------------------" +
                "\n Confirmation Number: " + String.format("%07d", this.confirmationNum));
        if (this.notes != null) {
            System.out.println("-----" + this.notes + "-----");
        }
    }

    // Setters and Getters
    /**
     * Returns the username on the ticket
     * 
     * @return String Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes the username in the ticket
     * 
     * @param usernameIn Username In
     */
    public void setUsername(String usernameIn) {
        this.username = usernameIn;
    }

    /**
     * Returns the Flight ID on the ticket
     * 
     * @return int Flight ID
     */
    public int getFlightID() {
        return flightID;
    }

    /**
     * Changes the Flight ID in the ticket
     * 
     * @param flightIDIn Flight ID in
     */
    public void setFlightID(int flightIDIn) {
        this.flightID = flightIDIn;
    }

    /**
     * Returns the number of seats in the ticket
     * 
     * @return int Number of seats
     */
    public int getNumOfSeats() {
        return numOfSeats;
    }

    /**
     * Changes the number of seats on the ticket
     * 
     * @param numOfSeatsIn Number of seats
     */
    public void setNumOfSeats(int numOfSeatsIn) {
        this.numOfSeats = numOfSeatsIn;
    }

    /**
     * Returns the Class type in the ticket
     * 
     * @return String Class Type
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Chanes the class type of the ticket
     * 
     * @param classTypeIn Class Type
     */
    public void setClassType(String classTypeIn) {
        this.classType = classTypeIn;
    }

    /**
     * Returns the confirmation number in the ticket
     * 
     * @return int Confirmation Number
     */
    public int getConfirmationNum() {
        return confirmationNum;
    }

    /**
     * Changes the confirmation number on the ticket
     * 
     * @param confirmationNumIn Confirmation number
     */
    public void setConfirmationNum(int confirmationNumIn) {
        this.confirmationNum = confirmationNumIn;
    }

    /**
     * Returns the note in the ticket
     * 
     * @return String Note
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Changes the note on the ticket
     * 
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns the tickets price
     * 
     * @return double Ticket Price
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * Changes the Ticket price
     * 
     * @param ticketPrice Ticket price
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * Returns the Members Air Fee
     * 
     * @return double Members Air Fee
     */
    public double getMaFee() {
        return maFee;
    }

    /**
     * Changes the Members Air Fee
     * 
     * @param maFee Members Air fee
     */
    public void setMaFee(double maFee) {
        this.maFee = maFee;
    }

    /**
     * Returns the Members Air Savings
     * 
     * @return double Members Air Savings
     */
    public double getMaSavings() {
        return maSavings;
    }

    /**
     * Changes the Members Air Savings on the ticket
     * 
     * @param maSavings Members Air Savings
     */
    public void setMaSavings(double maSavings) {
        this.maSavings = maSavings;
    }

    /**
     * Returns Security Fee
     * 
     * @return double Security Fee
     */
    public double getSecurityFee() {
        return securityFee;
    }

    /**
     * Changes the Security Fee on the ticket
     * 
     * @param securityFee Security Fee
     */
    public void setSecurityFee(double securityFee) {
        this.securityFee = securityFee;
    }

    /**
     * Returns the Sales Tax
     * 
     * @return double Sales Tax
     */
    public double getSalesTax() {
        return salesTax;
    }

    /**
     * Changes the Sales Tax on the ticket
     * 
     * @param salesTax Sales Tax
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * Returns the Total Price
     * 
     * @return double Total Price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Changes the Total price on the ticket
     * 
     * @param totalPrice Total Price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Returns if the ticket has been cancelled
     * 
     * @return boolean if Ticket is cancelled
     */
    public boolean isTicketCancelled() {
        return ticketCancelled;
    }

    /**
     * Changes if the ticket is cancelled
     * 
     * @param ticketCancelled Ticket cancelled
     */
    public void setTicketCancelled(boolean ticketCancelled) {
        this.ticketCancelled = ticketCancelled;
    }
}
