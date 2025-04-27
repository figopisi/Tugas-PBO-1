package Admin;

import View.Admin.AdminSBN;
import View.Admin.AdminSaham;
import util.InputHelper;

public class AdminController {
    private AdminSBN adminSBN;
    private AdminSaham adminSaham;

    public AdminController() {
        adminSBN = new AdminSBN();
        adminSaham = new AdminSaham();
    }

    public void adminMenu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|             ADMIN MENU                   |");
            System.out.println("|==========================================|");
            System.out.println("| 1. Kelola SBN                            |");
            System.out.println("| 2. Kelola Saham                          |");
            System.out.println("| 3. Logout                                |");
            System.out.println("============================================");
            choice = InputHelper.readInt("Pilih menu [1-3]: ", 1, 3);

            switch (choice) {
                case 1:
                    adminSBN.adminSBNMenu();
                    break;
                case 2:
                    adminSaham.adminSahamMenu();
                    break;
                case 3:
                    System.out.println("Logout dari akun Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 3);
    }
}
