SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- ---
-- Globals
CREATE SCHEMA IF NOT EXISTS `projectevolution` DEFAULT CHARACTER SET utf8 ;
USE `projectevolution` ;

-- ---
-- Table 'users'
--
-- ---

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` CHAR(40) NULL DEFAULT NULL,
  `password` CHAR(40) NULL DEFAULT NULL,
  `userName` CHAR(30) NULL DEFAULT NULL,
  `userType` CHAR(1) NULL DEFAULT 'U',
  `health` INTEGER NULL DEFAULT NULL,
  `intelligence` INTEGER NULL DEFAULT 50,
  `communication` INTEGER NULL DEFAULT 50,
  `willPower` INTEGER NULL DEFAULT 25,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `lastLogin` DATETIME(6) NULL DEFAULT NULL,
  `dateRegistered` DATETIME(6) NULL DEFAULT NULL,
  `accountActivetYN` CHAR  NULL DEFAULT 'Y',
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'tasks'
--
-- ---

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userID` BIGINT NOT NULL,
  `statType` CHAR(17) NOT NULL,
  `statValue` INTEGER NULL,
  `statDescription` CHAR(255) NULL DEFAULT NULL,
  `repeatableYN` CHAR(3) NOT NULL DEFAULT 'N',
  `repeatFrequencyDays` INTEGER NOT NULL DEFAULT 1,
  `accomplishedYN` CHAR(3) NOT NULL DEFAULT 'N',
  `dateAdded` DATETIME(6) NOT NULL,
  `dateAccomplished` DATETIME(6) NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'taskHistory'
--
-- ---

DROP TABLE IF EXISTS `taskHistory`;

CREATE TABLE `taskHistory` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userID` BIGINT NULL DEFAULT NULL,
  `health` INTEGER NULL DEFAULT NULL,
  `intelligence` INTEGER NULL DEFAULT NULL,
  `communication` INTEGER NULL DEFAULT NULL,
  `statValue`INTEGER NULL DEFAULT NULL,
  `willPower` INTEGER NULL DEFAULT NULL,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `dateCompleted` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'customTasks'
--
-- ---

DROP TABLE IF EXISTS `defaultTasks`;

CREATE TABLE `defaultTasks` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userID` BIGINT NOT NULL,
  `statType` CHAR(17) NOT NULL,
  `statValue` INTEGER NULL,
  `statDescription` CHAR(255) NULL DEFAULT NULL,
  `repeatableYN` CHAR(3) NOT NULL DEFAULT 'N',
  `repeatFrequencyDays` INTEGER NOT NULL DEFAULT 1,
  `accomplishedYN` CHAR(3) NOT NULL DEFAULT 'N',
  `dateAdded` DATETIME(6) NOT NULL,
  `dateAccomplished` DATETIME(6) NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys
-- ---

ALTER TABLE `tasks` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`);
ALTER TABLE `taskHistory` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`);

--
-- ---
-- Test Data
-- ---

INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1001','a','a','User A','A','50','50','50','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');
INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1002','b','b','User B','U','50','50','50','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');
INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1003','c','c','User C','U','50','50','50','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');

INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1001','1001','Health','1','Description for health','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1002','1001','Intelligence','1','Description for intelligence','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1003','1001','Communication','1','Description for communication','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1004','1002','Health','1','Description for health','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1005','1002','Intelligence','1','Description for intelligence','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1006','1002','Communication','1','Description for communication','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1007','1003','Health','1','Description for health','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1008','1003','Intelligence','1','Description for intelligence','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1009','1003','Communication','1','Description for communication','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');

INSERT INTO `taskHistory` (`id`,`userID`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1001','1001','5','8','10','1','1','1','2015-11-17 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1002','1001','7','3','15','1','1','1','2015-11-19 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1003','1001','3','12','20','1','1','1','2015-11-24 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1004','1001','9','14','17','1','1','1','2015-11-29 10:07:46');

INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1001','1001','Health','1','Description for health','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1002','1001','Intelligence','1','Description for intelligence','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1003','1001','Communication','1','Description for communication','Y','N','2015-11-17 10:07:46','2015-11-17 10:07:46');