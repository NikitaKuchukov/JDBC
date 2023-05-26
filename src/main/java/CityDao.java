import java.util.List;

public interface CityDao {
    void createCity(City city);

    City getCityById(int id);

    List<City> getAllCity();

    void updateCity(int id, City city);

    void deleteCity(City city);
}
