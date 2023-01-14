package com.enchere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UtilisateurController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/utilisateurs")
    public void insertUser(
            @RequestParam(value = "idUtilisateur") String idUtilisateur,
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "contact") String contact,
            @RequestParam(value = "motDePasse") String motDePasse
    ) {
        String query = String.format(
                "INSERT INTO utilisateur(idUtilisateur, nom, email, contact, motDePasse) VALUES ( CONCAT('USER', NEXTVAL('seq_utilisateur')),'%s','%s','%s', sha224('%s'), %s)",
                idUtilisateur, nom, email, contact, motDePasse);
        jdbcTemplate.batchUpdate(query);
    }
}
