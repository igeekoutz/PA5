import java.util.HashSet;

public class Airport {
    private String name;
    private String code;
    private String city;
    private String state;
    private String country;
    private double fee;
    private boolean hasLounge;
    private double totalFees;
    private HashSet<String> origFlights;
    private HashSet<String> destFlights;

    /**
     * Default constructor
     */
    public Airport() {

    }

    /**
     * Main constructor that assigns all the attributes
     * 
     * @param name      Name
     * @param code      Code
     * @param city      City
     * @param state     State
     * @param country   Country
     * @param fee       Fee
     * @param hasLounge Has Lounge
     */
    public Airport(String name, String code, String city, String state, String country, String fee,
            String hasLounge) {
        try {
            this.name = name;
            this.code = code;
            this.city = city;
            this.state = state;
            this.country = country;
            this.fee = Double.parseDouble(fee);
            this.hasLounge = Boolean.parseBoolean(hasLounge);
        } catch (NumberFormatException e) {
            System.out.println("Error inputting data for Airport " + e);
        }
        this.origFlights = new HashSet<String>();
        this.destFlights = new HashSet<String>();
    }

    /**
     * Adds the flight id that this airport is an origin for
     * 
     * @param idIn Flight ID
     */
    public void addOrigFlight(String idIn) {
        this.origFlights.add(idIn);
    }

    /**
     * Adds the flight id that his airport is a destination for
     * 
     * @param idIn Flight ID
     */
    public void addDestFlight(String idIn) {
        this.destFlights.add(idIn);
    }

    /**
     * Prints the infromation of the aiprort
     */
    public void printAirport() {
        System.out.println("\n \tAirport Information" +
                "\n \t-------------------" +
                "\n -Name: " + this.name +
                "\n -Code: " + this.code +
                "\n -City: " + this.city +
                "\n -State: " + this.state +
                "\n -Country: " + this.country +
                "\n -Fee: $" + this.fee +
                "\n -Has Lounge: " + this.hasLounge +
                "\n -Fees Earned: $" + this.totalFees);
    }

    /**
     * Increases the total fee the airport has made
     */
    public void incFee() {
        this.totalFees = this.totalFees + this.fee;
    }

    /**
     * Decreasees the total fee the airpot has made
     */
    public void decFee() {
        this.totalFees = this.totalFees - this.fee;
    }

    /**
     * Returns the name
     * 
     * @return String Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * 
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the code
     * 
     * @return String Code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code
     * 
     * @param code Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the city
     * 
     * @return String City
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city
     * 
     * @param city City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state
     * 
     * @return String State
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state
     * 
     * @param state State
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the country
     * 
     * @return String Country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country
     * 
     * @param country Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Returns the Fee
     * 
     * @return double Fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * Sets the Fee
     * 
     * @param fee Fee
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * Returns if it has a lounge
     * 
     * @return boolean Has a lounge
     */
    public boolean hasLounge() {
        return hasLounge;
    }

    /**
     * Sets if it has a lounge
     * 
     * @param hasLounge Has a lounge
     */
    public void setHasLounge(boolean hasLounge) {
        this.hasLounge = hasLounge;
    }

    /**
     * Returns the list of flight id's that this airport is the origin of
     * 
     * @return HashSet of flight id's
     */
    public HashSet<String> getOrigFlights() {
        return origFlights;
    }

    /**
     * Sets the list of flight id's that this airport is the origin of
     * 
     * @param origFlights Hashset of Strings
     */
    public void setOrigFlights(HashSet<String> origFlights) {
        this.origFlights = origFlights;
    }

    /**
     * Returns the list of flight id's that this airport is the destination of
     * 
     * @return HashSet of flight id's
     */
    public HashSet<String> getDestFlights() {
        return destFlights;
    }

    /**
     * Sets the list of flight id's that this airport is the destination of
     */
    public void setDestFlights(HashSet<String> destFlights) {
        this.destFlights = destFlights;
    }

    /**
     * Returns the total amount of money the airport has made off of fees
     * 
     * @return Total money from fees
     */
    public double getTotalFees() {
        return totalFees;
    }

    /**
     * Sets the total amount of money an airport has made off of fees
     * 
     * @param totalFees Total money from fees
     */
    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

}
