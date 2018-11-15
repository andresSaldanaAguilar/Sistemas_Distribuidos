/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sam-y
 */
public class Alta_Examen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String cambio = request.getParameter("cambio");
            String mensaje1 = request.getParameter("mensaje1");
            String mensaje2 = request.getParameter("mensaje2");
            int cambioi = Integer.parseInt(cambio);
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
            //formato
            out.println("<div style=\"padding:2%;background:#1ABC9C\">");
            out.println("<div class=\"container\" style=\"padding:2%;margin-top:4%;margin-bottom:4%;\">");
            //fin formato
            if (cambioi == 0) {
                out.println("<form action='Guardar_Examen' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Alta Examen</h1><br />");
                out.println("<label style=\"color:white\"color:white>Dia de examen:</label> <input class=\"form-control w-25 p-2\" class=\"form-control w-25 p-2\" id='datefield' type='date' name='fecha' required/><br /><br />");
                out.println("<label style=\"color:white\"color:white>Id de materia:</label> <input class=\"form-control w-25 p-2\" class=\"form-control w-25 p-2\" type='text' name='idMateria' pattern=\"[0-9]+\" required/><br /><br />");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("</center>");
                out.println("</form>");
            }else if (cambioi == 34) {  
                out.println("<form action='Cambio_Examen' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Cambio Examen</h1><br />");
                out.println("<label style=\"color:white\"color:white>Id de examen:</label> <input class=\"form-control w-25 p-2\" class=\"form-control w-25 p-2\" type='text' name='idExamen' pattern=\"[0-9]+\" required/><br /><br />");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("<br/><br/>");
                if (mensaje1!=null && mensaje2!=null) {
                    out.println("<h1>"+mensaje1+" "+mensaje2+"</h1><br />");
                }
                out.println("</center>");
                out.println("</form>");
            }else if (cambioi == 24) {  
                out.println("<form action='Borrar_Examen' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Eliminar Examen</h1><br />");
                out.println("<label style=\"color:white\"color:white>Id de examen:</label> <input class=\"form-control w-25 p-2\" type='text' name='idExamen' pattern=\"[0-9]+\" required/><br /><br />");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("<br /><br />");
                if (mensaje1!=null && mensaje2!=null) {
                    out.println("<h1>"+mensaje1+" "+mensaje2+"</h1><br />");
                }
                out.println("</center>");
                out.println("</form>");
            }else if (cambioi == 44) {  
                HttpSession session = request.getSession();
                session.setAttribute("select", 0);
                out.println("<form action='Buscar1_Examen' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Buscar Examen</h1><br />");
                out.println("<label style=\"color:white\"color:white>Id de examen:</label> <input class=\"form-control w-25 p-2\" type='text' name='idExamen' pattern=\"[0-9]+\" required/><br /><br />");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("<br /><br />");
                if (mensaje1!=null && mensaje2!=null) {
                    out.println("<h1>"+mensaje1+" "+mensaje2+"</h1><br />");
                }
                out.println("</center>");
                out.println("</form>");
            }else if (cambioi == 54) {  
                HttpSession session = request.getSession();
                session.setAttribute("select", 1);
                response.sendRedirect("Buscar1_Examen");
            }
            out.println("</body>");
            out.println("<script>var today = new Date();\n"
                    + "var dd = today.getDate();\n"
                    + "var mm = today.getMonth()+1; //January is 0!\n"
                    + "var yyyy = today.getFullYear();\n"
                    + " if(dd<10){\n"
                    + "        dd='0'+dd\n"
                    + "    } \n"
                    + "    if(mm<10){\n"
                    + "        mm='0'+mm\n"
                    + "    } \n"
                    + "\n"
                    + "today = yyyy+'-'+mm+'-'+dd;\n"
                    + "document.getElementById(\"datefield\").setAttribute(\"min\", today);</script>");
            out.println("</html>");//nodo raiz, aqui termina
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
