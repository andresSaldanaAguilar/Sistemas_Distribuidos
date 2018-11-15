
package Controlador;

import Interfaces.CarreraInt;
import Modelo.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class CarreraController extends UnicastRemoteObject implements CarreraInt{

    public CarreraController() throws RemoteException {
        super();
    }
    
    @Override
    public void insertCarrera(Carrera carrera) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(carrera);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteCarrera(int id) {
        Carrera c;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        c = (Carrera) session.load(Carrera.class, id);
        session.delete(c);
        tx.commit();
        session.close();
    }

    @Override
    public void updateCarrera(Carrera Carrera) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(Carrera);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallCarrera() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Carrera");
        List<Carrera> list = q.list();
        Iterator<Carrera> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Carrera ca = (Carrera) iter.next();
            dlm.addElement(ca);
        }
        return dlm;
    }

    @Override
    public Carrera selectoneCarrera(int id) {
        Carrera c;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        c = (Carrera) session.get(Carrera.class, id);
        tx.commit();
        session.close();
        return c;
    }

    public static void main(String[] args) {
        /*try {
            CentrodetrabajoController c = new CentrodetrabajoController();
            Carrera carrera = new Carrera(1,c.selectoneCentrodetrabajo(1),"hola",10);
            //insertCarrera(carrera);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Carrera a = (Carrera)dl.get(i); //ASI SE RECIBE UNA LISTA
            System.out.println(a.getNombreCarrera());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(CarreraController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }

}
