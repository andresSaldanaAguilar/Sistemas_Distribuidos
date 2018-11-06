/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.utilerias.Resultado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author andressaldana
 */
public class GenericoDAO {
    @PersistenceContext
    (unitName = "PayaraApp-ejbPU")
    private EntityManager em;
    
    public Resultado guardar(Object entidad){
        Resultado r = new Resultado();
        try{
            em.persist(entidad);
            em.flush();
            r.setResultado(entidad);
        }catch(Exception e){
            r.setCodigo(-1);
            r.setMensaje(e.toString());
        }
        return r;
    }
    
    public Resultado actualizar(Object entidad){
        Resultado r = new Resultado();
        try{
            em.merge(entidad);
            em.flush();
            r.setResultado(entidad);
        }catch(Exception e){
            r.setCodigo(-1);
            r.setMensaje(e.toString());
        }
        return r;
    }
    
    public Resultado borrar(Object entidad){
        Resultado r = new Resultado();
        try{
            em.remove(entidad);
            em.flush();
        }catch(Exception e){
            r.setCodigo(-1);
            r.setMensaje(e.toString());
        }
        return r;
    }
    
    public Resultado buscar(Class clase, Object id){
        Resultado<Object> r = new Resultado();
        try{
            Object entidad = em.find(clase, id);
            r.setResultado(entidad);
        }catch(Exception e){
            r.setCodigo(-1);
            r.setMensaje(e.toString());
        }
        return r;
    }
    
    public <T extends Class> Resultado buscarTodos(T clase){
        Resultado<T> r = new Resultado();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clase);
        cq.from(clase);
        List<T> resultados = em.createQuery(cq).getResultList();
        r.setResultados(resultados);
        return r;
    }
}
