package br.com.fatec.n2_poo_pokemenu.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class databasePostgreSQL implements Idatabase {
    private Connection conn;

    @Override
    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost/pokemondb", "root","root");
            return this.conn;
        } catch (SQLException | ClassNotFoundException err) {
            Logger.getLogger(databasePostgreSQL.class.getName()).log(Level.SEVERE, null, err);
            System.out.println("erro");
            return null;
        }
    }

    @Override
    public void desconnect(Connection connection) {
        try {
            connection.close();
        } catch (SQLException err) {
            Logger.getLogger(databasePostgreSQL.class.getName()).log(Level.SEVERE, null, err);
        }
    }
}
