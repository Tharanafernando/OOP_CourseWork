package OOP_CorseWork;


import java.util.LinkedList;
import java.util.Scanner;

public class Vendor implements Runnable {
    private String name;
    private String NIC;
    private double releaseRate;
    private TicketPool ticketPool;
    private Configuration configuration;
    private static LinkedList<Ticket> ticketManagement;

    public Vendor(double releaseRate){
        this.releaseRate = releaseRate;

    }


    @Override
    public void run() {
        System.out.println("Thread Started");
        System.out.println(" ");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = input.nextLine();
        System.out.println("Enter your NIC: ");
        NIC = input.nextLine();

        System.out.println("Enter ticket release rate: ");
        releaseRate = input.nextDouble();


        configuration = new Configuration(0,0,releaseRate,0);
        configuration.setTicketReleaseRate(releaseRate);






        try {
            ticketPool = new TicketPool();

            ticketPool.addTicket();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            throw new RuntimeException(e);
        }

    }

    public double getReleaseRate() {
        return releaseRate;
    }


}