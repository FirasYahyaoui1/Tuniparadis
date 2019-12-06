package com.example.tuniparadis;

public class User {
    private String nom;
    private String prenom;
    private String email;
    private String ville;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public User(String nom, String prenom, String email, String ville, String numro, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ville = ville;
        this.numro = numro;
        this.mot_de_passe = mot_de_passe;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNumro() {
        return numro;
    }

    public void setNumro(String numro) {
        this.numro = numro;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    private String numro;
    private String mot_de_passe;

    public User(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){

    }

}
