-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cabinet_medical
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cabinet_medical
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cabinet_medical` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cabinet_medical` ;

-- -----------------------------------------------------
-- Table `cabinet_medical`.`adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cabinet_medical`.`adresse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `rue` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(10) NOT NULL,
  `ville` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cabinet_medical`.`infirmiere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cabinet_medical`.`infirmiere` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adresse_id` INT NOT NULL,
  `numero_professionnel` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `tel_pro` VARCHAR(15) NOT NULL,
  `tel_perso` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telPro_UNIQUE` (`tel_pro` ASC) VISIBLE,
  UNIQUE INDEX `numeroProfessionnel_UNIQUE` (`numero_professionnel` ASC) VISIBLE,
  UNIQUE INDEX `telPerso_UNIQUE` (`tel_perso` ASC) VISIBLE,
  INDEX `fk_infirmiere_adresse1_idx` (`adresse_id` ASC) VISIBLE,
  CONSTRAINT `fk_infirmiere_adresse1`
    FOREIGN KEY (`adresse_id`)
    REFERENCES `cabinet_medical`.`adresse` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cabinet_medical`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cabinet_medical`.`patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adresse_id` INT NULL DEFAULT NULL,
  `infirmiere_id` INT NULL DEFAULT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `date_de_naissance` DATE NOT NULL,
  `sexe` ENUM('Homme', 'Femme', 'Autre') NOT NULL,
  `numero_securite_sociale` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numeroSecuriteSocial_UNIQUE` (`numero_securite_sociale` ASC) VISIBLE,
  INDEX `fk_patient_adresse_idx` (`adresse_id` ASC) VISIBLE,
  INDEX `fk_patient_infirmiere1_idx` (`infirmiere_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_adresse`
    FOREIGN KEY (`adresse_id`)
    REFERENCES `cabinet_medical`.`adresse` (`id`)
    ON DELETE SET NULL,
  CONSTRAINT `fk_patient_infirmiere1`
    FOREIGN KEY (`infirmiere_id`)
    REFERENCES `cabinet_medical`.`infirmiere` (`id`)
    ON DELETE SET NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cabinet_medical`.`deplacement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cabinet_medical`.`deplacement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `cout` DOUBLE NOT NULL,
  `infirmiere_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_deplacement_patient1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_deplacement_infirmiere1_idx` (`infirmiere_id` ASC) VISIBLE,
  CONSTRAINT `fk_deplacement_infirmiere1`
    FOREIGN KEY (`infirmiere_id`)
    REFERENCES `cabinet_medical`.`infirmiere` (`id`),
  CONSTRAINT `fk_deplacement_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `cabinet_medical`.`patient` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
