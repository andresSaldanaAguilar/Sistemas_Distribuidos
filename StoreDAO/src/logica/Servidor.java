package logica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.xpath.internal.SourceTree;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Servidor{

    public static final int PUERTO = 5000;
    
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor esperando por conexion...");
            while (true) {            
                Socket clienteSocket = serverSocket.accept();
                //datos de entrada
                BufferedReader mensajeDelCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                //datos de salida
                PrintStream ps = new PrintStream(clienteSocket.getOutputStream());
                //resultado booleano de la transaccion
                boolean respuesta = false;
                
                //resultado de set de registros
                String registros = "";
              
                String [] aux = mensajeDelCliente.readLine().split(";");
                //consiguiendo la opcion
                int opcion = Integer.parseInt(aux[0]);
                switch(opcion){
                    case 1:
                        System.out.println("Server: Insert Categories");
                        respuesta = CategoriesDAO.insert(aux[1],aux[2],aux[3]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 2:
                        System.out.println("Server: Delete Categories");
                        respuesta = CategoriesDAO.delete(Integer.parseInt(aux[1]));
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 3:
                        System.out.println("Server: Update Categories");
                        respuesta = CategoriesDAO.update(Integer.parseInt(aux[1]),aux[2],aux[3],aux[4]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 4:
                        System.out.println("Server: List Categories");
                        registros = CategoriesDAO.selectAll();
                        System.out.println("Success: "+registros);
                        ps.println(registros);
                        ps.flush();
                        break;
                    case 5:
                        String rand= "cust"+aux[1].substring(0, 1);
                        System.out.println("Server: Insert Customers");
                        respuesta = CustomersDAO.insert(rand,aux[1],aux[2],aux[3],aux[4],aux[5],aux[6],aux[7],aux[8],aux[9],aux[10]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 6:
                        System.out.println("Server: Delete Customers");
                        respuesta = CustomersDAO.delete(aux[1]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 7:
                        System.out.println("Server: Update Customers");
                        respuesta = CustomersDAO.update(aux[1],aux[2],aux[3],aux[4],aux[5],aux[6],aux[7],aux[8],aux[9],aux[10],aux[11]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 8:
                        System.out.println("Server: List Customers");
                        registros = CustomersDAO.selectAll();
                        System.out.println("Success: "+registros);
                        ps.println(registros);
                        ps.flush();
                        break;
                    case 9:
                        System.out.println("Server: Insert Suppliers");
                        respuesta = SuppliersDAO.insert(aux[1],aux[2],aux[3],aux[4],aux[5],aux[6],aux[7],aux[8],aux[9],aux[10],aux[11]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 10:
                        System.out.println("Server: Delete Suppliers");
                        respuesta = SuppliersDAO.delete(Integer.parseInt(aux[1]));
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 11:
                        System.out.println("Server: Update Suppliers");
                        respuesta = SuppliersDAO.update(Integer.parseInt(aux[1]),aux[2],aux[3],aux[4],aux[5],aux[6],aux[7],aux[8],aux[9],aux[10],aux[11],aux[12]);
                        System.out.println("Success: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 12:
                        System.out.println("Server: List Suppliers");
                        registros = SuppliersDAO.selectAll();
                        System.out.println("Success: "+registros);
                        ps.println(registros);
                        ps.flush();
                        break;                        
                                        
                    default:
                        break;
                }//switch
                clienteSocket.close();
            }
        }catch(Exception e){
            //handle errors
        }
    }

}