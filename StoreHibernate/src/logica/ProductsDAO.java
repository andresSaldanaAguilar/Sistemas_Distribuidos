package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Products;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductsDAO{

    public static boolean insert(String ProductName, String QuantityPerUnit, double UnitPerPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, int Discontinued, int supplierID, int categoryID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Products product = new Products(categoryID,supplierID,ProductName,QuantityPerUnit,UnitPerPrice,UnitsInStock,UnitsOnOrder,ReorderLevel,Discontinued);
        session.save(product);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Products product = (Products) session.get(Products.class,id);
        session.delete(product);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id, String ProductName, String QuantityPerUnit, double UnitPerPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, int Discontinued, int supplierID, int categoryID){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Products product = (Products) session.get(Products.class,id);
        product.setCategories(categoryID);
        product.setSuppliers(supplierID);
        product.setProductName(ProductName);
        product.setQuantityPerUnity(QuantityPerUnit);
        product.setUnitPrice(UnitPerPrice);
        product.setUnitsOnOrder(UnitsOnOrder);
        product.setReorderLevel(ReorderLevel);
        product.setDiscontinued(Discontinued);
        session.update(product);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Products.class);
        ArrayList<Products> Articulo = (ArrayList<Products>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Products product = (Products) itr.next();
                aux+=product.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Products product = (Products) session.get(Products.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return product.toString()+"_";
    }
 
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
