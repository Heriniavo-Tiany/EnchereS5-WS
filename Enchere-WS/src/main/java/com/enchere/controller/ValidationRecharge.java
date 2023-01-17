package com.enchere.controller;

// import com.enchere.model.Rechargement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ValidationRecharge {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/rechargements", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Object insertUser(
            @RequestParam(value = "admin") String admin,
            @RequestParam(value = "datevalidation") String datevalidation
    ) {
        String query = String.format(
                "INSERT INTO utilisateur(idutilisateur, nom, email, contact, motdepasse) VALUES ( CONCAT('USER', NEXTVAL('seq_utilisateur')),'%s','%s', '%s', sha224('%s'))",
                nom, email, contact, motDePasse);
        jdbcTemplate.batchUpdate(query);
        return "Utilisateur " + nom + " inséré";
    }

}
