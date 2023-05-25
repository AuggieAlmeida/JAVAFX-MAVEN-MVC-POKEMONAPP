package br.com.fatec.n2_poo_pokemenu.model.database;

public class databaseFactory {
    public static Idatabase getDatabase(String nome){
        if(nome.equals("mysql")){
            return new databaseMySQL();
        }else if(nome.equals("postgresql")){
            return new databasePostgreSQL();
        }
        return null;
    }
}
