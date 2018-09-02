/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author andressaldana
 */
public class Categoria {
    int idCategoria;
    String nombre;
    String descripcion;
    
    public Categoria(){}
    
    public int getIdCategoria(){
        return this.idCategoria;
    }
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
