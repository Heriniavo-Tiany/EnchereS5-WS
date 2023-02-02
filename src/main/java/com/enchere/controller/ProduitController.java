package com.enchere.controller;

import com.enchere.model.Error;
import com.enchere.model.Produit;
import com.enchere.model.Rechargement;
import com.enchere.model.User;
import com.enchere.mongoDB.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/produits", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Object insertProduit(
            @RequestParam(value = "idproduit") String idproduit,
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "categorie") String categorie,
            @RequestParam(value = "description") String description
    ) {
        Produit produit = new Produit();
        produit.setIdproduit(idproduit);
        produit.setNom(nom);
        produit.setCategorie(categorie);
        produit.setDescription(description);
        return produitRepository.insert(produit);
    }

}
