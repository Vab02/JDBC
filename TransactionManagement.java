import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionManagement {
    static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";
        Connection con = DriverManager.getConnection(url,"root","Vab@9024");
        System.out.println("Connection Successfully");


        con.setAutoCommit(false);
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO userinfo VALUES (?,?,?,?,?)");

            System.out.println("Enter the UID");
            int uid = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the Name");
            String name = sc.nextLine();

            System.out.println("Enter the EmailID");
            String email = sc.nextLine();

            System.out.println("Enter the ContactNo");
            String contact = sc.nextLine();

            System.out.println("Enter the City");
            String city = sc.nextLine();

            ps.setInt(1, uid);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, contact);
            ps.setString(5, city);

            int n = ps.executeUpdate();


            PreparedStatement ps1 = con.prepareStatement("INSERT INTO Education VALUES (?,?,?,?)");

            System.out.println("Enter the UID");
            int uid1 = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the SSC MARKS");
            double ssc = sc.nextDouble();

            System.out.println("Enter the HSC MARKS");
            double hsc = sc.nextDouble();

            System.out.println("Enter the GRADUATION MARKS");
            double grad = sc.nextDouble();

            ps1.setInt(1, uid1);
            ps1.setDouble(2, ssc);
            ps1.setDouble(3, hsc);
            ps1.setDouble(4, grad);

            int n1 = ps1.executeUpdate();

            con.commit();
            System.out.println("Data Succesfully Inserted in Both Tables");

        }
        catch (SQLException e){
            con.rollback();
            System.out.println("INSERTION FAILED");
        }

        con.setAutoCommit(true);
    }
}
