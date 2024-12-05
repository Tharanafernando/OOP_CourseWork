package OOP_CorseWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Configuration {
    private int totalNumberOfTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maximumTicketCapacity;

    public Configuration() {}

    public Configuration(int maximum,int total,int ticket, int customer) {
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
            checkPositive(1);
        }else{
            this.totalNumberOfTickets = total;
        }




    }

    public void setTicketReleaseRate(int ticket) {
        if (ticket<=0){
            checkPositive(2);
        }else{
            this.ticketReleaseRate = ticket;
        }





    }

    public void setCustomerRetrievalRate(int customer) {
        if (customer<=0){
            checkPositive(3);
        }else{
            this.customerRetrievalRate = customer;
        }

    }

    public void setMaximumTicketCapacity(int maximum) {
        if(maximum<=1){
            checkPositive(4);
        }else {
            this.maximumTicketCapacity = maximum;
        }

        if (maximum>totalNumberOfTickets){
            System.out.println("Maximum number of tickets should lower than total number of tickets");
            checkTotalAndMax();
        }else{
            this.maximumTicketCapacity = maximum;
        }

    }

    // check all parameter are greater than 0
    public void checkPositive(int num){
        Scanner input = new Scanner(System.in);
        switch(num){
            case 1:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    int tot;
                    tot = input.nextInt();
                    if(tot>0){
                        setTotalNumberOfTickets(tot);
                        break;
                    }

                }

                break;
            case 2:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    int rate;
                    rate = input.nextInt();
                    if(rate >0){
                        setTicketReleaseRate(rate);
                        break;
                    }

                }
                break;
            case 3:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    int customerRate;
                    customerRate = input.nextInt();
                    if(customerRate>0){
                        setCustomerRetrievalRate(customerRate);
                        break;
                    }

                }

                break;
            case 4:

                while (true){
                    System.out.println("Max capacity should be more than 1");
                    int max;
                    max = input.nextInt();
                    if(max>0){
                        setMaximumTicketCapacity(max);
                        break;
                    }


                }


                break;
        }



    }




    // Check the maximum capacity is lower than total tickets
    public void checkTotalAndMax(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Max capacity should be less than total tickets: ");
            int max;
            max = input.nextInt();
            if(max<totalNumberOfTickets){
                setMaximumTicketCapacity(max);
                break;
            }

        }

    }

    public void savetoTextFile(){



        try {
            FileWriter newFile = new FileWriter("NewFile.txt");

            newFile.write(
                    "Maximum Capacity :"+getMaximumTicketCapacity()+ " \n"+
                        "Total number of tickets: "+getTotalNumberOfTickets()+" \n"+
                        "Ticket release rate: "+getTicketReleaseRate()+"\n "+
                        "Customer retrieval rate: "+getCustomerRetrievalRate()
                         );
            newFile.close();
            System.out.println("Successfully write to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
