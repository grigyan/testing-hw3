import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        User Max = new User("Max", "max44@gmail.com");
        User Lily = new User("lilyyy", "lily_7@gmail.com");
        User Bob = new User("bob888", "thisIsBob_889@gmail.com");
        User Charlie = new User("charlie555", "charlie781@gmail.com");

        ComputerSystem system = new ComputerSystem();
        System.out.println("Adding Max, Lily and Bob to the system");
        system.addUser(Max);
        system.addUser(Lily);
        system.addUser(Bob);

        System.out.println("System contains Max: " + system.containsUser(Max.getEmail()));
        System.out.println("System contains Lily: " + system.containsUser(Lily.getEmail()));
        System.out.println("System.contains Bob: " + system.containsUser(Bob.getEmail()));
        System.out.println("System contains Charlie: " + system.containsUser(Charlie.getEmail()));

        System.out.println("Removing Max from system");
        system.removeUser(Max.getEmail());
        System.out.println("System contains Max: " + system.containsUser(Max.getEmail()));
        System.out.println();
        System.out.println();

        System.out.println("Adding Charlie to the system");
        system.addUser(Charlie);
        System.out.println("Charlie's current email " + Charlie.getEmail());
        system.changeUserEmail(Charlie.getEmail(), "charlieNew@gmail.com");
        System.out.println("Charlie's new email " + Charlie.getEmail());

        System.out.println("");
        System.out.println("All users: " + system.getAllUsers().toString());

    }
}
