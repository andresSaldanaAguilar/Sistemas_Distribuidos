/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.logica;

import Modelos.Materias;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andressaldana
 */
public interface Acciones extends Remote{

    public boolean InsertarMateria(String nombre, int creditos) throws RemoteException;
    public boolean BorrarMateria(int id) throws RemoteException;
    public boolean ActualizarMateria(String nombre, int creditos, int id) throws RemoteException;
    public ArrayList<Materias> ListarMateria() throws RemoteException;
}
