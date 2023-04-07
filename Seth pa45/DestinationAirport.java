public class DestinationAirport {
    private  String destinationAirport;
    private String destinationAirportCity;
    private String destinationAirportState;
    private String destinationAiportCountry;
    private String destinationCode;
    private double destinationAirportFee;
    private boolean destinationAirportLounge;

    DestinationAirport(){}
    
    DestinationAirport( String destinationAirport,
    String destinationAirportCity,
    String destinationAirportState,
    String destinationAirportCountry,
    String destinationCode,
    double destinationAirportFee,
    Boolean destinationAirportLounge){
        this.destinationAirport = destinationAirport;
        this.destinationAirportState = destinationAirportState;
        this.destinationAirportCity = destinationAirportCity;
        this.destinationAiportCountry = destinationAirportCountry;
        this.destinationCode = destinationCode;
        this.destinationAirportFee = destinationAirportFee;
        this.destinationAirportLounge = destinationAirportLounge;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDestinationAirportCity() {
        return destinationAirportCity;
    }

    public void setDestinationAirportCity(String destinationAirportCity) {
        this.destinationAirportCity = destinationAirportCity;
    }

    public String getDestinationAirportState() {
        return destinationAirportState;
    }

    public void setDestinationAirportState(String destinationAirportState) {
        this.destinationAirportState = destinationAirportState;
    }

    public String getDestinationAiportCountry() {
        return destinationAiportCountry;
    }

    public void setDestinationAiportCountry(String destinationAiportCountry) {
        this.destinationAiportCountry = destinationAiportCountry;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public double getDestinationAirportFee() {
        return destinationAirportFee;
    }

    public void setDestinationAirportFee(double destinationAirportFee) {
        this.destinationAirportFee = destinationAirportFee;
    }

    public boolean isDestinationAirportLounge() {
        return destinationAirportLounge;
    }

    public void setDestinationAirportLounge(boolean destinationAirportLounge) {
        this.destinationAirportLounge = destinationAirportLounge;
    }

    
}
