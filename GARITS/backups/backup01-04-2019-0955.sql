-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: garitsdb
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
-- Table structure for table `account_holder`
--

DROP TABLE IF EXISTS `account_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account_holder` (
  `customer_id` int(10) NOT NULL,
  `discount_plan` varchar(255) NOT NULL,
  `pay_later` tinyint(4) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `account_holder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_holder`
--

LOCK TABLES `account_holder` WRITE;
/*!40000 ALTER TABLE `account_holder` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
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
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Adam','79 Landon Yard, London','E6 3R2',2078957890,'adamhills@outlook.com',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `discount` (
  `discount_type` varchar(255) NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`discount_type`,`customer_id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `account_holder` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fixed_discount`
--

DROP TABLE IF EXISTS `fixed_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fixed_discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `discount_percentage` int(10) NOT NULL,
  PRIMARY KEY (`customer_id`,`discount_type`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `fixed_discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`),
  CONSTRAINT `fixed_discount_ibfk_2` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fixed_discount`
--

LOCK TABLES `fixed_discount` WRITE;
/*!40000 ALTER TABLE `fixed_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `fixed_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flexible_discount`
--

DROP TABLE IF EXISTS `flexible_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flexible_discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `discount_value` int(10) NOT NULL,
  `current_month` date NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `discount_type` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`),
  CONSTRAINT `flexible_discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flexible_discount`
--

LOCK TABLES `flexible_discount` WRITE;
/*!40000 ALTER TABLE `flexible_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `flexible_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foreperson`
--

DROP TABLE IF EXISTS `foreperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `foreperson` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foreperson`
--

LOCK TABLES `foreperson` WRITE;
/*!40000 ALTER TABLE `foreperson` DISABLE KEYS */;
/*!40000 ALTER TABLE `foreperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(10) NOT NULL,
  `invoice_date` date NOT NULL,
  `payment_due_date` date NOT NULL,
  `invoice_total` float NOT NULL,
  `invoice_paid` tinyint(4) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_reminder`
--

DROP TABLE IF EXISTS `invoice_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invoice_reminder` (
  `invoice_reminder_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(10) NOT NULL,
  `reminder_sent` tinyint(4) NOT NULL,
  PRIMARY KEY (`invoice_reminder_id`),
  KEY `invoice_id_idx` (`invoice_id`),
  CONSTRAINT `invoice_reminder_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_reminder`
--

LOCK TABLES `invoice_reminder` WRITE;
/*!40000 ALTER TABLE `invoice_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_date` date NOT NULL,
  `reg_no` varchar(8) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `mechanic_assigned` int(10) NOT NULL,
  `job_details` varchar(255) DEFAULT NULL,
  `job_duration` time NOT NULL,
  `job_status` varchar(255) NOT NULL,
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `reg_no_UNIQUE` (`reg_no`),
  KEY `mechanic_assigned_idx` (`mechanic_assigned`),
  KEY `customer_id_idx` (`customer_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `mechanic_assigned` FOREIGN KEY (`mechanic_assigned`) REFERENCES `mechanic` (`user_id`),
  CONSTRAINT `reg_no` FOREIGN KEY (`reg_no`) REFERENCES `vehicle` (`reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanic`
--

DROP TABLE IF EXISTS `mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mechanic` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `mechanic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic`
--

LOCK TABLES `mechanic` WRITE;
/*!40000 ALTER TABLE `mechanic` DISABLE KEYS */;
/*!40000 ALTER TABLE `mechanic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_used`
--

DROP TABLE IF EXISTS `part_used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `part_used` (
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
-- Dumping data for table `part_used`
--

LOCK TABLES `part_used` WRITE;
/*!40000 ALTER TABLE `part_used` DISABLE KEYS */;
/*!40000 ALTER TABLE `part_used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parts` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_ name` varchar(255) NOT NULL,
  `part_manufacturer` varchar(255) NOT NULL,
  `part_supplier_id` int(10) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `year` int(10) NOT NULL,
  `part_quantity` int(10) NOT NULL,
  PRIMARY KEY (`part_id`),
  UNIQUE KEY `part_supplier_id_UNIQUE` (`part_supplier_id`),
  CONSTRAINT `part_supplier_id` FOREIGN KEY (`part_supplier_id`) REFERENCES `supplier` (`part_supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `part_id` int(10) NOT NULL,
  `part_stock_quantity` int(10) NOT NULL,
  `part_threshold` int(10) NOT NULL,
  PRIMARY KEY (`part_id`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `part_supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  `supplier_address` varchar(255) NOT NULL,
  `supplier_tel` int(11) NOT NULL,
  `supplier_email` varchar(255) NOT NULL,
  PRIMARY KEY (`part_supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `user_pay` float DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','password','Mechanic',105);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variable_discount`
--

DROP TABLE IF EXISTS `variable_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `variable_discount` (
  `customer_id` int(10) NOT NULL,
  `discount_type` varchar(255) NOT NULL,
  `business_type` varchar(255) NOT NULL,
  `discount_percentage` int(10) DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`discount_type`),
  KEY `discount_type_idx` (`discount_type`),
  CONSTRAINT `variable_discount_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`),
  CONSTRAINT `variable_discount_ibfk_2` FOREIGN KEY (`discount_type`) REFERENCES `discount` (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variable_discount`
--

LOCK TABLES `variable_discount` WRITE;
/*!40000 ALTER TABLE `variable_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `variable_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle` (
  `reg_no` varchar(8) NOT NULL,
  `car_make` varchar(255) NOT NULL,
  `car_model` varchar(255) NOT NULL,
  `engine_serial` varchar(255) NOT NULL,
  `chassis_no` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`reg_no`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-01  9:55:02
