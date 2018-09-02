package Logica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.xpath.internal.SourceTree;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
                //resulta de set de registros
            
                String registros = "";
                Categoria c = null;
                String [] aux = mensajeDelCliente.readLine().split(";");
                //consiguiendo la opcion
                int opcion = Integer.parseInt(aux[0]);
                switch(opcion){
                    case 1:
                        System.out.println("Balance");
                        registros = CuentaDAO.listarCuenta(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+registros);
                        ps.println(registros);
                        ps.flush();
                        break;
                    case 2:
                        System.out.println("Login");
                        registros = ClientesDAO.loginClientes(aux[1],aux[2]);
                        System.out.println("operacion exitosa: "+registros);
                        ps.println(registros);
                        ps.flush();
                        break;
                    case 3:
                        System.out.println("Deposito/Retiro");
                        respuesta = CuentaDAO.actualizarCuenta(Double.parseDouble(aux[3]),Integer.parseInt(aux[4]));
                        operacionCuenta opCuenta = new operacionCuenta();
                        opCuenta.setTipo(aux[2]);
                        opCuenta.setCantidad(Double.parseDouble(aux[1]));
                        opCuenta.setIdCuenta(new BigInteger(aux[4]));
                        respuesta = respuesta && operacionesCuentaDAO.insertarOperacion(opCuenta);
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        ps.flush();
                        break;
                    case 4:
                        System.out.println("Transacciones");
                        registros = operacionesCuentaDAO.selectOperacionesCuenta(aux[1]);
                        System.out.println("operacion exitosa: "+registros);
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