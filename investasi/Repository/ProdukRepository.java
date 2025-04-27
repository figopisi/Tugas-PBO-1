package Repository;

import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;

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

    public List<SuratBerhargaNegara> getAllSBN() {
        return sbnList;
    }

    public void addSBN(SuratBerhargaNegara sbn) {
        sbnList.add(sbn);
    }
}


