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
public interface PreguntasInt extends Remote{
    public void insertPreguntas(Preguntas preguntas) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public void deletePreguntas(int id) throws RemoteException;
    public void updatePreguntas(Preguntas preguntas) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public DefaultListModel selectallPreguntas() throws RemoteException;
    public Preguntas selectonePreguntas(int id) throws RemoteException;
}
