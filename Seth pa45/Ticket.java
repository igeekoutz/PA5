public class Ticket {
    private double totalPrice;
    private String ticketType;
    private int numSeats;
    private String confirmationNumber;
    private String ID;
    private String userName;
    private boolean active;
    Ticket(){}

    Ticket(double totalPrice, int numSeats, String confirmationNumber, String ID, String userName, String ticketType, boolean active){
        this.totalPrice = totalPrice;
        this.numSeats = numSeats;
        this.confirmationNumber = confirmationNumber;
        this.ID = ID;
        this.userName = userName;
        this.ticketType = ticketType;
        this.active = active;
    }
    public void printTicket(){
        System.out.println("\nHere is your ticket information: \n");
        System.out.println("Ticket is active: " + this.isActive());
        System.out.println("Ticket associated to user: " + this.userName + "\nTickets for Flight Number: " + this.ID + "\nTicket type: " + this.ticketType + "\nNumber of seats purchased: " + this.numSeats + "\nAmount paid: " + this.totalPrice );
        System.out.println();
        }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getNumSeats() {
        return numSeats;
    }
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    public String getConfirmationNumber() {
        return confirmationNumber;
    }
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
    public String getID(){
        return this.ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
