package OOP_CorseWork;

public class Configuration {
    private int totalNumberOfTickets;
    private double ticketReleaseRate;
    private double customerRetrievalRate;
    private int maximumTicketCapacity;

    public Configuration(double ticket, double customer, int maximum) {
        this.ticketReleaseRate = ticket;
        this.customerRetrievalRate = customer;
        this.maximumTicketCapacity = maximum;
    }

    public Configuration(int total){
        this.totalNumberOfTickets = total;
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
//        if (totalNumberOfTickets > 0){
//            this.totalNumberOfTickets = total;
//        }else {
//            System.out.println("The total number of tickets is less than 0");
//        }
        this.totalNumberOfTickets = total;
    }

    public void setTicketReleaseRate(double ticket) {
        this.ticketReleaseRate = ticket;
//        if (ticketReleaseRate > 0){
//            this.ticketReleaseRate = ticket;
//        }
//        else {
//            System.out.println("The ticket release rate is less than 0");
//        }
    }

    public void setCustomerRetrievalRate(double customer) {
        this.customerRetrievalRate = customer;
//        if (customerRetrievalRate > 0){
//            this.customerRetrievalRate = customer;
//        }else {
//            System.out.println("The customer retrieval rate is less than 0");
//        }
    }

    public void setMaximumTicketCapacity(int maximum) {
        this.maximumTicketCapacity = maximum;
//        if (maximumTicketCapacity > 0){
//            this.maximumTicketCapacity = maximum;
//        }else {
//            System.out.println("The maximum ticket capacity is less than 0");
//        }
    }


}
