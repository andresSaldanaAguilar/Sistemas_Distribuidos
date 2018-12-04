package logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import modelos.Suppliers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SuppliersDAO{

    public static boolean insert(String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax, String HomePage){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Suppliers supplier = new Suppliers(CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax,HomePage);
        session.save(supplier);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Suppliers supplier = (Suppliers) session.get(Suppliers.class,id);
        session.delete(supplier);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id,String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax, String HomePage){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Suppliers supplier = (Suppliers) session.get(Suppliers.class,id);
        supplier.setCompanyName(CompanyName);
        supplier.setContactName(ContactName);
        supplier.setContactTitle(ContactTitle);
        supplier.setAddress(Address);
        supplier.setCity(City);
        supplier.setRegion(Region);
        supplier.setPostalCode(PostalCode);
        supplier.setCountry(Country);
        supplier.setPhone(Phone);
        supplier.setHomePage(HomePage);
        session.update(supplier);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Suppliers.class);
        ArrayList<Suppliers> Articulo = (ArrayList<Suppliers>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Suppliers supplier = (Suppliers) itr.next();
                aux+=supplier.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Suppliers supplier = (Suppliers) session.get(Suppliers.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return supplier.toString()+"_";
    }

}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
