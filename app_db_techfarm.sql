-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: techfarm-mysql:3306
-- Generation Time: Cze 19, 2023 at 02:20 PM
-- Wersja serwera: 5.7.42
-- Wersja PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_db`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `green_house`
--

CREATE TABLE `green_house` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `houseNumber` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `green_house`
--

INSERT INTO `green_house` (`id`, `city`, `street`, `postCode`, `houseNumber`) VALUES
(3, 'Wygoda', 'Wygodna', '11-11', '1'),
(4, 'test_city', 'test_street', 'test_postCode', 'test_houseNumber');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sensor`
--

CREATE TABLE `sensor` (
  `id` int(11) NOT NULL,
  `series` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `greenHouse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensor`
--

INSERT INTO `sensor` (`id`, `series`, `model`, `greenHouse`) VALUES
(3, '1', 'm1', 3),
(6, '2', 'm1', 3),
(7, '2', 'm1', 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `statistic`
--

CREATE TABLE `statistic` (
  `id` int(11) NOT NULL,
  `sensor` int(11) NOT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `humidity` varchar(255) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `statistic`
--

INSERT INTO `statistic` (`id`, `sensor`, `temperature`, `humidity`, `createdAt`) VALUES
(3, 3, '1', '1', '2023-06-18 20:06:45'),
(4, 3, '1', '1', '2023-06-18 22:10:32'),
(5, 3, '1', '1', '2023-06-18 22:10:32'),
(6, 3, '1', '1', '2023-06-18 22:11:23'),
(7, 3, '1', '1', '2023-06-18 22:11:23'),
(9, 3, '1', '1', '2023-06-18 22:19:52'),
(10, 3, '1', '1', '2023-06-18 22:19:52'),
(11, 3, '1', '1', '2023-06-19 00:21:09'),
(12, 3, '1', '1', '2023-06-19 00:21:09'),
(13, 3, '1', '1', '2023-06-19 00:21:31'),
(14, 3, '1', '1', '2023-06-19 00:21:31'),
(15, 3, '1', '1', '2023-06-19 00:22:45'),
(16, 3, '1', '1', '2023-06-19 00:22:45'),
(17, 3, '1', '1', '2023-06-19 00:23:21'),
(18, 3, '1', '1', '2023-06-19 00:23:21'),
(19, 3, '1', '1', '2023-06-19 00:23:28'),
(20, 3, '1', '1', '2023-06-19 00:23:28'),
(21, 3, '1', '1', '2023-06-19 12:29:19'),
(22, 3, '1', '1', '2023-06-19 12:29:19'),
(23, 7, '1', '1', '2023-06-19 13:14:14'),
(24, 7, '2', '2', '2023-06-19 13:14:14');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `green_house`
--
ALTER TABLE `green_house`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `greenHouse` (`greenHouse`);

--
-- Indeksy dla tabeli `statistic`
--
ALTER TABLE `statistic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `statistic_ibfk_1` (`sensor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `green_house`
--
ALTER TABLE `green_house`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sensor`
--
ALTER TABLE `sensor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `statistic`
--
ALTER TABLE `statistic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sensor`
--
ALTER TABLE `sensor`
  ADD CONSTRAINT `sensor_ibfk_1` FOREIGN KEY (`greenHouse`) REFERENCES `green_house` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `statistic`
--
ALTER TABLE `statistic`
  ADD CONSTRAINT `statistic_ibfk_1` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
