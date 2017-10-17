-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2017 at 01:29 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anpr`
--

-- --------------------------------------------------------

--
-- Table structure for table `cominfo`
--

CREATE TABLE `cominfo` (
  `InspectiontID` int(11) NOT NULL,
  `NumberPlate` varchar(16) NOT NULL,
  `DriverLicense` varchar(11) DEFAULT NULL,
  `Location` varchar(15) NOT NULL,
  `BluebookConcordance` varchar(3) NOT NULL,
  `Model` varchar(20) NOT NULL,
  `Comment` varchar(30) NOT NULL,
  `MaPaSe` varchar(3) NOT NULL,
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cominfo`
--

INSERT INTO `cominfo` (`InspectiontID`, `NumberPlate`, `DriverLicense`, `Location`, `BluebookConcordance`, `Model`, `Comment`, `MaPaSe`, `Date`) VALUES
(8, 'BA 59 PA 5921', '13456', 'handbag', 'Yes', 'Honda CB Unicorn', 'hfbbc', 'Yes', '2016-08-29 00:19:19'),
(10, 'BA 59 PA 5921', '86040', 'years', 'Yes', 'Honda CB Unicorn', 'bfvhdb', 'Yes', '2016-08-29 00:19:19'),
(14, 'BA 59 PA 5921', '789102', 'bhaisipati', 'Yes', 'Honda CB Unicorn', 'gawp', 'Yes', '2016-08-29 00:20:13'),
(15, 'BA 59 PA 5921', '1782635', 'Bhaisipati', 'No', 'Honda CB Unicorn', '', 'Yes', '2016-08-29 07:32:39'),
(16, 'BA 59 PA 5921', '0', 'ktm', 'Yes', 'Honda CB Unicorn', '', 'No', '2016-08-29 09:50:18'),
(17, 'BA 37 PA 5259', '0', '', 'No', 'Mahindra Flyte', '', 'No', '2016-08-29 10:38:32'),
(18, 'BA 59 PA 5921', '', '', 'No', 'Honda CB Unicorn', '', 'No', '2016-08-29 11:50:21');

-- --------------------------------------------------------

--
-- Table structure for table `policeinfo`
--

CREATE TABLE `policeinfo` (
  `PoliceID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `PhoneNumber` int(11) NOT NULL,
  `Age` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policeinfo`
--

INSERT INTO `policeinfo` (`PoliceID`, `Name`, `PhoneNumber`, `Age`, `Email`, `Password`) VALUES
(123, '123', 123, 123, '123', '123'),
(1234, 'gejjd', 12345, 30, 'hshuud@heard.com', 'qwertyuiop');

-- --------------------------------------------------------

--
-- Table structure for table `vehicleinfo`
--

CREATE TABLE `vehicleinfo` (
  `NumberPlate` varchar(20) NOT NULL,
  `Model` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicleinfo`
--

INSERT INTO `vehicleinfo` (`NumberPlate`, `Model`) VALUES
('BA 31 PA 3108', 'Mahindra Gusto'),
('BA 37 PA 5259', 'Mahindra Flyte'),
('BA 59 PA 5921', 'Honda CB Unicorn'),
('NA 21 CHA 2012', 'Honda Civic');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cominfo`
--
ALTER TABLE `cominfo`
  ADD PRIMARY KEY (`InspectiontID`);

--
-- Indexes for table `policeinfo`
--
ALTER TABLE `policeinfo`
  ADD PRIMARY KEY (`PoliceID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `vehicleinfo`
--
ALTER TABLE `vehicleinfo`
  ADD PRIMARY KEY (`NumberPlate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cominfo`
--
ALTER TABLE `cominfo`
  MODIFY `InspectiontID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
