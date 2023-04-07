import java.util.HashMap; 
public class Employee extends Person{

    private String ID;
    private double totalMoney;
    private int flightsPurchased;
    private boolean isTicketMiner;
    private String userName;
    private String password;
    private HashMap<String, Ticket> myTickets = new HashMap<String, Ticket>();

    Employee(){}

    Employee(String ID, String firstName, String lastName, String DOB, String role,  double totalMoney, int flightsPurchased, boolean isTicketMiner, String userName, String password){
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
    public HashMap<String, Ticket> getMyTickets() {
        return this.myTickets;
    }


    public void addTotMyTickets(String key, Ticket ticket) { //this method adds an entry to myTicket hashmap of customer
        this.myTickets.put(key, ticket);
    }

    public boolean hasEnoughMoney(double totalPrice){
        if(this.totalMoney > totalPrice){
            return true;
        }
        return false;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getFlightsPurchased() {
        return flightsPurchased;
    }

    public void setFlightsPurchased(int flightsPurchased) {
        this.flightsPurchased = flightsPurchased;
    }

    public boolean isTicketMiner() {
        return isTicketMiner;
    }

    public void setTicketMiner(boolean isTicketMiner) {
        this.isTicketMiner = isTicketMiner;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void addTicket(Ticket newTicket){
        this.myTickets.put(newTicket.getID(), newTicket);
    }
    public boolean active(){
        return true;
    }
    
}
