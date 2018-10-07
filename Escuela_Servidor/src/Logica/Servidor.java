/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 * @author andressaldana
 */

import Controladores.NewHibernateUtil;
import Modelos.Materias;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Servidor implements  Acciones{
    
    Session session;
    
   public Servidor(){}
        
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
    
    public static void main(String[] args) {
    
        
            try {
		 java.rmi.registry.LocateRegistry.createRegistry(1099); //puerto default del rmiregistry
		 System.out.println("RMI registry ready.");
            } catch (Exception e) {
		 System.out.println("Exception starting RMI registry:");
		 e.printStackTrace();
            }//catch
	
            try {
                System.setProperty("java.rmi.server.codebase","http://8.25.100.18/clases/"); 
                System.setProperty("java.security.policy","permisos.policy");
                Servidor acciones = new Servidor();
                Acciones stub = (Acciones) UnicastRemoteObject.exportObject(acciones, 0);
                
                // Bind the remote object's stub in the registry
                Registry registry = LocateRegistry.getRegistry();
                registry.bind("acciones", stub);
                

                System.err.println("Servidor listo...");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
            }
    }
}