package be.vdab.repository;

import be.vdab.domain.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private User user;

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
