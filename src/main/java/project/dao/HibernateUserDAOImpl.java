package project.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import project.config.DBHelper;
import project.config.GetSession;
import project.model.User;

import java.util.List;

public class HibernateUserDAOImpl implements UserDAO {

    private static SessionFactory sessionFactory;
    private static DBHelper dbHelper = DBHelper.getDbHelper();

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(dbHelper.getConfiguration().getProperties()).build();
                sessionFactory = dbHelper.getConfiguration().buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    @Override
    public void add(User user) {
        Transaction trans = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> listOfUser = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            listOfUser = session.createQuery("from User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfUser;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            user = session.load(User.class, id);
            user.getId();
        } catch (ObjectNotFoundException e) {
            user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        Transaction trans = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.update(user);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        Transaction trans = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.delete(user);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public User getByNameAndPassword(String name, String password) {

        User user = null;
        try (Session session = HibernateUserDAOImpl.getSessionFactory().openSession()) {
            Query query = session.createQuery("from users where name = :name");
            query.setParameter("name", name);
//            query.setParameter("password", password);
            List<User> list = query.list();
            for (User u : list) {
                user = u;
                System.out.println(user);
            }
            user.getId();
        } catch (ObjectNotFoundException e) {
            user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
