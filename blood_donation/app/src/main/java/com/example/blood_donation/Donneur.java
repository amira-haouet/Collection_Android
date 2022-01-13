package com.example.blood_donation;

public class Donneur {
    String nom, groupe;
    Integer id, etat;

    public Donneur(Integer id, String nom, String groupe, Integer etat) {
        this.nom = nom;
        this.groupe = groupe;
        this.etat = etat;
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getGroupe() {
        return groupe;
    }

    public Integer getEtat() {
        return etat;
    }

    public Integer getId() {
        return id;
    }
}