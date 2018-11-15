/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.MateriasInt;
import Interfaces.PreguntasInt;
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

public class PreguntasController extends UnicastRemoteObject implements PreguntasInt{

    public PreguntasController() throws RemoteException {
        super();
    }
      
        
    @Override
    public void insertPreguntas(Preguntas Preguntas) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(Preguntas);
        tx.commit();
        session.close();
    }

    @Override
    public void deletePreguntas(int id) {
        Preguntas preg;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        preg = (Preguntas) session.load(Preguntas.class, id);
        session.delete(preg);
        tx.commit();
        session.close();
    }

    @Override
    public void updatePreguntas(Preguntas preguntas) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(preguntas);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallPreguntas() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Preguntas");
        List<Preguntas> list = q.list();
        Iterator<Preguntas> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Preguntas a = (Preguntas) iter.next();
            dlm.addElement(a);
        }
        return dlm;
    }

    @Override
    public Preguntas selectonePreguntas(int id) {
        Preguntas p;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        p = (Preguntas) session.get(Preguntas.class, id);
        tx.commit();
        session.close();
        return p;
    }

    public static void main(String[] args) {
        /*try {
            ExamenController c = new ExamenController();
            Preguntas preguntas = new Preguntas(1,c.selectoneExamen(1),"¿Cual es el nombre del padre de la independencia?");
            insertPreguntas(preguntas);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Preguntas a = (Preguntas)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombrePreguntas());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(PreguntasController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
