package OOP_CorseWork;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicketPool {

    private LinkedList<String> ticket;
    private static Configuration configuration;
    private Vendor vendor;
    private final ReentrantLock lock = new ReentrantLock();


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
        lock.lock();
        try {
            this.ticket.add(ticketAdingString);
            System.out.println(ticketAdingString+" added to the pool");
            notifyAll();

        }finally {
            lock.unlock();
        }

//        try{
//
//            this.ticket.add(ticketAdingString);
//            System.out.println(ticketAdingString+" added to the pool");
//            notifyAll();
//        }catch(Exception e){
//            lock.unlock();
//        }




    }

    public synchronized void removeTicket(String ticketBuyingString) {

        while (ticket.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        lock.lock();
        try {
            this.ticket.remove(ticketBuyingString);
            System.out.println(ticketBuyingString+" removed from the pool");
            notifyAll();
        }finally {
            lock.unlock();
        }

//        try {
//
//            this.ticket.remove(ticketBuyingString);
//            System.out.println(ticketBuyingString+" removed from the pool");
//            notifyAll();
//        }catch(Exception e){
//            lock.unlock();
//        }




    }

}