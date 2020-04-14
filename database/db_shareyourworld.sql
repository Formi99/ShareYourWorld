-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Creato il: Apr 14, 2020 alle 14:53
-- Versione del server: 8.0.18
-- Versione PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_shareyourworld`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `acquisto`
--

DROP TABLE IF EXISTS `acquisto`;
CREATE TABLE IF NOT EXISTS `acquisto` (
  `materiale_titolo` varchar(50) NOT NULL,
  `utente_username` varchar(15) NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`materiale_titolo`,`utente_username`),
  KEY `materiale_titolo` (`materiale_titolo`),
  KEY `utente_username` (`utente_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `anime/manga`
--

DROP TABLE IF EXISTS `anime/manga`;
CREATE TABLE IF NOT EXISTS `anime/manga` (
  `materiale_titolo` varchar(50) NOT NULL,
  `materiale_anno` year(4) NOT NULL,
  `episodi` int(11) NOT NULL,
  `materiale_paese` varchar(20) NOT NULL,
  `materiale_genere` varchar(100) NOT NULL,
  `materiale_prezzo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`materiale_titolo`),
  KEY `materiale_titolo` (`materiale_titolo`),
  KEY `materiale_anno` (`materiale_anno`),
  KEY `materiale_paese` (`materiale_paese`),
  KEY `materiale_genere` (`materiale_genere`),
  KEY `materiale_prezzo` (`materiale_prezzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `materiale_titolo` varchar(50) NOT NULL,
  `pagine` int(11) NOT NULL,
  `materiale_paese` varchar(20) NOT NULL,
  `materiale_genere` varchar(100) NOT NULL,
  `materiale_anno` year(4) NOT NULL,
  `trama` varchar(1000) NOT NULL,
  `materiale_prezzo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`materiale_titolo`),
  KEY `materiale_titolo` (`materiale_titolo`),
  KEY `materiale_paese` (`materiale_paese`),
  KEY `materiale_genere` (`materiale_genere`),
  KEY `materiale_anno` (`materiale_anno`),
  KEY `materiale_prezzo` (`materiale_prezzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `materiale`
--

DROP TABLE IF EXISTS `materiale`;
CREATE TABLE IF NOT EXISTS `materiale` (
  `titolo` varchar(50) NOT NULL,
  `paese` varchar(20) NOT NULL,
  `genere` varchar(100) NOT NULL,
  `anno` year(4) NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`titolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `musica`
--

DROP TABLE IF EXISTS `musica`;
CREATE TABLE IF NOT EXISTS `musica` (
  `materiale_titolo` varchar(50) NOT NULL,
  `durata` int(11) NOT NULL,
  `materiale_genere` varchar(20) NOT NULL,
  `materiale_anno` year(4) NOT NULL,
  `materiale_prezzo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`materiale_titolo`),
  KEY `materiale_titolo` (`materiale_titolo`),
  KEY `materiale_genere` (`materiale_genere`),
  KEY `materiale_anno` (`materiale_anno`),
  KEY `materiale_prezzo` (`materiale_prezzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `username` varchar(15) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
