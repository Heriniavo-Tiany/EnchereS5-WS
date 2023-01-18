package com.enchere.controller;

import com.enchere.model.Rechargement;
import com.enchere.mongoDB.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;


    @GetMapping("/produits")
    @CrossOrigin
    public Object getProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    @CrossOrigin
    public Object getProduitById(@PathVariable String id) {
        return produitRepository.findById(id);
    }
}
