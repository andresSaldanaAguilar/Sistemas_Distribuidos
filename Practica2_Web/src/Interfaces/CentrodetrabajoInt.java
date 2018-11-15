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
public interface CentrodetrabajoInt extends Remote{
    public void insertCentrodetrabajo(Centrodetrabajo centrodetrabajo) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public void deleteCentrodetrabajo(int id) throws RemoteException;
    public void updateCentrodetrabajo(Centrodetrabajo centrodetrabajo) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public DefaultListModel selectallCentrodetrabajo() throws RemoteException;
    public Centrodetrabajo selectoneCentrodetrabajo(int id) throws RemoteException;
}
