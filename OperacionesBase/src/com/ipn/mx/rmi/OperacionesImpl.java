/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author andressaldana
 */
public class OperacionesImpl extends UnicastRemoteObject implements Operaciones{
    
    public OperacionesImpl() throws RemoteException{
        super();
    }

    @Override
    public double suma(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public double resta(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public double division(double x, double y) throws RemoteException {
        return x / y;
    }

    @Override
    public double multiplicar(double x, double y) throws RemoteException {
        
        return x * y;
    }
    
}
