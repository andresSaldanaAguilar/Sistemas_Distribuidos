/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.ejb;

import com.ipn.mx.modelo.dao.GenericoDAO;
import com.ipn.mx.modelo.dto.RolDTO;
import com.ipn.mx.modelo.entidades.Roles;
import com.ipn.mx.utilerias.Resultado;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author andressaldana
 */
@Stateless
@LocalBean
public class CarreraEJB {
    @EJB
    private GenericoDAO dao;
    public Resultado<RolDTO> guardar(RolDTO dto){
        Resultado <RolDTO> respuesta = new Resultado<>();
        // si validar(dto) == 0 entonces 
        if(validar(dto) ==0){
            Resultado rDao = dao.guardar(dto.getEntidad());
            respuesta = rDao.convertirATipo(RolDTO.class);
            if(respuesta.getCodigo() != 0){
                respuesta.setCodigo(-2);
            }
        }else{
            respuesta.setCodigo(0);
        }
        return respuesta;
    }
    
    public Resultado<RolDTO> actualizar(RolDTO dto){
        Resultado<RolDTO> respuesta = new Resultado<>();
        if(validar(dto) ==0){
            Resultado rDao = dao.actualizar(dto.getEntidad());
            respuesta = rDao.convertirATipo(RolDTO.class);
            if(respuesta.getCodigo() != 0){
                respuesta.setCodigo(-2);
            }
        }else{
            respuesta.setCodigo(0);
        }
        return respuesta;
    }
    
    public Resultado<RolDTO> eliminar(RolDTO dto){
        Resultado<RolDTO> respuesta = new Resultado<>();
            Resultado rDao = dao.eliminar(dto.getEntidad());
            respuesta = rDao.convertirATipo(RolDTO.class);
            if(respuesta.getCodigo() != 0){
                respuesta.setCodigo(-2);
            }
        return respuesta;
    }
    
    public Resultado<RolDTO> mostrarTodos(){

            Resultado<Roles> rDao = dao.buscarTodos(Roles.class);
            Resultado<RolDTO> respuesta = rDao.convertirATipo(RolDTO.class);
            if(respuesta.getCodigo() != 0){
                ArrayList<RolDTO> rolesDTOs = new ArrayList<>();
                for(Roles roles: rDao.getResultados()){
                    rolesDTOs.add(new RolDTO(roles));
                }
            }
            else{
                respuesta.setCodigo(-2);
            }
        return respuesta;
    }
    
    public Resultado<RolDTO> buscarPorId(Integer id){

            Resultado<Roles> rDao = dao.buscar(Roles.class,id);
            Resultado<RolDTO> respuesta = rDao.convertirATipo(RolDTO.class);
            if(respuesta.getCodigo() != 0){
                respuesta.setResultado(new RolDTO(rDao.getResultado()));
            }
            else{
                respuesta.setCodigo(-2);
            }
        return respuesta;
    }
    
    private int validar(RolDTO dto){
        int codigo = 0;
        /* si nombre de la carrera nulo, invalido */
        /* si ya existe el nombre, regresar invalido */
        return codigo;
    }
    
}
