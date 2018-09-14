/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author andressaldana
 */
public class SaludoImpl extends UnicastRemoteObject implements Saludo{

    public SaludoImpl() throws RemoteException{
        super();
    }
    
    @Override
    public String saludar(){
        return "Hello World!";
    }
    
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new RMISecurityManager());
        }
        try{
            SaludoImpl saludar = new SaludoImpl();
            Naming.rebind("ServidorSaludo", saludar);
            System.out.println("HelloServer bound in registry");
        }catch(Exception e){
            System.out.println("HelloImpl err: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    
}
