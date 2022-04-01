import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerSystem {
    private Map<String, User> users = new HashMap<>();


    public boolean containsUser(String email) {
        return users.containsKey(email);
    }

    public boolean addUser(User user) {
        if(users.containsKey(user.getEmail())) {
            return false;
        }

        users.put(user.getEmail(), user);
        return true;
    }

    public boolean removeUser(String email) {
        if(!users.containsKey(email)) {
            return false;
        }

        users.remove(email);
        return true;
    }

    public boolean changeUserEmail(String oldEmail, String newEmail) {
        if(oldEmail.equals(newEmail) ||
        !users.containsKey(oldEmail) ||
        newEmail.isBlank()) {
            return false;
        }

        User user = users.get(oldEmail);
        user.setEmail(newEmail);
        users.put(newEmail, user);
        removeUser(oldEmail);

        return true;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

}
