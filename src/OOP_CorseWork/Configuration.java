package OOP_CorseWork;

import java.util.Scanner;

public class Configuration {
    private int totalNumberOfTickets;
    private long ticketReleaseRate;
    private long customerRetrievalRate;
    private int maximumTicketCapacity;

    public Configuration(int maximum,int total,long ticket, long customer) {
        this.totalNumberOfTickets = total;
        this.ticketReleaseRate = ticket;
        this.customerRetrievalRate = customer;
        this.maximumTicketCapacity = maximum;
    }

    public Configuration(){
        this.totalNumberOfTickets = 0;
        this.ticketReleaseRate = 0;
        this.customerRetrievalRate = 0;
        this.maximumTicketCapacity = 0;
    }



    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public long getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public long getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setTotalNumberOfTickets(int total) {

        if (total<=0){
            System.out.println("Please enter a positive number or greater than 0");

        }else{
            this.totalNumberOfTickets = total;


        }


    }

    public void setTicketReleaseRate(long ticket) {
        if (ticket<=0){
            System.out.println("Please enter a positive number or greater than 0");
        }else{
            this.ticketReleaseRate = ticket;
        }
//        if (this.ticketReleaseRate<=0){
//            do {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("Please enter a number greater than 0");
//                this.ticketReleaseRate = sc.nextInt();
//
//            } while (this.ticketReleaseRate <= 0);
//
//        }else {
//            this.ticketReleaseRate = ticket;
//        }

    }

    public void setCustomerRetrievalRate(long customer) {
        if (customer<=0){
            System.out.println("Please enter a positive number or greater than 0");
        }else{
            this.customerRetrievalRate = customer;
        }
//        if (customer<=0){
//            do {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("Please enter a number greater than 0");
//                this.customerRetrievalRate = sc.nextInt();
//
//            } while (this.customerRetrievalRate <= 0);
//
//        }  else {
//            this.customerRetrievalRate = customer;
//        }
    }

    public void setMaximumTicketCapacity(int maximum) {

        if (maximum<=0){
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Please enter a number greater than 0");
                this.maximumTicketCapacity= sc.nextInt();
                maximum = this.maximumTicketCapacity;
                if (maximum<=0){
                    continue;
                }break;


            }

        }
        this.maximumTicketCapacity = maximum;

    }






}
