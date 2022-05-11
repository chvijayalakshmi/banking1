package se.bankDB;

import banking1.Transactions;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static junit.framework.TestCase.assertEquals;

public class BankingTransactions {

    private static final String connectionStringIM = "jdbc:h2:mem:";
    private static final String connectionStringFile = "jdbc:h2:¨./banking1";
    @Test
    public void createTable() throws Exception {
        var con = DriverManager.getConnection(connectionStringIM);
        var stmt = con.createStatement();
        stmt.execute("create table  bank_details(id int, name varchar(200), balance double,primary key(id))");
        addAccount(101, "vijaya", 200, con);
        addAccount(102,"Lakshmi", 100, con);

    }
    private void addAccount(int id, String name, double balance, Connection con) throws Exception {
        var stmt = con.createStatement();
        var prepStmt = con.prepareStatement("insert into bank_details(id, name, balance) values(?,?,?)");
        prepStmt.setInt(1, id);
        prepStmt.setString(2, name);
        prepStmt.setDouble(3, balance);
        prepStmt.execute();
    }
    @Test
    private void shouldRetrieveData() throws Exception {
    var con = DriverManager.getConnection(connectionStringIM);
    var stmt = con.createStatement();
    var rs = stmt.executeQuery("select * from bank_details");
        while(rs.next()){
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getDouble(3)+"\t");
        }
}
@Test
    void shouldDepositAmountToTheExistingAccount(){
        var D= new Transactions();
        double balance=1000;
        double amount = 150;
        assertEquals(1150,  D.deposit());
}
}
