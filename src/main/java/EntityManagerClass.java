import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerClass {
    static EntityManagerFactory entityManagerFactory;

    public static EntityManager createEntityManager() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}
