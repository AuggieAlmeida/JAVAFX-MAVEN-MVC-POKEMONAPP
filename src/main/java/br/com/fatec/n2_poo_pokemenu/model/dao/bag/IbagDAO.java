package br.com.fatec.n2_poo_pokemenu.model.dao.bag;
import br.com.fatec.n2_poo_pokemenu.model.domain.bag;

import java.util.List;

public interface IbagDAO {
    void saveBag(bag bag);
    void updateBag(bag bag);
    void deleteBag(bag bag);
    bag getBagById(int bagId);
    List<bag> getAllBags();
}
