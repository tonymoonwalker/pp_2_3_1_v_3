package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Override
    public List<User> allUsers() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getById(long id) {
        return null;
    }
}
