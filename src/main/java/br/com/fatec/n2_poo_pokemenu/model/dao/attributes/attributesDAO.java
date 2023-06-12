package br.com.fatec.n2_poo_pokemenu.model.dao.attributes;
import br.com.fatec.n2_poo_pokemenu.model.domain.attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class attributesDAO implements IattributesDAO {
    private Map<Integer, attributes> attributes;

    public attributesDAO() {
        attributes = new HashMap<>();
    }

    @Override
    public void saveAttributes(attributes att) {
    }

    @Override
    public void updateAttributes(attributes att) {
    }

    @Override
    public void deleteAttributes(attributes att) {
    }

    @Override
    public attributes getAttributesById(int attributeId) {
        return attributes.get(attributeId);
    }

    @Override
    public List<attributes> getAllAttributes() {
        return new ArrayList<>(attributes.values());
    }
}

