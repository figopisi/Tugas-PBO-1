package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Login> accounts = new ArrayList<>();

        accounts.add(new Admin("admin", "admin123"));
        accounts.add(new User("user1", "user123"));

        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("|         MAIN  MENU          |");
            System.out.println("|=============================|");
            System.out.println("| 1. Login as Admin           |");
            System.out.println("| 2. Login as User            |");
            System.out.println("| 3. Exit                     |");
            System.out.println("===============================");
            System.out.print("Choose an option [1-3]: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    boolean isAdminFound = false;
                    for (Login account : accounts) {
                        if (account instanceof Admin &&
                                account.authenticate(adminUsername, adminPassword)) {
                            account.showDashboard();
                            isAdminFound = true;
                            break;
                        }
                    }

                    if (!isAdminFound) {
                        System.out.println("Invalid admin credentials.");
                    }
                    break;

                case "2":
                    System.out.print("Enter user username: ");
                    String userUsername = scanner.nextLine();
                    System.out.print("Enter user password: ");
                    String userPassword = scanner.nextLine();

                    boolean isUserFound = false;
                    for (Login account : accounts) {
                        if (account instanceof User &&
                                account.authenticate(userUsername, userPassword)) {
                            account.showDashboard();
                            isUserFound = true;
                            break;
                        }
                    }

                    if (!isUserFound) {
                        System.out.println("Invalid user credentials.");
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("Thank you! Program exited.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
