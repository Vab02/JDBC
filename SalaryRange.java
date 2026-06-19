import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SalaryRange {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully 👍");

        String querry = "select empname,salary from employee where salary between ? and ?";

        PreparedStatement ps = con.prepareStatement(querry);

        System.out.println("Enter Min Salary");
        double minsal = sc.nextDouble();
        System.out.println("Enter Max Salary");
        double maxsal = sc.nextDouble();
        ps.setDouble(1,minsal);
        ps.setDouble(2,maxsal);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getDouble(2) + " " + "\n");
        }

    }
}
