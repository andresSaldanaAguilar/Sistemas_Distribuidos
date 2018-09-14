/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.logica;

import com.ipn.mx.entidades.Alumnos;
import com.ipn.mx.entidades.Carrera;
import com.ipn.mx.entidades.Escuela;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author andressaldana
 */
public class AccionesImpl extends UnicastRemoteObject implements Acciones{
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public AccionesImpl() throws RemoteException
    {
        super();
        emf = Persistence.createEntityManagerFactory("AlumnoCarreraPU");
        em = emf.createEntityManager();
    }
    
        
    @Override
    public List<Escuela> Escuelas() throws RemoteException {
        TypedQuery<Escuela> consulta = em.createNamedQuery("Escuela.findAll",Escuela.class);
        List <Escuela> lista = consulta.getResultList();
        if(lista.isEmpty()){
            System.out.println("No hay registros de escuelas");   
        }
        return lista;  
    }

    @Override
    public List<Carrera> Carreras() throws RemoteException {
        TypedQuery<Carrera> consulta = em.createNamedQuery("Carrera.findAll",Carrera.class);
        List <Carrera> lista = consulta.getResultList();
        if(lista.isEmpty()){
            System.out.println("No hay registros de carreras");   
        }
        return lista; 
    }

    @Override
    public List<Alumnos> AlumnosXCarreras() throws RemoteException {
        List<Alumnos> lista = em.createQuery("SELECT e from Alumnos e ORDER BY e.idCarrera").getResultList();
        if(lista.isEmpty()){
            System.out.println("No hay registros de alumnos");   
        }
        return lista;
    }
    
    @Override
    public void generaReporte() throws RemoteException {
        String inPath = "/Users/andressaldana/Documents/Github/Sistemas_Distribuidos/AlumnoCarrera/src/com/ipn/mx/reportes/report1.jasper";
         String outPath = "/Users/andressaldana/Documents/Github/Sistemas_Distribuidos/AlumnoCarrera/src/com/ipn/mx/reportes/report1.pdf";
         try{
             JasperPrint  print =  JasperFillManager.fillReport(inPath,null,Conexion.conectar());
             JRExporter  exporter= new JRPdfExporter();
             exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outPath);
             exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
             exporter.exportReport();
             System.out.println("File Created: "+ outPath);

             JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
             "/Users/andressaldana/Documents/Github/Sistemas_Distribuidos/AlumnoCarrera/src/com/ipn/mx/reportes/report1.jasper", null,
             Conexion.conectar());
             JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
             jasperViewer.setVisible(true);

         }catch(JRException e){
             e.printStackTrace();
         }
    }
    
}
