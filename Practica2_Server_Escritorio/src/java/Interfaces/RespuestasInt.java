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
public interface RespuestasInt extends Remote{
    public void insertRespuestas(Respuestas Respuestas) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public void deleteRespuestas(int id) throws RemoteException;
    public void updateRespuestas(Respuestas Respuestas) throws RemoteException, HeuristicMixedException, RollbackException, HeuristicRollbackException, SecurityException, SystemException;
    public DefaultListModel selectallRespuestas() throws RemoteException;
    public Respuestas selectoneRespuestas(int id) throws RemoteException;
}
