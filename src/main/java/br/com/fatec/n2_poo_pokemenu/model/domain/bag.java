package br.com.fatec.n2_poo_pokemenu.model.domain;

import java.io.Serializable;

public class bag implements Serializable {
    private Integer bagId;
    private Integer itemId;
    private Integer trainerId;
    private Integer qtd;
    private String type;
    private String description;

    // Construtor
    public bag(Integer bagId, Integer itemId, Integer trainerId, Integer qtd, String type, String description) {
        this.bagId = bagId;
        this.itemId = itemId;
        this.trainerId = trainerId;
        this.qtd = qtd;
        this.type = type;
        this.description = description;
    }

    // Getters e Setters
    public Integer getBagId() {
        return bagId;
    }

    public void setBagId(Integer bagId) {
        this.bagId = bagId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
