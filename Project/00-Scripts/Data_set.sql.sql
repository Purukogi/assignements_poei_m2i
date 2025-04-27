INSERT INTO cartes (nom, description)
VALUES 
('Carte Printemps', 'Carte de saison avec des plats frais printaniers'),
('Carte Été', 'Carte d’été avec des produits de saison'),
('Carte Hiver', 'Carte d’hiver avec des plats réconfortants'),
('Carte Automne', 'Carte automnale avec des recettes de saison'),
('Carte Végétarienne', 'Carte exclusivement végétarienne'),
('Carte Sans Gluten', 'Carte sans gluten'),
('Carte Desserts', 'Carte dédiée aux desserts gourmands'),
('Carte Boissons', 'Carte des boissons et cocktails');

INSERT INTO restaurants (nom, adresse, url_image, id_carte)
VALUES 
('Le Gourmet', '10 Rue de la Gastronomie, Paris', 'https://images.unsplash.com/photo-1544148103-0773bf10d330', 1),
('Chez Mamie', '15 Rue des Amis, Lyon', 'https://images.unsplash.com/photo-1549488344-1f9b8d2bd1f3', 2),
('La Table d''Or', '25 Boulevard du Sud, Marseille', 'https://images.unsplash.com/photo-1555396273-367ea4eb4db5', 3),
('Bistro Rive Gauche', '5 Place des Champs, Paris', 'https://images.unsplash.com/photo-1485182708500-e8f1f318ba72', 4),
('L''Épicurienne', '30 Avenue du Ciel, Bordeaux', 'https://images.unsplash.com/photo-1600093463592-8e36ae95ef56', 5),
('Le Petit Coin', '40 Rue des Vins, Nantes', 'https://images.unsplash.com/photo-1554118811-1e0d58224f24', 6);

INSERT INTO horaires (jour, ouverture, fermeture, id_restaurant)
VALUES 
-- Horaires pour Le Gourmet (id_restaurant = 1)
('Mardi', '10:00', '22:00', 1),
('Mercredi', '10:00', '22:00', 1),
('Jeudi', '10:00', '22:00', 1),
('Vendredi', '10:00', '23:00', 1),
('Samedi', '10:00', '23:00', 1),
('Dimanche', '10:00', '22:00', 1),

-- Horaires pour Chez Mamie (id_restaurant = 2)
('Lundi', '10:00', '22:00', 2),
('Mardi', '10:00', '22:00', 2),
('Mercredi', '10:00', '22:00', 2),
('Jeudi', '10:00', '22:00', 2),
('Vendredi', '10:00', '23:00', 2),
('Samedi', '10:00', '23:00', 2),

-- Horaires pour La Table d'Or (id_restaurant = 3)
('Lundi', '10:00', '22:00', 3),
('Mardi', '10:00', '22:00', 3),
('Jeudi', '10:00', '22:00', 3),
('Vendredi', '10:00', '23:00', 3),
('Samedi', '10:00', '23:00', 3),
('Dimanche', '10:00', '22:00', 3),

-- Horaires pour Bistro Rive Gauche (id_restaurant = 4)
('Lundi', '10:00', '22:00', 4),
('Mercredi', '10:00', '22:00', 4),
('Jeudi', '10:00', '22:00', 4),
('Vendredi', '10:00', '23:00', 4),
('Samedi', '10:00', '23:00', 4),
('Dimanche', '10:00', '22:00', 4),

-- Horaires pour L'Épicurienne (id_restaurant = 5)
('Mercredi', '10:00', '22:00', 5),
('Jeudi', '10:00', '22:00', 5),
('Vendredi', '10:00', '23:00', 5),
('Samedi', '10:00', '23:00', 5),
('Dimanche', '10:00', '22:00', 5),

-- Horaires pour Le Petit Coin (id_restaurant = 6)
('Lundi', '10:00', '22:00', 6),
('Mardi', '10:00', '22:00', 6),
('Mercredi', '10:00', '22:00', 6),
('Vendredi', '10:00', '23:00', 6),
('Samedi', '10:00', '23:00', 6),
('Dimanche', '10:00', '22:00', 6);

INSERT INTO tables_restaurant (nb_places, numero_table, id_restaurant)
VALUES
-- Tables pour Le Gourmet (id_restaurant = 1)
(4, 101, 1),
(2, 102, 1),
(4, 103, 1),
(4, 104, 1),
(2, 105, 1),
(4, 106, 1),
(4, 201, 1),
(2, 202, 1),
(6, 203, 1),
(4, 204, 1),
(4, 205, 1),
(2, 206, 1),
(4, 301, 1),
(4, 302, 1),
(8, 303, 1),
(4, 304, 1),
(4, 305, 1),
(2, 306, 1),
(4, 401, 1),
(4, 402, 1),

-- Tables pour Chez Mamie (id_restaurant = 2)
(4, 1, 2),
(2, 2, 2),
(4, 3, 2),
(2, 4, 2),
(4, 5, 2),
(4, 6, 2),
(6, 7, 2),
(4, 8, 2),
(2, 9, 2),
(4, 10, 2),
(4, 101, 2),
(2, 102, 2),
(4, 103, 2),
(4, 104, 2),
(8, 105, 2),
(4, 106, 2),
(4, 107, 2),
(2, 108, 2),
(4, 109, 2),
(4, 110, 2),

-- Tables pour La Table d'Or (id_restaurant = 3)
(4, 101, 3),
(2, 102, 3),
(4, 103, 3),
(4, 104, 3),
(2, 105, 3),
(4, 106, 3),
(4, 107, 3),
(2, 108, 3),
(6, 109, 3),
(4, 110, 3),
(4, 201, 3),
(2, 202, 3),
(4, 203, 3),
(4, 204, 3),
(8, 205, 3),
(4, 206, 3),
(4, 207, 3),
(2, 208, 3),
(4, 209, 3),
(4, 210, 3),

-- Tables pour Bistro Rive Gauche (id_restaurant = 4)
(4, 10, 4),
(2, 11, 4),
(4, 12, 4),
(2, 13, 4),
(4, 14, 4),
(4, 15, 4),
(6, 16, 4),
(4, 20, 4),
(2, 21, 4),
(4, 22, 4),
(4, 23, 4),
(2, 24, 4),
(4, 25, 4),
(4, 26, 4),
(8, 30, 4),
(4, 31, 4),
(4, 32, 4),
(2, 33, 4),
(4, 34, 4),
(4, 35, 4),

-- Tables pour L'Épicurienne (id_restaurant = 5)
(4, 1, 5),
(2, 2, 5),
(4, 3, 5),
(4, 4, 5),
(2, 5, 5),
(4, 6, 5),
(4, 7, 5),
(2, 8, 5),
(6, 9, 5),
(4, 10, 5),
(4, 11, 5),
(2, 12, 5),
(4, 13, 5),
(4, 14, 5),
(8, 15, 5),
(4, 16, 5),
(4, 17, 5),
(2, 18, 5),
(4, 19, 5),
(4, 20, 5),

-- Tables pour Le Petit Coin (id_restaurant = 6)
(4, 101, 6),
(2, 102, 6),
(4, 103, 6),
(4, 104, 6),
(2, 105, 6),
(4, 106, 6),
(4, 107, 6),
(2, 108, 6),
(6, 109, 6),
(4, 201, 6),
(4, 202, 6),
(2, 203, 6),
(4, 204, 6),
(4, 205, 6),
(8, 206, 6),
(4, 301, 6),
(4, 302, 6),
(2, 303, 6),
(4, 304, 6),
(4, 305, 6);

INSERT INTO roles (id, libelle)
VALUES 
('ADM', 'Administrateur'),
('EMP', 'Employé'),
('CLI', 'Client');

INSERT INTO utilisateurs (nom, prenom, login, email, telephone, mdp, salt, id_role)
VALUES
('Mugniery', 'Jean', 'Jean', 'jmu@email.fr', '123456789', 0x34D9D5AD78767CEB15CB8CFAE0CD76D8, 0xC1E615D548C0302A5E4F605FA92AD366, 'CLI'),
('Laviale', 'Clara', 'Clara', 'clara.laviale@email.fr', '789456136', 0xCF0D08119B1EC61818B9721D676F3AA3, 0xB3DC581F9306CA73FC23D137D3BBFE0B, 'CLI'),
('Sans', 'resa', 'sansResa', 'admin@admin.fr', '789456122', 0x00, 0x00, 'CLI'),
('Teillet', 'Quentin', 'Quentin', 'q-teillet@email.fr', '45613789', 0x7D17987B20667288FD29ED92A5CB7ABA, 0x0B35ED38DDF1D920B305D041EB1B35B8, 'CLI');

INSERT INTO employes (nom, prenom, login, email, telephone, mdp, id_role, id_restaurant)
VALUES
('Juvin', 'Fanny', 'Fanny', 'fanny.juvin@email.com', '45678913', '$2y$10$Xw/rTdNVbw9Tu5Nvih.JReJzp2VVFFAF2dxHifCQ6DwfCGZOmiDWu', 'EMP', 1),
('Malabry', 'Emmanuel', 'Emmanuel', 'e-malabry@email.com', '321654987', '$2y$10$C.r5SjeYU8NHZi1IbozEA.RWqrI8ITn0d0IfhZYgKGmII1afEFqMe', 'EMP', 1),
('Guillois', 'Loic', 'Loic', 'l.guillois@email.com', '456321789', '$2y$10$wTPdXPtEw48bmjLUtGu1/.OkUswcjCSSlNK5JO1B8.5okytDIrPB6', 'EMP', 2),
('Cassin', 'Etienne', 'Etienne', 'e.cassin@email.com', '98765431', '$2y$10$qwLyN2uRq7h/WdrrbgrnRufFuNBes0MyGJl4hY3JugumW4nsUDZ12', 'ADM', NULL);

INSERT INTO reservations (id_restaurant, id_utilisateur, id_table, horaire_reservation, nombre_personnes, statut)
VALUES 
(1, 1, 1, '2025-30-01 19:00', 2, 'Présent'),
(2, 2, 21, '2025-30-01 19:30', 4, 'Confirmée'),
(3, 3, 41, '2025-30-01 20:00', 3, 'Confirmée'),
(4, 3, 61, '2025-25-02 20:30', 2, 'Annulée'),
(5, 2, 81, '2025-18-03 21:00', 5, 'Confirmée'),
(6, 1, 101, '2025-18-02 21:30', 4, 'En attente'),
(1, 1, 7, '2025-21-05 21:00', 2, 'Confirmée'),
(1, 1, 2, '2025-04-07 12:00:00', 2, 'Présent');

INSERT INTO commandes (id_reservation, statut)
VALUES 
(1, 'Validée'),
(2, 'En attente'),
(3, 'Validée');

INSERT INTO categories (id, libelle)
VALUES 
(1, 'Entrée'),
(2, 'Plat'),
(3, 'Dessert'),
(4, 'Boisson');

INSERT INTO plats (nom, prix, description, id_categorie)
VALUES
-- Plats pour la catégorie "Entrée" (id_categorie = 1)
('Salade de saison', 8.50, 'Salade composée de légumes frais', 1),
('Soupe de légumes', 7.00, 'Soupe chaude avec des légumes de saison', 1),
('Carpaccio de bœuf', 12.00, 'Finement tranché avec une vinaigrette maison', 1),
('Tartare de saumon', 11.50, NULL, 1),
('Œuf cocotte', 9.00, 'Œuf cuit au four dans une crème légère', 1),

-- Plats pour la catégorie "Plat" (id_categorie = 2)
('Boeuf Bourguignon', 18.00, 'Boeuf mijoté dans une sauce au vin rouge', 2),
('Ratatouille', 15.00, 'Plat de légumes provençaux', 2),
('Magret de canard', 20.00, 'Magret grillé accompagné de sa sauce', 2),
('Poisson du jour', 22.00, 'Poisson frais de saison servi avec légumes', 2),
('Couscous', 16.50, NULL, 2),
('Pizza Margherita', 13.00, 'Pizza traditionnelle avec tomates et mozzarella', 2),
('Lasagne maison', 14.00, NULL, 2),
('Steak frites', 17.00, 'Steak grillé avec des frites maison', 2),

-- Plats pour la catégorie "Dessert" (id_categorie = 3)
('Tiramisu', 6.50, 'Dessert italien à base de mascarpone', 3),
('Crème brûlée', 6.00, 'Crème au lait avec une croûte caramélisée', 3),
('Mousse au chocolat', 5.50, 'Mousse légère et onctueuse au chocolat noir', 3),
('Fondant au chocolat', 7.00, NULL, 3),
('Cheesecake', 6.50, 'Gâteau à base de fromage frais et fruits rouges', 3),
('Crêpes sucrées', 5.00, 'Crêpes garnies de sucre, chocolat ou fruits', 3),

-- Plats pour la catégorie "Boisson" (id_categorie = 4)
('Coca-Cola', 3.00, 'Boisson gazeuse', 4),
('Eau minérale', 2.50, 'Eau plate', 4),
('Jus d''orange', 3.50, 'Jus frais pressé d''oranges', 4),
('Vin rouge', 4.00, 'Vin rouge léger', 4),
('Vin blanc', 4.00, 'Vin blanc frais et fruité', 4),
('Café', 2.00, 'Café espresso', 4),
('Thé vert', 2.50, 'Thé vert parfumé', 4),
('Bière artisanale', 5.00, 'Bière locale avec une touche de houblon', 4);

INSERT INTO asso_cartes_plats (id_carte, id_plat)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(2, 2),
(2, 3),
(2, 4),
(2, 6),
(2, 7),
(2, 11),
(2, 12),
(2, 14),
(2, 15),
(2, 16),
(3, 1),
(3, 3),
(3, 5),
(3, 6),
(3, 8),
(3, 9),
(3, 13),
(3, 15),
(3, 17),
(3, 19),
(4, 3),
(4, 4),
(4, 6),
(4, 7),
(4, 9),
(4, 12),
(4, 13),
(4, 14),
(4, 16),
(4, 17),
(5, 1),
(5, 2),
(5, 3),
(5, 5),
(5, 7),
(5, 9),
(5, 13),
(5, 16),
(5, 19),
(5, 20),
(6, 1),
(6, 6),
(6, 7),
(6, 11),
(6, 12),
(6, 13),
(6, 14),
(6, 16),
(6, 18),
(6, 20);

INSERT INTO asso_commandes_plats (id_commande, id_plat, quantite)
VALUES
(1, 2, 2),
(1, 4, 1),
(2, 5, 3);