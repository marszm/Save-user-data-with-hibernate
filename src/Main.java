import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(final String[] args) {

        User user = new User();
        user.setId(1);
        user.setFirstName("Mariusz");
        user.setSecondName("Szmer");

        Laptop laptop = new Laptop();
        laptop.setId(11);
        laptop.setName("DELL");

        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Laptop.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create session factoryobject.");
        }

        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            session.save(laptop);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }



//        user = session.get(User.class, 1);
//        System.out.println(user);



    }
}