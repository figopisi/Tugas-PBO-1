package View.Login;

import Model.Admin;
import Model.Login;
import Model.Customer;
import Util.InputHelper;
import View.Admin.AdminMenu;
import Service.Saham.SahamService;
import Service.SBN.addSBN;

import java.util.ArrayList;

public class LoginMenu {
    public static void menu() {
        ArrayList<Login> accounts = new ArrayList<>();

        accounts.add(new Admin("admin", "admin123"));
        accounts.add(new Customer("user1", "user123"));
        accounts.add(new Admin("Admin Figo", "adminFigo22"));
        accounts.add(new Customer("Admin Fajar", "Fajarganteng99"));

        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("|         MAIN  MENU          |");
            System.out.println("|=============================|");
            System.out.println("| 1. Login as Admin           |");
            System.out.println("| 2. Login as Customer        |");
            System.out.println("| 3. Exit                     |");
            System.out.println("===============================");
            String choice = InputHelper.readString("Choose an option [1-3]: ");

            switch (choice) {
                case "1":
                    boolean retryAdmin;
                    do {
                        String u = InputHelper.readString("Enter admin username: ");
                        String p = InputHelper.readString("Enter admin password: ");
                        boolean found = false;
                        for (Login acct : accounts) {
                            if (acct instanceof Admin && acct.authenticate(u, p)) {
                                new AdminMenu(new SahamService(), new addSBN()).show();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Invalid Admin credentials.");
                            retryAdmin = InputHelper.readString("Try again? (yes/no): ")
                                    .trim().equalsIgnoreCase("yes");
                        } else {
                            retryAdmin = false;
                        }
                    } while (retryAdmin);
                    break;

                case "2":
                    boolean retryUser;
                    do {
                        String u = InputHelper.readString("Enter user username: ");
                        String p = InputHelper.readString("Enter user password: ");
                        boolean found = false;
                        for (Login acct : accounts) {
                            if (acct instanceof Customer && acct.authenticate(u, p)) {
                                View.CustomerMenu.showMenu();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Invalid user credentials.");
                            retryUser = InputHelper.readString("Try again? (yes/no): ")
                                    .trim().equalsIgnoreCase("yes");
                        } else {
                            retryUser = false;
                        }
                    } while (retryUser);
                    break;

                case "3":
                    running = false;
                    System.out.println("Thank you! Program exited.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }
}
