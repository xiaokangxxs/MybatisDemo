/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.5.27 : Database - db_mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_mybatis`;

/*Table structure for table `t_address` */

DROP TABLE IF EXISTS `t_address`;

CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheng` varchar(20) DEFAULT NULL,
  `shi` varchar(20) DEFAULT NULL,
  `qu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_address` */

insert  into `t_address`(`id`,`sheng`,`shi`,`qu`) values 
(1,'河北省','保定市','唐县'),
(2,'河北省','保定市','望都县');

/*Table structure for table `t_grade` */

DROP TABLE IF EXISTS `t_grade`;

CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_grade` */

insert  into `t_grade`(`id`,`gradeName`) values 
(1,'大一'),
(2,'大二'),
(3,'大三'),
(4,'大四');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `addressId` int(11) DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `addressId` (`addressId`),
  KEY `gradeId` (`gradeId`),
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`gradeId`) REFERENCES `t_grade` (`id`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`addressId`) REFERENCES `t_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`name`,`age`,`status`,`addressId`,`gradeId`) values 
(1,'张三-update1',19,0,1,1),
(2,'李四',19,0,2,1),
(3,'王五张',25,0,1,1),
(4,'赵六',22,0,1,1),
(5,'张三111',18,1,1,2),
(6,'小明',22,0,2,3),
(7,'张三333',23,0,1,3),
(8,'张三444',20,0,2,2),
(9,'张三555',18,0,1,3);

/*Table structure for table `t_student1` */

DROP TABLE IF EXISTS `t_student1`;

CREATE TABLE `t_student1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_student1` */

insert  into `t_student1`(`id`,`name`,`age`,`status`) values 
(1,'张三',18,0),
(2,'李四',19,0),
(3,'王五',22,0),
(4,'赵六',20,0),
(5,'小明',25,0),
(6,'小红',18,0),
(7,'小刚',17,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
