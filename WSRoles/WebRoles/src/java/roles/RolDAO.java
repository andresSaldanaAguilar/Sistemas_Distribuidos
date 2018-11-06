package roles;

import conexion.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements Serializable{
    //Sentencias SQL
    private static final String SQL_INSERT = "insert into Roles(nombreRol) values(?)";
    private static final String SQL_SELECTONE = "select * from Roles where id = (?)";
    private static final String SQL_SELECTALL = "select * from Roles;";
    private static final String SQL_UPDATE = "update Roles set nombreRol=(?) where id=(?)";
    private static final String SQL_DELETE = "delete from Roles where id=?";

    public RolDAO() {
    }
    
    
    
    public synchronized boolean insertarRol(Rol rol){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean respuesta  = false;
        
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, rol.getNombreRol());
            respuesta = (ps.executeUpdate() == 1);
            if(respuesta){
                conn.commit();
            }
            else{
                Conexion.desecharCambios(conn);
            }
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        } catch (SQLException ex) {
            Conexion.desecharCambios(conn);
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public synchronized Rol seleccionarUnoRol(Rol rol){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rol rolReturn = null;
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(SQL_SELECTONE);
            ps.setInt(1, rol.getId());
            rs = ps.executeQuery();
            rs.next();
            rolReturn = new Rol();
            rolReturn.setId(rs.getInt(1));
            rolReturn.setNombreRol(rs.getString(2));
            
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        } catch (SQLException ex) {
            Conexion.desecharCambios(conn);
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Rol retornado: " + rolReturn.toString());
        return rolReturn;
    } 
    
    public synchronized List<Rol> seleccionarTodosRol(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Rol> lista = new ArrayList<Rol>();
        
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(SQL_SELECTALL);
            rs = ps.executeQuery();
   
            while(rs.next()){
                Rol aux = new Rol();
                aux.setId(rs.getInt(1));
                aux.setNombreRol(rs.getString(2));
                lista.add(aux);
            }
            
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        } catch (SQLException ex) {
            Conexion.desecharCambios(conn);
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public synchronized boolean actualizarRol(Rol rol){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean respuesta  = false;
        
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, rol.getNombreRol());
            ps.setInt(2, rol.getId());
            respuesta = (ps.executeUpdate() == 1);
            if(respuesta){
                conn.commit();
            }
            else{
                Conexion.desecharCambios(conn);
            }
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        } catch (SQLException ex) {
            Conexion.desecharCambios(conn);
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public synchronized boolean eliminarRol(Rol rol){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean respuesta  = false;
        
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, rol.getId());
            respuesta = (ps.executeUpdate() == 1);
            if(respuesta){
                conn.commit();
            }
            else{
                Conexion.desecharCambios(conn);
            }
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        } catch (SQLException ex) {
            Conexion.desecharCambios(conn);
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarConexion(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
    
}
