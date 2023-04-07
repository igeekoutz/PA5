import java.util.HashMap;

public abstract class Flight {
    // Attributes
    private int id;
    private int flightNumber;
    private Airport origAirport;
    private Airport destAirport;
    private String depDate;
    private String depTime;
    private int duration;
    private int distance;
    private int timeZoneDiff;
    private String arrDate;
    private String arrTime;
    private String flightType;
    private int surcharge;
    private boolean foodServed;
    private int routeCost;
    private int minerPoints;
    private int totalSeats;
    private int firClassSeats;
    private int buisnClassSeats;
    private int mainCabnSeats;
    private int firClassPrice;
    private int businClassPrice;
    private int mainCabnPrice;
    private HashMap<Integer, Ticket> tickets;
    private int firClassSeatsSold;
    private int businClassSeatsSold;
    private int mainCabnSeatsSold;
    private double firClassRevenue;
    private double businClassRevenue;
    private double mainCabnRevenue;
    private boolean flightCanceled;
    private double maSavingsTotal;
    private double salesTaxTotal;

    /**
     * Default Constructor for creating a basic flight object
     */
    public Flight() {
    }

    /**
     * Main constructor to all the attributes with information at once
     * 
     * @param idIn              Flight ID
     * @param flightNumberIn    The Flight number
     * @param origAirportIn     Airport object for the Origin airport
     * @param destAirportIn     Airport object for the Destination airport
     * @param depDateIn         Date that the flight will depart
     * @param depTimeIn         Time that the flight will depart
     * @param durationIn        Duration of the flight
     * @param distanceIn        Distance from the Origin airport to the destination
     *                          airport
     * @param timeZoneDiffIn    Time difference between the Origin city and
     *                          Destination city
     * @param arrDateIn         Date that the flight will arrive
     * @param arrTimeIn         Time that the flight will arrive
     * @param flightTypeIn      Type of flight
     * @param surchargeIn       The surcharge of the flight
     * @param foodServedIn      If the Flight is serving food
     * @param routeCostIn       The cost of the Flight
     * @param minerPointsIn     How much miner points the flight will give
     * @param totalSeatsIn      How many total seats there are on the flight
     * @param firClassSeatsIn   How many seats there are for First class
     * @param buisnClassSeatsIn How many seats there are for Busisness Class
     * @param mainCabnSeatsIn   How many seats there are for the Main cabin
     * @param firClassPriceIn   How much a First class seat costs
     * @param businClassPriceIn How much a Busisness class seat costs
     * @param mainCabnPriceIn   How much a Main Cabin seat costs
     */
    public Flight(String idIn, String flightNumberIn,
            Airport origAirportIn, Airport destAirportIn,
            String depDateIn, String depTimeIn,
            String durationIn, String distanceIn, String timeZoneDiffIn,
            String arrDateIn, String arrTimeIn, String flightTypeIn,
            String surchargeIn, String foodServedIn, String routeCostIn,
            String minerPointsIn, String totalSeatsIn, String firClassSeatsIn,
            String buisnClassSeatsIn, String mainCabnSeatsIn, String firClassPriceIn,
            String businClassPriceIn, String mainCabnPriceIn) {
        try {
            this.id = Integer.parseInt(idIn);
            this.flightNumber = Integer.parseInt(flightNumberIn);
            this.origAirport = origAirportIn;
            this.destAirport = destAirportIn;
            this.depDate = depDateIn;
            this.depTime = depTimeIn;
            this.duration = Integer.parseInt(durationIn);
            this.distance = Integer.parseInt(distanceIn);
            this.timeZoneDiff = Integer.parseInt(timeZoneDiffIn);
            this.arrDate = arrDateIn;
            this.arrTime = arrTimeIn;
            this.flightType = flightTypeIn;
            this.surcharge = Integer.parseInt(surchargeIn);
            this.foodServed = Boolean.parseBoolean(foodServedIn);
            this.routeCost = Integer.parseInt(routeCostIn);
            this.minerPoints = Integer.parseInt(minerPointsIn);
            this.firClassPrice = Integer.parseInt(firClassPriceIn);
            this.businClassPrice = Integer.parseInt(businClassPriceIn);
            this.mainCabnPrice = Integer.parseInt(mainCabnPriceIn);
            this.firClassSeats = Integer.parseInt(firClassSeatsIn);
            this.buisnClassSeats = Integer.parseInt(buisnClassSeatsIn);
            this.mainCabnSeats = Integer.parseInt(mainCabnSeatsIn);
            this.totalSeats = Integer.parseInt(totalSeatsIn);
            this.firClassSeatsSold = 0;
            this.businClassSeatsSold = 0;
            this.mainCabnSeatsSold = 0;
            this.firClassRevenue = 0;
            this.businClassRevenue = 0;
            this.mainCabnRevenue = 0;
        } catch (NumberFormatException n) {
            System.out.print("Error inputting Flight data:\n" + n);
        }
        // Initialize the tickets Array List
        this.tickets = new HashMap<Integer, Ticket>();
    }

    // Mehthods

    /**
     * Prints all the infromation about a flight
     */
    public void printFlight() {
        System.out.println("\n \tAirport Information" +
                "\n \t-------------------" +
                "\n -Origin Airport: " + this.origAirport.getName() +
                "\n -Origin Code: " + this.origAirport.getCode() +
                "\n -Origin has Lounge: " + this.origAirport.hasLounge() +
                "\n -Destination Airpot: " + this.destAirport.getName() +
                "\n -Destination Code: " + this.destAirport.getCode() +
                "\n -Food Served: " + this.foodServed +
                "\n\n \tTime Infromation" +
                "\n \t----------------" +
                "\n -Departure Date: " + this.depDate +
                "\n -Departure Time: " + this.depTime +
                "\n -Arrivale Date: " + this.arrDate +
                "\n -Arrivale Time: " + this.arrTime +
                "\n -Duration: " + this.duration + " minutes" +
                "\n -Distance: " + this.distance + " miles" +
                "\n -Time Zone Difference: " + this.timeZoneDiff + " hour" +
                "\n\n \t Pricing Infromation" +
                "\n \t--------------------" +
                "\n -First Class Price: $" + this.firClassPrice +
                "\n -Business Class Price: $" + this.businClassPrice +
                "\n -Main Cabin Price: $" + this.mainCabnPrice +
                "\n\n \tSeating Infromation" +
                "\n \t-------------------" +
                "\n -First Class Seats: " + this.firClassSeats +
                "\n -Busness Class Seats: " + this.buisnClassSeats +
                "\n -Main Cabin Seats: " + this.mainCabnSeats +
                "\n -Total Seats: " + this.totalSeats);
        if (this.flightCanceled) {
            System.out.println("------------FLIGHT HAS BEEN CANCELED------------");
        }
        System.out.println();
    }

    /**
     * Prints a smaller amount of information about the flight
     */
    public void shortPrintFlight() {
        System.out.println("\n \tAirport Information" +
                "\n \t-------------------" +
                "\n -Flight ID: " + this.id +
                "\n -Origin Airport: " + this.origAirport.getName() +
                "\n -Destination Airpot: " + this.destAirport.getName() +
                "\n -Departure Date: " + this.depDate +
                "\n -Departure Time: " + this.depTime +
                "\n -Arrivale Date: " + this.arrDate +
                "\n -Arrivale Time: " + this.arrTime);
        if (this.flightCanceled) {
            System.out.println("------------FLIGHT HAS BEEN CANCELED------------");
        }
        System.out.println();
    }

    /**
     * Prints the cost and seats available for each class
     */
    public void printFlightClasses() {
        // Check if any seats are sold out
        String firSeatsAvailable = String.valueOf(this.firClassSeats);
        String buisnSeatsAvailable = String.valueOf(this.buisnClassSeats);
        String mainSeatsAvailable = String.valueOf(this.mainCabnSeats);
        if (this.firClassSeats == 0) {
            firSeatsAvailable = "Sold Out";
        }
        if (this.buisnClassSeats == 0) {
            buisnSeatsAvailable = "Sold Out";
        }
        if (this.mainCabnSeats == 0) {
            mainSeatsAvailable = "Sold Out";
        }

        // Print the final information
        System.out.print("\n \tFlight Class Information" +
                "\n \t-------------------------" +
                "\n a) First Class Price: $" + this.firClassPrice + "\tFirst Class Seats Left: " + firSeatsAvailable +
                "\n b) Business Class Price: $" + this.businClassPrice + "\tBusiness Class Seats Left: "
                + buisnSeatsAvailable +
                "\n c) Main Cabin Price: $" + this.mainCabnPrice + "\tMain Cabin Seats Left: " + mainSeatsAvailable
                + "\n");
        if (this.flightType.equals("International")) {
            System.out.println("\tSurchagrge Per Seat: $" + this.surcharge);
        }
    }

    /**
     * Prints how many seats are left in the flight for each class
     */
    public void printSeatsleft() {
        // Check if any seats are sold out
        String firSeatsAvailable = String.valueOf(this.firClassSeats);
        String buisnSeatsAvailable = String.valueOf(this.buisnClassSeats);
        String mainSeatsAvailable = String.valueOf(this.mainCabnSeats);
        if (this.firClassSeats == 0) {
            firSeatsAvailable = "Sold Out";
        }
        if (this.buisnClassSeats == 0) {
            buisnSeatsAvailable = "Sold Out";
        }
        if (this.mainCabnSeats == 0) {
            mainSeatsAvailable = "Sold Out";
        }
        // Print the final information
        System.out.print("\n \tFlight Seats Left" +
                "\n \t-------------------------" +
                "\n First Class Seats Left: " + firSeatsAvailable +
                "\n Business Class Seats Left: " + buisnSeatsAvailable +
                "\n Main Cabin Seats Left: " + mainSeatsAvailable +
                "\n \tFlight Seats Sold" +
                "\n \t-------------------------" +
                "\n First Class Seats Left: " + this.firClassSeatsSold +
                "\n Business Class Seats Left: " + this.businClassSeatsSold +
                "\n Main Cabin Seats Left: " + this.mainCabnSeatsSold +
                "\n");
    }

    /**
     * Prints the revenue of the flight for each class
     */
    public void printSeatsRevenue() {
        System.out.print("\n \tFlight Seats Revenue" +
                "\n \t-------------------------" +
                "\n First Class Profits: $" + this.firClassRevenue +
                "\n Business Class Profits: $" + this.businClassRevenue +
                "\n Main Cabin Profits: $" + this.mainCabnRevenue +
                "\n Total Revenue: $" + getTotalRevenue() +
                "\n");
    }

    /**
     * Prints the list of all the customers usernames that bough a ticket for the
     * flight
     */
    public void printCustomerList() {
        System.out.print("\n \tCustomer List" +
                "\n \t-------------------------\n");
        for (Ticket value : this.tickets.values()) {
            System.out.println("\t Username: " + value.getUsername());
            System.out.println("\t Class: " + value.getClassType());
            System.out.println("\t Seats: " + value.getNumOfSeats());
            System.out.println("\t Price: $" + value.getTotalPrice());
            System.out.println();
        }
    }

    /**
     * Prints the profits of the flight
     */
    public void printFlightProfits() {
        printSeatsRevenue();
        System.out.println("Profits: $" + getProfit());
    }

    /**
     * Increases the amount of seats in flight based on the class and decreases the
     * amount of seats purchased
     * 
     * @param classType  The class type of the flight to be increased
     * @param numOfSeats The number of seats to be increased
     */
    public void increaseFlightSeats(String classType, int numOfSeats) {
        switch (classType) {
            case "First Class":
                this.firClassSeats = this.firClassSeats + numOfSeats;
                break;
            case "Business Class":
                this.buisnClassSeats = this.buisnClassSeats + numOfSeats;
                break;
            case "Main Cabin":
                this.mainCabnSeats = this.mainCabnSeats + numOfSeats;
                break;
        }
        this.totalSeats = this.totalSeats + numOfSeats;
        decreaseFlightSeatsPurchased(classType, numOfSeats);
    }

    /**
     * Decreases the amount of seats in flight based on the class and increases the
     * amount of seats purchased
     * 
     * @param classType  The class type of the flight to be decreased
     * @param numOfSeats The number of seats to be decreased
     */
    public void decreaseFlightSeats(String classType, int numOfSeats) {
        switch (classType) {
            case "First Class":
                this.firClassSeats = this.firClassSeats - numOfSeats;
                break;
            case "Business Class":
                this.buisnClassSeats = this.buisnClassSeats - numOfSeats;
                break;
            case "Main Cabin":
                this.mainCabnSeats = this.mainCabnSeats - numOfSeats;
                break;
        }
        this.totalSeats = this.totalSeats - numOfSeats;
        increaseFlightSeatsPurchased(classType, numOfSeats);
    }

    /**
     * Increases the amount of seats purchased in a flight
     * 
     * @param classType  The class type of the flight
     * @param numOfSeats The number of seats
     */
    public void increaseFlightSeatsPurchased(String classType, int numOfSeats) {
        switch (classType) {
            case "First Class":
                this.firClassSeatsSold = this.firClassSeatsSold + numOfSeats;
                break;
            case "Business Class":
                this.businClassSeatsSold = this.businClassSeatsSold + numOfSeats;
                break;
            case "Main Cabin":
                this.mainCabnSeatsSold = this.mainCabnSeatsSold + numOfSeats;
                break;
        }
        this.totalSeats = this.totalSeats + numOfSeats;
    }

    /**
     * Decreases the amount of seats purchased in a flight
     * 
     * @param classType  The class type of the flight
     * @param numOfSeats The number of seats
     */
    public void decreaseFlightSeatsPurchased(String classType, int numOfSeats) {
        switch (classType) {
            case "First Class":
                this.firClassSeatsSold = this.firClassSeatsSold - numOfSeats;
                break;
            case "Business Class":
                this.businClassSeatsSold = this.businClassSeatsSold - numOfSeats;
                break;
            case "Main Cabin":
                this.mainCabnSeatsSold = this.mainCabnSeatsSold - numOfSeats;
                break;
        }
        this.totalSeats = this.totalSeats + numOfSeats;
    }

    /**
     * Increases the seats revenue based on a class type
     * 
     * @param classType The class type of the flight
     * @param revenueIn The amount of revenue made
     */
    public void increaseFlightSeatsRevenue(String classType, double revenueIn) {
        switch (classType) {
            case "First Class":
                this.firClassRevenue = this.firClassRevenue + revenueIn;
                break;
            case "Business Class":
                this.businClassRevenue = this.businClassRevenue + revenueIn;
                break;
            case "Main Cabin":
                this.mainCabnRevenue = this.mainCabnRevenue + revenueIn;
                break;
        }
    }

    /**
     * Decreases the seats revenue based on a class type
     * 
     * @param classType The class type of the flight
     * @param revenueIn The amount of revenue
     */
    public void decreaseFlightSeatsRevenue(String classType, double revenueIn) {
        switch (classType) {
            case "First Class":
                this.firClassRevenue = this.firClassRevenue - revenueIn;
                break;
            case "Business Class":
                this.businClassRevenue = this.businClassRevenue - revenueIn;
                break;
            case "Main Cabin":
                this.mainCabnRevenue = this.mainCabnRevenue - revenueIn;
                break;
        }
    }

    /**
     * Returns the total revenue made from a flight
     * 
     * @return double Returns the total revenue
     */
    public double getTotalRevenue() {
        return this.firClassRevenue + this.businClassRevenue + this.mainCabnRevenue;
    }

    /**
     * Returns the total profit made from a flight
     * 
     * @return double Return the total profit
     */
    public double getProfit() {
        return getTotalRevenue() - this.routeCost;
    }

    /**
     * Adds tickets to a flight
     * 
     * @param ticketIn Ticket in
     */
    public void addTicket(Ticket ticketIn) {
        this.tickets.put(ticketIn.getConfirmationNum(), ticketIn);
    }

    /**
     * Removes a ticket from the flight
     * 
     * @param ticketIn Ticket object to be removed
     */
    public void removeTicket(Ticket ticketIn) {
        this.tickets.remove(ticketIn.getConfirmationNum());
    }

    /**
     * Increases the total savings a flight has made
     * 
     * @param maSavings Price of savings in
     */
    public void incMaSavingsTotal(double maSavings) {
        this.maSavingsTotal += maSavings;
    }

    /**
     * Decreases the total savings a flight has made
     * 
     * @param maSavings Price of savings
     */
    public void decMaSavingsTotal(double maSavings) {
        this.maSavingsTotal -= maSavings;
    }

    /**
     * Increases the total sales tax a flight has made
     * 
     * @param salesTax Price of sales tax
     */
    public void incSalesTaxTotal(double salesTax) {
        this.salesTaxTotal += salesTax;
    }

    /**
     * Decreases the total sales tax a flight has made
     * 
     * @param salesTax Price of sales tax
     */
    public void decSalesTaxTotal(double salesTax) {
        this.salesTaxTotal -= salesTax;
    }

    /**
     * Changes the new arrival time based on the new departure time and the duration
     * of the flight
     * 
     * @param newDepTime New departure time
     * @return boolean If the arrival time was changed successfully
     */
    private boolean newArrTime(String newDepTime) {
        // Try and catch to verify that they gave the correct format
        try {
            // Check how many hours and minutes are left for the duration of the flight
            int durLeft = this.duration;
            int hoursDur = 0;
            while (durLeft > 60) {
                durLeft = durLeft - 60;
                hoursDur++;
            }
            int minsDur = durLeft;

            // Seperate the departure time to get the individual hours and minutes then add
            // the hours/minutes
            String[] tempTime = newDepTime.split("[: ]");
            int arrMin = Integer.parseInt(tempTime[1]) + minsDur;
            String amPm = tempTime[2];
            if (arrMin > 60) {
                hoursDur++;
                arrMin = arrMin - 60;
            }
            int arrHours = Integer.parseInt(tempTime[0]) + hoursDur + this.timeZoneDiff;

            // Change the AM or PM if needed
            if ((arrHours > 11) && (amPm.equalsIgnoreCase("AM"))) {
                amPm = "PM";
            } else if ((arrHours > 11) && (amPm.equalsIgnoreCase("PM"))) {
                amPm = "AM";
                // Change the Date
                // TODO: set up a method to do this separatley and correctly
                String[] newDate = this.arrDate.split("/");
                int newDay = Integer.parseInt(newDate[1]) + 1;
                this.arrDate = newDate[0] + "/" + newDay + "/" + newDate[2];
            }
            if (arrHours > 12) {
                arrHours = arrHours - 12;
            }

            // Return the final arrival hours and change the departure time if everything
            // works
            String newArrTime = arrHours + ":" + String.format("%02d", arrMin) + " " + amPm;
            this.arrTime = newArrTime;
            this.depTime = newDepTime;
            return true;
        } catch (NumberFormatException n) {
            System.out.println("\nInvalid time!\n-------------\n");
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("\nInvalid time!\n-------------\n");
        }
        return false;
    }

    /**
     * Changes the Origine Airports name
     * 
     * @param airportIn Name of the new original airport
     */
    public void setOrigAirportName(String airportIn) {
        this.origAirport.setName(airportIn);
    }

    /**
     * Changes the origine code of the airport
     * 
     * @param codeIn String of the new origin airport code
     */
    public void setOrigCode(String codeIn) {
        this.origAirport.setCode(codeIn);
    }

    /**
     * Changes the Departure Airports name
     * 
     * @param airportIn Name of the new departure airport
     */
    public void setDestAirportName(String airportIn) {
        this.destAirport.setName(airportIn);
    }

    /**
     * Changes the Departure Airports code
     * 
     * @param codeIn String of the new destination airport code
     */
    public void setDestCode(String codeIn) {
        this.destAirport.setCode(codeIn);
    }

    /**
     * Changes the Departure date
     * 
     * @param dateIn Date in
     */
    public void setDepDate(String dateIn) {
        this.depDate = dateIn;
    }

    /**
     * changes the departure time and tells the user if it was changed correctly
     * 
     * @param timeIn Time in
     * @return boolean Returns if the time was changed successfully
     */
    public boolean setDepTime(String timeIn) {
        String newDepTime = timeIn;
        // Adjust Arrival time if Departure time is changed
        return newArrTime(newDepTime);
    }

    /**
     * Changes the first class price per seat
     * 
     * @param priceIn Price in
     */
    public void setFirClassPrice(int priceIn) {
        this.firClassPrice = priceIn;
    }

    /**
     * Changes the business class price per seat
     * 
     * @param priceIn Price in
     */
    public void setBusClassPrice(int priceIn) {
        this.businClassPrice = priceIn;
    }

    /**
     * Changes the main cabin price per seat
     * 
     * @param priceIn Price in
     */
    public void setMainCabPrice(int priceIn) {
        this.mainCabnPrice = priceIn;
    }

    /**
     * Changes the id of the Flight
     * 
     * @param id id In
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Changes the flight number of the flight
     * 
     * @param flightNumber Flight number in
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Changes the duration of the flight
     * 
     * @param duration Duration in
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Changes the distance of the flight
     * 
     * @param distance Distance in
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Changes the time zone difference of the flight
     * 
     * @param timeZoneDiff Time Zone Difference in
     */
    public void setTimeZoneDiff(int timeZoneDiff) {
        this.timeZoneDiff = timeZoneDiff;
    }

    /**
     * Changes the arrivale date of the flight
     * 
     * @param arrDate Arrival date in
     */
    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    /**
     * Changes the arrival time of the Flight
     * 
     * @param arrTime Arrival time in
     */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    /**
     * Changes the Flight Type of the Flight
     * 
     * @param flightType Flight Type in
     */
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    /**
     * Changes the surcharge of the Flight
     * 
     * @param surcharge Surcharge in
     */
    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    /**
     * Changes if the flight serves food on the flight
     * 
     * @param foodServed Food Served in
     */
    public void setFoodServed(boolean foodServed) {
        this.foodServed = foodServed;
    }

    /**
     * Changes the route cost of the flight
     * 
     * @param routeCost Route cost in
     */
    public void setRouteCost(int routeCost) {
        this.routeCost = routeCost;
    }

    /**
     * Changes the miner points the flight offers
     * 
     * @param minerPoints Miner Points in
     */
    public void setMinerPoints(int minerPoints) {
        this.minerPoints = minerPoints;
    }

    /**
     * Changes the total seats on the flight
     * 
     * @param totalSeats Total seats in
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     * Changes the total first class seats
     * 
     * @param firClassSeats First class seats in
     */
    public void setFirClassSeats(int firClassSeats) {
        this.firClassSeats = firClassSeats;
    }

    /**
     * Changes the total business class seats
     * 
     * @param buisnClassSeats Business class seats
     */
    public void setBuisnClassSeats(int buisnClassSeats) {
        this.buisnClassSeats = buisnClassSeats;
    }

    /**
     * Changes the total main cabins seats
     * 
     * @param mainCabnSeats Main cabin seats
     */
    public void setMainCabnSeats(int mainCabnSeats) {
        this.mainCabnSeats = mainCabnSeats;
    }

    /**
     * Changes the price of a business class seat
     * 
     * @param businClassPrice Busisness class price
     */
    public void setBusinClassPrice(int businClassPrice) {
        this.businClassPrice = businClassPrice;
    }

    /**
     * Changes the price of a main cabin seat
     * 
     * @param mainCabnPrice Main cabin price
     */
    public void setMainCabnPrice(int mainCabnPrice) {
        this.mainCabnPrice = mainCabnPrice;
    }

    /**
     * Add a list of tickets to the flight
     * 
     * @param tickets Hashmap of tickets
     */
    public void setTickets(HashMap<Integer, Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Changes the amount of first class seats where sold
     * 
     * @param firClassSeatsSold Seats sold in
     */
    public void setFirClassSeatsSold(int firClassSeatsSold) {
        this.firClassSeatsSold = firClassSeatsSold;
    }

    /**
     * Changes the amount of Business class seats where sold
     * 
     * @param businClassSeatsSold Seats sold in
     */
    public void setBusinClassSeatsSold(int businClassSeatsSold) {
        this.businClassSeatsSold = businClassSeatsSold;
    }

    /**
     * Changes the amount of main cabin seats where sold
     * 
     * @param mainCabnSeatsSold Seats sold in
     */
    public void setMainCabnSeatsSold(int mainCabnSeatsSold) {
        this.mainCabnSeatsSold = mainCabnSeatsSold;
    }

    /**
     * Changes the First class seats revenue
     * 
     * @param firClassRevenue Revenue in
     */
    public void setFirClassRevenue(double firClassRevenue) {
        this.firClassRevenue = firClassRevenue;
    }

    /**
     * Changes the Business class seats revenue
     * 
     * @param businClassRevenue Revenue in
     */
    public void setBusinClassRevenue(double businClassRevenue) {
        this.businClassRevenue = businClassRevenue;
    }

    /**
     * Changes the main cabin seats revenue
     * 
     * @param mainCabnRevenue Revenue in
     */
    public void setMainCabnRevenue(double mainCabnRevenue) {
        this.mainCabnRevenue = mainCabnRevenue;
    }

    /**
     * Changes if the flight has been canceled
     * 
     * @param flightCanceled Flight cancelled in
     */
    public void setFlightCanceled(boolean flightCanceled) {
        this.flightCanceled = flightCanceled;
    }

    /**
     * Returns the id of the Flight
     * 
     * @return int Of Flight id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the flight number of the flight
     * 
     * @return int Flight number
     */
    public int getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * Returns the Origin Airports name
     * 
     * @return String Airport Name
     */
    public String getOrigAirportName() {
        return this.origAirport.getName();
    }

    /**
     * Returns the origin airports code
     * 
     * @return String Airport code
     */
    public String getOrigCode() {
        return this.origAirport.getCode();
    }

    /**
     * Returns the destination airport name
     * 
     * @return String Airport name
     */
    public String getDestAirportName() {
        return this.destAirport.getName();
    }

    /**
     * Returns the destination airport code
     * 
     * @return String Airport code
     */
    public String getDestCode() {
        return this.destAirport.getCode();
    }

    /**
     * Returns the departue date
     * 
     * @return String Departue date
     */
    public String getDepDate() {
        return this.depDate;
    }

    /**
     * Returns the Departure time
     * 
     * @return String Departue time
     */
    public String getDepTime() {
        return this.depTime;
    }

    /**
     * Returns the flight duration
     * 
     * @return int Flight duration
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Returns the flights distance
     * 
     * @return int Flight distance
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * Returns the Flights Time zone difference
     * 
     * @return int Time Zone Difference
     */
    public int getTimeZoneDiff() {
        return this.timeZoneDiff;
    }

    /**
     * Returns the Arrival date
     * 
     * @return String Arrival date
     */
    public String getArrDate() {
        return this.arrDate;
    }

    /**
     * Returns the arrival time
     * 
     * @return String Arrival time
     */
    public String getArrTime() {
        return this.arrTime;
    }

    /**
     * Returns the flight type
     * 
     * @return String Flight type
     */
    public String getFlightType() {
        return flightType;
    }

    /**
     * Return the flight surcharge
     * 
     * @return int Flight surcharge
     */
    public int getSurcharge() {
        return surcharge;
    }

    /**
     * Returns if food is served on the flight
     * 
     * @return boolean Food served
     */
    public boolean isFoodServed() {
        return foodServed;
    }

    /**
     * Returns the price of the route cost
     * 
     * @return int Route cost
     */
    public int getRouteCost() {
        return routeCost;
    }

    /**
     * Returns the amount of miner points the flight offers
     * 
     * @return int Miner Points
     */
    public int getMinerPoints() {
        return minerPoints;
    }

    /**
     * Returns the amount of Business class seats
     * 
     * @return int Business class seats
     */
    public int getBuisnClassSeats() {
        return buisnClassSeats;
    }

    /**
     * Return the amount of total seats
     * 
     * @return int Total seats
     */
    public int getTotalSeats() {
        return this.totalSeats;
    }

    /**
     * Returns the amount of first class seats
     * 
     * @return int First Class seats
     */
    public int getFirClassSeats() {
        return this.firClassSeats;
    }

    /**
     * Returns the amount of Business class seats
     * 
     * @return int Business class seats
     */
    public int getBusinClassSeats() {
        return this.buisnClassSeats;
    }

    /**
     * Return the amount of main cabin seats
     * 
     * @return int Main cabin seats
     */
    public int getMainCabnSeats() {
        return this.mainCabnSeats;
    }

    /**
     * Returns the First class price per seat
     * 
     * @return int First class price per seat
     */
    public int getFirClassPrice() {
        return this.firClassPrice;
    }

    /**
     * Returns the Business class price per seat
     * 
     * @return int Business class price per seat
     */
    public int getBusinClassPrice() {
        return this.businClassPrice;
    }

    /**
     * Returns the Main Cabin price per seat
     * 
     * @return int Main cabin price per seat
     */
    public int getMainCabnPrice() {
        return this.mainCabnPrice;
    }

    /**
     * Returns a Hashmap list of tickets
     * 
     * @return HashMap<Integer, Ticket> Tickets from flight
     */
    public HashMap<Integer, Ticket> getTickets() {
        return tickets;
    }

    /**
     * Returns the amount of seats sold from first class
     * 
     * @return int First class seats sold
     */
    public int getFirClassSeatsSold() {
        return firClassSeatsSold;
    }

    /**
     * Returns the amount of seats sold from Business class
     * 
     * @return int Business class seats sold
     */
    public int getBusinClassSeatsSold() {
        return businClassSeatsSold;
    }

    /**
     * Returns the amount of seats sold from main cabin
     * 
     * @return int Main cabin seats sold
     */
    public int getMainCabnSeatsSold() {
        return mainCabnSeatsSold;
    }

    /**
     * Returns the First Class Revenue
     * 
     * @return double First class revenue
     */
    public double getFirClassRevenue() {
        return firClassRevenue;
    }

    /**
     * Returns the Business Class Revenue
     * 
     * @return double Business class revenue
     */
    public double getBusinClassRevenue() {
        return businClassRevenue;
    }

    /**
     * Returns the Main cabin Revenue
     * 
     * @return double Main cabin revenue
     */
    public double getMainCabnRevenue() {
        return mainCabnRevenue;
    }

    /**
     * Returns if the Flight is canceled
     * 
     * @return boolean Flight canceled
     */
    public boolean isFlightCanceled() {
        return flightCanceled;
    }

    /**
     * Return the Origin Airport object
     * 
     * @return Airport Origin Airport
     */
    public Airport getOrigAirport() {
        return origAirport;
    }

    /**
     * Change the Origin Airport object
     * 
     * @param origAirport Origin Airport
     */
    public void setOrigAirport(Airport origAirport) {
        this.origAirport = origAirport;
    }

    /**
     * Returns the Destination Airport object
     * 
     * @return Airport Destination airport
     */
    public Airport getDestAirport() {
        return destAirport;
    }

    /**
     * Changes the Destination Airport object
     * 
     * @param destAirport Destination Airport
     */
    public void setDestAirport(Airport destAirport) {
        this.destAirport = destAirport;
    }

    /**
     * Returns the Miners Air savings Total from the flight
     * 
     * @return double Miners Air Savings
     */
    public double getMaSavingsTotal() {
        return maSavingsTotal;
    }

    /**
     * Sets the Miners Air Savings total
     * 
     * @param maSavingsTotal Miners Air Saving
     */
    public void setMaSavingsTotal(double maSavingsTotal) {
        this.maSavingsTotal = maSavingsTotal;
    }

    /**
     * Returns the Sales Tax Total from the flight
     * 
     * @return double Sales Tax Total
     */
    public double getSalesTaxTotal() {
        return salesTaxTotal;
    }

    /**
     * Changes the Sales Tax Total
     * 
     * @param salesTaxTotal Sales Tax total
     */
    public void setSalesTaxTotal(double salesTaxTotal) {
        this.salesTaxTotal = salesTaxTotal;
    }

}