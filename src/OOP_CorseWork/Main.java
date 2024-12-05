package OOP_CorseWork;


import java.util.Scanner;

public class Main {
    private int total;
    private int max;
    private int rate;
    private int customerRate;
    private Configuration configuration;


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

//        System.out.println("How many vendors use this system: ");
//        int numVendors = sc.nextInt();




        System.out.println("Input Total Number of Tickets:");
        total = sc.nextInt();
        configuration.setTotalNumberOfTickets(total);



        System.out.println("Input Max Ticket Capacity:");
        max = sc.nextInt();
        configuration.setMaximumTicketCapacity(max);





        System.out.println("Input Ticket Release Rate: ");
        rate = sc.nextInt();
        configuration.setTicketReleaseRate(rate);

        System.out.println("Input Customer Retrieval Rate: ");
        customerRate = sc.nextInt();
        configuration.setCustomerRetrievalRate(customerRate);






        configuration.savetoTextFile();
        TicketPool ticketPool = new TicketPool(configuration);




        Vendor[] vendor1 = new Vendor[10];

        for (int i = 1; i < vendor1.length; i++) {
            vendor1[i] = new Vendor(ticketPool, (int) configuration.getTicketReleaseRate(), configuration.getTotalNumberOfTickets());
            Thread vendorThread = new Thread(vendor1[i],"Vendor"+i);
            vendorThread.start();
        }


        Consumer[] consumer1 = new Consumer[10];
        for (int i = 1; i < consumer1.length; i++) {
            consumer1[i] = new Consumer(ticketPool,(int) configuration.getCustomerRetrievalRate(),configuration.getTotalNumberOfTickets());
            Thread consumerThread = new Thread(consumer1[i],"Customer "+i);
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
