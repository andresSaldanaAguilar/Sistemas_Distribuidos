/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.PreguntasInt;
import Interfaces.RespuestasInt;
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

public class RespuestasController extends UnicastRemoteObject implements RespuestasInt{

    public RespuestasController() throws RemoteException {
        super();
    }
      
        
    @Override
    public void insertRespuestas(Respuestas respuestas) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(respuestas);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteRespuestas(int id) {
        Respuestas res;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        res = (Respuestas) session.load(Respuestas.class, id);
        session.delete(res);
        tx.commit();
        session.close();
    }

    @Override
    public void updateRespuestas(Respuestas respuestas) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(respuestas);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallRespuestas() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Respuestas");
        List<Respuestas> list = q.list();
        Iterator<Respuestas> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Respuestas a = (Respuestas) iter.next();
            dlm.addElement(a);
        }
        return dlm;
    }

    @Override
    public Respuestas selectoneRespuestas(int id) {
        Respuestas r;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        r = (Respuestas) session.get(Respuestas.class, id);
        tx.commit();
        session.close();
        return r;
    }

    public static void main(String[] args) {
        /*try {
            PreguntasController p = new PreguntasController();
            Respuestas Respuestas = new Respuestas(1,p.selectonePreguntas(1),"Miguel Hidalgo");
            insertRespuestas(Respuestas);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Respuestas a = (Respuestas)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombreRespuestas());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(RespuestasController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
