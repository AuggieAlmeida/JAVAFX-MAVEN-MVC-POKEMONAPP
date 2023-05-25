package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;
import br.com.fatec.n2_poo_pokemenu.model.dao.IcrudDAO;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;

import java.util.List;

public interface ItrainerDAO extends IcrudDAO<trainer> {

    List<trainer> selectAllTrainers();

    void findByLogin(String email, String password);
}
