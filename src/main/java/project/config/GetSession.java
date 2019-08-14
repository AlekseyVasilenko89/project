package project.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class GetSession {
    private static DBHelper dbHelper = DBHelper.getDbHelper();
    private static SessionFactory sessionFactory;

//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(dbHelper.getConfiguration().getProperties()).build();
//                sessionFactory = dbHelper.getConfiguration().buildSessionFactory(serviceRegistry);
//                return sessionFactory;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
    }