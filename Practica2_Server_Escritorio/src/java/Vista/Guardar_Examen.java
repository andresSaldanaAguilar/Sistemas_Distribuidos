/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.ExamenInt;
import Interfaces.MateriasInt;
import Interfaces.PreguntasInt;
import Modelo.Examen;
import Modelo.Materias;
import Modelo.Preguntas;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Guardar_Examen extends HttpServlet {

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
            HttpSession session = request.getSession();
            String idExamen = (String) session.getAttribute("idExamen");
            String fecha = request.getParameter("fecha");
            String idMateria = request.getParameter("idMateria");
            String fechaM = request.getParameter("fechaM");
            String idMateriaM = request.getParameter("idMateriaM");
            try {
                if (fecha != null && idMateria != null) {
                    int id = Integer.parseInt(idMateria);
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
                    DefaultListModel dl = examenController.selectallExamen();
                    Examen e = (Examen) dl.get(dl.size() - 1);
                    Materias m = materiasController.selectoneMaterias(id);
                    if (m != null) {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                        Examen examen = new Examen(e.getIdExamen() + 1, m, date);
                        examenController.insertExamen(examen);
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        response.sendRedirect("MenuPrincipal?alta=1");
                        out.println("</body>");
                        out.println("</html>");
                    } else {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        response.sendRedirect("MenuPrincipal?alta=2");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else if (fechaM != null && idMateriaM != null) {
                    int id = Integer.parseInt(idMateriaM);
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
                    Materias m = materiasController.selectoneMaterias(id);
                    if (m != null) {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaM);
                        Examen examen = new Examen(Integer.valueOf(idExamen), m, date);
                        examenController.updateExamen(examen);
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        response.sendRedirect("MenuPrincipal?modificacion=1");
                        out.println("</body>");
                        out.println("</html>");
                    } else {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        response.sendRedirect("MenuPrincipal?modificacion=2");
                        out.println("</body>");
                        out.println("</html>");
                    }
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
            } catch (ParseException ex) {
                Logger.getLogger(Guardar_Examen.class.getName()).log(Level.SEVERE, null, ex);
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
