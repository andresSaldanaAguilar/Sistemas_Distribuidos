package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Customers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomersDAO{

    public static boolean insert(String id, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customers customers = new Customers(id,CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax);
        session.save(customers);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(String id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customers customer = (Customers) session.get(Customers.class,id);
        session.delete(customer);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(String id, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Customers customer = (Customers) session.get(Customers.class,id);
        customer.setCustomerId(id);
        customer.setCompanyName(CompanyName);
        customer.setContactName(ContactName);
        customer.setContactTitle(ContactTitle);
        customer.setAddress(Address);
        customer.setCity(City);
        customer.setRegion(Region);
        customer.setPostalCode(PostalCode);
        customer.setCountry(Country);
        customer.setPhone(Phone);
        customer.setFax(Fax);
        session.update(customer);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Customers.class);
        ArrayList<Customers> Articulo = (ArrayList<Customers>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Customers customer = (Customers) itr.next();
                aux+=customer.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Customers customer = (Customers) session.get(Customers.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return customer.toString()+"_";
    } 
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
