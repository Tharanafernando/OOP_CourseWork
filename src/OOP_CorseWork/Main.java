package OOP_CorseWork;


import java.util.Scanner;

public class Main {
    private int total;
    private int max;
    private long rate;
    private long customerRate;
    private final Configuration configuration = new Configuration(max,total,rate,customerRate);


  //  private static Configuration configuration;
    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        main.takeInput();


    }


    public void takeInput(){
        Scanner sc = new Scanner(System.in);




        System.out.println("Input Total Number of Tickets:");
        total = sc.nextInt();
        configuration.setTotalNumberOfTickets(total);



        System.out.println("Input Max Ticket Capacity:");
        max = sc.nextInt();
        configuration.setMaximumTicketCapacity(max);





        System.out.println("Input Ticket Release Rate: ");
        rate = sc.nextLong();
        configuration.setTicketReleaseRate(rate);

        System.out.println("Input Customer Retrieval Rate: ");
         customerRate = sc.nextLong();
        configuration.setCustomerRetrievalRate(customerRate);




        System.out.println("Total number of tickets: "+configuration.getTotalNumberOfTickets());
        System.out.println("Max capacity is: "+configuration.getMaximumTicketCapacity());
        System.out.println("Ticket release rate is: "+configuration.getTicketReleaseRate());
        System.out.println("Customer retrieval rate is: "+configuration.getCustomerRetrievalRate());
        configuration.savetoTextFile();
        TicketPool ticketPool = new TicketPool(configuration);


        Vendor vendor = new Vendor(ticketPool);
        Consumer consumer = new Consumer(ticketPool);

        vendor.setConfiguration(configuration);
        consumer.setConfiguration(configuration);

        Thread vendorThread = new Thread(vendor);
        Thread consumerThread = new Thread(consumer);

        vendorThread.start();

        consumerThread.start();





    }


}
