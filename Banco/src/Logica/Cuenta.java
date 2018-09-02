package Logica;


import java.io.Serializable;
import java.math.BigInteger;

public class Cuenta implements Serializable{
    private BigInteger idCuenta;
    private double balance;
    private int idClientes;

    public Cuenta(){}

    public BigInteger getIdCuenta(){
        return this.idCuenta;
    }
    public void setIdCuenta(BigInteger idCuenta){
        this.idCuenta = idCuenta;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public int getIdCliente(){
        return this.idClientes;
    }
    public void setContrasenia(int idClientes){
        this.idClientes = idClientes;
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