package OOP_CorseWork;

import java.util.Scanner;
import java.util.logging.Logger;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private Ticket ticket;
    private int total;
    private int rate;
    private final double price;
    private String eventName;
    private final Main main;
    private int ticketCount = 0;




    public Vendor(TicketPool ticketPool,int total,int rate,double price,String eventName,Main main) {
        this.ticketPool = ticketPool;
        this.total = total;
        this.rate = rate;
        this.price = price;
        this.eventName = eventName;
        this.main = main;


    }




    @Override
    public void run() {

        System.out.println("Vendor Thread is going to start....");


        while (main.isRunning && ticketCount < total) {
            try {

                ticketCount++;
                ticket = new Ticket(ticketCount,eventName,price);

                ticketPool.addTicket(ticket);
                Thread.sleep(rate*1000L);

            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
                Thread.currentThread().interrupt();
                return;
            }

        }



    }





}





