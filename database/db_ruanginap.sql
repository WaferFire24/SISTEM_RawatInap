-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_ruanginap
DROP DATABASE IF EXISTS `db_ruanginap`;
CREATE DATABASE IF NOT EXISTS `db_ruanginap` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_ruanginap`;

-- Dumping structure for table db_ruanginap.dokter
DROP TABLE IF EXISTS `dokter`;
CREATE TABLE IF NOT EXISTS `dokter` (
  `id_dokter` int(5) NOT NULL AUTO_INCREMENT,
  `nama_dokter` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_dokter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.dokter: ~2 rows (approximately)
/*!40000 ALTER TABLE `dokter` DISABLE KEYS */;
INSERT INTO `dokter` (`id_dokter`, `nama_dokter`) VALUES
	(1313, 'Rahman'),
	(2121, 'Dendi');
/*!40000 ALTER TABLE `dokter` ENABLE KEYS */;

-- Dumping structure for table db_ruanginap.pasien
DROP TABLE IF EXISTS `pasien`;
CREATE TABLE IF NOT EXISTS `pasien` (
  `id_pasien` int(5) NOT NULL AUTO_INCREMENT,
  `nama_pasien` varchar(50) DEFAULT NULL,
  `penyakit_pasien` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.pasien: ~2 rows (approximately)
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `penyakit_pasien`) VALUES
	(901, 'Balmond', 'Timor Otak'),
	(902, 'Alucard', 'Tumor Otak'),
	(903, 'Layla', 'Kanker Serviks');
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;

-- Dumping structure for table db_ruanginap.perawat
DROP TABLE IF EXISTS `perawat`;
CREATE TABLE IF NOT EXISTS `perawat` (
  `id_perawat` int(5) NOT NULL AUTO_INCREMENT,
  `nama_perawat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_perawat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.perawat: ~2 rows (approximately)
/*!40000 ALTER TABLE `perawat` DISABLE KEYS */;
INSERT INTO `perawat` (`id_perawat`, `nama_perawat`) VALUES
	(4033, 'Nur'),
	(5022, 'Siti');
/*!40000 ALTER TABLE `perawat` ENABLE KEYS */;

-- Dumping structure for table db_ruanginap.petugas
DROP TABLE IF EXISTS `petugas`;
CREATE TABLE IF NOT EXISTS `petugas` (
  `id_petugas` int(5) NOT NULL AUTO_INCREMENT,
  `tgl_masuk` date DEFAULT NULL,
  `tgl_keluar` date DEFAULT NULL,
  `id_dokter` int(5) DEFAULT NULL,
  `id_perawat` int(5) DEFAULT NULL,
  `id_pasien` int(5) DEFAULT NULL,
  `id_ruangan` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_petugas`),
  KEY `FK_petugas_dokter` (`id_dokter`),
  KEY `FK_petugas_perawat` (`id_perawat`),
  KEY `FK_petugas_pasien` (`id_pasien`),
  KEY `FK_petugas_ruangan` (`id_ruangan`),
  CONSTRAINT `FK_petugas_dokter` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`),
  CONSTRAINT `FK_petugas_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  CONSTRAINT `FK_petugas_perawat` FOREIGN KEY (`id_perawat`) REFERENCES `perawat` (`id_perawat`),
  CONSTRAINT `FK_petugas_ruangan` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.petugas: ~3 rows (approximately)
/*!40000 ALTER TABLE `petugas` DISABLE KEYS */;
INSERT INTO `petugas` (`id_petugas`, `tgl_masuk`, `tgl_keluar`, `id_dokter`, `id_perawat`, `id_pasien`, `id_ruangan`) VALUES
	(101, '2020-07-01', '2020-07-20', 2121, 4033, 902, 2),
	(102, '2020-07-01', '2020-07-25', 2121, 5022, 901, 3),
	(103, '2019-12-12', '2020-05-01', 1313, 4033, 903, 1);
/*!40000 ALTER TABLE `petugas` ENABLE KEYS */;

-- Dumping structure for table db_ruanginap.ruangan
DROP TABLE IF EXISTS `ruangan`;
CREATE TABLE IF NOT EXISTS `ruangan` (
  `id_ruangan` int(3) NOT NULL AUTO_INCREMENT,
  `nama_ruangan` varchar(25) DEFAULT NULL,
  `Jumlah` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_ruangan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.ruangan: ~2 rows (approximately)
/*!40000 ALTER TABLE `ruangan` DISABLE KEYS */;
INSERT INTO `ruangan` (`id_ruangan`, `nama_ruangan`, `Jumlah`) VALUES
	(1, 'Cendrawasih', 25),
	(2, 'Raflessia', 25),
	(3, 'Saphire', 25);
/*!40000 ALTER TABLE `ruangan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
