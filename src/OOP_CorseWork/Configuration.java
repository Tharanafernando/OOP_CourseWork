package OOP_CorseWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            checkPositive(1);
        }else{
            this.totalNumberOfTickets = total;
        }




    }

    public void setTicketReleaseRate(long ticket) {
        if (ticket<=0){
            checkPositive(2);
        }else{
            this.ticketReleaseRate = ticket;
        }





    }

    public void setCustomerRetrievalRate(long customer) {
        if (customer<=0){
            checkPositive(3);
        }else{
            this.customerRetrievalRate = customer;
        }

    }

    public void setMaximumTicketCapacity(int maximum) {
        if(maximum<=0){
            checkPositive(4);
        }else {
            this.maximumTicketCapacity = maximum;
        }

//        if (maximum>totalNumberOfTickets){
//            System.out.println("Maximum number of tickets should lower than total number of tickets");
//        }else{
//            this.maximumTicketCapacity = maximum;
//        }

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
                        setTotalNumberOfTickets(tot);
                        break;
                    }

                }

                break;
            case 2:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    long rate;
                    rate = input.nextLong();
                    if(rate >0){
                        setTicketReleaseRate(rate);
                        break;
                    }

                }
                break;
            case 3:
                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
                    long customerRate;
                    customerRate = input.nextInt();
                    if(customerRate>0){
                        setCustomerRetrievalRate(customerRate);
                        break;
                    }

                }

                break;
            case 4:

                while (true){
                    System.out.println("Please enter a positive number or greater than 0");
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

    public void savetoTextFile(){
        File myfile = new File("NewFile.txt");
        try {
            if(myfile.createNewFile()){
                System.out.println("File Created");
            }else{
                System.out.println("File Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter newFile = new FileWriter("NewFile.txt");

            newFile.write(
                    "Maximum Capacity :"+getMaximumTicketCapacity()+ " "+
                        "Total number of tickets: "+getTotalNumberOfTickets()+" "+
                        "Ticket release rate: "+getTicketReleaseRate()+" "+
                        "Customer retrieval rate: "+getTotalNumberOfTickets()
                         );
            newFile.close();
            System.out.println("Successfully write to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
