package menu;
import java.util.ArrayList;
import java.util.Scanner;

class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}

class Admin extends Login {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void showDashboard() {
        System.out.println("Selamat datang, Admin " + getUsername() );
    }
}

class User extends Login {
    public User(String username, String password) {
        super(username, password);
    }

    public void showDashboard() {
        System.out.println("Selamat datang, " + getUsername() + "!");
    }
}



