package project.dao;

public class HibernateDaoFactory implements DaoFactory {
    @Override
    public UserDAO getUserDAO() {
        return new HibernateUserDAOImpl();
    }
}
