import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class UserDAO {

    private static SessionFactory sessionFactory;

    public void addUser(int id, String fname, String lname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = new User();
            user.setId(id);
            user.setFirstName(fname);
            user.setSecondName(lname);
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
                e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void retriveAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List users = session.createQuery("from User").list();
            users.stream().forEach(System.out::println);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteUser(int id, String fname, String lname) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = new User();
            user.setId(id);
            user.setFirstName(fname);
            user.setSecondName(lname);
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(int id, String fname, String lname){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = new User();
            user.setId(id);
            user.setFirstName(fname);
            user.setSecondName(lname);
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
