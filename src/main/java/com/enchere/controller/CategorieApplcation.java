package com.enchere.controller;

import java.util.List;

import com.enchere.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategorieApplcation {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/CategoriesEnchere")
    @CrossOrigin
    public List<Categorie> getCategories() {
        return jdbc.query(
                "SELECT * FROM categoriesenchere",
                (rs, rowNum) -> new Categorie(rs.getString("idcategorie"), rs.getString("nom")));
    }

    @PostMapping("/NewCategorieEnchere")
    @CrossOrigin
    public void insertCategorie(@RequestParam(value = "nom") String nom) {
        String query = String.format(
                "INSERT INTO categoriesenchere VALUES ( concat('CAT', nextval('s_categorie')), '%s')",
                nom);
        jdbc.batchUpdate(query);
    }

    @GetMapping("/CategorieEnchere")
    public Object getCategorie(@RequestParam(value = "id") String id) {
        String query = String.format("SELECT * FROM categoriesenchere WHERE idcategorie = '%s' ",
                id);
        return jdbc.query(
                query,
                (rs, rowNum) -> new Categorie(rs.getString("idcategorie"), rs.getString("nom")));
    }

    @RequestMapping(value = "/updateCatEnchere", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public void update(@RequestParam(value = "id") String id, @RequestParam(value = "nom") String nom) {
        String query = String.format("update categoriesenchere set nom='%s' where idcategorie='%s'",
                nom, id);
        System.out.println(query);
        jdbc.batchUpdate(query);
    }

    @DeleteMapping("/categories/{id}")
    @CrossOrigin
    public Object deleteCategorie(@PathVariable String id) throws Exception {
        String query = String.format("DELETE FROM categoriesenchere WHERE idcategorie='%s'", id);

        if (jdbc.batchUpdate(query)[0] != 0)
            return "Category " + id + " deleted  successfully";
        else
            throw new Exception("Error on delete category");
    }
}
