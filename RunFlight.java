/*
 * Ian Islas
 * 3/22/23
 * Advanced Object Orientied Programming
 * Daniel Mejia, Ph.D.
 * PA3
 * Lab Description:
 *   Create a system for user intercation that utilizies object oriented concepts to allow
 *   the user to purchase tickets, log in with their username and password and have access to a 
 *   menu of operations that displays and stores all there neccesary flight information. 
 * 
 * I have completed all work entirely on my own without any outside sources, that includes peers, experts, online sources etc. Only
 * assistance from the TA and IA's was provided during this assignment.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Scanner;
import java.util.HashMap; //
import java.util.InputMismatchException;

public class RunFlight {

    public static void main(String[] args) {

        File path = new File("FlightSchedule_pa4.csv");
        File path2 = new File("CustomerListPA4.csv");

        
        Scanner scan = null;    // flighschedule(5).csv scanner
        Scanner scan2 = null;   // customerlistPA3.csv scanner
        Scanner escan = null;   // employee flightschedule(2).csv scanner
        Scanner escan2 = null;   //employee customerlistPA2.csv scanner


        while (true) {
            Top:
            
            // loops prompt asking user to enter whether they are customer or faculty
            try {
                System.out.println("Please select option that applies\n\t1: Customer\n\t2: Employee");
                Scanner usertype = new Scanner(System.in);
                int userType = usertype.nextInt();


                // stores confirmation number of ticket
                HashMap<String, Integer> confirmNumMap = new HashMap<>();
                    
                /*hash map that associates customer with their ticket, purpose is to
                *have O(1) access to an organized customer and ticket pair
                */
                HashMap<String, String> customerlist = new HashMap<>();


                // CUSTOMER UI (if user is a customer we enter customer interface here)
                if (userType == 1) {

                     //loops if name is not on customerlistPA1.csv
                        System.out.print("Enter first and last name: ");
                        Scanner customerName = new Scanner(System.in);
                        String[] fullname = customerName.nextLine().split(" "); // fullname[0] = first name, fullname[1]= last name

                        try { // we try this if the file is found
                            scan = new Scanner(path);
                            scan2 = new Scanner(path2);
                            HashMap<String, Integer> headerValues = new HashMap<>(); // stores header values of customerlistPA2.csv
                            String[] tempHeader1 = scan2.nextLine().split(","); // reads header values of customerlistPA2.csv

                            for (int i = 0; i < tempHeader1.length; i++) { // here we are storing the header values into hashmap "headerValues"
                                headerValues.put(tempHeader1[i], i); // we want the key to be the value at the array and the value to be the index
                            }

                            while (scan.hasNextLine() && scan2.hasNextLine()) {
                                String[] customerData = scan2.nextLine().split(","); // this fetches the data stored in our hashmap "headerValues"

                                // CUSTOMER OBJECT
                                /*
                                 * how is this any different than writing customerData[0]?
                                 *      because searching through an array is linear O(n) whereas using a hashmap is constant time O(1)
                                 */
                                Customer c = new Customer(
                                        customerData[headerValues.get("Username")],
                                        Integer.parseInt(customerData[headerValues.get("ID")]),
                                        Double.parseDouble(customerData[headerValues.get("Money Available")]),
                                        customerData[headerValues.get("Role")],
                                        customerData[headerValues.get("Password")],
                                        customerData[headerValues.get("First Name")],
                                        customerData[headerValues.get("DOB")],
                                        Integer.parseInt(customerData[headerValues.get("Flights Purchased")]),
                                        Boolean.parseBoolean(customerData[headerValues.get("MinerAirlines Membership")]),
                                        customerData[headerValues.get("Last Name")],
                                        0.0
                                        );
                                // TAKES USER INPUT AND RETURNS DATA FROM THE USER INPUT(first name)
                                // searching by first name
                                if (fullname[0].equals(c.getFirstName()) && fullname[1].equals(c.getLastName())) {
                                    // break;
                                    System.out.println("Hello " + fullname[0] + "! Please sign in below."); // welcomes user by first name
                                    System.out.println("miner air membership: " + c.getHasMembership());

                                    // loops the login prompt if credentials are invalid based on refrence from
                                    // customerlistPA1
                                    while (true) {

                                        // asking user for there username and password
                                        System.out.print("Username: ");
                                        Scanner loginUser = new Scanner(System.in);
                                        String username = loginUser.nextLine();

                                        System.out.print("Password: ");
                                        Scanner loginPasswrd = new Scanner(System.in);
                                        String password = loginPasswrd.nextLine();

                                        if (username.equals(c.getUsername()) && password.equals(c.getPassword())) { // here the login info is valid and we enter interface
                                            System.out.println("--Login Successful--");
                                            break; // we break from the loop here and enter the menu of operations from PA0
                                        }else {
                                            System.out.println("--Invalid Login, Try Again--");
                                        }
                                    }

                                    while (true) { // checks if user enters a valid flight number
                                        System.out.print("Please enter flight ID: ");
                                        Scanner userdata = new Scanner(System.in);
                                        int input = userdata.nextInt();

                                        if (input <= 3008 && input >= 1) {
                                            try {
                                                scan = new Scanner(path);
                                                HashMap<String,Integer> headerValues0 = new HashMap<>(); // stores header values from flightschedulePA0.csv

                                                String[] tempHeader0 = scan.nextLine().split(","); // reads the header values from flightschedulePA0.csv

                                                for (int i = 0; i < tempHeader0.length; i++) { // here we are puttin the header values into hashmap "headerValues0"
                                                    headerValues0.put(tempHeader0[i], i); // we want the key to be the value at the array and the value to be the index
                                                }

                                                while (scan.hasNextLine()) {
                                                    String[] flightData = scan.nextLine().split(","); // this stores the data from flightschedulesPA0.csv
                                                    
                                                    // FLIGHT OBJECT
                                                    /*
                                                     * how is this any different than writing flightData[0]?
                                                     *      because searching through an array is linear O(n) whereas using a hashmap is constant time O(1)
                                                     */
                                                    Flight f = new Flight(
                                                            flightData[headerValues0.get("Type")],
                                                            flightData[headerValues0.get("Arrival Date")],
                                                            Integer.parseInt(flightData[headerValues0.get("Main Cabin Seats")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Flight Number")]),
                                                            flightData[headerValues0.get("Destination Code")],
                                                            flightData[headerValues0.get("Origin Airport")],
                                                            Integer.parseInt(flightData[headerValues0.get("Miner Points")]),
                                                            flightData[headerValues0.get("Origin Code")],
                                                            Integer.parseInt(flightData[headerValues0.get("Business Class Price")]),
                                                            Double.parseDouble(flightData[headerValues0.get("Main Cabin Price")]),
                                                            flightData[headerValues0.get("Departing Time")],
                                                            Integer.parseInt(flightData[headerValues0.get("Duration")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Surcharge")]),
                                                            Boolean.parseBoolean(flightData[headerValues0.get("Origin Airport Lounge")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Distance")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Time Zone Difference")]),
                                                            flightData[headerValues0.get("Arrival Time")],
                                                            flightData[headerValues0.get("Departing Date")],
                                                            flightData[headerValues0.get("Origin Airport State")],
                                                            flightData[headerValues0.get("Origin Airport Country")],
                                                            Double.parseDouble(flightData[headerValues0.get("Origin Airport Fee")]),
                                                            flightData[headerValues0.get("Destination Airport City")],
                                                            Boolean.parseBoolean(flightData[headerValues0.get("Food Served")]),
                                                            flightData[headerValues0.get("Destination Airport State")],
                                                            flightData[headerValues0.get("Destination Airport Country")],
                                                            Double.parseDouble(flightData[headerValues0.get("Destination Airport Fee")]),
                                                            Boolean.parseBoolean(flightData[headerValues0.get("Destination Airport Lounge")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Route Cost")]),
                                                            Integer.parseInt(flightData[headerValues0.get("Total Seats")]),
                                                            Integer.parseInt(flightData[headerValues0.get("ID")]),
                                                            Integer.parseInt(flightData[headerValues0.get("First Class Seats")]),
                                                            flightData[headerValues0.get("Destination Airport")],
                                                            Integer.parseInt(flightData[headerValues0.get("Business Class Seats")]),
                                                            flightData[headerValues0.get("Origin Airport City")],
                                                            Integer.parseInt(flightData[headerValues0.get("First Class Price")]),
                                                            0
                                                            );

                                                    HashMap<String, String> flightMap = new HashMap<>();
                                                    String strID = Integer.toString(f.getId());
                                                    flightMap.put("ID", strID);

                                                    // TAKES USER INPUT AND RETURNS DATA FROM THE USER INPUT
                                                    if (flightMap.get("ID").equals(Integer.toString(input))) {

                                                        // provides user ticket prices and the types of tickets
                                                        // available for purchase
                                                        System.out.println("\n--Welcome to Flight " + flightMap.get("ID") + "!--\n\nTICKET PRICES FOR FLIGHT " + flightMap.get("ID"));
                                                        System.out.println("-1.) Main Cabin Price: " + f.getMcPrice() + "\n-2.) Business Class Price: " + f.getBcPrice() + "\n-3.) First Class Price: " + f.getFcPrice());
                                                   
                                                        
                                                        while(true){ //prompt that loops if user  enters an invalid ticket type  //020
                                                            System.out.println("\nBALANCE: " + c.getMoneyAvailable());

                                                            //if user has insufficent funds ask this prompt again
                                                            System.out.print("\nSpecify type of ticket you wish to purchase\n-if NONE type 'n'-\n> ");
                                                            Scanner ticketType = new Scanner(System.in);
                                                            int ticketChoice = ticketType.nextInt();
                                                            
                                                            
                                                            if(ticketChoice <= 3 && ticketChoice >= 1){ // here the body makes assumption that the user will purchase a ticket
                                                                while (true) { // prompts question asking the user to enter desired quantity of tickets,if more than 8 or less than 1 than it will loop until user enters valid number //000
                                                                               
                                                                    System.out.print("Desired quantity of tickets: ");
                                                                    Scanner tQuantity = new Scanner(System.in);
                                                                    int ticketQuantity = tQuantity.nextInt();
    
                                                                    if (ticketQuantity <= 8 && ticketQuantity >= 1) {

                                                                        Ticket t = new Ticket();
                                                                        //here we save the instance of the hash table that holds the customer name and its ticket information
                                                                        // to have it accessible to the employee 
                                                                        CustomerListSingleton listsingleton = CustomerListSingleton.getInstance();
                                                                        FlightFeeSingleton flightfee = FlightFeeSingleton.getInstance();

                                                                        // MAIN CABIN TICKET TYPE
                                                                        if (ticketChoice == 1 && f.getMcSeats() >= ticketQuantity) { // checks if there are still seats available after the amount of ticket purchases
                                                                            
                                                                            //generates random number and stores its value in this hashmap
                                                                            //stores confimation numbers
                                                                            confirmNumMap.put("MainCabinTicketConfirmationNumber", t.setconfirmationNumber());
                                                              

                                                                            //mct = Main Cabin Ticket, stores confirmation number, total price, quantity and flight id              
                                                                            Ticket mct = new Ticket((f.getMcPrice() * ticketQuantity), ticketQuantity, confirmNumMap.get("MainCabinTicketConfirmationNumber"), f.getId(), false);
                                                                            
                                                                            //will be used later once we finish computing the total amount that includes the discount, fees, tax etc.
                                                                            HashMap<String, Double> origMainCabinPrice = new HashMap<>();
                                                                            origMainCabinPrice.put("mcPrice", f.getMcPrice());

                                                                            //We first implement the discount if applicable and then proceed to add on the fees on top after

                                                                            //sets the coupon if the customer has a MinerAir memebership
                                                                            if(c.getHasMembership() == true){
                                                                                double save = origMainCabinPrice.get("mcPrice") - (origMainCabinPrice.get("mcPrice") * 0.05);
                                                                                c.setSavings((origMainCabinPrice.get("mcPrice") * 0.05) * ticketQuantity);
                                                                                f.setMcPrice(save);

                                                                            }

                                                                            System.out.println("this is the price with the save implemented: " + f.getMcPrice());
                                                                            System.out.println("this is the orig mc seat price: " + origMainCabinPrice.get("mcPrice"));

                                                                            double totalTax = (0.0825 * f.getMcPrice()) * ticketQuantity;
                                                                            double totalMinerAirFees = 9.15 * ticketQuantity;
                                                                            double totalSecurityFees = 5.60 * ticketQuantity;
                                                                            double totalFees = totalMinerAirFees + totalSecurityFees;

                                                                            //here we save the flight id as a key paired with its fee as its value pair
                                                                            // MinerAirlineFee(9.15) + Security Fee(5.60) = 14.95
                                                                            HashMap<Integer, Double> profits = new HashMap<>();
                                                                            profits.put(f.getId(), totalFees);
                                                                            flightfee.setData(profits);
                                                            
                                                                            //we assume when we reach here f.getMcPrice already has the discount implemented 
                                                                            //we now need to just add the fees, 9.15 + 5.60 = 14.75
                                                                            f.setMcPrice(ticketQuantity * ((0.0825 * f.getMcPrice()) + (f.getMcPrice() + 14.75)));

                                                                            /* 
                                                                             *  FINAL PRICE IS SET HERE, this includes tax and fees, price is already adjusted for the membership
                                                                             *  discount by this point in the code
                                                                             */                                                                            
                                                                            mct.settotalPrice(f.getMcPrice());
                                                                            /*  
                                                                                since we manipulated the value of the main cabin price we use
                                                                                the hashmap "origMainCabinPrice" to set the value back to its original price to preserve
                                                                                the accuracy of data and reusability 
                                                                            */                                                                            

                                                                            // if customer has enough or equal to amount of funds for ticket, this includes all price computations 
                                                                            if (c.getMoneyAvailable() >= mct.gettotalPrice()) {                                                       
                                                                                
                                                                                //here we set the singleton object to the customerlist map
                                                                                customerlist.put(c.getFirstName(), mct.printData());
                                                                                listsingleton.setData(customerlist);


                                                                                Double d = new Double(c.getMoneyAvailable());
                                                                                float remainingBalance = (float)(d.floatValue() - (f.getMcPrice() * ticketQuantity));
                                                                               
                                                                                System.out.printf("\nYou have just reserved %d ticket(s) for a total price of %.2f \nCONFIRM PURCHASE? (Y/N): \n", mct.getQuantity() , mct.gettotalPrice());                                                                                
                                                                                //System.out.println("this is the price without the fee included: " + f.getMcPrice() * ticketQuantity);

                                                                                Scanner ticketpurchase = new Scanner(System.in);
                                                                                char confirmTicket = ticketpurchase.next().charAt(0);

                                                                                if(confirmTicket == 'Y' || confirmTicket == 'y'){
                                                                                    //c.setTicket(mct); // we set the customer with a ticket
                                                                                    f.setBcSeats(f.getMcSeats() - ticketQuantity); // updating seat count after ticket(s) purchase
                                                                                    System.out.println("\nCONFIRMATION NUMBER: " + confirmNumMap.get("MainCabinTicketConfirmationNumber"));
                                                                                    
                                                                                    if(c.getHasMembership() == true)
                                                                                        System.out.printf("\n--Savings: $%.2f--\n", c.getSavings());
                                                                                    
                                                                                    System.out.printf("Security Fees: %.2f\nMinerAir Fee: %.2f\nTax Total: %.2f\n", totalSecurityFees, totalMinerAirFees, totalTax);
                                                                                    System.out.printf("\nRemaining Balance: $%.2f\n", remainingBalance);
                                                                                    f.setMcPrice(origMainCabinPrice.get("mcPrice"));
                                                                                    break Top;
                                                                                }if(confirmTicket == 'N' || confirmTicket == 'n'){
                                                                                    break Top;
                                                                                }else{
                                                                                    break Top;
                                                                                }
                                                                     
                                                                            }else{ // if user doesnt have enough funds for the tickets(s)
                                                                                System.out.println("Insufficent Funds");
                                                                            }
    
                                                                        }
    
                                                                        // BUSINESS CLASS TICKET TYPE
                                                                        if (ticketChoice == 2 && f.getBcSeats() >= ticketQuantity) { // checks if there are still seats available after the amount of tiket(s) purchased
                                                                            
                                                                            confirmNumMap.put("BuisnessClassTicketConfirmationNumber", t.setconfirmationNumber());

                                                                            //bct = Buisness Class Ticket
                                                                            Ticket bct = new Ticket((f.getBcPrice() * ticketQuantity) + 9.15, ticketQuantity, confirmNumMap.get("BuisnessClassTicketConfirmationNumber"), f.getId(),false);
    
                                                                            if (c.getMoneyAvailable() >= (f.getBcPrice() * ticketQuantity)) { // if customer has enough or equal to amount of funds for ticket(s)
                                                                                //c.setTicket(bct);
                                                                                customerlist.put(c.getFirstName(), bct.printData());

                                                                                listsingleton.setData(customerlist);

                                                                                Double d = new Double(c.getMoneyAvailable());
                                                                                float remainingBalance = d.floatValue() - (f.getBcPrice() * ticketQuantity);

                                                                                System.out.println("\nYou have just reserved " + bct.getQuantity() + " ticket(s) for a total price of " + bct.gettotalPrice() + "\nCONFIRM PURCHASE? (Y/N): ");
                                                                                Scanner ticketpurchase = new Scanner(System.in);
                                                                                char confirmTicket = ticketpurchase.next().charAt(0);

                                                                                if(confirmTicket == 'Y' || confirmTicket == 'y'){//if confirm purchase
                                                                                    //c.setTicket(bct); // we set the customer with a ticket
                                                                                    f.setBcSeats(f.getBcSeats() - ticketQuantity);// updating seat count after ticket(s) purchase
                                                                                    System.out.println("CONFIRMATION NUMBER: " + confirmNumMap.get("BuisnessClassTicketConfirmationNumber"));
                                                                                    System.out.println("\nRemaining Balance: " + remainingBalance + "\n");
                                                                                    break Top;
                                                                                }if(confirmTicket == 'N' || confirmTicket == 'n'){
                                                                                    break Top;
                                                                                }else{
                                                                                    break Top;
                                                                                }
    
                                                                            }else {
                                                                                System.out.println("Insufficent Funds");
                                                                            }
                                                                        }
    
                                                                        // FIRST CLASS TICKET TYPE
                                                                        if (ticketChoice == 3 && f.getFcSeats() >= ticketQuantity) { // checks if there are still seats available after the amount of tickets purchased
    
                                                                            confirmNumMap.put("FirstClassTicketConfirmationNumber", t.setconfirmationNumber());

                                                                            //fct = First Class Ticket
                                                                            Ticket fct = new Ticket((f.getBcPrice() * ticketQuantity) + 9.15, ticketQuantity, confirmNumMap.get("FirstClassTicketConfirmationNumber"), f.getId(),false);

    
                                                                            if (c.getMoneyAvailable() >= (f.getFcPrice() * ticketQuantity)) { // if customer has enough or equal to amount of funds for ticket
                                                                                //c.setTicket(fct);
                                                                                customerlist.put(c.getFirstName(), fct.printData());

                                                                                listsingleton.setData(customerlist);
    
                                                                                Double d = new Double(c.getMoneyAvailable());
                                                                                float remainingBalance = d.floatValue() - (f.getFcPrice() * ticketQuantity);

                                                                                System.out.println("\nYou have just reserved " + fct.getQuantity() + " ticket(s) for a total price of " + fct.gettotalPrice() + "\nCONFIRM PURCHASE? (Y/N): ");
                                                                                Scanner ticketpurchase = new Scanner(System.in);
                                                                                char confirmTicket = ticketpurchase.next().charAt(0);

                                                                                if(confirmTicket == 'Y' || confirmTicket == 'y'){//if confirm purchase
                                                                                    //c.setTicket(fct); // we set the customer with a ticket
                                                                                    f.setFcSeats(f.getFcSeats() - ticketQuantity);// updating seat count after ticket(s) purchase
                                                                                    System.out.println("CONFIRMATION NUMBER: " + confirmNumMap.get("FirstClassTicketConfirmationNumber"));
                                                                                    System.out.println("\nRemaining Balance: " + remainingBalance);
                                                                                    break Top;
                                                                                }if(confirmTicket == 'N' || confirmTicket == 'n'){
                                                                                    break Top;
                                                                                }else{
                                                                                    break Top;
                                                                                }
                                                                     
                                                                            }else{
                                                                                System.out.println("Insufficent Funds");
                                                                            }
                                                                        }
    
    
                                                                    break; // breaks from loop asking user to enter how many tickets they want to buy
    
                                                                    }else{
                                                                        System.out.println("--You do not meet ticket quantity requirements--");
                                                                    }
    
                                                                    
                                                                } //end of 000
                                                                break;   // breaks loop that prompts user ticket type 020
                                                            
                                                            }else{
                                                                System.out.println("--Invalid ticket type, try again--");
                                                                
                                                            }
                                                                        
                                                        } // end of 020

                                                        
                                                                                                                
                                                    }

                                                }
                                                System.out.println();
                                            }

                                            catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            break; // breaks from the loop that prompts the user for flight ID
                                        } else {
                                            System.out.println("--Invalid flight ID, try again--");
                                        } // if user enters a number outside of range 1-18

                                    }
                                    break;
                                }

                            }

                        } catch (FileNotFoundException e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    
                } // end of customer ui



                // EMPLOYEE UI
                if (userType == 2) {
                    
                    while(true){ // loop if user inputs anything but an int LOOPe1
                        try {
                            escan = new Scanner(path);                            
                            HashMap<String, Integer> eheaderValues = new HashMap<>();
                            String[] a = escan.nextLine().split(",");
    
                            for(int i = 0; i < a.length; i++){
                                eheaderValues.put(a[i], i);
                            }
                          
                            while(true){ 
                                // loop if user inputs anything out of input range LOOPe2
                                System.out.println("Enter Flight ID or Origin Code: ");
                                Scanner input2 = new Scanner(System.in);
                                int employeeinput = input2.nextInt();
                                String inputFlightCode = input2.nextLine();
                        
                        
                                if(employeeinput <= 3008 && employeeinput >= 1){
                            
                                    while(escan.hasNextLine()){

                                        String[] eflightData = escan.nextLine().split(",");
                                    
                                        Flight ef = new Flight(
                                            eflightData[eheaderValues.get("Type")],
                                            eflightData[eheaderValues.get("Arrival Date")],
                                            Integer.parseInt(eflightData[eheaderValues.get("Main Cabin Seats")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Flight Number")]),
                                            eflightData[eheaderValues.get("Destination Code")],
                                            eflightData[eheaderValues.get("Origin Airport")],
                                            Integer.parseInt(eflightData[eheaderValues.get("Miner Points")]),
                                            eflightData[eheaderValues.get("Origin Code")],
                                            Integer.parseInt(eflightData[eheaderValues.get("Business Class Price")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Main Cabin Price")]),
                                            eflightData[eheaderValues.get("Departing Time")],
                                            Integer.parseInt(eflightData[eheaderValues.get("Duration")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Surcharge")]),
                                            Boolean.parseBoolean(eflightData[eheaderValues.get("Origin Airport Lounge")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Distance")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Time Zone Difference")]),
                                            eflightData[eheaderValues.get("Arrival Time")],
                                            eflightData[eheaderValues.get("Departing Date")],
                                            eflightData[eheaderValues.get("Origin Airport State")],
                                            eflightData[eheaderValues.get("Origin Airport Country")],
                                            Double.parseDouble(eflightData[eheaderValues.get("Origin Airport Fee")]),
                                            eflightData[eheaderValues.get("Destination Airport City")],
                                            Boolean.parseBoolean(eflightData[eheaderValues.get("Food Served")]),
                                            eflightData[eheaderValues.get("Destination Airport State")],
                                            eflightData[eheaderValues.get("Destination Airport Country")],
                                            Double.parseDouble(eflightData[eheaderValues.get("Destination Airport Fee")]),
                                            Boolean.parseBoolean(eflightData[eheaderValues.get("Destination Airport Lounge")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Route Cost")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("Total Seats")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("ID")]),
                                            Integer.parseInt(eflightData[eheaderValues.get("First Class Seats")]),
                                            eflightData[eheaderValues.get("Destination Airport")],
                                            Integer.parseInt(eflightData[eheaderValues.get("Business Class Seats")]),
                                            eflightData[eheaderValues.get("Origin Airport City")],
                                            Integer.parseInt(eflightData[eheaderValues.get("First Class Price")]),
                                            0
                                        );
                                    
                                        HashMap<String, String> eflightMap = new HashMap<>();
                                        String estrID =    Integer.toString(ef.getId());
                                        eflightMap.put("ID",estrID);

                                        

                                        //if(eflightMap.get("ID").equals(Integer.toString(employeeinput)))
                                        if(eflightMap.get("ID").equals(Integer.toString(employeeinput))){            
                                            System.out.println("\n--FLIGHT " + eflightMap.get("ID") + "'s DATA--");
                                            ef.printFlight();
                                            
                                            Employee e = new Employee();
                                            
                                            /*purpose of this ticket object is to retrieve a confirmation number
                                             * and store it for access later in our actual ticket object
                                             */
                                            Ticket dummyticket = new Ticket();

                                            System.out.println("\n--FLIGHT " + ef.getId() + "s PRICES\n-1.) Main Cabin Price: " + ef.getMcPrice() + "\n-2.) Business Class Price: " + ef.getBcPrice() + "\n-3.) First Class Price: " + ef.getFcPrice());
                                           
                                            System.out.println("Do you wish to purchase a ticket (Y/N): ");
                                            Scanner employee_purchase = new Scanner(System.in);
                                            char purchase = employee_purchase.next().charAt(0);

                                            System.out.print("Desired Quantity: ");
                                            Scanner tQuantity = new Scanner(System.in);
                                            int ticketQuantity = tQuantity.nextInt();

                                            if(purchase == 'Y' || purchase == 'y'){
                                                System.out.print("Specify type of ticket you wish to purchase\n-if NONE type 'n'-\n> ");
                                                Scanner ticketType = new Scanner(System.in);
                                                int ticketChoice = ticketType.nextInt();
            
                                                HashMap<String, Integer> quantityMap = new HashMap<>();
                                                quantityMap.put("quantity", ticketQuantity);

                                                if (ticketQuantity <= 8 && ticketQuantity >= 1){
                                                    
                                                    //TODO compute price with tax fees discount etc
                                                    TicketFactory ticketFactory = new TicketFactory();
                                                    TicketType ticket1 = ticketFactory.getTicketType(ticketChoice);
                                                    
                                                    switch(ticketChoice){
                                                        case 1:
                                                            System.out.printf("You have just purchased %d ticket(s)\nTOTAL PRICE OF TICKET(S): %.2f\n", ticketQuantity, ticket1.computePrice(ticketQuantity, ef.getMcPrice()));
                                                            break;
                                                        case 2:
                                                            System.out.printf("You have just purchased %d ticket(s)\nTOTAL PRICE OF TICKET(S): %.2f\n", ticketQuantity, ticket1.computePrice(ticketQuantity, ef.getBcPrice()));
                                                            break;
                                                        case 3:
                                                            System.out.printf("You have just purchased %d ticket(s)\nTOTAL PRICE OF TICKET(S): %.2f\n", ticketQuantity, ticket1.computePrice(ticketQuantity, ef.getFcPrice()));
                                                            break;
                                                    }
                                                }else{
                                                    System.out.println("--Invalid Quantity--");
                                                }
                                            }

                                            System.out.println("\n--FEE PROFITS--");
                                            //this prints the flight fee 
                                            e.printFlightFeeSingleton();

                                            
                                            System.out.println("\n--CUSTOMER LIST--");
                                            //this prints the list
                                            e.printCustomerListSingleton();

                                            System.out.println("Do you wish to cancel this flight (Y/N): ");
                                            Scanner cancel = new Scanner(System.in);
                                            char canceloption = cancel.next().charAt(0);

                                            if(canceloption == 'Y' || canceloption == 'y'){
                                                System.exit(0);
                                            }
                                       
                                            break Top; 
                                            
                                        }

                                        if(ef.getOriginCode().equals(inputFlightCode)){
                                            ef.printFlight2();
                                        }


                                       
                                    }

                                // LOOPe2 breaks loop that prompts user flight ID (if input is int, but not in range ex: 99999)
                                }else{
                                    System.out.println("--Invalid Flight ID, try again--");
                                }
                            }
                        
                        //break; // LOOPEe1 breaks loop that prompts user flight ID (if input is mismatch ex: Four@34&^%)   
                        }
                    
                        catch(Exception e){
                            System.out.println("--Invalid Flight ID, try again--");
                        }
                    }
                     
                           
                    
                    

                  
                    
                    
                    
                    //ask for flight number to search for
                        //display alll information of that flight
                        // present option to view customers (i.e customers who purchased tickets for this flight)
                            // show NAME
                            //seat TYPE: QUANTITY OF TICKETS PURCHASED 
                            // TOTAL PRICE OF TRANSACTION
 



                } // end of employee ui
                
                
                else {
                    System.out.println("--Invalid option--");
                }

                break; // this breaks the loop that asks the user whether they are employee or customer

            } catch (InputMismatchException e) { // this catches if input is not the desired type (int) when user is
                                                 // deciding from customer or employee
                                                 // example if user enters anthing other than a int than this will catch
                                                 // it and prompt thr question again
                // TODO: handle exception
                //System.out.println("--Invalid Input, try again--");
            }
        }

    }
}