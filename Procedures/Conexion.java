import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion{
    private static String url = "jdbc:mysql//localhost:3306/Ejer1";
    private static String user = "root";
    private static String password =  "Keane1234";

    public static synchronized Connection getConnection(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            System.out.println("Error en conexion");
        }finally{
            return cn;
        }
    }
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