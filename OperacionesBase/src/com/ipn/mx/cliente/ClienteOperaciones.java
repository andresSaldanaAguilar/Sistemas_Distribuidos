/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.cliente;

import com.ipn.mx.rmi.Operaciones;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andressaldana
 */
public class ClienteOperaciones {
    public static void main(String[] args) {
        try {
            Operaciones ope = (Operaciones)Naming.lookup("rmi://localhost/operaciones");
            double x= 990.0,y = 10.0;
            System.out.println(ope.suma(x, y));
            System.out.println(ope.resta(x, y));
            System.out.println(ope.multiplicar(x, y));
            System.out.println(ope.division(x, y));
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
