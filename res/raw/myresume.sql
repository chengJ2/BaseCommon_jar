/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.51b-community-nt-log : Database - myresume
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myresume` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myresume`;

/*Table structure for table `work_experience` */

DROP TABLE IF EXISTS `work_experience`;

CREATE TABLE `work_experience` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `companyname` varchar(100) collate utf8_hungarian_ci NOT NULL,
  `industryclassification` varchar(128) collate utf8_hungarian_ci NOT NULL,
  `jobtitle` varchar(100) collate utf8_hungarian_ci NOT NULL,
  `worktimeStart` varchar(30) collate utf8_hungarian_ci NOT NULL,
  `worktimeEnd` varchar(30) collate utf8_hungarian_ci NOT NULL,
  `expectedsalary` varchar(100) collate utf8_hungarian_ci NOT NULL,
  `workdesc` varchar(500) collate utf8_hungarian_ci default NULL,
  `createtime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

/*Data for the table `work_experience` */

insert  into `work_experience`(`id`,`userId`,`companyname`,`industryclassification`,`jobtitle`,`worktimeStart`,`worktimeEnd`,`expectedsalary`,`workdesc`,`createtime`) values (1,1,'adwr','qwr','asfasdfe23423sadvsdv','互联网/电子商务','2014-01-12','2015-11-12','4001-6000元/月','2016-04-09 17:59:51');

/* Procedure structure for procedure `pro_workexpericnce` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_workexpericnce` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_workexpericnce`(IN `install` VARCHAR(2),IN p_userId INT,IN p_companyname VARCHAR(100),
							   IN p_industryclassification VARCHAR(128),IN p_jobtitle VARCHAR(100),IN p_worktimeStart VARCHAR(30),
							   IN p_worktimeEnd VARCHAR(30),IN p_expectedsalary VARCHAR(100),IN p_workdesc VARCHAR(500))
BEGIN
    IF `install` = 1
    THEN  
	SELECT '201' AS msg;
    ELSEIF `install` = 2  
    THEN  
	INSERT INTO `work_experience` (`userId`,`companyname`,`industryclassification`,`jobtitle`,`worktimeStart`,`worktimeEnd`,`expectedsalary`,`workdesc`,`createtime`) 
	VALUES(p_userId,p_companyname,p_industryclassification,p_jobtitle,p_worktimeStart,p_worktimeEnd,p_expectedsalary,p_workdesc,NOW());
	SELECT '200' AS msg;
    END IF;  
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
