import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComputerSystemTest {

    @Test
    public void shouldContainUser() {
        ComputerSystem system = new ComputerSystem();
        User user1 = new User("user1", "user1@gmail.com");
        User user2 = new User("user2", "user2@gmail.com");

        system.addUser(user1);
        system.addUser(user2);

        Assert.assertTrue(system.containsUser(user1.getEmail()));
        Assert.assertTrue(system.containsUser(user2.getEmail()));
        Assert.assertFalse(system.containsUser(new User("user3", "user3@gmail.com").getEmail()));
    }


    @Test
    public void shouldAddUser() {
        ComputerSystem system = new ComputerSystem();
        User user1 = new User("user1", "user1@gmail.com");
        User user2 = new User("user2", "user2@gmail.com");
        system.addUser(user1);
        system.addUser(user2);

        // in case if everything goes right
        Assert.assertTrue(system.containsUser(user1.getEmail()));
        Assert.assertTrue(system.containsUser(user2.getEmail()));

        // in case if user already exists
        Assert.assertFalse(system.addUser(user1));
    }

    @Test
    public void shouldRemoveUser() {
        ComputerSystem system = new ComputerSystem();
        User user1 = new User("user1", "user1@gmail.com");
        system.addUser(user1);

        Assert.assertTrue(system.removeUser("user1@gmail.com"));
        Assert.assertFalse(system.removeUser("user2@gmail.com"));

        system.removeUser(user1.getEmail());
        Assert.assertEquals(system.getAllUsers().size(), 0);
    }

    @Test
    public void shouldChangeUserEmail() {
        ComputerSystem system = new ComputerSystem();
        system.addUser(new User("user1", "user1@gmail.com"));
        system.addUser(new User("user2", "user2@gmail.com"));

        Assert.assertTrue(system.changeUserEmail("user1@gmail.com", "user1New@gmail.com"));
        Assert.assertFalse(system.changeUserEmail("user2@gmail.com", "user2@gmail.com"));
        Assert.assertFalse(system.changeUserEmail("user2@gmail.com", ""));
        Assert.assertFalse(system.changeUserEmail("user3@gmail.com", "user2New@gmail.com"));
    }

    @Test
    public void shouldGetAllUsers() {
        ComputerSystem system = new ComputerSystem();
        User user1 = new User("user1", "user1@gmail.com");
        User user2 = new User("user2", "user2@gmail.com");

        system.addUser(user1);
        system.addUser(user2);

        List<User> users = system.getAllUsers();
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));
        Assert.assertEquals(users.size(), 2);
    }


}
