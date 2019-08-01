import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(final String[] args) {

        User user = new User();
        user.setName("Mariusz");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        System.out.println("...");

    }
}