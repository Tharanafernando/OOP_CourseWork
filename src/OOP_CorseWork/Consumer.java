package OOP_CorseWork;


import java.util.logging.Logger;

public class Consumer implements Runnable {
    private final TicketPool ticketPool;
    private String name;
    private String NIC;
    private Configuration configuration;
    private final  Logger logger = Logger.getLogger("Consumer");
    private int quantity;
    private int customerRate;



//    public Consumer(TicketPool ticketPool,Configuration configuration) {
//        this.ticketPool = ticketPool;
//        this.configuration = configuration;
//
//
//
//    }

    public Consumer(TicketPool ticketPool,int customerRate) {
        this.ticketPool = ticketPool;
        this.customerRate = customerRate;



    }




    @Override
    public void run() {



        System.out.println("Customer thread is going to start...");
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.removeTicket();
            try {
                Thread.sleep(customerRate*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
//        for (int i = 1; i <= configuration.getTotalNumberOfTickets(); i++) {
//            ticketPool.removeTicket();
//        }





    }







}
