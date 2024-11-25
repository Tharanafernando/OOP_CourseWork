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
        if(total<=0){
            System.out.println("Total number of tickets must be greater than 0");
            checkPositive(1);
        }else{
            this.totalNumberOfTickets = total;
        }




    }

    public void setTicketReleaseRate(long ticket) {
        if (ticket<=0){
            System.out.println("INVALID NUMBER");
            checkPositive(2);
        }else{
            this.ticketReleaseRate = ticket;
        }





    }

    public void setCustomerRetrievalRate(long customer) {
        if (customer<=0){
            System.out.println("Please enter a positive number or greater than 0");
            checkPositive(3);
        }else{
            this.customerRetrievalRate = customer;
        }

    }

    public void setMaximumTicketCapacity(int maximum) {
        if(maximum<=0){
            System.out.println("Please enter a positive number or greater than 0");
            checkPositive(4);
        }else {
            this.maximumTicketCapacity = maximum;
        }

        if (maximum>totalNumberOfTickets){
            System.out.println("Maximum number of tickets should lower than total number of tickets");
        }else{
            this.maximumTicketCapacity = maximum;
        }

    }


    public void checkPositive(int num){
        Scanner input = new Scanner(System.in);
        switch(num){
            case 1:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    int tot;
                    tot = input.nextInt();
                    if(tot>0){
                        this.totalNumberOfTickets = tot;
                        break;
                    }

                }

                break;
            case 2:
                if(ticketReleaseRate<=0){
                    System.out.println("Please enter a positive number or greater than 0");
                }
                break;
            case 3:
                if(customerRetrievalRate<=0){
                    System.out.println("Please enter a positive number or greater than 0");
                }
                break;
            case 4:
                if(maximumTicketCapacity<=0){
                    System.out.println("Please enter a positive number or greater than 0");
                }
                break;
        }



    }






}
