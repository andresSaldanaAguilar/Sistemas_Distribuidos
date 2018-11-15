
package Controlador;

import Interfaces.CalificacionesInt;
import Modelo.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
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

public class CalificacionesController extends UnicastRemoteObject implements CalificacionesInt{

    public CalificacionesController() throws RemoteException {
        super();
    }
    
    @Override
    public void insertCalificaciones(Calificaciones calificaciones) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(calificaciones);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteCalificaciones(int id) {
        Calificaciones c;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        c = (Calificaciones) session.load(Calificaciones.class, id);
        session.delete(c);
        tx.commit();
        session.close();
    }

    @Override
    public void updateCalificaciones(Calificaciones calificaciones) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(calificaciones);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallCalificaciones() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Calificaciones");
        List<Calificaciones> list = q.list();
        Iterator<Calificaciones> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Calificaciones c = (Calificaciones) iter.next();
            dlm.addElement(c);
        }
        return dlm;
    }


    @Override
    public Calificaciones selectoneCalificaciones(int id) {
        Calificaciones a;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        a = (Calificaciones) session.get(Calificaciones.class, id);
        tx.commit();
        session.close();
        return a;
    }

    public static void main(String[] args) {
        /*try {
            AlumnoController a = new AlumnoController();
            ExamenController e = new ExamenController();
            Double puntaje = 9.17;
            long id = 1;
            Calificaciones calificaciones = new Calificaciones(1,a.selectoneAlumno(id),e.selectoneExamen(1),puntaje);
            insertCalificaciones(calificaciones);

            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Calificaciones a = (Calificaciones)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombreCalificaciones());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(CalificacionesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }
}
