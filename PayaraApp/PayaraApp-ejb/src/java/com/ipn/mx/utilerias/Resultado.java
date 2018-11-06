/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import java.util.List;

/**
 *
 * @author andressaldana
 */
public class Resultado<T> {
    private int codigo;
    private String mensaje;
    private T resultado;
    private List<T> resultados;
    
    public Resultado(){
        this.codigo = 0;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public List<T> getResultados(){
        return resultados;
    }
            
    public void setResultados(List<T> resultados){
        this.resultados = resultados;
    }
    
    public T getResultado(){
        return resultado;
    }
            
    public void setResultado(T resultados){
        this.resultado = resultado;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }    
    
    public <U extends Object> Resultado<U> convertitATipo(Class<U> clase){
        Resultado<U> respuesta = new Resultado<>();
        respuesta.setCodigo(this.getCodigo());
        return respuesta;
    }
}
