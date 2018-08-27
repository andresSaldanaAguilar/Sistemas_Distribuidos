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
    public static void main( String[] args ) {
    String servidor = "localhost";
    Socket socket = null;
    Scanner sc = new Scanner(System.in);
    Scanner scstring = new Scanner(System.in);
    String [] stringArray;
    
    int opcion;

    try{
        socket = new Socket(servidor, Servidor.PUERTO);
        System.out.println("Elige una opcion:\n\t1.Insertar producto."
                + "\n\t2.Actualizar producto.\n\t3.Borrar producto."
                + "\n\t4.Listar productos dada una categoria.\n\t5.Listar productos."
                + "\n\t6.Insertar categoria.\n\t7.Actualizar categoria."
                + "\n\t8.Borrar categoria.\n\t9.Listar categorias."
                + "\n\t10.Consultar producto.\n\t11.Consultar categoria.");
        
        opcion = sc.nextInt();
        String aux = "";
        //salida de datos
        PrintStream salida= new PrintStream(socket.getOutputStream());
        //entrada de datos
        BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
        switch(opcion){
            //insertar producto
            case 1:
                System.out.println("Ingresa nombre,precio y categoria separados con un punto y coma entre si");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //actualizar producto
            case 2:
                System.out.println("Ingresa id del Producto,nombre,precio y categoria separados con un punto y coma entre si");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //borrar producto
            case 3:
                System.out.println("Ingresa el id del producto a eliminar");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //listar productos por categoria
            case 4:
                System.out.println("Ingresa el id de la categoria para filtrar productos");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "registros: ");
                stringArray = br.readLine().split("_");
                for( int i = 0; i < stringArray.length ; i++ ){
                    System.out.println("\t"+stringArray[i]);
                }
                salida.close();
                br.close();
                break;
            //listar productos
            case 5:
                aux = opcion+";";
                salida.println(aux);
                salida.flush();
                System.out.println( "registros: ");
                stringArray = br.readLine().split("_");
                for( int i = 0; i < stringArray.length ; i++ ){
                    System.out.println("\t"+stringArray[i]);
                }
                salida.close();
                br.close();
                break;
            //insertar categoria
            case 6:
                System.out.println("Ingresa nombre y descripcion separados con un punto y coma entre si");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //actualizar categoria
            case 7:
                System.out.println("Ingresa id de la Categoria, nombre y descripcion separados con un punto y coma entre si");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //borrar categoria
            case 8:
                System.out.println("Ingresa el id de la categoria a eliminar");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                System.out.println( "operacion exitosa: "+br.readLine() );
                salida.close();
                br.close();
                break;
            //listar categorias
            case 9:
                aux = opcion+";";
                salida.println(aux);
                salida.flush();
                System.out.println( "registros: ");
                stringArray = br.readLine().split("_");
                for( int i = 0; i < stringArray.length ; i++ ){
                    System.out.println("\t"+stringArray[i]);
                }
                salida.close();
                br.close();
                break;             
            //buscar producto por id
            case 10:
                System.out.println("Ingresa el id del producto a consultar");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                //impresion
                System.out.println( "registros: ");
                stringArray = br.readLine().split("_");
                for( int i = 0; i < stringArray.length ; i++ ){
                    System.out.println("\t"+stringArray[i]);
                }
                salida.close();
                br.close();
                break;    
            //buscar producto por id
            case 11:
                System.out.println("Ingresa el id de la categoria a consultar");
                aux = opcion+";"+scstring.nextLine();
                salida.println(aux);
                salida.flush();
                //impresion
                System.out.println( "registros: ");
                stringArray = br.readLine().split("_");
                for( int i = 0; i < stringArray.length ; i++ ){
                    System.out.println("\t"+stringArray[i]);
                }
                salida.close();
                br.close();
                break;
            default:
                break;
        }//switch
        
    }catch(IOException e){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.printStackTrace();
    }

    }
}
