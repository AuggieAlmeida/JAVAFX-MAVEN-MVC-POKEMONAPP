package br.com.fatec.n2_poo_pokemenu.model.domain;

import java.io.Serializable;
import java.util.Date;

public class trainer implements Serializable {
    private Integer trainerId;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private int age;
    private Boolean gender;
    private Double money;
    private Date date;

    // Construtor
    public trainer(Integer trainerId, String name, String nickname, String email, String password, int age, Boolean gender, Double money, Date date) {
        this.trainerId = trainerId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.date = date;
    }


    // Getters e Setters
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return nickname;
    }

    public void setSecondName(String secondName) {
        this.nickname = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    // Função override de Serializable, confere objeto trainer é um modelo de trainer ou igual outro trainer
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof trainer T)) {
            return false;
        }

        if(this.trainerId == null || T.trainerId == null) return false;

        return T.trainerId.equals(this.trainerId);
    }

    // Função override de Serializable, converte Trainer em String
    @Override
    public String toString() {
        return "Trainer [id=" + trainerId + ", name =" + name + nickname + ", email =" + email + ", password =" + password + ", idade ="
                + age + ", Gênero =" + gender + ", Dinheiro =" + money + ", Registrado em =" + date + "]";
    }
}
