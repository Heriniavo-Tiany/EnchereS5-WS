package com.enchere.controller;

import com.enchere.model.Rechargement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RechercheControlleur {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/rechercheavance", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin
    public Object rechecheavance(
            @RequestParam(value = "motcle") String motcle,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "categorie") String categorie,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "prixminimal") String prixminimal) {
        String query = String.format("SELECT * FROM v_demanderechargement ");

        return jdbcTemplate.query(
                query,
                (rs, rowNum) -> new Rechargement(rs.getString("idrechargement"), rs.getString("idutilisateur"),
                        rs.getTimestamp("datedemande"), rs.getDouble("compte")));
    }
}
