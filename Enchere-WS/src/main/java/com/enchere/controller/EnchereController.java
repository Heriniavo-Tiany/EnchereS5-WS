package com.enchere.controller;

// import com.enchere.model.Rechargement;
import com.enchere.model.Statistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EnchereController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/stats/categories")
    @CrossOrigin
    public Object getStatCat() {
        String query = String.format("SELECT * FROM v_statcat ");

        return jdbcTemplate.query(
                query,
                (rs, rowNum) -> new Statistique(rs.getString("idcategoriesenchere"), rs.getString("nom"), rs.getInt("count")));
    }


}
