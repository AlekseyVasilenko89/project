package project.dao;

import project.config.Util;

public class Client {
    private static DaoFactory daoFactory;

    public static DaoFactory getDaoFactory() {
        String propertiesName = "DB_CLIENT";
        if (Util.getPropertiesValue(propertiesName).equals("JDBC")) {
            daoFactory = new JDBCDaoFactory();
        }
        if (Util.getPropertiesValue(propertiesName).equals("HIBERNATE")) {
            daoFactory = new HibernateDaoFactory();
        }
        return daoFactory;
    }
}
