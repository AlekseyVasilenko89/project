package project.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.config.HibernateUtil;
import project.model.User;

import java.util.List;

public class HibernateUserDAOImpl implements UserDAO {

    @Override
    public void add(User user) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            listOfUser = session.createQuery("from User").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfUser;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.load(User.class, id);
            user.getId();
        } catch (ObjectNotFoundException e) {
            user = null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
}
