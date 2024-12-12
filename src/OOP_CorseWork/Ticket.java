package OOP_CorseWork;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ticket {
    private int ticketID;
    private String ticketName;
    private double ticketPrice;
    private boolean ticketStatus = true;
    private Logger logger = Logger.getLogger(Ticket.class.getName());

    public Ticket() {}

    public Ticket(int ticketID, String ticketName, double ticketPrice) {
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
    }

    public boolean isTicketAdded() {
        return ticketStatus;
    }

    public void addTicket() {
        ticketStatus = false;


    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }



    public String toString(){

        return
                "Ticket name: "+getTicketName()+"\n"
                +"Ticket ID: "+getTicketID()+"\n"
                +"Ticket Price: "+getTicketPrice();
    }
}
