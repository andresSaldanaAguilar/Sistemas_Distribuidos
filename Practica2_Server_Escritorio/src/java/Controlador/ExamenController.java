/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.CentrodetrabajoInt;
import Interfaces.ExamenInt;
import Modelo.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamenController extends UnicastRemoteObject implements ExamenInt{

    public ExamenController() throws RemoteException {
        super();
    }
        
    @Override
    public void insertExamen(Examen examen) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(examen);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteExamen(int id) {
        Examen e;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        e = (Examen) session.load(Examen.class, id);
        session.delete(e);
        tx.commit();
        session.close();
    }

    @Override
    public void updateExamen(Examen examen) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(examen);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallExamen() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Examen");
        List<Examen> list = q.list();
        Iterator<Examen> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Examen a = (Examen) iter.next();
            dlm.addElement(a);
        }
        return dlm;
    }

    @Override
    public Examen selectoneExamen(int id) {
        Examen e;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        e = (Examen) session.get(Examen.class, id);
        tx.commit();
        session.close();
        return e;
    }

    public static void main(String[] args) {
        /*try {
            MateriasController m = new MateriasController();
            Date fecha = new Date();
            Examen examen = new Examen(1,m.selectoneMaterias(1),fecha);
            insertExamen(examen);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Examen a = (Examen)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombreExamen());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(ExamenController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
