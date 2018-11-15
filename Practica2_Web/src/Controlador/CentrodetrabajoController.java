
package Controlador;

import Interfaces.CarreraInt;
import Interfaces.CentrodetrabajoInt;
import Modelo.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;
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


public class CentrodetrabajoController extends UnicastRemoteObject implements CentrodetrabajoInt{

    public CentrodetrabajoController() throws RemoteException {
        super();
    }
    

    @Override
    public void insertCentrodetrabajo(Centrodetrabajo centrodetrabajo) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(centrodetrabajo);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteCentrodetrabajo(int id) {
        Centrodetrabajo ct;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        ct = (Centrodetrabajo) session.load(Centrodetrabajo.class, id);
        session.delete(ct);
        tx.commit();
        session.close();
    }

    @Override
    public void updateCentrodetrabajo(Centrodetrabajo centrodetrabajo) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(centrodetrabajo);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallCentrodetrabajo() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Centrodetrabajo");
        List<Centrodetrabajo> list = q.list();
        Iterator<Centrodetrabajo> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Centrodetrabajo cent = (Centrodetrabajo) iter.next();
            dlm.addElement(cent);
        }
        return dlm;
    }

    @Override
    public Centrodetrabajo selectoneCentrodetrabajo(int id) {
        Centrodetrabajo ct;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        ct = (Centrodetrabajo) session.get(Centrodetrabajo.class, id);
        tx.commit();
        session.close();
        return ct;
    }

    public static void main(String[] args) {
        /*
            DefaultListModel dl;
            dl = selectallCentrodetrabajo();
            for (int i = 0; i < dl.size(); i++) {
            Centrodetrabajo a = (Centrodetrabajo)dl.get(i); //ASI SE RECIBE UNA LISTA
            System.out.println(a.getNombreCentroDeTrabajo());
            }*/
        
    }

}
