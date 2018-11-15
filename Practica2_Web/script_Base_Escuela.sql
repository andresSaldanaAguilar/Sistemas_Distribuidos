-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema escuela
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema escuela
-- -----------------------------------------------------
DROP DATABASE if exists escuela;
CREATE SCHEMA IF NOT EXISTS `escuela` DEFAULT CHARACTER SET utf8 ;
USE `escuela` ;

-- -----------------------------------------------------
-- Table `escuela`.`centrodetrabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`centrodetrabajo` (
  `idCentroDeTrabajo` INT(11) NOT NULL,
  `nombreCentroDeTrabajo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCentroDeTrabajo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`carrera` (
  `idCarrera` INT(11) NOT NULL,
  `nombreCarrera` VARCHAR(45) NULL DEFAULT NULL,
  `duracion` INT(11) NULL DEFAULT NULL,
  `idCentroDeTrabajo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCarrera`),
  INDEX `idCentroDeTrabajo` (`idCentroDeTrabajo` ASC),
  CONSTRAINT `carrera_ibfk_1`
    FOREIGN KEY (`idCentroDeTrabajo`)
    REFERENCES `escuela`.`centrodetrabajo` (`idCentroDeTrabajo`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`alumno` (
  `matricula` BIGINT(20) NOT NULL,
  `nombreAlumno` VARCHAR(45) NULL DEFAULT NULL,
  `paternoAlumno` VARCHAR(45) NULL DEFAULT NULL,
  `maternoAlumno` VARCHAR(45) NULL DEFAULT NULL,
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  `calle` VARCHAR(45) NULL DEFAULT NULL,
  `colonia` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `codigoPostal` BIGINT(20) NULL DEFAULT NULL,
  `sexo` VARCHAR(1) NULL DEFAULT NULL,
  `eMail` VARCHAR(45) NULL DEFAULT NULL,
  `idCarrera` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `idCarrera` (`idCarrera` ASC),
  CONSTRAINT `alumno_ibfk_1`
    FOREIGN KEY (`idCarrera`)
    REFERENCES `escuela`.`carrera` (`idCarrera`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`materias` (
  `idMaterias` INT(11) NOT NULL,
  `nombreMateria` VARCHAR(45) NULL DEFAULT NULL,
  `creditos` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idMaterias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`examen` (
  `idExamen` INT(11) NOT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `idMaterias` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idExamen`),
  INDEX `idMaterias` (`idMaterias` ASC),
  CONSTRAINT `examen_ibfk_1`
    FOREIGN KEY (`idMaterias`)
    REFERENCES `escuela`.`materias` (`idMaterias`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`calificaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`calificaciones` (
  `idCalificaciones` INT(11) NOT NULL,
  `puntuaje` DOUBLE NULL DEFAULT NULL,
  `idExamen` INT(11) NULL DEFAULT NULL,
  `matricula` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idCalificaciones`),
  INDEX `idExamen` (`idExamen` ASC),
  INDEX `matricula` (`matricula` ASC),
  CONSTRAINT `calificaciones_ibfk_1`
    FOREIGN KEY (`idExamen`)
    REFERENCES `escuela`.`examen` (`idExamen`)
    ON DELETE CASCADE,
  CONSTRAINT `calificaciones_ibfk_2`
    FOREIGN KEY (`matricula`)
    REFERENCES `escuela`.`alumno` (`matricula`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`preguntas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`preguntas` (
  `idPregunta` INT(11) NOT NULL,
  `pregunta` VARCHAR(100) NULL DEFAULT NULL,
  `idExamen` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idPregunta`),
  INDEX `idExamen` (`idExamen` ASC),
  CONSTRAINT `preguntas_ibfk_1`
    FOREIGN KEY (`idExamen`)
    REFERENCES `escuela`.`examen` (`idExamen`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `escuela`.`respuestas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`respuestas` (
  `idRespuesta` INT(11) NOT NULL,
  `respuesta` VARCHAR(100) NULL DEFAULT NULL,
  `idPregunta` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRespuesta`),
  INDEX `idPregunta` (`idPregunta` ASC),
  CONSTRAINT `respuestas_ibfk_1`
    FOREIGN KEY (`idPregunta`)
    REFERENCES `escuela`.`preguntas` (`idPregunta`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into centrodetrabajo (idCentroDetrabajo, nombreCentroDeTrabajo) values(1,"ESCOM");
insert into carrera(idCarrera,nombreCarrera,duracion,idCentroDeTrabajo) values(1,"Ingenieria en Sistemas",2,1);
insert into materias(idMaterias,nombreMateria,creditos) values(1,"Base de datos",12);
insert into alumno(matricula,nombreAlumno,paternoAlumno,maternoAlumno,fechaNacimiento,calle,colonia,numero,codigoPostal,sexo,eMail,idCarrera) values(2016630357,"Andres","Saldana","Aguilar",STR_TO_DATE('18-03-1997', '%d-%m-%Y'),"calle","colonia",12,54170,'M',"example@gmail.com",1);
insert into examen(idExamen,fecha,idMaterias) values(1,CURDATE(),1);
insert into preguntas(idPregunta,pregunta,idExamen) values(1,"de que color son las mangas del chaleco blanco de napoleon?",1); 
insert into respuestas(idRespuesta,respuesta,idPregunta) values(1,"no tiene mangas XDXDXDXD",1);
insert into calificaciones(idCalificaciones,puntuaje,idExamen,matricula) values(1,10,1,2016630357);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
