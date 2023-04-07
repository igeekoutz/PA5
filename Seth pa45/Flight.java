/**
 * Flight Class
 * @version 1.0
 * @since 1.0
 */
import java.util.HashMap; 
public class Flight {
    private String ID; 
    private String flightNumber;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private int Duration;
    private int Distance;
    private int timeZoneDifference;
    private String flightType;
    private int surcharge;
    private boolean foodServed;
    private int routeCost;
    private int minerPoints;
    private int totalSeats;
    private int firstClassSeats;
    private int businessClassSeats;
    private int mainCabinSeats;
    private int firstClassPrice;
    private int businessClassPrice;
    private int mainCabinPrice;
    private OriginAirport originAirport;
    private DestinationAirport destinationAirport;
    private HashMap<String, Ticket> allTickets = new HashMap<String, Ticket>();
    private double minerAirlinesFee;
    private double securityFee;
    private double taxCollected;
    private double totalSavings;
    private double currentProfit;

    /**
     * Constructor to create an empty flight object
     */
    Flight(){}

    /*
     * Constructor To Create a Flight Object given parameters
     * 
     */

    Flight(String ID, 
    String flightNumber,
    OriginAirport originAirport,
    DestinationAirport destinationAirport, 
    String departureDate, 
    String departureTime, 
    String arrivalDate, 
    String arrivalTime, 
    int Duration, 
    int Distance, 
    int timeZoneDifference, 
    String flightType, 
    int surcharge, 
    boolean foodServed, 
    int routeCost, 
    int minerPoints, 
    int totalSeats, 
    int firstClassSeats, 
    int businessClassSeats, 
    int mainCabinSeats, 
    int firstClassPrice, 
    int businessClassPrice, 
    int mainCabinPrice
    
    ){

            this.ID = ID;
            this.flightType = flightType;
            this.originAirport = originAirport;
            this.destinationAirport = destinationAirport;
            this.surcharge = surcharge;
            this.foodServed = foodServed;
            this.routeCost = routeCost;
            this.minerPoints = minerPoints;
            this.flightNumber = flightNumber;
            this.departureDate = departureDate;
            this.departureTime = departureTime;
            this.firstClassPrice = firstClassPrice;
            this.businessClassPrice = businessClassPrice;
            this.Duration = Duration;
            this.Distance = Distance;
            this.timeZoneDifference = timeZoneDifference;
            this.arrivalDate = arrivalDate;
            this.arrivalTime = arrivalTime;
            this.totalSeats = totalSeats;
            this.firstClassSeats = firstClassSeats;
            this.businessClassSeats = businessClassSeats;
            this.mainCabinSeats = mainCabinSeats;
            this.mainCabinPrice = mainCabinPrice;

        }
    public void removeProfit(double total){
        this.currentProfit -= total;
    }
    public void addToProfit(double total){
        this.currentProfit += total;
    }
    public double getCurrentProfit() {
        return currentProfit;
    }

    public void setCurrentProfit(double currentProfit) {
        this.currentProfit = currentProfit;
    }

    public void addSecurityFee(double amount){
        this.securityFee += amount;
    }
    public void addTaxes(double amount){
        this.taxCollected += amount;
    }
    public void addMinerAirlinesFee(double amount){
        this.minerAirlinesFee += amount;
    }
    public void addSavings(double amount){
        this.totalSavings += amount;
    }
    public OriginAirport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(OriginAirport originAirport) {
        this.originAirport = originAirport;
    }

    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(DestinationAirport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public double getMinerAirlinesFee() {
        return minerAirlinesFee;
    }

    public void setMinerAirlinesFee(double minerAirlinesFee) {
        this.minerAirlinesFee = minerAirlinesFee;
    }

    public double getSecurityFee() {
        return securityFee;
    }

    public void setSecurityFee(double securityFee) {
        this.securityFee = securityFee;
    }

    public double getTaxCollected() {
        return taxCollected;
    }

    public void setTaxCollected(double taxCollected) {
        this.taxCollected = taxCollected;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public void setMap(HashMap<String, Ticket> allTickets){
        this.allTickets = allTickets;
    }
    public HashMap<String, Ticket> getMap(){
        return this.allTickets;
    }
    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    public boolean isFoodServed() {
        return foodServed;
    }

    public void setFoodServed(boolean foodServed) {
        this.foodServed = foodServed;
    }

    public int getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(int routeCost) {
        this.routeCost = routeCost;
    }

    public int getMinerPoints() {
        return minerPoints;
    }

    public void setMinerPoints(int minerPoints) {
        this.minerPoints = minerPoints;
    }

    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return this.ID;
    }
    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }
    public String getFlightNumber(){
        return this.flightNumber;
    }
    public void setAllTickets(HashMap<String, Ticket> allTickets){
        this.allTickets = allTickets;
    }
    public HashMap<String, Ticket> getAllTickets(){
        return this.allTickets;
    }

    public void setDepatureDate(String date){
        this.departureDate = date;
    }
    public String getDepatureDate(){
        return this.departureDate;
    }

    public void setDepartureTime(String time){
        this.departureTime = time;
    }
    public String getDepartureTime(){
        return this.departureTime;
    }

    public void setFirstClassPrice(int price){
        this.firstClassPrice = price;
    }

    public int getFirstClassPrice(){
        return this.firstClassPrice;
    }
    public void setBusinessClassPrice(int price){
        this.businessClassPrice = price;
    }
    public int getBusinessClassPrice(){
        return this.businessClassPrice;
    }

    public void setDuration(int time){
        this.Duration = time;
    }
    public int getDuration(){
        return this.Duration;
    }

    public void setDistance(int distance){
        this.Distance = distance;
    }

    public int getDistance(){
        return this.Distance;
    }

    public void setTimeZoneDifference(int diff){
        this.timeZoneDifference = diff;
    }

    public int getTimeZoneDifference(){
        return this.timeZoneDifference;
    }
    
    public void setArrivalDate(String date){
        this.arrivalDate = date;
    }

    public String getArrivalDate(){
        return this.arrivalDate;
    }
    public void setArrivalTime(String time){
        this.arrivalTime = time;

    }
    public String getArrivalTime(){
        return this.arrivalTime;
    }
    public void setTotalSeats(int seats){
        this.totalSeats = seats;
    }
    public int getTotalSeats(){
        return this.totalSeats;
    }
    public void setFirstClassSeats(int seats){
        this.firstClassSeats = seats;
    }
    public int getFirstClassSeats(){
        return this.firstClassSeats;
    }
    public void setBusinessClassSeats(int seats){
        this.businessClassSeats = seats;
    }

    public int getBusinessClassSeats(){
        return this.businessClassSeats;
    }
    public void setMainCabinPrice(int price){
        this.mainCabinPrice = price;
    }
    public int getMainCabinPrice(){
        return this.mainCabinPrice;
    }

    public void setMainCabinSeats(int seats){
        this.mainCabinSeats = seats;
    }

    public int getMainCabinSeats(){
        return this.mainCabinSeats;
    }

    public String updateArrivalDate(String dd){ 
        return dd;
      }

    public String updateArrivalTime(String dt, int duration){
        String str = dt.substring(0, 5);
        String amOrPm = dt.substring(5);
        String[] splitStr = str.split(":");
        System.out.println(splitStr);
        String split1 = splitStr[0];
        String split2 = splitStr[1];
        int strToInt1 = Integer.parseInt(split1);
        int strToInt2 = Integer.parseInt(split2);
        int hours = Math.floorDiv(duration, 60);
        int minutes = duration%60;
        strToInt1 += hours;
        strToInt2 += minutes;
        if (Math.floorDiv(strToInt2, 60)>1){
            strToInt1 += Math.floorDiv(strToInt2, 60);
            strToInt2 = strToInt2%60;
        }
        String newTime = strToInt1 + ":" + strToInt2;
        if(strToInt1<10){
            String tempTime = "0" + strToInt1 + ":" + strToInt2;
            newTime = tempTime;
        }
        return newTime + "" + amOrPm;
         
       }

    public void printFlight(){  //Method to print all information pertaining to a particular flight
        System.out.println("Flight ID: " + this.ID);
        System.out.println("Origin Airport" + ": " + this.originAirport.getOriginCode());
        System.out.println("Destination Airport"+ ": " + this.destinationAirport.getDestinationCode());
        System.out.println("Departure Date"+ ": " + this.departureDate);
        System.out.println("Departure Time"+ ": " + this.departureTime);
        System.out.println("Arrival Date"+ ": " + this.arrivalDate);
        System.out.println("Arrival Time"+ ": " + this.arrivalTime );
        System.out.println("Duration"+ ": " + this.Duration);
        System.out.println("Distance"+ ": " + this.Distance);
        System.out.println("Time Zone Difference"+ ": " + this.timeZoneDifference);
        System.out.println("First Class Price"+ ": " + this.firstClassPrice);
        System.out.println("Business Class Price"+ ": " + this.businessClassPrice);
        System.out.println("Main Cabin Price"+ ": " + this.mainCabinPrice);
        System.out.println("First Class Seats"+ ": " + this.firstClassSeats);
        System.out.println("Business Class Seats"+ ": " + this.businessClassSeats);
        System.out.println("Main Cabin Seats"+ ": " + this.mainCabinSeats);
        System.out.println("Total Seats"+ ": " + this.totalSeats);
    }
    public void printTicket(String userName){
        System.out.println("Ticket for flight number: " + allTickets.get(userName).getID());
        System.out.println("Ticket Type: " + allTickets.get(userName).getTicketType());
        System.out.println("Seats Purchased: " + allTickets.get(userName).getNumSeats());
        System.out.println("Ticket Total: " + allTickets.get(userName).getTotalPrice());
        System.out.println();
    }

    public int totalAmountFirstClass(){
        int firstClassTotal = 0;
        for(String key : allTickets.keySet()){
            String ticketType = allTickets.get(key).getTicketType();
            if(ticketType.equals("First Class")){
                firstClassTotal += allTickets.get(key).getTotalPrice();
            }
        }
        return firstClassTotal;
    }

    public int totalAmountBusinessClass(){
        int businessClassTotal = 0;
        for(String key : allTickets.keySet()){
            String ticketType = allTickets.get(key).getTicketType();
            if(ticketType.equals("Business Class")){
                businessClassTotal += allTickets.get(key).getTotalPrice();
            }
        }
        return businessClassTotal;
    }

    public int totalAmountMainCabin(){
        int mainCabinTotal = 0;
        for(String key : allTickets.keySet()){
            String ticketType = allTickets.get(key).getTicketType();
            if(ticketType.equals("Main Cabin")){
                mainCabinTotal += allTickets.get(key).getTotalPrice();
            }
        }
        return mainCabinTotal;
    }

    public void addTicket(Ticket newTicket){
        this.allTickets.put(newTicket.getUserName(), newTicket);
    }
    public boolean checkSeats(String ticketType, int totalTickets,Flight currFlight){
        if(ticketType.equals("First Class")){
            if(totalTickets < currFlight.getFirstClassSeats() ){
                return true;
            }
        }
        if(ticketType.equals("Business Class")){
            if(totalTickets < currFlight.getBusinessClassSeats()){
                return true;
            }
        }
        if(ticketType.equals("Main Cabin")){
            if(totalTickets < currFlight.getMainCabinSeats()){
                return true;
            }
        }
        return false;

    }
    public boolean updateSeats(String ticketType, int totalTickets, Flight currFlight){
        if(ticketType.equals("First Class")){
            int firstClassSeats = currFlight.getFirstClassSeats();
            if(currFlight.checkSeats(ticketType, totalTickets, currFlight)){
                currFlight.setFirstClassSeats(firstClassSeats - totalTickets);
                currFlight.setTotalSeats(currFlight.getTotalSeats()-firstClassSeats);
                return true;
            }
        }
        if(ticketType.equals("Business Class")){
            int BusinessClassSeats = currFlight.getFirstClassSeats();
            if(currFlight.checkSeats(ticketType, totalTickets, currFlight)){
                currFlight.setBusinessClassSeats(BusinessClassSeats - totalTickets);
                currFlight.setTotalSeats(currFlight.getTotalSeats()-firstClassSeats);
                return true;
            }
        }
        if(ticketType.equals("Main Cabin")){
            int mainCabinSeats = currFlight.getFirstClassSeats();
            if(currFlight.checkSeats(ticketType, totalTickets, currFlight)){
                currFlight.setMainCabinSeats(mainCabinSeats - totalTickets);
                currFlight.setTotalSeats(currFlight.getTotalSeats()-firstClassSeats);
                return true;
            }
        } 
        else{
            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
            return false;
        }
        return true;
    }
    public void cancelTickets(){
        for(String key: this.allTickets.keySet()){
            this.allTickets.get(key).setActive(false); 
            removeProfit(this.allTickets.get(key).getTotalPrice());
            this.allTickets.get(key).setTotalPrice(0);       
        }
        System.out.println("Set all tickets on Flight to Inactive / Cancelled");
    }

    public int expectedProfit(){
        int expectedProfit = (this.businessClassSeats*this.businessClassPrice) + (this.firstClassSeats*this.firstClassPrice) + (this.mainCabinSeats*this.mainCabinPrice) ;
        return expectedProfit;
    }
    public void cancelFlightTicket(int ID, String username){
        this.allTickets.get(username).printTicket();
        this.allTickets.get(username).setActive(false);
        removeProfit(this.allTickets.get(username).getTotalPrice());
        addToProfit(9.15);

        System.out.println("Ticket set to inactive inside of tickets for Flight " + ID + " and profits have been updated.\n"); 
    }


}



