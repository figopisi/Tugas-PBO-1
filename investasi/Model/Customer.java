package Model;

public class Customer extends Login {
    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome User " + getUsername() + "! You are now in the user dashboard.");
    }
}
