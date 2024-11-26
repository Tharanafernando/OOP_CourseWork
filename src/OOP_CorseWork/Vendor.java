package OOP_CorseWork;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vendor implements Runnable {
    private String name;
    private String NIC;

    private final TicketPool ticketPool;
    private Configuration configuration;



    public Vendor(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }



    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public void run() {
       // configuration = new Configuration();

        if (configuration == null) {
            System.out.println("Configuration is null can not execute");
        }


        System.out.println("Vendor Thread is going to start....");

        for (int i = 1; i< configuration.getMaximumTicketCapacity();i++){
            ticketPool.addTicket("Ticket added: Ticket number "+i);


        }

        try {

            System.out.println("Vendor thread is going to add tickets");
            Thread.sleep(configuration.getTicketReleaseRate());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Vendor thread wakes up");



    }
}