/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.rmi.Naming;

/**
 *
 * @author andressaldana
 */
public class SaludoApplet extends Applet{
    String message = "blank";
    Saludo saludo = null;
    @Override
    public void init(){
        try{
            saludo = (Saludo)Naming.lookup("//"+getCodeBase().getHost()+"HelloServer");
            message = saludo.saludar();
        }catch(Exception e){
            System.out.println("HelloAppletException: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
        g.drawString(message, 25, 50);
    }
}
