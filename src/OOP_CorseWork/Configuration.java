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
            try{
                Scanner sc = new Scanner(System.in);
                if (total <= 0){
                    while (total<=0){
                        System.out.println("total tickets should be greater than 0 otherwise total tickets automatically will convert to 1");
                        total = 1;
                        System.out.println("Now total number of ticket is 1");
                        System.out.println("If you want enter again press Q");
                        String confirm = sc.nextLine();
                        if (confirm.equals("Q")){
                            System.out.print("Enter again: ");
                            totalNumberOfTickets = sc.nextInt();
                            System.out.println(" ");
                            if (totalNumberOfTickets <= 0){
                                total = 0;
                            }
                        }else{
                            break;
                        }

                    }




                }

                else{
                    this.totalNumberOfTickets = total;



                }

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }






    }

    public void setTicketReleaseRate(double ticket) {
        if (ticket <= 0){
            System.out.println("ticket should be greater than 0");
        }else {
            this.ticketReleaseRate = ticket;
        }

    }

    public void setCustomerRetrievalRate(double customer) {
        this.customerRetrievalRate = customer;
    }

    public void setMaximumTicketCapacity(int maximum) {

            if (maximum<=0){
                System.out.println("maximum number of tickets should be greater than 0");


            }
            else{
                this.maximumTicketCapacity = maximum;


            }








    }






}
