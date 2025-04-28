package Service.Saham;

import Model.Saham;
import Repository.ProdukRepository;
import Util.InputHelper;

import java.util.List;
import java.util.Optional;

public class SahamService {
    private final ProdukRepository repo = ProdukRepository.getInstance();

    public List<Saham> getAllSaham() {
        return repo.getAllSaham();
    }

    public void addSaham() {
        System.out.println("\n============================================");
        System.out.println("|            TAMBAH SAHAM BARU              |");
        System.out.println("============================================");

        String code = InputHelper.readString("Kode Saham: ");
        String name = InputHelper.readString("Nama Saham: ");
        double price = InputHelper.readDouble("Harga Saham: ");

        Saham saham = new Saham(code, name, price);
        repo.addSaham(saham);
        System.out.println("Saham berhasil ditambahkan!");
    }

    public void updatePrice() {
        System.out.println("\n============================================");
        System.out.println("|            UBAH HARGA SAHAM               |");
        System.out.println("============================================");

        String code = InputHelper.readString("Masukkan Kode Saham: ");
        double newPrice = InputHelper.readDouble("Masukkan Harga Baru: ");

        Optional<Saham> opt = repo.findSahamByCode(code);
        if (opt.isPresent()) {
            opt.get().setPrice(newPrice);
            System.out.println("Harga saham berhasil diperbarui.");
        } else {
            System.out.println("Kode saham tidak ditemukan.");
        }
    }

    public void removeSaham() {
        System.out.println("\n============================================");
        System.out.println("|            HAPUS SAHAM                    |");
        System.out.println("============================================");

        String code = InputHelper.readString("Masukkan Kode Saham yang ingin dihapus: ");
        boolean success = repo.removeSaham(code);

        if (success) {
            System.out.println("Saham berhasil dihapus.");
        } else {
            System.out.println("Kode saham tidak ditemukan.");
        }
    }
}
