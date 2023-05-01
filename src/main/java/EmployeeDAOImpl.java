import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String pass = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public void createEmployee(Employee employee) {

        }

    @Override
    public Employee getEmployeeById(int id) {

        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();

            String sql = "SELECT " +
                     "id, first_name, last_name, gender, age, city_id, city_name " +
                     "FROM employee " +
                     "INNER JOIN city ON employee.city_id = city.city_id";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");
                String cityNameOfEmployee = resultSet.getString("city_name");
                System.out.println("Employee Id: " + idOfEmployee);
                System.out.println("First_name: " + firstNameOfEmployee);
                System.out.println("Last_name: " + lastNameOfEmployee);
                System.out.println("Gender: " + genderOfEmployee);
                System.out.println("Age: " + ageOfEmployee);
                System.out.println("City: " + cityNameOfEmployee);

                employees.add(new Employee(idOfEmployee,
                        firstNameOfEmployee, lastNameOfEmployee,
                        genderOfEmployee, ageOfEmployee, cityIdOfEmployee));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключнии к базе данных!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
