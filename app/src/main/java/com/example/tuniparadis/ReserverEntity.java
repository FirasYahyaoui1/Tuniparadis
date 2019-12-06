package com.example.tuniparadis;

public class ReserverEntity {
    private String Durée;
    private String prix;
    private String nom;

    public ReserverEntity(String durée, String nom) {
        Durée = durée;
        this.nom = nom;
    }

    public ReserverEntity(String durée, String prix, String nom) {
        Durée = durée;
        this.prix = prix;
        this.nom = nom;
    }

    public String getDurée() {
        return Durée;
    }

    public void setDurée(String durée) {
        Durée = durée;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
