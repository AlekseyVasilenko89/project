package project.dao;

import project.config.Util;

public class Client {
    private Util util = new Util();
    private DaoFactory daoFactory;
    private String propertiesName = "DB_CLIENT";

    public DaoFactory getDaoFactory() {
        System.out.println("client work");
        if (util.getPropertiesValue(propertiesName).equals("JDBC")) {
            daoFactory = new JDBCDaoFactory();
        }
        if (util.getPropertiesValue(propertiesName).equals("HIBERNATE")) {
            System.out.println("Properties ok");
            daoFactory = new HibernateDaoFactory();
        }
        return daoFactory;
    }
}
