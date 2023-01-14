CREATE  TABLE categoriesenchere ( 
	idcategorie   SERIAL PRIMARY KEY,
	nom  varchar(20)    
 );

INSERT INTO categoriesenchere (NOM) VALUES ('Beaux arts');
INSERT INTO categoriesenchere (NOM) VALUES ('immo');
INSERT INTO categoriesenchere (NOM) VALUES ('voiture');


CREATE  TABLE utilisateur ( 
	idutilisateur  SERIAL PRIMARY KEY ,
	nom                  varchar(20)    ,
	email                varchar(50)    ,
	contact              varchar(10)    ,
	motdepasse           varchar(50)    ,
	compte               float(10)    
 );


INSERT INTO utilisateur (nom,email,contact,motdepasse,compte) VALUES('rakoto','rakoto@gmail.com','0339934589','motdepasse',1);
INSERT INTO utilisateur (nom,email,contact,motdepasse,compte) VALUES('rabe','rabe@gmail.com','0323047659','motdepasse',2);
INSERT INTO utilisateur (nom,email,contact,motdepasse,compte) VALUES('rasoa','rasoa@gmail.com','0389038736','motdepasse',3);
INSERT INTO utilisateur (nom,email,contact,motdepasse,compte) VALUES('rajao','rajao@gmail.com','0340038367','motdepasse',4);

	CREATE  TABLE categoriesproduit ( 
		idcategorie          SERIAL PRIMARY KEY ,
		nom                  varchar(20) NOT NULL    
	 );

INSERT INTO categoriesproduit(nom) VALUES('deco');
INSERT INTO categoriesproduit(nom) VALUES('habitation');
INSERT INTO categoriesproduit(nom) VALUES('vehicule');

CREATE  TABLE produits ( 
	idproduit   SERIAL PRIMARY KEY ,
	nom                  varchar(20) NOT NULL,
	description          varchar(255) NOT NULL,
	idcategoriesproduit    integer  NOT NULL,
	CONSTRAINT fk_categorie FOREIGN KEY(idcategoriesproduit) REFERENCES categoriesproduit(idcategorie)  
 );

INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('tableau picasso','autoportrait a la meche',1);
INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('habitation','surface de 3000m2',2);
INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('mustang GT','ford mustang GT cabriolet 1968',3);
INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('sculpture','Etienne-Maurice Falconet:amoursse disputant un coeur',1);
INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('baccarat','paire de salieres en cristal',1);
INSERT INTO produits (nom,description,idcategoriesproduit) VALUES ('bmw','bmw e30 modele 325is imm 1990',3);


CREATE  TABLE image ( 
	idimage     SERIAL PRIMARY KEY ,
	idproduit   integer NOT NULL,
	image                 varchar(50) NOT NULL 
 );

INSERT INTO image(idproduit,image) VALUES (1,'image');
INSERT INTO image(idproduit,image) VALUES (2,'image');
INSERT INTO image(idproduit,image) VALUES (3,'image');
INSERT INTO image(idproduit,image) VALUES (4,'image');
INSERT INTO image(idproduit,image) VALUES (5,'image');
INSERT INTO image(idproduit,image) VALUES (6,'image');


CREATE  TABLE rencherir ( 
	idrencherir            SERIAL PRIMARY KEY ,
	idenchere              integer    ,
	idutilisateur          integer    ,
	prix_mise_enchere   float(10),
	date_heure           timestamp    
 );

INSERT INTO rencherir(idenchere,idutilisateur,prix_mise_enchere,date_heure) VALUES()

CREATE  TABLE enchere ( 
	idenchere                SERIAL PRIMARY KEY ,
	idcategoriesenchere    integer    ,
	idutilisateur          integer    ,
	idproduit              integer    ,
	dateheure            timestamp    ,
	prix_minimal         float(10)   ,
	duree                integer,
	statut               varchar(50),
	CONSTRAINT fk_enchere_categorie FOREIGN KEY(idcategoriesenchere) REFERENCES categoriesenchere(idcategorie),
		CONSTRAINT fk_enchere_utilisateur FOREIGN KEY(idutilisateur) REFERENCES utilisateur(idutilisateur),
			CONSTRAINT fk_enchere_produits FOREIGN KEY(idproduit) REFERENCES produits(idproduit)

 );

INSERT INTO enchere(idcategoriesenchere,idutilisateur,idproduit,dateheure,prix_minimal,duree,statut) VALUES(2,1,2,now(),100,2,'publique');
INSERT INTO enchere(idcategoriesenchere,idutilisateur,idproduit,dateheure,prix_minimal,duree,statut) VALUES(3,4,3,now(),2000,1,'privee');
INSERT INTO enchere(idcategoriesenchere,idutilisateur,idproduit,dateheure,prix_minimal,duree,statut) VALUES(1,2,1,now(),500,3,'publique');

