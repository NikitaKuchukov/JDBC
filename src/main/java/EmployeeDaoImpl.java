import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void createEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerClass.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        EntityManagerClass.entityManagerFactory.close();
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = EntityManagerClass.createEntityManager();

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.close();
        EntityManagerClass.entityManagerFactory.close();

        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = EntityManagerClass.createEntityManager();

        Query query = entityManager.createNativeQuery("SELECT * FROM employee", Employee.class);
        List<Employee> employees = query.getResultList();

        entityManager.close();
        EntityManagerClass.entityManagerFactory.close();

        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        EntityManager entityManager = EntityManagerClass.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employeeOfDataBase = entityManager.find(Employee.class, id);
        employeeOfDataBase.setFirstName(employee.getFirstName());
        employeeOfDataBase.setLastName(employee.getLastName());
        employeeOfDataBase.setGender(employee.getGender());
        employeeOfDataBase.setAge(employee.getAge());
        employeeOfDataBase.setCityId(employee.getCityId());

        entityManager.merge(employeeOfDataBase);

        transaction.commit();
        entityManager.close();
        EntityManagerClass.entityManagerFactory.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerClass.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(entityManager.find(Employee.class, employee.getId()));

        transaction.commit();
        entityManager.close();
        EntityManagerClass.entityManagerFactory.close();
    }
}
