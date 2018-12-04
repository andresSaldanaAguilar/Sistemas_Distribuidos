package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Orderdetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDetailsDAO{

    
    public static boolean insert(double UnitPrice,int Quantity,double Discount, int OrderID, int ProductID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Orderdetails orderdetail = new Orderdetails(OrderID,ProductID,UnitPrice,Quantity,Discount);
        session.save(orderdetail);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Orderdetails orderdetail = (Orderdetails) session.get(Orderdetails.class,id);
        session.delete(orderdetail);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id, double UnitPrice,int Quantity,double Discount, int OrderID, int ProductID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Orderdetails orderdetail = (Orderdetails) session.get(Orderdetails.class,id);
        orderdetail.setOrders(OrderID);
        orderdetail.setProducts(ProductID);
        orderdetail.setUnitPrice(UnitPrice);
        orderdetail.setQuantity(Quantity);
        orderdetail.setDiscount(Discount);
        session.update(orderdetail);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Orderdetails.class);
        ArrayList<Orderdetails> Articulo = (ArrayList<Orderdetails>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Orderdetails orderdetail = (Orderdetails) itr.next();
                aux+=orderdetail.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Orderdetails orderdetail = (Orderdetails) session.get(Orderdetails.class,id);
        session.close();
        System.out.println("Exito al consultar;");
        return orderdetail.toString()+"_";
    }        

}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
