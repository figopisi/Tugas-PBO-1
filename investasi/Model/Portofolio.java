package Model;

import java.util.HashMap;
import java.util.Map;

public class Portofolio {
    private final Map<Saham, Integer> sahamHoldings = new HashMap<>();
    private final Map<SuratBerhargaNegara, Double> sbnHoldings = new HashMap<>();

    public Map<Saham, Integer> getSahamHoldings() {
        return sahamHoldings;
    }

    public Map<SuratBerhargaNegara, Double> getSbnHoldings() {
        return sbnHoldings;
    }

    public void buySaham(Saham s, int qty) {
        sahamHoldings.merge(s, qty, Integer::sum);
    }

    public void sellSaham(Saham s, int qty) {
        int current = sahamHoldings.getOrDefault(s, 0);
        if (qty > current) {
            throw new IllegalArgumentException("The quantity to sell exceeds your holdings.");
        }
        if (qty == current) {
            sahamHoldings.remove(s);
        } else {
            sahamHoldings.put(s, current - qty);
        }
    }

    public void buySbn(SuratBerhargaNegara sbn, double nominal) {
        sbnHoldings.merge(sbn, nominal, Double::sum);
        sbn.setNationalQuota(sbn.getNationalQuota() - (long) nominal);
    }
}

