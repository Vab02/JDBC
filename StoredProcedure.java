import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class StoredProcedure {
    static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";
        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Department Number:: ");
        int deptno = sc.nextInt();
        CallableStatement cs = con.prepareCall("{call GetDeptAvgSalary(?)}");

        cs.setInt(1,deptno);

        boolean result = cs.execute();

        if(result){
            ResultSet rs = cs.getResultSet();
            while (rs.next()){
                System.out.println("Department:: " + rs.getString(1));
                System.out.println("Average Salary :: " + rs.getDouble(2));
            }
            rs.close();
        }
        else{
            int n = cs.executeUpdate();
        }

        cs.close();
        con.close();

    }
}
