-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 20, 2022 at 03:17 PM
-- Server version: 8.0.28-0ubuntu0.20.04.3
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TP1`
--

-- --------------------------------------------------------

--
-- Table structure for table `Auteur`
--

CREATE TABLE `Auteur` (
  `matricule` int NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `genre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Auteur`
--

INSERT INTO `Auteur` (`matricule`, `nom`, `prenom`, `genre`) VALUES
(1, 'nom1', 'prenom1', 'Feminin');

-- --------------------------------------------------------

--
-- Table structure for table `Livre`
--

CREATE TABLE `Livre` (
  `isbn` int NOT NULL,
  `titre` varchar(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `date_editing` varchar(20) DEFAULT NULL,
  `editeur` varchar(20) DEFAULT NULL,
  `matricule` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Livre`
--

INSERT INTO `Livre` (`isbn`, `titre`, `description`, `date_editing`, `editeur`, `matricule`) VALUES
(1, 'titre1', 'desc1', 'date1', 'DUNOND', 1);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`email`, `password`, `role`) VALUES
('admin@admin.com', 'admin', 'Admin'),
('user@user.com', 'user', 'Visiteur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auteur`
--
ALTER TABLE `Auteur`
  ADD PRIMARY KEY (`matricule`);

--
-- Indexes for table `Livre`
--
ALTER TABLE `Livre`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `maricule` (`matricule`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Livre`
--
ALTER TABLE `Livre`
  ADD CONSTRAINT `Livre_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `Auteur` (`matricule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
