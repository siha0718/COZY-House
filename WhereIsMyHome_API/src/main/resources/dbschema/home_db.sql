-- MySQL Script generated by MySQL Workbench
-- Tue Nov 22 22:53:40 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `project` ;

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project` DEFAULT CHARACTER SET utf8 ;
USE `project` ;

-- -----------------------------------------------------
-- Table `project`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project`.`user` ;

CREATE TABLE IF NOT EXISTS `project`.`user` (
  `userid` VARCHAR(45) NOT NULL,
  `userpwd` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `useremail` VARCHAR(45) NULL,
  `userclass` INT NULL,
  `joindate` TIMESTAMP NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`houseinfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project`.`houseinfo` ;

CREATE TABLE IF NOT EXISTS `project`.`houseinfo` (
  `houseCode` INT NOT NULL AUTO_INCREMENT,
  `houseName` VARCHAR(45) NULL,
  `regCode` VARCHAR(45) NULL,
  `dongName` VARCHAR(45) NULL,
  `jibun` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `year` VARCHAR(45) NULL,
  `month` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `userid` VARCHAR(45) NULL,
  PRIMARY KEY (`houseCode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project`.`comment` ;

CREATE TABLE IF NOT EXISTS `project`.`comment` (
  `cmNum` INT NOT NULL AUTO_INCREMENT,
  `content` MEDIUMTEXT NULL,
  `houseCode` VARCHAR(45) NULL,
  `userid` VARCHAR(45) NULL,
  `time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cmNum`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`bookmark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project`.`bookmark` ;

CREATE TABLE IF NOT EXISTS `project`.`bookmark` (
  `houseCode` VARCHAR(45) NOT NULL,
  `houseName` VARCHAR(45) NULL,
  `regCode` VARCHAR(45) NULL,
  `dongName` VARCHAR(45) NULL,
  `jibun` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `year` VARCHAR(45) NULL,
  `month` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `userid` VARCHAR(45) NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into user(userid,userpwd,username,useremail,userclass)
values('admin','1234','운영자','admin@ssafy.com','0');

commit;