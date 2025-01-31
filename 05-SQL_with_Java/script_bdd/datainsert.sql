DROP TABLE IF EXISTS composants;

CREATE TABLE composants (
	id				INT				PRIMARY KEY
									IDENTITY,
	nom				VARCHAR(30)		NOT NULL,
	type			VARCHAR(10)		NOT NULL,
	date_sortie		DATE			
);

INSERT INTO composants 
			(nom,			type,		date_sortie)
	VALUES	('composant1',	'RAM',		DATEADD(YEAR, -70, GETDATE())),
			('composant2',	'CPU',		NULL);