/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Controladores.NewHibernateUtil;
import Modelos.Carrera;
import Modelos.Materias;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author andressaldana
 */
public class AccionesImpl extends UnicastRemoteObject implements Acciones{
    
    Session session;
    
    public AccionesImpl() throws RemoteException
    {
        super();
    }  
        
    @Override
    public boolean InsertarMateria(String nombre, int creditos) throws RemoteException {
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{
            int ultimoId = Integer.parseInt(session.createSQLQuery("SELECT MAX(idMaterias) FROM materias;").uniqueResult().toString());
            Materias m = new Materias();
            m.setIdMaterias(ultimoId+1);
            m.setNombreMateria(nombre);
            m.setCreditos(creditos);
            session.save(m);
            tr.commit(); 
            session.close();
            System.out.println("Exito al insertar materia;");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }
    }
    
    @Override
    public boolean BorrarMateria(int id) throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{           
            Materias m = new Materias();
            m.setIdMaterias(id);
            session.delete(m);
            tr.commit();
            session.close();
            System.out.println("Exito al borrar materia;");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }        
    }
    
    @Override
    public boolean ActualizarMateria(String nombre, int creditos, int id) throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{
            Materias m = (Materias) session.get(Materias.class,id);
            m.setNombreMateria(nombre);
            m.setCreditos(creditos);
            session.update(m);
            tr.commit();
            session.close();
            System.out.println("Exito al actualizar materia;");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }
    }
      
    @Override
    public ArrayList<Materias> ListarMateria() throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{
            Criteria criteria = session.createCriteria(Materias.class);
            ArrayList<Materias> materias = (ArrayList<Materias>) criteria.list();

            Iterator itr = materias.iterator();
            while (itr.hasNext()) {
                    Materias emp = (Materias) itr.next();
                    System.out.println("id: "+emp.getIdMaterias());
                    System.out.println("nombre: "+emp.getNombreMateria());
                    System.out.println("creditos: "+emp.getCreditos());
            }
            session.close();
            System.out.println("Exito al listar materia;");
            return  materias;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return null;
        }
    }
    
    public static void main(String[] args) throws RemoteException {
        AccionesImpl ai = new AccionesImpl();
        ai.InsertarMateria("Venezolano", 30);
        ai.BorrarMateria(0);
        ai.ActualizarMateria("Argentinou", 80, 1);
        ai.ListarMateria();
    }
  

}
