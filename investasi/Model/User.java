package Model;

import View.Login.Login;

public class User extends Login {
    public User(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome User " + getUsername() + "! You are now in the user dashboard.");
    }
}
