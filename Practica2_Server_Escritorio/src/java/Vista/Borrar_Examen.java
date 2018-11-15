/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.ExamenInt;
import Interfaces.MateriasInt;
import Modelo.Examen;
import Modelo.Materias;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sam-y
 */
public class Borrar_Examen extends HttpServlet {

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
            String idExamen = request.getParameter("idExamen");
            int id = Integer.valueOf(idExamen);
            try {
                ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
                Examen m = examenController.selectoneExamen(id);
                if (m != null) {
                    examenController.deleteExamen(id);
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    //estilos
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
                    out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">");
                    out.println("<style>* {font-family: 'Roboto', sans-serif;}</style>");
                    //fin estilos
                    out.println("</head>");
                    out.println("<body>");
                    //formato
                    out.println("<div style=\"padding:2%;background:#1ABC9C\">");
                    out.println("<div class=\"container\" style=\"padding:2%;margin-top:4%;margin-bottom:4%;\">");
                    //fin formato
                    response.sendRedirect("MenuPrincipal?baja=1");
                    out.println("</body>");
                    out.println("</html>");
                }else{out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    response.sendRedirect("Alta_Examen?cambio=24&mensaje1=ID&mensaje2=incorrecto");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (NotBoundException | MalformedURLException | RemoteException | SecurityException ex) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                response.sendRedirect("MenuPrincipal?altaomod=0");
                out.println("</body>");
                out.println("</html>");
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
