package OOP_CorseWork;


import java.util.LinkedList;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


public class TicketPool {

    private Queue<Ticket> ticketQue;
    private static Configuration configuration;
    private Vendor vendor;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Logger logger = Logger.getLogger(Vendor.class.getName());


    public TicketPool(Configuration configuration) {
        this.ticketQue = new LinkedList<>();
        TicketPool.configuration = configuration;
    }



    public void addTicket(Ticket ticket) {
        lock.lock();
        try{
            while (ticketQue.size()>= configuration.getMaximumTicketCapacity()){

                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            this.ticketQue.add(ticket);
            System.out.println(Thread.currentThread().getName()+" Ticket added to the pool. Ticket pool size is: "+ticketQue.size());

            notEmpty.signalAll();


        }finally {
            lock.unlock();
        }
    }

    public void removeTicket() {
        lock.lock();
        try{
            while (ticketQue.isEmpty()) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;

                }

            }
            Ticket ticket1 = ticketQue.poll();
            notFull.signalAll();
            System.out.println(Thread.currentThread().getName()+" bought tickets. Ticket pool size is "+ticketQue.size()+" "+ticket1.toString());


        }finally{
            lock.unlock();
        }









    }

}