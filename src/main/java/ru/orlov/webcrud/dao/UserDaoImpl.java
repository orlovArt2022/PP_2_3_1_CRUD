package ru.orlov.webcrud.dao;

import org.springframework.stereotype.Repository;
import ru.orlov.webcrud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
//        entityManager.remove(entityManager.find(User.class, id));
        Query query = entityManager.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void editUser(User newUser) {
        entityManager.merge(newUser);
    }

    @Override
    public User getByIdUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
