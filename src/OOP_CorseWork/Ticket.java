package OOP_CorseWork;

public class Ticket {
    private int ticketNo;
    private String tikcetName;
    private double ticketPrice;


    public Ticket(int ticketNo,String tikcetName, double ticketPrice) {
        this.ticketNo = ticketNo;
        this.tikcetName = tikcetName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String getTikcetName() {
        return tikcetName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public void setTikcetName(String tikcetName) {
        this.tikcetName = tikcetName;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
