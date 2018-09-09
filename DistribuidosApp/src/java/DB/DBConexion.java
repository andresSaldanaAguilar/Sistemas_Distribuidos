package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ANDRES
 */
public class DBConexion {
 private Connection conexion;   
   
    //metodo para conectarse a la base de datos
    public DBConexion conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //aqui especificamos localhost, base de datos, usuario y contraseña
            String BaseDeDatos = "jdbc:mysql://localhost/formulario?user=root&password=Keane1234";
            setConexion(DriverManager.getConnection(BaseDeDatos));
            if(getConexion() != null){
                System.out.println("Conexion Exitosa!");
            }else{
                System.out.println("Conexion Fallida!");                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
     }
        return this;
    }
    
    public Connection getConexion() {
            return conexion;
    }    
    public void setConexion(Connection conexion) {
            this.conexion = conexion;
    }
    
    //este metodo se encarga de realizar insterts,update y delete (sin retorno)
    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        return true;
    }
    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        return resultado;
    }

    
//public static void main(String[] args) throws Exception {
//        DBConexion db=new DBConexion();
//        db.conectar();
//        
//        //ejemplo de insert
//        db.ejecutar("insert into usuario values('Rosa','Saldaña','Aguilar','Y','1997-09-09','pollyketpo@gmail.com',1)");
//        
//        //ejemplo de consulta
//        ResultSet resultados = db.consultar("SELECT * FROM SEXO");        
//          if (resultados != null) {
//            try {
//                System.out.println("idSexo      Nombre");
//                System.out.println("--------------------------------");
//                while (resultados.next()) {
//                    System.out.println(""+resultados.getBigDecimal("idSexo")+"       "+resultados.getString("Nombre"));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//          }
//
//}

}
