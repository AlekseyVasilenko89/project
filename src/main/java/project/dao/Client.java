package project.dao;

import project.db.Util;

public class Client {
    private Util util = new Util();
    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        String propertiesName = "DB_CLIENT";
        System.out.println(util.getPropertiesValue(propertiesName));
        if (util.getPropertiesValue(propertiesName).equals("JDBC")){
            daoFactory= new JDBCDaoFactory();
        }
        if (util.getPropertiesValue(propertiesName).equals("HIBERNATE")){
            System.out.println("Properties ok");
            daoFactory= new HibernateDaoFactory();
        }
        return daoFactory;
    }
}
