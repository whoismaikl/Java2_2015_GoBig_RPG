SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- ---
-- Globals


-- ---
-- Table 'users'
--
-- ---

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `email` CHAR(40) NULL DEFAULT NULL,
  `password` CHAR(40) NULL DEFAULT NULL,
  `userName` CHAR(30) NULL DEFAULT NULL,
  `userType` CHAR(1) NULL DEFAULT 'U',
  `health` INTEGER NULL DEFAULT NULL,
  `intellegence` INTEGER NULL DEFAULT NULL,
  `communication` INTEGER NULL DEFAULT NULL,
  `willPower` INTEGER NULL DEFAULT NULL,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `lastLogin` DATETIME NULL DEFAULT NULL,
  `dateRegistered` DATETIME NULL DEFAULT NULL,
  `accountActivetYN` CHAR NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'tasks'
--
-- ---

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `userID` INTEGER NOT NULL,
  `statType` CHAR(17) NOT NULL,
  `statValue` INTEGER NULL,
  `statDescription` CHAR(255) NULL DEFAULT NULL,
  `repeatableYN` CHAR NOT NULL DEFAULT 'N',
  `accomplishedYN` CHAR(1) NOT NULL DEFAULT 'N',
  `dateAdded` DATETIME NOT NULL,
  `dateAccomplished` DATE NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'statHistory'
--
-- ---

DROP TABLE IF EXISTS `statHistory`;

CREATE TABLE `statHistory` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `userID` INTEGER NULL DEFAULT NULL,
  `health` INTEGER NULL DEFAULT NULL,
  `intellegence` INTEGER NULL DEFAULT NULL,
  `communication` INTEGER NULL DEFAULT NULL,
  `willPower` INTEGER NULL DEFAULT NULL,
  `dailyTodo` INTEGER NULL DEFAULT NULL,
  `dateReceived` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'customTasks'
--
-- ---

DROP TABLE IF EXISTS `defaultTasks`;

CREATE TABLE `defaultTasks` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `userID` INTEGER NULL DEFAULT NULL,
  `taskDescription` CHAR(255) NULL DEFAULT NULL,
  `taskType` CHAR(25) NULL DEFAULT NULL,
  `taskValue` INTEGER NULL DEFAULT 1,
  `dateCompleted` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys
-- ---

ALTER TABLE `tasks` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`);
ALTER TABLE `statHistory` ADD FOREIGN KEY (userID) REFERENCES `users` (`id`);

--
-- ---
-- Test Data
-- ---

INSERT INTO `users` (`id`,`email`,`password`,`userName`,`userType`,`health`,`intellegence`,`communication`,`willPower`,`dailyTodo`,`lastLogin`,`dateRegistered`,`accountActivetYN`) VALUES
  ('1001','a','a','My User Name','U','50','50','50','0','0','2015-10-26 02:01:03','2015-10-26 02:01:03','N');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1001','1001','Health','1','Description for health','Y','N','2015-11-17 10:07:46','2015-10-26');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1002','1001','Intellegence','1','Description for intellegence','Y','N','2015-11-17 10:07:46','2015-10-26');
INSERT INTO `tasks` (`id`,`userID`,`statType`,`statValue`,`statDescription`,`repeatableYN`,`accomplishedYN`,`dateAdded`,`dateAccomplished`) VALUES
  ('1003','1001','Communication','1','Description for communication','Y','N','2015-11-17 10:07:46','2015-10-26');

-- INSERT INTO `statHistory` (`id`,`userID`,`health`,`intellegence`,`communication`,`willPower`,`dailyTodo`,`dateReceived`) VALUES
-- ('','','','','','','','');
-- INSERT INTO `customTasks` (`id`,`userID`,`taskDescription`,`taskType`,`taskValue`,`dateCompleted`) VALUES
-- ('','','','','','');