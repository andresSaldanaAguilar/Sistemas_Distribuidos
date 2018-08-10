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
public class Cliente {
    public static void main( String[] args ) {
    String servidor = "localhost";

    try {
        Socket s = new Socket( servidor, Servidor.PUERTO );

        BufferedReader br = new BufferedReader(new InputStreamReader( s.getInputStream() ) );
        System.out.println( "Hora actual en localhost:" );
        System.out.println( "\t"+br.readLine() );

        br.close();
        s.close();     
    } catch( UnknownHostException e ) {
        System.out.println( e );
    } catch( IOException e ) {
        System.out.println( e );
      }
    }
}
