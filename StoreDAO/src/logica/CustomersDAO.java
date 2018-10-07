package logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CustomersDAO{

    public static synchronized boolean delete(String id){
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
            cs = cn.prepareCall("{call spDeleteCustomer(?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, id);
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
            e.printStackTrace();
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static synchronized boolean insert(String id, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax){
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
            cs = cn.prepareCall("{call spInsertCustomer(?,?,?,?,?,?,?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, id);
            cs.setString(2, CompanyName);
            cs.setString(3, ContactName);
            cs.setString(4, ContactTitle);
            cs.setString(5, Address);
            cs.setString(6, City);
            cs.setString(7, Region);
            cs.setString(8, PostalCode);
            cs.setString(9, Country);
            cs.setString(10, Phone);
            cs.setString(11, Fax);       
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
            e.printStackTrace();
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    } 
    
    public static synchronized boolean update(String id, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax){
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
            cs = cn.prepareCall("{call spUpdateCustomer(?,?,?,?,?,?,?,?,?,?,?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, id);
            cs.setString(2, CompanyName);
            cs.setString(3, ContactName);
            cs.setString(4, ContactTitle);
            cs.setString(5, Address);
            cs.setString(6, City);
            cs.setString(7, Region);
            cs.setString(8, PostalCode);
            cs.setString(9, Country);
            cs.setString(10, Phone);
            cs.setString(11, Fax);       
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
            e.printStackTrace();
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static synchronized String consult(String id){
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
            cs = cn.prepareCall("{call spSelectOneCustomer(?)}");
            //estalecemos el primer argumento del procedure
            cs.setString(1, id);
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
            e.printStackTrace();
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
            cs = cn.prepareCall("{call spSelectAllCustomer()}");
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
            e.printStackTrace();
        }catch(Exception e){
            //Impresion de error ajeno a base de datos
            e.printStackTrace();
        }
        return resultSet;
    }  
    
    public static void main(String[] args) {
        //CustomersDAO.insert("id", "pojo", "andrew", "title", "home address", "mexico", "north region", "54170", "state of mexico", "5543890085", "fax");
        //CustomersDAO.delete("id");
        //CustomersDAO.update("id", "pojojo", "andreas", "title", "home address", "mexico", "north region", "54170", "state of mexico", "5543890085", "fax");
        //System.out.println(CustomersDAO.consult("id"));
        //System.out.println(CustomersDAO.selectAll());
    }
}
//mostrar productos por categoria, mostrar uno o mostrar todos, seis metodos en total, actualizar, borrar
