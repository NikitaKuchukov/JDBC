import javax.persistence.EntityTransaction;
import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public void createCity(City city) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.persist(city);

        transaction.commit();
    }

    @Override
    public City getCityById(int id) {
        return EntityManagerClass.entityManager.find(City.class, id);
    }

    @Override
    public List<City> getAllCity() {
        return EntityManagerClass.entityManager.createNativeQuery(
                "SELECT * FROM city", City.class).getResultList();
    }

    @Override
    public void updateCity(int id, City city) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        City updatedCity = EntityManagerClass.entityManager.find(City.class, id);
        updatedCity.setCityName(city.getCityName());
        updatedCity.setEmployees(city.getEmployees());

        EntityManagerClass.entityManager.merge(updatedCity);

        transaction.commit();
    }

    @Override
    public void deleteCity(City city) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.remove(EntityManagerClass.entityManager.find(City.class, city.getCityId()));

        transaction.commit();
    }
}
