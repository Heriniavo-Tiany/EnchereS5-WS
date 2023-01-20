package com.enchere.model;

public class Statistique {
    String idCategorie;
    String nom;
    int nb;

    double somme;

    public Statistique() {
    }

    public Statistique(double somme) {
        this.somme = somme;
    }

    public Statistique(String idCategorie, String nom, int nb) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.nb = nb;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}
