/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author andressaldana
 */
public class operacionesCuentaDAO {
    public static synchronized String selectOperacionesCuenta(String idCuenta){
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
            cs = cn.prepareCall("{call spSelectOperacionesCuenta(?)}");
            cs.setBigDecimal(1, new BigDecimal(idCuenta));
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
                    registro = registro.concat(rs.getString(i) + ";");
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
  
    public static synchronized boolean insertarOperacion(operacionCuenta opCuenta){
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
            cs = cn.prepareCall("{call spInsertaroperacionesCuenta(?,?,?)}");
            //estalecemos el segundo argumento del procedure
            cs.setString(1, opCuenta.getTipo());
            //estalecemos el primer argumento del procedure
            cs.setDouble(2, opCuenta.getCantidad());
            
            cs.setBigDecimal(3, new BigDecimal(opCuenta.getIdCuenta()));
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
}
