-- MySQL Script generated by MySQL Workbench
-- Thu Feb 14 11:37:38 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lzx_ci_sample
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lzx_ci_sample` ;

-- -----------------------------------------------------
-- Schema lzx_ci_sample
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lzx_ci_sample` DEFAULT CHARACTER SET utf8 ;
USE `lzx_ci_sample` ;

-- -----------------------------------------------------
-- Table `lzx_ci_sample`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lzx_ci_sample`.`user` ;

CREATE TABLE IF NOT EXISTS `lzx_ci_sample`.`user` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lzx_ci_sample`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lzx_ci_sample`.`t_order` ;

CREATE TABLE IF NOT EXISTS `lzx_ci_sample`.`t_order` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `status` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lzx_ci_sample`.`order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lzx_ci_sample`.`order_item` ;

CREATE TABLE IF NOT EXISTS `lzx_ci_sample`.`order_item` (
  `id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `count` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  PRIMARY KEY (`id`, `order_id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
