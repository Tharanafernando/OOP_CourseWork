package OOP_CorseWork;


import java.util.Scanner;

public class Main {
    private static Configuration configuration;



    public static void main(String[] args) throws InterruptedException {
       // Configuration configuration = new Configuration();



        Scanner sc = new Scanner(System.in);

        System.out.println("Input Max Ticket Capacity:");
        int max = sc.nextInt();
       // configuration.setMaximumTicketCapacity(max);


        System.out.println("Input Total Number of Tickets:");
        int total = sc.nextInt();
       // configuration.setTotalNumberOfTickets(total);


        System.out.println("Input Ticket Release Rate: ");
        long rate = sc.nextLong();
       // configuration.setTicketReleaseRate(rate);

        System.out.println("Input Customer Retrieval Rate: ");
        long customerRate = sc.nextLong();
       // configuration.setCustomerRetrievalRate(customerRate);

        configuration = new Configuration(max, total, rate, customerRate);
        TicketPool ticketPool = new TicketPool(configuration);


        Vendor vendor = new Vendor(ticketPool);
        Consumer consumer = new Consumer(ticketPool);

        vendor.setConfiguration(configuration);
        consumer.setConfiguration(configuration);

        Thread vendorThread = new Thread(vendor);
        Thread consumerThread = new Thread(consumer);

        vendorThread.start();
        consumerThread.start();


        vendorThread.join();
        consumerThread.join();
    }


}
