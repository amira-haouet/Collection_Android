package com.example.blood_donation;

public class Donneur {
    Integer id;
    String nom;
    String Groupesanguin;
    Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGroupesanguin() {
        return Groupesanguin;
    }

    public void setGroupesanguin(String groupesanguin) {
        Groupesanguin = groupesanguin;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Donneur(Integer id, String nom, String groupesanguin, Boolean state) {
        this.id = id;
        this.nom = nom;
        Groupesanguin = groupesanguin;
        this.state = state;
    }
}
