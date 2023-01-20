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

    @Autowired
    ProduitRepository produitRepository;

    @RequestMapping(value = "/rechercheavance", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin
    public Object rechecheavance(
            @RequestParam(value = "motcle") String motcle,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "categorie") String categorie,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "prixminimal") String prixminimal) {
                String requete = "SELECT * FROM v_enchere where 1=1 and ";
                if (!date.isEmpty()) {
                    requete = requete+" dateheure = '" + date + "' and ";
                }
                if (!categorie.isEmpty()) {
                    requete = requete+" idcategoriesenchere = '" + categorie +"' and ";
                }
                if (!status.isEmpty()) {
                    requete = requete+" status = '" + status +"' and ";
                }
                if (!prixminimal.isEmpty()) {
                    requete = requete+" prix_minimal = '" + prixminimal+ "' and ";
                }
                requete = requete+" 1=1";

        List<Enchere> encheres = jdbcTemplate.query(
                requete,
                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                        rs.getString("idcategoriesenchere"),
                        rs.getString("idutilisateur"),
                        rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                        rs.getDouble("prix_minimal"),
                        rs.getInt("duree"),
                        rs.getDouble("prixfinal"), rs.getString("idgagnant")));
        List<Enchere> listeEnchere = new ArrayList<Enchere>();
        for (Enchere e : encheres) {
            e.setProduit(produitRepository.findById(e.getIdproduit()));
            if (e.getProduit().isPresent()) {
                if ((e.getProduit().get().getNom().contains(motcle))) {
                    listeEnchere.add(e);
                }
            }
        }
        return requete;
    }
}
