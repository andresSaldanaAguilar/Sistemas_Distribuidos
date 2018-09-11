
package paquete;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperacionesImpl extends UnicastRemoteObject implements Operaciones
{
    
    public OperacionesImpl() throws RemoteException
    {
        super();
    }

    @Override
    public double Sumar(double x, double y) throws RemoteException 
    {
        return x + y;
    }

    @Override
    public double Restar(double x, double y) throws RemoteException 
    {
        return x - y;
    }

    @Override
    public double Multiplicar(double x, double y) throws RemoteException 
    {
        return x * y;
    }

    @Override
    public double Dividir(double x, double y) throws RemoteException 
    {
        return x / y;
    }
    
    @Override
    public double Promedio(double[] x) 
    {
        int cantidad = x.length;
        double total = 0;
        int i;
        
        for( i=0 ; i<cantidad ; i++ )
        {
            total += (i+1) * x[i];
        }
        
        return total;
    }

    @Override
    public double Desviacion(double[] x) 
    {
        double suma = 0, a = 0;
        double xProm = Promedio(x);
        double div , res;
        
        for (int i = 0; i < x.length; i++){
                a = x[i] - xProm;
                suma += (double) Math.pow(a, 2);
        }
        
        div = suma / (x.length - 1);
        res = (double) Math.sqrt(div);
        
        return res;
    }

    @Override
    public int Factorial(int numero) 
    {
       if( numero == 0 ){
           return 1;
       }
       else{
           return numero * Factorial( numero - 1 );
       }
    }

    @Override
    public int Fibonacci(int numero) 
    {
        if( numero == 0 ){
            return 0;
        }
        else if( numero == 1 ){
            return 1;
        }
        else{
            return Fibonacci( numero-1 ) + Fibonacci( numero-2 );
        }
            
    }

    @Override
    public double Raizcuadrada(double numero1) 
    {
        return Math.sqrt(numero1);
    }
    
    @Override
    public double Cuadrado(double numero1) 
    {
        return Math.pow( numero1, 2 );
    }

    
}
