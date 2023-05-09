import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDao employeeDAO = new EmployeeDaoImpl();

        employeeDAO.createEmployee(new Employee("Alina", "Kabaeva", "Jen", 48, 4));

        System.out.println(employeeDAO.getEmployeeById(5));

        System.out.println(employeeDAO.getAllEmployee());

        employeeDAO.updateEmployee(13, new Employee("Andrey", "Makarov", "Muj", 35, 3));

        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(10));
    }
}
