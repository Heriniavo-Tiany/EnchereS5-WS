package com.enchere.controller;

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
    public Object updateRechargement(
            @RequestParam(value = "idRechargement") String idRechargement,
            @RequestParam(value = "admin") String admin) {
        String query = String.format(
                "UPDATE rechargement SET idadmin='%s', dateValidation=now() where idRechargement='%s'",
                admin, idRechargement);
        jdbcTemplate.batchUpdate(query);
        return "validation de rechargement inséré effectue";
    }

}
