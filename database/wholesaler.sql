-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 10 fév. 2020 à 19:09
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `wholesaler`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `stock` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`id`, `name`, `available`, `stock`, `description`) VALUES
(1, 'Tournevis', 1, 12, 'Tournevis type phillips'),
(2, 'Pied-de-biche', 1, 55, 'Pied-de-biche'),
(3, 'Coffret clé à laine', 1, 90, 'De taille 6 à 26'),
(4, '', 1, 96, ''),
(5, '', 1, 11, ''),
(6, '', 0, 10, ''),
(7, '', 1, 32, ''),
(8, '', 1, 57, ''),
(9, '', 0, 61, ''),
(10, '', 0, 95, ''),
(11, '', 0, 1, ''),
(12, '', 1, 30, ''),
(13, '', 1, 15, ''),
(14, '', 1, 7, ''),
(15, '', 1, 48, ''),
(16, '', 0, 49, ''),
(17, '', 1, 71, ''),
(18, '', 0, 10, ''),
(19, '', 1, 38, ''),
(20, '', 1, 19, ''),
(21, '', 1, 84, ''),
(22, '', 1, 17, ''),
(23, '', 1, 59, ''),
(24, '', 0, 73, ''),
(25, '', 0, 6, ''),
(26, '', 1, 12, ''),
(27, '', 1, 46, ''),
(28, '', 0, 55, ''),
(29, '', 1, 30, ''),
(30, '', 0, 25, ''),
(31, '', 1, 58, ''),
(32, '', 1, 20, ''),
(33, '', 1, 69, ''),
(34, '', 0, 35, ''),
(35, '', 1, 5, ''),
(36, '', 1, 20, ''),
(37, '', 1, 25, ''),
(38, '', 1, 77, ''),
(39, '', 1, 45, ''),
(40, '', 0, 23, ''),
(41, '', 0, 76, '');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id`, `lastname`, `firstname`, `country`, `city`, `zipcode`, `tel`, `adress`, `active`) VALUES
(1, 'Toumi', 'Anis', 'Belgium', 'Flobecq', '7080', '0498035795', 'Plachettes 12', 1),
(63, 'Binnion', 'Naëlle', 'France', 'Clermont-Ferrand', '63019 CEDEX 2', '3944432975', '7 Northland Park', 1),
(64, 'Clouter', 'Clélia', 'France', 'Labège', '31673 CEDEX', '1927373360', '58 Nobel Trail', 1),
(65, 'Leverett', 'Gösta', 'France', 'Lille', '59715 CEDEX 9', '4222370846', '809 Lotheville Center', 0),
(66, 'Sanson', 'Åsa', 'France', 'Bordeaux', '33060 CEDEX', '6926265257', '1604 Mifflin Street', 1),
(67, 'Bosman', 'Erwéi', 'France', 'Le Bourget-du-Lac', '73379 CEDEX', '1417412559', '79956 Pennsylvania Street', 1),
(68, 'Braim', 'Loïs', 'France', 'Marseille', '13343 CEDEX 15', '8019606121', '2521 Lotheville Plaza', 1),
(69, 'Krishtopaittis', 'Simplifiés', 'France', 'Salon-de-Provence', '13654 CEDEX', '2158286425', '2877 Carioca Junction', 0),
(70, 'Brusin', 'Mà', 'France', 'Angoulême', '16999 CEDEX 9', '7682562340', '8464 Kedzie Terrace', 1),
(71, 'Farre', 'Pò', 'France', 'Saint-Priest-en-Jarez', '42275 CEDEX', '3699591093', '68262 Morningstar Crossing', 0),
(72, 'Ingray', 'Cléopatre', 'France', 'Angers', '49937 CEDEX 9', '5083576320', '743 Buhler Way', 0),
(73, 'Screach', 'Vénus', 'France', 'Chartres', '28009 CEDEX', '2053653062', '239 Helena Way', 0),
(74, 'Loutheane', 'Joséphine', 'France', 'Montpellier', '34194 CEDEX 5', '7951519516', '1265 Northfield Plaza', 1),
(75, 'Tussaine', 'Léonore', 'France', 'Strasbourg', '67953 CEDEX 9', '8673287718', '24025 Towne Junction', 0),
(76, 'Langlois', 'Torbjörn', 'France', 'Limoges', '87015 CEDEX 1', '3895236275', '3 Mayfield Crossing', 1),
(77, 'Vasyukhnov', 'Géraldine', 'France', 'Levallois-Perret', '92309 CEDEX', '4153571954', '52 Jackson Center', 1),
(78, 'Skitch', 'Françoise', 'France', 'Paris 19', '75949 CEDEX 19', '9993252676', '12563 Farwell Plaza', 0),
(79, 'Greenland', 'Danièle', 'France', 'Dijon', '21083 CEDEX 9', '1324921835', '82 Reindahl Trail', 1),
(80, 'Annatt', 'Dù', 'France', 'Paris 20', '75971 CEDEX 20', '9583079619', '361 Memorial Road', 1),
(81, 'Cough', 'Mélia', 'France', 'Reims', '51054 CEDEX', '6897533568', '5 Carberry Crossing', 1),
(82, 'Hallgalley', 'Cléa', 'France', 'Neuilly-sur-Seine', '92521 CEDEX', '4022765258', '4579 Rockefeller Point', 1),
(83, 'Celli', 'Eliès', 'Belgium', 'Tournai', '7504', '9994537334', '51846 Scofield Drive', 0),
(84, 'Beceril', 'Eléa', 'Belgium', 'Antwerpen', '2170', '4512049747', '5 Londonderry Pass', 1),
(85, 'Hoggan', 'Håkan', 'Belgium', 'Momignies', '6594', '9036183351', '1259 Russell Street', 0),
(86, 'Ginsie', 'Andréanne', 'Belgium', 'Bouillon', '6834', '3901710887', '9 Atwood Hill', 1),
(87, 'Arkow', 'Pénélope', 'Belgium', 'Péruwelz', '7604', '7296782760', '82 Ryan Court', 1),
(88, 'Fellgate', 'Pélagie', 'Belgium', 'Namur', '5100', '3241804787', '37 Basil Place', 1),
(89, 'Beale', 'Solène', 'Belgium', 'Ath', '7823', '9575916849', '3 Buhler Center', 1),
(90, 'Merrywether', 'Lén', 'Belgium', 'Momignies', '6594', '5119315829', '19 Scott Point', 0),
(91, 'Craigmile', 'Cinéma', 'Belgium', 'Momignies', '6594', '7479991784', '4 Holmberg Crossing', 0),
(92, 'Kairns', 'Gaétane', 'Belgium', 'Tournai', '7536', '2727359214', '26916 Loftsgordon Place', 0),
(93, 'Ansill', 'Pò', 'Belgium', 'Ath', '7823', '2955749971', '30 Oak Valley Drive', 0),
(94, 'Oughton', 'Edmée', 'Belgium', 'Tournai', '7504', '5706702763', '1 Springs Way', 0),
(95, 'Bellefant', 'Marlène', 'Belgium', 'Ath', '7823', '8438411575', '72934 Fisk Alley', 0),
(96, 'Geall', 'Kù', 'Belgium', 'Mons', '7032', '1183106091', '06969 Eagle Crest Hill', 1),
(97, 'Hambling', 'Gaétane', 'Belgium', 'Namur', '5100', '4004339418', '22463 Dunning Parkway', 0),
(98, 'Casin', 'Yóu', 'Belgium', 'Bruxelles', '1050', '2566629810', '8 Shelley Point', 1),
(99, 'Harsum', 'Vérane', 'Belgium', 'Momignies', '6594', '2543219328', '816 Holy Cross Pass', 0),
(100, 'Skinley', 'Angélique', 'Belgium', 'Momignies', '6594', '6749229768', '84 Dahle Avenue', 1),
(101, 'Noni', 'Crééz', 'Belgium', 'Ninove', '9404', '7245234518', '797 Lake View Parkway', 0),
(102, 'Fairey', 'Maëly', 'Belgium', 'Charleroi', '6042', '7992845919', '0 Mayer Trail', 1);

-- --------------------------------------------------------

--
-- Structure de la table `histo_art`
--

DROP TABLE IF EXISTS `histo_art`;
CREATE TABLE IF NOT EXISTS `histo_art` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `vat_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_histo_articles` (`article_id`),
  KEY `fk_histo_art_vat` (`vat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `histo_art`
--

INSERT INTO `histo_art` (`id`, `article_id`, `date`, `price`, `vat_id`) VALUES
(1, 1, '2019-09-23', '17.50', 1),
(2, 2, '2018-04-13', '17.40', 1),
(3, 2, '2018-11-13', '18.20', 1),
(4, 3, '2018-09-23', '15.00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
CREATE TABLE IF NOT EXISTS `invoices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `date` date NOT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoices_clients` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `invoices`
--

INSERT INTO `invoices` (`id`, `number`, `date`, `client_id`) VALUES
(1, 1, '2019-10-13', 1),
(2, 2, '2019-11-17', 1);

-- --------------------------------------------------------

--
-- Structure de la table `inv_art`
--

DROP TABLE IF EXISTS `inv_art`;
CREATE TABLE IF NOT EXISTS `inv_art` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_id` int(11) NOT NULL,
  `art_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inv_art_inv` (`inv_id`),
  KEY `fk_inv_art_art` (`art_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inv_art`
--

INSERT INTO `inv_art` (`id`, `inv_id`, `art_id`, `amount`) VALUES
(1, 1, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `lastname`, `firstname`, `login`, `password`, `active`) VALUES
(1, 'Admin', 'Admin', 'Admin', 'Admin', 1),
(2, 'O\'Gormley', 'Angèle', 'ipsum', 'VN4cxc7GmdM', 0),
(3, 'Robillart', 'Cléopatre', 'pretium', 'Q90WpYC8x7CW', 1),
(4, 'Glanert', 'Magdalène', 'vivamus', 'SEJc0a', 1),
(5, 'Bamford', 'Séréna', 'in', 'hkhnOcrnMCw', 1),
(6, 'Itzhaiek', 'Mylène', 'suspendisse', '65TttY1o', 1),
(7, 'Corlett', 'Nuó', 'hac', 'afywZtu', 1),
(8, 'Caffin', 'Anaël', 'sapien', 'od0ew5ru33R', 1),
(9, 'Alpin', 'Estée', 'vestibulum', 'havgF1XoRuxE', 0),
(10, 'Harnetty', 'Eléonore', 'vivamus', 'tWxfnb', 0),
(11, 'Cund', 'Lén', 'morbi', 'TYp4e4', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vat`
--

DROP TABLE IF EXISTS `vat`;
CREATE TABLE IF NOT EXISTS `vat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rate` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vat`
--

INSERT INTO `vat` (`id`, `rate`) VALUES
(1, 21),
(2, 12),
(3, 6),
(4, 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `histo_art`
--
ALTER TABLE `histo_art`
  ADD CONSTRAINT `fk_histo_art_vat` FOREIGN KEY (`vat_id`) REFERENCES `vat` (`id`),
  ADD CONSTRAINT `fk_histo_articles` FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`);

--
-- Contraintes pour la table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `fk_invoices_clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

--
-- Contraintes pour la table `inv_art`
--
ALTER TABLE `inv_art`
  ADD CONSTRAINT `fk_inv_art_art` FOREIGN KEY (`art_id`) REFERENCES `articles` (`id`),
  ADD CONSTRAINT `fk_inv_art_inv` FOREIGN KEY (`inv_id`) REFERENCES `invoices` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
