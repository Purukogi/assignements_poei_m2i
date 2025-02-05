DROP TABLE IF EXISTS addresses, contacts, users;

CREATE TABLE contacts (
	id				INT				PRIMARY KEY
									IDENTITY,
	last_name		VARCHAR(50)		NOT NULL,
	first_name		VARCHAR(50)		NOT NULL,
	birthday		DATE,
	phone			VARCHAR(16),
	socials			VARCHAR(255),
	occupation		VARCHAR(50),
	specialty		VARCHAR(50),
);

CREATE TABLE addresses (
	id				INT				PRIMARY KEY
									IDENTITY,
	number			INT				NOT NULL,
	street			VARCHAR(255)	NOT NULL,
	zip_code		VARCHAR(8),
	city			VARCHAR(64)		NOT NULL,
	id_contact		INT				FOREIGN KEY REFERENCES contacts(id)
									ON DELETE CASCADE
);

CREATE TABLE users (
    id              INT             PRIMARY KEY     IDENTITY,
    username        VARCHAR(31)     NOT NULL,
    password        VARBINARY(63)   NOT NULL,
    salt            VARBINARY(63)   NOT NULL,
    token           VARCHAR(127)
);

INSERT INTO contacts (last_name, first_name, birthday,						phone,			socials,				occupation,		specialty)
	VALUES			 ('CASSIN',	 'Etienne',	 DATEADD(YEAR, -32, GETDATE()),	'0122334477',	'facebook.com/ECassin',	'Formateur',		'Fullstack'),
					 ('MUGNIERY','Jean',	 DATEADD(YEAR, -32, GETDATE()),	'0011223344',	'myspace.com/JMU',		'Formaté',		'Bug Creator'),
					 ('BATOR',	 'Al',		 DATEADD(YEAR, -32, GETDATE()),	'0154987546',	'Discord',				'Pirate',		'Spaceships'),
					 ('CULA',	 'Alphonse', DATEADD(YEAR, -32, GETDATE()), '1235497546',	'Carrier Pidgeon',		'Doctor',		'Bloodworks');

INSERT INTO addresses	(number,		street,				zip_code,		city,		id_contact)
	VALUES				(12,			'Rue Béole',		44300,			'Nantes',	1),
						(13,			'Rue Barbe',		44000,			'Nantes',	2),
						(54,			'Rue Stine',		98465,			'Paris',	3),
						(154,			'Avenue de Transylvanie', 4876,		'Prague',   4);

SELECT * FROM contacts;
SELECT * FROM addresses;
SELECT * FROM users;
SELECT contacts.id, last_name, first_name, birthday, phone, socials, occupation, specialty, addresses.id as id_address, number, street, zip_code, city  FROM contacts
	INNER JOIN addresses ON contacts.id = addresses.id_contact
	WHERE contacts.id = 2;

SELECT contacts.id, last_name, first_name, birthday, phone, socials, occupation, specialty, addresses.id as id_address, number, street, zip_code, city  FROM contacts
	INNER JOIN addresses ON contacts.id = addresses.id_contact