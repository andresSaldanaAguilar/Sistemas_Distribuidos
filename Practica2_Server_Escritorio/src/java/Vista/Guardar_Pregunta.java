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
public class Guardar_Pregunta extends HttpServlet {

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

            HttpSession session = request.getSession();
            String idPregunta = (String) session.getAttribute("idPregunta");
            String pregunta = request.getParameter("pregunta");
            String idExamen = request.getParameter("idExamen");
            String preguntaM = request.getParameter("preguntaM");
            String idExamenM = request.getParameter("idExamenM");
            try {
                if (pregunta != null && idExamen != null) {
                    int id = Integer.parseInt(idExamen);
                    PreguntasInt preguntasController = (PreguntasInt) Naming.lookup("rmi://localhost/preguntasController");
                    ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
                    DefaultListModel dl = preguntasController.selectallPreguntas();
                    Preguntas p = (Preguntas) dl.get(dl.size() - 1);
                    Examen e = examenController.selectoneExamen(id);
                    if (e != null) {
                        Preguntas preguntas = new Preguntas(p.getIdPregunta() + 1, e, pregunta);
                        preguntasController.insertPreguntas(preguntas);
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
                }else if (preguntaM != null && idExamenM != null) {
                    int id = Integer.parseInt(idExamenM);
                    PreguntasInt preguntasController = (PreguntasInt) Naming.lookup("rmi://localhost/preguntasController");
                    ExamenInt examenController = (ExamenInt) Naming.lookup("rmi://localhost/examenController");
                    Examen e = examenController.selectoneExamen(id);
                    if (e != null) {
                        Preguntas preguntas = new Preguntas(Integer.valueOf(idPregunta), e, preguntaM);
                        preguntasController.updatePreguntas(preguntas);
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
            Logger.getLogger(Guardar_Pregunta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Guardar_Pregunta.class.getName()).log(Level.SEVERE, null, ex);
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
