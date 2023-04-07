public class Customer extends Person { 
    
    // Attributes
    private String username;
    private int customerId;
    private double moneyAvailable;
    private String password;
    private int flightsPurchased;
    private boolean hasMembership;
    private double savings;


    // Constructor 


    /**
     * @param username
     * @param customerId
     * @param moneyAvailable
     * @param role
     * @param password
     * @param firstName
     * @param birthDate
     * @param flightsPurchased
     * @param hasMembership
     * @param lastName
     */
    public Customer(String username, int customerId, double moneyAvailable, String role, String password, String firstName, String birthDate, int flightsPurchased,
            boolean hasMembership, String lastName, double savings){ //Ticket hasTicket
        this.username = username;
        this.customerId = customerId;
        this.moneyAvailable = moneyAvailable;
        this.role = role;
        this.password = password;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.flightsPurchased = flightsPurchased;
        this.hasMembership = hasMembership;
        this.lastName = lastName; 
        this.savings = savings;
        //this.hasTicket = hasTicket;
    }


    /**
     * 
     */
    public Customer(){
        
    }
    

    // Methods
    /**
     * @return
     */
    public int getId() {
        return customerId;
    }
    /**
     * @param id
     */
    public void setId(int id) {
        this.customerId = id;
    }


    /**
     * @return
     */
    public boolean getHasMembership() {
        return hasMembership;
    }
    /**
     * @param hasMembership
     */
    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }


    /**
     * @return
     */
    public double getMoneyAvailable() {
        return moneyAvailable;
    }
    /**
     * @param moneyAvailable
     */
    public void setMoneyAvailable(double moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }


    /**
     * @return
     */
    public int getflightsPurchased() {
        return flightsPurchased;
    }
    /**
     * @param flightsPurchased
     */
    public void setflightsPurchased(int flightsPurchased) {
        this.flightsPurchased = flightsPurchased;
    }


    /**
     * @return
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    
    /**
     * @return
     */
    public double getSavings() {
        return savings;
    }
    /**
     * @param savings
     */
    public void setSavings(double savings) {
        this.savings = savings;
    }

    
/* 
    public void setTicket(Ticket ticket){
        this.hasTicket = ticket;
    }public Ticket getTicket(){
        return hasTicket;
    }
*/


}
