import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerClass {

    static EntityManager entityManager = createEntityManager();
    static EntityManagerFactory entityManagerFactory;

    private static EntityManager createEntityManager() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}
