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

INSERT INTO user (username, password, firstname, lastname, email) 
VALUES('factored', 'factored', 'factored', 'factored', 'factored@gmail.com');

INSERT INTO empleados (nombre, posicion) VALUES ('Amilder', 'Software Developer');
INSERT INTO empleados (nombre, posicion) VALUES ('Denilson', 'Data Scientist');
INSERT INTO empleados (nombre, posicion) VALUES ('Natalia', 'Ingeniera en Robótica');
INSERT INTO empleados (nombre, posicion) VALUES ('Samuel', 'Ingeniero Dev-Ops');
INSERT INTO empleados (nombre, posicion) VALUES ('Berro', 'Discord Admin');


INSERT INTO skills (nombre) VALUES ('Java');
INSERT INTO skills (nombre) VALUES ('React');
INSERT INTO skills (nombre) VALUES ('MySQL');
INSERT INTO skills (nombre) VALUES ('Docker');
INSERT INTO skills (nombre) VALUES ('JavaScript');
INSERT INTO skills (nombre) VALUES ('Python');
INSERT INTO skills (nombre) VALUES ('R');
INSERT INTO skills (nombre) VALUES ('Pandas');
INSERT INTO skills (nombre) VALUES ('Tensorflow');
INSERT INTO skills (nombre) VALUES ('Spring Boot');
INSERT INTO skills (nombre) VALUES ('Angular');
INSERT INTO skills (nombre) VALUES ('C++');
INSERT INTO skills (nombre) VALUES ('Html');


INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '1', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '2', '3');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '3', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '4', '2');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '5', '5');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('1', '10', '4');

INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('2', '6', '1');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('2', '7', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('2', '8', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('2', '9', '3');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('2', '3', '2');

INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('3', '6', '3');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('3', '1', '3');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('3', '13', '2');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('3', '12', '1');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('3', '5', '1');

INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('4', '3', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('4', '5', '3');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('4', '6', '4');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('4', '8', '1');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('4', '13', '5');

INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('5', '1', '5');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('5', '4', '5');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('5', '11', '5');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('5', '12', '5');
INSERT INTO empleados_skills (empleado_id, skill_id, nivel) VALUES ('5', '10', '5');



