package br.com.fatec.n2_poo_pokemenu.model.dao.bag;

import br.com.fatec.n2_poo_pokemenu.model.domain.bag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bagDAO implements IbagDAO {
    private Map<Integer, bag> bags;

    public bagDAO() {
        bags = new HashMap<>();
    }

    @Override
    public void saveBag(bag bag) {
        bags.put(bag.getBagId(), bag);
    }

    @Override
    public void updateBag(bag bag) {
        bags.put(bag.getBagId(), bag);
    }

    @Override
    public void deleteBag(bag bag) {
        bags.remove(bag.getBagId());
    }

    @Override
    public bag getBagById(int bagId) {
        return bags.get(bagId);
    }

    @Override
    public List<bag> getAllBags() {
        return new ArrayList<>(bags.values());
    }
}
