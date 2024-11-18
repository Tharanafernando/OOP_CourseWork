package OOP_CorseWork;

public class Ticket {
    private int ticketNo;
    private String ticketName;
    private double ticketPrice;


    public Ticket(int ticketNo,String ticketName, double ticketPrice) {
        this.ticketNo = ticketNo;
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String getTicketName() {
        return ticketName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
