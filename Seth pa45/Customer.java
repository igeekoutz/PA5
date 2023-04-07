import java.util.HashMap; 
public class Customer extends Person{
    private String ID;
    private double totalMoney;
    private int flightsPurchased;
    private boolean isTicketMiner;
    private String userName;
    private String password;
    private HashMap<String, Ticket> myTickets = new HashMap<String, Ticket>();

    Customer(){}

    Customer(String ID, String firstName, String lastName, String DOB, String role,  double totalMoney, int flightsPurchased, boolean isTicketMiner, String userName, String password){
        this.ID = ID;
        this.setFirstName(firstName);
        this.setRole(role);
        this.setDOB(DOB);
        this.setLastName(lastName);
        this.totalMoney = totalMoney;
        this.flightsPurchased = flightsPurchased;
        this.isTicketMiner = isTicketMiner;
        this.userName = userName;
        this.password = password;
    }
    public int getFlightsPurchased() {
        return this.flightsPurchased;
    }


    public void setFlightsPurchased(int flightsPurchased) {
        this.flightsPurchased = flightsPurchased;
    }


    public HashMap<String, Ticket> getMyTickets() {
        return this.myTickets;
    }


    public void addTotMyTickets(String key, Ticket ticket) { //this method adds an entry to myTicket hashmap of customer
        this.myTickets.put(key, ticket);
    }


    public String getID() {
        return this.ID;
    }


    public void setID(String iD) {
        this.ID = iD;
    }
    public double getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getConcertsPurchased() {
        return this.flightsPurchased;
    }

    public void setConcertsPurchased(int concertsPurchased) {
        this.flightsPurchased = concertsPurchased;
    }

    public boolean isTicketMiner() {
        return this.isTicketMiner;
    }

    public void setTicketMiner(boolean isTicketMiner) {
        this.isTicketMiner = isTicketMiner;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateMoney(double purchaseTotal){
        this.totalMoney = this.totalMoney - purchaseTotal;
    }
    public void addTicket(Ticket newTicket){
        this.myTickets.put(newTicket.getConfirmationNumber(), newTicket);
    }
    public boolean hasEnoughMoney(double totalPrice){
        if(this.totalMoney > totalPrice){
            return true;
        }
        return false;
    }
    public void printAllTickets(){
        for(String key: this.myTickets.keySet()){
            System.out.println("Ticket for flight number: " + myTickets.get(key).getID());
            System.out.println("Ticket Type: " + myTickets.get(key).getTicketType());
            System.out.println("Seats Purchased: " + myTickets.get(key).getNumSeats());
            System.out.println("Ticket Total: " + myTickets.get(key).getTotalPrice());
            System.out.println("Confirmation Number: " + myTickets.get(key).getConfirmationNumber());
            System.out.println();
       }
    }
    public void cancelCustomerTicket(String ID){
        this.myTickets.get(ID).setActive(false);
        this.totalMoney += this.myTickets.get(ID).getTotalPrice() - 9.15;
        System.out.println("Ticket set to inactive and refunded " + this.myTickets.get(ID).getTotalPrice()); 
    }
    public boolean active(){
        return true;
    }
}
