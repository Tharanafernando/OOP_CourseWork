package OOP_CorseWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input Max Ticket Capacity:");
        int max = sc.nextInt();

        System.out.println("Input Total Number of Tickets:");
        int total = sc.nextInt();

        System.out.println("Input Ticket Release Rate: ");
        double rate = sc.nextDouble();

        System.out.println("Input Customer Retrival Rate: ");
        double customerRate = sc.nextDouble();


        Configuration configuration = new Configuration(max, total, rate, customerRate);
    }


}
