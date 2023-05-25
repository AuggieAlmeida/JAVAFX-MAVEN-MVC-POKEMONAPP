package br.com.fatec.n2_poo_pokemenu.model.dao.trainer;

import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public void insert(Object o) { }

    @Override
    public void update(Object o) { }

    @Override
    public void delete(Object o) { }

    @Override
    public Object selectById(int i) { return null; }

    @Override
    public List<trainer> selectAll() {
        return null;
    }

    @Override
    public List<trainer> selectAllTrainers() {
        return null;
    }

    @Override
    public void findByLogin(String email, String password) {
        String sql = "SELECT * FROM trainer WHERE (email=? OR nickname=?) AND password=?";

        System.out.println(getConn() + "\t******************************************");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            //System.out.printf(String.valueOf(result));
        } catch (SQLException err) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, err);
        }

    }

}
