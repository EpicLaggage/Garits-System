-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 192.168.1.10    Database: garitsdb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Account_Holder`
--

DROP TABLE IF EXISTS `Account_Holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Account_Holder` (
  `customer_id` int(10) NOT NULL,
  `discount_plan` varchar(255) NOT NULL,
  `pay_later` tinyint(4) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `Account_Holder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account_Holder`
--

LOCK TABLES `Account_Holder` WRITE;
/*!40000 ALTER TABLE `Account_Holder` DISABLE KEYS */;
/*!40000 ALTER TABLE `Account_Holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Customer` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_postcode` varchar(8) NOT NULL,
  `customer_tel` int(11) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_account_holder` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'Adam','79 Landon Yard, London','E6 3R2',2078957890,'adamhills@outlook.com',0);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Discount`
--

DROP TABLE IF EXISTS `Discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Discount` (
  `discount_type` varchar(255) NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`discount_type`,`customer_id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `Discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `account_holder` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Discount`
--

LOCK TABLES `Discount` WRITE;
/*!40000 ALTER TABLE `Discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `Discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fixed_Discount`
--

DROP TABLE IF EXISTS `Fixed_Discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Fixed_Discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `discount_percentage` int(10) NOT NULL,
  PRIMARY KEY (`customer_id`,`discount_type`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `Fixed_Discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`),
  CONSTRAINT `Fixed_Discount_ibfk_2` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fixed_Discount`
--

LOCK TABLES `Fixed_Discount` WRITE;
/*!40000 ALTER TABLE `Fixed_Discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `Fixed_Discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flexible_Discount`
--

DROP TABLE IF EXISTS `Flexible_Discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Flexible_Discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `discount_value` int(10) NOT NULL,
  `current_month` date NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `Flexible_Discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`),
  CONSTRAINT `discount_type` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flexible_Discount`
--

LOCK TABLES `Flexible_Discount` WRITE;
/*!40000 ALTER TABLE `Flexible_Discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `Flexible_Discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Foreperson`
--

DROP TABLE IF EXISTS `Foreperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Foreperson` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Foreperson`
--

LOCK TABLES `Foreperson` WRITE;
/*!40000 ALTER TABLE `Foreperson` DISABLE KEYS */;
/*!40000 ALTER TABLE `Foreperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(10) NOT NULL,
  `invoice_date` date NOT NULL,
  `payment_due_date` date NOT NULL,
  `invoice_total` float NOT NULL,
  `invoice_paid` tinyint(4) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `Invoice_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice`
--

LOCK TABLES `Invoice` WRITE;
/*!40000 ALTER TABLE `Invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `Invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoice_Reminder`
--

DROP TABLE IF EXISTS `Invoice_Reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Invoice_Reminder` (
  `invoice_reminder_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(10) NOT NULL,
  `reminder_sent` tinyint(4) NOT NULL,
  PRIMARY KEY (`invoice_reminder_id`),
  KEY `invoice_id_idx` (`invoice_id`),
  CONSTRAINT `Invoice_Reminder_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice_Reminder`
--

LOCK TABLES `Invoice_Reminder` WRITE;
/*!40000 ALTER TABLE `Invoice_Reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `Invoice_Reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Job`
--

DROP TABLE IF EXISTS `Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_date` date NOT NULL,
  `reg_no` varchar(8) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `mechanic_assigned` int(10) NOT NULL,
  `job_work_required` mediumtext,
  `job_duration` time NOT NULL,
  `job_status` varchar(255) NOT NULL,
  `job_work_done` mediumtext,
  `job_type` varchar(45) NOT NULL,
  PRIMARY KEY (`job_id`),
  KEY `mechanic_assigned_idx` (`mechanic_assigned`),
  KEY `customer_id_idx` (`customer_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `Job_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `mechanic_assigned` FOREIGN KEY (`mechanic_assigned`) REFERENCES `mechanic` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Job`
--

LOCK TABLES `Job` WRITE;
/*!40000 ALTER TABLE `Job` DISABLE KEYS */;
/*!40000 ALTER TABLE `Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Job_Tasks`
--

DROP TABLE IF EXISTS `Job_Tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Job_Tasks` (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_content` varchar(255) DEFAULT NULL,
  `task_completed` tinyint(4) DEFAULT '0',
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `fk_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Job_Tasks`
--

LOCK TABLES `Job_Tasks` WRITE;
/*!40000 ALTER TABLE `Job_Tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `Job_Tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mechanic`
--

DROP TABLE IF EXISTS `Mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Mechanic` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `Mechanic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mechanic`
--

LOCK TABLES `Mechanic` WRITE;
/*!40000 ALTER TABLE `Mechanic` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mechanic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Part_Used`
--

DROP TABLE IF EXISTS `Part_Used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Part_Used` (
  `part_used_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(10) NOT NULL,
  `job_id` int(10) NOT NULL,
  `quantity_used` int(10) NOT NULL,
  PRIMARY KEY (`part_used_id`),
  KEY `part_id_idx` (`part_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `part_id` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Part_Used`
--

LOCK TABLES `Part_Used` WRITE;
/*!40000 ALTER TABLE `Part_Used` DISABLE KEYS */;
/*!40000 ALTER TABLE `Part_Used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parts`
--

DROP TABLE IF EXISTS `Parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Parts` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(255) DEFAULT NULL,
  `part_manufacturer` varchar(255) NOT NULL,
  `part_supplier_id` int(10) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `year` int(10) NOT NULL,
  `part_quantity` int(10) NOT NULL,
  `part_price` decimal(10,2) DEFAULT NULL,
  `part_threshold` int(10) DEFAULT '10',
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parts`
--

LOCK TABLES `Parts` WRITE;
/*!40000 ALTER TABLE `Parts` DISABLE KEYS */;
INSERT INTO `Parts` VALUES (1,'Tyre, heavy tread','Fjord',1,'Fjord Transit Van',0,8,45.00,6),(2,'Exhaust, complete box','Fjord',1,'Fjord Estate',0,3,200.00,2),(3,'Engine Mounts, set','',2,'All Makes',0,6,15.00,4),(4,'Spark Plugs, each','',2,'All Makes',0,23,1.50,20),(5,'Spark Leads, set','',2,'All Makes',0,16,12.50,10),(6,'Distributor Cap','Fjord2',1,'Fjord Vehicles',0,10,35.00,5),(7,'Paint, Arrogant Red','Slap-it-on Paints',2,'All Makes',0,3,60.00,2),(8,'Interior Bulb','Switch-it-on',2,'Rolls Royce',0,2,118.00,1),(9,'Motor Oil','',2,'All Makes',0,30,25.00,25),(10,'Oil Filter','',2,'All Makes',0,16,10.00,15),(11,'Air Filter','',2,'All Makes',0,15,15.00,10),(12,'Test Part','Test Manufacturer',5,'All Makes',2018,10,23.50,6);
/*!40000 ALTER TABLE `Parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supplier`
--

DROP TABLE IF EXISTS `Supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Supplier` (
  `part_supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  `supplier_address` varchar(255) NOT NULL,
  `supplier_tel` int(11) NOT NULL,
  `supplier_email` varchar(255) NOT NULL,
  PRIMARY KEY (`part_supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supplier`
--

LOCK TABLES `Supplier` WRITE;
/*!40000 ALTER TABLE `Supplier` DISABLE KEYS */;
INSERT INTO `Supplier` VALUES (1,'Fjord Supplies','10 Largeunits, Trade Estate, Reading, RG10 4PT',1895453857,''),(2,'Halfords','1 Enormous Office, Trading Park, Harlesdon, London, NW10 4UP',2083335555,''),(5,'Test Supplier','Test Address, N1 0AA',1334563212,'test@email.com'),(6,'Another Test Supplier','Address',1225441236,'testsupplier@outlook.com');
/*!40000 ALTER TABLE `Supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `user_pay` float DEFAULT NULL,
  `user_name` mediumtext,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Test Mechanic User','$2a$10$2nUcQ7PobBaxxnqvjD0O/OpOfy0Q2rhf6N6Bb9uHDob8r6BiPw3Nu','Mechanic',105,'testmechanic');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Variable_Discount`
--

DROP TABLE IF EXISTS `Variable_Discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Variable_Discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `business_type` varchar(255) NOT NULL,
  `discount_percentage` int(10) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`discount_type`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `Variable_Discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`),
  CONSTRAINT `Variable_Discount_ibfk_2` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Variable_Discount`
--

LOCK TABLES `Variable_Discount` WRITE;
/*!40000 ALTER TABLE `Variable_Discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `Variable_Discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle`
--

DROP TABLE IF EXISTS `Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Vehicle` (
  `reg_no` varchar(8) NOT NULL,
  `car_make` varchar(255) NOT NULL,
  `car_model` varchar(255) NOT NULL,
  `engine_serial` varchar(255) NOT NULL,
  `chassis_no` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `purchase_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reg_no`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle`
--

LOCK TABLES `Vehicle` WRITE;
/*!40000 ALTER TABLE `Vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-01  9:17:35
