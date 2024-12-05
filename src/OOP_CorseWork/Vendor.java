package OOP_CorseWork;

import java.util.Scanner;
import java.util.logging.Logger;


public class Vendor implements Runnable {
    private String name;
    private String NIC;

    private final TicketPool ticketPool;
    private Configuration configuration;
    private final Logger logger = Logger.getLogger(Vendor.class.getName());
    private Ticket ticket;
    private int total;
    private int rate;
    private final double price;
    private String eventName;




//    public Vendor(TicketPool ticketPool,Configuration configuration) {
//        this.ticketPool = ticketPool;
//        this.configuration = configuration;
//
//    }

    public Vendor(TicketPool ticketPool,int total,int rate,double price,String eventName) {
        this.ticketPool = ticketPool;
        this.total = total;
        this.rate = rate;
        this.price = price;
        this.eventName = eventName;

    }








    @Override
    public void run() {
        Scanner input = new Scanner(System.in);



        System.out.println("Vendor Thread is going to start....");

//        System.out.println("Event name");
//        String eventName = input.next();
//
//        System.out.println("Ticket Price");
//        int price = input.nextInt();

        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 1; i<= total;i++){
                ticket = new Ticket(i,eventName,price);
                ticketPool.addTicket(ticket);
            }

            try {
                Thread.sleep(rate*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }






    }





}

//            int tot = 1;
//            do  {
//                ticket.setTicketID(tot);
//                ticket.setTicketName(eventName);
//                ticket.setTicketPrice(price);
//
//                ticketPool.addTicket(ticket);
//
//
//                if (tot == configuration.getMaximumTicketCapacity()){
//                    tot = 1;
//                    try {
//                        Thread.sleep(configuration.getTicketReleaseRate()*1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//
//                ++tot;
//            }while (tot == configuration.getMaximumTicketCapacity());




//            if (i==configuration.getMaximumTicketCapacity()){
//                try {
//                    Thread.sleep(configuration.getTicketReleaseRate());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }



