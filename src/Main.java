import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(final String[] args) {

        UserDAO userDAO = new UserDAO();
        userDAO.addUser(1,"a","bb");
//        System.out.println();
    }
}