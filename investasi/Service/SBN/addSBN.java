package Service.SBN;

import Model.SuratBerhargaNegara;
import Repository.ProdukRepository;
import util.InputHelper;

import java.util.List;

public class addSBN {
    private ProdukRepository produkRepository;

    public addSBN() {
        this.produkRepository = ProdukRepository.getInstance();
    }

    public void addSBN() {
        System.out.println("\n============================================");
        System.out.println("|            TAMBAH SBN BARU               |");
        System.out.println("============================================");

        String name = InputHelper.readString("Nama: ");
        double interestRate = InputHelper.readDouble("Bunga (%): ");
        int duration = InputHelper.readInt("Jangka Waktu (bulan): ", 1, Integer.MAX_VALUE);
        String maturityDate = InputHelper.readString("Tanggal Jatuh Tempo (dd-mm-yyyy): ");
        int nationalQuota = InputHelper.readInt("Kuota Nasional: ", 1, Integer.MAX_VALUE);

        SuratBerhargaNegara sbn = new SuratBerhargaNegara(name, interestRate, duration, maturityDate, nationalQuota);
        produkRepository.addSBN(sbn);
        System.out.println("SBN berhasil ditambahkan!");
    }

    public List<SuratBerhargaNegara> getSbnList() {
        return produkRepository.getAllSBN();
    }
}
