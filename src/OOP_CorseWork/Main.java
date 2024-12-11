package OOP_CorseWork;


import java.util.Scanner;

public class Main {

    private final Configuration configuration = new Configuration();
    volatile boolean isRunning = true;
    private Thread[] vendorThread;
    private Thread[] consumerThread;


  //  private static Configuration configuration;
    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("To start enter 'S' ");
        String option = scanner.nextLine(); // start the program
        if (option.equalsIgnoreCase("S")) {
            main.takeInput();
        }else if (option.equalsIgnoreCase("E")) {
            scanner.close();
        }



    }


    public void takeInput() throws InterruptedException {
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
        String eventName = sc.next();

        System.out.println("Ticket price: ");
        double ticketPrice = sc.nextDouble();



        configuration.savetoTextFile();
        TicketPool ticketPool = new TicketPool(configuration,this);




        Vendor[] vendor = new Vendor[3];
        vendorThread = new Thread[3];
        for (int i = 0; i < vendor.length; i++) {
            vendor[i] = new Vendor(ticketPool,totalTickets,rate,ticketPrice,eventName,this);
            vendorThread[i] = new Thread(vendor[i],"Vendor"+i);


            vendorThread[i].start();
        }


        Consumer[] consumer = new Consumer[4];
        consumerThread = new Thread[4];
        for (int i = 0; i < consumer.length; i++) {
            consumer[i] = new Consumer(ticketPool,customerRate,3,this);
           // consumer1[i].setConfiguration(configuration);
            consumerThread[i] = new Thread(consumer[i],"Consumer"+i);

            consumerThread[i].start();

        }

        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            while (isRunning) {
                System.out.println("Press E to exit.");
                String option2 = scanner.nextLine().trim();
                if (option2.equalsIgnoreCase("E")) {
                    stopFunctioning();
                    System.out.println("Exit Application");
                    break;
                }else {
                    System.out.println("Invalid input");

                }
            }
            scanner.close();

        }).start();





    }

    public boolean stopFunctioning(){
        isRunning = false;
        for (Thread venThread : vendorThread) {
            if (venThread != null && venThread.isAlive()) {
                venThread.interrupt();
            }

        }

        for (Thread customerThread : consumerThread) {
            if (customerThread != null && customerThread.isAlive()) {
                customerThread.interrupt();
            }

        }


        return isRunning;
    }




}



