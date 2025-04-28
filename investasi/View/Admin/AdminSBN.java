package View.Admin;

import Service.Saham.SahamService;
import Service.SBN.addSBN;
import Util.InputHelper;

public class AdminSBN {
    private final addSBN sbnService;
    private final SahamService sahamService;

    public AdminSBN(SahamService sahamService) {
        this.sahamService = sahamService;
        sbnService = new addSBN();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|              SBN MENU                     |");
            System.out.println("|===========================================|");
            System.out.println("| 1. Tambah SBN                             |");
            System.out.println("| 2. Kembali                                |");
            System.out.println("============================================");
            choice = InputHelper.readInt("Pilih menu [1-2]: ", 1, 2);

            switch (choice) {
                case 1:
                    sbnService.addSBN();
                    break;
                case 2:
                    AdminMenu adminMenu = new AdminMenu(sahamService, sbnService); // Kirimkan sahamService dan sbnService yang dibutuhkan
                    adminMenu.show();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 2);
    }
}
