package br.com.fatec.n2_poo_pokemenu.util;

import java.util.List;

public interface dao {
    public void insert(Object o);
    public void update(Object o);
    public void delete(Object o);
    public Object select(int i);
    public List select();
}
