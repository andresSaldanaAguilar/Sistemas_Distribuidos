package controladores;

import Modelos.Carrera;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andressaldana
 */
public class CarreraOps {
    Session session;
    
    public Carrera create(String nombre, String descripcion){
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Carrera carrera = new Carrera(nombre,descripcion);
        session.save(carrera);
        tx.commit();
        session.close();
        return carrera;        
    }
    
    public Carrera delete(int id){            
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Carrera carrera = (Carrera) session.get(Carrera.class,id);
        session.delete(carrera);
        tx.commit();
        session.close();
        return carrera;        
    }
    
    public Carrera update(int id,String nombre, String descripcion){
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Carrera carrera = (Carrera) session.get(Carrera.class,id);
        carrera.setNombreCarrera(nombre);
        carrera.setDescripcionCarrera(descripcion);
        session.update(carrera);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return carrera;
    }    
    
    public String listAll(){
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Carrera.class);
        ArrayList<Carrera> Articulo = (ArrayList<Carrera>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Carrera carrera = (Carrera) itr.next();
                aux+=carrera.toString()+"\n";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public String listOne(int id){
        session = NewHibernateUtil.getSessionFactory().openSession();
        Carrera carrera = (Carrera) session.get(Carrera.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return carrera.toString();
    } 
}
