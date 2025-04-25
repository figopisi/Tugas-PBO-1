package Service;

import Model.User;
import Model.Portofolio;
import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.HashMap;
import java.util.Map;

/**
 * Service for managing investment portfolios,
 * using the View.Login.User class as the User entity.
 */

public class PortofolioService {
    private final Map<User, Portofolio> data = new HashMap<>();
    private final SahamService sahamSvc = new SahamService();
    private final SBNService sbnSvc   = new SBNService();

    private Portofolio getOrCreate(User user) {
        return data.computeIfAbsent(user, u -> new Portofolio());
    }

    // --- Saham ---
    public void buySaham(User user, String kode, int qty) {
        Saham s = sahamSvc.findByCode(kode)
                .orElseThrow(() -> new IllegalArgumentException("Saham Code is not found."));
        getOrCreate(user).buySaham(s, qty);
    }

    public void sellSaham(User user, String kode, int qty) {
        Saham s = sahamSvc.findByCode(kode)
                .orElseThrow(() -> new IllegalArgumentException("Saham Code is not found."));
        getOrCreate(user).sellSaham(s, qty);
    }

    // --- SBN ---
    public void buySBN(User user, String nama, double nominal) {
        SuratBerhargaNegara sbn = sbnSvc.findByName(nama)
                .orElseThrow(() -> new IllegalArgumentException("SBN Name is not found."));
        if (sbn.getNationalQuota() < (long) nominal) {
            throw new IllegalArgumentException("Kuota nasional tidak mencukupi.");
        }
        getOrCreate(user).buySbn(sbn, nominal);
    }

    /**
     * Simulates the monthly coupon: (interest rate % / 100) / 12 * 0.9 * nominal value
     */
    public double simulateSBN(String nama, double nominal) {
        SuratBerhargaNegara sbn = sbnSvc.findByName(nama)
                .orElseThrow(() -> new IllegalArgumentException("SBN Name is not found."));
        return (sbn.getInterestRate() / 100.0) / 12.0 * 0.9 * nominal;
    }

    // --- Portofolio View ---
    public Portofolio getPortofolio(User user) {
        return getOrCreate(user);
    }
}
