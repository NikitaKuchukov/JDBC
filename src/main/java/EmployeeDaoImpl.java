import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void createEmployee(Employee employee) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.persist(employee);

        transaction.commit();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return EntityManagerClass.entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployee() {

        return EntityManagerClass.entityManager.createNativeQuery(
                "SELECT * FROM employee", Employee.class).getResultList();

    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        Employee updatedEmployee = EntityManagerClass.entityManager.find(Employee.class, id);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setGender(employee.getGender());
        updatedEmployee.setAge(employee.getAge());
        updatedEmployee.setCity(employee.getCity());

        EntityManagerClass.entityManager.merge(updatedEmployee);

        transaction.commit();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.remove(EntityManagerClass.entityManager.find(Employee.class, employee.getId()));

        transaction.commit();
    }
}
