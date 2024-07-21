-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (x86_64)
--
-- Host: localhost    Database: flowershop
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flower_shop`
--

DROP TABLE IF EXISTS `flower_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flower_shop` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `date_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flower_shop`
--

LOCK TABLES `flower_shop` WRITE;
/*!40000 ALTER TABLE `flower_shop` DISABLE KEYS */;
INSERT INTO `flower_shop` VALUES (3,'whitelilly','shop3','lillies','2024-06-16 13:09:41.647092','2024-06-16 13:09:41.647362'),(5,'whitelilly','shop2','lillies','2024-06-16 13:10:11.078593','2024-06-16 13:10:11.078695'),(6,'redrose','shop2','rose','2024-06-16 13:12:18.643515','2024-06-16 13:12:18.643657'),(7,'redrose','shop3','rose','2024-06-16 13:12:29.556808','2024-06-16 13:12:29.556873'),(9,'rose','shop2','whiterose','2024-06-27 12:41:09.428964','2024-06-27 12:41:09.429011'),(10,'rose','shop11','redrose','2024-06-27 20:44:31.255023','2024-06-27 20:44:31.255310'),(11,'rose','shop11','redrose','2024-06-27 20:45:25.937588','2024-06-27 20:45:25.937724'),(12,'rose','shop11','redrose','2024-06-27 20:45:37.327236','2024-06-27 20:45:37.327299'),(13,'rose','shop15','redrose','2024-06-27 20:45:58.219205','2024-06-27 20:45:58.219240'),(14,'lilly','shop15','whielilly','2024-06-27 20:46:34.526986','2024-06-27 20:46:34.527023'),(15,'lily','shop05','white lily','2024-06-27 20:47:14.756361','2024-06-27 20:47:14.756418'),(18,'whitelilly','shop17','lillies8','2024-07-02 14:50:08.459751','2024-07-02 14:50:08.459804'),(20,'whitelilly','shop5','lillies3','2024-07-02 18:46:26.792334','2024-07-02 18:46:26.792707'),(21,'whitelilly','shop17','lillies','2024-07-02 18:46:51.711855','2024-07-02 18:46:51.711969');
/*!40000 ALTER TABLE `flower_shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21 17:52:24
