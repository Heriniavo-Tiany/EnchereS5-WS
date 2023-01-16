package com.enchere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UtilisateurController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/utilisateurs", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Object insertUser(
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "contact") String contact,
            @RequestParam(value = "motDePasse") String motDePasse
    ) {
        String query = String.format(
                "INSERT INTO utilisateur(idutilisateur, nom, email, contact, motdepasse) VALUES ( CONCAT('USER', NEXTVAL('seq_utilisateur')),'%s','%s', '%s', sha224('%s'))",
                nom, email, contact, motDePasse);
        jdbcTemplate.batchUpdate(query);
        return "Utilisateur " + nom + " inséré";
    }

    @RequestMapping(value = "/admins", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Object insertAdmin(
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "contact") String contact,
            @RequestParam(value = "motDePasse") String motDePasse
    ) {
        String query = String.format(
                "INSERT INTO admin(idadmin, nom, email, contact, motdepasse) VALUES ( CONCAT('ADMIN', NEXTVAL('seq_admin')),'%s','%s', '%s', sha224('%s'))",
                nom, email, contact, motDePasse);
        jdbcTemplate.batchUpdate(query);
        return "Admin " + nom + " inséré";
    }
}
