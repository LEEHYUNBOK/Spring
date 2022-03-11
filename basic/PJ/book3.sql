CREATE DATABASE  IF NOT EXISTS `book3` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `book3`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: book3
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `categoryId` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book_category` (`categoryId`),
  CONSTRAINT `FK_book_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'죄와벌','도스토예프스키',1,10000),(3,'레미제라블','빅토르 위고',1,11000),(4,'나나','에밀졸라',1,9000),(5,'그리스인 조르바','카잔차카스',1,8000),(9,'노인과 바다','헤밍웨이',1,8500),(10,'돈키호테','세르반테스',1,9500),(11,'리어 왕','세익스피어',1,9000),(12,'몽테크리스토 백작','뒤마',1,10000),(13,'모비딕','멜빌',1,10000),(14,'바람과 함께 사라지다','마가렛 미첼',1,12000),(15,'실낙원','밀턴',1,9000),(16,'토지','박경리',1,13000),(17,'경제학 개론','홍길동',3,10000),(18,'미시경제학','임꺽정',3,9000),(19,'거시경제학','온달',3,9000),(20,'자본시장론','평강',3,9500),(21,'지질학개론','홍길동',4,10000),(22,'천문학개론','임꺽정',4,1500),(24,'과학사','전우치',4,3000),(25,'동양문화사','온달',5,4000),(26,'동북아시아고대사','평강',5,5000),(27,'중세유럽사','홍길동',5,6000),(28,'영국사','임꺽정',5,7000),(29,'환율의 미래','전우치',3,11000),(30,'ETF 투자','홍길동',3,9000),(31,'에너지 혁명','온달',3,8000),(32,'해양학 개론','임꺽정',4,10000),(33,'식물학 개론','홍길동',4,11000),(34,'동물학 개론','전우치',4,15000),(35,'미생물학 개론','전우치',4,9000),(36,'지구과학 개론','전우치',4,8000),(37,'미국사','임꺽정',5,5000),(39,'한국사','임꺽정',5,6000),(40,'고구려사','전우치',5,10000),(41,'고려사','전우치',5,9000),(42,'조선사','온달',5,8000),(43,'고조선사','온달',5,13000),(44,'일본역사','홍길동',5,9000),(45,'중국사','홍길동',5,15000),(46,'러시아사','홍길동',5,10000),(47,'유라시아역사','홍길동',5,9000),(48,'새책','홍길동',2,10000);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'소설'),(2,'수필'),(3,'경제'),(4,'과학'),(5,'역사');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-03 15:08:45
