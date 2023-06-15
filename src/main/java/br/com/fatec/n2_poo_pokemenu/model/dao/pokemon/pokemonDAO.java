package br.com.fatec.n2_poo_pokemenu.model.dao.pokemon;

import br.com.fatec.n2_poo_pokemenu.model.dao.attributes.IattributesDAO;
import br.com.fatec.n2_poo_pokemenu.model.dao.trainer.trainerDAO;
import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;
import br.com.fatec.n2_poo_pokemenu.model.domain.trainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pokemonDAO implements IpokemonDAO {
    private Connection conn;
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection connection) {
        this.conn = connection;
    }

    private static final int MAX_POKEMONS = 6;
    private static final String PROPERTY_KEY = "pokemonList";

    private final ObjectMapper objectMapper;

    public pokemonDAO() {
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public void savePokemon(pokemon pok) {
        List<String> pokemonList = getPokemonList();
        if (pokemonList.size() < MAX_POKEMONS) {
            pokemonList.add(pok.getName());
            setPokemonList(pokemonList);
        } else {
            System.out.println("O limite máximo de pokémons foi atingido. Não é possível adicionar mais pokémons.");
        }
    }

    public void removePokemonFromList(String pokemonName) {
        List<String> pokemonList = getPokemonList();
        if (pokemonList.contains(pokemonName)) {
            pokemonList.remove(pokemonName);
            setPokemonList(pokemonList);
        } else {
            System.out.println("O pokémon " + pokemonName + " não existe na lista.");
        }
    }

    public List<String> getPokemonList() {
        String pokemonListString = System.getProperty(PROPERTY_KEY);
        if (pokemonListString != null && !pokemonListString.isEmpty()) {
            try {
                String[] pokemonNamesArray = objectMapper.readValue(pokemonListString, String[].class);
                return new ArrayList<>(Arrays.asList(pokemonNamesArray));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }


    private void setPokemonList(List<String> pokemonList) {
        try {
            String pokemonListString = objectMapper.writeValueAsString(pokemonList);
            System.setProperty(PROPERTY_KEY, pokemonListString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updatePokemon(pokemon pok) {

    }

    @Override
    public void deletePokemon(pokemon pok) {
    }

    @Override
    public pokemon getPokemonById(int pokeId) {
        return null;
    }

    @Override
    public List<pokemon> searchPokemon(String search) {
        String sql = "SELECT * FROM pokemon WHERE name LIKE ?";
        List<pokemon> pokemons = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" +search + "%");

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                pokemon p = new pokemon(result.getInt("pokeId"), result.getString("name"), result.getFloat("weight"), result.getFloat("height"), new String[]{result.getString("types")});
                pokemons.add(p);
            }
            return pokemons;
        } catch (SQLException ex) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<pokemon> getAllPokemon() {
        String sql = "SELECT * FROM pokemon";
        List<pokemon> pokemons = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                pokemon p = new pokemon(result.getInt("pokeId"), result.getString("name"), result.getFloat("weight"), result.getFloat("height"), new String[]{result.getString("types")});
                pokemons.add(p);
            }
            return pokemons;
        } catch (SQLException ex) {
            Logger.getLogger(trainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
