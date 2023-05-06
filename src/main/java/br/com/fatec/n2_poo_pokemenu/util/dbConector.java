package br.com.fatec.n2_poo_pokemenu.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConector {
    static String url = "jdbc:mysql://localhost/cadastrocliente";
    static String user = "root";
    static String pass = "root";
    static Connection con;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            if(con==null){
                con = (Connection) DriverManager.getConnection(url, user, pass);
            }
            return con;
        } catch (ClassNotFoundException err)  {
            throw new SQLException(err.getMessage());
        }

    }


}
