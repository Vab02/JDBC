import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConvertEmpToCollection {
    static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully !");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from Employee;");

        Set<Employee> emps = new TreeSet<>();
        while(rs.next()){
            Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            emps.add(e);
        }

        for (Employee eeeee : emps){
            System.out.println(eeeee);
        }

        ResultSet rs1 = st.executeQuery("Select * from Employee;");
        Set<Employee> emp1 = new TreeSet<>((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        while(rs1.next()) {
            Employee e = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getInt(4)
            );
            emp1.add(e);
        }

        for (Employee e : emp1){
            System.out.println(e);
        }

    }
}
