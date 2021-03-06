/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CentrodetrabajoController;
import Interfaces.CentrodetrabajoInt;
import Modelo.Centrodetrabajo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author sam-y
 */
public class Formulario_Centrodetrabajo_Alta extends javax.swing.JInternalFrame {

    int banderaCambio = 0;
    int idCambio = 0;

    /**
     * Creates new form Formulario_Centrodetrabajo
     */
    public Formulario_Centrodetrabajo_Alta() {
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

        jPanel1 = new javax.swing.JPanel();
        nombreCT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(162, 177, 192));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Centro de Trabajo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre :");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(nombreCT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            CentrodetrabajoInt centrodetrabajoController = (CentrodetrabajoInt) Naming.lookup("rmi://localhost/centrodetrabajoController");
            if (banderaCambio == 1) {
                if (this.nombreCT.getText().length() > 0) {
                    Centrodetrabajo centrodetrabajo = new Centrodetrabajo(idCambio, this.nombreCT.getText());
                    centrodetrabajoController.updateCentrodetrabajo(centrodetrabajo);
                    JOptionPane.showMessageDialog(null, "Modificacion exitosa");
                }
            } else {
                if (this.nombreCT.getText().length() > 0) {
                    DefaultListModel dl = centrodetrabajoController.selectallCentrodetrabajo();
                    Centrodetrabajo ct = (Centrodetrabajo) dl.get(dl.size() - 1); //ASI SE RECIBE UNA LISTA
                    Centrodetrabajo centrodetrabajo = new Centrodetrabajo(ct.getIdCentroDeTrabajo() + 1, this.nombreCT.getText());
                    centrodetrabajoController.insertCentrodetrabajo(centrodetrabajo);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
            this.setVisible(false);
            this.nombreCT.setText("");
            this.jButton1.setText("Aceptar");
            banderaCambio = 0;
        } catch (NotBoundException | MalformedURLException | RemoteException | SecurityException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.nombreCT.setText("");
        this.jButton1.setText("Aceptar");
        banderaCambio = 0;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreCT;
    // End of variables declaration//GEN-END:variables

    void setVisible(boolean b, int i) throws NotBoundException {
        try {
            setVisible(true);

            String stringInput = JOptionPane.showInputDialog("Id del Centro de Trabajo a modificar");
            if (stringInput != null) {
                int id = Integer.parseInt(stringInput);
                CentrodetrabajoInt centrodetrabajoController = (CentrodetrabajoInt) Naming.lookup("rmi://localhost/centrodetrabajoController");
                Centrodetrabajo ct = centrodetrabajoController.selectoneCentrodetrabajo(id);
                if (ct != null) {
                    this.nombreCT.setText(ct.getNombreCentroDeTrabajo());
                    this.jButton1.setText("Cambiar");
                    banderaCambio = 1;
                    idCambio = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Id inválido");
                    this.setVisible(false);
                    this.nombreCT.setText("");
                    this.jButton1.setText("Aceptar");
                    banderaCambio = 0;
                }
            } else {
                setVisible(false);
                this.nombreCT.setText("");
                this.jButton1.setText("Aceptar");
                banderaCambio = 0;
            }

        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
