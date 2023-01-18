package com.enchere.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Renchere {
    String idrencherir;
    String idenchere;
    String iduser;
    float prix;
    Timestamp date;

    public Renchere(String idenchere, String iduser, float prix) {
        this.idenchere = idenchere;
        this.iduser = iduser;
        this.prix = prix;
    }

    public Renchere(String idrencherir, String idenchere, String iduser, float prix, Timestamp date) {
        this.idrencherir = idrencherir;
        this.idenchere = idenchere;
        this.iduser = iduser;
        this.prix = prix;
        this.date = date;
    }

    public String getIdrencherir() {
        return idrencherir;
    }

    public void setIdrencherir(String idrencherir) {
        this.idrencherir = idrencherir;
    }

    public String getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(String idenchere) {
        this.idenchere = idenchere;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
