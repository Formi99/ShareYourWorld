-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Creato il: Apr 21, 2020 alle 12:57
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
-- Database: `shareyourworld`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria_per_file`
--

DROP TABLE IF EXISTS `categoria_per_file`;
CREATE TABLE IF NOT EXISTS `categoria_per_file` (
  `ID_File` int(11) NOT NULL,
  `ID_categoria` int(11) NOT NULL,
  PRIMARY KEY (`ID_File`,`ID_categoria`),
  KEY `ID_categoria` (`ID_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `chat`
--

DROP TABLE IF EXISTS `chat`;
CREATE TABLE IF NOT EXISTS `chat` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `file`
--

DROP TABLE IF EXISTS `file`;
CREATE TABLE IF NOT EXISTS `file` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(400) NOT NULL,
  `Genere` varchar(400) NOT NULL,
  `Anno_di_uscita` int(11) NOT NULL,
  `Prezzo` decimal(10,0) NOT NULL,
  `Paese_Provenienza` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `lista_chat`
--

DROP TABLE IF EXISTS `lista_chat`;
CREATE TABLE IF NOT EXISTS `lista_chat` (
  `ID_chat` int(11) NOT NULL,
  `ID_utente_chiamato` int(11) NOT NULL,
  `messaggio` varchar(1500) NOT NULL,
  `ora` date NOT NULL,
  PRIMARY KEY (`ID_chat`,`ID_utente_chiamato`),
  KEY `ID_utente_chiamato` (`ID_utente_chiamato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `lista_partecipanti_blog`
--

DROP TABLE IF EXISTS `lista_partecipanti_blog`;
CREATE TABLE IF NOT EXISTS `lista_partecipanti_blog` (
  `ID_utente` int(11) NOT NULL,
  `ID_blog` int(11) NOT NULL,
  `Messaggio` varchar(1500) NOT NULL,
  `Data` date NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_blog`),
  KEY `ID_blog` (`ID_blog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(400) NOT NULL,
  `email` varchar(400) NOT NULL,
  `password` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `categoria_per_file`
--
ALTER TABLE `categoria_per_file`
  ADD CONSTRAINT `ID_categoria` FOREIGN KEY (`ID_categoria`) REFERENCES `categoria` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `ID_file` FOREIGN KEY (`ID_File`) REFERENCES `file` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limiti per la tabella `lista_chat`
--
ALTER TABLE `lista_chat`
  ADD CONSTRAINT `ID_chat` FOREIGN KEY (`ID_chat`) REFERENCES `chat` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `ID_utente_chiamato` FOREIGN KEY (`ID_utente_chiamato`) REFERENCES `utente` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limiti per la tabella `lista_partecipanti_blog`
--
ALTER TABLE `lista_partecipanti_blog`
  ADD CONSTRAINT `ID_blog` FOREIGN KEY (`ID_blog`) REFERENCES `blog` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `ID_utente` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
