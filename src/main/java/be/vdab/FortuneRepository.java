package be.vdab;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named // Same as @ManagedBean
public class FortuneRepository {
    @PersistenceContext
    private EntityManager entityManager;

    List<Fortune> findAll() {
        return entityManager.createQuery("select f from Fortune f", Fortune.class).getResultList();
    }
}
