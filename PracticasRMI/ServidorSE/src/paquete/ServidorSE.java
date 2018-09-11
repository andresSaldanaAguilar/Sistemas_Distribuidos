
package paquete;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorSE 
{
    public static void main(String[] args) 
    {
        try 
        {
            LocateRegistry.createRegistry(1099);
            
            Operaciones ope = new OperacionesImpl();
            Naming.bind("operaciones", ope);
            System.out.println("Servidor corriendo...");
        } 
        catch (RemoteException | AlreadyBoundException |  MalformedURLException ex ) 
        {
            ex.printStackTrace();
            Logger.getLogger(ServidorSE.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}