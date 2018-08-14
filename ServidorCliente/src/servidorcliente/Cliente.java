/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author andressaldana
 */
public class Cliente extends JFrame implements ActionListener{
    // JTextField
    static JTextField t;
    // JFrame
    static JFrame f;
    // JButton
    static JButton b;
 
    public static void main(String[] args)
    {
        f = new JFrame("Consultor de bases de datos");
        b = new JButton("consultar");
        Cliente cl = new Cliente();
        b.addActionListener(cl);
        t = new JTextField(16);
        JPanel p = new JPanel();
        p.add(t);
        p.add(b);
 
        f.add(p);
        f.setSize(300, 100);
        f.show();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
 
    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("consultar")) {
            abrirSocket();
        }
    }
    
    private static final int PUERTOESCUCHA = 6666;

    private void abrirSocket(){
        Socket socket = null;
        try{
            socket = new Socket("localhost", PUERTOESCUCHA);
            PrintStream salida= new PrintStream(socket.getOutputStream());
            salida.println(t.getText());               
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                socket.close();
            }catch(IOException ee){
            }
        }

    }
}
