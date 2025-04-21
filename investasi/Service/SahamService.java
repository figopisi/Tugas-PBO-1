package Service;

import Model.Saham;
import Repository.ProdukRepository;

import java.util.List;
import java.util.Optional;

public class SahamService {
    private final ProdukRepository repo = ProdukRepository.getInstance();

    public List<Saham> getAllSaham() {
        return repo.getAllSaham();
    }

    public void addSaham(Saham s) {
        repo.addSaham(s);
    }

    //Update stock price.
    //@return true if the code is found and the price is updated; false otherwise.

    public boolean updatePrice(String code, double newPrice) {
        Optional<Saham> opt = repo.findSahamByCode(code);
        opt.ifPresent(s -> s.setPrice(newPrice));
        return opt.isPresent();
    }

    public boolean removeSaham(String code) {
        return repo.removeSaham(code);
    }

    public Optional<Saham> findByCode(String code) {
        return repo.findSahamByCode(code);
    }
}
