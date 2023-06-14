package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;

import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public interface ItrainerDAO {
    boolean saveTrainer(trainer trainer);
    void updateTrainer(trainer trainer);
    void deleteTrainer();
    trainer getTrainerById(int trainerId);
    List<trainer> selectAllTrainers();
    Boolean findByLogin(String email, String password);

    List<trainer> filteredQuery(String search, String start, String end);
}
