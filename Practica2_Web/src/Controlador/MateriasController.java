/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.ExamenInt;
import Interfaces.MateriasInt;
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

public class MateriasController extends UnicastRemoteObject implements MateriasInt{

    public MateriasController() throws RemoteException {
        super();
    }
      
    @Override
    public void insertMaterias(Materias materias) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(materias);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteMaterias(int id) {
        Materias mat;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        mat = (Materias) session.load(Materias.class, id);
        session.delete(mat);
        tx.commit();
        session.close();
    }

    @Override
    public void updateMaterias(Materias materias) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(materias);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallMaterias() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Materias");
        List<Materias> list = q.list();
        Iterator<Materias> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Materias m = (Materias) iter.next();
            dlm.addElement(m);
        }
        return dlm;
    }

    @Override
    public Materias selectoneMaterias(int id) {
        Materias m;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        m = (Materias) session.get(Materias.class, id);
        tx.commit();
        session.close();
        return m;
    }

    public static void main(String[] args) {
        /*try {
            
            Materias materias = new Materias(1,"Sistemas Distribuidos", 4);
            insertMaterias(materias);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Materias a = (Materias)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombreMaterias());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(MateriasController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
