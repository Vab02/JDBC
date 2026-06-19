import java.sql.Connection;
import java.sql.DriverManager;

public class TransactionISolation {
    static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully !");

        System.out.println(con.getTransactionIsolation()); //4

        con.setTransactionIsolation(8);



    }
}
