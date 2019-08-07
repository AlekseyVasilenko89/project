package project.dao;

import project.config.Util;

public class Client {
    private Util util = new Util();
    private DaoFactory daoFactory;
    private String propertiesName = "DB_CLIENT";

    public DaoFactory getDaoFactory() {
        if (util.getPropertiesValue(propertiesName).equals("JDBC")) {
            daoFactory = new JDBCDaoFactory();
        }
        if (util.getPropertiesValue(propertiesName).equals("HIBERNATE")) {
            daoFactory = new HibernateDaoFactory();
        }
        return daoFactory;
    }
}
