import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableAndUpdatable {
    static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully !");

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = st.executeQuery("Select * from Employee");

        while(rs.next()){
            double salary = rs.getDouble(3);

            if(salary < 10000){
                salary = salary + (salary * 0.02);
            }
            else if(salary >= 10000 && salary < 25000){
                salary = salary + (salary * 0.05);
            }
            else if(salary >= 25000 && salary < 50000){
                salary = salary + (salary * 0.08);
            }
            else {
                salary = salary + (salary * 0.10);
            }

            rs.updateDouble(3,salary);
            rs.updateRow();
        }

        System.out.println("Salary updated Successfully");

    }
}
