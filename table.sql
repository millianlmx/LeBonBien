-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: immo_la2_v1
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `ANNONCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ANNONCE` (
                           `ID_ANNONCE` int NOT NULL AUTO_INCREMENT COMMENT 'Identifiant unique de l''annonce',
                           `DATE_ANNONCE` date NOT NULL COMMENT 'Date de publication de l''annonce',
                           `ID_BIEN` int NOT NULL COMMENT 'Identifiant du bien concerné par l''annonce',
                           `ID_AGENT` int NOT NULL COMMENT 'Identifiant de l''agent immobilier',
                           `ID_PROPRIETAIRE` int NOT NULL COMMENT 'Identifiant du propriétaire du bien au moment de la publication',
                           `TITRE` TEXT NOT NULL COMMENT 'Titre de l''annonce',
                           `DESCRIPTION` TEXT NOT NULL COMMENT 'Description de l''annonce',
                           `PRIX` DECIMAL(10,2) NOT NULL COMMENT 'Prix de vente ou de location',
                           PRIMARY KEY (`ID_ANNONCE`),
                           KEY `AGENT_fk` (`ID_AGENT`),
                           KEY `BIEN_fk` (`ID_BIEN`),
                           KEY `ANNONCE_PROPRIETAIRE_fk` (`ID_PROPRIETAIRE`),
                           CONSTRAINT `AGENT_fk` FOREIGN KEY (`ID_AGENT`) REFERENCES `TIERS` (`ID_TIERS`),
                           CONSTRAINT `ANNONCE_PROPRIETAIRE_fk` FOREIGN KEY (`ID_PROPRIETAIRE`) REFERENCES `TIERS` (`ID_TIERS`),
                           CONSTRAINT `BIEN_fk` FOREIGN KEY (`ID_BIEN`) REFERENCES `BIEN` (`ID_BIEN`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `BIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BIEN` (
                        `ID_BIEN` int NOT NULL AUTO_INCREMENT COMMENT 'Identifiant du bien',
                        `LIB_BIEN` varchar(50) NOT NULL COMMENT 'description du bien',
                        `ADR_NO_VOIE` varchar(7) DEFAULT NULL COMMENT 'Numéro dans la voie',
                        `NOM_VOIE` varchar(100) DEFAULT NULL COMMENT 'Nom de la voie',
                        `CODE_POSTAL` varchar(5) NOT NULL COMMENT 'Code postal de la commune',
                        `COMMUNE` varchar(100) NOT NULL COMMENT 'Nom de la commune',
                        `COMPLEMENT_ADRESSE` varchar(7) DEFAULT NULL COMMENT 'Exemple : N° appartement, étage ...',
                        `ID_PROPRIETAIRE` int NOT NULL,
                        `ID_AGENT` int not NULL,
                        `SURFACE` decimal(10, 2) NOT NULL COMMENT 'Surface du bien en m²',
                        `NB_PIECES` int NOT NULL COMMENT 'Nombre de pièces',
                        `NB_CHAMBRES` int NOT NULL COMMENT 'Nombre de chambres',
                        `NB_SDB` int NOT NULL COMMENT 'Nombre de salles de bain',
                        `TYPE` varchar(50) NOT NULL COMMENT 'Type de bien Maison, Appartement, T2, T3 ...',
                        PRIMARY KEY (`ID_BIEN`),
                        KEY `BIEN_PROPRIETAIRE_fk` (`ID_PROPRIETAIRE`),
                        KEY `BIEN_AGENT_kf` (`ID_AGENT`),
                        CONSTRAINT `BIEN_AGENT_fk` FOREIGN KEY (`ID_AGENT`) REFERENCES `TIERS` (`ID_TIERS`),
                        CONSTRAINT `BIEN_PROPRIETAIRE_fk` FOREIGN KEY (`ID_PROPRIETAIRE`) REFERENCES `TIERS` (`ID_TIERS`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `EQUIPEMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EQUIPEMENT` (
                              `ID_EQUIPEMENT` int NOT NULL AUTO_INCREMENT COMMENT 'Identifiant de l''équipement',
                              `LIB_EQUIPEMENT` varchar(50) NOT NULL COMMENT 'Description de l''équipement',
                              `VALEUR` varchar(50) NOT NULL COMMENT 'Valeur de l''équipement',
                              `ID_BIEN` int NOT NULL COMMENT 'Identifiant du bien concerné',
                              PRIMARY KEY (`ID_EQUIPEMENT`),
                              KEY `EQUIPEMENT_BIEN_fk` (`ID_BIEN`),
                              CONSTRAINT `EQUIPEMENT_BIEN_fk` FOREIGN KEY (`ID_BIEN`) REFERENCES `BIEN` (`ID_BIEN`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `TIERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIERS` (
                         `ID_TIERS` int NOT NULL AUTO_INCREMENT,
                         `NOM_TIERS` varchar(100) NOT NULL COMMENT 'Nom du tiers ou raison sociale',
                         `PRENOM_TIERS` varchar(100) DEFAULT NULL COMMENT 'Prénom du tiers si personne physique',
                         `TEL_TIERS` varchar(10) NOT NULL COMMENT 'No de téléphone du tiers',
                         `MAIL_TIERS` varchar(100) DEFAULT NULL COMMENT 'Adresse mail du tiers',
                         `TYPE_TIERS` int NOT NULL COMMENT 'Type de tiers',
                         PRIMARY KEY (`ID_TIERS`),
                         KEY `TYPE_TIERS_fk` (`TYPE_TIERS`),
                         CONSTRAINT `TYPE_TIERS_fk` FOREIGN KEY (`TYPE_TIERS`) REFERENCES `TYPE_TIERS` (`ID_TYPE_TIERS`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `TYPE_TIERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TYPE_TIERS` (
                              `ID_TYPE_TIERS` int NOT NULL AUTO_INCREMENT,
                              `LIB_TYPE_TIERS` varchar(100) NOT NULL,
                              PRIMARY KEY (`ID_TYPE_TIERS`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `TIERS` VALUES (6,'DUPONT','PIERRE','00000000','pdupont@gmail.com',2),(7,'DURAND','MARIE','00000000','mdurand@gmail.com',2),(8,'DUVAL','Jeanne','00000000',NULL,1),(9,'DUPOND','Anne','0678787878',NULL,1),(10,'CURIE','Sylvain','0678787878',NULL,2),(11,'CURIE','Marie','0678787878',NULL,2),(12,'EINSTEIN','Jane','0678787878',NULL,1),(13,'EINSTEIN','Pierre','0678787878',NULL,2),(14,'EINSTEIN','Albert','0678787878',NULL,2),(15,'EINSTEIN','Zoe','0678787878',NULL,2),(16,'VALLE','Isabelle','0909090909','',1),(17,'MICHKA','Chloé','0909090909',NULL,3);

INSERT INTO `TYPE_TIERS` VALUES (1,'LOCATAIRE'),(2,'PROPRIETAIRE'),(3,'AGENT IMMOBILIER');

INSERT INTO BIEN (LIB_BIEN, ADR_NO_VOIE, NOM_VOIE, CODE_POSTAL, COMMUNE, COMPLEMENT_ADRESSE, ID_PROPRIETAIRE, ID_AGENT, SURFACE, NB_PIECES, NB_CHAMBRES, NB_SDB, TYPE) VALUES
                                                                                                                                                                           ('Appartement lumineux', '15', 'Rue de la Paix', '75001', 'Paris', '3ème étage', 6, 17, 65.5, 3, 2, 1, 'Appartement'),
                                                                                                                                                                           ('Maison avec jardin', '24', 'Avenue des Fleurs', '69003', 'Lyon', NULL, 7, 17, 120.0, 5, 3, 2, 'Maison'),
                                                                                                                                                                           ('Studio étudiant', '8', 'Rue de l''Université', '31000', 'Toulouse', 'Rez-de-chaussée', 10, 17, 25.0, 1, 1, 1, 'Studio'),
                                                                                                                                                                           ('Loft moderne', '42', 'Boulevard Haussmann', '75008', 'Paris', '5ème étage', 11, 17, 85.0, 2, 1, 1, 'Loft'),
                                                                                                                                                                           ('Villa avec piscine', '10', 'Chemin des Oliviers', '06160', 'Antibes', NULL, 13, 17, 200.0, 6, 4, 3, 'Villa');

INSERT INTO BIEN (LIB_BIEN, ADR_NO_VOIE, NOM_VOIE, CODE_POSTAL, COMMUNE, COMPLEMENT_ADRESSE, ID_PROPRIETAIRE, ID_AGENT, SURFACE, NB_PIECES, NB_CHAMBRES, NB_SDB, TYPE) VALUES
                                                                                                                                                                           ('Appartement cosy', '8', 'Rue de la République', '69002', 'Lyon', '4ème ét', 6, 17, 45.5, 2, 1, 1, 'T2'),
                                                                                                                                                                           ('Maison de ville', '12', 'Avenue Jean Jaurès', '31500', 'Toulouse', NULL, 7, 17, 110.0, 4, 3, 2, 'Maison'),
                                                                                                                                                                           ('Studio meublé', '5', 'Rue des Étudiants', '34000', 'Montpellier', 'Bât B', 10, 17, 20.0, 1, 1, 1, 'Studio'),
                                                                                                                                                                           ('Duplex moderne', '18', 'Boulevard Victor Hugo', '06000', 'Nice', '6&7 ét', 11, 17, 95.0, 4, 2, 2, 'Appartement'),
                                                                                                                                                                           ('Pavillon avec jardin', '7', 'Allée des Cerisiers', '44000', 'Nantes', NULL, 13, 17, 130.0, 5, 4, 2, 'Maison'),
                                                                                                                                                                           ('Loft industriel', '22', 'Rue de la Soie', '69100', 'Villeurbanne', 'RDC', 14, 17, 80.0, 2, 1, 1, 'Loft'),
                                                                                                                                                                           ('Chalet de montagne', '3', 'Chemin des Sapins', '74400', 'Chamonix', NULL, 15, 17, 85.0, 3, 2, 1, 'Chalet'),
                                                                                                                                                                           ('Penthouse vue mer', '45', 'Promenade des Anglais', '06000', 'Nice', '5e ét', 6, 17, 150.0, 5, 3, 3, 'Appartement'),
                                                                                                                                                                           ('Maison d''architecte', '9', 'Rue des Oliviers', '13008', 'Marseille', NULL, 7, 17, 180.0, 6, 4, 3, 'Maison'),
                                                                                                                                                                           ('Studio d''artiste', '14', 'Rue de la Croix-Rouge', '84000', 'Avignon', '2e ét', 10, 17, 35.0, 1, 1, 1, 'Studio');

INSERT INTO ANNONCE (DATE_ANNONCE, ID_BIEN, ID_AGENT, ID_PROPRIETAIRE, TITRE, DESCRIPTION, PRIX) VALUES
                                                                                                     (CURDATE(), 6, 17, 6, 'Superbe appartement lumineux au cœur de Paris',
                                                                                                      'Magnifique appartement de 3 pièces situé dans le 1er arrondissement de Paris. Parfaitement agencé, il offre un cadre de vie idéal en plein centre-ville. Proche de toutes commodités.',
                                                                                                      800.00),

                                                                                                     (CURDATE(), 7, 17, 7, 'Charmante maison familiale avec jardin à Lyon',
                                                                                                      'Belle maison de 5 pièces avec un jardin bien entretenu. Idéale pour une famille, elle offre un cadre de vie paisible tout en restant proche du centre-ville de Lyon. Parfait équilibre entre confort et praticité.',
                                                                                                      900.00),

                                                                                                     (CURDATE(), 8, 17, 10, 'Studio étudiant pratique au cœur de Toulouse',
                                                                                                      'Studio fonctionnel et bien situé, parfait pour les étudiants. À proximité immédiate des universités et des commerces, il offre tout le nécessaire pour une vie étudiante confortable.',
                                                                                                      1000.00),

                                                                                                     (CURDATE(), 9, 17, 11, 'Loft moderne et spacieux à Paris',
                                                                                                      'Superbe loft au design contemporain situé dans le prestigieux 8ème arrondissement. Espace de vie ouvert, lumineux et modulable. Une opportunité rare sur le marché parisien.',
                                                                                                      700.00),

                                                                                                     (CURDATE(), 10, 17, 13, 'Villa de luxe avec piscine à Antibes',
                                                                                                      'Magnifique villa avec vue mer, dotée d''une piscine privée et d''un jardin paysager. Cette propriété d''exception offre des prestations haut de gamme dans un cadre idyllique sur la Côte d''Azur.',
                                                                                                      950.00);