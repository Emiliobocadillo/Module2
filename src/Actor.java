import java.util.ArrayList;

public class Actor {
    private String fullName;
    private String role;

    public Actor(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String toString() {
        return fullName + " as " + role;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }
}
