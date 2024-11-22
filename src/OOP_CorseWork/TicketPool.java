package OOP_CorseWork;


import java.util.LinkedList;
import java.util.List;

public class TicketPool {

    private LinkedList<String> ticket;
    private static Configuration configuration;
    private Vendor vendor;

    public TicketPool(Configuration configuration) {
        ticket = new LinkedList<>();
        this.configuration = configuration;
    }



    public synchronized void addTicket(String ticketAdingString) {

        while (ticket.size()>= configuration.getTotalNumberOfTickets()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.ticket.add(ticketAdingString);
        System.out.println(ticketAdingString+" added to the pool");
        notifyAll();


    }

    public synchronized void removeTicket(String ticketBuyingString) {
        while (ticket.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        this.ticket.remove(ticketBuyingString);
        System.out.println(ticketBuyingString+" removed from the pool");
        notifyAll();

    }

}