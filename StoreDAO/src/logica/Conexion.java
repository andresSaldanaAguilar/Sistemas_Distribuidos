/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;




import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion{
    //definimmos url a la base de datos
    private static String url = "jdbc:mysql://localhost/Store";
    //definimos el usuario de base de datos
    private static String user = "root";
    //definimos contraseña de base de datos
    private static String password = "Keane1234";
    //definimos el driver a ocupar
    private static String driver = "com.mysql.jdbc.Driver";

    
    //metodo encargado de conexion a la base de datos definida anteriormente
    public static synchronized Connection getConexion(){
        //creamos una conexion 
        Connection cn = null;
        try{
            //establecemos que dirver se usara
            Class.forName(driver);
            //intentamos conexion a la base
            cn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa a base de datos");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error en conexion con base de datos");
        }finally{
            return cn;
        }
    }
    
    //cerramos la llamada a procedimiento almacenado
    public static synchronized void cerrarCallSt (CallableStatement cs){
        try{
            cs.close();
        }catch(Exception e){
            System.out.println("Error en al cerrar procedimiento almacenado");
        }
    }

    //cerramos el set de resultados
    public static synchronized void cerrar(ResultSet rs){
        try{
            rs.close();
        }catch(Exception e){
            System.out.println("Error al cerrar el set de resultados");
        }
    }

    //cerramos conecion a base de datos
    public static synchronized void cerrar(Connection cn){
        try{
            cn.close();
        }catch(Exception e){
            System.out.println("Error al cerrar conexion a base de datos");
        }
    }

    //deshacemos todo cambio hecho en la base
    public static synchronized void deshacerCambios(Connection cn){
        try{
            cn.rollback();
        }catch(Exception e){
            System.out.println("Error al revertir cambios");
        }
    }

}