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

-- Dumping structure for table db_ruanginap.petugas_kamar
DROP TABLE IF EXISTS `petugas_kamar`;
CREATE TABLE IF NOT EXISTS `petugas_kamar` (
  `id_petugas` int(5) NOT NULL AUTO_INCREMENT,
  `nama_petugas` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Daftar petugas kamar rawat inap\r\n';

-- Dumping data for table db_ruanginap.petugas_kamar: ~4 rows (approximately)
/*!40000 ALTER TABLE `petugas_kamar` DISABLE KEYS */;
INSERT INTO `petugas_kamar` (`id_petugas`, `nama_petugas`) VALUES
	(101, 'abidin'),
	(102, 'Saleh'),
	(104, 'Ibnu'),
	(105, 'Ijar');
/*!40000 ALTER TABLE `petugas_kamar` ENABLE KEYS */;

-- Dumping structure for table db_ruanginap.ruangan
DROP TABLE IF EXISTS `ruangan`;
CREATE TABLE IF NOT EXISTS `ruangan` (
  `id_ruangan` int(3) NOT NULL AUTO_INCREMENT,
  `n_pasien` varchar(50) DEFAULT NULL,
  `penyakit` varchar(50) DEFAULT NULL,
  `n_dokter` varchar(50) DEFAULT NULL,
  `id_petugas` int(5) DEFAULT NULL,
  `tgl_masuk` date DEFAULT NULL,
  `tgl_keluar` date DEFAULT NULL,
  PRIMARY KEY (`id_ruangan`),
  KEY `FK_ruangan_petugas_kamar` (`id_petugas`),
  CONSTRAINT `FK_ruangan_petugas_kamar` FOREIGN KEY (`id_petugas`) REFERENCES `petugas_kamar` (`id_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_ruanginap.ruangan: ~3 rows (approximately)
/*!40000 ALTER TABLE `ruangan` DISABLE KEYS */;
INSERT INTO `ruangan` (`id_ruangan`, `n_pasien`, `penyakit`, `n_dokter`, `id_petugas`, `tgl_masuk`, `tgl_keluar`) VALUES
	(200, 'Storm', 'Kejang-kejang', 'Nurdin', 102, '2020-07-09', '2020-07-11'),
	(201, 'Bara', 'Jantung', 'Saiful', 105, '2020-07-09', '2020-10-10'),
	(203, 'Raja', 'Asma', 'Syahputra', 104, '2019-03-04', '2019-03-04');
/*!40000 ALTER TABLE `ruangan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
