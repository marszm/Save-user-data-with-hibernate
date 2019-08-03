import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {

    SessionFactory sessionFactory = null;

    public User addUser(int id, String fname, String lname) {
        User user = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            user = new User(id, fname, lname);
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
                e.printStackTrace();
        } finally {
            session.close();
        }
    return user;
    }

}
