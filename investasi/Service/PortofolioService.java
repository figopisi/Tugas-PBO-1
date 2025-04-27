package Service;

import Model.Saham;
import Model.SuratBerhargaNegara;
import Repository.ProdukRepository;

import java.util.*;

public class PortofolioService {
    private ProdukRepository produkRepository;
    private Map<Saham, Integer> sahamPortfolio;
    private Map<SuratBerhargaNegara, Double> sbnPortfolio;

    public PortofolioService() {
        this.produkRepository = ProdukRepository.getInstance();
        this.sahamPortfolio = new HashMap<>();
        this.sbnPortfolio = new HashMap<>();
    }

    public void addSahamToPortfolio(Saham saham, int jumlah) {
        sahamPortfolio.put(saham, sahamPortfolio.getOrDefault(saham, 0) + jumlah);
    }

    public boolean removeSahamFromPortfolio(Saham saham, int jumlah) {
        int currentAmount = sahamPortfolio.getOrDefault(saham, 0);
        if (currentAmount >= jumlah) {
            sahamPortfolio.put(saham, currentAmount - jumlah);
            return true;
        }
        return false; // jika tidak cukup saham untuk dijual
    }

    public void addSBNToPortfolio(SuratBerhargaNegara sbn, double nominal) {
        sbnPortfolio.put(sbn, sbnPortfolio.getOrDefault(sbn, 0.0) + nominal);
    }

    public void viewPortfolio() {
        double totalSaham = 0.0;
        double totalSBN = 0.0;
        double totalBungaSBN = 0.0;

        // Menampilkan saham yang dimiliki beserta jumlah juga total nominal
        System.out.println("Saham yang dimiliki:");
        for (Map.Entry<Saham, Integer> entry : sahamPortfolio.entrySet()) {
            Saham saham = entry.getKey();
            int jumlah = entry.getValue();
            double hargaSaham = saham.getPrice();
            double totalHargaSaham = jumlah * hargaSaham;
            totalSaham += totalHargaSaham;

            System.out.printf("%s - %d lembar @ Rp%.2f (Total: Rp%.2f)\n",
                    saham.getCompanyName(), jumlah, hargaSaham, totalHargaSaham);
        }

        // Menampilkan SBN yang dimiliki beserta nominal dan bunga
        System.out.println("\nSBN yang dimiliki:");
        for (Map.Entry<SuratBerhargaNegara, Double> entry : sbnPortfolio.entrySet()) {
            SuratBerhargaNegara sbn = entry.getKey();
            double nominal = entry.getValue();
            double bungaBulanan = (sbn.getInterestRate() / 100.0) / 12.0 * 0.9 * nominal;
            totalSBN += nominal;
            totalBungaSBN += bungaBulanan;

            System.out.printf("%s - Rp%.2f (Bunga Bulanan: Rp%.2f)\n", sbn.getName(), nominal, bungaBulanan);
        }

        // Menampilkan total portofolio
        System.out.println("\n==================================");
        System.out.printf("Total Nilai Saham: Rp%.2f\n", totalSaham);
        System.out.printf("Total Nilai SBN: Rp%.2f\n", totalSBN);
        System.out.printf("Total Bunga SBN per bulan: Rp%.2f\n", totalBungaSBN);
        System.out.println("==================================");
    }
}
