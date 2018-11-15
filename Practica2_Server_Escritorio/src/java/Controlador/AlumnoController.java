/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.AlumnoInt;
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

public class AlumnoController extends UnicastRemoteObject implements AlumnoInt {

    public AlumnoController() throws RemoteException {
        super();
    }

    @Override
    public void insertAlumno(Alumno alumno) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alumno);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteAlumno(long id) {
        Alumno ct;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        ct = (Alumno) session.load(Alumno.class, id);
        session.delete(ct);
        tx.commit();
        session.close();
    }

    @Override
    public void updateAlumno(Alumno alumno) throws HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(alumno);
        tx.commit();
        session.close();
    }

    @Override
    public DefaultListModel selectallAlumno() {
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Alumno");
        List<Alumno> list = q.list();
        Iterator<Alumno> iter = list.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while (iter.hasNext()) {
            Alumno a = (Alumno) iter.next();
            dlm.addElement(a);
        }
        return dlm;
    }

    @Override
    public Alumno selectoneAlumno(long id) {
        Alumno a;
        SessionFactory sessionFac = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sessionFac.openSession();
        Transaction tx = session.beginTransaction();
        a = (Alumno) session.get(Alumno.class, id);
        tx.commit();
        session.close();
        return a;
    }

    public static void main(String[] args) {
        /*try {
            CarreraController c = new CarreraController();
            Date fecha = new Date();
            long n = 56530;
            Alumno alumno = new Alumno(1,c.selectoneCarrera(1),"Samuel","Arteaga","Lara",fecha,"Acolhuacan","Tlayehuale",15,n,"M","sam-y.barca@hotmail.com");
            //insertAlumno(alumno);
            
            /*
            DefaultListModel dl;
            dl = selectall();
            for (int i = 0; i < dl.size(); i++) {
            Alumno a = (Alumno)dl.get(i); //ASI SE RECIBE UNA LISTA .
            System.out.println(a.getNombreAlumno());
            }
        } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(AlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }
}
