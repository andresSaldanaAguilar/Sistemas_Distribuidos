package com.ipn.mx.ws;

import java.sql.ResultSet;
import java.util.List;
import roles.Rol;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import roles.RolDAO;

@WebService(serviceName = "wsRoles")
public class wsRoles {
    
    @WebMethod(operationName = "insertarRol")
    public boolean insertarRol(@WebParam(name = "nombreRol") String nombreRol) {
        Rol rol = new Rol();
        rol.setNombreRol(nombreRol);
        RolDAO rolDao = new RolDAO();
        return rolDao.insertarRol(rol);
    }
    
    @WebMethod(operationName = "seleccionarUnoRol")
    public Rol seleccionarUnoRol(@WebParam(name = "idRol") int idRol) {
        Rol rol = new Rol();
        rol.setId(idRol);
        RolDAO rolDao = new RolDAO();
        return rolDao.seleccionarUnoRol(rol);
    }
    
    @WebMethod(operationName = "seleccionarTodosRol")
    public List<Rol> seleccionarTodosRol() {
        List<Rol> datos = null;
        RolDAO rolDao = new RolDAO();
        datos = rolDao.seleccionarTodosRol();
        return datos;
    }
    
    
    @WebMethod(operationName = "actualizarRol")
    public boolean actualizarRol(@WebParam(name = "nombreRol") String nombreRol, @WebParam(name = "idRol") int idRol) {
        Rol rol = new Rol();
        rol.setNombreRol(nombreRol);
        rol.setId(idRol);
        RolDAO rolDao = new RolDAO();
        return rolDao.actualizarRol(rol);
    }
    
    @WebMethod(operationName = "eliminarRol")
    public boolean eliminarRol(@WebParam(name = "idRol") int idRol) {
        Rol rol = new Rol();
        rol.setId(idRol);
        RolDAO rolDao = new RolDAO();
        return rolDao.eliminarRol(rol);
    }
    
}
