package br.com.fatec.n2_poo_pokemenu.model.database;

import java.sql.Connection;

public interface Idatabase {

    public Connection connect();

    public void desconnect(Connection conn);
}
