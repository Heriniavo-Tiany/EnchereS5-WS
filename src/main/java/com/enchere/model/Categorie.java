package com.enchere.model;

public class Categorie {
    String idcategorie;
    String nom;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public Categorie(String id, String nom) {
        this.nom = nom;
        this.idcategorie = id;
    }

    public void setIdcategorie(String id) {
        this.idcategorie = id;
    }

    public String getIdcategorie() {
        return this.idcategorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

}
