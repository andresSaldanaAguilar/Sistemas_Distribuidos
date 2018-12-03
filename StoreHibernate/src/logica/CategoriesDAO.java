package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Categories;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriesDAO{
    
    public static boolean insert(String CategoryName, String Description, String Picture){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Categories categories = new Categories(CategoryName,Description,Picture);
        session.save(categories);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Categories category = (Categories) session.get(Categories.class,id);
        session.delete(category);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id,String nombre, String descripcion,String picture){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Categories category = (Categories) session.get(Categories.class,id);
        category.setCategoryName(nombre);
        category.setDescription(descripcion);
        category.setPicture(picture);
        session.update(category);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Categories.class);
        ArrayList<Categories> Articulo = (ArrayList<Categories>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Categories category = (Categories) itr.next();
                aux+=category.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Categories category = (Categories) session.get(Categories.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return category.toString()+"_";
    } 
    
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
