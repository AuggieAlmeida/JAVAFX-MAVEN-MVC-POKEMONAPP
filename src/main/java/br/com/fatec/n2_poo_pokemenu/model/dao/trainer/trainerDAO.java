package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;

import br.com.fatec.n2_poo_pokemenu.controller.registerController;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class trainerDAO implements ItrainerDAO {
    private Connection conn;
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection connection) {
        this.conn = connection;
    }

    private trainer t = null;

    /**
     * Autenticação de conta
     *
     * @param email    Email ou nickname do usuário
     * @param password Senha do usuário
     * @return
     */
    @Override
    public Boolean findByLogin(String email, String password) {
        String sql = "SELECT * FROM trainer WHERE (email=? OR nickname=?) AND password=?";

        System.out.println(getConn() + "\t******************************************");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, email);
            ps.setString(3, password);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException err) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return false;
    }

    @Override
    public boolean saveTrainer(trainer t) {
        String sql = "INSERT INTO trainer(name, nickname, email, password, age, gender, money, date) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getNickname());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getPassword());
            ps.setInt(5, t.getAge());
            ps.setString(6, t.getGender());
            ps.setDouble(7, t.getMoney());
            ps.setDate(8, Date.valueOf(t.getDate()));

            ps.execute();
            return true;
        } catch (SQLException err) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, err);
            return false;
        }
    }

    @Override
    public void updateTrainer(trainer trainer) {

    }

    @Override
    public void deleteTrainer(trainer trainer) {

    }

    @Override
    public trainer getTrainerById(int trainerId) {
        return null;
    }


    @Override
    public List<trainer> selectAllTrainers() {
        return null;
    }
}
