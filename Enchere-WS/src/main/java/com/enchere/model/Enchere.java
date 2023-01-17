package com.enchere.model;

import java.security.Timestamp;

public class Enchere {
    String idenchere;
    String idcategoriesenchere;
    String idutilisateur;
    String idproduit;
    Timestamp dateheure;
    double prix_minimal;
    int duree;
    double prixFinal;
    String idGagnant;

    public Enchere(String idenchere,String idcategoriesenchere, String idutilisateur, String idproduit,
            Timestamp dateheure, double prix_minimal, int duree, double prixFinal, String idGagnant) {
        this.idenchere = idenchere;
        this.idcategoriesenchere = idcategoriesenchere;
        this.idutilisateur = idutilisateur;
        this.idproduit = idproduit;
        this.dateheure = dateheure;
        this.prix_minimal = prix_minimal;
        this.duree = duree;
        this.prixFinal = prixFinal;
        this.idGagnant = idGagnant;
    }

    public Enchere(String idenchere, String idcategoriesenchere, String idutilisateur, String idproduit,
            Timestamp dateheure, double prix_minimal, int duree) {
        this.idenchere = idenchere;
        this.idcategoriesenchere = idcategoriesenchere;
        this.idutilisateur = idutilisateur;
        this.idproduit = idproduit;
        this.dateheure = dateheure;
        this.prix_minimal = prix_minimal;
        this.duree = duree;
    }

    public String getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(String idenchere) {
        this.idenchere = idenchere;
    }

    public String getIdcategoriesenchere() {
        return idcategoriesenchere;
    }

    public void setIdcategoriesenchere(String idcategoriesenchere) {
        this.idcategoriesenchere = idcategoriesenchere;
    }

    public String getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(String idproduit) {
        this.idproduit = idproduit;
    }

    public Timestamp getDateheure() {
        return dateheure;
    }

    public void setDateheure(Timestamp dateheure) {
        this.dateheure = dateheure;
    }

    public double getPrix_minimal() {
        return prix_minimal;
    }

    public void setPrix_minimal(double prix_minimal) {
        this.prix_minimal = prix_minimal;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }

    public String getIdGagnant() {
        return idGagnant;
    }

    public void setIdGagnant(String idGagnant) {
        this.idGagnant = idGagnant;
    }

}
