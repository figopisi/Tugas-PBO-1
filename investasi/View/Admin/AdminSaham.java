package View.Admin;

import Service.SahamService;
import Util.InputHelper;

public class AdminSaham {
    private final SahamService sahamService;

    public AdminSaham(SahamService sahamService) {
        this.sahamService = sahamService;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|              SAHAM MENU                  |");
            System.out.println("|===========================================|");
            System.out.println("| 1. Tambah Saham                          |");
            System.out.println("| 2. Ubah Harga Saham                      |");
            System.out.println("| 3. Kembali                               |");
            System.out.println("============================================");
            choice = InputHelper.readInt("Pilih menu [1-3]: ", 1, 3);

            switch (choice) {
                case 1:
                    sahamService.addSaham();
                    break;
                case 2:
                    sahamService.updatePrice();
                    break;
                case 3:
                    System.out.println("Kembali ke menu Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 4);
    }
}
