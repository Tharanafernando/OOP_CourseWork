package OOP_CorseWork;

import java.util.LinkedList;
import java.util.Scanner;

public class TicketPool {

    private static Vendor vendor;
    private static Consumer consumer;
    private static Configuration configuration;

   // private static Configuration configuration;
    private static LinkedList<Ticket> ticketPool;



    public static void main(String[] args) {
        configuration = new Configuration(0,0,0,0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter max capacity: ");
        int maxCapacity = sc.nextInt();
        configuration.setMaximumTicketCapacity(maxCapacity);


        System.out.println("Enter number of tickets: ");
        int noOfTickets = sc.nextInt();
        configuration.setTotalNumberOfTickets(noOfTickets);


        vendor = new Vendor();

        try{
            Thread v1 = new Thread(vendor);

            v1.start();
            v1.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter customer retrieval rate: ");
        double customerRetrievalRate = sc.nextDouble();
        configuration = new Configuration(maxCapacity,noOfTickets,0,customerRetrievalRate);


    }



    public synchronized static void removeTicket(){

    }

    public synchronized void addTicket(){
        System.out.println("ticket added successfully");



    }

}