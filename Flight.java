public class Flight extends Ticket{

    //Atributes
    private String flightType;
    private String arrivalDate;
    private int mcSeats;
    private int flightNum;
    private String destinationCode;
    private String originAirport;
    private int minerPoints;
    private String originCode;
    private int bcPrice;
    private double mcPrice;
    private String departTime;
    private int duration;
    private int surcharge;
    private Boolean originAirportLounge;
    private int distance;
    private int timezoneDiff;
    private String arrivalTime;
    private String departDate;
    private String originAirportState;
    private String originAirportCountry;
    private double originAirportFee;
    private String destinationAirportCity;
    private Boolean foodServed;
    private String destinationAirportState;
    private String destinationAirportCountry;
    private double destinationAirportFee;
    private Boolean destinationAirportLounge;
    private int routeCost;
    private int totalSeats;
    private int id;
    private int fcSeats;
    private String destinationAirport;
    private int bcSeats;
    private String originAirportCity;
    private int fcPrice;
    private double fees;
    private double profits;
     

    //Constructor 
    public Flight(String flightType, String arrivalDate, int mcSeats, int flightNum, String destinationCode,
            String originAirport, int minerPoints, String originCode, int bcPrice, double mcPrice, String departTime,
            int duration, int surcharge, Boolean originAirportLounge, int distance, int timezoneDiff,
            String arrivalTime, String departDate, String originAirportState, String originAirportCountry,
            double originAirportFee, String destinationAirportCity, Boolean foodServed, String destinationAirportState,
            String destinationAirportCountry, double destinationAirportFee, Boolean destinationAirportLounge,
            int routeCost, int totalSeats, int id, int fcSeats, String destinationAirport, int bcSeats,
            String originAirportCity, int fcPrice, double fees) {
        
        this.flightType = flightType;
        this.arrivalDate = arrivalDate;
        this.mcSeats = mcSeats;
        this.flightNum = flightNum;
        this.destinationCode = destinationCode;
        this.originAirport = originAirport;
        this.minerPoints = minerPoints;
        this.originCode = originCode;
        this.bcPrice = bcPrice;
        this.mcPrice = mcPrice;
        this.departTime = departTime;
        this.duration = duration;
        this.surcharge = surcharge;
        this.originAirportLounge = originAirportLounge;
        this.distance = distance;
        this.timezoneDiff = timezoneDiff;
        this.arrivalTime = arrivalTime;
        this.departDate = departDate;
        this.originAirportState = originAirportState;
        this.originAirportCountry = originAirportCountry;
        this.originAirportFee = originAirportFee;
        this.destinationAirportCity = destinationAirportCity;
        this.foodServed = foodServed;
        this.destinationAirportState = destinationAirportState;
        this.destinationAirportCountry = destinationAirportCountry;
        this.destinationAirportFee = destinationAirportFee;
        this.destinationAirportLounge = destinationAirportLounge;
        this.routeCost = routeCost;
        this.totalSeats = totalSeats;
        this.id = id;
        this.fcSeats = fcSeats;
        this.destinationAirport = destinationAirport;
        this.bcSeats = bcSeats;
        this.originAirportCity = originAirportCity;
        this.fcPrice = fcPrice;
        this.fees = fees;
    }

    public Flight(int id /*HashMap<String, String> customerlist*/){
        this.id = id;
        //this.customerlist = customerlist;
    }

    public Flight(){}
  
    //Methods (getters, setters)
    public void printFlight(){
        System.out.println("[ORIGIN AIRPORT] " + this.originAirport + "\n" + "[ORIGIN CODE] " + this.originCode + "\n" +"[DESTINATION AIRPORT] " + this.destinationAirport + "\n" +"[DESTINATION CODE] " + this.destinationCode + "\n" + 
        "[DEPART DATE] " + this.departDate + "\n" + "[DEPART TIME] " + this.departTime + "\n" +"[DURATION] " + this.duration  + "\n" +"[DISTANCE] " + this.distance + "\n" +"[TIME ZONE DIFFERENCE] " + this.timezoneDiff + "\n" +
        "[ARRIVAL DATE] " + this.arrivalDate + "\n" +"[ARRIVAL TIME] " + this.arrivalTime + "\n" +"[FLIGHT TYPE] " + this.flightType + "\n" +"[SURCHARGE] " + this.surcharge + "\n" +"[SURCHARGE] " + this.foodServed + "\n" +
        "[ROUTE COST] " + this.routeCost + "\n" +"[FIRST CLASS PRICE] " + this.fcPrice + "\n" +"[BUSINESS CLASS PRICE] " + this.bcPrice + "\n" +"[MAIN CLASS PRICE] " + this.mcPrice + "\n" +"[FIRST CLASS SEATS REMAINING] " + this.fcSeats + "\n" +
        "[BUSINESS CLASS SEATS REMAINING] " + this.bcSeats + "\n" +"[MAIN CLASS SEATS REMAINING] " + this.mcSeats + "\n" +"[TOTAL SEATS REMAINING] " + this.totalSeats);
    }

    public void printFlight2(){
        System.out.println("[ORIGIN CODE] " + this.originCode + "\n" + "[AIRPORT] " + this.originAirport + "\n" + "[CITY] " + this.originAirportCity + "\n" + "[STATE] "+ this.originAirportState + "\n" 
        + "[COUNTRY] " + this.originAirportCountry + "\n" + "[FEES] " + this.fees + "\n" + "[LOUNGE STATUS] " + this.originAirportLounge + "\n" + "[PROFIT] " + this.profits + "\n");
    }


/* 
    public String[] getCustomerlist() {
        return customerlist;
    }public void setCustomerlist(String[] customerlist) {
        this.customerlist = customerlist;
    }
*/

//DOCUMENT ALL GETTERS AND SETTERS

 
    public Boolean getOriginAirportLounge() {
        return originAirportLounge;
    }public void setOriginAirportLounge(Boolean originAirportLounge) {
        this.originAirportLounge = originAirportLounge;
    }

    public String getOriginAirportState() {
        return originAirportState;
    }public void setOriginAirportState(String originAirportState) {
        this.originAirportState = originAirportState;
    }

    public String getDestinationAirportCountry() {
        return destinationAirportCountry;
    }public void setDestinationAirportCountry(String destinationAirportCountry) {
        this.destinationAirportCountry = destinationAirportCountry;
    }

    public double getDestinationAirportFee() {
        return destinationAirportFee;
    }public void setDestinationAirportFee(double destinationAirportFee) {
        this.destinationAirportFee = destinationAirportFee;
    }

    public Boolean getDestinationAirportLounge() {
        return destinationAirportLounge;
    }public void setDestinationAirportLounge(Boolean destinationAirportLounge) {
        this.destinationAirportLounge = destinationAirportLounge;
    }


    public String getDestinationAirportCity() {
        return destinationAirportCity;
    }public void setDestinationAirportCity(String destinationAirportCity) {
        this.destinationAirportCity = destinationAirportCity;
    }

    public double getOriginAirportFee() {
        return originAirportFee;
    }public void setOriginAirportFee(double originAirportFee) {
        this.originAirportFee = originAirportFee;
    }

    public String getOriginAirportCountry() {
        return originAirportCountry;
    }public void setOriginAirportCountry(String originAirportCountry) {
        this.originAirportCountry = originAirportCountry;
    }


    public String getOriginAirportCity() {
        return originAirportCity;
    }public void setOriginAirportCity(String originAirportCity) {
        this.originAirportCity = originAirportCity;
    }


    public String getDestinationAirportState() {
        return destinationAirportState;
    }public void setDestinationAirportState(String destinationAirportState) {
        this.destinationAirportState = destinationAirportState;
    }
    
    public int getId() {
        return id;
    }public void setId(int id) {
        this.id = id;
    }


    public int getFlightNum() {
        return flightNum;
    }public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }


    public String getOriginAirport() {
        return originAirport;
    }public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }


    public String getOriginCode() {
        return originCode;
    }public void setOriginCode(String originCode){
        this.originCode = originCode;
    }


    public String getDestinationAirport(){
        return destinationAirport;
    }public void setDestinationAirport(String destinationAirport){
        this.destinationAirport = destinationAirport;
    }


    public String getDestinationCode(){
        return destinationCode;
    }public void setDestinationCode(String destinationCode){
        this.destinationCode = destinationCode;
    }


    public String getDepartDate(){
        return this.departDate;
    }public void setDepartDate(String departDate){
        this.departDate = departDate;
    }


    public String getDepartTime(){
        return this.departTime;
    }public void setDepartTime(String departTime){
        this.departTime = departTime;
    }


    public int getDuration() {
        return duration;
    }public void setDuration(int duration) {
        this.duration = duration;
    }


    public int getDistance() {
        return distance;
    }public void setDistance(int distance) {
        this.distance = distance;
    }


    public int getTimezoneDiff() {
        return timezoneDiff;
    }public void setTimezoneDiff(int timezoneDiff) {
        this.timezoneDiff = timezoneDiff;
    }


    public String getArrivalDate() {
        return arrivalDate;
    }public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public String getArrivalTime() {
        return arrivalTime;
    }public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public String getFlightType() {
        return flightType;
    }public void setFlightType(String flightType) {
        this.flightType = flightType;
    }


    public int getSurcharge() {
        return surcharge;
    }public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }


    public Boolean getFoodServed() {
        return foodServed;
    }public void setFoodServed(Boolean foodServed) {
        this.foodServed = foodServed;
    }


    public int getRouteCost() {
        return routeCost;
    }public void setRouteCost(int routeCost) {
        this.routeCost = routeCost;
    }


    public int getMinerPoints() {
        return minerPoints;
    }public void setMinerPoints(int minerPoints) {
        this.minerPoints = minerPoints;
    }


    public int getTotalSeats() {
        return totalSeats;
    }public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }


    public int getFcSeats() {
        return fcSeats;
    }public void setFcSeats(int fcSeats) {
        this.fcSeats = fcSeats;
    }


    public int getBcSeats() {
        return bcSeats;
    }public void setBcSeats(int bcSeats) {
        this.bcSeats = bcSeats;
    }


    public int getMcSeats() {
        return mcSeats;
    }public void setMcSeats(int mcSeats) {
        this.mcSeats = mcSeats;
    }

    public int getFcPrice() {
        return fcPrice;
    }public void setFcPrice(int fcPrice) {
        this.fcPrice = fcPrice;
    }


    public int getBcPrice() {
        return bcPrice;
    }public void setBcPrice(int bcPrice) {
        this.bcPrice = bcPrice;
    }


    public double getMcPrice() {
        return mcPrice;
    }public void setMcPrice(double mcPrice) {
        this.mcPrice = mcPrice;
    }

    public double getProfits() {
        return profits;
    }public void setProfits(double profits) {
        this.profits = profits;
    }

    public double getFees() {
        return fees;
    }public void setFees(double fees) {
        this.fees = fees;
    }
}