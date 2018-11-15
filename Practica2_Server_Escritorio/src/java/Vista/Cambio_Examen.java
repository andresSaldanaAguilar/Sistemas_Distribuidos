/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.ExamenInt;
import Interfaces.PreguntasInt;
import Modelo.Examen;
import Modelo.Preguntas;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sam-y
 */
public class Cambio_Examen extends HttpServlet {

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
            throws ServletException, IOException, NotBoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String ids = request.getParameter("idExamen");
            HttpSession session = request.getSession();
            session.setAttribute("idExamen", ids);
            int id = Integer.parseInt(ids);
            ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
            Examen e = examenController.selectoneExamen(id);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //estilos
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">");
            out.println("<style>* {font-family: 'Roboto', sans-serif;}</style>");
            //fin estilos            
            out.println("<title>Servlet Cambio_Respuesta</title>");            
            out.println("</head>");
            //formato
            out.println("<div style=\"padding:2%;background:#1ABC9C\">");
            out.println("<div class=\"container\" style=\"padding:2%;margin-top:4%;margin-bottom:4%;\">");
            //fin formato            
            out.println("<body>");
            if (e != null) {
                out.println("<form action='Guardar_Examen' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Cambio Examen</h1><br />");
                out.println("<label style=\"color:white\"color:white>Dia del examen:</label> <input class=\"form-control w-25 p-2\" id='datefield' type='date' name='fechaM' value='"+e.getFecha()+"' required/><br /><br />");
                out.println("<label style=\"color:white\"color:white>idMateria:</label> <input class=\"form-control w-25 p-2\" type='text' name='idMateriaM' pattern=\"[0-9]+\" value='"+e.getMaterias().getIdMaterias()+"' required/><br /><br />");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("</center>");
                out.println("</form>");
            } else {
                response.sendRedirect("Alta_Examen?cambio=34&mensaje1=ID&mensaje2=incorrecto");
                out.println("</body>");
                out.println("</html>");
            }
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
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cambio_Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cambio_Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
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
