/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.MateriasInt;
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
import javax.servlet.http.HttpSession;
import javax.swing.DefaultListModel;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author sam-y
 */
public class Guarda_Materia extends HttpServlet {

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
            String nombreMateria = request.getParameter("nombreMateria");
            String creditos = request.getParameter("creditos");
            String nombreMateriaM = request.getParameter("nombreMateriaM");
            String creditosM = request.getParameter("creditosM");
            try {
                if (nombreMateria != null && creditos != null) {
                    int creditosi = Integer.parseInt(creditos);
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    DefaultListModel dl = materiasController.selectallMaterias();
                    Materias m = (Materias) dl.get(dl.size() - 1);
                    Materias materia = new Materias(m.getIdMaterias() + 1, nombreMateria, creditosi);
                    materiasController.insertMaterias(materia);
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    response.sendRedirect("MenuPrincipal?alta=1");
                    out.println("</body>");
                    out.println("</html>");
                }else if (nombreMateriaM != null && creditosM != null) {
                    HttpSession session = request.getSession();
                    String idMateria = (String)session.getAttribute("idMateria");
                    int creditosi = Integer.parseInt(creditosM);
                    int idMateriai = Integer.parseInt(idMateria);
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    Materias materia = new Materias(idMateriai, nombreMateriaM, creditosi);
                    materiasController.updateMaterias(materia);
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    response.sendRedirect("MenuPrincipal?modificacion=1");
                    out.println("</body>");
                    out.println("</html>");
                }

            } catch (NotBoundException | MalformedURLException | RemoteException | HeuristicMixedException | RollbackException | HeuristicRollbackException | SecurityException | SystemException ex) {
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
