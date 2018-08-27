package Logica;


import java.io.Serializable;

public class Producto implements Serializable{
    private int idProducto;
    private String nombre;
    private double precio;
    private int idCategoria;

    public Producto(){}

    public int getIdProducto(){
        return this.idProducto;
    }
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public int getIdCategoria(){
        return this.idCategoria;
    }
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }
    
    
    //para que se esta usando?
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id").append(getIdProducto()).append("\n");
        sb.append("nombre").append(nombre).append("\n");
        sb.append("Categoria").append(idCategoria).append("\n");
        sb.append("Nombre Categoria").append(1).append("\n");
        return sb.toString();
    }
}

//mostrar productos por categoria
//mostrar producto, categoria y nombre de categoria