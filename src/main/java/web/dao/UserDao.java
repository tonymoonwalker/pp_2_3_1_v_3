package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void edit(User user);
    void delete(long id);
    User getById(long id);
}
