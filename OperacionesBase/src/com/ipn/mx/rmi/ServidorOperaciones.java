/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andressaldana
 */
public class ServidorOperaciones {
    public static void main(String[] args) {
        try {
            Operaciones ope;
            LocateRegistry.createRegistry(1099);
            ope = new OperacionesImpl();
            Naming.bind("operaciones", ope);
            System.out.println("Servidor Funcionando...");
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServidorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
