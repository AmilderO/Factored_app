-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema factored_demo2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema factored_demo2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `factored_demo2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `factored_demo2` ;

-- -----------------------------------------------------
-- Table `factored_demo2`.`empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factored_demo2`.`empleados` ;

CREATE TABLE IF NOT EXISTS `factored_demo2`.`empleados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `posicion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `factored_demo2`.`skills`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factored_demo2`.`skills` ;

CREATE TABLE IF NOT EXISTS `factored_demo2`.`skills` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `factored_demo2`.`empleados_skills`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factored_demo2`.`empleados_skills` ;

CREATE TABLE IF NOT EXISTS `factored_demo2`.`empleados_skills` (
  `empleado_id` INT NOT NULL,
  `skill_id` INT NOT NULL,
  `nivel` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`empleado_id`, `skill_id`),
  INDEX `FK_SKILL` (`skill_id` ASC) VISIBLE,
  CONSTRAINT `FK_EMPLEADO`
    FOREIGN KEY (`empleado_id`)
    REFERENCES `factored_demo2`.`empleados` (`id`),
  CONSTRAINT `FK_SKILL`
    FOREIGN KEY (`skill_id`)
    REFERENCES `factored_demo2`.`skills` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `factored_demo2`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factored_demo2`.`user` ;

CREATE TABLE IF NOT EXISTS `factored_demo2`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_date` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `firstname` VARCHAR(255) NULL DEFAULT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `modified_date` DATETIME(6) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `role` ENUM('ADMIN', 'USER') NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKf9dvvibvpfsldnu8wh3enop4i` (`username` ASC, `email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `factored_demo2`.`token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factored_demo2`.`token` ;

CREATE TABLE IF NOT EXISTS `factored_demo2`.`token` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_pddrhgwxnms2aceeku9s2ewy5` (`token` ASC) VISIBLE,
  INDEX `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2`
    FOREIGN KEY (`user_id`)
    REFERENCES `factored_demo2`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 97
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
