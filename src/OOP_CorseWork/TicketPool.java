package OOP_CorseWork;

import java.util.Scanner;

public class TicketPool {

    private static Vendor vendor;
    private static Consumer consumer;
   // private static int totalNumberOfTickets;
    private static double ticketRate;
    private static double customerPrice;
    private static int maximumTicketCapacity;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Configuration configuration = new Configuration(ticketRate,customerPrice,maximumTicketCapacity);
        try{
            System.out.println("maximum ticket capacity: ");
            maximumTicketCapacity = sc.nextInt();
            configuration.setMaximumTicketCapacity(maximumTicketCapacity);

            System.out.println("give no of tickets: ");
            vendor.run();
//            totalNumberOfTickets = sc.nextInt();
//            if (totalNumberOfTickets < configuration.getMaximumTicketCapacity()) {
//                addTicket();
//            }


            System.out.println("give ticket release rate: ");
            ticketRate = sc.nextDouble();
            configuration.setTicketReleaseRate(ticketRate);

            System.out.println("give customer retrieval price: ");
            customerPrice = sc.nextDouble();
            configuration.setCustomerRetrievalRate(customerPrice);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized static void removeTicket(){
        

    }

    public synchronized static void addTicket(){
//        for (int i = 0; i < totalNumberOfTickets; i++) {
//            System.out.println("Ticket has been created");
//        }
    }
}
