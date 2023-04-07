public class OriginAirport {
    private String originAirport;
    private String originAirportCity;
    private String originAirportState;
    private String originAirportCountry;
    private String originCode;
    private double originAirportFee;
    private Boolean originAirportLounge;

    OriginAirport(){}

    OriginAirport( String originAirport,
    String originAirportCity,
    String originAirportState,
    String originAirportCountry,
    String originCode,
    double originAirportFee,
    Boolean originAirportLounge){
        this.originAirport = originAirport;
        this.originAirportState = originAirportState;
        this.originAirportCity = originAirportCity;
        this.originAirportCountry = originAirportCountry;
        this.originCode = originCode;
        this.originAirportFee = originAirportFee;
        this.originAirportLounge = originAirportLounge;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getOriginAirportCity() {
        return originAirportCity;
    }

    public void setOriginAirportCity(String originAirportCity) {
        this.originAirportCity = originAirportCity;
    }

    public String getOriginAirportState() {
        return originAirportState;
    }

    public void setOriginAirportState(String originAirportState) {
        this.originAirportState = originAirportState;
    }

    public String getOriginAirportCountry() {
        return originAirportCountry;
    }

    public void setOriginAirportCountry(String originAirportCountry) {
        this.originAirportCountry = originAirportCountry;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public double getOriginAirportFee() {
        return originAirportFee;
    }

    public void setOriginAirportFee(double originAirportFee) {
        this.originAirportFee = originAirportFee;
    }

    public boolean isOriginAirportLounge() {
        return originAirportLounge;
    }

    public void setOriginAirportLounge(boolean originAirportLounge) {
        this.originAirportLounge = originAirportLounge;
    }

    
}
