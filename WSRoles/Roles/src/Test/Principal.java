package Test;

import com.ipn.mx.ws.Rol;
import java.util.List;

public class Principal extends javax.swing.JFrame {
    Actualizar ac= new Actualizar();
    Eliminar el= new Eliminar();
    Insertar in= new Insertar();
    
    SeleccionarUno su= new SeleccionarUno();
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        x = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuInsertar = new javax.swing.JMenuItem();
        jMenuActualizar = new javax.swing.JMenuItem();
        jMenuSelTodo = new javax.swing.JMenuItem();
        jMenuSelUno = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout xLayout = new javax.swing.GroupLayout(x);
        x.setLayout(xLayout);
        xLayout.setHorizontalGroup(
            xLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        xLayout.setVerticalGroup(
            xLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("CRUD");

        jMenuInsertar.setText("Insertar");
        jMenuInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInsertarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuInsertar);

        jMenuActualizar.setText("Actualizar");
        jMenuActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActualizarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuActualizar);

        jMenuSelTodo.setText("Seleccionar todos");
        jMenuSelTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSelTodoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuSelTodo);

        jMenuSelUno.setText("Seleccionar uno ");
        jMenuSelUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSelUnoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuSelUno);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jMenu2.add(Eliminar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(x)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(x)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInsertarActionPerformed
        this.x.add(in);
        in.setVisible(true);
    }//GEN-LAST:event_jMenuInsertarActionPerformed

    private void jMenuActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActualizarActionPerformed
        this.x.add(ac);
        ac.setVisible(true);
    }//GEN-LAST:event_jMenuActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        this.x.add(el);
        el.setVisible(true);
    }//GEN-LAST:event_EliminarActionPerformed

    private void jMenuSelTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSelTodoActionPerformed
        SelectTodos st= new SelectTodos();
        SeleccionarTodo sel= new SeleccionarTodo();
        this.x.add(st);
        st.setVisible(true);
        sel.setVisible(true);
        test t = new test();
        List<Rol> listaRoles = null;
        listaRoles = t.seleccionarTodosRol();
        sel.addColumna("ID");
        sel.addColumna("Rol");
        for (int i = 0; i < listaRoles.size(); i++) {
           String os[]= {String.valueOf(listaRoles.get(i).getId()),listaRoles.get(i).getNombreRol()};
           st.addFila(os);
           sel.addFila(os);
           System.out.println("Lista de roles:" + listaRoles.get(i).getId() + ", " + listaRoles.get(i).getNombreRol());
        }
        
        
        
    }//GEN-LAST:event_jMenuSelTodoActionPerformed

    private void jMenuSelUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSelUnoActionPerformed
        this.x.add(su);
        su.setVisible(true);
    }//GEN-LAST:event_jMenuSelUnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuActualizar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuInsertar;
    private javax.swing.JMenuItem jMenuSelTodo;
    private javax.swing.JMenuItem jMenuSelUno;
    private javax.swing.JDesktopPane x;
    // End of variables declaration//GEN-END:variables
}
