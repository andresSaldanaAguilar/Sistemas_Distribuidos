/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
import java.util.ArrayList;
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

    public boolean insert(ArrayList<String> a){
        Boolean aux = false;
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Client: Insert");
            String out = "";
            for(int i = 0; i < a.size(); i++){
                if(i == 0){
                    out+=a.get(0);
                }
                else{
                    out+=";"+a.get(i);   
                }
            }
            System.out.println(out);
            salida.println(out);
            salida.flush();
            aux = Boolean.parseBoolean(br.readLine());
            System.out.println( "Success: "+ aux );
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
    
    public boolean delete(ArrayList<String> a){
        Boolean aux = false;
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Client: Delete");
            String out = "";
            for(int i = 0; i < a.size(); i++){
                if(i == 0){
                    out+=a.get(0);
                }
                else{
                    out+=";"+a.get(i);   
                }
            }
            salida.println(out);
            salida.flush();
            aux = Boolean.parseBoolean(br.readLine());
            System.out.println( "Success: "+ aux );
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
    
    public boolean update(ArrayList<String> a){
        Boolean aux = false;
        Socket socket = null;
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Client: Update");
            String out = "";
            for(int i = 0; i < a.size(); i++){
                if(i == 0){
                    out+=a.get(0);
                }
                else{
                    out+=";"+a.get(i);   
                }
            }
            salida.println(out);
            salida.flush();
            aux = Boolean.parseBoolean(br.readLine());
            System.out.println( "Success: "+ aux );
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
    
    public ArrayList<String[]> listAll(int number){
        String aux = "";
        Socket socket = null;
        ArrayList<String[]> set = new ArrayList<String[]>();
        try{
            socket = new Socket(servidor, Servidor.PUERTO);
            //salida de datos
            PrintStream salida= new PrintStream(socket.getOutputStream());
            //entrada de datos
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );

            System.out.println("Client: SelectAll");
            String out = number+";";
            salida.println(out);
            salida.flush();
            aux = br.readLine();
            salida.close();
            br.close();   
            String[] arr = aux.split("_");
            for(String item:arr){             
                set.add(item.split(";"));
            }  
            
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
        return set;
    }    
    
    
    public static void main(String[] args) {
        Cliente c = new Cliente();
        ArrayList<String> a = new ArrayList<String>();
        /*a.add("name");
        a.add("desc");
        a.add("pic");
        c.insert(a);*/
        
        /*a.add("2");
        a.add("newname");
        a.add("newdesc");
        a.add("newpic");
        c.update(a);*/
        
        /*a.add("3");
        c.delete(a);*/
        
        /*ArrayList<String[]> b = c.listAll();
        for(String[] item: b){
            for(String subitem: item){
                System.out.println(subitem);
            }
        }*/
    }
}
