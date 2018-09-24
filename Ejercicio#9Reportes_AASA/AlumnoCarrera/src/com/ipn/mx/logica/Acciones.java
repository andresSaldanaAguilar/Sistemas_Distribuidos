/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.logica;

import com.ipn.mx.entidades.Alumnos;
import com.ipn.mx.entidades.Carrera;
import com.ipn.mx.entidades.Escuela;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author andressaldana
 */
public interface Acciones extends Remote{
    public List<Escuela> Escuelas() throws RemoteException;
    public List<Carrera> Carreras() throws RemoteException;
    public List<Alumnos> AlumnosXCarreras() throws RemoteException;
    public void generaReporte() throws RemoteException;
    public boolean InsertarCarrera(String nombre) throws RemoteException;
    public boolean BorrarCarrera(int id) throws RemoteException;
    public boolean ActualizarCarrera(int id ,String nombre) throws RemoteException;
}
