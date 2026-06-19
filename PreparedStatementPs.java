import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class PreparedStatementPs {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully 👍");

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee where empid = ?");

        System.out.println("Enter the Emloyee ID::");
        int empno = sc.nextInt();
        ps.setInt(1,empno);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getDouble(3) + " ");
            System.out.print(rs.getInt(4) + " " + "\n");
        }
        else {
            System.out.println("Employee Does Not Exists");
        }

    }
}
