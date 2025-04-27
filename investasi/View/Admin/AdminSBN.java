package View.Admin;

import Service.SBN.addSBN;
import Util.InputHelper;

public class AdminSBN {
    private final addSBN sbnService;

    public AdminSBN() {
        sbnService = new addSBN();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|              SBN MENU                      |");
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
                    System.out.println("Kembali ke menu Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 2);
    }
}
