DROP TABLE IF EXISTS	asso_commandes_plats,
						asso_cartes_plats,
						plats,
						categories,
						commandes,
						reservations,
						utilisateurs,
						employes,
						roles,
						tables_restaurant,
						horaires,
						restaurants,
						cartes;

CREATE TABLE cartes (
	id				INT					PRIMARY KEY 
										IDENTITY,
	nom				VARCHAR(30)			NOT NULL,
	description		VARCHAR(255)
);

CREATE TABLE restaurants (
	id				INT					PRIMARY KEY 
										IDENTITY,
	nom				VARCHAR(30)			NOT NULL,
	adresse			VARCHAR(255)		NOT NULL,
	url_image		VARCHAR(255)				,
	id_carte		INT					FOREIGN KEY REFERENCES cartes(id) ON DELETE SET NULL
);


CREATE TABLE horaires (
	id				INT					PRIMARY KEY 
										IDENTITY,
	jour			VARCHAR(8)			NOT NULL,
	ouverture		TIME				NOT NULL,
	fermeture		TIME				NOT NULL,
	id_restaurant	INT					NOT NULL
										FOREIGN KEY REFERENCES restaurants(id) ON DELETE CASCADE
);

CREATE TABLE tables_restaurant (
	id				INT					PRIMARY KEY 
										IDENTITY,
	nb_places		INT					NOT NULL,
	numero_table	INT					NOT NULL,
	id_restaurant	INT					NOT NULL
										FOREIGN KEY REFERENCES restaurants(id) ON DELETE CASCADE
);

CREATE TABLE roles (
	id				CHAR(3)				PRIMARY KEY,
	libelle			VARCHAR(30)			NOT NULL
										UNIQUE
);

CREATE TABLE utilisateurs (
	id				INT					PRIMARY KEY
										IDENTITY,
	nom				VARCHAR(30)			NOT NULL,
	prenom			VARCHAR(30)			NOT NULL,
	login			VARCHAR(30)					,
	email			VARCHAR(60)			NOT NULL,
	telephone		VARCHAR(20)					,
	mdp				VARBINARY(20)		NOT NULL,
	salt			VARBINARY(63)		NOT NULL,
	token			VARCHAR(127)				,
	id_role			CHAR(3)				NOT NULL
										FOREIGN KEY REFERENCES roles(id) ON DELETE CASCADE,
	id_restaurant	INT					FOREIGN KEY REFERENCES restaurants(id) ON DELETE SET NULL
);

CREATE TABLE employes (
	id				INT					PRIMARY KEY
										IDENTITY,
	nom				VARCHAR(30)			NOT NULL,
	prenom			VARCHAR(30)			NOT NULL,
	login			VARCHAR(30)					,
	email			VARCHAR(60)			NOT NULL,
	telephone		VARCHAR(20)					,
	mdp				VARCHAR(127)		NOT NULL,
	token			VARCHAR(127)				,
	id_role			CHAR(3)				NOT NULL
										FOREIGN KEY REFERENCES roles(id) ON DELETE CASCADE,
	id_restaurant	INT					FOREIGN KEY REFERENCES restaurants(id) ON DELETE SET NULL
);

CREATE TABLE reservations (
	id					INT					PRIMARY KEY
											IDENTITY,
	id_restaurant		INT					NOT NULL
											FOREIGN KEY REFERENCES restaurants(id) ON DELETE CASCADE,
	id_utilisateur		INT					NOT NULL
											FOREIGN KEY REFERENCES utilisateurs(id) ON DELETE CASCADE,
	id_table			INT					FOREIGN KEY REFERENCES tables_restaurant(id) ON DELETE NO ACTION,
	horaire_reservation DATETIME			NOT NULL,
	nombre_personnes	INT					NOT NULL,
	statut				VARCHAR(20)			NOT NULL
);

CREATE TABLE commandes (
	id					INT					PRIMARY KEY
											IDENTITY,
	id_reservation		INT					NOT NULL
											FOREIGN KEY REFERENCES reservations(id) ON DELETE CASCADE,
	statut				VARCHAR(20)			NOT NULL
);

CREATE TABLE categories (
	id			INT				PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
								UNIQUE
);

CREATE TABLE plats (
	id				INT				PRIMARY KEY 
									IDENTITY,
	nom				VARCHAR(30)		NOT NULL,
	prix			DECIMAL(5,2)	NOT NULL,
	description		VARCHAR(255)			,
	id_categorie	INT				NOT NULL 
									FOREIGN KEY REFERENCES categories(id) ON DELETE CASCADE
);

CREATE TABLE asso_cartes_plats (
	id_carte		INT				NOT NULL 
									FOREIGN KEY REFERENCES cartes(id) ON DELETE CASCADE,
	id_plat			INT				NOT NULL 
									FOREIGN KEY REFERENCES plats(id) ON DELETE CASCADE
);

CREATE TABLE asso_commandes_plats (
	id				INT				PRIMARY KEY 
									IDENTITY,
	id_commande		INT				NOT NULL 
									FOREIGN KEY REFERENCES commandes(id) ON DELETE CASCADE,
	id_plat			INT				NOT NULL 
									FOREIGN KEY REFERENCES plats(id) ON DELETE CASCADE,
	quantite		INT				NOT NULL 
									DEFAULT 1
);