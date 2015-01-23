-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.28 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2015-01-23 18:44:46
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for prizypricer
DROP DATABASE IF EXISTS `prizypricer`;
CREATE DATABASE IF NOT EXISTS `prizypricer` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `prizypricer`;


-- Dumping structure for table prizypricer.t_product
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE IF NOT EXISTS `t_product` (
  `BAR_CODE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BAR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table prizypricer.t_product: ~1 rows (approximately)
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` (`BAR_CODE`, `DESCRIPTION`, `NAME`) VALUES
	('1001A', 'This is barcode for soap', 'SOAP'),
	('1002A', 'This is barcode for Oil', 'OIL'),
	('1003A', 'This is barcode for shampoo', 'Shampoo'),
	('1004A', 'This is barcode for Cream', 'Cream');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;


-- Dumping structure for table prizypricer.t_product_details
DROP TABLE IF EXISTS `t_product_details`;
CREATE TABLE IF NOT EXISTS `t_product_details` (
  `CODE` varchar(50),
  `PRICE` float,
  `STORE_NAME` varchar(100),
  `NOTES` varchar(100) DEFAULT NULL,
  KEY `FK_t_product_details_t_product` (`CODE`),
  CONSTRAINT `FK_t_product_details_t_product` FOREIGN KEY (`CODE`) REFERENCES `t_product` (`BAR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table prizypricer.t_product_details: ~1 rows (approximately)
/*!40000 ALTER TABLE `t_product_details` DISABLE KEYS */;
INSERT INTO `t_product_details` (`CODE`, `PRICE`, `STORE_NAME`, `NOTES`) VALUES
	('1001A', 50, 'ABC', 'hkhkl'),
	('1001A', 30, 'ABC', 'sdafsadf'),
	('1001A', 37, 'Apna Bazar', 'this is price at Apna Bazar'),
	('1002A', 55, 'Dmart', 'this is price at Dmart'),
	('1003A', 10.1, 'EasyDay', 'this is price at easy day');
/*!40000 ALTER TABLE `t_product_details` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
