package Service;

import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SBNService {
    private List<SuratBerhargaNegara> sbnList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adminSBNMenu() {
        int choice;
        do {
            System.out.println("\n============================================");
            System.out.println("|            SBN MENU             |");
            System.out.println("|==========================================|");
            System.out.println("| 1. Tambah SBN                            |");
            System.out.println("| 2. Kembali                               |");
            System.out.println("============================================");
            System.out.print("Pilih menu [1-2]: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSBN();
                    break;
                case 2:
                    System.out.println("Kembali ke menu Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 2);
    }

    public void addSBN() {
        System.out.println("\n============================================");
        System.out.println("|            TAMBAH SBN BARU              |");
        System.out.println("============================================");
        System.out.print("Nama: ");
        String name = scanner.nextLine();

        System.out.print("Bunga (%): ");
        double interestRate = scanner.nextDouble();

        System.out.print("Jangka Waktu (bulan): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tanggal Jatuh Tempo (dd-mm-yyyy): ");
        String maturityDate = scanner.nextLine();

        System.out.print("Kuota Nasional: ");
        int nationalQuota = scanner.nextInt();
        scanner.nextLine();

        SuratBerhargaNegara sbn = new SuratBerhargaNegara(name, interestRate, duration, maturityDate, nationalQuota);
        sbnList.add(sbn);
        System.out.println("SBN berhasil ditambahkan!");
    }

    public List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }
}
