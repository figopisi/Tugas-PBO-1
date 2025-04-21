package View.Login;

public abstract class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }

    public abstract void showDashboard();
}


class Admin extends Login {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome " + getUsername() + "! You are now in the admin dashboard.");
    }
}

class User extends Login {
    public User(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome User " + getUsername() + "! You are now in the user dashboard.");
    }
}

