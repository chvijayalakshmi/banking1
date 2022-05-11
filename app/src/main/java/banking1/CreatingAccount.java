package banking1;

import java.util.Scanner;

public class CreatingAccount {
    private String customer_name;
    private int customerId;
    private double balance;
    public String getCustomer_name(){
        return customer_name;
    }
    public void setCustomer_name(String cname){
        this.customer_name=cname;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int cid){
        this.customerId=cid;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
public void create_account(){
    Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String n=sc.next();
    System.out.println("Enter your ID:");
    int i=sc.nextInt();
    System.out.println("Enter amount to deposit:");
    double a = sc.nextDouble();
    System.out.println("Customer name: "+n);
    System.out.println("Customer ID is: "+i);
    System.out.println("Balance is: "+a);


}
}
