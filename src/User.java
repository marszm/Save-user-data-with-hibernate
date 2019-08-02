import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {

    @Id
    private int id;
    private String firstName;
    private String secondNname;

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondNname() {
        return secondNname;
    }

    public void setSecondNname(String secondNname) {
        this.secondNname = secondNname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondNname='" + secondNname + '\'' +
                '}';
    }
}
