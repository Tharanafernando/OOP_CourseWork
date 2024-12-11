package OOP_CorseWork;




public class Consumer implements Runnable {
    private final TicketPool ticketPool;
    private int quantity;
    private int customerRate;
    private final Main main;



//    public Consumer(TicketPool ticketPool,Configuration configuration) {
//        this.ticketPool = ticketPool;
//        this.configuration = configuration;
//
//
//
//    }

    public Consumer(TicketPool ticketPool,int customerRate,int quantity,Main main) {
        this.ticketPool = ticketPool;
        this.customerRate = customerRate;
        this.quantity = quantity;
        this.main = main;

    }




    @Override
    public void run() {
        System.out.println("Customer thread is going to start...");
        while (main.isRunning){
            try {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + ": Waiting for customer thread to finish...");
                    return;
                }

                for (int i = 0; i < quantity; i++) {
                    ticketPool.BuyTicket();
                    Thread.sleep(customerRate*1000L);
                }

            }

              catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": Customer thread interrupted");
                Thread.currentThread().interrupt();
                break;
              }


        }

        






    }







}



