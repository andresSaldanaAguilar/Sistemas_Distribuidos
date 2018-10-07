package Modelos;
// Generated Sep 29, 2018 5:52:28 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Examen generated by hbm2java
 */
public class Examen  implements java.io.Serializable {


     private int idExamen;
     private Materias materias;
     private Date fecha;
     private Set preguntases = new HashSet(0);
     private Set calificacioneses = new HashSet(0);

    public Examen() {
    }

	
    public Examen(int idExamen) {
        this.idExamen = idExamen;
    }
    public Examen(int idExamen, Materias materias, Date fecha, Set preguntases, Set calificacioneses) {
       this.idExamen = idExamen;
       this.materias = materias;
       this.fecha = fecha;
       this.preguntases = preguntases;
       this.calificacioneses = calificacioneses;
    }
   
    public int getIdExamen() {
        return this.idExamen;
    }
    
    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }
    public Materias getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getPreguntases() {
        return this.preguntases;
    }
    
    public void setPreguntases(Set preguntases) {
        this.preguntases = preguntases;
    }
    public Set getCalificacioneses() {
        return this.calificacioneses;
    }
    
    public void setCalificacioneses(Set calificacioneses) {
        this.calificacioneses = calificacioneses;
    }




}


