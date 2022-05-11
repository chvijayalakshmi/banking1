package banking1;

import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many accounts want to open");
        int n=sc.nextInt();

        Transactions t[] = new Transactions[n];
        for(int i=0;i< t.length;i++) {
            t[i] = new Transactions();
            t[i].openAccount();
        }
        int option=0;
        do{

            System.out.println("Please select one option");
            System.out.println("1.Display all customer details"+"\t"+"2.Search an account by Customer id"+"\t"+"3.Deposit     4.Withdraw         5.Exit ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    for(int i=0;i<t.length;i++) {
                        t[i].showDetails();
                    }
                break;
                case 2:
                    System.out.println("Enter customer id to search:");
                    int no= sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < t.length; i++) {
                        found = t[i].search(no);
                        if (found) {
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("*******  Search failed! ********* Account does not exit");
                    }break;
                case 3:
                    System.out.println("Enter customer id ");
                    no=sc.nextInt();
                    found = false;
                    for(int i=0;i<t.length;i++) {
                        found=t[i].search(no);
                        if(found) {
                            t[i].deposit();
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("*******  Search failed! ********* Account does not exit");
                    }
                    break;
                case 4:
                    System.out.println("Enter CId");
                    no= sc.nextInt();
                    found =false;
                    for(int i =0;i<t.length;i++) {
                        found=t[i].search(no);
                        if(found) {
                            t[i].withdraw();
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("*******  Search failed! ********* Account does not exit");
                    }break;
                case 5:
                    System.out.println("****************Thank you*************");
                    break;
            }
        }while(option!=5);

    }
}
