/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author andressaldana
 */
public class Servidor {

    public static final int PUERTO = 5000;
    
    public static String metodo_1(){
        Calendar gc = GregorianCalendar.getInstance();
        Date fecha = gc.getTime();
        DateFormat hora = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return hora.format(fecha);
    }
    
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(PUERTO);
        System.out.println("Esperando una conexión:");
        Socket socketCliente = ss.accept();
        System.out.println("Cliente conectado, sirviendo...");

        PrintWriter pw = new PrintWriter(socketCliente.getOutputStream());
        pw.println(metodo_1());
        pw.flush();
        pw.close();
        socketCliente.close();
    }
}
