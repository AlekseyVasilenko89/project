package project.service;

import project.dao.Client;
import project.dao.UserDAO;
import project.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserService userService;
    private Client client = new Client();
    private UserDAO UserDAO = Client.getDaoFactory().getUserDAO();

    private UserServiceImpl() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public void add(User user) {
        UserDAO.add(user);
    }

    @Override
    public List<User> getAll() {
        return UserDAO.getAll();
    }

    @Override
    public User getById(int id) {
        return UserDAO.getById(id);
    }

    @Override
    public void update(User user) {
        UserDAO.update(user);
    }

    @Override
    public void remove(int id) {
        User user = UserDAO.getById(id);
        if (user != null) {
            UserDAO.remove(user);
        }
    }

    @Override
    public User getByNameAndPassword(String name, String password) {
        User user = null;
        if (name == null || password == null) {
            return user;
        } else {
            return UserDAO.getByNameAndPassword(name, password);
        }
    }
}
