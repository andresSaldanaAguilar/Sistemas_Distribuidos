/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Controlador.AlumnoController;
import Controlador.CalificacionesController;
import Controlador.CarreraController;
import Controlador.CentrodetrabajoController;
import Controlador.ExamenController;
import Controlador.MateriasController;
import Controlador.PreguntasController;
import Controlador.RespuestasController;
import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam-y
 */
public class Servidor {
    public static void main(String[] args) throws java.rmi.AlreadyBoundException {
        try {
            LocateRegistry.createRegistry(1099);
            AlumnoController alumnoController = new AlumnoController();
            Naming.bind("alumnoController", alumnoController);
            CalificacionesController calificacionesController = new CalificacionesController();
            Naming.bind("calificacionesController", calificacionesController);
            CarreraController CarreraController = new CarreraController();
            Naming.bind("carreraController", CarreraController);
            CentrodetrabajoController centrodetrabajoController = new CentrodetrabajoController();
            Naming.bind("centrodetrabajoController", centrodetrabajoController);
            ExamenController examenController = new ExamenController();
            Naming.bind("examenController", examenController);
            MateriasController materiasController = new MateriasController();
            Naming.bind("materiasController", materiasController);
            PreguntasController preguntasController = new PreguntasController();
            Naming.bind("preguntasController", preguntasController);
            RespuestasController respuestasController = new RespuestasController();
            Naming.bind("respuestasController", respuestasController);
            System.out.println("Servidor funcionando");
        } catch (AlreadyBoundException | MalformedURLException | RemoteException ex) { //multicatch, esto estaba reemplazado con 3 catch
            Logger.getLogger(AlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
