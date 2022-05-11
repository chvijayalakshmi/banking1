package se.bankDB;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankDB {
    private static final String connectionStringIM = "jdbc:h2:mem:";
    private static final String connectionStringFile = "jdbc:h2:¨./banking";

    @Test
    public void createTable() throws Exception{
        System.out.println(System.getProperty("user.dir"));//fetches the directory or path of the workspace for the current project
        var con = DriverManager.getConnection(connectionStringIM);
        var stmt = con.createStatement();


        stmt.execute("create table  bank_details(id int, name varchar(200), balance double,primary key(id))");
        addAccount(105,"vijaya", 2000.0, con);
        addAccount(102,"lakshmi",1000, con);

        //stmt.execute("insert into bank_details(id, name, amount) values(1101, 'vij')");
        //stmt.execute("insert into bank_details(name) values('vijaya') ");
    }

    @Test
    public void shouldRetrieveData() throws Exception {
        var con = DriverManager.getConnection(connectionStringFile);
        var stmt = con.createStatement();
        var rs = stmt.executeQuery("SELECT * FROM BANK_DETAILS");
        while(rs.next()){
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getDouble(3)+"\t");
        }

    }

    @Test
    public void shouldUpdateData() throws Exception {
        var con = DriverManager.getConnection(connectionStringFile);
        var stmt = con.prepareStatement("UPDATE BANK_DETAILS SET AMOUNT = ? WHERE ID = ?");
        stmt.setDouble(1, 2000);
        stmt.setInt(2, 105);
        stmt.execute();
    }

    private void addAccount(int id, String name, double balance, Connection con) throws Exception {
        var stmt = con.createStatement();
        var prepStmt = con.prepareStatement("insert into bank_details(id, name, balance) values(?,?,?)");
        prepStmt.setInt(1, id);
        prepStmt.setString(2, name);
        prepStmt.setDouble(3, balance);
        prepStmt.execute();

    }
}
