/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author andressaldana
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero uno");

        jLabel2.setText("Numero dos");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Resultado: ---");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suma", "Resta", "Multiplicacion", "Division", "Promedio", "Fibonacci", "Maximo", "Cuadrado", "Paridad", "Raiz" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String op = jComboBox1.getSelectedItem().toString();
        String aux1 = jTextField1.getText(), aux2 = jTextField2.getText();
        boolean isnumber1 = true,isnumber2 = true;

        if(!aux1.equals("")){
            for(int i = 0; i < aux1.length(); i++){
                if((int)aux1.charAt(i) == 48 || (int)aux1.charAt(i) == 49 || (int)aux1.charAt(i) == 50 || 
                    (int)aux1.charAt(i) == 51 || (int)aux1.charAt(i) == 52 || (int)aux1.charAt(i) == 53 ||
                    (int)aux1.charAt(i) == 54 || (int)aux1.charAt(i) == 55 || (int)aux1.charAt(i) == 56 ||
                    (int)aux1.charAt(i) == 57){}
                else{
                    isnumber1  = false;
                }
            }
        }
        
        if(!aux2.equals("")){
            for(int i = 0; i < aux2.length(); i++){
                if((int)aux2.charAt(i) == 48 || (int)aux2.charAt(i) == 49 || (int)aux2.charAt(i) == 50 || 
                    (int)aux2.charAt(i) == 51 || (int)aux2.charAt(i) == 52 || (int)aux2.charAt(i) == 53 ||
                    (int)aux2.charAt(i) == 54 || (int)aux2.charAt(i) == 55 || (int)aux2.charAt(i) == 56 ||
                    (int)aux2.charAt(i) == 57){}
                else{
                    isnumber2  = false;
                }
            }
        }
        
        if(!isnumber1 || !isnumber2){
             JOptionPane.showConfirmDialog(null, "Uno de los elementos no es numero","alert", JOptionPane.OK_CANCEL_OPTION);           
        }
        else{
            if(op.equals("Suma")){
                jLabel3.setText("El resultado de "+jTextField1.getText()+" + "+ jTextField2.getText() +" es: "+suma(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Resta")){
                jLabel3.setText("El resultado de "+jTextField1.getText()+" - "+ jTextField2.getText() +" es: "+resta(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Multiplicacion")){
                jLabel3.setText("El resultado de "+jTextField1.getText()+" * "+ jTextField2.getText() +" es: "+multiplica(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Division")){
                jLabel3.setText("El resultado de "+jTextField1.getText()+" / "+ jTextField2.getText() +" es: "+divide(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Promedio")){
                jLabel3.setText("Promedio: "+promedio(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Fibonacci")){
                jLabel3.setText("Serie de fibonacci con "+jTextField1.getText()+ "elementos: "+fibonacci(Integer.parseInt(jTextField1.getText())));
            }
            else if(op.equals("Maximo")){
                jLabel3.setText("El maximo entre "+jTextField1.getText()+" y "+ jTextField2.getText() +" es: "+maximo(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText())));
            }
            else if(op.equals("Cuadrado")){
                jLabel3.setText("El cuadrado de "+jTextField1.getText()+" es: "+cuadrado(Integer.parseInt(jTextField1.getText())));
            }
            else if(op.equals("Paridad")){
                jLabel3.setText(jTextField1.getText()+" es: "+paridad(Integer.parseInt(jTextField1.getText())));
            }
            else if(op.equals("Raiz")){
                jLabel3.setText("La raiz de "+jTextField1.getText()+" es: "+raiz(Integer.parseInt(jTextField1.getText())));
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String op = jComboBox1.getSelectedItem().toString();
        if(op.equals("Fibonacci")){
            jTextField2.setEnabled(false);
        }
        else if(op.equals("Cuadrado")){
            jTextField2.setEnabled(false);
        }
        else if(op.equals("Paridad")){
            jTextField2.setEnabled(false);
        }
        else{
            jTextField2.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private static int suma(int numeroUno, int numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.suma(numeroUno, numeroDos);
    }

    private static int resta(int numeroUno, int numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.resta(numeroUno, numeroDos);
    }

    private static int multiplica(int numeroUno, int numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.multiplica(numeroUno, numeroDos);
    }

    private static double divide(double numeroUno, double numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.divide(numeroUno, numeroDos);
    }

    private static double cuadrado(double numeroUno) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.cuadrado(numeroUno);
    }

    private static String fibonacci(double numeroUno) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.fibonacci(numeroUno);
    }

    private static double maximo(double numeroUno, double numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.maximo(numeroUno, numeroDos);
    }

    private static String paridad(double numeroUno) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.paridad(numeroUno);
    }

    private static double promedio(double numeroUno, double numeroDos) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.promedio(numeroUno, numeroDos);
    }

    private static double raiz(double numeroUno) {
        com.ipn.mx.ws.Operaciones_Service service = new com.ipn.mx.ws.Operaciones_Service();
        com.ipn.mx.ws.Operaciones port = service.getOperacionesPort();
        return port.raiz(numeroUno);
    }
}
