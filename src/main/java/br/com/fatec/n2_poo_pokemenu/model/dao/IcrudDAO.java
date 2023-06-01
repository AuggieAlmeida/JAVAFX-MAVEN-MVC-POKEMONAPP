package br.com.fatec.n2_poo_pokemenu.model.dao;

import java.util.List;

/**
 * Interface de implementação do CRUD utilizando DAO
 * @param <o> Objeto model instanciado para realizar CRUD
 */
public interface IcrudDAO<o> {
    public void insert(Object o);
    public void update(Object o);
    public void delete(Object o);
    public Object selectById(int i);
    public List<o> selectAll();
}
