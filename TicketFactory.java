public class TicketFactory {
    /**
     * @param ticketType
     * @return
     */
    public TicketType getTicketType(int ticketType){
        if(ticketType > 3 || ticketType < 1){
            return null;
        }
        
        if(ticketType == 1){
            return new MCticket();
        }

        else if(ticketType == 2){
            return new BCticket();
        }

        else if(ticketType == 3){
            return new FCticket();
        }

        return null;
    }
}
