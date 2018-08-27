package Logica;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Conexion{
    private static String url = "jdbc:mysql://localhost/Ejer1";
    private static String user = "root";
    private static String password = "Keane1234";
    private static String driver = "com.mysql.jdbc.Driver";

    public static synchronized Connection getConexion(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error en conexion");
        }finally{
            return cn;
        }
    }
    
    /*public static synchronized String getConsulta(Connection cn, String table){
  
        Statement st;
        ResultSet rs;
        ResultSetMetaData resultadoMetaData;
        boolean existenMasFilas;
        int numeroColumnas, i;
        String resultSet = "",registro;
        
        try {  
            st = cn.createStatement();
            rs = st.executeQuery("Select * from"+table);
            existenMasFilas = rs.next();
            if (!existenMasFilas) {
                resultSet+="================================";
            }
            resultadoMetaData = rs.getMetaData();
            numeroColumnas = resultadoMetaData.getColumnCount();
            System.out.println(numeroColumnas + " registros en el resultado.");
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + "  ");
                }
                resultSet += "registro\n";
                System.out.println(registro);
                existenMasFilas = rs.next();
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resultSet;
    }*/
    
    public static synchronized void cerrarCallSt (CallableStatement cs){
        try{
            cs.close();
        }catch(Exception e){
            System.out.println("Error en cerrarCallSt");
        }
    }

    public static synchronized void cerrar(ResultSet rs){
        try{
            rs.close();
        }catch(Exception e){
            ///Terminar
        }
    }

    public static synchronized void cerrar(Connection cn){
        try{
            cn.close();
        }catch(Exception e){
            //terminar
        }
    }

    public static synchronized void deshacerCambios(Connection cn){
        try{
            cn.rollback();
        }catch(Exception e){
            //Terminar
        }
    }

}