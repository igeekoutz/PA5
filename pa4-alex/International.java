public class International extends Flight {
    private int surcharge;

    /**
     * Default constructor for object
     */
    public International() {

    }

    /**
     * Main Constructor to create an object
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
    public International(String idIn, String flightNumberIn,
            Airport origAirportIn, Airport destAirportIn,
            String depDateIn, String depTimeIn,
            String durationIn, String distanceIn, String timeZoneDiffIn,
            String arrDateIn, String arrTimeIn, String flightTypeIn,
            String surchargeIn, String foodServedIn, String routeCostIn,
            String minerPointsIn, String totalSeatsIn, String firClassSeatsIn,
            String buisnClassSeatsIn, String mainCabnSeatsIn, String firClassPriceIn,
            String businClassPriceIn, String mainCabnPriceIn) {
        super(idIn, flightNumberIn, origAirportIn, destAirportIn,
                depDateIn, depTimeIn, durationIn, distanceIn, timeZoneDiffIn,
                arrDateIn, arrTimeIn, flightTypeIn, surchargeIn, foodServedIn, routeCostIn, minerPointsIn,
                totalSeatsIn, firClassSeatsIn, buisnClassSeatsIn, mainCabnSeatsIn,
                firClassPriceIn, businClassPriceIn, mainCabnPriceIn);
        try {
            this.surcharge = Integer.parseInt(surchargeIn);
        } catch (NumberFormatException n) {
            System.out.print("Error Inputting flight data:\n" + n);
        }
    }

    /**
     * Prints all the flights classes with seats left and price
     */
    public void printFlightClasses() {
        // Check if any seats are sold out
        String firSeatsAvailable = String.valueOf(getFirClassSeats());
        String buisnSeatsAvailable = String.valueOf(getBuisnClassSeats());
        String mainSeatsAvailable = String.valueOf(getMainCabnSeats());
        if (getFirClassSeats() == 0) {
            firSeatsAvailable = "Sold Out";
        }
        if (getBuisnClassSeats() == 0) {
            buisnSeatsAvailable = "Sold Out";
        }
        if (getMainCabnSeats() == 0) {
            mainSeatsAvailable = "Sold Out";
        }

        // Print the final information
        System.out.print("\n \tFlight Class Information" +
                "\n \t-------------------------" +
                "\n a) First Class Price: $" + getFirClassPrice() + "\tFirst Class Seats Left: " + firSeatsAvailable +
                "\n b) Business Class Price: $" + getBusinClassPrice() + "\tBusiness Class Seats Left: "
                + buisnSeatsAvailable +
                "\n c) Main Cabin Price: $" + getMainCabnPrice() + "\tMain Cabin Seats Left: " + mainSeatsAvailable
                + "\n");
        System.out.println("\tSurchagrge Per Seat: $" + this.surcharge);
    }

    // Setters and Getters

    /**
     * Returns the surcharge
     * 
     * @return int Surcharge
     */
    public int getSurcharge() {
        return surcharge;
    }

    /**
     * Sets the surcharge
     * 
     * @param surcharge Surcharge In
     */
    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

}
