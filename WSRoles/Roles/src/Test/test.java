package Test;

import com.ipn.mx.ws.Rol;
import java.util.List;

public class test {

    protected static boolean actualizarRol(java.lang.String nombreRol, int idRol) {
        com.ipn.mx.ws.WsRoles_Service service = new com.ipn.mx.ws.WsRoles_Service();
        com.ipn.mx.ws.WsRoles port = service.getWsRolesPort();
        return port.actualizarRol(nombreRol, idRol);
    }

   protected static boolean eliminarRol(int idRol) {
        com.ipn.mx.ws.WsRoles_Service service = new com.ipn.mx.ws.WsRoles_Service();
        com.ipn.mx.ws.WsRoles port = service.getWsRolesPort();
        return port.eliminarRol(idRol);
    }

    protected static boolean insertarRol(java.lang.String nombreRol) {
        com.ipn.mx.ws.WsRoles_Service service = new com.ipn.mx.ws.WsRoles_Service();
        com.ipn.mx.ws.WsRoles port = service.getWsRolesPort();
        return port.insertarRol(nombreRol);
    }

    protected static java.util.List<com.ipn.mx.ws.Rol> seleccionarTodosRol() {
        com.ipn.mx.ws.WsRoles_Service service = new com.ipn.mx.ws.WsRoles_Service();
        com.ipn.mx.ws.WsRoles port = service.getWsRolesPort();
        return port.seleccionarTodosRol();
    }

    protected static Rol seleccionarUnoRol(int idRol) {
        com.ipn.mx.ws.WsRoles_Service service = new com.ipn.mx.ws.WsRoles_Service();
        com.ipn.mx.ws.WsRoles port = service.getWsRolesPort();
        return port.seleccionarUnoRol(idRol);
    }
    
    public static void main(String[] args) {
        List<Rol> listaRoles = null;
        Rol rolTest = new Rol();
        String nombreRol = "Gestor";
        
        //System.out.println(insertarRol(nombreRol));
        //actualizarRol("Giselle", 6);
        System.out.println(actualizarRol("Giselle", 6));
        /*
        listaRoles = seleccionarTodosRol();
        for (int i = 0; i < listaRoles.size(); i++) {
            System.out.println("Lista de roles:" + listaRoles.get(i).getId() + ", " + listaRoles.get(i).getNombreRol());
        }
        */
        
        /*
        rolTest = seleccionarUnoRol(1);
        System.out.println("Rol consultado: " + rolTest.getId() + ", " + rolTest.getNombreRol());
        
        */
        //System.out.println(eliminarRol(6));
        
    }
}
