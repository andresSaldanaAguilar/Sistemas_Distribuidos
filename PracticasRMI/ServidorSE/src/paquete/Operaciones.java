
package paquete;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operaciones extends Remote
{
    public double Sumar( double x , double y ) throws RemoteException;
    public double Restar( double x , double y ) throws RemoteException;
    public double Multiplicar( double x , double y ) throws RemoteException;
    public double Dividir( double x , double y ) throws RemoteException;
    public double Promedio(double [] x)  throws RemoteException;
    public double Desviacion(double [] x)  throws RemoteException;
    public int Factorial(int x)  throws RemoteException;
    public int Fibonacci(int x)  throws RemoteException;
    public double Cuadrado(double x)  throws RemoteException;
    public double Raizcuadrada(double x)  throws RemoteException;
}
