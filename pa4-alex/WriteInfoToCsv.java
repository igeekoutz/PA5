import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteInfoToCsv {
    private File flightFile;
    private File customerFile;
    private FileWriter writer;

    /**
     * Default Constructor
     */
    public WriteInfoToCsv() {

    }

    /**
     * Writes updated infromation for International to a new csv file
     * 
     * @param flightMapIn HashMap with lists of International flight
     */
    public void writeInternational(HashMap<String, International> flightMapIn) {
        try {
            flightFile = new File("./FlightScheduleUpdates.csv");
            writer = new FileWriter(flightFile);

            // header
            writer.write(
                    "ID,Flight Number,Origin Airport,Origin Code,Destination Airport," +
                            "Destination Code,Departing Date,Departing Time,Duration,Distance," +
                            "Time Zone Difference,Arrival Date,Arrival Time,Flight Type, Surcharge," +
                            "Food Served,Route Cost,Miner Points,Total Seats,First Class Seats," +
                            "Business Class Seats,Main Cabin Seats,First Class Price,Business Class Price" +
                            ",Main Cabin Price,First Class Seats Sold,Business Class Seats Sold,Main " +
                            "Cabin Seats Sold,Total First Class Revenue,Total Business Class Revenue," +
                            "Total Main Cabin Revenue");
            writer.write('\n');

            for (Flight value : flightMapIn.values()) {
                writer.write(value.getId() + "," + value.getFlightNumber() + "," + value.getOrigAirportName() + ","
                        + value.getOrigCode() + "," + value.getDestAirportName()
                        + "," + value.getDestCode() + "," + value.getDepDate() + "," + value.getDepTime() + ","
                        + value.getDuration() + "," + value.getDistance() + "," +
                        value.getTimeZoneDiff() + "," + value.getArrDate() + "," + value.getArrTime() + ","
                        + value.getFlightType() + "," + value.getSurcharge() + "," +
                        value.isFoodServed() + "," + value.getRouteCost() + "," + value.getMinerPoints() + ","
                        + value.getTotalSeats() + "," + value.getFirClassSeats() + "," +
                        value.getBusinClassSeats() + "," + value.getMainCabnSeats() + "," + value.getFirClassPrice()
                        + "," + value.getBusinClassPrice() + "," +
                        value.getMainCabnPrice() + "," + value.getFirClassSeatsSold() + ","
                        + value.getBusinClassSeatsSold() + "," + value.getMainCabnSeatsSold() + "," +
                        value.getFirClassRevenue() + "," + value.getBusinClassRevenue() + ","
                        + value.getMainCabnRevenue());

                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating File writer \n" + e);
        }
    }

    /**
     * Writes updated infromation for the Domestic to a new csv file
     * 
     * @param flightMapIn HashMap with lists of Domestic flight
     */
    public void writeDomestic(HashMap<String, Domestic> flightMapIn) {
        try {
            // Append the Domestic files to the Flight Schedule
            flightFile = new File("./FlightScheduleUpdates.csv");
            writer = new FileWriter(flightFile, true);

            for (Flight value : flightMapIn.values()) {
                writer.write(value.getId() + "," + value.getFlightNumber() + "," + value.getOrigAirportName() + ","
                        + value.getOrigCode() + "," + value.getDestAirportName()
                        + "," + value.getDestCode() + "," + value.getDepDate() + "," + value.getDepTime() + ","
                        + value.getDuration() + "," + value.getDistance() + "," +
                        value.getTimeZoneDiff() + "," + value.getArrDate() + "," + value.getArrTime() + ","
                        + value.getFlightType() + "," + value.getSurcharge() + "," +
                        value.isFoodServed() + "," + value.getRouteCost() + "," + value.getMinerPoints() + ","
                        + value.getTotalSeats() + "," + value.getFirClassSeats() + "," +
                        value.getBusinClassSeats() + "," + value.getMainCabnSeats() + "," + value.getFirClassPrice()
                        + "," + value.getBusinClassPrice() + "," +
                        value.getMainCabnPrice() + "," + value.getFirClassSeatsSold() + ","
                        + value.getBusinClassSeatsSold() + "," + value.getMainCabnSeatsSold() + "," +
                        value.getFirClassRevenue() + "," + value.getBusinClassRevenue() + ","
                        + value.getMainCabnRevenue());

                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating File writer \n" + e);
        }
    }

    /**
     * Writes updated infromation for the Customer to a new csv file
     * 
     * @param customerMapIn HashMap with lists of Customers
     */
    public void writeCustomer(HashMap<String, Customer> customerMapIn) {
        try {
            customerFile = new File("./CustomerListUpdates.csv");
            writer = new FileWriter(customerFile);

            // header
            writer.write(
                    "ID,First Name,Last Name,DOB,Role,Moeny Available,Flights Pruchased," +
                            "Miner Air Membership,Username,Password");
            writer.write('\n');

            for (Customer value : customerMapIn.values()) {
                writer.write(value.getId() + "," + value.getFirstName() + "," + value.getLastName() + ","
                        + value.getDOB() + "," + value.getRole() + "," +
                        value.getMoneyAvailable() + "," + value.getFlightsPurchased() + "," + value.isMaMember() + ","
                        + value.getUsername() + "," + value.getPassword());

                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating File writer \n" + e);
        }
    }

    /**
     * Writes updated infromation for the Employee to a new csv file
     * 
     * @param employeeMapIn HashMap with lists of Emloyees
     */
    public void writeEmployee(HashMap<String, Employee> employeeMapIn) {
        try {
            // Append the Emplyee files to the Customer List
            customerFile = new File("./CustomerListUpdates.csv");
            writer = new FileWriter(customerFile, true);

            for (Employee value : employeeMapIn.values()) {
                writer.write(value.getId() + "," + value.getFirstName() + "," + value.getLastName() + ","
                        + value.getDOB() + "," + value.getRole() + "," +
                        value.getMoneyAvailable() + "," + value.getFlightsPurchased() + "," + value.isMaMember() + ","
                        + value.getUsername() + "," + value.getPassword());

                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating File writer \n" + e);
        }
    }

}
