package Repository;

import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdukRepository {
    private static ProdukRepository instance;
    private final List<Saham> sahamList = new ArrayList<>();
    private final List<SuratBerhargaNegara> sbnList = new ArrayList<>();

    private ProdukRepository() { }

    public static synchronized ProdukRepository getInstance() {
        if (instance == null) {
            instance = new ProdukRepository();
        }
        return instance;
    }

    public List<Saham> getAllSaham() {
        return sahamList;
    }

    public void addSaham(Saham s) {
        sahamList.add(s);
    }

    public Optional<Saham> findSahamByCode(String code) {
        return sahamList.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public boolean removeSaham(String code) {
        return findSahamByCode(code)
                .map(sahamList::remove)
                .orElse(false);
    }

    public List<SuratBerhargaNegara> getAllSBN() {
        return sbnList;
    }

    public void addSBN(SuratBerhargaNegara sbn) {
        sbnList.add(sbn);
    }

    public Optional<SuratBerhargaNegara> findSBNByName(String name) {
        return sbnList.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public boolean removeSBN(String name) {
        return findSBNByName(name)
                .map(sbnList::remove)
                .orElse(false);
    }
}
