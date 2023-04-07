import java.lang.Math;

public class Ticket{
    private int confirmationNumber;
    private double totalPrice;
    private int quantity;
    private int TicketFlightID;
    private boolean isCanceled;
   // security fee that is applied to every ticket
    

    //Constructor
    public Ticket(double totalPrice, int quantity, int confirmnum, int TicketFlightID, boolean isCanceled){
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.confirmationNumber = confirmnum;
        this.TicketFlightID = TicketFlightID;
        this.isCanceled = isCanceled;
    }
    public Ticket(){

    }
   
    //Methods
    
    //this generates a random number from 1 to 100
    public int setconfirmationNumber(){
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        
        for(int i = 0; i < 100; i++){
            confirmationNumber = (int)(Math.random() * range) + min;
            break;
        }
        
        return confirmationNumber;

    }

    public String printData(){

        String data = (
        "\t--RECEIPT--\n\t" 
        +  "TICKET #" + this.confirmationNumber 
        + "\n\tQUANTITY: " + this.quantity 
        + "\n\tTOTAL PRICE: " + this.totalPrice
        + "\n\tFLIGHT: " + this.TicketFlightID
        );

        return data;
    }

    public void settotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }public double gettotalPrice(){
        return totalPrice; // we return the value with the fees
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }public int getQuantity(){
        return quantity;
    }

    public int getTicketFlightID(){
        return this.TicketFlightID;
    }public void setTicketFlightID(int flightID){
        this.TicketFlightID = flightID;
    }
    
    public boolean getCanceled() {
        return isCanceled;
    }public void setCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }
    
    




}
