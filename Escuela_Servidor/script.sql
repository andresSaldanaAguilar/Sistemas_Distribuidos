DROP DATABASE IF EXISTS Escuela;
CREATE DATABASE Escuela;
USE Escuela;

create table centrodetrabajo(
    idCentroDeTrabajo int(11) primary key not null,
    nombreCentroDeTrabajo varchar(45)
);

create table carrera(
    idCarrera int(11) primary key not null,
    nombreCarrera varchar(45),
    duracion int(11),
    idCentroDeTrabajo int(11),
        FOREIGN KEY (idCentroDeTrabajo)
        REFERENCES centrodetrabajo(idCentroDeTrabajo)
        ON DELETE CASCADE
);

create table alumno(
    matricula bigint(20) primary key not null,
    nombreAlumno varchar(45),
    paternoAlumno varchar(45),
    maternoAlumno varchar(45),
    fechaNacimiento date,
    calle varchar(45),
    colonia varchar(45),
    numero int(11),
    codigoPostal bigint(20),
    sexo varchar(1),
    eMail varchar(45),
    idCarrera int(11),
        FOREIGN KEY (idCarrera)
        REFERENCES carrera(idCarrera)
        ON DELETE CASCADE
);

create table materias(
    idMaterias int(11) primary key not null,
    nombreMateria varchar(45),
    creditos int(11)    
);

create table examen(
    idExamen int(11) primary key not null,
    fecha date,
    idMaterias int(11),
    FOREIGN KEY (idMaterias)
        REFERENCES materias(idMaterias)
        ON DELETE CASCADE
);

create table calificaciones(
    idCalificaciones int(11) primary key not null,
    puntuaje double,
    idExamen int(11),
    matricula bigint(20),
        FOREIGN KEY (idExamen)
        REFERENCES examen(idExamen)
        ON DELETE CASCADE,
        FOREIGN KEY (matricula)
        REFERENCES alumno(matricula)
        ON DELETE CASCADE
);

create table preguntas(
    idPregunta int(11) primary key not null,
    pregunta varchar(100),
    idExamen int(11),
        FOREIGN KEY (idExamen)
        REFERENCES examen(idExamen)
        ON DELETE CASCADE
);

create table respuestas(
    idRespuesta int(11) primary key not null,
    respuesta varchar(100),
    idPregunta int(11),
        FOREIGN KEY (idPregunta)
        REFERENCES preguntas(idPregunta)
        ON DELETE CASCADE
);
