import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteElectronicTicket {

    /**
     * Default constructor
     */
    public WriteElectronicTicket() {

    }

    /**
     * Writes the data of a ticket and flight to a csv file for a single ticket
     * 
     * @param ticketIn  Ticket object
     * @param curFlight Flight object
     */
    public void writeTicket(Ticket ticketIn, Flight curFlight) {
        String fileName = ticketIn.getUsername() + "_Electronic_Ticket_Summary.csv";

        try {
            // Create the new file and the writer
            File ticketFile = new File(fileName);
            FileWriter writer = new FileWriter(ticketFile, true);

            // Write all the information of the ticket to the file
            writer.write(
                    "Ticket Information " + "\n" +
                            "-------------------------" + "\n" +
                            "Confirmation Number: " + ticketIn.getConfirmationNum() + "\n" +
                            "Flight Origin Airport Code: " + curFlight.getOrigCode() + "\n" +
                            "Flight Origin Airport Name: " + curFlight.getOrigAirportName() + "\n" +
                            "Flight Destination Airport Code: " + curFlight.getDestCode() + "\n" +
                            "Flight Destination Airport Name: " + curFlight.getDestAirportName() + "\n" +
                            "Departure Date: " + curFlight.getDepDate() + "\n" +
                            "Departure Time: " + curFlight.getDepTime() + "\n" +
                            "Arrival Date: " + curFlight.getArrDate() + "\n" +
                            "Arrival Time: " + curFlight.getArrTime() + "\n" +
                            "Ticket Type: " + ticketIn.getClassType() + "\n" +
                            "Ticket Quantity: " + ticketIn.getNumOfSeats() + "\n" +
                            "Total Cost: " + ticketIn.getTotalPrice() +
                            "\n\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing Electronic Ticket \n" + e);
        }
    }
}
