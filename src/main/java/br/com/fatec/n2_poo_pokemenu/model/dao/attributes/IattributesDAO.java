package br.com.fatec.n2_poo_pokemenu.model.dao.attributes;

import br.com.fatec.n2_poo_pokemenu.model.domain.attributes;

import java.util.List;

public interface IattributesDAO {
    void saveAttributes(attributes att);
    void updateAttributes(attributes att);
    void deleteAttributes(attributes att);
    attributes getAttributesById(int attributeId);
    List<attributes> getAllAttributes();
}
