package Repository;

import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdukRepository {
    private static ProdukRepository instance;
    private final List<Saham> daftarSaham = new ArrayList<>();
    private final List<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    private ProdukRepository() { }

    public static synchronized ProdukRepository getInstance() {
        if (instance == null) {
            instance = new ProdukRepository();
        }
        return instance;
    }

    // === Saham ===
    public List<Saham> getAllSaham() {
        return daftarSaham;
    }

    public void addSaham(Saham s) {
        daftarSaham.add(s);
    }

    public Optional<Saham> findSahamByCode(String kode) {
        return daftarSaham.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(kode))
                .findFirst();
    }

    public boolean removeSaham(String kode) {
        return findSahamByCode(kode)
                .map(daftarSaham::remove)
                .orElse(false);
    }

    // === SBN ===
    public List<SuratBerhargaNegara> getAllSBN() {
        return daftarSBN;
    }

    public void addSBN(SuratBerhargaNegara sbn) {
        daftarSBN.add(sbn);
    }

    public Optional<SuratBerhargaNegara> findSBNByName(String nama) {
        return daftarSBN.stream()
                .filter(s -> s.getName().equalsIgnoreCase(nama))
                .findFirst();
    }

    public boolean removeSBN(String nama) {
        return findSBNByName(nama)
                .map(daftarSBN::remove)
                .orElse(false);
    }
}


