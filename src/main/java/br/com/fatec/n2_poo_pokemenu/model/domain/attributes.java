package br.com.fatec.n2_poo_pokemenu.model.domain;
import java.io.Serializable;

public class attributes implements Serializable {
    private Integer attributeId;
    private String name;
    private String halfdmg;
    private String halfatk;
    private String doubledmg;
    private String doubleatk;
    private String nodmg;
    private String noatk;

    // Construtor
    public attributes(Integer attributeId, String name, String halfdmg, String halfatk, String doubledmg, String doubleatk, String nodmg, String noatk) {
        this.attributeId = attributeId;
        this.name = name;
        this.halfdmg = halfdmg;
        this.halfatk = halfatk;
        this.doubledmg = doubledmg;
        this.doubleatk = doubleatk;
        this.nodmg = nodmg;
        this.noatk = noatk;
    }

    // Getters e Setters
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

    public String getHalfdmg() {
        return halfdmg;
    }

    public void setHalfdmg(String halfdmg) {
        this.halfdmg = halfdmg;
    }

    public String getHalfatk() {
        return halfatk;
    }

    public void setHalfatk(String halfatk) {
        this.halfatk = halfatk;
    }

    public String getDoubledmg() {
        return doubledmg;
    }

    public void setDoubledmg(String doubledmg) {
        this.doubledmg = doubledmg;
    }

    public String getDoubleatk() {
        return doubleatk;
    }

    public void setDoubleatk(String doubleatk) {
        this.doubleatk = doubleatk;
    }

    public String getNodmg() {
        return nodmg;
    }

    public void setNodmg(String nodmg) {
        this.nodmg = nodmg;
    }

    public String getNoatk() {
        return noatk;
    }

    public void setNoatk(String noatk) {
        this.noatk = noatk;
    }
}
