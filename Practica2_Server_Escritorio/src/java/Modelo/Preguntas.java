package Modelo;
// Generated 14-oct-2018 18:13:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Preguntas generated by hbm2java
 */
public class Preguntas  implements java.io.Serializable {


     private int idPregunta;
     private Examen examen;
     private String pregunta;
     private Set respuestases = new HashSet(0);

    public Preguntas() {
    }

	
    public Preguntas(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public Preguntas(int idPregunta, Examen examen, String pregunta, Set respuestases) {
       this.idPregunta = idPregunta;
       this.examen = examen;
       this.pregunta = pregunta;
       this.respuestases = respuestases;
    }
   
    public Preguntas(int idPregunta, Examen examen, String pregunta) {
       this.idPregunta = idPregunta;
       this.examen = examen;
       this.pregunta = pregunta;
    }
    
    public int getIdPregunta() {
        return this.idPregunta;
    }
    
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public Examen getExamen() {
        return this.examen;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public Set getRespuestases() {
        return this.respuestases;
    }
    
    public void setRespuestases(Set respuestases) {
        this.respuestases = respuestases;
    }




}

