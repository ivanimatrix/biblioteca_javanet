-- MySQL dump 10.16  Distrib 10.1.25-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	10.1.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `id_alumno` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rut_alumno` varchar(10) NOT NULL,
  `nombres_alumno` varchar(60) NOT NULL,
  `apellidos_alumno` varchar(60) NOT NULL,
  `nacimiento_alumno` date NOT NULL,
  `sexo_alumno` varchar(10) NOT NULL COMMENT 'MASCULINO o FEMENINO',
  `direccion_alumno` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `rut_alumno` (`rut_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'15175863-0','Carolina','Valenzuela','2004-02-12','FEMENINO','Avenida Las Rosas 1000');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generos`
--

DROP TABLE IF EXISTS `generos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generos` (
  `id_genero` tinyint(4) NOT NULL,
  `nombre_genero` varchar(50) NOT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generos`
--

LOCK TABLES `generos` WRITE;
/*!40000 ALTER TABLE `generos` DISABLE KEYS */;
INSERT INTO `generos` VALUES (1,'Ciencia Ficción'),(2,'Literatura Española'),(3,'Literatura Angloamericana'),(4,'Infantil'),(5,'Ciencias Exactas'),(6,'Ciencias Sociales'),(7,'Ciencias Naturales'),(8,'Otros');
/*!40000 ALTER TABLE `generos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libros` (
  `id_libro` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `codigo_libro` varchar(15) NOT NULL COMMENT 'codigo ISBN',
  `descripcion_libro` varchar(1000) NOT NULL,
  `cantidad_libro` int(11) NOT NULL DEFAULT '0',
  `ingreso_libro` date NOT NULL,
  `genero_fk_libro` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_libro`),
  UNIQUE KEY `codigo_libro` (`codigo_libro`),
  KEY `fk_genero_libro` (`genero_fk_libro`),
  CONSTRAINT `fk_genero_libro` FOREIGN KEY (`genero_fk_libro`) REFERENCES `generos` (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (2,'111111','Don Quijote de la Mancha',1,'2017-08-08',2);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamos` (
  `id_prestamo` bigint(20) NOT NULL,
  `devolucion_prestamo` date NOT NULL,
  `alumno_fk_prestamo` bigint(20) unsigned NOT NULL,
  `libro_fk_prestamo` bigint(20) unsigned NOT NULL,
  `estado_prestamo` tinyint(1) DEFAULT '1' COMMENT '1: prestado; 2:devuelto',
  PRIMARY KEY (`id_prestamo`),
  KEY `fk_alumno_prestamo` (`alumno_fk_prestamo`),
  KEY `fk_libro_prestamo` (`libro_fk_prestamo`),
  CONSTRAINT `fk_alumno_prestamo` FOREIGN KEY (`alumno_fk_prestamo`) REFERENCES `alumnos` (`id_alumno`),
  CONSTRAINT `fk_libro_prestamo` FOREIGN KEY (`libro_fk_prestamo`) REFERENCES `libros` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
INSERT INTO `prestamos` VALUES (1,'2017-08-18',1,2,2),(2,'2017-08-24',1,2,2);
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rut_usuario` varchar(10) NOT NULL,
  `pass_usuario` varchar(250) NOT NULL,
  `nombres_usuario` varchar(60) NOT NULL,
  `apellidos_usuario` varchar(60) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `rut_usuario` (`rut_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'15489151-k','demo','Ivan','Almonacid');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-12 11:21:16
