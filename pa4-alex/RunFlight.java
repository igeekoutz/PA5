/*
 * Name: Alejandro Olivas
 * Date: 1/19/2023
 * Course: CS 3331 
 * CRN: 21219
 * Instructor: Daniel Mejia
 * Programmin Assignment 0
 * Lab Description:
 * Honesty Statement: I completed this work entirely on my own without any outside sources.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This RunFlight class will be printing and recieving information from the
 * user.
 * It will call data to be able to modify and recieve information.
 * 
 * @version 3.0
 */
public class RunFlight {

    /**
     * Prints the Main menu and asks the user for a first and last name.
     * Then calls the login method
     * 
     * @param args args argument taken into the main
     */
    public static void main(String[] args) {
        // Send the Filename with flights and populate the data
        Data myData = new Data();
        String flightFileName = "./FlightSchedule.csv";
        boolean populatedFlightSuccessfully = myData.populateFlights(flightFileName);
        String customerFileName = "./CustomerListPA4.csv";
        boolean populatedCustomersSuccessfully = myData.populateCustomers(customerFileName);
        if (!populatedFlightSuccessfully || !populatedCustomersSuccessfully) {
            exit(myData);
        }

        // Attributes that are used multiple times
        Scanner input = new Scanner(System.in);
        String userInput = "";
        final String lineSepa = "---------------------------------------------------";
        CurUserSingleton curUser = CurUserSingleton.getInstance();
        DecimalFormat moneyFormat = new DecimalFormat("#.##");

        // Welcome Message
        System.out.println("\t\t  Welcome to MinerAir!");

        // Main Menu
        while (!userInput.equalsIgnoreCase("exit")) {
            // Show Menu and get the Users Information
            System.out.println("\t\t-------------------------\n \t\t\tMain Menu\n \t\t-------------------------");
            System.out
                    .print("Please enter your First and Last Name to continue or type 'EXIT' to Quit! \nFirst Name >");
            String firstName = input.nextLine();
            if (firstName.equals("EXIT")) {
                break;
            }
            System.out.print("Last Name >");
            String lastName = input.nextLine();
            if (lastName.equals("EXIT")) {
                break;
            }

            // Allow the user to log in
            logIn(input, myData, curUser, firstName, lastName, lineSepa, moneyFormat);
        }

        myData.writeInfo();
        input.close();
        exit(myData);
    }

    /**
     * Gets the users username and password and checks if it's valid.
     * 
     * @param input       This is a scanner that the method will need to use.
     * @param myData      This is a object to be able to acces the Data class.
     * @param curUser     This is a curUserSingleton to be able to acces the
     *                    curUser.
     * @param firstName   This is the firstName that the user gave us.
     * @param lastName    This is the lastName that the user gave us.
     * @param lineSepa    This is a String that just adds a lot of lines to make
     *                    prints look cleaner.
     * @param moneyFormat This is a format to be able to print money with only two
     *                    decimals
     */
    public static void logIn(Scanner input, Data myData, CurUserSingleton curUser, String firstName, String lastName,
            String lineSepa, DecimalFormat moneyFormat) {
        boolean validInput = false;

        while (!validInput) {
            // Get the Customers log in information
            System.out.println("\t\t-------------------------\n \t\t         Log In\n \t\t-------------------------");
            System.out.print("Please enter your Username and Password or 'BACK' to go back to Main Menu.\nUsername >");
            String username = input.nextLine();
            System.out.print("Password >");
            String password = input.nextLine();

            // Go back if user wants to return to main menu
            if (username.equalsIgnoreCase("back") || password.equalsIgnoreCase("back")) {
                return;
            }

            // Check if the passwords valid
            if (myData.checkUsername(username) && myData.checkPassword(password)) {
                validInput = true;
            }

            // Check if the first and last name match the user if we found a username
            if (validInput && (!myData.accountMatch(firstName, lastName) || !myData.checkUsername(username))) {
                System.out.println(
                        "\nFirst and Last name don't match Username! Please try again!\n------------------------------------------------------------");
                myData.writeToLog("User inputted incorrect First or Last name for " + username, true);
                return;
            }

            if (!validInput) {
                System.out.println(
                        "\nInvalid Log In, Please try again!\n---------------------------------------------------\n");
                myData.writeToLog(username + " Failed to Log In", true);
            }

            if (validInput) {
                myData.writeToLog(username + " Logged In", true);
            }
        }

        // Send the user to the appropriate Menu based on their role
        if (curUser.getCurUserType().equals("Customer")) {
            customerMenu(input, myData, curUser, lineSepa, moneyFormat);
        } else if (curUser.getCurUserType().equals("Employee")) {
            employeeMenu(input, myData, curUser, lineSepa, moneyFormat);
        }
    }

    /**
     * Prints the Customer Menu and gives them options for what they want do.
     * 
     * @param input       This is a scanner that the method will need to use.
     * @param myData      This is a object to be able to acces the Data class.
     * @param curUser     This is a curUserSingleton to be able to acces the
     *                    curUser.
     * @param lineSepa    This is a String that just adds a lot of lines to make
     *                    prints
     *                    look cleaner.
     * @param moneyFormat This is a format to be able to print money with only two
     *                    decimals
     */
    public static void customerMenu(Scanner input, Data myData, CurUserSingleton curUser, String lineSepa,
            DecimalFormat moneyFormat) {
        String userInput = "";

        // Ask the user what they would like to do view or change flight info
        while (!userInput.equalsIgnoreCase("BACK")) {
            System.out
                    .println("\t\t-------------------------\n \t\t      Customer Menu\n \t\t-------------------------");
            System.out.println(lineSepa);
            System.out.println("Please select 'a', 'b', 'c', 'd' or 'BACK' to go to Main Menu");
            System.out.print(
                    "\ta) View Flight Information \n \tb) Purchase Flight Tickets\n \tc) View Balance \n \td) View Tickets Purchased \n \te) Cancel Ticket \n>");
            userInput = input.nextLine();
            // Switch to the choice the user selected
            switch (userInput.toLowerCase()) {
                case "a":
                    System.out.println(lineSepa);
                    myData.writeToLog("Customer Chose to Show Fligth Information", false);
                    checkFilghtID(input, myData, false, lineSepa);
                    break;
                case "b":
                    System.out.println(lineSepa);
                    myData.writeToLog("Customer Started Ticket Purchase", false);
                    purchaseTickets(input, myData, curUser, lineSepa, moneyFormat);
                    break;
                case "c":
                    System.out.println(lineSepa);
                    System.out.println(
                            "Current Balance: $" + moneyFormat.format(curUser.getCustomer().getMoneyAvailable()));
                    System.out.println();
                    myData.writeToLog("Customer Viewed Balance", false);
                    break;
                case "d":
                    System.out.println(lineSepa);
                    myData.printUserTickets();
                    myData.writeToLog("Customer Viewed Tickets Purchased", false);
                    break;
                case "e":
                    System.out.println(lineSepa);
                    myData.writeToLog("Customer Started Ticket Cancelation", false);
                    cancelTickets(input, myData, curUser, lineSepa);
                    break;
                case "back":
                    myData.writeToLog("Customer went back to Main Menu", false);
                    break;
                default:
                    System.out.println(
                            "\nInvalid input, Please type one of the choices below or 'BACK'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Prints the Employee menu and gives them options for what they want to do
     * 
     * @param input       This is a scanner that the method will need to use.
     * @param myData      This is a object to be able to acces the Data class.
     * @param curUser     This is a curUserSingleton to be able to acces the
     *                    curUser.
     * @param lineSepa    This is a String that just adds a lot of lines to make
     *                    prints
     *                    look cleaner.
     * @param moneyFormat This is a format to be able to print money with only two
     *                    decimals
     */
    public static void employeeMenu(Scanner input, Data myData, CurUserSingleton curUser, String lineSepa,
            DecimalFormat moneyFormat) {
        String userInput = "";

        // Ask the user what they would like to do view or change flight info
        while (!userInput.equalsIgnoreCase("BACK")) {
            System.out
                    .println("\t\t-------------------------\n \t\t      Employee Menu\n \t\t-------------------------");
            System.out.println(lineSepa);
            System.out.println("Please select 'a', 'b' or 'BACK' to go to Main Menu");
            System.out.print(
                    "\ta) View/Modify Flight Information \n \tb) View Airport Information \n \tc) Purchase Flight Tickets\n \td) View Balance \n \te) View Tickets Purchased \n \tf) Cancel Ticket \n \tg) Automatic Purchasing \n \th) Print Electronic Ticket\n>");
            userInput = input.nextLine();
            // Switch to the choice the user selected
            switch (userInput.toLowerCase()) {
                case "a":
                    System.out.println(lineSepa);
                    myData.writeToLog("Employee Chose to Show Fligth Information", false);
                    checkFilghtID(input, myData, true, lineSepa);
                    break;
                case "b":
                    System.out.println(lineSepa);
                    chooseAirport(input, myData, lineSepa);
                    myData.writeToLog("Employee viewed airport Information", false);
                    break;
                case "c":
                    System.out.println(lineSepa);
                    myData.writeToLog("Employee Started Ticket Purchase", false);
                    purchaseTickets(input, myData, curUser, lineSepa, moneyFormat);
                    break;
                case "d":
                    System.out.println(lineSepa);
                    System.out.println(
                            "Current Balance: $" + moneyFormat.format(curUser.getEmployee().getMoneyAvailable()));
                    System.out.println();
                    myData.writeToLog("Employee Viewed Balance", false);
                    break;
                case "e":
                    System.out.println(lineSepa);
                    myData.printUserTickets();
                    myData.writeToLog("Employee Viewed Tickets Purchased", false);
                    break;
                case "f":
                    System.out.println(lineSepa);
                    myData.writeToLog("Employee Started Ticket Cancelation", false);
                    cancelTickets(input, myData, curUser, lineSepa);
                    break;
                case "g":
                    System.out.println(lineSepa);
                    myData.writeToLog("Employee went to the Automatic Ticket menu", false);
                    automaticTicket(input, myData, lineSepa);
                    break;
                case "h":
                    System.out.println(lineSepa);
                    myData.writeToLog("Employee started Electronic Ticket Menu", false);
                    electronicTicketMenu(input, myData, lineSepa);
                    break;
                case "back":
                    myData.writeToLog("Employee went back to Main Menu", false);
                    break;
                default:
                    System.out.println(
                            "\nInvalid input, Please type one of the choices below or 'BACK'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Allows a User to Purchase a ticket for one flight, one class, and 8 seats
     * max
     * 
     * @param input       This is a scanner that the method will need to use.
     * @param myData      This is a object to be able to acces the Data class.
     * @param curUser     This is a curUserSingleton to be able to acces the
     *                    curUser.
     * @param lineSepa    This is a String that just adds a lot of lines to make
     *                    prints
     *                    look cleaner.
     * @param moneyFormat This is a format to be able to print money with only two
     *                    decimals
     */
    public static void purchaseTickets(Scanner input, Data myData, CurUserSingleton curUser, String lineSepa,
            DecimalFormat moneyFormat) {

        // Call the checkFlightID to
        boolean validId = checkFilghtID(input, myData, false, lineSepa);
        if (!validId) {
            myData.writeToLog("User left Ticket Purchase Menu", false);
        }

        // Verify flight isn't canceled
        if (myData.checkFlightCanceled()) {
            System.out.println(lineSepa);
            System.out.println("\tERROR FLIGHT HAS BEEN CANCELED");
            System.out.println(lineSepa);
            myData.writeToLog("User tried to purchase tickets for canceled flight", false);
            return;
        }

        // Ask the user what Class they wanna be in and how many ticket they want to
        // purchase
        boolean validInput = false;
        String classType = "";
        while (!validInput) {
            System.out.println(lineSepa);
            System.out.println(
                    "What class will you like to be in, Select 'a', 'b', 'c' or 'BACK' to exit Purchase Menu?");
            myData.showFlightClass();
            System.out.print(">");
            classType = input.nextLine();

            // Leave method if the user wants to go back or check if the input is valid
            if (classType.equalsIgnoreCase("back")) {
                myData.writeToLog("User left Ticket Purchase", false);
                return;
            } else if (!(classType.equalsIgnoreCase("a") || classType.equalsIgnoreCase("b")
                    || classType.equalsIgnoreCase("c"))) {
                System.out.println(
                        "\nInvalid input, Please type 'a', 'b', 'c' or 'BACK'!\n---------------------------------------------------\n");
            } else {
                validInput = true;
            }

            // Change the class type to the actual name to make it easier to refer to it
            switch (classType) {
                case "a":
                    classType = "First Class";
                    break;
                case "b":
                    classType = "Business Class";
                    break;
                case "c":
                    classType = "Main Cabin";
                    break;
            }
        }

        // Ask the user for how many tickets until a valid answer is given
        boolean validNumTickets = false;
        int numOfTickets = -1;
        double ticketPrice = 0;
        double maFee = 0;
        double securityFee = 0;
        double maSavings = 0;
        double salesTax = 0;
        double totalPrice = 0;
        while (!validNumTickets) {
            System.out.print(
                    "Enter the amout of tickets do you want to purchase for this Flight 1-8? Max 8! or 'BACK' to exit Purchase Menu\n>");
            String userInput = input.nextLine();

            // Leave method if the user wants to go back
            if (userInput.equalsIgnoreCase("back")) {
                myData.writeToLog("User left Ticket Purchase", false);
                return;
            }

            // Check if the user gave a valid num of tickets
            try {
                numOfTickets = Integer.parseInt(userInput);
                if (numOfTickets > 8) {
                    System.out.println(
                            "Invalid Number of Tickets! Max 8!\n---------------------------------------------------\n");
                } else {
                    validNumTickets = true;
                }
            } catch (NumberFormatException n) {
                System.out.println(
                        "Invalid Number of Tickets! Please try again\n---------------------------------------------------\n");
                System.out.println(lineSepa + "\n");
                continue;
            }

            // Check if there are enought seats in that class
            if (myData.checkSeats(classType, numOfTickets)) {
                validInput = true;
            } else {
                System.out.println(
                        "\nError not enough Seat. Please Choose a different Class!\n---------------------------------------------------\n");
                validNumTickets = false;
            }

            // Once we checked for valid choices get the price of the tickets for later
            ticketPrice = myData.getFlightPrice(classType, numOfTickets);
            maSavings = myData.getSavings(ticketPrice);
            maFee = myData.getMaFee();
            securityFee = myData.getSecurityFee(numOfTickets);
            salesTax = myData.getSalesTax(ticketPrice, maSavings, maFee, securityFee);
            totalPrice = (ticketPrice - maSavings) + maFee + securityFee + salesTax;

        }

        // Show the user their detials of the purchase(Ticket) and ask to confirm
        validInput = false;
        double curUserMoneyAvailable = 0;
        if (curUser.getCurUserType().equals("Customer")) {
            curUserMoneyAvailable = curUser.getCustomer().getMoneyAvailable();
        } else if (curUser.getCurUserType().equals("Employee")) {
            curUserMoneyAvailable = curUser.getEmployee().getMoneyAvailable();
        }
        while (!validInput) {
            System.out.println("\n \tTicket Information" +
                    "\n \t-------------------" +
                    "\nFight ID: " + myData.getFlightID() +
                    "\nNumber of Seats: " + numOfTickets +
                    "\nClass: " + classType +
                    "\n \tFees and Taxes" +
                    "\n \t-------------------" +
                    "\nTicket Price: $" + moneyFormat.format(ticketPrice) +
                    "\nMinersAirlines Member Savings: $" + moneyFormat.format(maSavings) +
                    "\nMinersAirline Fee: $ " + moneyFormat.format(maFee) +
                    "\nSecurity Fee: $" + moneyFormat.format(securityFee) +
                    "\nSales Tax: $" + moneyFormat.format(salesTax) +
                    "\nTotal: $" + moneyFormat.format(totalPrice) +
                    "\n \tCustomer Wallet" +
                    "\n \t-------------------" +
                    "\nMoney Avaliable: $" + moneyFormat.format(curUserMoneyAvailable));
            // Print how much an employee saved
            if (curUser.getCurUserType().equals("Employee")) {
                System.out.println("\tEmployee Discount Applied" +
                        "\n \t-------------------");
                if (classType.equals("First Class")) {
                    System.out.println("50% off");
                } else {
                    System.out.println("75% off");
                }
            }

            System.out.println("\nPlease select 'a' or 'b'.");
            System.out.print("\ta) Conrim Purchase \n \tb) Cancel Purchase\n>");
            String userConfirmation = input.nextLine();

            if (userConfirmation.equalsIgnoreCase("b")) {
                myData.writeToLog("Customer Canceled Purchase", false);
                return;
            } else if (userConfirmation.equalsIgnoreCase("a")) {
                validInput = true;
            } else {
                System.out.println(
                        "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
            }
        }

        // Check if the user has enough money to purchase the tickets and decrease that
        // from their wallet
        if (!myData.checkBalance(totalPrice)) {
            System.out.println(
                    "\nError not enough funds in Users Account! Please Try Again\n---------------------------------------------------\n");
            myData.writeToLog("Customer's Purchase had invalid funds.", false);
            return;
        }

        // Once confirmed remove those seats from the flight and add the ticket to the
        // flight/customer, then print the ticket
        myData.validatePurchase(classType, numOfTickets, ticketPrice, maSavings, maFee, securityFee, salesTax,
                totalPrice, true);
        myData.writeToLog("User Purchased a Ticket for Flight ID: " + myData.getFlightID() + ", Class:" + classType
                + ", Num of Tickets: " + numOfTickets, false);
    }

    /**
     * Allows the User to cancel a ticket that they have purchased.
     * 
     * @param input    This is a scanner that the method will need to use.
     * @param myData   This is a object to be able to acces the Data class.
     * @param curUser  This is a curUserSingleton to be able to acces the curUser.
     * @param lineSepa This is a String that just adds a lot of lines to make prints
     *                 look cleaner.
     */
    public static void cancelTickets(Scanner input, Data myData, CurUserSingleton curUser, String lineSepa) {
        boolean validConfirmationNum = false;
        String userInput = "";
        int confirmationNum = 0;
        while (!validConfirmationNum) {
            myData.printUserTickets();
            System.out.println(lineSepa);
            System.out.print(
                    "Enter the Confirmation Number of the flight you will like to Cancel Tickets for or 'BACK' to exit.\n>");
            userInput = input.nextLine();

            // Leave method if the user wants to go back
            if (userInput.equalsIgnoreCase("back")) {
                myData.writeToLog("Customer left Ticket Cancelation", false);
                return;
            }

            // Try to convert value given to an int
            try {
                confirmationNum = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println(
                        "\nInvalid input, Please verify your Confirmation Number and try again!\n---------------------------------------------------\n");
                continue;
            }

            // Check if user gave a valid Confirmation Number
            validConfirmationNum = myData.checkTicketConfirmationNum(confirmationNum);
            if (!validConfirmationNum) {
                System.out.println(
                        "\nInvalid input, Please verify your Confirmation Number and try again!\n---------------------------------------------------\n");
            }
        }

        // Show the user their detials of the purchase(Ticket) and ask to confirm
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\nIs the Ticket showen above the one you want to cancel? Please select 'a' or 'b'.");
            System.out.println(lineSepa);
            System.out.print("\ta) Confirm Ticket Cancelation \n \tb) Cancel Ticket Cancelation\n>");
            userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("b")) {
                myData.writeToLog("Customer Canceled Ticket Cancelation", false);
                return;
            } else if (userInput.equalsIgnoreCase("a")) {
                myData.cancelUserTicket(confirmationNum);
                myData.writeToLog("User Canceled Ticket " + confirmationNum, false);
                validInput = true;
            } else {
                System.out.println(
                        "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Prints the Employee View/Change Flight menu and options for what they want to
     * do
     * 
     * @param input    This is a scanner that the method will need to use.
     * @param myData   This is a object to be able to acces the Data class.
     * @param lineSepa This is a String that just adds a lot of lines to make prints
     *                 look cleaner.
     */
    public static void employeeInterface(Scanner input, Data myData, String lineSepa) {
        String userInput = "";

        // Ask the user what they would like to do view or change flight info
        while (!userInput.equalsIgnoreCase("BACK")) {
            System.out.println(lineSepa);
            System.out.println("Please select 'a', 'b' or 'BACK' to go to Change Flight ID");
            // by entering an aiprots cod
            System.out.print(
                    "\ta) View Flight Information\n \tb) View Seats Left/Sold \n \tc) View Seats Revenue \n \td) View Customers List \n \te) View Fligth Profits \n \tf) Edit Flight Informaiton \n \tg) Cancel Flight \n>");
            userInput = input.nextLine();
            // Switch to the choice the user selected
            switch (userInput.toLowerCase()) {
                case "a":
                    System.out.println(lineSepa);
                    myData.showFlightInfo();
                    myData.writeToLog("Employee Viewed Flight Information", false);
                    break;
                case "b":
                    System.out.println(lineSepa);
                    myData.showSeatsLeft();
                    myData.writeToLog("Employee Viewed Seats Left/Sold", false);
                    break;
                case "c":
                    System.out.println(lineSepa);
                    myData.showSeatsRevenue();
                    myData.writeToLog("Employee Viewed Seats Revenue", false);
                    break;
                case "d":
                    System.out.println(lineSepa);
                    myData.showCustomerList();
                    myData.writeToLog("Employee Viewed Customers List", false);
                    break;
                case "e":
                    System.out.println(lineSepa);
                    myData.showFlightProfits();
                    myData.writeToLog("Employee Viewed Fligth Profits", false);
                    break;
                case "f":
                    System.out.println(lineSepa);
                    changeFlightInfo(input, myData);
                    break;
                case "g":
                    System.out.println(lineSepa);
                    cancelFlight(input, myData, lineSepa);
                    break;
                case "back":
                    break;
                default:
                    System.out.println(
                            "\nInvalid input, Please type an option below or 'BACK'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Allows a user to choose an airport using the id or the origin and destination
     * airports
     * 
     * @param input    Scanner object for the method to use
     * @param myData   Data object for the method to user
     * @param lineSepa String that helps format the prints
     */
    public static void chooseAirport(Scanner input, Data myData, String lineSepa) {
        boolean validInput = false;
        String airportCode = "";
        while (!validInput) {
            System.out
                    .println(
                            "\t\t------------------------------------\n \t\t\tAirport Information Menu\n \t\t------------------------------------");
            System.out.print(
                    "Please enter the Code of the Airport you would like to see the information for or 'BACK' to go back\n>");
            airportCode = input.nextLine();

            // Leave menu if user want to go back
            if (airportCode.equalsIgnoreCase("back")) {
                myData.writeToLog("User Left Airport Information Menu", false);
            }

            if (myData.showAirportInfo(airportCode)) {
                validInput = true;
                myData.writeToLog("User viewed Airport information with code: " + airportCode, false);
            } else {
                System.out.println(
                        "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Prompts a user for their flight ID, after an accurate ID is given it'll call
     * the next appropriate method
     * 
     * @param input      This is a scanner that the method will need to use.
     * @param myData     This is a object to be able to acces the Data class.
     * @param isEmployee This is a boolean that tells the method if an employee
     *                   called this method
     * @param lineSepa   This is a String that just adds a lot of lines to make
     *                   prints look cleaner.
     */
    public static boolean checkFilghtID(Scanner input, Data myData, boolean isEmployee, String lineSepa) {

        boolean validInput = false;
        String searchChoice = "";
        boolean searchByCode = false;

        // Ask the user if they wanna search by Flight Code Flight ID
        while (!validInput) {
            System.out
                    .println("\t\t-------------------------\n \t\t\tFlight Menu\n \t\t-------------------------");
            System.out.print(
                    "\ta) Search Flight by Airport Code \n \tb) Search Flight by ID\n \tor 'BACK' to go back\n>");
            searchChoice = input.nextLine();

            // Leave menu if user want to go back
            if (searchChoice.equalsIgnoreCase("back")) {
                myData.writeToLog("User Left Flight Menu", false);
                return false;
            }

            if (searchChoice.equalsIgnoreCase("a")) {
                validInput = true;
                searchByCode = true;
            } else if (searchChoice.equalsIgnoreCase("b")) {
                validInput = true;
            } else {
                System.out.println(
                        "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
            }
        }

        validInput = false;
        if (searchByCode) {
            while (!validInput) {
                // Print instructions and get the users Flight id
                System.out
                        .println(
                                "\t\t-------------------------\n \t\t\tFlight Code Menu\n \t\t-------------------------");
                System.out.print("Please enter the Origin Code or 'BACK' to go back:\n >");
                String origCode = input.nextLine();
                // Leave menu if user want to go back
                if (origCode.equalsIgnoreCase("back")) {
                    myData.writeToLog("User Left Flight Menu", false);
                    return false;
                }
                System.out.print("Please enter the Destination Code or 'BACK' to go back:\n >");
                String distCode = input.nextLine();
                // Leave menu if user want to go back
                if (origCode.equalsIgnoreCase("back")) {
                    myData.writeToLog("User Left Flight Menu", false);
                    return false;
                }

                // Check if the user inputed a valid airport codes
                validInput = myData.checkCode(origCode, distCode);

                if (!validInput) {
                    System.out.println(
                            "\nInvalid input, Please verify the codes and try again!\n---------------------------------------------------\n");
                }
            }
        }

        validInput = false;
        String usersId = "";

        while (!validInput) {
            // Print instructions and get the users Flight id
            System.out.println("\t\t-------------------------\n \t\t\tFlight ID Menu\n \t\t-------------------------");
            System.out.print("Please enter the ID of the Flight you want to view or 'BACK' to go back.\n >");
            usersId = input.nextLine();

            // Don't check anything just return 'q' to quit if user wants to quit
            if (usersId.equalsIgnoreCase("BACK")) {
                myData.writeToLog("User Left Flight Menu", false);
                return false;
            }

            // Check if the user inputed a valid id
            validInput = myData.checkId(usersId);
            if (!validInput) {
                System.out.println(
                        "\nInvalid input, Please verify your ID and try again!\n---------------------------------------------------\n");
            }
        }

        // If the current User is an employee send them to Employee Interface, else show
        // the customer the flight info
        if (isEmployee) {
            myData.writeToLog("Employee chose Flight ID: " + usersId, false);
            employeeInterface(input, myData, lineSepa);
        } else {
            myData.showFlightInfo();
            myData.writeToLog("Customer chose Flight ID: " + usersId, false);
        }
        return true;
    }

    /**
     * Asks the Employee what they would like to change and calls data with their
     * choices.
     * 
     * @param input  This is a scanner that the method will need to use.
     * @param myData This is a object to be able to acces the Data class.
     */
    public static void changeFlightInfo(Scanner input, Data myData) {
        // Ask the user what they will like to change, go back or quite. Get user input
        String changeOption = "";
        while (!changeOption.equalsIgnoreCase("b")) {
            System.out.println(
                    "Please select the number that corresponds with what you will like to edit or 'BACK' to go back");
            System.out.print("\t1) Change Origin Airport" +
                    "\n \t2) Change Origin Code" +
                    "\n \t3) Change Destination Airport" +
                    "\n \t4) Change Destination Code" +
                    "\n \t5) Change Departure Date" +
                    "\n \t6) Change Departure Time" +
                    "\n \t7) Change First Class Price" +
                    "\n \t8) Change Business Class Price" +
                    "\n \t9) Change Main Cabin Price \n>");
            changeOption = input.nextLine();

            // Skip calling the method if they want to go back
            if (changeOption.equalsIgnoreCase("back")) {
                break;
            }

            // Call the method in data to change that option and pass the scanner
            myData.changeInfo(changeOption, input);
        }
    }

    /**
     * Allows the Employee to cancel the Flight for everyone
     * 
     * @param input    This is a scanner that the method will need to use.
     * @param myData   This is a object to be able to acces the Data class.
     * @param lineSepa This is a String that just adds a lot of lines to make prints
     *                 look cleaner.
     */
    public static void cancelFlight(Scanner input, Data myData, String lineSepa) {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n \tCancel Flight" +
                    "\n \t-------------------" +
                    "\n Are you sure you want to cancel Flight Id: " + myData.getFlightID());
            System.out.println("\nPlease select 'a' or 'b'.");
            System.out.print("\ta) Confirm Flight Cancelation \n \tb) Don't Cancel Flight\n>");
            String userConfirmation = input.nextLine();

            if (userConfirmation.equalsIgnoreCase("b")) {
                myData.writeToLog("Employee declined cancelation of flight id: " + myData.getFlightID(), false);
                return;
            } else if (userConfirmation.equalsIgnoreCase("a")) {
                myData.cancelFlight();
                myData.writeToLog("Employee canceled the Flight ID: " + myData.getFlightID(), false);
                System.out.println(lineSepa);
                System.out.println("Flight Canceled!");
                System.out.println(lineSepa);
                validInput = true;
            } else {
                System.out.println(
                        "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
            }
        }
    }

    /**
     * Allows the employee to automatic purchase a list of tickets
     * 
     * @param input    This is a scanner that the method will need to use.
     * @param myData   This is a object to be able to acces the Data class.
     * @param lineSepa This is a String that just adds a lot of lines to make prints
     *                 look cleaner.
     */
    public static void automaticTicket(Scanner input, Data myData, String lineSepar) {
        boolean validInput = false;
        String userInput = "";

        // Ask the user if they wanna search by Flight Code Flight ID
        while (!validInput) {
            System.out
                    .println("\t\t-------------------------\n \t\t\tAutomation Menu\n \t\t-------------------------");
            System.out.println(
                    "Which file will you like to run for automation, please choose a letter or 'BACK' to go back:");
            System.out.print(
                    "\ta) AutoPurchaser10k.csv \n \tb) AutoPurchaser100k.csv \n \tc) autoPurchaser400k.csv\n>");
            userInput = input.nextLine();

            // Leave menu if user want to go back
            if (userInput.equalsIgnoreCase("back")) {
                myData.writeToLog("User left automation", false);
                return;
            }

            validInput = true;

            switch (userInput) {
                case "a":
                    myData.writeToLog("User ran the ticket automation with the 10k file", false);
                    myData.automaticPurchasing("AutoPurchaser10k.csv");
                    break;
                case "b":
                    myData.writeToLog("User ran the ticket automation with the 100k file", false);
                    myData.automaticPurchasing("AutoPurchaser100k.csv");
                    break;
                case "c":
                    myData.writeToLog("User ran the ticket automation with the 400k file", false);
                    myData.automaticPurchasing("AutoPurchaser400k.csv");
                    break;
                default:
                    System.out.println(
                            "\nInvalid input, Please type 'a' or 'b'!\n---------------------------------------------------\n");
                    validInput = false;
                    break;
            }
        }

    }

    /**
     * Allows the Employee to print an electronic version of a users tickets
     * 
     * @param input    This is a scanner that the method will need to use.
     * @param myData   This is a object to be able to acces the Data class.
     * @param lineSepa This is a String that just adds a lot of lines to make prints
     *                 look cleaner.
     */
    public static void electronicTicketMenu(Scanner input, Data myData, String lineSepa) {
        boolean validInput = false;

        while (!validInput) {
            // Get the Username of the user
            System.out.println(
                    "\n\t\t-------------------------\n \t\tElectronic Ticket menu\n \t\t-------------------------");
            System.out.print(
                    "Please enter your Username of the User you want to print the tickets for or 'BACK' to go back to Main Menu.\nUsername >");
            String username = input.nextLine();

            // Go back if user wants to return to main menu
            if (username.equalsIgnoreCase("back")) {
                return;
            }

            // Call the method to print the ticket of the user
            validInput = myData.writeElectronicTickets(username);
            if (validInput) {
                myData.writeToLog("Printed Electronic Ticket For: " + username, false);
            }
        }

    }

    /**
     * Exits the program and saves/closes anything that is still left
     * 
     * @param myData This is a object to be able to acces the Data class.
     */
    public static void exit(Data myData) {
        myData.writeToLog("User Quit!", true);
        System.out.println("Goodbye!");
        System.exit(0);
    }

}