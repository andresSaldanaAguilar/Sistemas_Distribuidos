
package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Formulario extends javax.swing.JInternalFrame implements ActionListener
{
    JLabel titulo , x , y;
    JScrollPane scroll;
    JTextArea espacio;
    JTextField numx , numy;
    JComboBox combo;
    JButton calcula , cerrar;
    
    Operaciones ope;
    
    public Formulario()
    {
        setLayout(null);        
        
        x=new JLabel();
        x.setText("Operando 1");
        add(x);
        x.setBounds(50,100,150,30);
        x.setVisible(false);
        
        y=new JLabel();
        y.setText("Operando 2");
        add(y);
        y.setBounds(50,130,150,30);
        y.setVisible(false);
        
        numx = new JTextField();
        add(numx);
        numx.setBounds(120,100,150,30);
        numx.setVisible(false);
        
        numy = new JTextField();
        add(numy);
        numy.setBounds(120,130,150,30);
        numy.setVisible(false);
        
        //TextArea
        espacio=new JTextArea();
        scroll=new JScrollPane(espacio);
        scroll.setBounds(70,100,250,130);
        add(scroll);
        scroll.setVisible(false);
        
        //Combo
        combo = new JComboBox();
        combo.addItem("Seleccione operacion");
        combo.addItem("Suma");
        combo.addItem("Resta");
        combo.addItem("Multiplicacion");
        combo.addItem("Division");
        combo.addItem("Promedio");
        combo.addItem("Desviacion");
        combo.addItem("Factorial");
        combo.addItem("Fibonacci");
        combo.addItem("Cuadrado");
        combo.addItem("Raiz Cuadrada");
        add(combo);
        combo.setBounds(100,50,170,30);
        
        //Botones
        calcula = new JButton();
        calcula.setText("Calcular");
        add(calcula);
        calcula.setBounds(50,250,150,30);
        calcula.setVisible(false);
        
        cerrar = new JButton();
        cerrar.setText("X");
        add(cerrar);
        cerrar.setBounds(345,0,40,30);
        cerrar.setVisible(true);
        
        
        //ActionListener
        combo.addActionListener(this);
        calcula.addActionListener(this);
        cerrar.addActionListener(this);
        
        //RMI
        rmi();
        
        setBounds(20,20,400,330);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        String cadena = (String) combo.getSelectedItem();
        double nume1 , nume2;
        
        if(evento.getSource().equals(combo))
        {
            limpiar();
            
            if( cadena.contains("Suma") || cadena.contains("Resta") ||cadena.contains("Multiplicacion") ||cadena.contains("Division") )
            {
                x.setVisible(true);
                y.setVisible(true);
                
                numx.setVisible(true);
                numy.setVisible(true);
                
                calcula.setVisible(true);
            }
            if(cadena.contains("Factorial") ||cadena.contains("Fibonacci") ||cadena.contains("Cuadrado") ||cadena.contains("Raiz Cuadrada") )
            {
                x.setVisible(true);
                numx.setVisible(true);
                
                calcula.setVisible(true);
            }
            if(cadena.contains("Promedio") ||cadena.contains("Desviacion") )
            {
                scroll.setVisible(true);
                
                calcula.setVisible(true);
            }
        }
        
        if(evento.getSource().equals(cerrar))
        {
            setVisible(false);
        }
        
        if(evento.getSource().equals(calcula))
        {
            try
            {
                if( cadena.contains("Suma") ||  cadena.contains("Resta") ||cadena.contains("Multiplicacion") ||cadena.contains("Division") )
                {   
                    if( numx.getText().equals("") )
                    {
                        nume1 = 0;
                    }
                    else
                    {
                        nume1 = Double.parseDouble(numx.getText());
                    }

                    if( numy.getText().equals("") )
                    {
                        nume2 = 0;
                    }
                    else
                    {
                        nume2 = Double.parseDouble(numy.getText());
                    }
                    
                    if(cadena.contains("Division") && nume2==0 )
                    {
                        nume2 = 1;
                    }

                    if( cadena.contains("Suma") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Sumar(nume1, nume2) );
                    }
                    if( cadena.contains("Resta") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Restar(nume1, nume2) );
                    }
                    if(cadena.contains("Multiplicacion") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Multiplicar(nume1, nume2) );
                    }
                    if(cadena.contains("Division") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Dividir(nume1, nume2) );
                    }
                }
                
                if(cadena.contains("Promedio") ||cadena.contains("Desviacion") )
                {
                    String cad , x[];
                    double ar[];
                    int i;
                    
                    if( espacio.getText().equals("") )
                    {
                        espacio.setText("1");
                    }
                    
                    cad = espacio.getText();
                    
                    String y[] = cad.split("\n");
                    
                    ar = new double[y.length];
                    
                    for( i=0 ; i<y.length ; i++)
                    {
                        ar[i] = Double.parseDouble(y[i]);
                    }
                    
                    if(cadena.contains("Promedio") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Promedio( ar ) );
                    }
                    if(cadena.contains("Desviacion") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Desviacion( ar ) );
                    }
                }
                if(cadena.contains("Factorial") || cadena.contains("Fibonacci")  )
                {   
                    if( numx.getText().equals("") )
                    {
                        nume1 = 0;
                    }
                    else
                    {
                        nume1 = Integer.parseInt(numx.getText());
                    }
                    
                    if(cadena.contains("Factorial") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Factorial( (int) nume1 ) );
                    }
                    if(cadena.contains("Fibonacci") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Fibonacci((int) nume1 ) );
                    }
                }
                if(cadena.contains("Cuadrado") || cadena.contains("Raiz Cuadrada")  )
                {
                    if( numx.getText().equals("") )
                    {
                        nume1 = 0;
                    }
                    else
                    {
                        nume1 = Double.parseDouble(numx.getText());
                    }
                    
                    if(cadena.contains("Cuadrado") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Cuadrado( nume1 ) );
                    }
                    if(cadena.contains("Raiz Cuadrada") )
                    {
                        JOptionPane.showMessageDialog(null, "Resultado: " + ope.Raizcuadrada( nume1 ) );
                    }
                }
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    public void limpiar()
    {
        x.setVisible(false);
        y.setVisible(false);
        numx.setVisible(false);
        numy.setVisible(false);
        scroll.setVisible(false);
        calcula.setVisible(false);
    }
    
    //RMI
    public void rmi()
    {
        try
        {
            ope = (Operaciones) Naming.lookup("rmi://localhost/operaciones");
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex) 
        {
            System.out.println(ex);
             Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    
}
