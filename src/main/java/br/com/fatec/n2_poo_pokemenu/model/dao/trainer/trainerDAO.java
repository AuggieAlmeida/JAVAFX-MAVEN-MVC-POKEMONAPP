package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;

import java.sql.*;
import java.util.ArrayList;
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

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, email);
            ps.setString(3, password);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                String key = "logged";
                String property = String.valueOf(result.getInt("trainerId"));
                System.setProperty(key, property);
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
    public void updateTrainer(trainer t) {
        String sql = "UPDATE trainer SET name=?, nickname=?, email=?, age=?, money=? WHERE trainerID=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getNickname());
            ps.setString(3, t.getEmail());
            ps.setInt(4, t.getAge());
            ps.setDouble(5, t.getMoney());
            ps.setInt(6, Integer.parseInt(System.getProperty("logged")));

            ps.execute();
        } catch (SQLException err) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, err);
        }
    }

    @Override
    public void deleteTrainer() {
        String sql = "DELETE FROM trainer WHERE trainerId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(System.getProperty("logged")));
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public trainer getTrainerById(int trainerId) {
        String sql = "SELECT * FROM trainer WHERE trainerId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trainerId);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                trainer t = new trainer(result.getInt("trainerId"), result.getString("name"), result.getString("nickname"), result.getString("email"), result.getString("password"), result.getInt("age"), result.getString("gender"), result.getDouble("money"));
                t.setMoney(result.getDouble("money"));
                t.setDate(result.getDate("date").toLocalDate());
                return t;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<trainer> selectAllTrainers() {
        String sql = "SELECT * FROM trainer";
        List<trainer> trainers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                trainer t = new trainer(result.getInt("trainerId"), result.getString("name"), result.getString("nickname"), result.getString("email"), result.getString("password"), result.getInt("age"), result.getString("gender"), result.getDouble("money"));
                trainers.add(t);
            }
            return trainers;
        } catch (SQLException ex) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<trainer> filteredQuery(String search, String start, String end) {
        String sql = "SELECT * FROM trainer WHERE (name LIKE ? OR nickname LIKE ? OR email LIKE ?) AND (age >= ? AND age <= ?)";
        List<trainer> trainers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setInt(4, Integer.parseInt(start));
            ps.setInt(5, Integer.parseInt(end));

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                trainer t = new trainer(result.getInt("trainerId"), result.getString("name"), result.getString("nickname"), result.getString("email"), result.getString("password"), result.getInt("age"), result.getString("gender"), result.getDouble("money"));
                trainers.add(t);
            }
            return trainers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
