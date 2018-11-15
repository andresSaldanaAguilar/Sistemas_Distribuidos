/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Alumno;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.DefaultListModel;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author sam-y
 */
public interface AlumnoInt extends Remote{
    public void insertAlumno(Alumno alumno) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public void deleteAlumno(long id) throws RemoteException;
    public void updateAlumno(Alumno alumno) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public DefaultListModel selectallAlumno() throws RemoteException;
    public Alumno selectoneAlumno(long id)throws RemoteException;
}
