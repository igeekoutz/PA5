import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
//import java.util.HashSet;

/**
 * This Data class will handle informaiton, adjuct infromation and return
 * infromation to the RunFlight class.
 * It calls other methods and keeps track of information.
 * 
 * @version 3.0
 */
public class Data {
    private FileWriter logFile;
    private HashMap<String, International> internationalMap;
    private HashMap<String, Domestic> domesticMap;
    private HashMap<String, Customer> customerMap;
    private HashMap<String, Employee> employeeMap;
    private HashMap<String, Airport> airportList;
    private Flight curFlight;
    private CurUserSingleton curUser;
    private int confirmationNumber;

    /**
     * Default constructor for Data and resets the log file
     */
    public Data() {
        try {
            // Create a new log file
            this.logFile = new FileWriter("./log.txt", false);
        } catch (IOException e) {
            System.out.println("Error creating new log file");
        }
    }

    /**
     * Sets up the log file and records Users actions to the log file
     * 
     * @param information actions to be written to the log file
     * @param enterExit   Keeps track if this is an enter or exit action
     */
    public void writeToLog(String information, boolean enterExit) {
        try {
            this.logFile = new FileWriter("./log.txt", true);
            if (enterExit) {
                this.logFile.write("\n" + information);
            } else {
                this.logFile.write("\n \t" + information);
            }
            this.logFile.close();
        } catch (IOException e) {
            System.out.print("Error writing to log");
        }
    }

    /**
     * This method is in charge of taking in a csv file name and reading the data
     * then
     * inputting it into a Hashmap to store flight data
     * 
     * @param fileName Name of the file with the Flight information from RunFlight
     * @return boolean returns if the method ran correctly
     */
    public boolean populateFlights(String fileName) {
        // HasMap to store Flights in
        this.internationalMap = new HashMap<String, International>();
        this.domesticMap = new HashMap<String, Domestic>();
        FlightFactory flightFactory = new FlightFactory();

        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            // Get the col for each attribute at the header and get the Flight Type col
            String[] headerLine = null;
            int flightTypeCol;
            if (sc.hasNextLine()) {
                headerLine = sc.nextLine().split(",");
            }
            // use the factory to assign the rest of the header
            flightTypeCol = flightFactory.assignCols(headerLine);

            // Iterate through each line and create a flight object for each line
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                switch (line[flightTypeCol]) {
                    case "International":
                        International newInternational = flightFactory.createInternational(line);
                        this.internationalMap.put(String.valueOf(newInternational.getId()), newInternational);
                        break;
                    case "Domestic":
                        Domestic newDomestic = flightFactory.createDomestic(line);
                        this.domesticMap.put(String.valueOf(newDomestic.getId()), newDomestic);
                        break;
                }
            }
            // Get the airport list after all the flights have been added and the airport
            // list has been createdc
            this.airportList = flightFactory.getAirportList();

            // If flights was populated without any errors return true
            return true;
        } catch (ArrayIndexOutOfBoundsException a) {
            writeToLog("Error while populating flights: " + a.getMessage(), false);
            System.out.print("Error while populating flights data. Verify information is correct format.");
            return false;
        } catch (HeaderException e) {
            writeToLog("Error while populating flights: " + e.getMessage(), false);
            System.out.println("Error while populating flights: \n" + e.getMessage());
            return false;
        } catch (FileNotFoundException f) {
            writeToLog("Error reading FLight file: " + f.getMessage(), false);
            System.out.print("Error reading Flight file: \n" + f);
            return false;
        }
    }

    /**
     * This method is in charge of taking in a csv file name and reading the data
     * then
     * populating it into a Hashmap to store Users data.
     * 
     * @param fileName Name of the customer file with the Customer information from
     *                 RunFlight
     * @return boolean returns if the method ran correctly
     */
    public boolean populateCustomers(String fileName) {
        // HasMap to store Customers in
        this.customerMap = new HashMap<String, Customer>();
        this.employeeMap = new HashMap<String, Employee>();
        UserFactory userFactory = new UserFactory();

        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            // Get the col for each attribute at the header and get the Flight Type col
            String[] headerLine = null;
            int roleCol;
            if (sc.hasNextLine()) {
                headerLine = sc.nextLine().split(",");
            }
            // use the factory to assign the rest of the header
            roleCol = userFactory.assignCols(headerLine);

            // Iterate through each line and create a Customer object for each line
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                switch (line[roleCol]) {
                    case "Customer":
                        Customer newCustomer = userFactory.createCustomer(line);

                        // Insert the new Customer into the Hashmap
                        this.customerMap.put(newCustomer.getUsername(), newCustomer);
                        break;
                    case "Employee":
                        Employee newEmployee = userFactory.creatEmployee(line);

                        // Insert the new Employee into the Hashmap
                        this.employeeMap.put(newEmployee.getUsername(), newEmployee);
                        break;
                }

            }
            curUser = CurUserSingleton.getInstance();

            // If Users was populated without any errors return true
            return true;
        } catch (ArrayIndexOutOfBoundsException a) {
            writeToLog("Error populating Users: " + a.getMessage(), false);
            System.out.print("Error while populating customer data. Verify information is correct format.");
            return false;
        } catch (HeaderException e) {
            writeToLog("Error while populating Users: " + e.getMessage(), false);
            System.out.println("Error while populating Users: \n" + e.getMessage());
            return false;
        } catch (FileNotFoundException f) {
            writeToLog("Error reading Customer file: " + f.getMessage(), false);
            System.out.print("Error reading Customer file: \n" + f);
            return false;
        }
    }

    /**
     * Finds all the flights that have the origin airport code given and the
     * destination code given, then prints their information
     * 
     * @param origCode Origin code of the airport
     * @param destCode Destination code of the airport
     * @return If a flight is found with the code it returns true
     */
    public boolean checkCode(String origCode, String destCode) {
        boolean flightsFound = false;

        // Check if both codes are valid airport codes
        if (this.airportList.containsKey(origCode) && this.airportList.containsKey(destCode)) {
            // Itrate through the list of flights in the origin airport
            for (String flightId : this.airportList.get(origCode).getOrigFlights()) {
                if (this.airportList.get(destCode).getDestFlights().contains(flightId)) {
                    checkId(flightId);
                    this.curFlight.shortPrintFlight();
                    flightsFound = true;
                }
            }
        }

        return flightsFound;
    }

    /**
     * Checks the Flight ID and sets it as the curFlight
     * 
     * @param userInput flight id given in from RunFlight
     * @return boolean Returns if the flight exists or not
     */
    public boolean checkId(String userInput) {
        // Check if the current flight Exists
        if (this.internationalMap.containsKey(userInput)) {
            this.curFlight = this.internationalMap.get(userInput);
            return true;
        } else if (this.domesticMap.containsKey(userInput)) {
            this.curFlight = this.domesticMap.get(userInput);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the username given is a valid username that is stored then assigns
     * the curUser in the UserSingleton
     * 
     * @param userInput Username given
     * @return boolean Returns if the user exists or not
     */
    public boolean checkUsername(String userInput) {
        if (this.customerMap.containsKey(userInput)) {
            this.curUser.setCustomer(this.customerMap.get(userInput));
            return true;
        } else if (this.employeeMap.containsKey(userInput)) {
            this.curUser.setEmploye(this.employeeMap.get(userInput));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the first and last name matches the current user.
     * 
     * @param firstName Firstname given from RunFlight
     * @param lastName  Lastname given from RunFlight
     * @return boolean Returns if the users first and last name match the curUser
     */
    public boolean accountMatch(String firstName, String lastName) {
        if (this.curUser.getCurUserType().equals("Customer")) {
            if (this.curUser.getCustomer().getFirstName().equalsIgnoreCase(firstName)
                    && this.curUser.getCustomer().getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            if (this.curUser.getEmployee().getFirstName().equalsIgnoreCase(firstName)
                    && this.curUser.getEmployee().getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the password given from RunFlight matches the the curUser password.
     * 
     * @param userInput Password given from RunFlight
     * @return boolean Returns if the password matches the curUser password.
     */
    public boolean checkPassword(String userInput) {
        if (this.curUser.getCurUserType().equals("Customer")) {
            if (userInput.equals(this.curUser.getCustomer().getPassword())) {
                return true;
            }
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            if (userInput.equals(this.curUser.getEmployee().getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calls a flight method to print curFlight information
     */
    public void showFlightInfo() {
        this.curFlight.printFlight();
    }

    /**
     * Print the information about an airport coressponding to the airport code
     * given
     * 
     * @param airportCodeIn Airport code of the information we want to view
     * @return If an airport is found with the code given it returns true
     */
    public boolean showAirportInfo(String airportCodeIn) {
        if (this.airportList.containsKey(airportCodeIn)) {
            this.airportList.get(airportCodeIn).printAirport();
            return true;
        }
        return false;
    }

    /**
     * Calls the flight method to print the curFlight seat informaiton
     */
    public void showSeatsLeft() {
        this.curFlight.printSeatsleft();
    }

    /**
     * Calls the Flight method to print the curFlight Revenue
     */
    public void showSeatsRevenue() {
        this.curFlight.printSeatsRevenue();
    }

    /**
     * Calls the Flight method to print a list of customers that have bought tickets
     * to the curFlight
     */
    public void showCustomerList() {
        this.curFlight.printCustomerList();
    }

    /**
     * Calls the Flight method that prints the curFlights profits
     */
    public void showFlightProfits() {
        this.curFlight.printFlightProfits();
    }

    /**
     * Calls the Flight method that prints all the curFlight classes with their
     * seats left and price
     */
    public void showFlightClass() {
        this.curFlight.printFlightClasses();
    }

    /**
     * Checks if the curFlight has enough seats avaliable for the class.
     * 
     * @param classType    Class that the user wants to purchase
     * @param numOfTickets Amount of tickets that the user wants to purchase
     * @return boolean Returns if there are enough tickets for the purchase
     */
    public boolean checkSeats(String classType, int numOfTickets) {
        // Check if there are enough seats left
        switch (classType) {
            case "First Class":
                if (numOfTickets > this.curFlight.getFirClassSeats()) {
                    return false;
                }
                break;
            case "Business Class":
                if (numOfTickets > this.curFlight.getBusinClassSeats()) {
                    return false;
                }
                break;
            case "Main Cabin":
                if (numOfTickets > this.curFlight.getMainCabnSeats()) {
                    return false;
                }
                break;
        }

        return true;
    }

    /**
     * Returns the flight id of the curFlight
     * 
     * @return int flighId of the curFlight
     */
    public int getFlightID() {
        return this.curFlight.getId();
    }

    /**
     * Gets the ticketPrice based on the flight type and number of tickets the user
     * wants to purchase
     * 
     * @param classType    Class type that the user wants to purchase
     * @param numOfTickets Number of tickets that the user wants to purchase
     * @return double Returns the price of the ticketPrice
     */
    public double getFlightPrice(String classType, double numOfTickets) {
        // Calculate the price of the tickets that they chose and add a discount for
        // employees
        double ticketprice = 0;
        switch (classType) {
            case "First Class":
                ticketprice = numOfTickets * this.curFlight.getFirClassPrice();
                if (this.curFlight.getFlightType().equals("International")) {
                    ticketprice = ticketprice + (this.curFlight.getSurcharge() * numOfTickets);
                }
                if (this.curUser.getCurUserType().equals("Employee")) {
                    ticketprice = ticketprice / 2;
                }
                break;
            case "Business Class":
                ticketprice = numOfTickets * this.curFlight.getBusinClassPrice();
                if (this.curFlight.getFlightType().equals("International")) {
                    ticketprice = ticketprice + (this.curFlight.getSurcharge() * numOfTickets);
                }
                if (this.curUser.getCurUserType().equals("Employee")) {
                    ticketprice = ticketprice - (ticketprice * 0.75);
                }
                break;
            case "Main Cabin":
                ticketprice = numOfTickets * this.curFlight.getMainCabnPrice();
                if (this.curFlight.getFlightType().equals("International")) {
                    ticketprice = ticketprice + (this.curFlight.getSurcharge() * numOfTickets);
                }
                if (this.curUser.getCurUserType().equals("Employee")) {
                    ticketprice = ticketprice - (ticketprice * 0.75);
                }
                break;
        }
        // Add the fees of the origin and destination airport to the ticket price
        ticketprice += this.curFlight.getOrigAirport().getFee();
        ticketprice += this.curFlight.getDestAirport().getFee();
        return ticketprice;
    }

    /**
     * Returns the amount of savings the User will save based if they are an Miners
     * Airlines Member
     * 
     * @param ticketPrice Takes in the ticketPrice of the current purchase
     * @return double Returns the amount the user will save
     */
    public double getSavings(double ticketPrice) {
        double savings = 0;
        if (this.curUser.getCurUserType().equals("Customer")) {
            if (this.curUser.getCustomer().isMaMember()) {
                savings = ticketPrice * 0.05;
            }
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            if (this.curUser.getEmployee().isMaMember()) {
                savings = ticketPrice * 0.05;
            }
        }
        return savings;
    }

    /**
     * Return the preditermined Miners Airline fee
     * 
     * @return double Returns the fee price
     */
    public double getMaFee() {
        return 9.15;
    }

    /**
     * Returns the security fee based on the num of tickets that are going to be
     * purchased
     * 
     * @param numOfTickets Number of tickets the user wants to purchase
     * @return double Returns the price of the security fee
     */
    public double getSecurityFee(int numOfTickets) {
        return 5.60 * numOfTickets;
    }

    /**
     * Returns the sales tax for the current purchase
     * 
     * @param ticketPrice Current purchases ticket price
     * @param maSavings   current purchases Miners Airline Savings
     * @param maFee       Current purchase Miners Airline Fee
     * @param securityFee Current purchase Security Fee
     * @return double Returns the slaes tax price
     */
    public double getSalesTax(double ticketPrice, double maSavings, double maFee, double securityFee) {
        double curTotal = (ticketPrice - maSavings) + maFee + securityFee;
        double salesTax = curTotal * 0.0825;
        salesTax = Math.round(salesTax * 100) / 100;
        return salesTax;
    }

    /**
     * Checks if the curFlight has been cancelled before a user tries to purchase a
     * flight
     * 
     * @return boolean Returns if the curFlight is cancelled
     */
    public boolean checkFlightCanceled() {
        return this.curFlight.isFlightCanceled();
    }

    /**
     * Checks if the curUser has enough money to finalize the purchase
     * 
     * @param totalPrice The total price of the current purchase
     * @return boolean Returns if the user has enough funds for the purchase
     */
    public boolean checkBalance(double totalPrice) {
        if (this.curUser.getCurUserType().equals("Customer")) {
            if (this.curUser.getCustomer().getMoneyAvailable() >= totalPrice) {
                return true;
            }
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            if (this.curUser.getEmployee().getMoneyAvailable() >= totalPrice) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a new confirmation number for a ticket
     * 
     * @return int Returns confirmation number
     */
    private int getConfirmationNum() {
        this.confirmationNumber = this.confirmationNumber + 1;
        return this.confirmationNumber;
    }

    /**
     * Creats a new ticket, adds it to the curUser/curFlight, removes money from the
     * curUser, and adds the amount made to the flight
     * 
     * @param classType    Class Type of the current purchase
     * @param numOfTickets Number of tickets of the current purchase
     * @param ticketPrice  Ticket price of the current purchase
     * @param maSavings    Miners Airline Savings of the current purchase
     * @param maFee        Miners Airline Fee of the current purchase
     * @param securityFee  Security Fee of the current purchase
     * @param salesTax     Sales Tax of the current purchase
     * @param totalPrice   Total Price of the current purchase
     */
    public void validatePurchase(String classType, int numOfTickets, double ticketPrice, double maSavings,
            double maFee, double securityFee, double salesTax, double totalPrice, boolean printTicket) {
        String curUsername = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curUsername = this.curUser.getCustomer().getUsername();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            if (this.curUser.getEmployee().getMoneyAvailable() >= totalPrice) {
                curUsername = this.curUser.getEmployee().getUsername();
            }
        }
        Ticket newTicket = new Ticket(getConfirmationNum(), curUsername,
                this.curFlight.getId(), numOfTickets, classType, ticketPrice, maFee, maSavings, securityFee,
                salesTax, totalPrice);

        if (this.curUser.getCurUserType().equals("Customer")) {
            // Add the current ticket to the user and modify their total fees/savings
            this.curUser.getCustomer().addTicket(newTicket);
            this.curUser.getCustomer().incFlightsPurchased();
            this.curUser.getCustomer().decreaseMoneyAvailable(totalPrice);
            this.curUser.getCustomer().incMaFeeTotal(maFee);
            this.curUser.getCustomer().incMaSavingsTotal(maSavings);
            this.curUser.getCustomer().incSecurityFeeTotal(securityFee);
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            this.curUser.getEmployee().addTicket(newTicket);
            this.curUser.getEmployee().incFlightsPurchased();
            this.curUser.getEmployee().decreaseMoneyAvailable(totalPrice);
            this.curUser.getEmployee().incMaFeeTotal(maFee);
            this.curUser.getEmployee().incMaSavingsTotal(maSavings);
            this.curUser.getEmployee().incSecurityFeeTotal(securityFee);
        }

        // Increase the amount of fees in the airports have made for each airport
        this.curFlight.getOrigAirport().incFee();
        this.curFlight.getDestAirport().incFee();

        // Add the ticket to the flight and change the seats/revenue/taxes/savings
        this.curFlight.addTicket(newTicket);
        this.curFlight.decreaseFlightSeats(classType, numOfTickets);
        this.curFlight.increaseFlightSeatsRevenue(classType, (ticketPrice - maSavings) + maFee + securityFee);
        this.curFlight.incMaSavingsTotal(maSavings);
        this.curFlight.incSalesTaxTotal(salesTax);

        if (printTicket) {
            newTicket.printTicket();
        }
    }

    /**
     * Prints all the tickets of the curUser
     */
    public void printUserTickets() {
        HashMap<Integer, Ticket> curTickets = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curTickets = this.curUser.getCustomer().getTickets();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            curTickets = this.curUser.getEmployee().getTickets();
        }

        for (Ticket value : curTickets.values()) {
            curTickets.get(value.getConfirmationNum()).printTicket();
        }
    }

    /**
     * Checks that the confrimation number is part of the curUsers tickets
     * 
     * @param confirmationNumIn Confirmation number of the ticket
     * @return boolean Returns if the confirmation number is part of the curUsers
     *         ticket.
     */
    public boolean checkTicketConfirmationNum(int confirmationNumIn) {
        HashMap<Integer, Ticket> curTickets = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curTickets = this.curUser.getCustomer().getTickets();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            curTickets = this.curUser.getEmployee().getTickets();
        }

        if (curTickets.containsKey(confirmationNumIn)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cancells the curUsers ticket that matches the confirmation number given and
     * returns the money to the user and flight
     * 
     * @param confirmationNumIn Confrimation Number of a ticket.
     */
    public void cancelUserTicket(int confirmationNumIn) {
        HashMap<Integer, Ticket> curTickets = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curTickets = this.curUser.getCustomer().getTickets();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            curTickets = this.curUser.getEmployee().getTickets();
        }
        Ticket refundedTicket = curTickets.get(confirmationNumIn);
        // Check if the ticket has already been cancelled
        if (refundedTicket.isTicketCancelled()) {
            System.out.println("Error Ticket already Cancelled");
            return;
        }
        refundedTicket.setTicketCancelled(true);
        // Insert the seats back to the flight and remove the ticket
        try {
            // Get the flight id and return the seats back to it's class
            String flightId = Integer.toString(refundedTicket.getFlightID());
            checkId(flightId);
            String flightClass = refundedTicket.getClassType();
            int flightSeats = refundedTicket.getNumOfSeats();
            this.curFlight.increaseFlightSeats(flightClass, flightSeats);
            this.curFlight.decreaseFlightSeatsPurchased(flightClass, flightSeats);
            // Decrease the revenue, maSavings, and salestax from the ticket
            double revenue = refundedTicket.getTicketPrice();
            this.curFlight.decreaseFlightSeatsRevenue(flightClass, revenue);
            this.curFlight.decMaSavingsTotal(refundedTicket.getMaSavings());
            this.curFlight.decSalesTaxTotal(refundedTicket.getSalesTax());
            // Decrease the fees from the airports
            this.curFlight.getOrigAirport().decFee();
            this.curFlight.getDestAirport().decFee();
            // Remove the ticket from the flight
            this.curFlight.removeTicket(refundedTicket);

        } catch (NullPointerException e) {
            System.out.println("Error removing ticket");
            writeToLog("There was an error while removing ticket " + confirmationNumIn, false);
        }

        // Refund the ticketPrice, taxes and surcharge to the customer, not the maFee
        double ticketRefund = refundedTicket.getTicketPrice();
        double taxRefund = refundedTicket.getSalesTax();
        double surchargeRefund = this.curFlight.getSurcharge();
        double refundTotal = ticketRefund + taxRefund + surchargeRefund;
        if (this.curUser.getCurUserType().equals("Customer")) {
            this.curUser.getCustomer().increaseMoneyAvailable(refundTotal);
            this.curUser.getCustomer().decFlightPurchased();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            this.curUser.getEmployee().increaseMoneyAvailable(refundTotal);
            this.curUser.getEmployee().decFlightPurchased();
        }
        // Adjust the ticket to have no fees or seats and add a note
        refundedTicket.setTicketPrice(0);
        refundedTicket.setSalesTax(0);
        refundedTicket.setNotes("TICKET CANCELED!");

        // Print what was refunded to the customer
        System.out.println("\n \tAmount Refunded" +
                "\n \t-------------------" +
                "\n -Ticket Price Refund: $" + ticketRefund +
                "\n -Tax Refund: $" + taxRefund +
                "\n -Surcharge Refund: $" + surchargeRefund +
                "\n -------------------" +
                "\n -Total Refunded: $" + refundTotal);
    }

    /**
     * Cancels the users tickets and returns all the money to the user and flight
     * 
     * @param flightId           Id of the flight that is being cancelled
     * @param curConfirmationNum Confrimation Number of the ticket that is going to
     *                           be cancelled for both the Users and Flight
     */
    public void cancelUsersFlight(int flightId, int curConfirmationNum) {
        // Get the curticket from the customer and save it
        HashMap<Integer, Ticket> curTickets = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curTickets = this.curUser.getCustomer().getTickets();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            curTickets = this.curUser.getEmployee().getTickets();
        }
        Ticket canceledTicket = curTickets.get(confirmationNumber);
        if (canceledTicket.isTicketCancelled()) {
            return;
        }
        canceledTicket.setTicketCancelled(true);
        // Return ticketprice, tax, and surcharge to the customer
        double ticketRefund = canceledTicket.getTicketPrice();
        double taxRefund = canceledTicket.getSalesTax();
        double surchargeRefund = this.curFlight.getSurcharge();
        double refundTotal = ticketRefund + taxRefund + surchargeRefund;
        if (this.curUser.getCurUserType().equals("Customer")) {
            this.curUser.getCustomer().increaseMoneyAvailable(refundTotal);
            this.curUser.getCustomer().decFlightPurchased();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            this.curUser.getEmployee().increaseMoneyAvailable(refundTotal);
            this.curUser.getEmployee().decFlightPurchased();
        }

        // Decrease the fees from the airport
        this.curFlight.getOrigAirport().decFee();
        this.curFlight.getDestAirport().decFee();

        canceledTicket.setNumOfSeats(0);
        canceledTicket.setTicketPrice(0);
        canceledTicket.setSalesTax(0);
        canceledTicket.setNotes("FLIGHT CANCELED!");

        // Return the seat Revenue to the Flight
        this.curFlight.decreaseFlightSeatsRevenue(canceledTicket.getClassType(), ticketRefund);

    }

    /**
     * Cancels a Flight and sets the seats and revenue to 0.
     */
    public void cancelFlight() {
        // Change users tickets to reflect the Flight was canceled
        HashMap<Integer, Ticket> curTickets = this.curFlight.getTickets();
        for (Ticket value : curTickets.values()) {
            // Change the curUser to be the one that's in the ticket
            checkUsername(value.getUsername());
            int curFlightId = this.curFlight.getId();
            int curConfirmationNum = value.getConfirmationNum();
            cancelUsersFlight(curFlightId, curConfirmationNum);
        }
        // Change the flight information to reflect it was canceled
        this.curFlight.setFlightCanceled(true);

        this.curFlight.setFirClassSeats(0);
        this.curFlight.setBuisnClassSeats(0);
        this.curFlight.setMainCabnSeats(0);
        this.curFlight.setTotalSeats(0);

        this.curFlight.setFirClassSeatsSold(0);
        this.curFlight.setBusinClassSeatsSold(0);
        this.curFlight.setMainCabnSeatsSold(0);

        // Set the sales tax total and maSavings total to 0
        this.curFlight.setSalesTaxTotal(0);
        this.curFlight.setMaSavingsTotal(0);

    }

    /**
     * Taks the users option to change info and calls the appropriate setter in the
     * Flight class to make changes
     * 
     * @param option    Users option on what they want to change
     * @param userInput What they want to change tht option to
     */
    public void changeInfo(String option, Scanner userInput) {
        // Create a scanner to scan the users input
        String newChoice = "";
        boolean validChoice = true;
        int newChcNum = 0;
        String[] choices = { "", "Origin Airport", "Origin Code", "Destination Airport",
                "Destination Code", "Departure Date", "Departure Time",
                "First Class Price", "Business Class Price", "Main Cabin Price" };

        // Go into the selected input and call the correct method
        switch (option) {
            // Change Origin Airpot
            case "1":
                System.out.print("Please enter the new Origin Airport: \n>");
                newChoice = userInput.nextLine();
                this.curFlight.setOrigAirportName(newChoice);
                break;
            // Change Origin Code
            case "2":
                System.out.print("Please enter the new Origin Code: \n>");
                newChoice = userInput.nextLine();
                if (newChoice.length() != 3) {
                    validChoice = false;
                } else {
                    this.curFlight.setOrigCode(newChoice);
                }
                break;
            // Change Destination Airpot
            case "3":
                System.out.print("Please enter the new Destination Airport: \n>");
                newChoice = userInput.nextLine();
                this.curFlight.setDestAirportName(newChoice);
                break;
            // Change Destination Code
            case "4":
                System.out.print("Please enter the new Destination Code: \n>");
                newChoice = userInput.nextLine();
                if (newChoice.length() != 3) {
                    validChoice = false;
                } else {
                    this.curFlight.setDestCode(newChoice);
                }
                break;
            // Change Destination Date
            case "5":
                System.out.print("Please enter the new Destination Date (##/##/##): \n>");
                newChoice = userInput.nextLine();
                this.curFlight.setDepDate(newChoice);
                break;
            // Change Destination Time
            case "6":
                System.out.print("Please enter the new Destination Time (##:## #M): \n>");
                newChoice = userInput.nextLine();
                validChoice = this.curFlight.setDepTime(newChoice);
                break;
            // Change First Class Price
            case "7":
                System.out.print("Please enter the new First Class Price: \n> $");
                newChoice = userInput.nextLine();
                try {
                    newChcNum = Integer.parseInt(newChoice);
                } catch (Exception e) {
                    validChoice = false;
                }
                if (validChoice) {
                    this.curFlight.setFirClassPrice(newChcNum);
                }
                break;
            // Change Business Clss Price
            case "8":
                System.out.print("Please enter the new Business Class Price: \n> $");
                newChoice = userInput.nextLine();
                try {
                    Integer.parseInt(newChoice);
                } catch (Exception e) {
                    validChoice = false;
                }
                if (validChoice) {
                    this.curFlight.setBusClassPrice(newChcNum);
                }
                break;
            // Change Main Cabin Price
            case "9":
                System.out.print("Please enter the new Main Cabin Price: \n> $");
                newChoice = userInput.nextLine();
                try {
                    Integer.parseInt(newChoice);
                } catch (Exception e) {
                    validChoice = false;
                }
                if (validChoice) {
                    this.curFlight.setMainCabPrice(newChcNum);
                }
                break;
            // Invalid choice
            default:
                System.out.println(
                        "\nInvalid Choice Please choose one of the following selections. \n-------------------------------------------------------------\n");
                return;
        }

        // Tell the user if you were able to successfully change the choice or not
        if (validChoice) {
            writeToLog("User successfully change: " + choices[Integer.parseInt(option)] + " to " + newChoice, false);
            System.out.println("Successfully Changed!");
        } else {
            System.out.println("\nInvalid input\n-------------\n");
        }

    }

    /**
     * Reads a file and automatically purchases all the tickets for the users in the
     * file
     * 
     * @param fileName Name of the file that has the automation
     */
    public void automaticPurchasing(String fileName) {
        System.out.println("\nAutomatic Ticket Purchasing Started!\n");
        File file = new File(fileName);

        try (Scanner sc = new Scanner(file)) {
            // Skip the head
            sc.nextLine();

            // Iteratre through each line in the file
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");

                // declare all the columns of the header
                String firstName = line[0];
                String lastName = line[1];
                String action = line[2];
                String flightId = line[3];
                // String origAirport = line[4];
                // String destAirport = line[5];
                String ticketType = line[6];
                int ticketQuantity = Integer.parseInt(line[7]);

                if (action.equals("Buy")) {
                    // Set the curUser to the user on our cur line
                    String username = firstName.toLowerCase() + lastName.toLowerCase();
                    checkUsername(username);

                    // Change the flight id
                    boolean validID = checkId(flightId);
                    if (!validID) {
                        System.out.println("Error invalid ID given" + username);
                    }

                    // Verify the flight isn't cancelled
                    if (checkFlightCanceled()) {
                        continue;
                    }

                    // Get the price of the ticket
                    double ticketPrice = getFlightPrice(ticketType, ticketQuantity);
                    double maSavings = getSavings(ticketPrice);
                    double maFee = getMaFee();
                    double securityFee = getSecurityFee(ticketQuantity);
                    double salesTax = getSalesTax(ticketPrice, maSavings, maFee, securityFee);
                    double totalPrice = (ticketPrice - maSavings) + maFee + securityFee + salesTax;

                    // Skip if the user doesn't have enough money
                    if (!checkBalance(totalPrice)) {
                        continue;
                    }

                    // Finalize the purchase
                    validatePurchase(ticketType, ticketQuantity, ticketPrice, maSavings, maFee, securityFee, salesTax,
                            totalPrice, false);
                }
            }

            System.out.println("\nAutomation Finished!\n");
        } catch (FileNotFoundException e) {
            writeToLog("Error reading Automation file " + e, false);
            System.out.println("Error reading Automation file \n " + e);
            return;
        } catch (NumberFormatException e) {
            writeToLog("Error parsing numbers in ticket automation" + e, false);
            System.out.println("Error parsing numbers in ticket automation \n" + e);
            return;
        }
    }

    /**
     * Prints all the tickets for the user to a csv
     * 
     * @param usernameIn Username of the user
     * @return Returns true if it was successful
     */
    public boolean writeElectronicTickets(String usernameIn) {
        // Check if the username given is valie
        boolean validUsername = checkUsername(usernameIn);
        if (!validUsername) {
            System.out.println("Error Invalid Username Given!");
            return false;
        }

        // Get the list of ticket from the user
        HashMap<Integer, Ticket> curTickets = null;
        if (this.curUser.getCurUserType().equals("Customer")) {
            curTickets = this.curUser.getCustomer().getTickets();
        } else if (this.curUser.getCurUserType().equals("Employee")) {
            curTickets = this.curUser.getEmployee().getTickets();
        }

        WriteElectronicTicket tickeWriter = new WriteElectronicTicket();
        for (Ticket curTicket : curTickets.values()) {
            // Set the current flight to be the flight in the ID
            boolean validID = checkId(String.valueOf(curTicket.getFlightID()));

            if (validID) {
                tickeWriter.writeTicket(curTicket, this.curFlight);
            }
        }

        System.out.println("\nSuccessfully Printed Ticket Information!\n");

        return true;
    }

    /**
     * Writes the new infromation that has been changed to a new cvs file.
     */
    public void writeInfo() {
        WriteInfoToCsv write = new WriteInfoToCsv();
        write.writeInternational(internationalMap);
        write.writeDomestic(domesticMap);
        write.writeCustomer(customerMap);
        write.writeEmployee(employeeMap);
        writeToLog("Wrote new files with updated information!", true);
    }
}