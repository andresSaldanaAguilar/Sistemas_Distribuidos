/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Roles;
import java.io.Serializable;

/**
 *
 * @author andressaldana
 */
public class RolDTO implements Serializable{
    private Roles entidad;
    public RolDTO(){
        this.entidad = new Roles();
    }
    
    public RolDTO(Roles entidad){
        this.entidad = entidad;
    }
    
    public Roles getEntidad(){
        return entidad;
    }
    
    public void setEntidad(Roles entidad){
        this.entidad = entidad;
    }
}
