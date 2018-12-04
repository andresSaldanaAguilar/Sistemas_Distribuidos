package logica;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Employees;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class EmployeesDAO{

    public static boolean insert(String Password, String Privilege, String LastName, String FirstName, String Title, String TitleOfCourtesy, String BirthDate, String HireDate, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Extension, String Photo, String Notes, String ReportsTo){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employees employee = new Employees(Password, Privilege, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, Phone, Extension, Photo, Notes, ReportsTo);
        session.save(employee);
        tx.commit();
        session.close();
        System.out.println("Exito al crear;");
        return true;        
    }
    
    public static boolean delete(int id){           
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employees employee = (Employees) session.get(Employees.class,id);
        session.delete(employee);
        tx.commit();
        session.close();
        System.out.println("Exito al borrar;");
        return true;        
    }
    
    public static boolean update(int id, String Password, String Privilege, String LastName, String FirstName, String Title, String TitleOfCourtesy, String BirthDate, String HireDate, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Extension, String Photo, String Notes, String ReportsTo){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Employees employee = (Employees) session.get(Employees.class,id);
        employee.setPassword(Password);
        employee.setPrivilege(Privilege);
        employee.setLastName(LastName);
        employee.setFirstName(FirstName);
        employee.setTitle(Title);
        employee.setTitleOfCourtesy(TitleOfCourtesy);
        employee.setBirthDate(BirthDate);
        employee.setHireDate(HireDate);
        employee.setAddress(Address);
        employee.setCity(City);
        employee.setRegion(Region);
        employee.setPostalCode(PostalCode);
        employee.setCountry(Country);
        employee.setHomePhone(Phone);
        employee.setPhoneExtension(Extension);
        employee.setPhoto(Photo);
        employee.setNotes(Notes);
        employee.setReportsTo(ReportsTo);
        session.update(employee);
        tr.commit();
        session.close();
        System.out.println("Exito al actualizar;");
        return true;
    }    
    
    public static String selectAll(){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Employees.class);
        ArrayList<Employees> Articulo = (ArrayList<Employees>) criteria.list();
        String aux="";
        Iterator itr = Articulo.iterator();
        while (itr.hasNext()) {
                Employees employee = (Employees) itr.next();
                aux+=employee.toString()+"_";
        }
        session.close();
        System.out.println("Exito al listar;");
        return  aux;
    }
    
    public static String consult(int id){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Employees employee = (Employees) session.get(Employees.class,id);
        session.close();
        System.out.println("Exito al actualizar;");
        return employee.toString()+"_";
    }    
    
    public static String log_in(String birthDate,String firstName,String lastName, String password){
        Session session;
        session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Employees.class);
        Employees employee = (Employees) criteria.add(Restrictions.eq("password",password)).add(Restrictions.eq("birthDate",birthDate)).add(Restrictions.eq("firstName",firstName)).add(Restrictions.eq("lastName",lastName)).uniqueResult();
        session.close();
        System.out.println("Loggin in...");
        return employee.toString() == null ? "false" : employee.toString();
    } 

}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
