package View.Admin;

import Service.SBN.addSBN;
import Util.InputHelper;


public class AdminSaham {
    private addSBN sbnService;

    public AdminSaham() {
            sbnService = new addSBN();
    }

    public void adminSBNMenu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|              Saham MENU                     |");
            System.out.println("|===========================================|");
            System.out.println("| 1. Tambah Saham                             |");
            System.out.println("| 2. Ubah Harga Saham                           |");
            System.out.println("| 3. Kembali                                |");
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


