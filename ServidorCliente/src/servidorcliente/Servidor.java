/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andressaldana
 */
public class Servidor extends Thread{
    public static final int PUERTO = 6666;
    ServerSocket socketServidor;
    public Servidor(){
        try{
            socketServidor = new ServerSocket(PUERTO);
            System.out.println("Esperando por conexion de cliente...");
        }catch(IOException e){
            e.printStackTrace();
        }
        start();
    }
    
    public void run(){
        try{
            while(true){
                Socket socketCliente = socketServidor.accept();
                SQLConexion miConexion = new SQLConexion(socketCliente);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Servidor();
    }
}
