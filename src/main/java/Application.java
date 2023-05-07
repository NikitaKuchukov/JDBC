import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        List<Employee> employees = employeeDAO.getAllEmployee();
        System.out.println(employees);

        System.out.println(employeeDAO.getEmployeeById(3));

        employeeDAO.updateEmployee(4, new Employee(4, "Anton", "Golubkov", "Muj", 24,  new City(1, "")));
        System.out.println(employeeDAO.getEmployeeById(4));

        employeeDAO.deleteEmployee(9);
        System.out.println(employeeDAO.getEmployeeById(9));

        employeeDAO.createEmployee(new Employee(2, "Grigoriy", "Leps", "Muj", 55, new City(2, "")));
        System.out.println(employeeDAO.getEmployeeById(7));
    }
}
