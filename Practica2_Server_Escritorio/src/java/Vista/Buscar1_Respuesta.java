/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.RespuestasInt;
import Modelo.Respuestas;
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

public class Buscar1_Respuesta extends HttpServlet {

    String[][] datos;

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
                    String idRespuesta = request.getParameter("idRespuesta");
                    int id = Integer.valueOf(idRespuesta);
                    RespuestasInt respuestasController = (RespuestasInt) Naming.lookup("rmi://localhost/respuestasController");
                    Respuestas m = respuestasController.selectoneRespuestas(id);
                    if (m != null) {
                        out.println("<table border=1>");
                        out.println("<col width=\"40\">");
                        out.println("<col width=\"330\">");
                        out.println("<col width=\"40\">");
                        out.println("<tr>");
                        out.println("<td><center><strong>Id de Respuesta</strong></center></td>");
                        out.println("<td><center><strong>Respuesta</strong></center></td>");
                        out.println("<td><center><strong>Id de Pregunta</strong></center></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td><center>    " + m.getIdRespuesta() + "    </center></td>");
                        out.println("<td><center>    " + m.getRespuesta() + "    </center></td>");
                        out.println("<td><center>    " + m.getPreguntas().getIdPregunta() + "    </center></td>");
                        String[][] datos2 = new String[2][3];
                        datos2[0][0] = "Id";
                        datos2[0][1] = "Respuesta";
                        datos2[0][2] = "Id de Pregunta";
                        datos2[1][0] = String.valueOf(m.getIdRespuesta());
                        datos2[1][1] = String.valueOf(m.getRespuesta());
                        datos2[1][2] = String.valueOf(m.getPreguntas().getIdPregunta());
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
                        response.sendRedirect("Alta_Respuestas?cambio=42&mensaje1=ID&mensaje2=incorrecto");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else if (tipo_select == 1) {
                    RespuestasInt respuestasController = (RespuestasInt) Naming.lookup("rmi://localhost/respuestasController");
                    DefaultListModel dl;
                    dl = respuestasController.selectallRespuestas();
                    if (dl.size() > 0) {
                        out.println("<table border=1>");
                        out.println("<col width=\"40\">");
                        out.println("<col width=\"330\">");
                        out.println("<col width=\"40\">");
                        out.println("<tr>");
                        out.println("<td><center><strong>Id de Respuesta</strong></center></td>");
                        out.println("<td><center><strong>Respuesta</strong></center></td>");
                        out.println("<td><center><strong>Id de Pregunta</strong></center></td>");
                        out.println("</tr>");
                        String[][] datos2 = new String[dl.size()+1][3];
                        datos2[0][0] = "Id";
                        datos2[0][1] = "Respuesta";
                        datos2[0][2] = "Id de Pregunta";
                        for (int i = 0; i < dl.size(); i++) {
                            Respuestas a = (Respuestas) dl.get(i); //ASI SE RECIBE UNA LISTA
                            out.println("<tr>");
                            out.println("<td><center>    " + a.getIdRespuesta() + "    </center></td>");
                            out.println("<td><center>    " + a.getRespuesta() + "    </center></td>");
                            out.println("<td><center>    " + a.getPreguntas().getIdPregunta() + "    </center></td>");
                            datos2[i+1][0] = String.valueOf(a.getIdRespuesta());
                            datos2[i+1][1] = String.valueOf(a.getRespuesta());
                            datos2[i+1][2] = String.valueOf(a.getPreguntas().getIdPregunta());
                            out.println("</tr>");
                        }
                        datos = datos2;
                        session.setAttribute("datos",datos);
                        out.println("<table>");
                    } else {
                        out.println("<h1>No hay Respuestas</h1>");
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
