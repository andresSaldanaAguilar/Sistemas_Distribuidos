/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author andressaldana
 */
public interface Operaciones extends Remote{
    public double suma(double x, double y) throws RemoteException;
    public double resta(double x, double y) throws RemoteException;
    public double division(double x, double y) throws RemoteException;
    public double multiplicar(double x, double y) throws RemoteException;
}
