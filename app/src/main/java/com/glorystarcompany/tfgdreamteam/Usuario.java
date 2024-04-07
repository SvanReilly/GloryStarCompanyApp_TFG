package com.glorystarcompany.tfgdreamteam;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String name, password, mail;
    private int wins, defeats, gcAmount;

    public Usuario(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public Usuario(String name, String password, String mail, int wins, int defeats, int gcAmount) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.wins = wins;
        this.defeats = defeats;
        this.gcAmount = gcAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGcAmount() {
        return gcAmount;
    }

    public void setGcAmount(int gcAmount) {
        this.gcAmount = gcAmount;
    }
}


