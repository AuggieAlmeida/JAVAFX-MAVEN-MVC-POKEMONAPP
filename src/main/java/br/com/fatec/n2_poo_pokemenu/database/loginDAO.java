package br.com.fatec.n2_poo_pokemenu.database;

import br.com.fatec.n2_poo_pokemenu.model.loginModel;
import br.com.fatec.n2_poo_pokemenu.util.dao;
import br.com.fatec.n2_poo_pokemenu.util.dbConector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class loginDAO implements dao {

    @Override
    public void insert(Object o) {
        loginModel log = (loginModel) o;
        String sql = "INSERT INTO ";
        try {
            PreparedStatement ps = dbConector.getConnection().prepareStatement(sql);
            ps.setString(1, log.getName());
            ps.setString(2, log.getSecondName());
            ps.setInt(3, log.getAge());
            ps.setBoolean(4, log.getGender());
            ps.setDouble(5, log.getMoney());
            ps.setDate(6, (Date) log.getDate());

            ps.execute();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object select(int i) {
        return null;
    }

    @Override
    public List select() {
        return null;
    }
}
