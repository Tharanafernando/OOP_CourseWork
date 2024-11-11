package OOP_CorseWork;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private static TicketPool ticketPool;
    private static String name;
    private static String NIC;
    private static int noOfBuyingTickets;

    public Consumer(TicketPool ticketPool, String name, String NIC) {
        this.ticketPool = ticketPool;
        this.name = name;
        this.NIC = NIC;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your name: ");
            name = scanner.nextLine();

            System.out.println("Enter your NIC: ");
            NIC = scanner.nextLine();

            System.out.println("Enter your no of buying tickets: ");
            noOfBuyingTickets = scanner.nextInt();


            ticketPool.removeTicket();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }







}
