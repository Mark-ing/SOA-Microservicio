-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestion_proyectov3
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `aprobacion`
--

DROP TABLE IF EXISTS `aprobacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aprobacion` (
  `ID_Aprobacion` int NOT NULL AUTO_INCREMENT,
  `ID_Proyecto` int DEFAULT NULL,
  `ID_Jefe_Area` int DEFAULT NULL,
  `Descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Aprobacion` date DEFAULT NULL,
  `Ap_Estado` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_Aprobacion`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  KEY `ID_JefeArea` (`ID_Jefe_Area`),
  CONSTRAINT `aprobacion_ibfk_1` FOREIGN KEY (`ID_Proyecto`) REFERENCES `proyecto` (`ID_Proyecto`),
  CONSTRAINT `aprobacion_ibfk_2` FOREIGN KEY (`ID_Jefe_Area`) REFERENCES `jefe_area` (`ID_Jefe_Area`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aprobacion`
--

LOCK TABLES `aprobacion` WRITE;
/*!40000 ALTER TABLE `aprobacion` DISABLE KEYS */;
INSERT INTO `aprobacion` VALUES (22,1,17,'cambiiar','2024-11-14','Activo');
/*!40000 ALTER TABLE `aprobacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `ID_Area` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  PRIMARY KEY (`ID_Area`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Recursos Humanos','2024-01-01'),(2,'Tecnología','2024-02-01'),(3,'Finanzas','2024-03-01');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignacion_proyecto`
--

DROP TABLE IF EXISTS `asignacion_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion_proyecto` (
  `ID_Asignacion_Proyecto` int NOT NULL AUTO_INCREMENT,
  `ID_Jefe_Area` int NOT NULL,
  `ID_Proyecto` int NOT NULL,
  PRIMARY KEY (`ID_Asignacion_Proyecto`,`ID_Jefe_Area`,`ID_Proyecto`),
  KEY `ID_JefeArea` (`ID_Jefe_Area`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  CONSTRAINT `asignacion_proyecto_ibfk_1` FOREIGN KEY (`ID_Jefe_Area`) REFERENCES `jefe_area` (`ID_Jefe_Area`),
  CONSTRAINT `asignacion_proyecto_ibfk_2` FOREIGN KEY (`ID_Proyecto`) REFERENCES `proyecto` (`ID_Proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion_proyecto`
--

LOCK TABLES `asignacion_proyecto` WRITE;
/*!40000 ALTER TABLE `asignacion_proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento` (
  `ID_Documento` int NOT NULL AUTO_INCREMENT,
  `ID_Proyecto` int DEFAULT NULL,
  `Ruta_Carpeta` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `Fecha_Modificacion` date DEFAULT NULL,
  PRIMARY KEY (`ID_Documento`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  CONSTRAINT `documento_ibfk_1` FOREIGN KEY (`ID_Proyecto`) REFERENCES `proyecto` (`ID_Proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (4,1,'marco','2024-09-11','2024-11-02'),(5,2,'ESPINOZA_FERNANDO.pdf','2024-09-12','2024-10-26'),(6,3,'s','2024-09-14','2024-09-15'),(7,4,'Primer Entregable FJEM.docx','2024-10-26','2024-11-01'),(8,5,'0820240722394.pdf','2024-10-26','2024-11-02'),(10,6,'CONSULTA DE VALIDEZ (1).pdf','2024-10-26','2024-10-26'),(11,1,'marco','2024-09-11','2024-11-02');
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `ID_Empleado` int NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int DEFAULT NULL,
  `E_Nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `E_Apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_Rol_Equipo` int DEFAULT NULL,
  PRIMARY KEY (`ID_Empleado`),
  KEY `ID_Usuario` (`ID_Usuario`),
  KEY `ID_Rol_Equipo_idx` (`ID_Rol_Equipo`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID_Usuario`),
  CONSTRAINT `ID_Rol_Equipo` FOREIGN KEY (`ID_Rol_Equipo`) REFERENCES `rol_equipo` (`ID_Rol_Equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (21,29,'Fernando','Espinoza Martinez',NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `ID_Equipo` int NOT NULL AUTO_INCREMENT,
  `Nombre_Equipo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `Estado_Equipo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_Equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'Equipo Desarrollo','2024-01-15','Activo'),(2,'Equipo Soporte','2024-02-20','Inactivo'),(3,'Equipo Financiero','2024-03-05','Activo'),(4,'Equipo Desarrollo','2024-01-15','Activo'),(5,'Equipo Soporte','2024-02-20','Inactivo'),(6,'Equipo Financiero','2024-03-05','Activo');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo_empleado`
--

DROP TABLE IF EXISTS `equipo_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo_empleado` (
  `ID_Equipo` int NOT NULL,
  `ID_Empleado` int NOT NULL,
  `ID_Equipo_Empleado` int NOT NULL,
  PRIMARY KEY (`ID_Equipo`,`ID_Empleado`,`ID_Equipo_Empleado`),
  KEY `ID_Empleado` (`ID_Empleado`),
  CONSTRAINT `equipo_empleado_ibfk_1` FOREIGN KEY (`ID_Equipo`) REFERENCES `equipo` (`ID_Equipo`),
  CONSTRAINT `equipo_empleado_ibfk_2` FOREIGN KEY (`ID_Empleado`) REFERENCES `empleado` (`ID_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo_empleado`
--

LOCK TABLES `equipo_empleado` WRITE;
/*!40000 ALTER TABLE `equipo_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipo_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jefe_area`
--

DROP TABLE IF EXISTS `jefe_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jefe_area` (
  `ID_Jefe_Area` int NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int DEFAULT NULL,
  `JF_Nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `JF_Apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID_Jefe_Area`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `jefe_area_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jefe_area`
--

LOCK TABLES `jefe_area` WRITE;
/*!40000 ALTER TABLE `jefe_area` DISABLE KEYS */;
INSERT INTO `jefe_area` VALUES (17,68,'JACNTO2','SW'),(22,71,'Jack','Lazaro');
/*!40000 ALTER TABLE `jefe_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jefe_proyecto`
--

DROP TABLE IF EXISTS `jefe_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jefe_proyecto` (
  `ID_Jefe_Pro` int NOT NULL AUTO_INCREMENT,
  `JP_Nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `JP_Apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_Usuario` int DEFAULT NULL,
  PRIMARY KEY (`ID_Jefe_Pro`),
  KEY `ID_Usuarios_idx` (`ID_Usuario`),
  CONSTRAINT `ID_Usuarios` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jefe_proyecto`
--

LOCK TABLES `jefe_proyecto` WRITE;
/*!40000 ALTER TABLE `jefe_proyecto` DISABLE KEYS */;
INSERT INTO `jefe_proyecto` VALUES (1,'Luis','Fernández',34),(2,'María','López',35),(3,'Ricardo','Díaz',36);
/*!40000 ALTER TABLE `jefe_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `ID_Proyecto` int NOT NULL AUTO_INCREMENT,
  `ID_Equipo` int DEFAULT NULL,
  `Nombre_Proyecto` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Inicio` date DEFAULT NULL,
  `Fecha_Fin` date DEFAULT NULL,
  `P_Estado` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID_Jefe_Pro` int DEFAULT NULL,
  PRIMARY KEY (`ID_Proyecto`),
  KEY `ID_Equipo` (`ID_Equipo`),
  KEY `ID_JefePro` (`ID_Jefe_Pro`),
  CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`ID_Equipo`) REFERENCES `equipo` (`ID_Equipo`),
  CONSTRAINT `proyecto_ibfk_2` FOREIGN KEY (`ID_Jefe_Pro`) REFERENCES `jefe_proyecto` (`ID_Jefe_Pro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,1,'Proyecto Alpha','Proyecto Alpha','2024-01-01','2024-06-01','Pendiente',1),(2,2,'Proyecto Beta','Proyecto Beta','2024-02-01','2024-07-01','Pendiente',2),(3,3,'Proyecto Gamma','Proyecto Gamma','2024-03-01','2024-08-01','Pendiente',3),(4,1,'Proyecto Alpha','Proyecto Alpha','2024-01-01','2024-06-01','Completado',1),(5,2,'Proyecto Beta','Proyecto Beta','2024-02-01','2024-07-01','Pendiente',2),(6,3,'Proyecto Gamma','Proyecto Gamma','2024-03-01','2024-08-01','Finalizado',3);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_equipo`
--

DROP TABLE IF EXISTS `rol_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_equipo` (
  `ID_Rol_Equipo` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  PRIMARY KEY (`ID_Rol_Equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_equipo`
--

LOCK TABLES `rol_equipo` WRITE;
/*!40000 ALTER TABLE `rol_equipo` DISABLE KEYS */;
INSERT INTO `rol_equipo` VALUES (1,'Desarrollador','2024-01-01'),(2,'Soporte','2024-02-01'),(3,'Analista','2024-03-01');
/*!40000 ALTER TABLE `rol_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_usuarios`
--

DROP TABLE IF EXISTS `rol_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_usuarios` (
  `ID_Rol` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  PRIMARY KEY (`ID_Rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_usuarios`
--

LOCK TABLES `rol_usuarios` WRITE;
/*!40000 ALTER TABLE `rol_usuarios` DISABLE KEYS */;
INSERT INTO `rol_usuarios` VALUES (1,'Administrador','2024-01-10'),(2,'Jefe de Area','2024-02-10'),(3,'Empleado','2024-03-10'),(4,'Jefe de Proyecto','2024-10-10');
/*!40000 ALTER TABLE `rol_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_cambio`
--

DROP TABLE IF EXISTS `solicitud_cambio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitud_cambio` (
  `ID_Solicitud` int NOT NULL AUTO_INCREMENT,
  `ID_Proyecto` int DEFAULT NULL,
  `ID_Jefe_Area` int DEFAULT NULL,
  `Descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Aprobacion` date DEFAULT NULL,
  `SC_Estado` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Fecha_Solicitud` date DEFAULT NULL,
  PRIMARY KEY (`ID_Solicitud`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  KEY `solicitud_cambio_ibfk_2_idx` (`ID_Jefe_Area`),
  CONSTRAINT `solicitud_cambio_ibfk_1` FOREIGN KEY (`ID_Proyecto`) REFERENCES `proyecto` (`ID_Proyecto`),
  CONSTRAINT `solicitud_cambio_ibfk_2` FOREIGN KEY (`ID_Jefe_Area`) REFERENCES `jefe_area` (`ID_Jefe_Area`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_cambio`
--

LOCK TABLES `solicitud_cambio` WRITE;
/*!40000 ALTER TABLE `solicitud_cambio` DISABLE KEYS */;
INSERT INTO `solicitud_cambio` VALUES (8,4,17,'cambiar el nombre','2024-11-03','Rechazado','2024-10-28'),(10,5,22,'NECESITO QUE SE PUEDAN REGISTRAR LOS USUARIOS','2024-11-01','Aprobado','2024-10-28'),(11,3,17,'DESEO QUE CUANDO SE ACTUALIZE LOS DOCUMENTOS ME PERMITA PODER VISUALIZAR EL DOCUMENTO SUBIDO ',NULL,'Pendiente','2024-10-28'),(20,5,22,'asd',NULL,'Pendiente','2024-11-02');
/*!40000 ALTER TABLE `solicitud_cambio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `ID_Usuario` int NOT NULL AUTO_INCREMENT,
  `ID_Rol` int DEFAULT NULL,
  `ID_Area` int DEFAULT NULL,
  `correo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `contraseña` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `U_Estado` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`),
  KEY `ID_Rol` (`ID_Rol`),
  KEY `ID_Area` (`ID_Area`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_Rol`) REFERENCES `rol_usuarios` (`ID_Rol`),
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`ID_Area`) REFERENCES `area` (`ID_Area`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (29,1,2,'espinozaf3009@gmail.com','$2y$10$mBFX1ZpxS8SKE.gdKWfWnele6Jwzyhe6skBV1AUxk1ijyMprW1zbm','2024-10-27','Activo'),(34,4,2,'espinozaf3007@gmail.com','$2y$10$rDtINgXNrsNqiFFnTeAEsOtX3IG.LdFZGSq8p3UlFVMFzyPkTbSoe','2024-10-27','Activo'),(35,4,2,'espinozaf3008@gmail.com','$2y$10$LWHJAztjJQOyuhHoQlo.wusYyZI2qKEvbPy7/GglLLp0ocHXRPdaW','2024-10-27','Activo'),(36,4,2,'espinozaf3006@gmail.com','$2y$10$4Kc.6nzMCi/72WzbKAoXmOttMUTcu4slkKt83FVwnwSIdNnR3M/BK','2024-10-27','Activo'),(68,2,2,'JACINTO2@gmail.com','$2y$10$Yr/HPB/NxBAOoQKaCuvtSOgu/3zh29Zn3KFwdCnt9AbRrqSwBXPMG','2024-11-02','Activo'),(71,2,1,'jackjplg@gmail.com','$2y$10$kHi5AYgI9DtwEgUn5gy.VOvi9KpSWgAUvxkGyJvMB3ymGu8QzskMm','2024-11-02','Activo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_sesiones`
--

DROP TABLE IF EXISTS `usuarios_sesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_sesiones` (
  `ID_Sesiones` int NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int DEFAULT NULL,
  `Fecha_Ingreso` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_Sesiones`),
  KEY `ID_Usuario_idx` (`ID_Usuario`),
  CONSTRAINT `ID_Usuario` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_sesiones`
--

LOCK TABLES `usuarios_sesiones` WRITE;
/*!40000 ALTER TABLE `usuarios_sesiones` DISABLE KEYS */;
INSERT INTO `usuarios_sesiones` VALUES (1,29,'2024-10-28 13:33:52'),(2,29,'2024-10-28 13:50:35'),(3,29,'2024-10-28 13:51:04'),(4,34,'2024-10-28 13:52:34'),(5,35,'2024-10-28 13:52:45'),(6,36,'2024-10-28 13:53:02'),(7,29,'2024-10-28 13:53:14'),(8,34,'2024-10-28 14:01:20'),(9,34,'2024-10-28 14:05:45'),(10,29,'2024-10-28 14:20:30'),(12,34,'2024-10-28 15:22:54'),(14,34,'2024-10-28 15:54:46'),(16,29,'2024-10-28 16:09:19'),(19,29,'2024-10-28 16:13:27'),(20,29,'2024-10-29 13:27:18'),(22,29,'2024-10-29 13:29:54'),(24,34,'2024-10-29 13:30:55'),(27,29,'2024-10-30 04:24:56'),(29,29,'2024-10-30 04:31:39'),(30,29,'2024-11-01 17:22:54'),(31,29,'2024-11-01 17:23:13'),(33,34,'2024-11-01 17:30:38'),(34,34,'2024-11-01 17:38:54'),(36,34,'2024-11-01 17:42:09'),(37,29,'2024-11-01 17:42:35'),(38,34,'2024-11-01 17:42:49'),(39,29,'2024-11-01 17:44:44'),(40,29,'2024-11-01 18:26:08'),(41,29,'2024-11-01 18:39:47'),(42,34,'2024-11-01 18:49:25'),(43,29,'2024-11-02 15:23:01'),(44,29,'2024-11-02 15:24:39'),(45,29,'2024-11-02 20:40:43'),(46,34,'2024-11-02 22:20:53'),(47,29,'2024-11-03 00:27:55'),(48,29,'2024-11-03 00:39:57'),(49,34,'2024-11-03 00:41:15'),(51,29,'2024-11-03 01:11:13'),(52,34,'2024-11-03 01:35:54'),(53,29,'2024-11-03 01:39:41'),(56,29,'2024-11-03 01:44:35'),(57,29,'2024-11-03 02:00:34'),(58,29,'2024-11-03 02:01:21'),(60,29,'2024-11-03 02:02:41'),(62,29,'2024-11-03 02:05:40'),(64,29,'2024-11-03 02:08:42');
/*!40000 ALTER TABLE `usuarios_sesiones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-14 16:12:26
