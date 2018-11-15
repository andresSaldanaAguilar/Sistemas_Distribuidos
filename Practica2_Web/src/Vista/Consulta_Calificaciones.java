/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.AlumnoInt;
import Interfaces.CarreraInt;
import Modelo.Alumno;
import Modelo.Calificaciones;
import Modelo.Carrera;
import Modelo.Centrodetrabajo;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author sam-y
 */
public class Consulta_Calificaciones extends javax.swing.JInternalFrame {

    String[][] datos;

    public Consulta_Calificaciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        graficar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(162, 177, 192));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "Puntaje", "Id de Examen", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabla);

        jButton5.setText("Generar Reporte");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        graficar.setText("Graficar");
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });

        jButton4.setText("Confirmar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Calificaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graficar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(graficar)
                    .addComponent(jButton5))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String stringInput = JOptionPane.showInputDialog("Ingrese un nombre para el reporte");
            if (stringInput != null && (Integer.valueOf(stringInput.charAt(0)) - 9) > 0) {
                String ruta = stringInput + ".xls";
                String[][] a = datos;
                WorkbookSettings conf = new WorkbookSettings();
                conf.setEncoding("ISO-8859-1");
                WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta), conf);
                //crear hojas
                WritableSheet sheet = workbook.createSheet("REsultado", 0);

                WritableFont h = new WritableFont(WritableFont.ARIAL, 16, WritableFont.NO_BOLD);
                WritableCellFormat hformat = new WritableCellFormat(h);

                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[i].length; j++) {
                        sheet.addCell(new jxl.write.Label(j, i, a[i][j]));
                    }
                }
                workbook.write();
                workbook.close();
                JOptionPane.showMessageDialog(null, "Reporte generado!");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre inválido");
            }

        } catch (IOException ex) {
            Logger.getLogger(Consulta_Centrodetrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(Consulta_Centrodetrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
        String[] arreglo_num = new String[datos.length-1]; //datos
        for (int i = 0; i < datos.length-1; i++) {
            arreglo_num[i] = datos[i+1][1];
            System.out.println("Este es el dato "+i+" : ."+arreglo_num[i]+".");
        }
        double[] arr = new double[arreglo_num.length];
        XYSeries series = new XYSeries("Grafica de calificaciones");
        for (int i = 0; i < arreglo_num.length; i++) {
            series.add(i, Double.valueOf(arreglo_num[i]));
            arr[i] = Double.valueOf(arreglo_num[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Calificaciones", "alumnos", "calificacion", dataset, PlotOrientation.VERTICAL, true, false, false);
        ChartFrame frame = new ChartFrame("Calificaciones", chart);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_graficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton graficar;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    void setVisible(boolean b, int i) {

    }

    void setVisible(Calificaciones c) {
        setVisible(true);
        this.Tabla.setValueAt(c.getIdCalificaciones(), 0, 0);
        this.Tabla.setValueAt(c.getPuntuaje(), 0, 1);
        this.Tabla.setValueAt(c.getExamen().getIdExamen(), 0, 2);
        this.Tabla.setValueAt(c.getAlumno().getMatricula(), 0, 3);
        String[][] datos2 = new String[2][4];
        datos2[0][0] = "Id";
        datos2[0][1] = "Puntaje";
        datos2[0][2] = "Id de Examen";
        datos2[0][3] = "Matricula";
        datos2[1][0] = String.valueOf(c.getIdCalificaciones());
        datos2[1][1] = String.valueOf(c.getPuntuaje());
        datos2[1][2] = String.valueOf(c.getExamen().getIdExamen());
        datos2[1][3] = String.valueOf(c.getAlumno().getMatricula());
        datos = datos2;

    }

    void setVisible(boolean b, DefaultListModel dl) {
        setVisible(true);
        System.out.println(dl.size());
        Object[][] filas = new Object[dl.size()][4];
        String[][] datos2 = new String[dl.size() + 1][4];
        datos2[0][0] = "Id";
        datos2[0][1] = "Puntaje";
        datos2[0][2] = "Id de Examen";
        datos2[0][3] = "Matricula";
        for (int i = 0; i < dl.size(); i++) {
            Calificaciones a = (Calificaciones) dl.get(i); //ASI SE RECIBE UNA LISTA
            filas[i][0] = a.getIdCalificaciones();
            filas[i][1] = a.getPuntuaje();
            filas[i][2] = a.getExamen().getIdExamen();
            filas[i][3] = a.getAlumno().getMatricula();
            datos2[i + 1][0] = String.valueOf(a.getIdCalificaciones());
            datos2[i + 1][1] = String.valueOf(a.getPuntuaje());
            datos2[i + 1][2] = String.valueOf(a.getExamen().getIdExamen());
            datos2[i + 1][3] = String.valueOf(a.getAlumno().getMatricula());
        }
        datos = datos2;
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
                filas,
                new String[]{
                    "Id", "Puntaje", "Id de Examen", "Matricula"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };

        });
        jScrollPane2.setViewportView(Tabla);
        jScrollPane2.setPreferredSize(new Dimension(3, 0));
        Tabla.setSize(200, 200);

    }
}
