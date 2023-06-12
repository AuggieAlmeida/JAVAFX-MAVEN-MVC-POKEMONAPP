package br.com.fatec.n2_poo_pokemenu.model.domain;
import java.io.Serializable;

public class party implements Serializable {
    private Integer partyId;
    private Integer trainerId;
    private Integer pokeId;
    private String nickname;
    private Integer level;
    private Integer queuePos;

    // Construtor
    public party(Integer partyId, Integer trainerId, Integer pokeId, String nickname, Integer level, Integer queuePos) {
        this.partyId = partyId;
        this.trainerId = trainerId;
        this.pokeId = pokeId;
        this.nickname = nickname;
        this.level = level;
        this.queuePos = queuePos;
    }

    // Getters e Setters
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getPokeId() {
        return pokeId;
    }

    public void setPokeId(Integer pokeId) {
        this.pokeId = pokeId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getQueuePos() {
        return queuePos;
    }

    public void setQueuePos(Integer queuePos) {
        this.queuePos = queuePos;
    }
}
