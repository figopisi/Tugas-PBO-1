package View.Login;

import Model.Admin;
import Model.Login;
import Model.Customer;
import Util.InputHelper;
import View.Admin.AdminMenu;
import View.CustomerMenu;
import Service.Saham.SahamService;
import Service.SBN.addSBN;
import java.util.ArrayList;

public class LoginMenu {
    public static void menu() {
        ArrayList<Login> accounts = new ArrayList<>();

        accounts.add(new Model.Admin("admin", "admin123"));
        accounts.add(new Model.Customer("user1", "user123"));
        accounts.add(new Model.Admin("Admin Figo", "adminFigo22"));
        accounts.add(new Model.Customer("Admin Fajar", "Fajarganteng99"));

        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("|         MAIN  MENU          |");
            System.out.println("|=============================|");
            System.out.println("| 1. Login as Admin           |");
            System.out.println("| 2. Login as User            |");
            System.out.println("| 3. Exit                     |");
            System.out.println("===============================");
            String choice = InputHelper.readString("Choose an option [1-3]: ");

            switch (choice) {
                case "1":
                    boolean retryAdminLogin;
                    do {
                        String adminUsername = InputHelper.readString("Enter admin username: ");
                        String adminPassword = InputHelper.readString("Enter admin password: ");

                        boolean isAdminFound = false;
                        for (Login account : accounts) {
                            if (account instanceof Admin &&
                                    account.authenticate(adminUsername, adminPassword)) {
                                new AdminMenu(new SahamService(), new addSBN()).show();
                                isAdminFound = true;
                                break;
                            }
                        }

                        if (!isAdminFound) {
                            System.out.println("Invalid Admin credentials.");
                            String retryChoice = InputHelper.readString("Do you want to try again? (yes/no): ").trim().toLowerCase();
                            retryAdminLogin = retryChoice.equals("yes");
                        } else {
                            retryAdminLogin = false;
                        }
                    } while (retryAdminLogin);
                    break;

                case "2":
                    boolean retryUserLogin;
                    do {
                        String userUsername = InputHelper.readString("Enter user username: ");
                        String userPassword = InputHelper.readString("Enter user password: ");

                        boolean isUserFound = false;
                        for (Login account : accounts) {
                            if (account instanceof Customer &&
                                    account.authenticate(userUsername, userPassword)) {
                                CustomerMenu.showMenu();
                                isUserFound = true;
                                break;
                            }
                        }

                        if (!isUserFound) {
                            System.out.println("Invalid user credentials.");
                            String retryChoice = InputHelper.readString("Do you want to try again? (yes/no): ").trim().toLowerCase();
                            retryUserLogin = retryChoice.equals("yes");
                        } else {
                            retryUserLogin = false;
                        }
                    } while (retryUserLogin);
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
