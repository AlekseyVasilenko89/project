package project.service;

import project.dao.HibernateUserDAOImpl;
import project.dao.UserDAO;
import project.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserService userService;

    private UserDAO hibernateUserDAO = new HibernateUserDAOImpl();

    public static UserService getUserService() {
        if (userService== null) {
            userService= new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public void add(User user) {
        hibernateUserDAO.add(user);
    }

    @Override
    public List<User> getAll() {
        return hibernateUserDAO.getAll();
    }

    @Override
    public User getById(int id) {
        return hibernateUserDAO.getById(id);
    }

    @Override
    public void update(User user) {
        hibernateUserDAO.update(user);
    }

    @Override
    public void remove(int id) {
        User user = hibernateUserDAO.getById(id);
        if (!(user == null)) {
            hibernateUserDAO.remove(user);
        }
    }
}
