package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;

import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;

import java.util.List;

public interface ItrainerDAO {
    boolean saveTrainer(trainer trainer);
    void updateTrainer(trainer trainer);
    void deleteTrainer(trainer trainer);
    trainer getTrainerById(int trainerId);
    List<trainer> selectAllTrainers();
    Boolean findByLogin(String email, String password);
}
