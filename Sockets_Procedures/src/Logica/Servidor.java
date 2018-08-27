package Logica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Servidor{

    public static final int PUERTO = 5000;
    
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor esperando por conexion...");
            Socket clienteSocket = serverSocket.accept();
            //datos de entrada
            BufferedReader mensajeDelCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            //datos de salida
            PrintStream ps = new PrintStream(clienteSocket.getOutputStream());
            //resultado booleano de la transaccion
            boolean respuesta = false;
            //resulta de set de registros
            String registros = "";
            
            while (true) {
                Producto p = null;
                Categoria c = null;
                String [] aux = mensajeDelCliente.readLine().split(";");
                //consiguiendo la opcion
                int opcion = Integer.parseInt(aux[0]);
                switch(opcion){
                    case 1:
                        System.out.println("Operacion: insertando producto");
                        p = new Producto();
                        p.setNombre(aux[1]);
                        p.setPrecio(Integer.parseInt(aux[2]));
                        p.setIdCategoria(Integer.parseInt(aux[3]));
                        respuesta = ProductoDAO.insertarProducto(p);
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 2:
                        System.out.println("Operacion: actualizando producto");
                        p = new Producto();
                        p.setIdProducto(Integer.parseInt(aux[1]));
                        p.setNombre(aux[2]);
                        p.setPrecio(Integer.parseInt(aux[3]));
                        p.setIdCategoria(Integer.parseInt(aux[4]));
                        respuesta = ProductoDAO.actualizarProducto(p);
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 3:
                        System.out.println("Operacion: borrar producto");
                        respuesta = ProductoDAO.borrarProducto(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 4:
                        System.out.println("Operacion: listar productos por categoria");
                        registros = ProductoDAO.listarProductoPorCategoria(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+"\n"+registros);
                        ps.println(registros);
                        break;
                    case 5:
                        System.out.println("Operacion: listar productos");
                        registros = ProductoDAO.listarProductos();
                        System.out.println("operacion exitosa: "+"\n"+registros);
                        ps.println(registros);
                        break;
                    case 6:
                        System.out.println("Operacion: insertando categoria");
                        c = new Categoria();
                        c.setNombre(aux[1]);
                        c.setDescripcion(aux[2]);
                        respuesta = CategoriaDAO.insertarCategoria(c);
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 7:
                        System.out.println("Operacion: insertando categoria");
                        c = new Categoria();
                        c.setIdCategoria(Integer.parseInt(aux[1]));
                        c.setNombre(aux[2]);
                        c.setDescripcion(aux[3]);
                        respuesta = CategoriaDAO.actualizarCategoria(c);
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 8:
                        System.out.println("Operacion: borrar categoria");
                        respuesta = CategoriaDAO.borrarCategoria(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+respuesta);
                        ps.println(respuesta);
                        break;
                    case 9:
                        System.out.println("Operacion: listar producto");
                        registros = CategoriaDAO.listarCategorias();
                        System.out.println("operacion exitosa: "+"\n"+registros);
                        ps.println(registros);
                        break;                          
                    case 10:
                        System.out.println("Operacion: listar producto");
                        registros = ProductoDAO.listarProducto(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+"\n"+registros);
                        ps.println(registros);
                        break;
                    case 11:
                        System.out.println("Operacion: listar producto");
                        registros = CategoriaDAO.listarCategoria(Integer.parseInt(aux[1]));
                        System.out.println("operacion exitosa: "+"\n"+registros);
                        ps.println(registros);
                        break;
                    default:
                        break;
                }//switch
            }
        }catch(Exception e){
            //handle errors
        }
    }

}