package Service.SBN;

import Model.SuratBerhargaNegara;
import Repository.ProdukRepository;
import Service.PortofolioService;
import Util.InputHelper;

import java.util.Optional;

public class BuySBN {
    private final PortofolioService portofolioService;
    private final ProdukRepository produkRepository;
    private static final double MAX_NOMINAL = Double.MAX_VALUE;

    public BuySBN(PortofolioService portofolioService) {
        this.portofolioService = portofolioService;
        this.produkRepository = ProdukRepository.getInstance();
    }

    public void buySBN() {
        System.out.println("\n==============================================");
        System.out.println("|                 BELI SBN                   |");
        System.out.println("==============================================");
        String code = InputHelper.readString("Masukkan kode SBN yang ingin dibeli: ");
        Optional<SuratBerhargaNegara> optionalSBN = produkRepository.findSBNByName(code);

        if (optionalSBN.isPresent()) {
            SuratBerhargaNegara sbn = optionalSBN.get();
            double nominal = InputHelper.readDouble("Masukkan nominal pembelian SBN: ");

            if (nominal > sbn.getNationalQuota()) {
                System.out.println("Nominal pembelian melebihi kuota nasional yang tersedia.");
                return;
            }

            portofolioService.addSBNToPortfolio(sbn, nominal);
            System.out.println("Berhasil membeli SBN.");
        } else {
            System.out.println("Kode SBN tidak ditemukan.");
        }
    }
}
