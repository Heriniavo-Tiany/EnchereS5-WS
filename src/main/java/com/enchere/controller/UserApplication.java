package com.enchere.controller;

import com.enchere.model.*;
import com.enchere.model.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApplication {

    @Autowired
    JdbcTemplate jdbc;

    @PostMapping("/User")
    public Object getUser(@RequestParam(value = "email") String email, @RequestParam(value = "mdp") String mdp) {
        // String query = String.format("SELECT * FROM utilisateur WHERE email = '%s'
        // and motdepasse = md5('%s')::varchar",
        // email, mdp);
        String query = String.format("SELECT * FROM utilisateur WHERE email = '%s' and motdepasse = '%s'",
                email, mdp);
        try {
            return jdbc.query(
                    query,
                    (rs, rowNum) -> new User(rs.getString("idutilisateur"), rs.getString("email"),
                            rs.getString("motdepasse")));
        } catch (IndexOutOfBoundsException e) {
            return new Error(404, "Email & Mot de passe non correspondant");
        }

    }

    @PostMapping("/Admin")
    @CrossOrigin
    public Object getAdmin(@RequestParam(value = "email") String email, @RequestParam(value = "mdp") String mdp) {
        // String query = String.format("SELECT * FROM admin WHERE email = '%s' and
        // motdepasse = md5('%s')::varchar",
        // email, mdp);
        String query = String.format("SELECT * FROM admin WHERE email = '%s' and motdepasse = '%s'",
                email, mdp);

        try {
            return jdbc.query(
                    query,
                    (rs, rowNum) -> new User(rs.getString("idadmin"), rs.getString("email"),
                            rs.getString("motdepasse")));
        } catch (IndexOutOfBoundsException e) {
            return new Error(404, "Email & Mot de passe non correspondant");
        }

    }

}