import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductoDAO{
    public static synchronized boolean insertarProducto(Producto producto){
        Connection cn = null;
        CallableStatement cs = null;
        boolean respuesta = false;
        try{
            cn.Conexion.getConexion();
            cn.setAutoCommit(false);
            cs = cn.prepareCall("{call spInsertar(?,?,?)}");
            cs.setString(1, producto.getNombre());
            cs.setDouble(2,producto.getPrecio());
            cs.setInt(3,producto.IdCategoria().getIdCategoria());
            respuesta = cs.executeUpdate() == 1? true:false;
            if(respuesta){
                cn.commit();
            }else{
                Conexion.deshacerCambios(cn);
            }
            Conexion.cerrarCallSt(cs);
            Conexion.cerrar(cn);
        }catch(SQLException e){
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCallSt(cs);
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Terminar
        }
        return respuesta;
    }
}
//en que consiste el patron de diseño data access object
//comentar linea a linea que hace cada 
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar