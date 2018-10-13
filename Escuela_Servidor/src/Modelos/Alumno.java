package Modelos;
// Generated Sep 29, 2018 5:52:28 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private long matricula;
     private Carrera carrera;
     private String nombreAlumno;
     private String paternoAlumno;
     private String maternoAlumno;
     private Date fechaNacimiento;
     private String calle;
     private String colonia;
     private Integer numero;
     private Long codigoPostal;
     private String sexo;
     private String email;
     private Set calificacioneses = new HashSet(0);

    public Alumno() {
    }

	
    public Alumno(long matricula) {
        this.matricula = matricula;
    }
    public Alumno(long matricula, Carrera carrera, String nombreAlumno, String paternoAlumno, String maternoAlumno, Date fechaNacimiento, String calle, String colonia, Integer numero, Long codigoPostal, String sexo, String email, Set calificacioneses) {
       this.matricula = matricula;
       this.carrera = carrera;
       this.nombreAlumno = nombreAlumno;
       this.paternoAlumno = paternoAlumno;
       this.maternoAlumno = maternoAlumno;
       this.fechaNacimiento = fechaNacimiento;
       this.calle = calle;
       this.colonia = colonia;
       this.numero = numero;
       this.codigoPostal = codigoPostal;
       this.sexo = sexo;
       this.email = email;
       this.calificacioneses = calificacioneses;
    }
   
    public long getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public String getNombreAlumno() {
        return this.nombreAlumno;
    }
    
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public String getPaternoAlumno() {
        return this.paternoAlumno;
    }
    
    public void setPaternoAlumno(String paternoAlumno) {
        this.paternoAlumno = paternoAlumno;
    }
    public String getMaternoAlumno() {
        return this.maternoAlumno;
    }
    
    public void setMaternoAlumno(String maternoAlumno) {
        this.maternoAlumno = maternoAlumno;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getColonia() {
        return this.colonia;
    }
    
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Long getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(Long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getCalificacioneses() {
        return this.calificacioneses;
    }
    
    public void setCalificacioneses(Set calificacioneses) {
        this.calificacioneses = calificacioneses;
    }




}

