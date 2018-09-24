/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Carrera;

/**
 *
 * @author andressaldana
 */
public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscuelitaPU");
        EntityManager em = emf.createEntityManager();
        Carrera c = new Carrera();
        //c.setNombreCarrera("Mecatronica");
        //c.setDescripcionCarrera("carrera acerca de robots");
        //em.getTransaction().begin();
        //em.persist(c);//inserta
        //em.merge(c);//actualiza

        //em.getTransaction().commit();

        //buscando
        //c.setIdCarrera(3);
        //System.out.println(em.find(c.getClass(), c.getIdCarrera()).toString());

        //borrando
        //c.setIdCarrera(3);
        //c = em.find(c.getClass(), c.getIdCarrera());
        //em.getTransaction().begin();
        //em.remove(c);
        //em.getTransaction().commit();

        //select *
        //em.getTransaction().begin();
        //Query q = em.createQuery("select c from Carrera c");
        //System.out.println(q.getResultList());
        //em.getTransaction().commit();
       
        //em.getTransaction().begin();
        //TypedQuery<Carrera> tq = em.createNamedQuery("Carrera.findAll",Carrera.class);
        //System.out.println(tq.getResultList().toString());
        //em.getTransaction().commit();
    }
}
