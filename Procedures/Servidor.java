import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Servidor{
    public static void main(String[] args) {
        int port = 5000;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("texto");
            Socket clienteSocket = serverSocket.accept();
            BufferedReader mensajeDelCliente = new BufferedReader(new InputStreamReader(clienteSocket.getOutputStream()));
            PrintStream ps = new PrintStream(clienteSocket.getOutputStream());
        
        while (true) {
            int opcion = Integer.parseInt(mensajeDelCliente.readLine());
            switch(opcion){
                case 1:
                case 2:
            }//switch
        }
        }catch(Exception e){   
        }
    }
    producto p = new Producto();
    p.setNombre("nombre");
    p.setPrecio("Precio");
    p.setIdCategoria("idCategoria");
    boolean respuesta = Pro
}