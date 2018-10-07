package logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class OrderDetailsDAO{

    public static synchronized boolean delete(int id){
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
            cs = cn.prepareCall("{call spDeleteOrderDetails(?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, id);
            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1;
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
    
    public static synchronized boolean insert(double UnitPrice,int Quantity,double Discount, int OrderID, int ProductID){
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
            cs = cn.prepareCall("{call spInsertOrderDetails(?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setDouble(1, UnitPrice);
            cs.setInt(2, Quantity);
            cs.setDouble(3, Discount);
            cs.setInt(4, OrderID);
            cs.setInt(5, ProductID);       

            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1;
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
    
    public static synchronized boolean update(int id, double UnitPrice,int Quantity,double Discount, int OrderID, int ProductID){
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
            cs = cn.prepareCall("{call spUpdateOrderDetails(?,?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, id);
            cs.setDouble(2, UnitPrice);
            cs.setInt(3, Quantity);
            cs.setDouble(4, Discount);
            cs.setInt(5, OrderID);
            cs.setInt(6, ProductID);   
            
            //guardamos en una variable binaria el resultado de la transaccion
            respuesta = cs.executeUpdate() == 1;
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
    
    public static synchronized String consult(int id){
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
            cs = cn.prepareCall("{call spSelectOneOrderDetails(?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, id);
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
    
    
    public static synchronized String selectAll(){
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
            cs = cn.prepareCall("{call spSelectAllOrderDetails()}");
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
