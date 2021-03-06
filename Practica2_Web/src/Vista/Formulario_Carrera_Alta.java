/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Interfaces.CarreraInt;
import Interfaces.CentrodetrabajoInt;
import Modelo.Carrera;
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
public class Formulario_Carrera_Alta extends javax.swing.JInternalFrame {

    int banderaCambio = 0;
    int idCambio = 0;

    public Formulario_Carrera_Alta() {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        nombreCT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreCarrera = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        duracion = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        idCentTrabajo = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre :");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel2.setText("Nuevo Centro de Trabajo");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(nombreCT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        jPanel1.setBackground(new java.awt.Color(162, 177, 192));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nueva Carrera");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Duración :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Id Centro de trabajo :");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(nombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idCentTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idCentTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 150, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 150, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 109, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 108, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            CarreraInt carreraController = (CarreraInt) Naming.lookup("rmi://localhost/carreraController");
            CentrodetrabajoInt centrodetrabajoController = (CentrodetrabajoInt) Naming.lookup("rmi://localhost/centrodetrabajoController");
            if (banderaCambio == 1) {
                if (this.nombreCarrera.getText().length() > 0) {
                    if ((Integer) this.duracion.getValue() > 0) {
                        if ((Integer) this.idCentTrabajo.getValue() > 0) {
                            Centrodetrabajo ct = centrodetrabajoController.selectoneCentrodetrabajo((Integer) this.idCentTrabajo.getValue());
                            if (ct == null) {
                                JOptionPane.showMessageDialog(null, "Id de Centro de Trabajo incorrecto.");
                            } else {
                                Carrera carrera = new Carrera(idCambio, ct, this.nombreCarrera.getText(), (Integer) this.duracion.getValue());
                                try {
                                    carreraController.updateCarrera(carrera);

                                    JOptionPane.showMessageDialog(null, "Modificacion exitosa");
                                    this.setVisible(false);
                                } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SystemException ex) {
                                    Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Id invalido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Duracion invalida");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa un nombre");
                }
            } else {
                if (this.nombreCarrera.getText().length() > 0) {
                    if ((Integer) this.duracion.getValue() > 0) {
                        if ((Integer) this.idCentTrabajo.getValue() > 0) {
                            DefaultListModel dl = carreraController.selectallCarrera();
                            Carrera c = (Carrera) dl.get(dl.size() - 1); //ASI SE RECIBE UNA LISTA
                            Centrodetrabajo ct = centrodetrabajoController.selectoneCentrodetrabajo((Integer) this.idCentTrabajo.getValue());
                            if (ct == null) {
                                JOptionPane.showMessageDialog(null, "Id de Centro de Trabajo incorrecto.");
                            } else {
                                Carrera carrera = new Carrera(c.getIdCarrera() + 1, ct, this.nombreCarrera.getText(), (Integer) this.duracion.getValue());
                                try {
                                    carreraController.insertCarrera(carrera);
                                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                                    this.setVisible(false);
                                } catch (HeuristicMixedException | RollbackException | HeuristicRollbackException | SystemException ex) {
                                    Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Id invalido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Duracion invalida");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa un nombre");
                }
            }
            this.nombreCarrera.setText("");
            this.duracion.setValue(0);
            this.idCentTrabajo.setValue(0);
            this.jButton3.setText("Aceptar");
            banderaCambio = 0;
        } catch (NotBoundException | MalformedURLException | RemoteException | SecurityException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        this.nombreCarrera.setText("");
        this.duracion.setValue(0);
        this.idCentTrabajo.setValue(0);
        this.jButton3.setText("Aceptar");
        banderaCambio = 0;
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner duracion;
    private javax.swing.JSpinner idCentTrabajo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreCT;
    private javax.swing.JTextField nombreCarrera;
    // End of variables declaration//GEN-END:variables

    void setVisible(boolean b, int i) throws NotBoundException {
        try {
            setVisible(true);
            String stringInput = JOptionPane.showInputDialog("Id de la Carrera a modificar");
            if (stringInput != null) {
                int id = Integer.parseInt(stringInput);
                CarreraInt carreraController = (CarreraInt) Naming.lookup("rmi://localhost/carreraController");
                Carrera c = carreraController.selectoneCarrera(id);
                if (c != null) {
                    this.nombreCarrera.setText(c.getNombreCarrera());
                    this.duracion.setValue(c.getDuracion());
                    this.idCentTrabajo.setValue(c.getCentrodetrabajo().getIdCentroDeTrabajo());
                    this.jButton3.setText("Cambiar");
                    banderaCambio = 1;
                    idCambio = id;
                } else {
                    JOptionPane.showMessageDialog(null, "Id inválido");
                    this.setVisible(false);
                    this.nombreCarrera.setText("");
                    this.duracion.setValue(0);
                    this.idCentTrabajo.setValue(0);
                    this.jButton3.setText("Aceptar");
                    banderaCambio = 0;
                }
            } else {
                setVisible(false);
                this.nombreCarrera.setText("");
                this.duracion.setValue(0);
                this.idCentTrabajo.setValue(0);
                this.jButton3.setText("Aceptar");
                banderaCambio = 0;
            }

        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Formulario_Centrodetrabajo_Alta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
