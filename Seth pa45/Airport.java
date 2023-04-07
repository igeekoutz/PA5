import java.util.HashMap;
public class Airport {
    private String airport;
    private String airportCity;
    private String airportState;
    private String airportCountry;
    private String code;
    private double airportFee;
    private Boolean airportLounge;
    Airport( String Airport,
    String AirportCity,
    String AirportState,
    String AirportCountry,
    String Code,
    double AirportFee,
    Boolean AirportLounge){
        this.airport = Airport;
        this.airportState = AirportState;
        this.airportCity = AirportCity;
        this.airportCountry = AirportCountry;
        this.code = Code;
        this.airportFee = AirportFee;
        this.airportLounge = AirportLounge;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportState() {
        return airportState;
    }

    public void setAirportState(String airportState) {
        this.airportState = airportState;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAirportFee() {
        return airportFee;
    }

    public void setAirportFee(double airportFee) {
        this.airportFee = airportFee;
    }

    public Boolean getAirportLounge() {
        return airportLounge;
    }

    public void setAirportLounge(Boolean airportLounge) {
        this.airportLounge = airportLounge;
    }
    
}
