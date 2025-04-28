package View.Admin;

import Service.Saham.SahamService;
import Service.SBN.addSBN;
import Util.InputHelper;

public class AdminMenu {
    private final SahamService sahamService;
    private final addSBN sbnService;

    public AdminMenu(SahamService sahamService, addSBN sbnService) {
        this.sahamService = sahamService;
        this.sbnService = sbnService;
    }

    public void show() {
        int choice;
        do {
            System.out.println("\n===============================");
            System.out.println("|          ADMIN MENU         |");
            System.out.println("|=============================|");
            System.out.println("| 1. Saham                    |");
            System.out.println("| 2. SBN                      |");
            System.out.println("| 3. Logout                   |");
            System.out.println("===============================");
            choice = InputHelper.readInt("Pilih opsi [1-3]: ", 1, 3);

            switch (choice) {
                case 1:
                    new AdminSaham(sahamService).menu();
                    break;
                case 2:
                    new AdminSBN(sahamService).menu();
                    break;
                case 3:
                    System.out.println("Logout berhasil.\n");
                    break;
            }
        } while (choice != 3);
    }
}
