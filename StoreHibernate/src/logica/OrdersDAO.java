package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdersDAO{
    
    public static boolean insert(String OrderDate, String RequiredDate, String ShippedDate, int ShipVia, double Freight, String Name, String Address, String City, String Region, String PostalCode, String Country, int EmployeeID, int CustomerID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Orders order = new Orders(new Integer(CustomerID),new Integer(EmployeeID),OrderDate,RequiredDate,ShippedDate,new Integer(ShipVia),new Double(Freight),Name,Address,City,Region,PostalCode,Country);
        session.save(order);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Orders order = (Orders) session.get(Orders.class,id);
        session.delete(order);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id, String OrderDate, String RequiredDate, String ShippedDate, int ShipVia, double Freight, String Name, String Address, String City, String Region, String PostalCode, String Country, int EmployeeID, int CustomerID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Orders order = (Orders) session.get(Orders.class,id);
        order.setCustomers(CustomerID);
        order.setEmployees(EmployeeID);
        order.setOrderDate(OrderDate);
        order.setRequiredDate(RequiredDate);
        order.setShippedDate(ShippedDate);
        order.setShipVia(ShipVia);
        order.setFreight(Freight);
        order.setShipName(Name);
        order.setShipAddress(Address);
        order.setShipCity(City);
        order.setShipRegion(Region);
        order.setShipPostalCode(PostalCode);
        order.setShipCountry(Country);
        session.update(order);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Orders.class);
        ArrayList<Orders> Articulo = (ArrayList<Orders>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Orders order = (Orders) itr.next();
                aux+=order.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Orders order = (Orders) session.get(Orders.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return order.toString()+"_";
    }    
    
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
