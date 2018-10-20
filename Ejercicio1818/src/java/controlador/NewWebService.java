/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Articulo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author andressaldana
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

   
    
    Session session;
    
    @WebMethod(operationName = "InsertarArticulo")
    public boolean InsertarArticulo(@WebParam(name = "claveArticulo") String claveArticulo,@WebParam(name = "descripcion") String descripcion,@WebParam(name = "precio") double precio,@WebParam(name = "existencias") int existencias) throws RemoteException {
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{
            //int ultimoId = Integer.parseInt(session.createSQLQuery("SELECT MAX(claveArticulo) FROM Articulo;").uniqueResult().toString());
            Articulo a = new Articulo();
            a.setClaveArticulo(claveArticulo);
            a.setDescripcion(descripcion);
            a.setPrecio(BigDecimal.valueOf(precio));
            a.setExistencias(existencias);
            session.save(a);
            tr.commit(); 
            session.close();
            System.out.println("Exito al insertar.");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }
    }
    
    @WebMethod(operationName = "BorrarArticulo")
    public boolean BorrarArticulo(@WebParam(name = "claveArticulo") String claveArticulo) throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{           
            Articulo a = new Articulo();
            a.setClaveArticulo(claveArticulo);
            session.delete(a);
            tr.commit();
            session.close();
            System.out.println("Exito al borrar;");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }        
    }
    
    @WebMethod(operationName = "ActualizarArticulo")
    public boolean ActualizarArticulo(@WebParam(name = "claveArticulo") String claveArticulo,@WebParam(name = "descripcion") String descripcion,@WebParam(name = "precio") Double precio,@WebParam(name = "existencias") int existencias) throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try{
            Articulo a = (Articulo) session.get(Articulo.class,claveArticulo);
            if(descripcion != null)
                a.setDescripcion(descripcion);
            if(precio != null)
                a.setPrecio(BigDecimal.valueOf(precio));
            if(existencias != -1)
                a.setExistencias(existencias);
            session.update(a);
            tr.commit();
            session.close();
            System.out.println("Exito al actualizar;");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return false;
        }
    }
     
    @WebMethod(operationName = "ListarArticulos")
    public ArrayList<Articulo> ListarArticulos() throws RemoteException{
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Articulo.class);
            ArrayList<Articulo> Articulo = (ArrayList<Articulo>) criteria.list();

            Iterator itr = Articulo.iterator();
            while (itr.hasNext()) {
                    Articulo art = (Articulo) itr.next();
                    System.out.println("clave: "+art.getClaveArticulo());
                    System.out.println("desc: "+art.getDescripcion());
                    System.out.println("existencias: "+art.getExistencias());
                    System.out.println("precio: "+art.getPrecio());
            }
            session.close();
            System.out.println("Exito al listar;");
            return  Articulo;
        }
        catch(Exception e){
            e.printStackTrace();
            session.close();
            return null;
        }
    }
    
}
