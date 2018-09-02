package Logica;


import java.io.Serializable;

public class Clientes implements Serializable{
    private int idClientes;
    private String contrasenia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroTelefonico;
    private String calle;
    private String colonia;
    private int numero;

    public Clientes(){}

    public int getIdClientes(){
        return this.idClientes;
    }
    public void setIdClientes(int idClientes){
        this.idClientes = idClientes;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getContrasenia(){
        return this.contrasenia;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    public String getApat(){
        return this.apellidoPaterno;
    }
    public void setApat(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getAmat(){
        return this.apellidoMaterno;
    }
    public void setAmat(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }  
    public String getnumTel(){
        return this.numeroTelefonico;
    }
    public void setnumTel(String numeroTelefonico){
        this.numeroTelefonico = numeroTelefonico;
    }
    public String getCalle(){
        return this.calle;
    }
    public void setCalle(String calle){
        this.calle = calle;
    } 
    public String getColonia(){
        return this.colonia;
    }
    public void setColonia(String colonia){
        this.colonia = colonia;
    }             
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
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