/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miCliente;

/**
 *
 * @author andressaldana
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println(suma(1,3));
        System.out.println(divide(1,3));
        System.out.println(resta(1,3));
        System.out.println(multiplica(1,3));
    }

    private static String hello(java.lang.String name) {
        cliente.Operaciones_Service service = new cliente.Operaciones_Service();
        cliente.Operaciones port = service.getOperacionesPort();
        return port.hello(name);
    }

    private static int suma(int numeroUno, int numeroDos) {
        cliente.Operaciones_Service service = new cliente.Operaciones_Service();
        cliente.Operaciones port = service.getOperacionesPort();
        return port.suma(numeroUno, numeroDos);
    }

    private static double divide(double numeroUno, double numeroDos) {
        cliente.Operaciones_Service service = new cliente.Operaciones_Service();
        cliente.Operaciones port = service.getOperacionesPort();
        return port.divide(numeroUno, numeroDos);
    }

    private static int resta(int numeroUno, int numeroDos) {
        cliente.Operaciones_Service service = new cliente.Operaciones_Service();
        cliente.Operaciones port = service.getOperacionesPort();
        return port.resta(numeroUno, numeroDos);
    }

    private static int multiplica(int numeroUno, int numeroDos) {
        cliente.Operaciones_Service service = new cliente.Operaciones_Service();
        cliente.Operaciones port = service.getOperacionesPort();
        return port.multiplica(numeroUno, numeroDos);
    }
}
