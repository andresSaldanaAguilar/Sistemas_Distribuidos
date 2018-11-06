package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/WSRoles";
    private static String user = "root";
    private static String password = "Keane1234";
    
    public static synchronized Connection getConexion(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            return conn;
        }
    }
    
    public static synchronized void cerrarPreparedStatement(PreparedStatement ps){
        try {
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized void cerrarResultSet(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized void cerrarConexion(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized void desecharCambios(Connection conn){
        try {
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
