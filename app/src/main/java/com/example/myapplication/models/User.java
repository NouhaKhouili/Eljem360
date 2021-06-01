package com.example.myapplication.models;

public class User {

    private String nom;
    private String prenom;
    private  String email;
    private String password;
    private String confirmation_de_password;

    public String getConfirmation_de_password() {
        return confirmation_de_password;
    }

    public void setConfirmation_de_password(String confirmation_de_password) {
        this.confirmation_de_password = confirmation_de_password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
}
