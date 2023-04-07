import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
public class  FileFactory {

    private HashMap<String, Integer> allFlightIndexes = new HashMap<String, Integer>();
    private HashMap<String, Integer> allCustomerIndexes = new HashMap<String, Integer>();

    public void setFlightMap(HashMap<String, Integer> allFlightIndexes){
        this.allFlightIndexes = allFlightIndexes;
    }
    public HashMap<String, Integer> getFlightMap(){
        return this.allFlightIndexes;
    }

    FileFactory(){}


    public void generateHashMapForFlightFile()throws FileNotFoundException{
        Scanner flightScan = new Scanner(new File("FlightSchedulePA4.csv"));  //scanner for file conatining flights
        String flightLine = flightScan.nextLine();
        String [] flightInfo = flightLine.split(",");
        
        allFlightIndexes.put("Duration", 8);

        for(int i = 0; i < flightInfo.length; i ++){
            //System.out.println(flightInfo[i]);
            allFlightIndexes.put(flightInfo[i], i);
            

        }

    } 
    public void generateHashMapForCustomerFile()throws FileNotFoundException{
        Scanner customerScan = new Scanner(new File("CustomerListPA4.csv"));  //scanner for file conatining flights
        String customerLine = customerScan.nextLine();
        String [] customerInfo = customerLine.split(",");

        for(int i = 0; i < customerInfo.length; i ++){
            //System.out.println(flightInfo[i]);
            allCustomerIndexes.put(customerInfo[i], i);

        }

    }     

    public Customer generateCustomerObject(String[] customerInfo){      
        Customer currCustomer = new Customer(customerInfo[allCustomerIndexes.get("ID")] ,customerInfo[allCustomerIndexes.get("First Name")], customerInfo[allCustomerIndexes.get("Last Name")], customerInfo[allCustomerIndexes.get("DOB")], customerInfo[allCustomerIndexes.get("Role")], Double.valueOf(customerInfo[allCustomerIndexes.get("Money Available")]), Integer.parseInt(customerInfo[allCustomerIndexes.get("Flights Purchased")]), Boolean.valueOf(customerInfo[allCustomerIndexes.get("MinerAirlines Membership")]), customerInfo[allCustomerIndexes.get("Username")], customerInfo[allCustomerIndexes.get("Password")]);
        return currCustomer;
    }     
    public Employee generateEmployeeObject(String[] customerInfo){
        Employee currEmployee = new Employee(customerInfo[allCustomerIndexes.get("ID")] ,customerInfo[allCustomerIndexes.get("First Name")], customerInfo[allCustomerIndexes.get("Last Name")], customerInfo[allCustomerIndexes.get("DOB")], customerInfo[allCustomerIndexes.get("Role")], Double.valueOf(customerInfo[allCustomerIndexes.get("Money Available")]), Integer.parseInt(customerInfo[allCustomerIndexes.get("Flights Purchased")]), Boolean.valueOf(customerInfo[allCustomerIndexes.get("MinerAirlines Membership")]), customerInfo[allCustomerIndexes.get("Username")], customerInfo[allCustomerIndexes.get("Password")]);
        return currEmployee;
    }  
    public void printMap(){
        for(String key: this.allCustomerIndexes.keySet()){
            System.out.println(key + ": " + this.allCustomerIndexes.get(key));
        }
    }
    public Flight generateFlightObject(String[] flightInfo){



        OriginAirport originAirport = new OriginAirport(flightInfo[allFlightIndexes.get("Origin Airport")], flightInfo[allFlightIndexes.get("Origin Airport City")], flightInfo[allFlightIndexes.get("Origin Airport State")],
        flightInfo[allFlightIndexes.get("Origin Airport Country")], flightInfo[allFlightIndexes.get("Origin Code")], Double.parseDouble(flightInfo[allFlightIndexes.get("Origin Airport Fee")]), Boolean.valueOf(flightInfo[allFlightIndexes.get("Origin Airport Lounge")]));

        DestinationAirport destinationAirport = new DestinationAirport(flightInfo[allFlightIndexes.get("Destination Airport")], flightInfo[allFlightIndexes.get("Destination Airport City")], flightInfo[allFlightIndexes.get("Destination Airport State")],
        flightInfo[allFlightIndexes.get("Destination Airport Country")], flightInfo[allFlightIndexes.get("Destination Code")], Double.parseDouble(flightInfo[allFlightIndexes.get("Destination Airport Fee")]), Boolean.valueOf(flightInfo[allFlightIndexes.get("Destination Airport Lounge")]));

        Flight currFlight = new Flight(flightInfo[allFlightIndexes.get("ID")], flightInfo[allFlightIndexes.get("Flight Number")], originAirport, destinationAirport, flightInfo[allFlightIndexes.get("Departing Date")], flightInfo[allFlightIndexes.get("Departing Time")], flightInfo[allFlightIndexes.get("Arrival Date")], flightInfo[allFlightIndexes.get("Arrival Time")],
                                  Integer.parseInt(flightInfo[allFlightIndexes.get("Duration")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Distance")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Time Zone Difference")]), flightInfo[allFlightIndexes.get("Type")], Integer.parseInt(flightInfo[allFlightIndexes.get("Surcharge")]), 
                                  Boolean.valueOf(flightInfo[allFlightIndexes.get("Food Served")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Route Cost")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Miner Points")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Total Seats")]), Integer.parseInt(flightInfo[allFlightIndexes.get("First Class Seats")]),
                                  Integer.parseInt(flightInfo[allFlightIndexes.get("Business Class Seats")]),Integer.parseInt(flightInfo[allFlightIndexes.get("Main Cabin Seats")]), Integer.parseInt(flightInfo[allFlightIndexes.get("First Class Price")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Business Class Price")]), Integer.parseInt(flightInfo[allFlightIndexes.get("Main Cabin Price")]));

        return currFlight;
    }
    public Airport generateAirportObject(String[] flightInfo){
        Airport airport = new Airport(flightInfo[allFlightIndexes.get("Origin Airport")], flightInfo[allFlightIndexes.get("Origin Airport City")], flightInfo[allFlightIndexes.get("Origin Airport State")],
        flightInfo[allFlightIndexes.get("Origin Airport Country")], flightInfo[allFlightIndexes.get("Origin Code")], Double.parseDouble(flightInfo[allFlightIndexes.get("Origin Airport Fee")]), Boolean.valueOf(flightInfo[allFlightIndexes.get("Origin Airport Lounge")]));
        return airport;
    }
}
