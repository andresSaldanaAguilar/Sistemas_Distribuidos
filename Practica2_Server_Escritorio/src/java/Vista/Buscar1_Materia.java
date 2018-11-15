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

/**
 *
 * @author sam-y
 */
public class Buscar1_Materia extends HttpServlet {

    String[][] datos;
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
            Integer tipo_select = (Integer) session.getAttribute("select");

            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                //estilos
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
                out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">");
                out.println("<style>* {font-family: 'Roboto', sans-serif;} table, th, td {border: 1px solid white;color:white;}</style>");
                //fin estilos
                out.println("</head>");
                out.println("<body>");
                //formato
                out.println("<div style=\"padding:2%;background:#1ABC9C\">");
                out.println("<div class=\"container\" style=\"padding:2%;margin-top:4%;margin-bottom:4%;\">");
                //fin formato                
                out.println("<center>");
                out.println("<h1 class=\"text-light\" style=\"font-size:300%\">Listado de cursos</h1>");

                if (tipo_select == 0) {
                    String idMateria = request.getParameter("idMateria");
                    int id = Integer.valueOf(idMateria);
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    Materias m = materiasController.selectoneMaterias(id);
                    if (m != null) {
                        out.println("<table border=1>");
                        out.println("<col width=\"40\">");
                        out.println("<col width=\"330\">");
                        out.println("<col width=\"40\">");
                        out.println("<tr>");
                        out.println("<td><center><strong>Id de Materia</strong></center></td>");
                        out.println("<td><center><strong>Nombre</strong></center></td>");
                        out.println("<td><center><strong>Creditos</strong></center></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td><center>    " + m.getIdMaterias() + "    </center></td>");
                        out.println("<td><center>    " + m.getNombreMateria() + "    </center></td>");
                        out.println("<td><center>    " + m.getCreditos() + "    </center></td>");
                        String[][] datos2 = new String[2][3];
                        datos2[0][0] = "Id";
                        datos2[0][1] = "Nombre de Materia";
                        datos2[0][2] = "Creditos";
                        datos2[1][0] = String.valueOf(m.getIdMaterias());
                        datos2[1][1] = String.valueOf(m.getNombreMateria());
                        datos2[1][2] = String.valueOf(m.getCreditos());
                        datos = datos2;
                        session.setAttribute("datos",datos);
                        out.println("</tr>");
                        out.println("<table>");
                    } else {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        response.sendRedirect("Alta_Materias?cambio=41&mensaje1=ID&mensaje2=incorrecto");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else if (tipo_select == 1) {
                    MateriasInt materiasController = (MateriasInt) Naming.lookup("rmi://localhost/materiasController");
                    DefaultListModel dl;
                    dl = materiasController.selectallMaterias();

                    if (dl.size() > 0) {
                        out.println("<table border=1>");
                        out.println("<col width=\"40\">");
                        out.println("<col width=\"330\">");
                        out.println("<col width=\"40\">");
                        out.println("<tr>");
                        out.println("<td><strong>Id de Materia</strong></td>");
                        out.println("<td><strong>Nombre</strong></td>");
                        out.println("<td><strong>Creditos</strong></td>");
                        out.println("</tr>");
                        String[][] datos2 = new String[dl.size()+1][3];
                        datos2[0][0] = "Id";
                        datos2[0][1] = "Nombre de Materia";
                        datos2[0][2] = "Creditos";
                        for (int i = 0; i < dl.size(); i++) {
                            Materias a = (Materias) dl.get(i); //ASI SE RECIBE UNA LISTA
                            out.println("<tr>");
                            out.println("<td><center>    " + a.getIdMaterias() + "    </center></td>");
                            out.println("<td><center>    " + a.getNombreMateria() + "    </center></td>");
                            out.println("<td><center>    " + a.getCreditos() + "    </center></td>");
                            datos2[i+1][0] = String.valueOf(a.getIdMaterias());
                            datos2[i+1][1] = String.valueOf(a.getNombreMateria());
                            datos2[i+1][2] = String.valueOf(a.getCreditos());
                            out.println("</tr>");
                        }
                        datos = datos2;
                        session.setAttribute("datos",datos);
                        out.println("<table>");
                    } else {
                        out.println("<h1>No hay Materias</h1>");
                    }
                }
                out.println("</br>");
                out.println("</br>");
                out.println("<form action='MenuPrincipal' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<input type='hidden' name='busqueda' value='1'>");
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Aceptar'/>");
                out.println("</form>");
                out.println("</br>");
                out.println("</br>");
                out.println("<form action='Reporte_Respuesta' method='get' >");//contenido que se va a desplegar dentro de la pagina web
                out.println("<input class=\"btn btn-sm btn-outline-light w-25 p-2\" type='submit' value='Generar Reporte'/>");
                out.println("</form>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");

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
