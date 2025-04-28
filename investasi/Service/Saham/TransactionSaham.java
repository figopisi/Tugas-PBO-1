package Service.Saham;

import Model.Saham;
import Repository.ProdukRepository;
import Service.PortofolioService;
import Util.InputHelper;

import java.util.Optional;

public class TransactionSaham {
    private final PortofolioService portofolioService;
    private final ProdukRepository produkRepository;
    private static final int MAX_QUANTITY = Integer.MAX_VALUE;

    public TransactionSaham(PortofolioService portofolioService) {
        this.portofolioService = portofolioService;
        this.produkRepository = ProdukRepository.getInstance();
    }

    public void buySaham() {
        System.out.println("\n==============================================");
        System.out.println("|                BELI SAHAM                  |");
        System.out.println("==============================================");
        String code = InputHelper.readString("Masukkan kode saham yang ingin dibeli: ");
        Optional<Saham> optionalSaham = produkRepository.findSahamByCode(code);

        if (optionalSaham.isPresent()) {
            int quantity = InputHelper.readInt("Masukkan jumlah saham yang ingin dibeli: ", 1, MAX_QUANTITY);
            portofolioService.addSahamToPortfolio(optionalSaham.get(), quantity);
            System.out.println("Berhasil membeli saham.");
        } else {
            System.out.println("Kode saham tidak ditemukan.");
        }
    }

    public void sellSaham() {
        System.out.println("\n==============================================");
        System.out.println("|                JUAL SAHAM                  |");
        System.out.println("==============================================");
        String code = InputHelper.readString("Masukkan kode saham yang ingin dijual: ");
        Optional<Saham> optionalSaham = produkRepository.findSahamByCode(code);

        if (optionalSaham.isPresent()) {
            int quantity = InputHelper.readInt("Masukkan jumlah saham yang ingin dijual: ", 1, MAX_QUANTITY);
            boolean success = portofolioService.removeSahamFromPortfolio(optionalSaham.get(), quantity);

            if (success) {
                System.out.println("Berhasil menjual saham.");
            } else {
                System.out.println("Gagal menjual saham. Cek jumlah kepemilikan anda.");
            }
        } else {
            System.out.println("Kode saham tidak ditemukan.");
        }
    }
}
