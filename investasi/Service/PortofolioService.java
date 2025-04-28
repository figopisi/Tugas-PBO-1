package Service;

import Model.Saham;
import Model.SuratBerhargaNegara;
import Repository.ProdukRepository;

import java.util.*;

public class PortofolioService {
    private final ProdukRepository productRepository;
    private final Map<Saham, Integer> stockPortfolio;
    private final Map<SuratBerhargaNegara, Double> sbnPortfolio;

    public PortofolioService() {
        this.productRepository = ProdukRepository.getInstance();
        this.stockPortfolio = new HashMap<>();
        this.sbnPortfolio = new HashMap<>();
    }

    public void addStockToPortfolio(Saham stock, int quantity) {
        stockPortfolio.put(stock, stockPortfolio.getOrDefault(stock, 0) + quantity);
    }

    public boolean removeStockFromPortfolio(Saham stock, int quantity) {
        int currentAmount = stockPortfolio.getOrDefault(stock, 0);
        if (currentAmount >= quantity) {
            stockPortfolio.put(stock, currentAmount - quantity);
            return true;
        }
        return false;
    }

    public void addSBNToPortfolio(SuratBerhargaNegara sbn, double nominal) {
        sbnPortfolio.put(sbn, sbnPortfolio.getOrDefault(sbn, 0.0) + nominal);
    }

    public void viewPortfolio() {
        double totalStocks = 0.0;
        double totalSBN = 0.0;
        double totalInterestSBN = 0.0;

        System.out.println("Saham yang dimiliki:");
        for (Map.Entry<Saham, Integer> entry : stockPortfolio.entrySet()) {
            Saham stock = entry.getKey();
            int quantity = entry.getValue();
            double stockPrice = stock.getPrice();
            double totalStockPrice = quantity * stockPrice;
            totalStocks += totalStockPrice;

            System.out.printf("%s - %d lembar @ Rp%.2f (Total: Rp%.2f)\n",
                    stock.getCompanyName(), quantity, stockPrice, totalStockPrice);
        }

        System.out.println("\nSBN yang dimiliki:");
        for (Map.Entry<SuratBerhargaNegara, Double> entry : sbnPortfolio.entrySet()) {
            SuratBerhargaNegara sbn = entry.getKey();
            double nominal = entry.getValue();
            double monthlyInterest = (sbn.getInterestRate() / 100.0) / 12.0 * 0.9 * nominal;
            totalSBN += nominal;
            totalInterestSBN += monthlyInterest;

            System.out.printf("%s - Rp%.2f (Bunga Bulanan: Rp%.2f)\n", sbn.getName(), nominal, monthlyInterest);
        }

        System.out.println("\n==================================");
        System.out.printf("Total Nilai Saham: Rp%.2f\n", totalStocks);
        System.out.printf("Total Nilai SBN: Rp%.2f\n", totalSBN);
        System.out.printf("Total Bunga SBN per bulan: Rp%.2f\n", totalInterestSBN);
        System.out.println("==================================");
    }
}
