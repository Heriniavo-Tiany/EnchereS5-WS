package com.enchere.model;

public class Utilisateur {
    String idUtilisateur;
    String nom;
    String email;
    String contact;
    String motdepasse;
    Double compte;

    public Utilisateur() {
    }

    public Utilisateur(String idUtilisateur, String nom, String email, String contact, String motdepasse, Double compte) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.email = email;
        this.contact = contact;
        this.motdepasse = motdepasse;
        this.compte = compte;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Double getCompte() {
        return compte;
    }

    public void setCompte(Double compte) {
        this.compte = compte;
    }
}
