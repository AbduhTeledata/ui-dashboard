# Host: localhost  (Version: 5.5.55)
# Date: 2024-03-08 10:29:21
# Generator: MySQL-Front 5.3  (Build 1.18)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "biaya"
#

DROP TABLE IF EXISTS `biaya`;
CREATE TABLE `biaya` (
  `id_biaya` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nama_biaya` varchar(30) NOT NULL,
  `harga` int(30) NOT NULL,
  PRIMARY KEY (`id_biaya`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "biaya"
#

#INSERT INTO `biaya` VALUES (1,'Reguler ',20000);

#
# Source for table "orders"
#

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id_order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `no_meja` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `no_order` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jam_mulai` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jam_selesai` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_biaya_sewa` int(11) NOT NULL,
  `durasi` int(11) NOT NULL,
  `diskon` int(11) DEFAULT NULL,
  `status_order` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_pembayaran` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal_order` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "orders"
#

#INSERT INTO `orders` VALUES (1,NULL,'1','A0001','2024-01-11T14:36:17+07:00','2024-01-11T17:59:17+07:00',100000,2,2,'selesai','lunas','2024-02-13'),(2,NULL,'2','A0002','2024-01-11T14:39:17+07:00','2024-01-11T17:20:17+07:00',100000,2,2,'selesai','lunas','2024-02-13'),(3,NULL,'2','A0003','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',100000,2,2,'selesai','lunas','2024-02-13'),(4,NULL,'8','705444329','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,2,6,'selesai','lunas','2024-01-13'),(5,NULL,'5','855227459','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,10,4,'selesai','lunas','2024-01-13'),(6,NULL,'1','597242611','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,6,1,'selesai','lunas','2024-01-13'),(7,NULL,'7','893089307','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,2,8,'selesai','lunas','2024-01-13'),(8,NULL,'2','530777287','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,8,10,'selesai','lunas','2024-01-13'),(9,NULL,'7','639924184','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,6,10,'selesai','lunas','2024-01-13'),(10,NULL,'2','516481974','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,4,3,'selesai','lunas','2024-01-13'),(11,NULL,'6','407597623','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,9,3,'selesai','lunas','2024-01-13'),(12,NULL,'7','939875797','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,4,0,'selesai','lunas','2024-01-13'),(13,NULL,'6','551325074','2024-01-11T19:21:17+07:00','2024-01-11T17:05:17+07:00',177737,8,8,'selesai','lunas','2024-01-13');

#
# Source for table "pengguna"
#

DROP TABLE IF EXISTS `pengguna`;
CREATE TABLE `pengguna` (
  `id_pengguna` char(10) NOT NULL,
  `nama_pengguna` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `telp_pengguna` varchar(15) NOT NULL,
  `alamat_pengguna` varchar(100) NOT NULL,
  `level` varchar(5) NOT NULL,
  PRIMARY KEY (`id_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "pengguna"
#

#INSERT INTO `pengguna` VALUES ('1','abduh','abduh','abduh','082128421871','Bandung','1'),('2','hazlam','hazlam','hazlam','08213456','Baleendah','1'),('3','hazlam','hazlam','hazlam','08213456','Baleendah','1'),('4','hazlam','hazlam','hazlam','08213456','Baleendah','1'),('5','abduh','abduh','abduh','08234445','Baleendah','1');

#
# Source for table "transaksi"
#

DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi` (
  `id_order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `no_meja` varchar(30) NOT NULL,
  `jam_mulai` varchar(30) NOT NULL,
  `jam_selesai` varchar(30) NOT NULL,
  `total_biaya` varchar(50) NOT NULL,
  `durasi` varchar(30) NOT NULL,
  `member` varchar(30) NOT NULL,
  `diskon` varchar(30) DEFAULT NULL,
  `status_order` varchar(10) NOT NULL,
  `status_bayar` varchar(50) NOT NULL,
  `tanggal_order` varchar(50) NOT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;

#
# Data for table "transaksi"
#

#INSERT INTO `transaksi` VALUES (1,'1','12:3:1','13:2:1','20000','2','Member','0','1','Lunas','2024-02-03'),(18,'1','00:25:06','00:25:06','105000','1:1','Paket','0','1','Lunas','2024-03-05'),(19,'1','01:46:18','01:46:18','75000','1:5','Paket','0','1','Lunas','2024-03-05'),(20,'1','02:44:11','02:44:11','75000','1:3','Paket','0','1','Lunas','2024-03-05'),(21,'1','02:52:11','02:52:11','75000','1:3','Paket','0','1','Lunas','2024-03-05'),(22,'1','02:57:34','03:59:34','75000','1:2','Paket','0','1','Lunas','2024-03-05'),(23,'1','06:16:48','07:18:48','30000','1:2','Reguler','0','1','Lunas','2024-03-05'),(24,'1','06:17:52','08:17:52','60000','2:0','Reguler','0','1','Lunas','2024-03-05'),(25,'1','10:25:14','11:25:14','30000','1:0','Reguler','0','1','Lunas','2024-03-05'),(26,'1','10:35:11','10:35:11','0','0:0','Loss Reguler','0','1','Lunas','2024-03-05'),(27,'1','10:21:34','10:21:34','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(28,'1','10:24:24','10:24:24','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(29,'1','10:26:37','10:26:37','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(30,'1','10:29:54','10:29:54','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(31,'1','10:33:33','10:33:33','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(32,'1','10:39:33','10:39:33','0','0:0','Reguler','0','1','Lunas','2024-03-06'),(33,'1','10:45:14','10:45:14','0','0:0','Paket','0','1','Lunas','2024-03-06'),(34,'1','10:46:16','11:48:16','30000','1:2','Paket','0','1','Lunas','2024-03-06'),(35,'1','10:47:46','10:47:46','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(36,'1','10:48:42','11:50:42','30000','1:2','Paket','0','1','Lunas','2024-03-06'),(37,'1','10:51:07','10:51:07','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(38,'1','10:52:31','11:52:31','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(39,'1','10:57:47','11:57:47','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(40,'1','11:12:18','11:12:18','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(41,'1','11:35:34','11:35:34','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(42,'1','11:40:15','11:40:15','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(43,'1','11:41:17','11:41:17','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(44,'1','11:45:33','11:45:33','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(45,'1','11:48:55','11:48:55','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(46,'1','11:53:48','12:53:48','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(47,'1','12:02:29','13:02:29','30000','1:0','Reguler','0','1','Lunas','2024-03-06'),(48,'1','12:20:04','13:20:04','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(49,'1','12:21:21','13:21:21','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(50,'1','12:27:52','12:27:52','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(51,'1','12:29:10','12:29:10','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(52,'1','12:32:41','13:32:41','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(53,'1','12:47:44','12:47:44','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(54,'1','12:50:53','12:50:53','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(55,'1','12:52:56','12:52:56','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(56,'1','12:53:36','12:53:36','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(57,'1','12:55:58','12:55:58','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(58,'1','12:57:59','12:57:59','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(59,'1','12:59:20','12:59:20','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(60,'1','13:13:47','13:13:47','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(61,'1','13:16:55','13:16:55','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(62,'1','13:17:54','13:17:54','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(63,'1','13:25:25','13:25:25','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(64,'1','13:58:24','13:58:24','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(65,'1','14:09:09','14:09:09','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(66,'1','14:10:32','14:10:32','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(67,'1','14:20:58','14:20:58','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(68,'1','14:22:36','14:22:36','0','0:0','Free Reguler','0','1','Lunas','2024-03-06'),(69,'1','14:28:16','14:28:16','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(70,'1','14:40:48','14:40:48','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(71,'1','14:42:07','14:42:07','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(72,'1','15:12:05','15:12:05','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(73,'1','15:34:39','15:34:39','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(74,'1','15:38:29','15:38:29','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(75,'1','15:40:44','15:40:44','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(76,'1','15:41:30','16:41:30','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(77,'1','15:45:03','16:45:03','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(78,'1','17:53:18','17:53:18','0','0:0','Loss Reguler','0','1','Lunas','2024-03-06'),(79,'1','17:58:26','18:58:26','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(80,'1','17:59:41','18:59:41','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(81,'1','18:10:21','19:10:21','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(82,'1','18:18:01','19:18:01','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(83,'1','18:25:21','19:25:21','30000','1:0','Paket','0','1','Lunas','2024-03-06'),(84,'1','09:27:16','09:27:16','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(85,'1','09:32:39','10:32:39','30000','1:0','Paket','0','1','Lunas','2024-03-07'),(86,'1','09:41:46','09:41:46','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(87,'1','09:45:25','09:45:25','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(88,'1','09:51:47','09:51:47','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(89,'1','09:54:21','09:54:21','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(90,'1','09:55:38','09:55:38','0','0:0','Loss Reguler','0','1','Lunas','2024-03-07'),(91,'1','09:59:44','10:59:44','30000','1:0','Paket','0','1','Lunas','2024-03-07'),(92,'1','12:56:06','13:56:06','30000','1:0','Paket','0','1','Lunas','2024-03-07'),(93,'1','16:15:08','17:15:08','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(94,'1','16:17:05','17:17:05','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(95,'1','16:19:12','17:19:12','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(96,'1','16:26:22','17:26:22','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(97,'1','16:29:29','17:29:29','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(98,'1','16:30:51','17:30:51','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(99,'1','16:42:36','17:42:36','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(100,'1','16:45:25','17:45:25','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(101,'1','16:47:30','17:47:30','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(102,'1','16:55:36','17:55:36','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(103,'1','16:56:19','17:56:19','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(104,'1','16:57:39','17:57:39','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(105,'1','17:00:24','18:00:24','30000','1:0','Paket','0','0','Lunas','2024-03-07'),(106,'1','17:52:48','18:52:48','30000','1:0','Paket','0','01','Lunas','2024-03-07'),(107,'1','17:56:27','18:56:27','30000','1:0','Paket','0','1','Lunas','2024-03-07'),(108,'1','18:03:15','19:03:15','30000','1:0','Paket','0','1','Lunas','2024-03-07'),(109,'1','18:05:37','19:05:37','30000','1:0','Paket','0','1','Lunas','2024-03-07');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
