package br.com.fatec.n2_poo_pokemenu.model.domain;
import java.io.Serializable;

public class pokemon implements Serializable {
    private Integer pokeId;
    private Integer attributeId;
    private String name;
    private Float weight;
    private Float height;
    private String evolution;
    private String devolution;

    // Construtor
    public pokemon(Integer pokeId, Integer attributeId, String name, Float weight, Float height, String evolution, String devolution) {
        this.pokeId = pokeId;
        this.attributeId = attributeId;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.evolution = evolution;
        this.devolution = devolution;
    }

    // Getters e Setters
    public Integer getPokeId() {
        return pokeId;
    }

    public void setPokeId(Integer pokeId) {
        this.pokeId = pokeId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public String getDevolution() {
        return devolution;
    }

    public void setDevolution(String devolution) {
        this.devolution = devolution;
    }
}
