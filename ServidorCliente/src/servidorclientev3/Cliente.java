/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorclientev3;

import servidorclientev2.*;
import servidorcliente.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    //table
    static JTable table;
 
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
        
        //cabecera de tabla
        String[] columns = new String[] {};
        //registros
        Object[][] data = new Object[][] {};
        //create table with data
        table = new JTable(data, columns);
        p.add(new JScrollPane(table));
      
        
        p.setVisible(true);        
        f.setSize(500, 500);
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
            //envio de consulta
            socket = new Socket("localhost", PUERTOESCUCHA);
            PrintStream salida= new PrintStream(socket.getOutputStream());
            salida.println(t.getText()); 
            //resultado
            BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
            System.out.println( "Respuesta del servidor:" );
            String line = "";
            
            //creando la tablita
            line =  br.lines().collect(Collectors.joining("\n"));
            String [] array = line.split("\n");
            int x = array.length;
            int y = array[0].split("\t").length;
            Object[][] tabla = new Object[x][y];
            for(int i = 0; i < x ; i++){
                String [] aux = array[i].split("\t");
                for(int j = 0; j < y ; j++){
                    tabla[i][j] = aux[j];
                }
            }
            System.out.println(line);
            br.close();
            //cabecera de la tabla
            String[] columns = new String[y];
            //repintamos tabla
            table.setModel(new DefaultTableModel(tabla, columns));
            table.repaint();
            
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
