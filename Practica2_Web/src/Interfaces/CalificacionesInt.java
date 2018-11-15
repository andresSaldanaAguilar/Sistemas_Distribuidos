/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.*;
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
public interface CalificacionesInt extends Remote{
    public void insertCalificaciones(Calificaciones calificaciones) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public void deleteCalificaciones(int id) throws RemoteException;
    public void updateCalificaciones(Calificaciones calificaciones) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public DefaultListModel selectallCalificaciones() throws RemoteException;
    public Calificaciones selectoneCalificaciones(int id) throws RemoteException;
}
