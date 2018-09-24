/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.ejemplos;

import com.ipn.mx.entidades.Alumnos;
import com.ipn.mx.entidades.Carrera;
import com.ipn.mx.entidades.Escuela;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author andressaldana
 */
public class Consultas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlumnoCarreraPU");
        EntityManager em = emf.createEntityManager();
        
        //agrega
        //Escuela e = new Escuela();
        //ya hace el auto increment del id
        /*e.setNombreEscuela("ESIQIE");
        e.setCalle("Juan de dios Batiz");
        e.setNumero(1000);   
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); */
        
        Carrera e = new Carrera();
        //ya hace el auto increment del id
        e.setNombreCarrera("Sistemas"); 
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        
        //modifica
        /*Escuela e = em.find( Escuela.class, 2);
        e.setIdEscuela(2);
        e.setNombreEscuela("ESE VATOVSKY");
        em.getTransaction().begin();   
        em.merge(e);
        em.getTransaction().commit(); */
        
        //elimina
        /*Escuela e = em.find( Escuela.class, 1);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit(); */
        
        //lista
        /*
        TypedQuery<Escuela> consulta = em.createNamedQuery("Escuela.findAll",Escuela.class);
        List <Escuela> lista = consulta.getResultList();
        for (Escuela escuela : lista) {
            System.out.println(escuela.getIdEscuela()+"_"+escuela.getCalle()+"_"+escuela.getNombreEscuela());
        }*/
        
        //lista por id
        /*
        List<Escuela> lista = em.createQuery("SELECT e from Escuela e WHERE e.calle = :ids").setParameter("ids","Otra Callee").getResultList();
        for (Escuela escuela : lista) {
            System.out.println(escuela.getIdEscuela()+"_"+escuela.getCalle()+"_"+escuela.getNombreEscuela());
        }*/
 
    }
}
