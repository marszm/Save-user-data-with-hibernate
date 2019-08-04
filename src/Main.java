import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(final String[] args) {

        //Create Users
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(1,"Mariusz","Szmer");
        userDAO.addUser(2,"Ewa","Szmer");
        userDAO.addUser(3,"Leszek","Szmer");

        //Retreive Users
        userDAO.retriveAllUsers();

        //Update User



        //Delete User

        userDAO.deleteUser(1,"Mariusz","Szmer");
        userDAO.retriveAllUsers();
    }
}