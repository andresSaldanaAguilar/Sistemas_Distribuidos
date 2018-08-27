package Logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ProductoDAO{
    //funcion que inserta un producto en la base de datos por medio de una
    //llamada de un procedure
    public static synchronized boolean insertarProducto(Producto producto){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spInsertarP(?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, producto.getNombre());
            //estalecemos el segundo argumento del procedure
            cs.setDouble(2,producto.getPrecio());
            //estalecemos el tercer argumento del procedure
            cs.setInt(3,producto.getIdCategoria()); //nota
            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1? true:false;
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
            //imprimiendo error relacionado a base de datos
            e.printStackTrace();
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static synchronized boolean actualizarProducto(Producto producto){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spActualizarP(?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, producto.getNombre());
            //estalecemos el segundo argumento del procedure
            cs.setDouble(2,producto.getPrecio());
            //estalecemos el tercer argumento del procedure
            cs.setInt(3,producto.getIdCategoria()); //nota
            //estalecemos el primer argumento del procedure
            cs.setInt(4, producto.getIdProducto());
            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1? true:false;
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static synchronized boolean borrarProducto(int idProducto){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spDeleteP(?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, idProducto);
            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1? true:false;
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static synchronized String listarProductoPorCategoria(int idCategoria){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        //set de resultados de la base
        ResultSet rs = null;
        //variable para loop de registros
        boolean existenMasFilas;
        //variable que guarda los metadatos
        ResultSetMetaData resultadoMetaData;
        //cadena con el resultado de la busqueda
        String resultSet= "",registro;
        //variables de apoyo para el recorrido de los registros
        int numeroColumnas, i;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spSelectAllProductsByCategory(?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, idCategoria);
            //ejecutamos el select
            cs.execute();
            //conseguimos los resultados
            rs = cs.getResultSet();        
            //recorremos los resultados
            existenMasFilas = rs.next();
            //ponemos un identificador para el final de la consulta
            if (!existenMasFilas) {
                resultSet+="================================";
            }
            //conseguimos los metadatos
            resultadoMetaData = rs.getMetaData();
            //contamos el numero de columnas de los registros
            numeroColumnas = resultadoMetaData.getColumnCount();

            //recorremos los registros por columnas
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + "  ");
                }
                resultSet += registro+"_";
                existenMasFilas = rs.next();
            }
            rs.close();
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public static synchronized String listarProductos(){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        //set de resultados de la base
        ResultSet rs = null;
        //variable para loop de registros
        boolean existenMasFilas;
        //variable que guarda los metadatos
        ResultSetMetaData resultadoMetaData;
        //cadena con el resultado de la busqueda
        String resultSet= "",registro;
        //variables de apoyo para el recorrido de los registros
        int numeroColumnas, i;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spSelectAllP()}");
            //ejecutamos el select
            cs.execute();
            //conseguimos los resultados
            rs = cs.getResultSet();        
            //recorremos los resultados
            existenMasFilas = rs.next();
            //ponemos un identificador para el final de la consulta
            if (!existenMasFilas) {
                resultSet+="================================";
            }
            //conseguimos los metadatos
            resultadoMetaData = rs.getMetaData();
            //contamos el numero de columnas de los registros
            numeroColumnas = resultadoMetaData.getColumnCount();

            //recorremos los registros por columnas
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + "  ");
                }
                resultSet += registro+"_";
                existenMasFilas = rs.next();
            }
            rs.close();
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public static synchronized String listarProducto(int idProducto){
        //creamos un atributo que manejara la conexion a base de datos
        Connection cn = null;
        //atributo encargado de llamar el procedure
        CallableStatement cs = null;
        //respuesta guarda el resultado de la conexion a base de datos  
        boolean respuesta = false;
        //set de resultados de la base
        ResultSet rs = null;
        //variable para loop de registros
        boolean existenMasFilas;
        //variable que guarda los metadatos
        ResultSetMetaData resultadoMetaData;
        //cadena con el resultado de la busqueda
        String resultSet= "",registro;
        //variables de apoyo para el recorrido de los registros
        int numeroColumnas, i;
        
        try{
            //establece la conexion con la base de datos especificada
            cn = Conexion.getConexion();
            //evitamos el guardado permanente al termino de la transaccion 
            cn.setAutoCommit(false);
            //construimos una llamada al procedure
            cs = cn.prepareCall("{call spSelectOneP(?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, idProducto);
            //ejecutamos el select
            cs.execute();
            //conseguimos los resultados
            rs = cs.getResultSet();        
            //recorremos los resultados
            existenMasFilas = rs.next();
            //ponemos un identificador para el final de la consulta
            if (!existenMasFilas) {
                resultSet+="================================";
            }
            //conseguimos los metadatos
            resultadoMetaData = rs.getMetaData();
            //contamos el numero de columnas de los registros
            numeroColumnas = resultadoMetaData.getColumnCount();

            //recorremos los registros por columnas
            while (existenMasFilas) {
                registro = "";
                for (i = 1; i <= numeroColumnas; i++) {
                    registro = registro.concat(rs.getString(i) + "  ");
                }
                resultSet += registro+"_";
                existenMasFilas = rs.next();
            }
            rs.close();
            //hace los cambios cometidos, permanentes
            if(respuesta){
                cn.commit();
            }else{
                //deshacemos los cambios hechos
                Conexion.deshacerCambios(cn);
            }
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(SQLException e){
            //si hay algun error, deshacemos todo cambio hecho en base de datos
            Conexion.deshacerCambios(cn);
            //cierre de llamada a procedure
            Conexion.cerrarCallSt(cs);
            //cierre de conexion con base de datos
            Conexion.cerrar(cn);
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return resultSet;
    }
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar