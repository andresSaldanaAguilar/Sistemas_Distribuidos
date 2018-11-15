/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author sam-y
 */
public class Genera_Reporte extends HttpServlet {

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
            String [][] datos = (String[][]) session.getAttribute("datos");
            String nombre = request.getParameter("nombreReporte");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Genera_Reporte</title>");
            out.println("</head>");
            out.println("<body>");
            System.out.println(datos[0][0]);
            System.out.println(datos[0][1]);
            System.out.println(datos[0][2]);
            try {
                    String ruta = "C:\\Users\\sam-y\\OneDrive\\Documentos\\7mo_Semestre\\SistemasDistribuidos\\Practica2_CHIDA_web\\" + nombre + ".xls";
                    String[][] a = datos;
                    WorkbookSettings conf = new WorkbookSettings();
                    conf.setEncoding("ISO-8859-1");
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta), conf);
                    //crear hojas
                    WritableSheet sheet = workbook.createSheet("Resultado", 0);

                    WritableFont h = new WritableFont(WritableFont.ARIAL, 16, WritableFont.NO_BOLD);
                    WritableCellFormat hformat = new WritableCellFormat(h);

                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a[i].length; j++) {
                            sheet.addCell(new jxl.write.Label(j, i, a[i][j]));
                            System.out.println("anadiendo celdas");
                        }
                    }
                    workbook.write();
                    workbook.close();               
                    response.sendRedirect("MenuPrincipal?reportegenerado=1");
            } catch (IOException ex) {
                Logger.getLogger(Genera_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        
            } catch (WriteException ex) {
                Logger.getLogger(Genera_Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</body>");
            out.println("</html>");
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
