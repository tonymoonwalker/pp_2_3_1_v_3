package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        entityManager.merge(user);

    }

    @Override
    public void delete(long id) {
        entityManager.remove(id);

    }

    @Override
    public User getById(long id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);

        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }
}
