import java.util.List;

public interface EmployeeDAO {
    void createEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployee();
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
