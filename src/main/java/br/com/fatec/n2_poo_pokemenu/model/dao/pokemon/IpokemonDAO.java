package br.com.fatec.n2_poo_pokemenu.model.dao.pokemon;

import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;

import java.util.List;

public interface IpokemonDAO {
    void savePokemon(pokemon pok);
    void updatePokemon(pokemon pok);
    void deletePokemon(pokemon pok);
    pokemon getPokemonById(int pokeId);
    List<pokemon> getAllPokemon();
}
