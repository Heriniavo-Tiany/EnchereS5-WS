package com.enchere.controller;

import java.util.List;

import com.enchere.model.*;
import com.enchere.model.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class RenchereApplication {

    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/Rencheres")
    public List<Renchere> getAll(@RequestParam(value = "idenchere") String idenchere) {

        String query = String.format("SELECT * FROM rencherir WHERE idrencherir = '%s' ",
                idenchere);
        return jdbc.query(
                query,
                (rs, rowNum) -> new Renchere(rs.getString("idrencherir"), rs.getString("idenchere"),
                        rs.getString("idutilisateur"),
                        rs.getFloat("prix_mise_enchere"), rs.getTimestamp("date_heure")));

    }

    @RequestMapping(value = "/NewRenchere", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object insert(
            @RequestParam(value = "idenchere") String idenchere,
            @RequestParam(value = "iduser") String iduser,
            @RequestParam(value = "prix") String prix) {
        Object val = null;
        try {
            String sql = String.format("SELECT max(prix_mise_enchere) as max from rencherir where idenchere= '%s'",
                    idenchere);
            List<Object> max = jdbc.query(sql, (rs, row) -> rs.getFloat("max"));

            if (Float.parseFloat(prix) <= Float.parseFloat(max.get(0).toString())) {
                val = new Error(007, "Votre mise est insuffisante");
            } else {
                String query = String.format(
                        "INSERT INTO rencherir VALUES ( concat('R', nextval('seq_rencherir')), '%s', '%s', '%s',now())",
                        idenchere, iduser, prix);
                jdbc.batchUpdate(query);
                val = "Mise insérer";
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return val;
    }

    @PostMapping("/deleteRenchere")
    public Object delete(@RequestParam(value = "idrencherir") String idrencherir,
            @RequestParam(value = "idenchere") String idenchere) {
        Object val = null;
        String sql = String.format(
                "select max(prix_mise_enchere) from rencherir where idenchere='%s' and idrencherir not like '%s'",
                idenchere, idrencherir);
        List<Object> obj = jdbc.query(sql, (rs, row) -> rs.getFloat("max"));
        float max = Float.parseFloat(obj.get(0).toString());

        String sql2 = String.format(
                "select prix_mise_enchere as prix from rencherir where idenchere='%s' and idrencherir ='%s'", idenchere,
                idrencherir);
        List<Object> obj1 = jdbc.query(sql2, (rs, row) -> rs.getFloat("prix"));
        float prix = Float.parseFloat(obj1.get(0).toString());
        System.out.println("max : " + max);
        System.out.println("prix : " + prix);

        if (max < prix) {
            String query = String.format("DELETE FROM rencherir WHERE idrencherir='%s'", idrencherir);
            if (jdbc.batchUpdate(query)[0] != 0)
                val = "Renchere Supprimer ";
            else
                val = new Error(1312, "un probleme est survenu");
        } else {
            val = new Error(1011, "Quelqu'un a déjà sur-encheri, votre renchere ne peut plus être supprimer");
        }
        return val;
    }
}
