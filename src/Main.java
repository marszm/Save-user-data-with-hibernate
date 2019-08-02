import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(final String[] args) {

        User user = new User();
        user.setId(1);
        user.setFirstName("Mariusz");
        user.setSecondNname("Szmer");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        user = session.get(User.class, 1);
        transaction.commit();
        System.out.println(user);



    }
}