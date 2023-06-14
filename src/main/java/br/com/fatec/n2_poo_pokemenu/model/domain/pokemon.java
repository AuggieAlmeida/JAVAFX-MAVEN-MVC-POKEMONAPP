package br.com.fatec.n2_poo_pokemenu.model.domain;

import java.io.Serializable;

public class pokemon implements Serializable {
    private int id;
    private String name;
    private float weight;
    private float height;
    private String[] types;

    public pokemon(int id, String name, float weight, float height, String[] types) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.types = types;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public String[] getTypes() {
        return types;
    }

}
