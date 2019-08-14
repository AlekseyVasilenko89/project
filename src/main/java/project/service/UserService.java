package project.service;

import project.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> getAll();

    User getById(int id);

    void update(User user);

    void remove(int id);

    User getByNameAndPassword (String name, String password);
}
