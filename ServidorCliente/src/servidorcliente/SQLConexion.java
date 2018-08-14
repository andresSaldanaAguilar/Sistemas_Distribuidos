/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcliente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConexion extends Thread{
    protected Socket socketCliente;
    protected BufferedReader entrada;
    protected PrintStream salida;
    protected String consulta;
    
    public SQLConexion(Socket socketCliente){
        this.socketCliente = socketCliente;
        try {
            entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
            salida = new PrintStream(this.socketCliente.getOutputStream());
        } catch (IOException e) {
            System.err.println(e);
            try{
                this.socketCliente.close();
            }catch(IOException e2){
            }
            return;
        }
        start();
    }
    
    public void run(){
        try{
            consulta = entrada.readLine();
            System.out.println("Consulta a Ejecutar: " + consulta +";");
            ejecutaSQL();
        }catch(IOException e){
        }finally{
            try{
                socketCliente.close();
            }catch(IOException e){
            }
        }
    }
    
    public void ejecutaSQL() {
        Connection cnn;
        Statement st;
        ResultSet rs;
        ResultSetMetaData resultadoMetaData;
        boolean existenMasFilas;
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root", clave = "Keane1234", registro;
        int numeroColumnas, i;
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/perro", usuario, clave);
            st = cnn.createStatement();
            rs = st.executeQuery(consulta);
            existenMasFilas = rs.next();
            if (!existenMasFilas) {
                salida.println("No hay mas filas.");
            }
            resultadoMetaData = rs.getMetaData();
            numeroColumnas = resultadoMetaData.getColumnCount();
            System.out.println(numeroColumnas + " columnas en el resultado.");
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + "  ");
                }
                salida.println(registro);
                System.out.println(registro);
                existenMasFilas = rs.next();
            }
            System.out.println("\n---Fin de la consulta.");
            rs.close();
            st.close();
            cnn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

