package OOP_CorseWork;


import java.util.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


public class TicketPool {

    private Queue<Ticket> ticketQue;
    private static Configuration configuration;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Logger logger = Logger.getLogger(Vendor.class.getName());
    private int limit = 0;
    private final Main main;



    public TicketPool(Configuration configuration,Main main) {
        this.ticketQue = new LinkedList<>();
        TicketPool.configuration = configuration;
        this.main = main;

    }



    public void addTicket(Ticket ticket) {
        lock.lock();
        try{

            while (ticketQue.size()>= configuration.getMaximumTicketCapacity()){
                logger.info(">>> Ticket pool is full.");
                if (Thread.currentThread().isInterrupted()|| !main.isRunning){
                    System.out.println(Thread.currentThread().getName()+" is going to be exit");
                    return;

                } limit++;
                if (limit == configuration.getTotalNumberOfTickets()){
                    return;
                   // main.stopFunctioning();
                }

                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }


            // add ticket to the ticketQue
            ticketQue.add(ticket);
            System.out.println(Thread.currentThread().getName()+" Ticket added to the pool. Ticket pool size is: "+ticketQue.size());

            notEmpty.signalAll();


        }finally {
            lock.unlock();
        }
    }

    public void BuyTicket() {
        lock.lock();
        try{
            while (ticketQue.isEmpty()) {
                logger.info(">>> Ticket pool is empty.");
                if (Thread.currentThread().isInterrupted()|| !main.isRunning){
                    System.out.println(Thread.currentThread().getName()+" is going to be exit");
                    return;
                }
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;

                }

            }
            Ticket ticket1 = ticketQue.poll();
            System.out.println(Thread.currentThread().getName() + " removed ticket: " + ticket1);
            notFull.signalAll();



        }finally{
            lock.unlock();
        }









    }

}