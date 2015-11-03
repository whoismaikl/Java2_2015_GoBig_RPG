SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Java2_test` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `email` CHAR(25) NULL DEFAULT NULL,
  `password` CHAR(25) NULL DEFAULT NULL,
  `nickName` CHAR(25) NULL DEFAULT NULL,
  `userType` CHAR NULL DEFAULT 'U',
  `health` INTEGER NULL DEFAULT 50,
  `intellegence` INTEGER NULL DEFAULT 50,
  `communication` INTEGER NULL DEFAULT 50,
  `willPower` INTEGER NULL DEFAULT 30,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `lastLogin` DATETIME NULL DEFAULT NULL,
  `dateRegistered` DATETIME NULL DEFAULT NULL,
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


INSERT INTO `users` (`id`,`email`,`password`,`nickName`,`userType`,`health`,`intellegence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`, `dateRegistered`) VALUES
  (1,'','','','','0','0','0','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  (1,'0','','0','','','','2015-10-26 02:01:03','2015-10-26 02:01:03');