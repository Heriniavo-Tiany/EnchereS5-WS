package com.enchere.model;

public class User {
    String id;
    String email;
    String mdp;

    public User() {
    }

    public User(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public User(String id, String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
        this.id = id;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMdp() {
        return this.mdp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
