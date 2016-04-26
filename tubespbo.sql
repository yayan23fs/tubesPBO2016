-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2016 at 01:08 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nama` varchar(20) NOT NULL,
  `tglLahir` date NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(13) NOT NULL,
  `nip` varchar(9) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nama`, `tglLahir`, `alamat`, `telp`, `nip`, `status`) VALUES
('bapakatauibu', '1980-03-25', 'Buah Batu regency', '08560316906', '1111', 1),
('ibuibu', '1980-04-20', 'permata buah batu', '085603176907', '22223333', 0);

-- --------------------------------------------------------

--
-- Table structure for table `kelompokta`
--

CREATE TABLE `kelompokta` (
  `topik` varchar(30) NOT NULL,
  `dosen` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelompokta`
--

INSERT INTO `kelompokta` (`topik`, `dosen`) VALUES
('biometric_sensor', '1111'),
('internet_of_things', '1111'),
('topik3', '1111');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nama` varchar(20) NOT NULL,
  `tglLahir` date NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(13) NOT NULL,
  `nim` varchar(10) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `topik` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nama`, `tglLahir`, `alamat`, `telp`, `nim`, `status`, `topik`) VALUES
('Fauzan Yayan', '1991-04-23', 'jl. sukabirus', '081295787200', '1103091173', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tugasakhir`
--

CREATE TABLE `tugasakhir` (
  `nim` varchar(10) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `pembimbing1` varchar(9) DEFAULT NULL,
  `pembimbing2` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tugasakhir`
--

INSERT INTO `tugasakhir` (`nim`, `judul`, `pembimbing1`, `pembimbing2`) VALUES
('1103091173', 'sistem identifikasi', 'null', '1111');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `isdosen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `kode`, `isdosen`) VALUES
('dosen1', 'dosen1', '1111', 1),
('dosen2', 'dosen2', '22223333', 1),
('mahas1', 'mahas1', '1103091173', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `kelompokta`
--
ALTER TABLE `kelompokta`
  ADD PRIMARY KEY (`topik`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tugasakhir`
--
ALTER TABLE `tugasakhir`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
