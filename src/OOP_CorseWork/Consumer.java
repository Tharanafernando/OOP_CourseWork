package OOP_CorseWork;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private final TicketPool ticketPool;
    private String name;
    private String NIC;
    private Configuration configuration;
    private Lock lock = new ReentrantLock();

    public Consumer(TicketPool ticketPool) {
        this.ticketPool = ticketPool;



    }


    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void run() {
        //configuration = new Configuration();

        if(configuration == null) {
            System.out.println("No configuration found");
        }


        System.out.println("Customer thread is going to start...");
        
        for (int i = 1; i < configuration.getMaximumTicketCapacity(); i++) {
            ticketPool.removeTicket("Ticket bought: Ticket number "+i);


        }

        try {
            System.out.println("Customer waiting for tickets");
            Thread.sleep(configuration.getCustomerRetrievalRate());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }







}
