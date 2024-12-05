package OOP_CorseWork;


import java.util.Scanner;

public class Main {
//    private int total;
//    private int max;
//    private int rate;
//    private int customerRate;
//    private Configuration configuration = new Configuration(max,total,rate,customerRate);
    private final Configuration configuration = new Configuration();


  //  private static Configuration configuration;
    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("To start enter 'S' ");
        String option = scanner.nextLine(); // start the program
        if (option.equalsIgnoreCase("S")) {
            main.takeInput();
        }



    }


    public void takeInput(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Total Number of Tickets:");
        int totalTickets = sc.nextInt();
        configuration.setTotalNumberOfTickets(totalTickets);
        totalTickets = configuration.getTotalNumberOfTickets();


        System.out.println("Input Max Ticket Capacity:");
        int max = sc.nextInt();
        configuration.setMaximumTicketCapacity(max);
        max = configuration.getMaximumTicketCapacity();





        System.out.println("Input Ticket Release Rate: ");
        int rate = sc.nextInt();
        configuration.setTicketReleaseRate(rate);
        rate = (int) configuration.getTicketReleaseRate();

        System.out.println("Input Customer Retrieval Rate: ");
        int customerRate = sc.nextInt();
        configuration.setCustomerRetrievalRate(customerRate);
        customerRate = (int) configuration.getCustomerRetrievalRate();


       // configuration = new Configuration(max,total,rate,customerRate);

        System.out.println("Event name: ");
        String eventName = sc.nextLine();

        System.out.println("Ticket price: ");
        double ticketPrice = sc.nextDouble();



        configuration.savetoTextFile();
        TicketPool ticketPool = new TicketPool(configuration);




        Vendor[] vendor = new Vendor[10];
        for (int i = 0; i < vendor.length; i++) {
           // vendor1[i] = new Vendor(ticketPool, (int) configuration.getTicketReleaseRate(), configuration.getTotalNumberOfTickets());
            vendor[i] = new Vendor(ticketPool,totalTickets,rate,ticketPrice,eventName);
           // vendor1[i].setConfiguration(configuration);
            Thread vendorThread = new Thread(vendor[i],"Vendor"+i);
            vendorThread.start();
        }


        Consumer[] consumer = new Consumer[10];
        for (int i = 0; i < consumer.length; i++) {
            consumer[i] = new Consumer(ticketPool,customerRate);
           // consumer1[i].setConfiguration(configuration);
            Thread consumerThread = new Thread(consumer[i],"Customer "+i);
            consumerThread.start();

        }











    }


}


//        Vendor vendor = new Vendor(ticketPool);
//        Consumer consumer = new Consumer(ticketPool);

//        vendor.setConfiguration(configuration);
//        consumer.setConfiguration(configuration);

//        Thread venThread  = new Thread(vendor);
//        venThread.start();

//        Thread consumerThread = new Thread(consumer);
//        consumerThread.start();





//        Thread consumerThread = new Thread(consumer);




//        consumerThread.start();
