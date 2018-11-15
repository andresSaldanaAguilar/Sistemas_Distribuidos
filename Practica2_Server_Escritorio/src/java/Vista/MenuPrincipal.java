package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interfaces.*;
import Modelo.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

//public es el modificador de clase
public class MenuPrincipal extends HttpServlet {

    @Override
    //protected, solo los miembros de la clase los puede ocupar 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            //objeto request obtiene informacion de la peticion del cliente
            //objeto response que encapsula pero va del servidor al cliente, al revés de request
            //throws es porque podría arrojar una excepcion, como entrada y salida de datos o ServeletException
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //le decimos al cliente cual va a ser el tipo de contenido que enviaremos
        PrintWriter out = response.getWriter(); //canal de comunicacion del servidor al cliente 
        
        out.println("<!DOCTYPE html>");//es un texto enviado por el canal de comunicacion 
        out.println("<html>");//nodo raiz, ahi comienza
        out.println("<head>");//comienza el encabezado 
        //estilos
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">");
        out.println("<style>* {font-family: 'Roboto', sans-serif;}</style>");
        //fin estilos
        out.println("<title>Servlet Servlet1</title>"); //Aqui dentro van las hojas de estilo y funcionalidad (javascript)
        out.println("</head>");//termina el encabezado
        out.println("<body>");
        out.println("<center>");
        //formato
        out.println("<div style=\"padding:2%;background:#1ABC9C\">");
        out.println("<div class=\"container\" style=\"padding:2%;margin-top:4%;margin-bottom:4%;\">");
        //fin formato
        out.println("<div>");
        out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Administracion de Escuela</h1>");//contenido que se va a desplegar dentro de la pagina web
        out.println("<form action='MenuCRUD' method='get'>");
        out.println("<input type='hidden' name='tipo' value='1'>");//altas
        out.println("<h3><input type='submit' value='ALTAS' class=\"btn btn-sm btn-outline-light w-25 p-2\"></h3>");
        out.println("</form>");
        out.println("<form action='MenuCRUD' method='get'>");
        out.println("<input type='hidden' name='tipo' value='2'>");//bajas
        out.println("<h3><input type='submit' value='BAJAS' class=\"btn btn-sm btn-outline-light w-25 p-2\"></h3>");
        out.println("</form>");
        out.println("<form action='MenuCRUD' method='get'>");
        out.println("<input type='hidden' name='tipo' value='3'>");//cambio
        out.println("<h3><input type='submit' value='CAMBIOS' class=\"btn btn-sm btn-outline-light w-25 p-2\"></h3>");
        out.println("</form>");
        out.println("<form action='MenuCRUD' method='get'>");
        out.println("<input type='hidden' name='tipo' value='4'>");//consultauno
        out.println("<h3><input type='submit' value='CONSULTA UNO' class=\"btn btn-sm btn-outline-light w-25 p-2\"></h3>");
        out.println("</form>");
        out.println("<form action='MenuCRUD' method='get'>");
        out.println("<input type='hidden' name='tipo' value='5'>");//consultatodos
        out.println("<h3><input type='submit' value='CONSULTA TODOS' class=\"btn btn-sm btn-outline-light w-25 p-2\"></h3>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");//nodo raiz, aqui termina

    }
}
