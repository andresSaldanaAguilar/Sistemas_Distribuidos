package modelo;
// Generated Oct 18, 2018 4:22:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Articulo generated by hbm2java
 */
public class Articulo  implements java.io.Serializable {


     private String claveArticulo;
     private String descripcion;
     private BigDecimal precio;
     private int existencias;

    public Articulo() {
    }

    public Articulo(String claveArticulo, String descripcion, BigDecimal precio, int existencias) {
       this.claveArticulo = claveArticulo;
       this.descripcion = descripcion;
       this.precio = precio;
       this.existencias = existencias;
    }
   
    public String getClaveArticulo() {
        return this.claveArticulo;
    }
    
    public void setClaveArticulo(String claveArticulo) {
        this.claveArticulo = claveArticulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public int getExistencias() {
        return this.existencias;
    }
    
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}

