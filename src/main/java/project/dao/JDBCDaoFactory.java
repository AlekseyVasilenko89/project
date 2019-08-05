package project.dao;

public class JDBCDaoFactory implements DaoFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
}
