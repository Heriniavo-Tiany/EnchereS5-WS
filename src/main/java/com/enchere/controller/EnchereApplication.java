package com.enchere.controller;

import javax.servlet.http.HttpServletRequest;
//import javax.xml.ws.RequestWrapper;
import com.enchere.mongoDB.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import com.enchere.model.*;

//import javafx.scene.chart.ValueAxis;

@RestController
public class EnchereApplication {

        @Autowired
        JdbcTemplate jdbc;

        @Autowired
        ProduitRepository produitRepository;

        @GetMapping("/Encheres")
        @CrossOrigin
        public List<Enchere> getAll() {
                List<Enchere> encheres = jdbc.query(
                                "SELECT * FROM enchere",
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                ProduitController produitController = new ProduitController();
                for (Enchere e : encheres) {
                        System.out.println(e.getIdproduit());
                        System.out.println(produitRepository.findById(e.getIdproduit()));
                        e.setProduit(produitRepository.findById(e.getIdproduit()));
                }
                return encheres;
        }

        @GetMapping("/Enchere")
        public Enchere get(@RequestParam(value = "idenchere") String idenchere) {
                String query = String.format("SELECT * FROM enchere WHERE idenchere = '%s' ",
                                idenchere);
                List<Enchere> encheres = new ArrayList<>();
                try {
                        encheres = jdbc.query(
                                        query,
                                        (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                        rs.getString("idcategoriesenchere"),
                                                        rs.getString("idutilisateur"),
                                                        rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                        rs.getDouble("prix_minimal"),
                                                        rs.getInt("duree"),
                                                        rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                        ProduitController produitController = new ProduitController();
                        for (Enchere e : encheres) {
                                System.out.println(e.getIdproduit());
                                System.out.println(produitRepository.findById(e.getIdproduit()));
                                e.setProduit(produitRepository.findById(e.getIdproduit()));
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return encheres.get(0);
        }

        @GetMapping("/EnchereEnCours")
        public List<Enchere> getEnCours() {
                String query = String.format("SELECT * FROM v_enchere WHERE status = '0' ");
                List<Enchere> encheres = new ArrayList<>();
                encheres= jdbc.query(
                                query,
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                                                ProduitController produitController = new ProduitController();
                for (Enchere e :
                        encheres) {
                        System.out.println(e.getIdproduit());
                        System.out.println(produitRepository.findById(e.getIdproduit()));
                        e.setProduit(produitRepository.findById(e.getIdproduit()));
                }
                return encheres;
        }

        @GetMapping("/EnchereFini")
        public List<Enchere> getFini() {
                List<Enchere> encheres = new ArrayList<>();
                String query = String.format("SELECT * FROM v_enchere WHERE status = '1' ");
                encheres = jdbc.query(
                                query,
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                                                for (Enchere e :
                        encheres) {
                        System.out.println(e.getIdproduit());
                        System.out.println(produitRepository.findById(e.getIdproduit()));
                        e.setProduit(produitRepository.findById(e.getIdproduit()));
                }
                return encheres;
        }

        @GetMapping("/PasCommence")
        public List<Enchere> PasCommence() {
                String query = String.format("SELECT * FROM v_enchere WHERE status = '-1'");
                List<Enchere> encheres = new ArrayList<>();
                encheres= jdbc.query(
                                query,
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                                                for (Enchere e :
                        encheres) {
                        System.out.println(e.getIdproduit());
                        System.out.println(produitRepository.findById(e.getIdproduit()));
                        e.setProduit(produitRepository.findById(e.getIdproduit()));
                }
                return encheres;
        }
        @GetMapping("/PasFini")
        @CrossOrigin
        public List<Enchere> PasFini() {
                String query = String.format("SELECT * FROM v_enchere WHERE status = '-1' or status = '0'");
                List<Enchere> encheres = new ArrayList<>();
                encheres= jdbc.query(
                                query,
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
                                                for (Enchere e :
                        encheres) {
                        System.out.println(e.getIdproduit());
                        System.out.println(produitRepository.findById(e.getIdproduit()));
                        e.setProduit(produitRepository.findById(e.getIdproduit()));
                }
                return encheres;
        }

        @RequestMapping(value = "/UpdateEnchere", method = RequestMethod.POST, produces = "application/json")
        @ResponseBody
        public void update(HttpServletRequest request) {
                String idenchere = request.getParameter("idenchere");
                String iduser = request.getParameter("idutilisateur");
                String idcategorie = request.getParameter("idcategorie");
                String idproduit = request.getParameter("idproduit");
                String dateheure = request.getParameter("dateheure");
                double prix_minimal = Double.valueOf(request.getParameter("prix_minimal"));
                String prixfinal = request.getParameter("prixfinal");
                int duree = Integer.parseInt(request.getParameter("duree"));
                String idgagnant = request.getParameter("idgagnant");

                String query = String.format(
                                "update enchere set idutilisateur ='%s', idcategoriesenchere='%s', idproduit='%s',dateheure='%s',prix_minimal='%s',prixfinal='%s',duree='%s',idgagnant='%s' where idenchere='%s'",
                                iduser, idcategorie, idproduit, dateheure, prix_minimal, prixfinal, duree, idgagnant,
                                idenchere);
                if (prixfinal.isEmpty() || idgagnant.isEmpty()) {
                        query = String.format(
                                        "update enchere set idutilisateur ='%s', idcategoriesenchere='%s', idproduit='%s',dateheure='%s',prix_minimal='%s',duree='%s' where idenchere='%s'",
                                        iduser, idcategorie, idproduit, dateheure, prix_minimal, duree,
                                        idenchere);
                }
                System.out.println(query);
                jdbc.batchUpdate(query);
        }

        @RequestMapping(value = "/NewEnchere", method = RequestMethod.POST, produces = "application/json")
        @ResponseBody
        public void insert(HttpServletRequest request) {
                String iduser = request.getParameter("idutilisateur");
                String idcategorie = request.getParameter("idcategorie");
                String idproduit = request.getParameter("idproduit");
                String dateheure = request.getParameter("dateheure");
                double prix_minimal = Double.valueOf(request.getParameter("prix_minimal"));

                int duree = Integer.parseInt(request.getParameter("duree"));

                String query = String.format(
                                "insert into enchere values( concat('ECR', nextval('s_enchere')),'%s','%s','%s','%s','%s','%s')",
                                idcategorie, iduser, idproduit, dateheure, prix_minimal, duree);
                System.out.println(query);
                jdbc.batchUpdate(query);
        }

        @GetMapping("/HistoEnchere")
        public List<Enchere> getByIdUser(@RequestParam(value = "iduser") String iduser) {
                String sql = String.format("SELECT * FROM enchere where idutilisateur= '%s'", iduser);
                return jdbc.query(sql,
                                (rs, rowNum) -> new Enchere(rs.getString("idenchere"),
                                                rs.getString("idcategoriesenchere"),
                                                rs.getString("idutilisateur"),
                                                rs.getString("idproduit"), rs.getTimestamp("dateheure"),
                                                rs.getDouble("prix_minimal"),
                                                rs.getInt("duree"),
                                                rs.getDouble("prixfinal"), rs.getString("idgagnant")));
        }

}
