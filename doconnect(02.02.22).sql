-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: doconnect
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminid` int NOT NULL AUTO_INCREMENT,
  `adminname` varchar(255) NOT NULL,
  `email` varchar(225) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Karthik Veeresh Tippeshetti','karthikveeresh.tippe@hcl.com','1234'),(2,'Karthik Veeresh Tippeshetti','tkarthik642@gmail.com','1234'),(3,'Karthik Veeresh Tippeshetti','roya@test.com','1234');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `answerimage` text,
  `answername` text NOT NULL,
  `astatus` int NOT NULL,
  `question_id` int NOT NULL,
  `user_userid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id_idx` (`question_id`) /*!80000 INVISIBLE */,
  KEY `user_userid_idx` (`user_userid`) /*!80000 INVISIBLE */,
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `userid` FOREIGN KEY (`user_userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (2,'no image','Science is the study of the physical and natural world through observations and experiments. Science is all around us. Right now, the fact that you exist and are in the process of reading this lesson is science. The process of creating the air we breathe - also science. The food we enjoy, water we drink, and clothes we wear are all based in science. Looking up into the atmosphere gives us a glimpse into astronomy, another branch of science. You can\'t get around it. Science is everywhere and is one of the most important topics of study in our world.',0,1,2),(3,'no image','next anser',0,4,2),(6,NULL,'another answer',0,1,4),(8,NULL,'It is a study of living.',0,1,6),(10,NULL,'Answer',0,1,4),(11,NULL,'Science is subject of nature',0,1,6),(12,NULL,'Electromagnetism is a branch of physics',0,4,4),(13,NULL,'Addition is a Mathematical operation.',0,15,4),(16,NULL,'The carbon monoxide molecule contains a total of 1 bond (s) There are 1 non-H bond (s), 1 multiple bond (s) and 1 triple bond (s).',0,8,6),(17,NULL,'Restart MATLAB',0,17,4),(18,NULL,'Angular is a framework built on JS',0,16,7),(19,NULL,'Answer from ma\'am',0,1,12);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qstatus` int NOT NULL,
  `questionimage` text,
  `questionname` text NOT NULL,
  `topic_topicid` int NOT NULL,
  `user_userid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_topicid_idx` (`topic_topicid`),
  KEY `user_userid_idx` (`user_userid`),
  CONSTRAINT `FK17wht8h89n15j80ae8vt8jo86` FOREIGN KEY (`user_userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `FKm9cahdnp5jxl2gwvm32iyig4w` FOREIGN KEY (`topic_topicid`) REFERENCES `topic` (`topicid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,0,'','What is science',1,1),(4,0,'','What is electromagnetism ',1,1),(8,0,'','What Is the structure of carbon monoxide ',1,1),(9,0,'','What Is Java',4,2),(10,0,'','What Is Spring',5,4),(11,0,'','How old is Kannada language',8,4),(13,0,'','How old is Kannada language',8,1),(15,0,'','What is addition?',2,4),(16,0,'','What is Angular?',6,4),(17,0,'image1.png','I am getting an error like in the image below',3,6),(18,0,'image1.png','Help me with this error',9,6),(21,0,'Screenshot (88)_1641528395098.png','How does the brain works?',1,11),(22,0,'image (1)_1641530966274.png','What is Array in java?',4,12);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topicid` int NOT NULL AUTO_INCREMENT,
  `cetegory` varchar(255) NOT NULL,
  PRIMARY KEY (`topicid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'Science '),(2,'Maths'),(3,'Physics'),(4,'Java'),(5,'Spring'),(6,'Angular'),(7,'Python'),(8,'Kannada'),(9,'EEE'),(10,'Hindi'),(11,'telugu'),(12,'android');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'email2','Karthik','password2'),(2,'email5','Keerthi','password'),(4,'karthik@test.com','Karthik Veeresh Tippeshtti','1234'),(5,'karthik@123','Roshini','1234'),(6,'a@a.com','Ajay','1234'),(7,'Kavitha@hcl.com','Kavitha','1234'),(8,'tarun@hcl.com','Tarun','1234'),(9,'roshni@hcl.com','Roshni','1234'),(10,'rahul@hcl.com','Rahul@hcl.com','1234'),(11,'t@t.com','Tharun@hcl.com','1234'),(12,'Shalini@gmail.com','Shalini','1234');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-27 21:26:12
