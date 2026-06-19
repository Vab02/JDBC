import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String querry = (
                        "SELECT d.deptname, AVG(e.salary) AS avgsal " +
                        "FROM employee e " +
                        "JOIN department d ON e.deptid = d.deptid " +
                        "GROUP BY d.deptname " +
                        "ORDER BY avgsal DESC");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Crud";

        Connection con = DriverManager.getConnection(url,"root","Vab@9024");

        System.out.println("Connection Successfully !");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from Employee;");

        while(rs.next()){
            System.out.println(rs.getInt(1) + " ");
            System.out.println(rs.getString(2)+ " ");
            System.out.println(rs.getDouble(3)+ " " );
            System.out.println(rs.getInt(4) + " "+ "\n");
        }

//      int Update = st.executeUpdate("update employees set firstname = 'sarthak' where employeeid = 101");
//        int Update = st.executeUpdate("update employees set salary = 20000 where employeeid = 101;");
//        System.out.println(Update);

        ResultSet rs1 = st.executeQuery(querry);

        while(rs1.next()){
            System.out.print(rs1.getString(1) + " ");
            System.out.print(rs1.getDouble(2) + " " + "\n");
        }


        rs.close();
        st.close();
        con.close();






    }
}
