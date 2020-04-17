-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Creato il: Apr 17, 2020 alle 12:11
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
-- Database: `shw2`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(400) NOT NULL,
  `Descrizione` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria_per_file`
--

DROP TABLE IF EXISTS `categoria_per_file`;
CREATE TABLE IF NOT EXISTS `categoria_per_file` (
  `ID_File` int(11) NOT NULL,
  `ID_Categoria` int(11) NOT NULL,
  PRIMARY KEY (`ID_File`,`ID_Categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `chat`
--

DROP TABLE IF EXISTS `chat`;
CREATE TABLE IF NOT EXISTS `chat` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username_chiamato` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Username_chiamato` (`Username_chiamato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `file`
--

DROP TABLE IF EXISTS `file`;
CREATE TABLE IF NOT EXISTS `file` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(400) NOT NULL,
  `Prezzo` double NOT NULL,
  `Genere` varchar(400) NOT NULL,
  `Anno_di_uscita` int(11) NOT NULL,
  `Paese_Provenienza` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `lista_acquisti`
--

DROP TABLE IF EXISTS `lista_acquisti`;
CREATE TABLE IF NOT EXISTS `lista_acquisti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username_Acquirente` varchar(200) NOT NULL,
  `ID_file` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Username_Acquirente` (`Username_Acquirente`),
  KEY `ID_file` (`ID_file`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `lista_partecipanti_blog`
--

DROP TABLE IF EXISTS `lista_partecipanti_blog`;
CREATE TABLE IF NOT EXISTS `lista_partecipanti_blog` (
  `ID_blog` int(11) NOT NULL,
  `Username_Partecipante` varchar(200) NOT NULL,
  PRIMARY KEY (`ID_blog`,`Username_Partecipante`),
  KEY `Username_Partecipante` (`Username_Partecipante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `Username` varchar(200) NOT NULL,
  `Nome` varchar(400) NOT NULL,
  `Cognome` varchar(400) NOT NULL,
  `Email` varchar(400) NOT NULL,
  `Password` varchar(400) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `Username_chiamato` FOREIGN KEY (`Username_chiamato`) REFERENCES `utente` (`Username`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limiti per la tabella `lista_acquisti`
--
ALTER TABLE `lista_acquisti`
  ADD CONSTRAINT `ID_file` FOREIGN KEY (`ID_file`) REFERENCES `file` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `Username_Acquirente` FOREIGN KEY (`Username_Acquirente`) REFERENCES `utente` (`Username`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limiti per la tabella `lista_partecipanti_blog`
--
ALTER TABLE `lista_partecipanti_blog`
  ADD CONSTRAINT `ID_blog` FOREIGN KEY (`ID_blog`) REFERENCES `blog` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `Username_Partecipante` FOREIGN KEY (`Username_Partecipante`) REFERENCES `utente` (`Username`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
