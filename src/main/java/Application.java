import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();

        City city = City.builder().cityName("NSK").employees(List.of()).build();

        Employee emp1 = Employee.builder()
                .firstName("Artut")
                .lastName("Pirojkov")
                .gender("Muj")
                .city(city)
                .age(55)
                .build();

        Employee emp2 = Employee.builder()
                .firstName("Dmitriy")
                .lastName("Donskoy")
                .gender("Muj")
                .age(66)
                .city(city)
                .build();

        city.setEmployees(List.of(emp1, emp2));

        cityDao.createCity(city);
        System.out.println(employeeDao.getAllEmployee().containsAll(city.getEmployees()));

        cityDao.updateCity(31, City.builder().cityName("Samara").build());

employeeDao.updateEmployee(49, Employee.builder()
        .firstName("Viktoriya")
        .lastName("Gromova")
        .gender("Jen")
        .age(21)
        .city(city)
        .build());

        cityDao.deleteCity(cityDao.getCityById(32));
        System.out.println(employeeDao.getAllEmployee().containsAll(city.getEmployees()));
    }
}
