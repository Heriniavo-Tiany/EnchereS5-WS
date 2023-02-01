package com.enchere.controller;

import com.enchere.model.Error;
import com.enchere.model.Rechargement;
import com.enchere.model.User;
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
                "INSERT INTO admin(idadmin, nom, email, contact, motdepasse) VALUES ( CONCAT('ADMIN', NEXTVAL('seq_admin')),'%s','%s', '%s',md5('%s'))",
                nom, email, contact, motDePasse);
        jdbcTemplate.batchUpdate(query);
        return "Admin " + nom + " inséré";
    }

    @GetMapping("/demandeRechargements")
    @CrossOrigin
    public Object getDemandes() {
        String query = String.format("SELECT * FROM v_demanderechargement ");

        return jdbcTemplate.query(
                query,
                (rs, rowNum) -> new Rechargement(rs.getString("idrechargement"), rs.getString("idutilisateur"), rs.getTimestamp("datedemande"), rs.getDouble("compte")));
    }

    @RequestMapping(value = "/loginUtilisateurs", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Object loginUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "mdp") String mdp
    ) {
        String query = String.format("SELECT * FROM utilisateur WHERE email = '%s' and motdepasse = sha224('%s')::varchar",
                email, mdp);
        try {
            return jdbcTemplate.query(
                    query,
                    (rs, rowNum) -> new User(rs.getString("idadmin"), rs.getString("email"),
                            rs.getString("motdepasse")));
        } catch (IndexOutOfBoundsException e) {
            return new Error(404, "Email & Mot de passe non correspondant");
        }

    }


}
