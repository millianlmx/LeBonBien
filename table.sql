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
                        `SURFACE` decimal(10, 2) NOT NULL COMMENT 'Surface du bien en m²',
                        `NB_PIECES` int NOT NULL COMMENT 'Nombre de pièces',
                        `NB_CHAMBRES` int NOT NULL COMMENT 'Nombre de chambres',
                        `NB_SDB` int NOT NULL COMMENT 'Nombre de salles de bain',
                        `TYPE` varchar(50) NOT NULL COMMENT 'Type de bien Maison, Appartement, T2, T3 ...',
                        PRIMARY KEY (`ID_BIEN`),
                        KEY `BIEN_PROPRIETAIRE_fk` (`ID_PROPRIETAIRE`),
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