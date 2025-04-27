package Admin;

import Model.Saham;
import Model.SuratBerhargaNegara;
import Service.SahamService;
import Service.SBNService;
import Util.InputHelper;

public class AdminController {
    private final SahamService sahamSvc;
    private final SBNService sbnSvc;

    public AdminController(SahamService sahamSvc, SBNService sbnSvc) {
        this.sahamSvc = sahamSvc;
        this.sbnSvc   = sbnSvc;
    }

    public void menu() {
        int pilihan;
        do {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            pilihan = InputHelper.readInt("Pilih: ", 1, 3);

            switch (pilihan) {
                case 1: menuSaham(); break;
                case 2: menuSBN(); break;
                case 3: System.out.println("Logout Admin."); break;
            }
        } while (pilihan != 3);
    }