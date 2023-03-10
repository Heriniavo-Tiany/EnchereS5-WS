CREATE TABLE categoriesenchere
(
    idcategorie VARCHAR(20) PRIMARY KEY,
    nom         varchar(80)
);

INSERT INTO categoriesenchere (IDCATEGORIE, NOM)
VALUES ('1', 'Beaux arts');
INSERT INTO categoriesenchere (IDCATEGORIE, NOM)
VALUES ('2', 'immo');
INSERT INTO categoriesenchere (IDCATEGORIE, NOM)
VALUES ('3', 'voiture');


CREATE TABLE utilisateur
(
    idutilisateur VARCHAR(20) PRIMARY KEY,
    nom           varchar(20),
    email         varchar(50),
    contact       varchar(10),
    motdepasse    varchar,
    compte        float(10) default 0
);

CREATE SEQUENCE seq_utilisateur;

CREATE TABLE admin
(
    idadmin    VARCHAR(20) PRIMARY KEY,
    nom        varchar(20),
    email      varchar(50),
    contact    varchar(10),
    motdepasse varchar
);
insert into admin
VALUES ('1', 'koto', 'koto@gmail.com', '0331216444', 'koto');

CREATE SEQUENCE seq_admin;



INSERT INTO utilisateur (idutilisateur, nom, email, contact, motdepasse, compte)
VALUES ('1', 'rakoto', 'rakoto@gmail.com', '0339934589', 'motdepasse', 1);
INSERT INTO utilisateur (idutilisateur, nom, email, contact, motdepasse, compte)
VALUES ('2', 'rabe', 'rabe@gmail.com', '0323047659', 'motdepasse', 2);
INSERT INTO utilisateur (idutilisateur, nom, email, contact, motdepasse, compte)
VALUES ('3', 'rasoa', 'rasoa@gmail.com', '0389038736', 'motdepasse', 3);
INSERT INTO utilisateur (idutilisateur, nom, email, contact, motdepasse, compte)
VALUES ('4', 'rajao', 'rajao@gmail.com', '0340038367', 'motdepasse', 4);

CREATE TABLE categoriesproduit
(
    idcategorie VARCHAR(20) PRIMARY KEY,
    nom         varchar(20) NOT NULL
);

INSERT INTO categoriesproduit(idcategorie, nom)
VALUES ('1', 'deco');
INSERT INTO categoriesproduit(idcategorie, nom)
VALUES ('2', 'habitation');
INSERT INTO categoriesproduit(idcategorie, nom)
VALUES ('3', 'vehicule');

CREATE TABLE rechargement
(
    idRechargement varchar(10) PRIMARY KEY,
    idUtilisateur  varchar(10) NOT NULL,
    idAdmin        varchar(10),
    dateDemande    timestamp,
    dateValidation timestamp,
    compte         float(10),
    FOREIGN KEY (idUtilisateur) REFERENCES utilisateur (idutilisateur),
    FOREIGN KEY (idAdmin) REFERENCES admin (idadmin)
);
insert into rechargement (idRechargement, idUtilisateur, dateDemande, compte)
VALUES ('rech05', '1', '2023-01-02', '200000'),
       ('rech06', '2', '2023-01-02', '60000000'),
       ('rech07', '3', '2023-01-02', '2500000'),
       ('rech08', '4', '2023-01-02', '210000');

insert into rechargement
values
-- (idrechargement,idUtilisateur,idAdmin,dateDemande,dateValidation,compte),
('rech01', '1', '1', '2023-01-01', '2023-01-04', '100000'),
('rech02', '1', '1', '2023-01-01', '2023-01-04', '200000'),
('rech03', '3', '1', '2023-01-01', '2023-01-04', '500000'),
('rech04', '4', '1', '2023-01-01', '2023-01-04', '1000000');


CREATE VIEW v_demandeRechargement AS
(
select idRechargement, idUtilisateur, dateDemande, compte
FROM rechargement
WHERE idAdmin is NULL
  AND dateValidation is NULL
    );



-- CREATE  TABLE produits (
-- 	idproduit   VARCHAR(20) PRIMARY KEY ,
-- 	nom                  varchar(20) NOT NULL,
-- 	description          varchar(255) NOT NULL,
-- 	idcategoriesproduit    integer  NOT NULL,
-- 	CONSTRAINT fk_categorie FOREIGN KEY(idcategoriesproduit) REFERENCES categoriesproduit(idcategorie)  
--  );

-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('1','tableau picasso','autoportrait a la meche',1);
-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('2','habitation','surface de 3000m2',2);
-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('3','mustang GT','ford mustang GT cabriolet 1968',3);
-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('4','sculpture','Etienne-Maurice Falconet:amoursse disputant un coeur',1);
-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('5','baccarat','paire de salieres en cristal',1);
-- INSERT INTO produits (idproduit,nom,description,idcategoriesproduit) VALUES ('6','bmw','bmw e30 modele 325is imm 1990',3);


-- CREATE  TABLE image ( 
-- 	idimage     VARCHAR(20) PRIMARY KEY ,
-- 	idproduit   integer NOT NULL,
-- 	image                 varchar(50) NOT NULL 
--  );

-- INSERT INTO image(idimage,idproduit,image) VALUES ('1',1,'image');
-- INSERT INTO image(idimage,idproduit,image) VALUES ('2',2,'image');
-- INSERT INTO image(idimage,idproduit,image) VALUES ('3',3,'image');
-- INSERT INTO image(idimage,idproduit,image) VALUES ('4',4,'image');
-- INSERT INTO image(idimage,idproduit,image) VALUES ('5',5,'image');
-- INSERT INTO image(idimage,idproduit,image) VALUES ('6',6,'image');


-----miandry produit izay tokony any anaty mongoDB
CREATE TABLE enchere
(
    idenchere           VARCHAR(20) PRIMARY KEY,
    idcategoriesenchere VARCHAR(20),
    idutilisateur       VARCHAR(20),
    idproduit           VARCHAR,
    dateheure           timestamp,
    prix_minimal        float(10),
    duree               int,
    prixFinal           double precision,
    idGagnant           VARCHAR(20),
    CONSTRAINT fk_enchere_categorie FOREIGN KEY (idcategoriesenchere) REFERENCES categoriesenchere (idcategorie),
    CONSTRAINT fk_enchere_utilisateur FOREIGN KEY (idutilisateur) REFERENCES utilisateur (idutilisateur),
    CONSTRAINT fk_enchere_gagnant FOREIGN KEY (idGagnant) REFERENCES utilisateur (idutilisateur)
);

INSERT INTO enchere(idenchere, idcategoriesenchere, idutilisateur, idproduit, dateheure, prix_minimal, duree, prixFinal,
                    idGagnant)
VALUES ('1', '2', '1', '63c40af0b27b0c6b8128b42b', '2023/5/12 00:00:00', 100, 1324, 3000, 1);
INSERT INTO enchere(idenchere, idcategoriesenchere, idutilisateur, idproduit, dateheure, prix_minimal, duree, prixFinal,
                    idGagnant)
VALUES ('2', '3', '4', '63c40af0b27b0c6b8128b42c', now(), 2000, 324, 2000, 3);
INSERT INTO enchere(idenchere, idcategoriesenchere, idutilisateur, idproduit, dateheure, prix_minimal, duree, prixFinal,
                    idGagnant)
VALUES ('3', '1', '2', '63c40af0b27b0c6b8128b42d', now(), 500, 1224, 10000, 3);

insert into enchere (idenchere, idcategoriesenchere, idutilisateur, idproduit, dateheure, prix_minimal, duree)VALUES
('6', '3','1', '63c40af0b27b0c6b8128b42e',  now(), 300000, 60);

CREATE TABLE rencherir
(
    idrencherir       VARCHAR(20) PRIMARY KEY,
    idenchere         VARCHAR(20),
    idutilisateur     VARCHAR(20),
    prix_mise_enchere float(10),
    date_heure        timestamp default now(),
    Foreign Key (idenchere) REFERENCES Enchere (idenchere),
    foreign Key (idutilisateur) REFERENCES Utilisateur (idutilisateur)
);

INSERT INTO rencherir(idrencherir, idenchere, idutilisateur, prix_mise_enchere, date_heure)
VALUES ('1', '1', '1', '2000', '2023-01-16 20:02:00'),
       ('2', '1', '2', '3000', '2023-01-16 20:02:30'),
       ('3', '1', '1', '4000', '2023-01-16 20:03:00'),
       ('4', '1', '2', '4001', '2023-01-16 20:03:50'),
       ('5', '1', '1', '5000', '2023-01-16 20:04:30');


CREATE VIEW v_statcat AS
(
SELECT e.idcategoriesenchere, c.nom, count(e.idcategoriesenchere)
FROM enchere e
         JOIN categoriesenchere c ON e.idcategoriesenchere = c.idcategorie
GROUP BY e.idcategoriesenchere, c.nom
    );


CREATE VIEW v_enchereTermine AS
SELECT *, dateheure + (duree * INTERVAL '1 minute') as dateheurefin
FROM enchere
WHERE prixFinal IS NOT NULL
  AND idGagnant IS NOT NULL;

CREATE VIEW v_enchere AS
SELECT *,
       dateheure + (duree * INTERVAL '1 minute') as dateheurefin,
       CASE
           WHEN prixFinal IS NOT NULL AND idGagnant IS NOT NULL THEN 1
           WHEN now() < enchere.dateheure THEN -1
           ELSE 0
           END                                   as status
FROM enchere;
select now();



CREATE VIEW v_statSumPerMonth as
(
WITH months AS (SELECT generate_series(1, 12) as mois)
SELECT months.mois, COALESCE(sum(prixFinal), 0) as sum
FROM months
         LEFT JOIN v_enchereTermine
                   ON months.mois = EXTRACT(MONTH FROM v_enchereTermine.dateheurefin)
GROUP BY months.mois
ORDER BY months.mois
);
---anja
-- CREATE or REPLACE view v_encherestatut AS
-- SELECT idenchere,idcategoriesenchere,idutilisateur,idproduit,dateheure,prix_minimal,duree,COALESCE(prixFinal,'0') as prixfinal, COALESCE(idGagnant,'0') idgagnant,
-- CASE WHEN prixFinal is null THEN 0
--     else 1
--     end as status
--  FROM enchere ;
 CREATE SEQUENCE seq_rechargement;

create sequence s_categorie;

create sequence seq_rencherir;

create sequence s_enchere;