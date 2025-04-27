package View.Admin;

import Service.SahamService;
import util.InputHelper;

public class AdminSaham {
    private SahamService sahamService;

    public AdminSaham() {
        sahamService = new SahamService();
    }

    public void adminSahamMenu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|              SAHAM MENU                  |");
            System.out.println("|==========================================|");
            System.out.println("| 1. Tambah Saham                          |");
            System.out.println("| 2. Ubah Harga Saham                      |");
            System.out.println("| 3. Hapus Saham                           |");
            System.out.println("| 4. Kembali                               |");
            System.out.println("============================================");
            choice = InputHelper.readInt("Pilih menu [1-4]: ", 1, 4);

            switch (choice) {
                case 1:
                    sahamService.addSaham();
                    break;
                case 2:
                    sahamService.updatePrice();
                    break;
                case 3:
                    sahamService.removeSaham();
                    break;
                case 4:
                    System.out.println("Kembali ke menu Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 4);
    }
}
