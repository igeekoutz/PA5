import java.util.Scanner;

import org.junit.rules.TestRule;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * This is a description of a main class
 * @version 1.0
 */
public class FlightRunner {
    /**
     * The main method description
     * @param args argument taken into main
     * @throws IOException
     */
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> allStrings = new ArrayList<String>();
    public static int confirmationNumber = 0;
    public static String line = "------------------------------------------------------";
    public static String[] findClient(HashMap<String, Customer> allCustomers, HashMap<String, Employee> allEmployees, String[] name){
        for(String key: allCustomers.keySet()){
            if(allCustomers.get(key).getFirstName().equalsIgnoreCase(name[0]) && allCustomers.get(key).getLastName().equalsIgnoreCase(name[1])){
                String[] importantInfo = {allCustomers.get(key).getRole(), allCustomers.get(key).getUserName()};
                return importantInfo;
            }
        }
        for(String key: allEmployees.keySet()){
            if(allEmployees.get(key).getFirstName().equalsIgnoreCase(name[0]) && allEmployees.get(key).getLastName().equalsIgnoreCase(name[1])){
                String[] importantInfo = {allEmployees.get(key).getRole(), allEmployees.get(key).getUserName()};
                return importantInfo;
            }
        }
        System.out.println("Could not find client in the system");
        return null;
    }
    /**
 * Reads a file containing actions for automatic ticket purchasing and executes the corresponding actions.
 *
 * @param allCustomers a HashMap containing all customers
 * @param allFlights a HashMap containing all flights
 * @param allEmployees a HashMap containing all employees
 * @throws FileNotFoundException if the file containing the actions is not found
 */
    public static void automaticTicketPurchasing(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees)throws FileNotFoundException{
        System.out.println("Welcome to the Automatic ticket purchaser, there are 3 options\n\n1. AutoPurchaser10k\n2.AutoPurchaser100k\n3.AutoPurchaser400k\n4. Go Back\n");
        String selection = scan.next();
        switch(selection){
            case"1":
                Scanner autoPurchaser10k = new Scanner(new File("AutoPurchaser10K.csv")); 
                while (autoPurchaser10k.hasNextLine()){   //This while loop populates allFlight hash map with all flight data
                    String actionLine = autoPurchaser10k.nextLine();
                    String [] actionInfo = actionLine.split(",");
                    String[] name = {actionInfo[0], actionInfo[1]};
                    String[] importantInfo = findClient(allCustomers, allEmployees, name);
                    purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, true, actionInfo);
                }
                
            case"2":
                Scanner autoPurchaser100k = new Scanner(new File("AutoPurchaser10K.csv")); 
                while (autoPurchaser100k.hasNextLine()){   //This while loop populates allFlight hash map with all flight data
                    String actionLine = autoPurchaser100k.nextLine();
                    String [] actionInfo = actionLine.split(",");
                    String[] name = {actionInfo[0], actionInfo[1]};
                    String[] importantInfo = findClient(allCustomers, allEmployees, name);
                    purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, true, actionInfo);
                }
            case"3":
                Scanner autoPurchaser400k = new Scanner(new File("AutoPurchaser10K.csv")); 
                while (autoPurchaser400k.hasNextLine()){   //This while loop populates allFlight hash map with all flight data
                    String actionLine = autoPurchaser400k.nextLine();
                    String [] actionInfo = actionLine.split(",");
                    String[] name = {actionInfo[0], actionInfo[1]};
                    String[] importantInfo = findClient(allCustomers, allEmployees, name);
                    purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, true, actionInfo);
                }
            case "4":
                return;
            default:
                System.out.println("\nInvalid Menu option, try again.\n");
        }
    }
    public static HashMap<String, Airport> allAirports = new HashMap<String, Airport>();
    /**

This method allows the user to view airport information by airport code. The user will be prompted to enter an airport code and the information regarding the airport will be printed including the airport name, city, state, country, fees and lounge status. The user may choose to view information for another airport or exit the menu.
@param allCustomers A HashMap containing all customer objects in the system
@param allFlights A HashMap containing all flight objects in the system
@param allEmployees A HashMap containing all employee objects in the system
@param importantInfo An array containing important information about the currently logged in user, such as their name and role
@throws NoSuchElementException If the scanner is closed or empty when trying to read user input
@return void This method does not return anything
*/
    public static void viewAirportInformation(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees, String[] importantInfo){
        boolean continue1 = true;
        while(continue1){
            System.out.println("Here you may view Airport Information by airport code, to begin please eneter an Airport code");
            System.out.print("\nAirport Code: ");
            String selection = scan.next();
            System.out.println(line);
            System.out.println("\nAirport Code: " + allAirports.get(selection).getCode() + 
                            " \nAirport Name: " + allAirports.get(selection).getAirport() + 
                            " \nAirport City: " + allAirports.get(selection).getAirportCity()+ 
                            "\nAirport State: " + allAirports.get(selection).getAirportState()+ 
                            "\nAirport Country: " + allAirports.get(selection).getAirportCountry()+ 
                            "\nAirport Fees: " + allAirports.get(selection).getAirportFee()+
                            "\nLounge Status: " + allAirports.get(selection).getAirportLounge() + "\n");
            System.out.println(line);
            System.out.println("Would you like to see the information for another Airport?\n\n 1. Yes \n 2. No\n");
            String continue2 = scan.next();
            if(continue2.equalsIgnoreCase("2")){
                continue1 = false;
            }

        }

    }
    /**

Adds an airport to the allAirports HashMap.
@param code the code of the airport being added
@param airport the Airport object being added to the HashMap
*/
    public void addAirport(String code, Airport airport){
        allAirports.put(code, airport);
    }
    /**

This method prints a menu allowing customers to search for flight information based on flight ID or flights between origin and destination airport.
If the customer selects option 1, they will be prompted to enter the ID of the flight they want information for.
If the customer selects option 2, they will be prompted to enter the origin and destination codes and all flights between those two airports will be displayed.
After either option, the customer will be prompted to purchase a ticket for the selected flight.
@param allCustomers A HashMap containing all customers.
@param allFlights A HashMap containing all flights.
@param allEmployees A HashMap containing all employees.
@param importantInfo An array of Strings containing important information for the program.
*/
    public static void viewFlightInformationMenu(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees, String[] importantInfo){
        System.out.println("How would you like to serach for a Flight(s)?\n\n1. Flight ID\n2. Flights between 'X' and 'Y'\n");
        System.out.print("Please enetr your selection: ");
        String selection = scan.next();
        switch(selection){
            case "1":
                System.out.print("Please enter the ID of the flight you would like to see information for: ");
                String menuChoice = scan.next();
                System.out.println();
                allFlights.get(menuChoice).printFlight();
                System.out.print("Would you like to purchase a ticket for this flight?\n\n 1. Yes\n2. No\n");
                System.out.println("\n*PLEASE WRITE DOWN THE FLIGHT ID YOUD LIKE TO BUY TICKETS FOR BEFORE MOVING ON*\n");
                String purchaseTicket = scan.next();
                switch(purchaseTicket){
                    case "1":
                        String[] arr = new String[0];
                        purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, false, arr);
                    
                    default:
                        return;
                }

            case "2":
                System.out.print("To see flights between 'Origin Code' and 'Destination Code' please eneter both codes\n\n Origin Code: " );
                String originCode = scan.next();
                System.out.println("\nDestination Code: ");
                String destinationCode = scan.next();
                for(String key: allFlights.keySet()){

                    if(originCode.equalsIgnoreCase(allFlights.get(key).getOriginAirport().getOriginCode()) && destinationCode.equalsIgnoreCase(allFlights.get(key).getDestinationAirport().getDestinationCode())){
                        System.out.println(line);
                        allFlights.get(key).printFlight();
                        System.out.println(line);
                    }
                }
                System.out.println("Would you like to purchase a ticket for any of these flights?\n\n 1. Yes\n 2. No\n");
                System.out.println("\n*PLEASE WRITE DOWN THE FLIGHT ID YOUD LIKE TO BUY TICKETS FOR BEFORE MOVING ON*\n");
                String purchaseTicket1 = scan.next();
                switch(purchaseTicket1){
                    case "1":
                        String[] arr = new String[0];
                        purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, false, arr);
                    default:
                        return;
                }
                    

            default:
                System.out.println("Invalid menu option, please try again.");
        }
       
    }
    /**

This method displays a cancellation menu for customers and employees to cancel a ticket for a flight.
If the user is a customer, they will be shown a list of their available tickets and asked to enter the
confirmation number of the ticket they would like to cancel. The ticket will then be cancelled and the
customer will be refunded. If the user is an employee, they will be asked to enter the ticket confirmation
number, and the ticket will be cancelled without a refund to the customer.
@param allCustomers the hashmap containing all customers
@param allFlights the hashmap containing all flights
@param allEmployees the hashmap containing all employees
@param importantInfo an array containing important user information, such as user type and ID
*/
    public static void cancelTicketMenu(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees, String[] importantInfo){
        if(importantInfo[0].equalsIgnoreCase("Customer")){
            boolean stayin2 = true;
            while(stayin2){
                System.out.print("You have the following tickets available to cancel: \n");
                allCustomers.get(importantInfo[1]).printAllTickets();
                System.out.print("Enter the confirmation number of the ticket that you would like to cancel: ");
                String ticketID = scan.next();
                System.out.println();
                allFlights.get(ticketID).cancelFlightTicket(Integer.parseInt((ticketID)), importantInfo[1]);
                allCustomers.get(importantInfo[1]).cancelCustomerTicket(ticketID);
                addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " cancelled a ticket for Flight #" + ticketID +" money has been refunded and ticket set to inactive");
                System.out.println("Would you like to cancel the tickets for another flight?\n\n1. Yes\n2. No\n");
                String menuChoice = scan.next();
                    if(menuChoice.equalsIgnoreCase("2")){
                        stayin2 = false;
                    }
                    else{
                        System.out.println("\nmenu uption invalid\n");
                    }
            }
        }
        else if(importantInfo[0].equalsIgnoreCase("Employee")){
            boolean stayIn2 = true;
                while(stayIn2){
                    //itetrate over all of the tickets in flight returning the ticket total to the username attached to the ticket, checkl what type of seats
                    // were purchased and return that amount to that sepcifi type and to total seats as well, finally, set the active parameter inb the tciket to false
                    System.out.print("Please enter the ID of the flight that you would like to cancel: ");
                    String flightToCancel = scan.next();
                    cancelTicketsForFlight(allFlights.get(flightToCancel), allCustomers);
                    System.out.println("Would you like to cancel the tickets for another flight?\n\n1. Yes\n2. No\n");
                    addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " cancelled all tickets for Flight #" + flightToCancel + " all money has been refunded and tickets set to inacvtive");
                    int menuChoice = scan.nextInt();
                    if(menuChoice == 2){
                        stayIn2 = false;
                    }
                }
        }
    }
    /**

This method adds up all the fees for a given flight, including Miner Airlines fee, security fee, and taxes.
@param total the current total of fees
@param currFlight the flight for which the fees should be calculated
@return the new total of fees after all fees have been added
*/
    public static double addAllFees(double total, Flight currFlight){
        double newTotal = addMinerAirlinesFee(total, currFlight);
        newTotal = addSecurityFee(newTotal, currFlight);
        newTotal = addTaxes(newTotal, currFlight);
        return newTotal;
    }
    /**

Adds the Miner Airlines fee of $9.15 to the total cost of the transaction.
@param total the current total cost of the transaction
@param currFlight the flight for which the fee is being added
@return the new total cost of the transaction with the added Miner Airlines fee
*/
    public static double addMinerAirlinesFee(double total, Flight currFlight){
        System.out.println("\nAdded $9.15 MinerAirlinesFee to transaction");
        double minerFee = 9.15;
        currFlight.addMinerAirlinesFee(minerFee);
        return total + minerFee;
    }
    public static double addSecurityFee(double total, Flight currFlight){
        System.out.println("\nAdded $5.60 Security Fee to transaction");
        double securityFee = 5.60;
        currFlight.addSecurityFee(securityFee);
        return total + securityFee;
    }
    public static double minerAirlinesMember(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees, String[] importantInfo, double total, Flight currFlight){
        if(importantInfo[0].equalsIgnoreCase("Customer")){
            if(allCustomers.get(importantInfo[1]).isTicketMiner()){
                System.out.println("\nUser is a Miner Airlines member, 5% discount has been added\n");
                double savings = total * 0.05;
                currFlight.addSavings(savings);
                total -= savings;
                return total;
            }
            else{
                System.out.println("\nUser is not a Miner Airlines Member, 5% discount not added.\n");
                return total;
            }
        }
        else if(importantInfo[0].equalsIgnoreCase("Employee")){
            if(allEmployees.get(importantInfo[1]).isTicketMiner()){
                System.out.println("\nUser is a Miner Airlines member, 5% discount has been added\n");
                double savings = total * 0.05;
                currFlight.addSavings(savings);
                total -= savings;
                return total;
            }
            else{
                System.out.println("\nUser is not a Miner Airlines Member, 5% discount not added.\n");
                return total;
            }
        }
        else{
            System.out.println("\nCould not verify membership, 5% discount not added\n");
            return total;
        }
    }
    public static double addTaxes(double total, Flight currFlight){
        System.out.println("\nAdded Texas Taxes (8.25%) to total\n");
        double newTotal= total + (total * .0825);
        currFlight.addTaxes(total * .0825);
        return total + newTotal;
    }
    public static void addToList(String str){
        allStrings.add(str);
        
    }
    public static void purchaseTicketMenu(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees, String[] importantInfo, boolean automaticPurchasing, String[] actions){
        if(automaticPurchasing == false){
            System.out.print("What Flight would you like to purchase Tickets for?");
            String inputID = scan.next();
            System.out.println("\nThere are 3 types of tickets available, First Class, Business Class and Main Cabin\n");
            System.out.println("1. First Class Price: $" + allFlights.get(inputID).getFirstClassPrice()+" Seats available: "+ allFlights.get(inputID).getFirstClassSeats()+"\n2. Business Class Price: $" + allFlights.get(inputID).getBusinessClassPrice() + " Seats available: "+ allFlights.get(inputID).getBusinessClassSeats()+ "\n3. Main Cabin Price: $" + allFlights.get(inputID).getMainCabinPrice()+ " Seats available: "+ allFlights.get(inputID).getMainCabinSeats());
            System.out.println();
            if(importantInfo[0].equalsIgnoreCase("Customer")){
                System.out.println("Total money available: " + allCustomers.get(importantInfo[1]).getTotalMoney());
            }
            else if(importantInfo[0].equalsIgnoreCase("Employee")){
                System.out.println("Total money available: " + allEmployees.get(importantInfo[1]).getTotalMoney());
            }
            System.out.println();
            System.out.println("\n What type of ticket you would like to purchase?: ");
            String ticketType = scan.next();
            boolean checkNumber = false;
            while(checkNumber!= false){
                if(Integer.parseInt(ticketType)>0 && Integer.parseInt(ticketType)<4){
                    checkNumber = true;
                }
                System.out.print("Invalid input option, please try again: ");
                ticketType = scan.next();
                System.out.println("\n");
            }
            if(Integer.parseInt(ticketType) == 1){
                System.out.println("How many First Class Tickets would you like to purchase? (You can purchase a maximum of 8 at a time)");
                int ticketsPurchased = scan.nextInt();
                if (ticketsPurchased > 8){
                    while(ticketsPurchased > 8){
                        System.out.print("You tried to purchase more than 8 tickets, please enter a different amount: ");
                        ticketsPurchased = scan.nextInt();
                        System.out.println();
                    }
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getFirstClassPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("First Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "First Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            allFlights.get(inputID).addToProfit(newTotal);
                            System.out.println("Thank you for your purchase");
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " First Class Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    
                    System.out.println("As an Employee of MinerAirlines you get 50% off your First Class Ticket Purchase.\n");
                    double discount = ticketTotal * 0.5;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("First Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "First Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            
                            System.out.println("Thank you for your purchase");
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " First Class Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                }
            }
            else if(Integer.parseInt(ticketType) == 2){
                System.out.println("How many Business Class Tickets woudl you like to purchase? ");
                int ticketsPurchased = scan.nextInt();
                if (ticketsPurchased > 8){
                    while(ticketsPurchased > 8){
                        System.out.print("You tried to purchase more than 8 tickets, please enter a different amount: ");
                        ticketsPurchased = scan.nextInt();
                        System.out.println();
                    }
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getBusinessClassPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Business Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Business Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            
                            System.out.println("Thank you for your purchase");
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Business Class Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    
                    System.out.println("As an Employee of MinerAirlines you get 75% off your Business Class Ticket Purchase.\n");
                    double discount = ticketTotal * 0.75;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Business Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Business Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            
                            System.out.println("Thank you for your purchase");
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Business Class Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                }
            }
            else if(Integer.parseInt(ticketType) == 3){
                System.out.println("How many Main Cabin Tickets woudl you like to purchase? ");
                int ticketsPurchased = scan.nextInt();
                if (ticketsPurchased > 8){
                    while(ticketsPurchased > 8){
                        System.out.print("You tried to purchase more than 8 tickets, please enter a different amount: ");
                        ticketsPurchased = scan.nextInt();
                        System.out.println();
                    }
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getMainCabinPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Main Cabin", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Main Cabin", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            
                            System.out.println("Thank you for your purchase");
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Main Cabin Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    
                    System.out.println("As an Employee of MinerAirlines you get 75% off your Main Cabin Ticket Purchase.\n");
                    double discount = ticketTotal * 0.75;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    System.out.println("Your total comes out to: " + newTotal + " Would you like to proceed?\n\n1. Yes\n2. No\n");
                    int confirmPurchase = scan.nextInt();
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)&&confirmPurchase==1){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Main Cabin", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Main Cabin", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            
                            System.out.println("Thank you for your purchase");
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Main Cabin Tickets for Flight #" + inputID);
                            newTicket.printTicket();
                        }
                        else{
                            System.out.print("\nYou purchased more tickets than there are available, please enter another amount.");
                        }
                    }
                    else{
                        System.out.println("Cannot finalize tranaction as you do not have enough money.");
                    }
                }
                
            }

            
        }
        else if(automaticPurchasing){
            String inputID = actions[3];
            if(actions[6].equals("First Class")){
                int ticketsPurchased = Integer.parseInt(actions[7]);
                if (ticketsPurchased > 8){
                    return; //I do this in case its more they just cant buy a ticket
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getFirstClassPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("First Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "First Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            allFlights.get(inputID).addToProfit(newTotal);
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " First Class Tickets for Flight #" + inputID);
                        }
                        else{
                            return;
                        }
                    }
                    else{
                        return;
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    double discount = ticketTotal * 0.5;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("First Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "First Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " First Class Tickets for Flight #" + inputID);
                        }
                        else{
                            return; //if more tickets then available void sale
                        }
                    }
                    else{
                        return; //if not enough money then void sale
                    }
                }
            }
            else if(actions[6].equals("Business Class")){
                int ticketsPurchased = Integer.parseInt(actions[7]);
                if (ticketsPurchased > 8){
                    return;
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getBusinessClassPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Business Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Business Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Business Class Tickets for Flight #" + inputID);
                        }
                        else{
                            return; //if more tickets than available void purchase
                        }
                    }
                    else{
                        return; //if less money than total void purchase
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    double discount = ticketTotal * 0.75;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Business Class", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Business Class", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Business Class Tickets for Flight #" + inputID);
                        }
                        else{
                            return; //if more tickets than available void purchase
                        }
                    }
                    else{
                        return; //if less money than total void purchase
                    }
                }
            }
            else if(actions[6].equals("Main Cabin")){
                int ticketsPurchased = Integer.parseInt(actions[7]);
                if (ticketsPurchased > 8){
                    return;
                }
                boolean isInternational = checkForInternational(allFlights.get(inputID));
                double ticketTotal = ticketsPurchased * allFlights.get(inputID).getMainCabinPrice();
                if(isInternational){
                    ticketTotal = addSurcharge(allFlights.get(inputID), ticketTotal);
                }
                if(importantInfo[0].equalsIgnoreCase("Customer")){
                    double newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allCustomers.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Main Cabin", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Main Cabin", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allCustomers.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            addToList("Customer " + allCustomers.get(importantInfo[1]).getFirstName() + " " + allCustomers.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Main Cabin Tickets for Flight #" + inputID);
                        }
                        else{
                            return;
                        }
                    }
                    else{
                        return;
                    }
                    
                }
                else if(importantInfo[0].equalsIgnoreCase("Employee")){
                    double discount = ticketTotal * 0.75;
                    double newTotal = ticketTotal-discount;
                    newTotal = addAllFees(ticketTotal, allFlights.get(inputID));
                    newTotal = minerAirlinesMember(allCustomers, allFlights, allEmployees, importantInfo, newTotal, allFlights.get(inputID));
                    if(allEmployees.get(importantInfo[1]).hasEnoughMoney(newTotal)){  //This is used to check if the customer has enough money
                        if(allFlights.get(inputID).checkSeats("Main Cabin", ticketsPurchased, allFlights.get(inputID))){  //if theres enough seats avaailable then proceed
                            confirmationNumber += 1;
                            String confirmNumString = String.valueOf(confirmationNumber);
                            Ticket newTicket = new Ticket(newTotal, ticketsPurchased, confirmNumString, allFlights.get(inputID).getID(), importantInfo[1], "Main Cabin", true);  //Create a new ticket given the flighst information and customer enetred amounts
                            allFlights.get(inputID).addTicket(newTicket);  //add ticket to public variable allTickets which contains all purchased tickets
                            allEmployees.get(importantInfo[1]).addTicket(newTicket); //Add tickets to private hashmap of tickets customer owns
                            addToList("Employee " + allEmployees.get(importantInfo[1]).getFirstName() + " " + allEmployees.get(importantInfo[1]).getLastName() + " purchased " + ticketsPurchased + " Main Cabin Tickets for Flight #" + inputID);
                        }
                        else{
                            return;
                        }
                    }
                    else{
                        return;
                    }
                }
            }
        }

    }
    
    public static boolean checkForInternational(Flight currFlight){
        if(currFlight.getFlightType().equalsIgnoreCase("International")){
            System.out.println("Since your Flight is International a " + currFlight.getSurcharge() + " has been added to the total");
            return true;
        }
        return false;
    }
     public static double addSurcharge(Flight currFlight, double totalPrice){
         double newPrice = totalPrice;
         newPrice += currFlight.getSurcharge();
         return newPrice;
     }
    public static void populateMaps(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees)throws FileNotFoundException{
        //Scanners to access files
        Scanner flightScan = new Scanner(new File("FlightSchedulePA4.csv"));  //scanner for file conatining flights
        Scanner customerScan = new Scanner(new File("CustomerListPA4.csv"));  //scanner for file containing customer data
        FileFactory fileContentOrganizor = new FileFactory(); //This is a class used to make contents in a file readable dynamically
        fileContentOrganizor.generateHashMapForFlightFile(); //calling on this will create a hashmap with the indexes of keywords inside file
        fileContentOrganizor.generateHashMapForCustomerFile();
        //fileContentOrganizor.printMap();
        //Skip first line in file
        flightScan.nextLine(); 
        customerScan.nextLine();
        //while loops to populate hashmaps
        while (flightScan.hasNextLine()){   //This while loop populates allFlight hash map with all flight data
            String flightLine = flightScan.nextLine();
            String [] flightInfo = flightLine.split(",");
            Flight currFlight = fileContentOrganizor.generateFlightObject(flightInfo); //Using this method I look up indexes  inside hashmap and place those ityems in the smae place ecerytime given their duynamically changing index
            boolean hasAirport = allFlights.containsKey(currFlight.getOriginAirport().getOriginCode());
            if(hasAirport == false){
                Airport currAirport = fileContentOrganizor.generateAirportObject(flightInfo);
                allAirports.put(currAirport.getCode(), currAirport);
            }

            allFlights.put(currFlight.getID(), currFlight);
        }
        while (customerScan.hasNextLine()){   //This while loop populates allCustomer hash map with all customer data
            
            String customerLine = customerScan.nextLine();
            String [] clientInfo = customerLine.split(",");
            if(clientInfo[3].equalsIgnoreCase("Customer")){ //check whetehr client is a customer
                Customer currCustomer = fileContentOrganizor.generateCustomerObject(clientInfo);
                allCustomers.put(currCustomer.getUserName(), currCustomer);
            }
            else if(clientInfo[3].equalsIgnoreCase("Employee")){ //check whetehr client is an employee
                Employee currEmployee = fileContentOrganizor.generateEmployeeObject(clientInfo);
                allEmployees.put(currEmployee.getUserName(), currEmployee); ///This creates an entry in hasmap with username as key and info as value
            }
        }

    }
    public static void cancelTicketsForFlight(Flight currFlight, HashMap<String, Customer> customerList){
        HashMap<String, Ticket> tempMap = currFlight.getMap();
        for(String key: tempMap.keySet()){
            customerList.get(tempMap.get(key).getUserName()).setTotalMoney( customerList.get(tempMap.get(key).getUserName()).getTotalMoney()+tempMap.get(key).getTotalPrice());
            currFlight.cancelTickets();

        }
        System.out.println("\n*All Tickets for Flight have been Cancelled and Money Refunded*\n");
    }

    public static String[] loginScreen(HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees){
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;
        String[] importantInfo = new String[]{"Role", "temp"};
        while(loggedIn != true){  //This is the main loop, here we start with username and password prompts then continue to eveyrthing else
            System.out.print("Hello and welcome to MinerAir, to get started please enter your First and Last name.\n" + "\nFirst Name: ");
            String firstName = scan.next();
            System.out.print("Last Name: ");
            String lastName = scan.next();
            System.out.println("\nThank you " + firstName + " " + lastName + ", now please enter your username and password.\n");
            System.out.print("Username: ");
            String userName = scan.next();
            boolean isUSerValid = false;
            while(isUSerValid != true){
                Boolean checkCustomer = allCustomers.containsKey(userName);
                Boolean checkEmployee = allEmployees.containsKey(userName);
                if(checkCustomer || checkEmployee){
                    isUSerValid = true;
                    System.out.println("\nUsername Enetered was valid, you may proceed.\n");
                }
                else{
                    System.out.print("The username you entered was invalid please try again: ");
                    userName = scan.next();
                    System.out.println();
                }
            }
            importantInfo[1] = userName;
            System.out.println();
            boolean isValid = false;

            
            while(isValid != true){
                try{
                    if(allCustomers.get(userName).getFirstName().equalsIgnoreCase(firstName) && allCustomers.get(userName).getLastName().equalsIgnoreCase(lastName)){
                        System.out.println("First and Last name associated with username match up, you may proceed.");
                        System.out.println();
                        isValid = true;
                    }
                    else{
                        System.out.println("First or Last name entered do not match up with username, please make sure you enetered the information correctly.");
                        System.out.print("First Name: ");
                        firstName = scan.next();
                        System.out.println();
                        System.out.print("Last Name: ");
                        lastName = scan.next();
                        System.out.println();
                    }
                }
                catch(Exception e){
                    System.out.println("Client is not a customer.");
                }
                try{
                    if(allEmployees.get(userName).getFirstName().equalsIgnoreCase(firstName) && allEmployees.get(userName).getLastName().equalsIgnoreCase(lastName)){
                        System.out.println("First and Last name associated with username match up, you may proceed.");
                        System.out.println();
                        isValid = true;
                    }
                    else{
                        System.out.println("First or Last name entered do not match up with username, please make sure you enetered the information correctly.");
                        System.out.print("First Name: ");
                        firstName = scan.next();
                        System.out.println();
                        System.out.print("Last Name: ");
                        lastName = scan.next();
                        System.out.println();
                    }
                }
                catch(Exception e){
                    System.out.println("Client is not an employee.");

                }
            }
            if(allCustomers.containsKey(userName) || allEmployees.containsKey(userName)){   //first check if username exists, if username doesnt exists then you will start from the beginning
                System.out.print("Please enter your password: ");
                String password = scan.next();
                try{  
                    if(allEmployees.get(userName).getPassword().equalsIgnoreCase(password)){
                        loggedIn = true;
                        importantInfo = new String[]{"Employee", userName};
                        addToList("Employee " + firstName + " " + lastName + ", Username: " + userName + " Logged in");
                        return importantInfo;
                    }
                }
                catch(Exception e){
                    System.out.println("Caught invalid operation");
                }
                try{
                    if(allCustomers.get(userName).getPassword().equalsIgnoreCase(password)){
                        loggedIn = true;
                        importantInfo = new String[]{"Customer", userName};
                        addToList("Customer " + firstName + " " + lastName + ", Username: " + userName + " Logged in");
                        return importantInfo;
                    }
                }
                catch(Exception e){
                    System.out.println("Caught invalid operation");
                }
            }
        }
        return importantInfo;
    }

    public static void customerMenu(String[] importantInfo, HashMap<String, Flight> allFlights, HashMap<String, Customer> allCustomers, HashMap<String, Employee> allEmployees){
        String line = "------------------------------------------------------";
        
        System.out.println("");
        System.out.println("\t"+line);
        System.out.println("Our Records indicate youe are a Customer, Please locate your flights ID and enter it below.");
        System.out.println("\t"+line);
        System.out.println();
        System.out.println("Please enter your Flights ID or type in 'EXIT' to end Session: ");
        boolean validID = false;
        String inputID = scan.next();  //This selects the flight for all future selections
        while(validID == false){
            validID = allFlights.containsKey(inputID);
            if(validID == false){
                System.out.print("Either the number you eneterd is invalid or the flight you are looking for does not exist. Please try again: ");
                inputID = scan.next();  //This selects the flight for all future selections
                System.out.println();
            }
        }
        boolean temp = true;
        while(temp == true){  //Loop To retieve, update and buy tickets for one particular flight
            System.out.print("To go back to log in screen type 'return' otherwise enter any character: ");
            String check = scan.next();
            if(check.equalsIgnoreCase("Return")){
                temp = false;
                break;
            }
            System.out.println();
            System.out.println("Here are the following menu options\n1. View a Flights information\n2. Purchase Tickets\n3. Cancel a ticket\n4. View Tickets\n 5. Go Back\n"); //Add update functionality for an employee
            String in = scan.next();

            if (in.equalsIgnoreCase("1")){  //This section is to view flight information
                viewFlightInformationMenu(allCustomers, allFlights, allEmployees, importantInfo);
            }
            
            
            else if(in.equalsIgnoreCase("2")){  //This section is to purchase tickets
                String[] arr = new String[0];
                purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, false, arr);

            }
            else if(in.equalsIgnoreCase("3")){
                cancelTicketMenu(allCustomers, allFlights, allEmployees, importantInfo);

            }
            else if(in.equalsIgnoreCase("4")){
                System.out.println("\nHere are all your tickets: \n");
                allCustomers.get(importantInfo[1]).printAllTickets();
            }
            else if(in.equalsIgnoreCase("5")){
                return;
            }
            else{ //If menu selection is invalid
                System.out.println("The menu selection you enetered was invalid, please try again");
            }
        }
    }
    public static void employeeMenu(String[] importantInfo, HashMap<String, Customer> allCustomers, HashMap<String, Flight> allFlights, HashMap<String, Employee> allEmployees) throws FileNotFoundException{
        String line = "------------------------------------------------------";
        Scanner scan = new Scanner(System.in);
        boolean employeeMenu = true;
        while(employeeMenu){
            System.out.println("As an employee you have acess to the following menu options:");
            System.out.print("1. View Flight Information by ID\n" + "2. Cancel flights\n"+"3. Purchase Tickets\n"+"4. View Airport Information by Airport Code\n"+ "5. Automatic Ticket Purchasing\n"+"6. Go Back to Log In Screen\n\n"+ " Please make your selection: ");
            String employeeMenuSelection1 = scan.next();
            System.out.println();

            if (employeeMenuSelection1.equalsIgnoreCase("1")){ // this is to view flight information
                System.out.println("1. View Flight Information\n"+
                                    "2. View total number of seats remaining\n"+
                                    "3. View first class seats remaining\n"+
                                    "4. View business class seats remaining\n"+
                                    "5. View main cabin seats remaining\n"+
                                    "6. Inquire list of customer\n" + 
                                    "7. Compute amount collected from frist class seats\n"+
                                    "8. Compute amount collected from Business Class Seats\n"+
                                    "9. Compute amount collected from Main Cabin Seats\n"+
                                    "10 Compute amount collected from all seats sold\n" + 
                                    "11. Compute the total profit expected for the flight\n" +
                                    "12. View total Security Fee collected for flight\n" +
                                    "13. View Total MinerAirlinesFee Collected for flight\n"+
                                    "14. View Total tax collected for the flight\n");

                System.out.print("Please enter your selection: ");
                String employeeMenuSelection2 = scan.next();
                System.out.println();
                System.out.print("Please eneter the flight that you would like to see inquire about: ");
                String employeeFlightSelection = scan.next();
                System.out.println();
                switch(employeeMenuSelection2){
                    case "1":
                        System.out.println("The Flight information is as follows: \n" );
                        allFlights.get(employeeFlightSelection).printFlight();
                        break;
                    case "2":
                        System.out.println("The Total number of seats remaining is: " + allFlights.get(employeeFlightSelection).getTotalSeats());
                        break;
                    case "3":
                        System.out.println("The number of First Class Seats remaining is: " + allFlights.get(employeeFlightSelection).getFirstClassSeats());
                        break;
                    case "4":
                        System.out.println("The number of Business Class Seats remaining is: " + allFlights.get(employeeFlightSelection).getBusinessClassSeats());
                        break;
                    case "5":
                        System.out.println("The number of Main Cabin Seats remaining is: " + allFlights.get(employeeFlightSelection).getMainCabinSeats());
                        break;
                    case "6":
                        System.out.println("The customers on this flight are as follows: ");
                    case "7":
                        System.out.println("The total amount collected from First Class ticket sales is: " + allFlights.get(employeeFlightSelection).totalAmountFirstClass());
                    case "8":
                        System.out.println("The total amount collected from Business Class ticket sales is: " + allFlights.get(employeeFlightSelection).totalAmountBusinessClass());
                    case "9":
                        System.out.println("The total amount collected from Main Cabin ticket sales is: " + allFlights.get(employeeFlightSelection).totalAmountMainCabin());
                    case "10":
                        double totalTicketSales = allFlights.get(employeeFlightSelection).totalAmountFirstClass() + allFlights.get(employeeFlightSelection).totalAmountBusinessClass() + allFlights.get(employeeFlightSelection).totalAmountMainCabin();
                        System.out.println("The total amount collected from all ticket sales is: "+ totalTicketSales);
                    case "11":
                        int expectedProfit = allFlights.get(employeeFlightSelection).expectedProfit();
                        System.out.println("The expected profit to be collected from this flight is: " + expectedProfit);
                    case "12":
                        System.out.println("Total Sceutorty Fee collected for Flight " + employeeFlightSelection + ": " + allFlights.get(employeeFlightSelection).getSecurityFee());
                    case "13":
                        System.out.println("Total Miner Airlines Fee collected for Flight " + employeeFlightSelection + ": " + allFlights.get(employeeFlightSelection).getMinerAirlinesFee());
                    case "14":
                        System.out.println("Total Tax collected for Flight " + employeeFlightSelection + ": " + allFlights.get(employeeFlightSelection).getTaxCollected());
                    default:
                        System.out.println("Invalid menu option");
                }
            }
            else if(employeeMenuSelection1.equalsIgnoreCase("2")){ //this is to cancel a flight
                cancelTicketMenu(allCustomers, allFlights, allEmployees, importantInfo);
            }
            else if(employeeMenuSelection1.equalsIgnoreCase("3")){
                String[] arr = new String[0];
                purchaseTicketMenu(allCustomers, allFlights, allEmployees, importantInfo, false, arr);
            }
            else if(employeeMenuSelection1.equalsIgnoreCase("4")){
                viewAirportInformation(allCustomers, allFlights, allEmployees, importantInfo);
            }
            else if(employeeMenuSelection1.equalsIgnoreCase("5")){
                automaticTicketPurchasing(allCustomers, allFlights, allEmployees);
            }
            else if(employeeMenuSelection1.equalsIgnoreCase("6")){
                employeeMenu = false;
                break;
            }
            else{
                System.out.println("\nMenu Option entered was Invalid, try again.\n");
            }
        }
    }


    public static void main(String[] args) throws IOException{ 
        HashMap<String, Customer> allCustomers = new HashMap<String, Customer>();  //create a hashamp for customers
        HashMap<String, Flight> allFlights = new HashMap<String, Flight>();  //create a hashmap for flights
        HashMap<String, Employee> allEmployees = new HashMap<String, Employee>();  //create a hashmap for employees
        //these are the hashmaps that are used to view and access relative infromation to these objects

        populateMaps(allCustomers, allFlights, allEmployees); //Running this will populate all of the hash maps with information from csv files
        Scanner scan = new Scanner(System.in);
        //File write to write contents to a separte file
        FileWriter flightUpdateLog = new FileWriter("flightUpdateLog.txt", true);  //this is used to write actions to a separate file
        boolean loop = true;
        while(loop == true){ 
            //This is the main loop, here we start with username and password prompts then continue to eveyrthing else  //if username exists check if password is valid, now select flight. If pass is incorrect then you will restart from the beginning

            String[] importantInfo = loginScreen(allCustomers, allFlights, allEmployees);
            System.out.println("Log in succesful");
    
            
            System.out.println("\t"+line);
            System.out.println("\t"+line);
            System.out.println("Would you like to continue your session?\n\n1. Yes\n2. No\n");
            if(scan.next().equals("2")){
                break;
            }
            
            if(importantInfo[0].equalsIgnoreCase("Customer")){
                customerMenu(importantInfo, allFlights, allCustomers, allEmployees);
            }
            else if(importantInfo[0].equalsIgnoreCase("Employee")){
                employeeMenu(importantInfo, allCustomers, allFlights, allEmployees);
            }

        }
        for(String str: allStrings){ //This writes eeveything form yhe book intot he none eixitygkkldslklsdksklj;saklkkdklksal;;a  akak akak kakkka a kekewkskKALSKA  SKlklsk k wkl;kalks  KSKSKL;AKlkslak
            flightUpdateLog.write(str + System.lineSeparator());
        }
        flightUpdateLog.close();
        
        scan.close();
        System.out.println();
        System.out.println("\t"+line + "--------");
        System.out.println("\tThank you for flying with MinerAir, we wish you a great rest of your day!");
        System.out.println("\t"+line + "--------");

    }
}
