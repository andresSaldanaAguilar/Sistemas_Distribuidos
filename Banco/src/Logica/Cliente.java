/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andressaldana
 */
public class Cliente {
    String servidor = "localhost";
    Scanner sc = new Scanner(System.in);
    Scanner scstring = new Scanner(System.in);
    String [] stringArray;
    
    public String balance(int idCliente){
        String aux = "";
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Balance");
            salida.println("1;"+idCliente);
            salida.flush();
            aux = br.readLine();
            System.out.println( "operacion exitosa: "+aux);
            salida.close();
            br.close();    
            
        }catch(IOException e){
        try {
           socket.close();
        }catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    
    public String logIn(String contrasenia,String nombre){
        String aux = "";
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Login");
            salida.println("2;"+contrasenia+";"+nombre);
            salida.flush();
            aux = br.readLine();
            System.out.println( "operacion exitosa: "+ aux );
            salida.close();
            br.close();    
            
        }catch(IOException e){
        try {
            socket.close();
        }catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    public String depositar(String balance,int idCliente){
        String aux = "";
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Deposito");
            salida.println("3;"+balance+";"+idCliente);
            salida.flush();
            aux = br.readLine();
            System.out.println( "operacion exitosa: "+ aux );
            salida.close();
            br.close();    
            
        }catch(IOException e){
        try {
            socket.close();
        }catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    
    public String transacciones(BigInteger idCuenta){
        String aux = "";
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Transaccion");
            salida.println("4;"+idCuenta);
            salida.flush();
            aux = br.readLine();
            System.out.println( "operacion exitosa: "+ aux );
            salida.close();
            br.close();    
            
        }catch(IOException e){
        try {
            socket.close();
        }catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
}
