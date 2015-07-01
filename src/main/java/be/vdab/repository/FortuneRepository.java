package be.vdab.repository;

import be.vdab.domain.Fortune;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named // Same as @ManagedBean
public class FortuneRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Fortune> findAll() {
        return entityManager.createQuery("select f from Fortune f", Fortune.class).getResultList();
    }
}
