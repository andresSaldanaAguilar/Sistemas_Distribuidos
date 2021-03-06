package Modelos;
// Generated Nov 29, 2018 6:10:28 PM by Hibernate Tools 4.3.1



/**
 * Carrera generated by hbm2java
 */
public class Carrera  implements java.io.Serializable {


     private Integer idCarrera;
     private String nombreCarrera;
     private String descripcionCarrera;

    public Carrera() {
    }

    public Carrera(String nombreCarrera, String descripcionCarrera) {
       this.nombreCarrera = nombreCarrera;
       this.descripcionCarrera = descripcionCarrera;
    }
   
    public Integer getIdCarrera() {
        return this.idCarrera;
    }
    
    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }
    public String getNombreCarrera() {
        return this.nombreCarrera;
    }
    
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public String getDescripcionCarrera() {
        return this.descripcionCarrera;
    }
    
    public void setDescripcionCarrera(String descripcionCarrera) {
        this.descripcionCarrera = descripcionCarrera;
    }

    public String toString(){
        return idCarrera+"\t"+nombreCarrera+"\t"+descripcionCarrera;
    }
}


