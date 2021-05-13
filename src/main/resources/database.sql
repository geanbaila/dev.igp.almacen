-- MySQL Script generated by MySQL Workbench
-- Sat May  8 13:53:25 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almacen` DEFAULT CHARACTER SET utf8 ;
USE `almacen` ;

-- -----------------------------------------------------
-- Table `almacen`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`marca` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`modelo` (
  `idmodelo` INT NOT NULL,
  `marca_id` INT NOT NULL,
  PRIMARY KEY (`idmodelo`),
  INDEX `fk_modelo_marca1_idx` (`marca_id` ASC) ,
  CONSTRAINT `fk_modelo_marca1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `almacen`.`marca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`puesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`puesto` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`bien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`item` (
  `id` INT NOT NULL,
  `puesto_id` INT NOT NULL,
  `marca_id` INT NOT NULL,
  `modelo_id` INT NOT NULL,
  `denominacion` VARCHAR(45) NULL,
  `codigo_patrimonial` VARCHAR(45) NOT NULL,
  `codigo_ambiente` VARCHAR(45) NULL,
  `codigo_inventario` VARCHAR(8) NULL,
  `fecha_inventario` VARCHAR(4) NULL,
  `serie` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_marca1_idx` (`marca_id` ASC) ,
  INDEX `fk_item_modelo1_idx` (`modelo_id` ASC) ,
  UNIQUE INDEX `codigo_patrimonial_UNIQUE` (`codigo_patrimonial` ASC) ,
  INDEX `fk_bien_puesto1_idx` (`puesto_id` ASC) ,
  CONSTRAINT `fk_item_marca1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `almacen`.`marca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_modelo1`
    FOREIGN KEY (`modelo_id`)
    REFERENCES `almacen`.`modelo` (`idmodelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bien_puesto1`
    FOREIGN KEY (`puesto_id`)
    REFERENCES `almacen`.`puesto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`tipo_orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`tipo_orden` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`motivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`motivo` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`estado_orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`estado_orden` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`origen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`origen` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`rol_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`rol_usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`usuario` (
  `id` INT NOT NULL,
  `rol_usuario_id` INT NOT NULL,
  `usuario` VARCHAR(45) NULL,
  `clave` VARCHAR(45) NULL,
  `bestado` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_rol_usuario1_idx` (`rol_usuario_id` ASC) ,
  CONSTRAINT `fk_usuario_rol_usuario1`
    FOREIGN KEY (`rol_usuario_id`)
    REFERENCES `almacen`.`rol_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden` (
  `id` INT NOT NULL,
  `tipo_orden_id` INT NOT NULL,
  `motivo_id` INT NOT NULL,
  `estado_orden_id` INT NOT NULL,
  `origen_id` INT NOT NULL,
  `destino` VARCHAR(45) NULL,
  `fecha_salida_prevista` DATE NULL,
  `fecha_retorno_prevista` DATE NULL,
  `comisionado` VARCHAR(45) NULL,
  `comisionado_dni` VARCHAR(45) NULL,
  `comisionado_area` VARCHAR(45) NULL,
  `autoriza` VARCHAR(45) NULL,
  `autoriza_dni` VARCHAR(45) NULL,
  `autoriza_area` VARCHAR(45) NULL,
  `accesorio` VARCHAR(45) NULL,
  `observacion` VARCHAR(45) NULL,
  `fecha_salida` DATETIME NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_tipo_orden_idx` (`tipo_orden_id` ASC) ,
  INDEX `fk_orden_motivo1_idx` (`motivo_id` ASC) ,
  INDEX `fk_orden_estado_orden1_idx` (`estado_orden_id` ASC) ,
  INDEX `fk_orden_origen1_idx` (`origen_id` ASC) ,
  INDEX `fk_orden_usuario1_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_orden_tipo_orden`
    FOREIGN KEY (`tipo_orden_id`)
    REFERENCES `almacen`.`tipo_orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_motivo1`
    FOREIGN KEY (`motivo_id`)
    REFERENCES `almacen`.`motivo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_estado_orden1`
    FOREIGN KEY (`estado_orden_id`)
    REFERENCES `almacen`.`estado_orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_origen1`
    FOREIGN KEY (`origen_id`)
    REFERENCES `almacen`.`origen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `almacen`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`personal` (
  `id` INT NOT NULL,
  `puesto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_personal_puesto1_idx` (`puesto_id` ASC) ,
  CONSTRAINT `fk_personal_puesto1`
    FOREIGN KEY (`puesto_id`)
    REFERENCES `almacen`.`puesto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`rol_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`rol_usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden_detalle` (
  `id` INT NOT NULL,
  `orden_id` INT NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `denominacion` VARCHAR(45) NULL,
  `codigo_patrimonial` VARCHAR(45) NULL,
  `codigo_ambiente` VARCHAR(45) NULL,
  `codigo_inventario` VARCHAR(45) NULL,
  `serie` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `retorna` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_detalle_orden1_idx` (`orden_id` ASC) ,
  CONSTRAINT `fk_orden_detalle_orden1`
    FOREIGN KEY (`orden_id`)
    REFERENCES `almacen`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden_firma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden_firma` (
  `id` INT NOT NULL,
  `orden_id` INT NOT NULL,
  `cargo` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `estado` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_firma_orden1_idx` (`orden_id` ASC) ,
  CONSTRAINT `fk_orden_firma_orden1`
    FOREIGN KEY (`orden_id`)
    REFERENCES `almacen`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`configuracion_firma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`configuracion_firma` (
  `id` INT NOT NULL,
  `personal_id` INT NOT NULL,
  `cargo` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `bestado` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_configuracion_firma_personal1_idx` (`personal_id` ASC) ,
  CONSTRAINT `fk_configuracion_firma_personal1`
    FOREIGN KEY (`personal_id`)
    REFERENCES `almacen`.`personal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden_retorno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden_retorno` (
  `id` INT NOT NULL,
  `orden_id` INT NOT NULL,
  `comisionado` VARCHAR(45) NULL,
  `comisionado_dni` VARCHAR(45) NULL,
  `comisionado_area` VARCHAR(45) NULL,
  `asignado` VARCHAR(45) NULL,
  `asignado_dni` VARCHAR(45) NULL,
  `asignado_area` VARCHAR(45) NULL,
  `fecha_retorno` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_retorno_orden1_idx` (`orden_id` ASC) ,
  CONSTRAINT `fk_orden_retorno_orden1`
    FOREIGN KEY (`orden_id`)
    REFERENCES `almacen`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden_retorno_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden_retorno_detalle` (
  `id` INT NOT NULL,
  `orden_retorno_idorden_retorno` INT NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `denominacion` VARCHAR(45) NULL,
  `codigo_patrimonial` VARCHAR(45) NULL,
  `codigo_ambiente` VARCHAR(45) NULL,
  `codigo_inventario` VARCHAR(45) NULL,
  `serie` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `fecha_retorno_prevista` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_retorno_detalle_orden_retorno1_idx` (`orden_retorno_idorden_retorno` ASC) ,
  CONSTRAINT `fk_orden_retorno_detalle_orden_retorno1`
    FOREIGN KEY (`orden_retorno_idorden_retorno`)
    REFERENCES `almacen`.`orden_retorno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`orden_retorno_firma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`orden_retorno_firma` (
  `id` INT NOT NULL,
  `orden_retorno_id` INT NOT NULL,
  `cargo` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `estado` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_retorno_firma_orden_retorno1_idx` (`orden_retorno_id` ASC) ,
  CONSTRAINT `fk_orden_retorno_firma_orden_retorno1`
    FOREIGN KEY (`orden_retorno_id`)
    REFERENCES `almacen`.`orden_retorno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;