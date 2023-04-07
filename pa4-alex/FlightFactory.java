import java.util.HashMap;

public class FlightFactory {
    private int idCol;
    private int flightNumCol;
    private int origAirportCol;
    private int origCodeCol;
    private int origCityCol;
    private int origStateCol;
    private int origCountryCol;
    private int origFeeCol;
    private int origLoungeCol;
    private int destAirportCol;
    private int destCodeCol;
    private int destCityCol;
    private int destStateCol;
    private int destCountryCol;
    private int destFeeCol;
    private int destLoungeCol;
    private int depDateCol;
    private int depTimeCol;
    private int durationCol;
    private int distanceCol;
    private int timeZoneDiffCol;
    private int arrDateCol;
    private int arrTimeCol;
    private int flightTypeCol;
    private int surchargeCol;
    private int foodServedCol;
    private int routeCostCol;
    private int minerPointsCol;
    private int totalSeatsCol;
    private int firClassSeatsCol;
    private int buisnClassSeatsCol;
    private int mainCabnSeatsCol;
    private int firClassPriceCol;
    private int businClassPriceCol;
    private int mainCabnPriceCol;
    private HashMap<String, Airport> airportList;

    /**
     * Default FlightFactory constructor
     */
    public FlightFactory() {
        this.airportList = new HashMap<String, Airport>();
    }

    /**
     * Assigns the column of the attributes from the header
     * 
     * @param headerLine String array with the header
     * @return Integer Returns the col of the Flight Type
     * @throws HeaderException If a header isn't in the predefined attributes
     */
    public Integer assignCols(String[] headerLine) throws HeaderException {

        for (int i = 0; i < headerLine.length; i++) {
            switch (headerLine[i]) {
                case "ID":
                    this.idCol = i;
                    break;
                case "Flight Number":
                    this.flightNumCol = i;
                    break;
                case "Origin Airport":
                    this.origAirportCol = i;
                    break;
                case "Origin Code":
                    this.origCodeCol = i;
                    break;
                case "Origin Airport City":
                    this.origCityCol = i;
                    break;
                case "Origin Airport State":
                    this.origStateCol = i;
                    break;
                case "Origin Airport Country":
                    this.origCountryCol = i;
                    break;
                case "Origin Airport Fee":
                    this.origFeeCol = i;
                    break;
                case "Origin Airport Lounge":
                    this.origLoungeCol = i;
                    break;
                case "Destination Airport":
                    this.destAirportCol = i;
                    break;
                case "Destination Code":
                    this.destCodeCol = i;
                    break;
                case "Destination Airport City":
                    this.destCityCol = i;
                    break;
                case "Destination Airport State":
                    this.destStateCol = i;
                    break;
                case "Destination Airport Country":
                    this.destCountryCol = i;
                    break;
                case "Destination Airport Fee":
                    this.destFeeCol = i;
                    break;
                case "Destination Airport Lounge":
                    this.destLoungeCol = i;
                    break;
                case "Departing Date":
                    this.depDateCol = i;
                    break;
                case "Departing Time":
                    this.depTimeCol = i;
                    break;
                case "Duration":
                    this.durationCol = i;
                    break;
                case "Distance":
                    this.distanceCol = i;
                    break;
                case "Time Zone Difference":
                    this.timeZoneDiffCol = i;
                    break;
                case "Arrival Date":
                    this.arrDateCol = i;
                    break;
                case "Arrival Time":
                    this.arrTimeCol = i;
                    break;
                case "Type":
                    this.flightTypeCol = i;
                    break;
                case "Surcharge":
                    this.surchargeCol = i;
                    break;
                case "Food Served":
                    this.foodServedCol = i;
                    break;
                case "Route Cost":
                    this.routeCostCol = i;
                    break;
                case "Miner Points":
                    this.minerPointsCol = i;
                    break;
                case "Total Seats":
                    this.totalSeatsCol = i;
                    break;
                case "First Class Seats":
                    this.firClassSeatsCol = i;
                    break;
                case "Business Class Seats":
                    this.buisnClassSeatsCol = i;
                    break;
                case "Main Cabin Seats":
                    this.mainCabnSeatsCol = i;
                    break;
                case "First Class Price":
                    this.firClassPriceCol = i;
                    break;
                case "Business Class Price":
                    this.businClassPriceCol = i;
                    break;
                case "Main Cabin Price":
                    this.mainCabnPriceCol = i;
                    break;
                default:
                    throw new HeaderException("Header not handeled " + headerLine[i]);
            }
        }

        return this.flightTypeCol;
    }

    /**
     * Creates an Internation object using the columns and returns the new
     * International object
     * 
     * @param line String array with information of the new Flight
     * @return International Returns a Internation object
     */
    public International createInternational(String[] line) {
        // Check if the origin Airport code is already in the airport list or create the
        // airport then add it
        Airport origAirport;
        if (this.airportList.containsKey(line[origCodeCol])) {
            origAirport = this.airportList.get(line[origCodeCol]);
        } else {
            origAirport = new Airport(line[origAirportCol], line[origCodeCol], line[origCityCol],
                    line[origStateCol], line[origCountryCol], line[origFeeCol], line[origLoungeCol]);
            this.airportList.put(line[origCodeCol], origAirport);
        }
        // Add the id of the flight to the airports origin list\
        origAirport.addOrigFlight(line[idCol]);

        Airport destAirport;
        if (this.airportList.containsKey(line[destCodeCol])) {
            destAirport = this.airportList.get(line[destCodeCol]);
        } else {
            destAirport = new Airport(line[destAirportCol], line[destCodeCol], line[destCityCol],
                    line[destStateCol], line[destCountryCol], line[destFeeCol], line[destLoungeCol]);
            this.airportList.put(line[destCodeCol], destAirport);
        }
        // Add the id of the flight to the airports destination list
        destAirport.addDestFlight(line[idCol]);

        International newInternational = new International(line[idCol], line[flightNumCol], origAirport,
                destAirport,
                line[depDateCol], line[depTimeCol], line[durationCol], line[distanceCol], line[timeZoneDiffCol],
                line[arrDateCol],
                line[arrTimeCol], line[flightTypeCol], line[surchargeCol], line[foodServedCol], line[routeCostCol],
                line[minerPointsCol],
                line[totalSeatsCol], line[firClassSeatsCol], line[buisnClassSeatsCol], line[mainCabnSeatsCol],
                line[firClassPriceCol],
                line[businClassPriceCol], line[mainCabnPriceCol]);

        return newInternational;
    }

    /**
     * Creates a Domestic object using the columns and returns the new Domestic
     * object
     * 
     * @param line String array with information of the new Flight
     * @return Domestic Return a Domestic object
     */
    public Domestic createDomestic(String[] line) {
        Airport origAirport;
        if (this.airportList.containsKey(line[origCodeCol])) {
            origAirport = this.airportList.get(line[origCodeCol]);
        } else {
            origAirport = new Airport(line[origAirportCol], line[origCodeCol], line[origCityCol],
                    line[origStateCol], line[origCountryCol], line[origFeeCol], line[origLoungeCol]);
            this.airportList.put(line[origCodeCol], origAirport);
        }
        // Add the id of the flight to the airports origin list\
        origAirport.addOrigFlight(line[idCol]);

        Airport destAirport;
        if (this.airportList.containsKey(line[destCodeCol])) {
            destAirport = this.airportList.get(line[destCodeCol]);
        } else {
            destAirport = new Airport(line[destAirportCol], line[destCodeCol], line[destCityCol],
                    line[destStateCol], line[destCountryCol], line[destFeeCol], line[destLoungeCol]);
            this.airportList.put(line[destCodeCol], destAirport);
        }
        // Add the id of the flight to the airports destination list
        destAirport.addDestFlight(line[idCol]);

        Domestic newDomestic = new Domestic(line[idCol], line[flightNumCol], origAirport, destAirport,
                line[depDateCol], line[depTimeCol], line[durationCol], line[distanceCol], line[timeZoneDiffCol],
                line[arrDateCol],
                line[arrTimeCol], line[flightTypeCol], line[surchargeCol], line[foodServedCol], line[routeCostCol],
                line[minerPointsCol],
                line[totalSeatsCol], line[firClassSeatsCol], line[buisnClassSeatsCol], line[mainCabnSeatsCol],
                line[firClassPriceCol],
                line[businClassPriceCol], line[mainCabnPriceCol]);

        return newDomestic;
    }

    // Getters and Setters

    /**
     * Returns ID col
     * 
     * @return int ID col
     */
    public int getIdCol() {
        return idCol;
    }

    /**
     * Sets ID col
     * 
     * @param idCol ID col
     */
    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    /**
     * Returns the Flight num col
     * 
     * @return int Flight number col
     */
    public int getFlightNumCol() {
        return flightNumCol;
    }

    /**
     * Sets the Flight num col
     * 
     * @param flightNumCol Flight number col
     */
    public void setFlightNumCol(int flightNumCol) {
        this.flightNumCol = flightNumCol;
    }

    /**
     * Returns the Origin Airport col
     * 
     * @return int Origin Airport col
     */
    public int getOrigAirportCol() {
        return origAirportCol;
    }

    /**
     * Changes the Origin Airport col
     * 
     * @param origAirportCol Origin Airport cl
     */
    public void setOrigAirportCol(int origAirportCol) {
        this.origAirportCol = origAirportCol;
    }

    /**
     * Returns the origin airport code
     * 
     * @return int airport code
     */
    public int getOrigCodeCol() {
        return origCodeCol;
    }

    /**
     * Changes the origin airport code
     * 
     * @param origCodeCol airport code
     */
    public void setOrigCodeCol(int origCodeCol) {
        this.origCodeCol = origCodeCol;
    }

    /**
     * Return the origin city col
     * 
     * @return int origin city col
     */
    public int getOrigCityCol() {
        return origCityCol;
    }

    /**
     * Sets the origin city col
     * 
     * @param origCityCol origin city col
     */
    public void setOrigCityCol(int origCityCol) {
        this.origCityCol = origCityCol;
    }

    /**
     * Returns the origin state col
     * 
     * @return int origin state col
     */
    public int getOrigStateCol() {
        return origStateCol;
    }

    /**
     * Sets the origin state col
     * 
     * @param origStateCol Origin state col
     */
    public void setOrigStateCol(int origStateCol) {
        this.origStateCol = origStateCol;
    }

    /**
     * Returns the origin country col
     * 
     * @return int origin county col
     */
    public int getOrigCountryCol() {
        return origCountryCol;
    }

    /**
     * Sets the origin country col
     * 
     * @param origCountryCol Origin county col
     */
    public void setOrigCountryCol(int origCountryCol) {
        this.origCountryCol = origCountryCol;
    }

    /**
     * Returns the origin fee col
     * 
     * @return int Origin fee col
     */
    public int getOrigFeeCol() {
        return origFeeCol;
    }

    /**
     * Changes the origin fee col
     * 
     * @param origFeeCol Origin fee col
     */
    public void setOrigFeeCol(int origFeeCol) {
        this.origFeeCol = origFeeCol;
    }

    /**
     * Returns the origin lounge col
     * 
     * @return int Origin lunge col
     */
    public int getOrigLoungeCol() {
        return origLoungeCol;
    }

    /**
     * Sets the origin lounge col
     * 
     * @param origLoungeCol Origin lounge col
     */
    public void setOrigLoungeCol(int origLoungeCol) {
        this.origLoungeCol = origLoungeCol;
    }

    /**
     * Returns the destination airport col
     * 
     * @return int destination airport col
     */
    public int getDestAirportCol() {
        return destAirportCol;
    }

    /**
     * Sets the destination airport col
     * 
     * @param destAirportCol Airport cl
     */
    public void setDestAirportCol(int destAirportCol) {
        this.destAirportCol = destAirportCol;
    }

    /**
     * Return the Destination code col
     * 
     * @return int Destination code col
     */
    public int getDestCodeCol() {
        return destCodeCol;
    }

    /**
     * Sets the destination code col
     * 
     * @param destCodeCol code col
     */
    public void setDestCodeCol(int destCodeCol) {
        this.destCodeCol = destCodeCol;
    }

    /**
     * Returns the Destination city col
     * 
     * @return int City col
     */
    public int getDestCityCol() {
        return destCityCol;
    }

    /**
     * Sets the destination city col
     * 
     * @param destCityCol city col
     */
    public void setDestCityCol(int destCityCol) {
        this.destCityCol = destCityCol;
    }

    /**
     * Returns the dest state col
     * 
     * @return int State col
     */
    public int getDestStateCol() {
        return destStateCol;
    }

    /**
     * Sets the dest state col
     * 
     * @param destStateCol State col
     */
    public void setDestStateCol(int destStateCol) {
        this.destStateCol = destStateCol;
    }

    /**
     * Returns the dest country col
     * 
     * @return int Country col
     */
    public int getDestCountryCol() {
        return destCountryCol;
    }

    /**
     * Sets the dest country col
     * 
     * @param destCountryCol country col
     */
    public void setDestCountryCol(int destCountryCol) {
        this.destCountryCol = destCountryCol;
    }

    /**
     * Returns the dest fee col
     * 
     * @return int Fee col
     */
    public int getDestFeeCol() {
        return destFeeCol;
    }

    /**
     * Sets the dest fee col
     * 
     * @param destFeeCol Fee ol
     */
    public void setDestFeeCol(int destFeeCol) {
        this.destFeeCol = destFeeCol;
    }

    /**
     * Returns dest lounge col
     * 
     * @return int Lounge col
     */
    public int getDestLoungeCol() {
        return destLoungeCol;
    }

    /**
     * Sets dest lounge col
     * 
     * @param destLoungeCol Lounge col
     */
    public void setDestLoungeCol(int destLoungeCol) {
        this.destLoungeCol = destLoungeCol;
    }

    /**
     * Returns the departure date col
     * 
     * @return int Departure date col
     */
    public int getDepDateCol() {
        return depDateCol;
    }

    /**
     * Sets the departure date col
     * 
     * @param depDateCol
     */
    public void setDepDateCol(int depDateCol) {
        this.depDateCol = depDateCol;
    }

    /**
     * Returns the departure time col
     * 
     * @return int Departure time col
     */
    public int getDepTimeCol() {
        return depTimeCol;
    }

    /**
     * Sets the departure time col
     * 
     * @param depTimeCol Departure time col
     */
    public void setDepTimeCol(int depTimeCol) {
        this.depTimeCol = depTimeCol;
    }

    /**
     * Returns the duration col
     * 
     * @return int Duration col
     */
    public int getDurationCol() {
        return durationCol;
    }

    /**
     * Sets the duration col
     * 
     * @param durationCol Duration col
     */
    public void setDurationCol(int durationCol) {
        this.durationCol = durationCol;
    }

    /**
     * Returns the distance col
     * 
     * @return int Distance col
     */
    public int getDistanceCol() {
        return distanceCol;
    }

    /**
     * Sets the distance col
     * 
     * @param distanceCol Distance col
     */
    public void setDistanceCol(int distanceCol) {
        this.distanceCol = distanceCol;
    }

    /**
     * Returns the time zone difference col
     * 
     * @return int Time zone difference col
     */
    public int getTimeZoneDiffCol() {
        return timeZoneDiffCol;
    }

    /**
     * Sets the time zone difference col
     * 
     * @param timeZoneDiffCol Time zone difference col
     */
    public void setTimeZoneDiffCol(int timeZoneDiffCol) {
        this.timeZoneDiffCol = timeZoneDiffCol;
    }

    /**
     * Returns the arrival date col
     * 
     * @return int Arrival date col
     */
    public int getArrDateCol() {
        return arrDateCol;
    }

    /**
     * Sets the arrival date col
     * 
     * @param arrDateCol Arrival date col
     */
    public void setArrDateCol(int arrDateCol) {
        this.arrDateCol = arrDateCol;
    }

    /**
     * Returns the arrival time col
     * 
     * @return int Arrival time col
     */
    public int getArrTimeCol() {
        return arrTimeCol;
    }

    /**
     * Sets the arrival time col
     * 
     * @param arrTimeCol Arrival time col
     */
    public void setArrTimeCol(int arrTimeCol) {
        this.arrTimeCol = arrTimeCol;
    }

    /**
     * Returns the Flight Type col
     * 
     * @return int Flight type col
     */
    public int getFlightTypeCol() {
        return flightTypeCol;
    }

    /**
     * Sets the flight type col
     * 
     * @param flightTypeCol Flight type col
     */
    public void setFlightTypeCol(int flightTypeCol) {
        this.flightTypeCol = flightTypeCol;
    }

    /**
     * Returns the surcharge col
     * 
     * @return int Surcharge col
     */
    public int getSurchargeCol() {
        return surchargeCol;
    }

    /**
     * Sets the surcharge col
     * 
     * @param surchargeCol Surcharge col
     */
    public void setSurchargeCol(int surchargeCol) {
        this.surchargeCol = surchargeCol;
    }

    /**
     * Returns food served col
     * 
     * @return int Food served col
     */
    public int getFoodServedCol() {
        return foodServedCol;
    }

    /**
     * Sets the food served col
     * 
     * @param foodServedCol Food served col
     */
    public void setFoodServedCol(int foodServedCol) {
        this.foodServedCol = foodServedCol;
    }

    /**
     * Returns the route cost col
     * 
     * @return int Route cost col
     */
    public int getRouteCostCol() {
        return routeCostCol;
    }

    /**
     * Sets the route cost col
     * 
     * @param routeCostCol Route cost col
     */
    public void setRouteCostCol(int routeCostCol) {
        this.routeCostCol = routeCostCol;
    }

    /**
     * Returns the miner points col
     * 
     * @return int Miner points col
     */
    public int getMinerPointsCol() {
        return minerPointsCol;
    }

    /**
     * Sets the miner points col
     * 
     * @param minerPointsCol Miner points col
     */
    public void setMinerPointsCol(int minerPointsCol) {
        this.minerPointsCol = minerPointsCol;
    }

    /**
     * Returns the total seats col
     * 
     * @return int Total seats col
     */
    public int getTotalSeatsCol() {
        return totalSeatsCol;
    }

    /**
     * Sets total seats col
     * 
     * @param totalSeatsCol Total seats col
     */
    public void setTotalSeatsCol(int totalSeatsCol) {
        this.totalSeatsCol = totalSeatsCol;
    }

    /**
     * Returns the fir class seats col
     * 
     * @return int Fir class seats col
     */
    public int getFirClassSeatsCol() {
        return firClassSeatsCol;
    }

    /**
     * Sets the fir class seats col
     * 
     * @param firClassSeatsCol Fir class seats col
     */
    public void setFirClassSeatsCol(int firClassSeatsCol) {
        this.firClassSeatsCol = firClassSeatsCol;
    }

    /**
     * Returns the Business class seats col
     * 
     * @return int Business class seats col
     */
    public int getBuisnClassSeatsCol() {
        return buisnClassSeatsCol;
    }

    /**
     * Sets the Business class seats col
     * 
     * @param buisnClassSeatsCol Business class seats col
     */
    public void setBuisnClassSeatsCol(int buisnClassSeatsCol) {
        this.buisnClassSeatsCol = buisnClassSeatsCol;
    }

    /**
     * Returns the main cabin seats col
     * 
     * @return int Main cabin seats col
     */
    public int getMainCabnSeatsCol() {
        return mainCabnSeatsCol;
    }

    /**
     * Sets the main cabin seats col
     * 
     * @param mainCabnSeatsCol Main cabin seats col
     */
    public void setMainCabnSeatsCol(int mainCabnSeatsCol) {
        this.mainCabnSeatsCol = mainCabnSeatsCol;
    }

    /**
     * Returns the First class price col
     * 
     * @return int First class price col
     */
    public int getFirClassPriceCol() {
        return firClassPriceCol;
    }

    /**
     * Sets the First class price col
     * 
     * @param firClassPriceCol First calss price col
     */
    public void setFirClassPriceCol(int firClassPriceCol) {
        this.firClassPriceCol = firClassPriceCol;
    }

    /**
     * Returns the business class price col
     * 
     * @return int Business class price col
     */
    public int getBusinClassPriceCol() {
        return businClassPriceCol;
    }

    /**
     * Sets the business class price col
     * 
     * @param businClassPriceCol Business class price col
     */
    public void setBusinClassPriceCol(int businClassPriceCol) {
        this.businClassPriceCol = businClassPriceCol;
    }

    /**
     * Returns the main cabin price col
     * 
     * @return int Main cabin price col
     */
    public int getMainCabnPriceCol() {
        return mainCabnPriceCol;
    }

    /**
     * Sets the main cabin price col
     * 
     * @param mainCabnPriceCol Main cabin price col
     */
    public void setMainCabnPriceCol(int mainCabnPriceCol) {
        this.mainCabnPriceCol = mainCabnPriceCol;
    }

    /**
     * Returns the hashmap of all the airports
     * 
     * @return HashMapn of airports with a key of the airport codes
     */
    public HashMap<String, Airport> getAirportList() {
        return airportList;
    }

    /**
     * Sets the airport list hashmap
     * 
     * @param airportList HashMap of airports
     */
    public void setAirportList(HashMap<String, Airport> airportList) {
        this.airportList = airportList;
    }

}