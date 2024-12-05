package OOP_CorseWork;



public class Consumer implements Runnable {
    private final TicketPool ticketPool;
    private String name;
    private String NIC;
    private Configuration configuration;
    private final int customerRate;
    private final int quantity;


    public Consumer(TicketPool ticketPool,int customerRate,int quantity) {
        this.ticketPool = ticketPool;
        this.customerRate = customerRate;
        this.quantity = quantity;


    }


//    public void setConfiguration(Configuration configuration) {
//        this.configuration = configuration;
//    }

    @Override
    public void run() {
        //configuration = new Configuration();

//        if(configuration == null) {
//            System.out.println("No configuration found");
//        }


        System.out.println("Customer thread is going to start...");
        
        for (int i = 1; i <= quantity; i++) {
            ticketPool.removeTicket();
        }

        try {
            Thread.sleep(customerRate*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }







}
