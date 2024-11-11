package OOP_CorseWork;

import java.util.Scanner;

public class TicketPool {

    private static Vendor vendor;
    private static Consumer consumer;
    private static int totalTickets;
    private static double ticketRate;
    private static double customerPrice;
    private static int maximumTicketCapacity;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Configuration configuration = new Configuration(totalTickets,ticketRate,customerPrice,maximumTicketCapacity);

        System.out.println("give no of tickets: ");
        totalTickets = sc.nextInt();
        configuration.setTotalNumberOfTickets(totalTickets);

        System.out.println("give ticket release rate: ");
        ticketRate = sc.nextDouble();
        configuration.setTicketReleaseRate(ticketRate);

        System.out.println("give customer retrieval price: ");
        customerPrice = sc.nextDouble();
        configuration.setMaximumTicketCapacity(maximumTicketCapacity);

        System.out.println("maximum ticket capacity: ");
        maximumTicketCapacity = sc.nextInt();
        configuration.setMaximumTicketCapacity(maximumTicketCapacity);









    }

    public synchronized static void removeTicket(){

    }

    public synchronized static void addTicket(){
        
    }
}
