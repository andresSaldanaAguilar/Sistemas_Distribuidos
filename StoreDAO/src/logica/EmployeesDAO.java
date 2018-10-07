package logica;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class EmployeesDAO{

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
            cs = cn.prepareCall("{call spDeleteEmployee(?)}");
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
    
    public static synchronized boolean insert(String LastName, String FirstName, String Title, String TitleOfCourtesy, Date BirthDate, Date HireDate, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Extension, Blob Photo, String Notes, int ReportsTo){
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
            cs = cn.prepareCall("{call spInsertEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, LastName);
            cs.setString(2, FirstName);
            cs.setString(3, Title);
            cs.setString(4, TitleOfCourtesy);
            cs.setDate(5, (java.sql.Date) BirthDate);
            cs.setDate(6, (java.sql.Date) HireDate);
            cs.setString(7, Address);
            cs.setString(8, City);
            cs.setString(9, Region);
            cs.setString(10, PostalCode);
            cs.setString(11, Country);
            cs.setString(12, Phone);
            cs.setString(13, Extension);
            cs.setBlob(14, Photo);
            cs.setString(15, Notes);       
            cs.setInt(16, ReportsTo); 
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
    
    public static synchronized boolean update(int id, String LastName, String FirstName, String Title, String TitleOfCourtesy, Date BirthDate, Date HireDate, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Extension, Blob Photo, String Notes, int ReportsTo){
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
            cs = cn.prepareCall("{call spUpdateEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setInt(1, id);
            cs.setString(2, LastName);
            cs.setString(3, FirstName);
            cs.setString(4, Title);
            cs.setString(5, TitleOfCourtesy);
            cs.setDate(6, (java.sql.Date) BirthDate);
            cs.setDate(7, (java.sql.Date) HireDate);
            cs.setString(8, Address);
            cs.setString(9, City);
            cs.setString(10, Region);
            cs.setString(11, PostalCode);
            cs.setString(12, Country);
            cs.setString(13, Phone);
            cs.setString(14, Extension);
            cs.setBlob(15, Photo);
            cs.setString(16, Notes);       
            cs.setInt(17, ReportsTo); 
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
            cs = cn.prepareCall("{call spSelectOneEmployee(?)}");
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
            cs = cn.prepareCall("{call spSelectAllEmployee()}");
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
