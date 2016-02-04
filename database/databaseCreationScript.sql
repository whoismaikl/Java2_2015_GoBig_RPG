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
  `taskID` BIGINT NULL DEFAULT NULL,
  `statType` CHAR(17) NOT NULL,
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

ALTER TABLE `tasks` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`) ON DELETE CASCADE;
ALTER TABLE `taskHistory` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- ---
-- Test Data
-- ---

INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1001','a','a','User A','A','37','48','49','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');
INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1002','b','b','User B','U','22','33','31','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');
INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intelligence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1003','dainis.vevers@gmail.com','c','Dainis','U','22','33','31','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','Y');

INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1001','1001','Health','1','Use Legs To go Home','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1002','1001','Intelligence','1','Play Starcraft','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1003','1001','Communication','1','GoTo Facebook','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1004','1002','Health','1','Eat Heathy Food','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1005','1002','Intelligence','5','Buy Brain','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1006','1002','Communication','1','Go To Party','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1007','1003','Health','1','Go To Gym','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1008','1003','Intelligence','1','Read News','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1009','1003','Communication','1','Talk With Cat About Java','Yes','N','2015-11-17 10:07:46','2015-11-17 10:07:46');

INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1001','1001','1001','Health','1','0','0','1','1','1','2015-11-17 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1002','1001','1002','Intelligence','1','3','0','3','1','1','2015-11-24 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1003','1001','1003','Communication','1','3','9','9','1','1','2015-11-29 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1004','1001','1001','Health','9','3','9','8','1','1','2015-12-10 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1005','1001','1002','Intelligence','9','16','9','7','1','1','2015-12-20 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1006','1001','1003','Communication','9','16','17','8','1','1','2015-12-30 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1007','1001','1001','Health','19','16','17','10','1','1','2016-01-05 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1008','1001','1002','Intelligence','19','22','17','6','1','1','2016-01-10 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1009','1001','1003','Communication','19','22','31','14','1','1','2016-01-15 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1010','1001','1001','Health','22','22','31','3','1','1','2016-01-20 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1011','1001','1002','Intelligence','22','29','31','7','1','1','2016-01-25 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1012','1001','1003','Communication','22','29','33','2','1','1','2016-01-26 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1013','1001','1001','Health','24','29','33','33','1','1','2016-01-26 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1014','1001','1002','Intelligence','24','33','33','4','1','3','2016-01-26 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1015','1001','1003','Communication','24','33','37','4','1','1','2016-01-27 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1016','1001','1001','Health','27','33','37','3','1','1','2016-01-27 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1017','1001','1002','Intelligence','27','38','37','5','1','1','2016-01-27 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1018','1001','1003','Communication','27','38','40','3','1','1','2016-01-28 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1019','1001','1001','Health','30','38','40','10','3','1','2016-01-28 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1020','1001','1002','Intelligence','30','40','40','2','1','1','2016-01-28 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1021','1001','1003','Communication','30','40','44','4','1','1','2016-01-28 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1022','1001','1001','Health','32','40','44','2','1','1','2016-01-30 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1023','1001','1002','Intelligence','32','43','44','3','1','1','2016-01-30 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1024','1001','1003','Communication','32','43','46','2','1','1','2016-01-30 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1025','1001','1001','Health','33','43','46','1','1','1','2016-01-31 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1026','1001','1002','Intelligence','33','45','46','2','1','1','2016-01-31 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1027','1001','1003','Communication','33','45','47','1','1','1','2016-01-31 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1028','1001','1001','Health','37','45','47','4','1','1','2016-02-02 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1029','1001','1002','Intelligence','37','48','47','3','1','1','2016-02-02 10:07:46');
INSERT INTO `taskHistory` (`id`,`userID`,`taskID`,`statType`,`health`,`intelligence`,`communication`, `statValue`,`willPower`,`dailyTodo`,`dateCompleted`) VALUES
  ('1030','1001','1003','Communication','37','48','49','2','1','1','2016-02-02 10:07:46');


INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1001','1001','Health','1','Zarjadka','Yes','N','2016-01-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1002','1001','Intelligence','1','Read Java Books','Yes','N','2016-01-17 10:07:46','2015-11-17 10:07:46');
INSERT INTO `defaultTasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1003','1001','Communication','1','Meet Parents','Yes','N','2016-01-17 10:07:46','2015-11-17 10:07:46');