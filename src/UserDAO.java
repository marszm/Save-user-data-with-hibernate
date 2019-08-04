import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Entity;

@Entity
public class UserDAO {

    private static SessionFactory sessionFactory;

    public void addUser(int id, String fname, String lname) {
//        User user = null;
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
}
