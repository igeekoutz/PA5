public class FCticket implements TicketType{

    public double computePrice(int quantity, double seatPrice) {
        //here we are implementing the employee discount
        seatPrice = seatPrice - (seatPrice * 0.5);
        seatPrice = quantity * ((0.0825 * seatPrice) + (seatPrice + 14.75));

        return seatPrice;
    }    

    
}
