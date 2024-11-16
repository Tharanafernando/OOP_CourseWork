package OOP_CorseWork;

import java.util.Scanner;

public class Configuration {
    private int totalNumberOfTickets;
    private double ticketReleaseRate;
    private double customerRetrievalRate;
    private int maximumTicketCapacity;

    public Configuration(int maximum,int total,double ticket, double customer) {
        this.totalNumberOfTickets = total;
        this.ticketReleaseRate = ticket;
        this.customerRetrievalRate = customer;
        this.maximumTicketCapacity = maximum;
    }







    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public double getTicketReleaseRate(){
        return ticketReleaseRate;
    }

    public double getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setTotalNumberOfTickets(int total) {
        if (this.totalNumberOfTickets<=0){
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter a number greater than 0");
                this.totalNumberOfTickets = sc.nextInt();

            } while (this.totalNumberOfTickets <= 0);

        }else {
            this.totalNumberOfTickets = total;
        }

    }

    public void setTicketReleaseRate(double ticket) {
        if (this.ticketReleaseRate<=0){
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter a number greater than 0");
                this.ticketReleaseRate = sc.nextInt();

            } while (this.ticketReleaseRate <= 0);

        }else {
            this.ticketReleaseRate = ticket;
        }

    }

    public void setCustomerRetrievalRate(double customer) {
        if (this.customerRetrievalRate<=0){
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter a number greater than 0");
                this.customerRetrievalRate = sc.nextInt();

            } while (this.customerRetrievalRate <= 0);

        }else {
            this.customerRetrievalRate = customer;
        }
    }

    public void setMaximumTicketCapacity(int maximum) {

        if (this.maximumTicketCapacity<=0){
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter a number greater than 0");
                this.maximumTicketCapacity = sc.nextInt();

            } while (this.maximumTicketCapacity <= 0);

        }else {
            this.maximumTicketCapacity = maximum;
        }








    }






}
