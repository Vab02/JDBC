import java.util.Comparator;

public class Employee implements Comparable<Employee> , Comparator<Employee> {
    private int EmpId;
    private String EmpName;
    private Double Salary;
    private int DeptId;


    Employee(int EmpId, String EmpName, Double Salary,int DeptId){
        this.EmpId = EmpId;
        this.EmpName = EmpName;
        this.Salary = Salary;
        this.DeptId = DeptId;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public int getDeptId() {
        return DeptId;
    }

    public void setDeptId(int deptId) {
        DeptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmpId +
                ", EmployeeName='" + EmpName + '\'' +
                ", Salary='" + Salary + '\'' +
                ", DepartmentID='" + DeptId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return o.getEmpName().compareTo(this.getEmpName());
    }


    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary() - o1.getSalary());
    }
}
