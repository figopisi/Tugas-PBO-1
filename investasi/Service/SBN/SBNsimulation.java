package Service.SBN;

import Model.SuratBerhargaNegara;
import util.InputHelper;
import java.util.List;

public class SBNsimulation {
    public void simulateSBNList(List<SuratBerhargaNegara> sbnList) {
        if (sbnList.isEmpty()) {
            System.out.println("Tidak ada SBN untuk disimulasikan.");
            return;
        }

        System.out.println("\nDaftar SBN yang tersedia:");
        for (int i = 0; i < sbnList.size(); i++) {
            System.out.println((i + 1) + ". " + sbnList.get(i));
        }

        int choice = InputHelper.readInt("Pilih SBN untuk simulasi (1-" + sbnList.size() + "): ", 1, sbnList.size());
        SuratBerhargaNegara selectedSBN = sbnList.get(choice - 1);

        double investmentAmount = InputHelper.readDouble("Masukkan jumlah investasi: ");
        double interestRate = selectedSBN.getInterestRate();
        int duration = selectedSBN.getDuration();

        double investmentResult = investmentAmount + (investmentAmount * interestRate / 100 * duration / 12);

        System.out.println("\n============================");
        System.out.println("|        SIMULASI SBN       |");
        System.out.println("============================");
        System.out.println("SBN yang dipilih: " + selectedSBN.getName());
        System.out.println("Jumlah Investasi: Rp " + investmentAmount);
        System.out.println("Bunga: " + interestRate + "% per tahun");
        System.out.println("Durasi: " + duration + " bulan");
        System.out.println("Hasil Investasi setelah " + duration + " bulan: Rp " + investmentResult);
        System.out.println("============================");
    }
}
