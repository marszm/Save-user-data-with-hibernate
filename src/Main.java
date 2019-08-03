import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(final String[] args) {

        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create session factoryobject.");
        }

        UserDAO userDAO = new UserDAO();
        userDAO.addUser(1,"Mariusz","Szmer");
//        User user1 = new User("Mariusz","Szmer");
//        User user2 = new User("Ewa","Szmer");
//        User user3 = new User("Leszek","Szmer");







    }
}