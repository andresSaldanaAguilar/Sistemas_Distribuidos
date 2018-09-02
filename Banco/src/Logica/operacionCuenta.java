package Logica;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class operacionCuenta implements Serializable{
    private BigInteger idOperacionesCuenta;
    private Date fechaOperacion;
    private String tipoDeMovimiento;
    private double cantidad;
    private BigInteger idCuenta;

    public operacionCuenta(){}

    public BigInteger getIdOperacionesCuenta(){
        return this.idOperacionesCuenta;
    }
    public void setIdOperacionesCuenta(BigInteger idOperacionesCuenta){
        this.idOperacionesCuenta = idOperacionesCuenta;
    }
    public Date getFecha(){
        return this.fechaOperacion;
    }
    public void setFecha(Date fechaOperacion){
        this.fechaOperacion = fechaOperacion;
    }
    public String getTipo(){
        return this.tipoDeMovimiento;
    }
    public void setTipo(String tipoDeMovimiento){
        this.tipoDeMovimiento = tipoDeMovimiento;
    }
    public double getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }
    public BigInteger getIdCuenta(){
        return this.idCuenta;
    }
    public void setIdCuenta(BigInteger idCuenta){
        this.idCuenta = idCuenta;
    }
     
    
    //para que se esta usando?
    /*public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id").append(getIdProducto()).append("\n");
        sb.append("nombre").append(nombre).append("\n");
        sb.append("Categoria").append(idCategoria).append("\n");
        sb.append("Nombre Categoria").append(1).append("\n");
        return sb.toString();
    }*/
}