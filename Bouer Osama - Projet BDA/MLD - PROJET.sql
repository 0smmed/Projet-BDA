create database DbBibliothèque;
use DbBibliothèque;

-- Table Associe

CREATE TABLE Bibliotheque(
   idBibliotheque INT,
   Emplacement VARCHAR(50),
   PRIMARY KEY(idBibliotheque)
);

CREATE TABLE Auteur(
   IdAuteur INT,
   Nom VARCHAR(50),
   Adresse VARCHAR(50),
   Region VARCHAR(50),
   PRIMARY KEY(IdAuteur)
);

CREATE TABLE Telephone(
   NumeroTel INT,
   Type VARCHAR(50),
   IdAuteur INT NOT NULL,
   PRIMARY KEY(NumeroTel),
   UNIQUE(IdAuteur),
   FOREIGN KEY(IdAuteur) REFERENCES Auteur(IdAuteur)
);

CREATE TABLE Livre(
   ISBN INT,
   Titre VARCHAR(50),
   IdAuteur INT NOT NULL,
   PRIMARY KEY(ISBN),
   FOREIGN KEY(IdAuteur) REFERENCES Auteur(IdAuteur)
);

CREATE TABLE Associé(
   idBibliotheque INT,
   IdAuteur INT,
   PRIMARY KEY(idBibliotheque, IdAuteur),
   FOREIGN KEY(idBibliotheque) REFERENCES Bibliotheque(idBibliotheque),
   FOREIGN KEY(IdAuteur) REFERENCES Auteur(IdAuteur)
);


-- Insertion des enregistrement dans la table Bibliotheque.
INSERT INTO Bibliotheque (IdBibliotheque, Emplacement)
VALUES
(1, 'Bibliothèque Nationale, Nouakchott'),
(2, 'Bibliothèque Régionale, Nouadhibou'),
(3, 'Bibliothèque Municipale, Atar'),
(4, 'Bibliothèque Communautaire, Zouerate'),
(5, 'Bibliothèque Universitaire, Nouakchott'),
(6, 'Bibliothèque Scolaire, Kaédi'),
(7, 'Bibliothèque de Quartier, Rosso'),
(8, 'Bibliothèque Mobile, Adrar'),
(9, 'Bibliothèque Culturelle, Néma'),
(10, 'Bibliothèque Médiathèque, Kiffa');

-- Insertion des enregistrement dans la table Auteur.
INSERT INTO Auteur (idAuteur, nom, adresse, region)
VALUES
(1, "Mohamed Ahmed", "Avenue des Palmiers, Nouakchott",
'Mauritanie'),
(2, "Fatimata Fall", "Rue des Pêcheurs, Nouadhibou", 'Mauritanie'),
(3, 'Ismaila Sow', 'Rue du Savoir, Atar', 'Mauritanie'),
(4, 'Aicha Ould', 'Avenue de la Connaissance, Zouerate', 'Mauritanie'),
(5, 'Omar Kane', 'Boulevard Universitaire, Nouakchott', 'Mauritanie'),
(6, 'Hawa Camara', "Rue des Écoles, Kaédi", 'Mauritanie'),
(7, 'Baba Ahmed', 'Avenue de la Culture, Rosso', 'Mauritanie'),
(8, 'Mariem Cheikh', 'Route Mobile, Adrar', 'Mauritanie'),
(9, 'Brahim Ould', 'Avenue des Arts, Néma', 'Mauritanie'),
(10, 'Aminetou Ould', 'Rue de la Médiathèque, Kiffa', 'Mauritanie');

-- Insertion des enregistrement dans la table Livre.
INSERT INTO Livre (ISBN, titre, idAuteur)
VALUES
(123456, "Chroniques du Désert", 1),
(789012, "Légendes de l'Océan", 2),
(345678, "Poésie du Sahara", 3),
(901234, "Histoires de Zouerate", 4),
(567890, "Université et Savoir", 5),
(234567, "Contes de Kaédi", 6),
(890123, "Rosso à travers les Âges", 7),
(456789, "Adrar et sa Mobile", 8),
(123789, "L'Art de Néma", 9),
(987654, "Médiathèque de Kiffa", 10);

-- Insertion des enregistrement dans la table Telephone.
INSERT INTO Telephone (NumeroTel, type, idAuteur)
VALUES
(111111, 'Mobile', 1),
(222222, 'Fixe', 2),
(333333, 'Mobile', 3),
(444444, 'Fixe', 4),
(555555, 'Mobile', 5),
(666666, 'Fixe', 6),
(777777, 'Mobile', 7),
(888888, 'Fixe', 8),
(999999, 'Mobile', 9),
(101010, 'Fixe', 10);

-- Insertion des enregistrement dans la table Associer
INSERT INTO Associé (idBibliotheque, idAuteur)
VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 4),
(5, 5),
(6, 5),
(7, 5),
(8, 1),
(9, 2),
(10, 5);

-- 3/Insérer une nouvelle bibliothèque avec l'idBibliotheque 11 à l'emplacement 'Bibliothèque de Village, Boghé' ?
INSERT INTO Bibliotheque (idBibliotheque, Emplacement)
VALUES (11, 'Bibliothèque de Village, Boghé');

-- 4/Ajouter un nouvel auteur avec l'idAuteur 11, nom 'Hassan Ould Med', adresse 'Rue des Livres, Boghé' et région 'Trarza' ?
INSERT INTO Auteur (idAuteur, Nom, Adresse, Region)
VALUES (11, 'Hassan Ould Med', 'Rue des Livres, Boghé', 'Trarza');

-- 5/Ajouter un nouveau numéro de téléphone '123123' de type 'Mobile' pour l'auteur avec l'idAuteur 11 ?
INSERT INTO Telephone (NumeroTel, Type, idAuteur)
VALUES (123123, 'Mobile', 11);

-- 6/Supprimer la colonne 'adresse' de la table Auteur ?
ALTER TABLE Auteur DROP COLUMN Adresse;

-- 7/Insérer un nouveau livre avec l'ISBN '111222', le titre 'Voyages à travers le Savoir' et l'idAuteur 11 ?
INSERT INTO Livre (ISBN, Titre, idAuteur)
VALUES (111222, 'Voyages à travers le Savoir', 11);

-- 8/Insérer une nouvelle association entre la bibliothèque avec l'idBibliotheque 11 et l'auteur avec l'idAuteur 11 ?
INSERT INTO Associé (idBibliotheque, idAuteur)
VALUES (11, 11);

-- 9/Afficher toutes les informations de la table Auteur ?
SELECT * FROM Auteur;

-- 10/Quelle commande SQL permet d'afficher uniquement les noms et les régions des auteurs ?
SELECT Nom, Region FROM Auteur;

-- 11/Afficher les régions des auteurs sans répétition ?
SELECT DISTINCT Region FROM Auteur;

-- 12/Afficher les livres triés par titre (ordre croissant) ?
SELECT * FROM Livre ORDER BY Titre ASC;

-- 13/Afficher les livres triés par titre (ordre décroissant) ?
SELECT * FROM Livre ORDER BY Titre DESC;

-- 14/Afficher les numéros de téléphone et les noms des auteurs (en remplaçant le champ nom par NomAuteur dans l'affichage) ?
SELECT Telephone.NumeroTel, Auteur.Nom AS NomAuteur FROM Telephone
JOIN Auteur ON Telephone.idAuteur = Auteur.idAuteur;

-- 15/Comment afficher les noms des auteurs dont la région est 'Mauritanie', triés par le nom ?
SELECT Nom FROM Auteur WHERE Region = 'Mauritanie' ORDER BY Nom;

-- 16/Afficher les ISBN et les titres des livres dont l'idAuteur est supérieur à 5 ?
SELECT ISBN, Titre FROM Livre WHERE idAuteur > 5;

-- 17/Comment afficher les bibliothèques dont l'emplacement est 'Bibliothèque Nationale, Nouakchott' ou la région de l'auteur est 'Mauritanie' ?
SELECT * FROM Bibliotheque
WHERE emplacement = 'Bibliothèque Nationale, Nouakchott'
   OR idBibliotheque IN (SELECT idBibliotheque FROM Associé
                         WHERE idAuteur IN (SELECT idAuteur FROM Auteur WHERE Region = 'Mauritanie'));

-- 18/Afficher les noms des livres qui contiennent la lettre 'a' dans leur titre ?
SELECT Titre FROM Livre WHERE Titre LIKE '%a%';

-- 19/Afficher les ISBN et les titres des livres dont le titre de la bibliothèque commence par 'B' ?
SELECT Livre.ISBN, Livre.Titre FROM Livre
JOIN Associé ON Livre.idAuteur = Associé.idAuteur
JOIN Bibliotheque ON Associé.idBibliotheque = Bibliotheque.idBibliotheque
WHERE Bibliotheque.emplacement LIKE 'B%';

-- 20/Afficher les ISBN, les titres et les emplacements des livres dont le deuxième caractère de l'ISBN est '3' ?
SELECT Livre.ISBN, Livre.Titre, Bibliotheque.Emplacement
FROM Livre
JOIN Associé ON Livre.idAuteur = Associé.idAuteur
JOIN Bibliotheque ON Associé.idBibliotheque = Bibliotheque.idBibliotheque
WHERE SUBSTRING(Livre.ISBN, 2, 1) = '3';

-- 21/Comment obtenir le nombre total d'enregistrements dans la table Bib ?
SELECT COUNT(*) FROM Bibliotheque;

-- 22/Quelle est la requête SQL pour compter le nombre total de livres dont l'idAuteur est inférieur à 8 ?
SELECT COUNT(*) FROM Livre WHERE idAuteur < 8;

-- 23/Modifier l'emplacement de la bibliothèque avec l'idBib 1 pour être 'Bibliothèque Centrale, Nouakchott' ?
UPDATE Bibliotheque SET emplacement = 'Bibliothèque Centrale, Nouakchott' WHERE idBibliotheque = 1;

-- 24/Modifier l'emplacement de la bibliothèque avec l'idBib 2 pour être 'Bibliothèque Principale, Nouadhibou' ?
UPDATE Bibliotheque SET emplacement = 'Bibliothèque Principale, Nouadhibou' WHERE idBibliotheque = 2;

-- 25/Modifier l'emplacement de la bibliothèque avec l'idBib 3 pour être 'Bibliothèque Municipale, Atar' et son emplacement pour être 'Place du Savoir, Atar' ?
UPDATE Bibliotheque SET emplacement = 'Bibliothèque Municipale, Atar' WHERE idBibliotheque = 3;

-- 26/Supprimer la bibliothèque avec l'idBibliotheque 4 de la table DbBibliotheque ?
DELETE FROM Bibliotheque WHERE idBibliotheque = 4;

-- 27/Supprimer l’auteur avec l'idAuteur 4 de la table Auteur
DELETE FROM Auteur WHERE idAuteur = 4;
