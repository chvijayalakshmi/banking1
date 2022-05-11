package banking1;
import java.util.Scanner;

public class Transactions {
    private static final String connectionStringIM = "jdbc:h2:mem:";
    private static final String connectionStringFile = "jdbc:h2:¨./banking1";
    private String name;
    private int id;
    private static double balance;
static Scanner sc=new Scanner(System.in);
    public  void openAccount() {
        System.out.print("Enter Customer Id:");
        id =sc.nextInt();
        System.out.print("Enter Customer Name:");
        name =sc.next();
        System.out.print("Enter Account Balance:");
        balance=sc.nextDouble();
    }
    public void showDetails() {
        System.out.println("Name of account holder: "+ name);
        System.out.println(" account no is: "+ id);
        System.out.println(" account Balance is: "+balance);
    }

    public boolean search(int cno) {
       // System.out.println("Enter accounts Customer id to deposit:");
        //int i = sc.nextInt();
        if (id ==cno) {
            showDetails();
            return true;
        } return false;
    }

    public static int deposit() {
        System.out.println("Enter amount to deposit:");
        int amount = sc.nextInt();
        balance = balance + amount;
        System.out.println("Account balance after deposit is:"+balance);
        return 0;
    }
    public void withdraw() {
        System.out.println("Enter account no to withdraw:");
        double amount = sc.nextInt();
            if (balance >= amount) {
                balance=balance-amount;
                System.out.println("Balance after withdraw:"+balance);
            }
            else {
                System.out.println("Your balance is less than" +amount + "please enter valid amount");
            }
          }

}
