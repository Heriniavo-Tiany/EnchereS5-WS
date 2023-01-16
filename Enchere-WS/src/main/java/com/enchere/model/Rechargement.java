package com.enchere.model;

import java.sql.Timestamp;

public class Rechargement {
    String idRechargement;
    String idUser;
    String idAdmin;
    Timestamp dateDemande;
    Timestamp dateValidation;
    Double compte;

    public Rechargement() {
    }

    public Rechargement(String idRechargement, String idUser, Timestamp dateDemande, Double compte) {
        this.idRechargement = idRechargement;
        this.idUser = idUser;
        this.dateDemande = dateDemande;
        this.compte = compte;
    }

    public Rechargement(String idRechargement, String idUser, String idAdmin, Timestamp dateDemande, Timestamp dateValidation, Double compte) {
        this.idRechargement = idRechargement;
        this.idUser = idUser;
        this.idAdmin = idAdmin;
        this.dateDemande = dateDemande;
        this.dateValidation = dateValidation;
        this.compte = compte;
    }

    public String getIdRechargement() {
        return idRechargement;
    }

    public void setIdRechargement(String idRechargement) {
        this.idRechargement = idRechargement;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Timestamp getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Timestamp dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Timestamp getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Timestamp dateValidation) {
        this.dateValidation = dateValidation;
    }

    public Double getCompte() {
        return compte;
    }

    public void setCompte(Double compte) {
        this.compte = compte;
    }
}
