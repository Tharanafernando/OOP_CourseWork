package OOP_CorseWork;

public class Configuration {
    private int totalNumberOfTickets;
    private double ticketReleaseRate;
    private double customerRetrievalRate;
    private int maximumTicketCapacity;

    public Configuration(int total,double ticket, double customer, int maximum) {
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
        this.totalNumberOfTickets = total;
    }

    public void setTicketReleaseRate(double ticket) {
        this.ticketReleaseRate = ticket;
    }

    public void setCustomerRetrievalRate(double customer) {
        this.customerRetrievalRate = customer;
    }

    public void setMaximumTicketCapacity(int maximum) {
        this.maximumTicketCapacity = maximum;
    }


}
