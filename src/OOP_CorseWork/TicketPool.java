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

        System.out.println(configuration.getMaximumTicketCapacity());




        System.out.println("Enter number of tickets: ");
        int noOfTickets = sc.nextInt();
        configuration.setTotalNumberOfTickets(noOfTickets);






        vendor = new Vendor(0);

        try{
            Thread v1 = new Thread(vendor);
            if (v1.isInterrupted()){
                System.out.println("Thread is interrupted");
            }

            v1.start();

            v1.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter customer retrieval rate: ");
        double customerRetrievalRate = sc.nextDouble();
        configuration.setCustomerRetrievalRate(customerRetrievalRate);

        configuration = new Configuration(configuration.getMaximumTicketCapacity(), configuration.getTotalNumberOfTickets(), vendor.getReleaseRate(), configuration.getCustomerRetrievalRate());


        System.out.println("Maximum capacity: " + configuration.getMaximumTicketCapacity());
        System.out.println("Number of tickets: " + configuration.getTotalNumberOfTickets());
        System.out.println("Release Rate: "+configuration.getTicketReleaseRate());
        System.out.println("Customer retrieval rate: " + configuration.getCustomerRetrievalRate());


    }



    public synchronized static void removeTicket(){

    }

    public synchronized void addTicket(){

        System.out.println("ticket added successfully");

//        for (int i = 0; i< configuration.getTotalNumberOfTickets();i++){
//            System.out.println(i+")"+" ticket added successfully");
//        }



    }

}