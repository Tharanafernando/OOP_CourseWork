package OOP_CorseWork;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vendor implements Runnable {
    private String name;
    private String NIC;
    private static int noOfTickets;
    private TicketPool ticketPool;

    public Vendor(String name, String NIC,int noOfTickets) {
        this.name = name;
        this.NIC = NIC;
        this.noOfTickets = noOfTickets;


    }

        @Override
    public void run() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = input.nextLine();
        System.out.println("Enter your NIC: ");
        NIC = input.nextLine();
        System.out.println("No of tickets to release: ");
        noOfTickets = input.nextInt();

        Configuration c1 = new Configuration(noOfTickets);
        c1.setTotalNumberOfTickets(noOfTickets);

        try {
            ticketPool = new TicketPool();
            ticketPool.addTicket();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }








}