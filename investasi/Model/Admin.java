package Model;

public class Admin extends Login {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome " + getUsername() + "! You are now in the admin dashboard.");
    }
}
