package Modelo;
// Generated 14-oct-2018 18:13:40 by Hibernate Tools 4.3.1

import Controlador.AlumnoController;
import Controlador.ExamenController;




/**
 * Calificaciones generated by hbm2java
 */
public class Calificaciones  implements java.io.Serializable {


     private int idCalificaciones;
     private Alumno alumno;
     private Examen examen;
     private Double puntuaje;

    public Calificaciones() {
    }

	
    public Calificaciones(int idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }
    public Calificaciones(int idCalificaciones, Alumno alumno, Examen examen, Double puntuaje) {
       this.idCalificaciones = idCalificaciones;
       this.alumno = alumno;
       this.examen = examen;
       this.puntuaje = puntuaje;
    }

   
    public int getIdCalificaciones() {
        return this.idCalificaciones;
    }
    
    public void setIdCalificaciones(int idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Examen getExamen() {
        return this.examen;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    public Double getPuntuaje() {
        return this.puntuaje;
    }
    
    public void setPuntuaje(Double puntuaje) {
        this.puntuaje = puntuaje;
    }




}


