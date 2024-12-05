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
    private final int releaseRate;
    private final int totalTickets;



    public Vendor(TicketPool ticketPool,int rate,int totalTickets) {
        this.ticketPool = ticketPool;
        this.releaseRate = rate;
        this.totalTickets = totalTickets;


    }



//    public void setConfiguration(Configuration configuration) {
//        this.configuration = configuration;
//    }


    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
       // configuration = new Configuration();
//        ticket = new Ticket(0," ",0);

//        if (configuration == null) {
//            System.out.println("Configuration is null can not execute");
//        }


        System.out.println("Vendor Thread is going to start....");

        System.out.println("Event name");
        String eventName = input.next();

        System.out.println("Ticket Price");
        int price = input.nextInt();

        for (int i = 1; i<= totalTickets;i++){
            ticket = new Ticket(i,eventName,price);
            ticketPool.addTicket(ticket);
        }

        try {
            Thread.sleep(releaseRate*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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



