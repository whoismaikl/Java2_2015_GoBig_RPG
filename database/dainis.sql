SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Java2_test` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `email` CHAR(50) NULL DEFAULT NULL,
  `password` CHAR(30) NULL DEFAULT NULL,
  `lastLogin` DATETIME NULL DEFAULT NULL,
  `dateRegistered` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` CHAR(25) NULL DEFAULT NULL,
  `Surname` CHAR(25) NULL DEFAULT NULL,
  `nickName` CHAR(25) NULL DEFAULT NULL,
  `health` INTEGER NULL DEFAULT 50,
  `intellegence` INTEGER NULL DEFAULT 50,
  `communication` INTEGER NULL DEFAULT 50,
  `willPower` INTEGER NULL DEFAULT 30,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `userType` CHAR NULL DEFAULT 'U',
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `userID` INTEGER NULL DEFAULT NULL,
  `statType` CHAR(15) NULL DEFAULT NULL,
  `statValue` INTEGER NULL DEFAULT NULL,
  `statDescription` VARCHAR(100) NULL DEFAULT NULL,
  `repeatableYN` CHAR(1) NULL DEFAULT 'N',
  `accomplishedYN` CHAR(1) NULL DEFAULT 'N',
  `dateAdded` DATETIME NULL DEFAULT NULL,
  `dateAccomplished` DATETIME NULL DEFAULT NULL,
  `daysToAccomplish` INTEGER NULL DEFAULT 1,
  PRIMARY KEY (`id`)
);



 INSERT INTO `login` (`id`,`email`,`password`,`lastLogin`,`dateRegistered`) VALUES
 (1,'','','2015-10-26 02:01:03','2015-10-26 02:01:03');
 INSERT INTO `users` (`id`,`name`,`Surname`,`nickName`,`health`,`intellegence`,`communication`,`willPower`,`dailyTodo`,`userType`) VALUES
 (1,'','','','0','0','0','0','0','');
 INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
 (1,'0','','0','','','','2015-10-26 02:01:03','2015-10-26 02:01:03');