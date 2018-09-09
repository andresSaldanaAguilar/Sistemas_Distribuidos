package PruebaJSP;

import java.io.*;
import java.net.*;

public class YourServer
{    
    public static void main(String[] args ) 
    {
        try {    
            ServerSocket socket = new ServerSocket(8765);

            Socket insocket = socket.accept( );

            BufferedReader in = new BufferedReader (new 
                InputStreamReader(insocket.getInputStream()));
            PrintWriter out = new PrintWriter (insocket.getOutputStream(), 
                true);

            String instring = in.readLine();
            System.out.println("Server got:" + instring);
            String [] operandos = instring.split(",");
            
            double suma = Double.parseDouble(operandos[0])+Double.parseDouble(operandos[1]);
            
            double resta = Double.parseDouble(operandos[0])-Double.parseDouble(operandos[1]);
            
            double multiplicacion = Double.parseDouble(operandos[0])*Double.parseDouble(operandos[1]);
            
            double division = Double.parseDouble(operandos[0])/Double.parseDouble(operandos[1]);
            
            String modulo = "";
            if(Double.parseDouble(operandos[0])%2 == 0){
                modulo = "es par";
            }else modulo = "es impar";
            
            double max = Math.max(Double.parseDouble(operandos[0]), Double.parseDouble(operandos[1]));
            
            int aux [] = {Integer.parseInt(operandos[0]), Integer.parseInt(operandos[1])};
            double desv = desviacion(aux);
            
            double prom = (Double.parseDouble(operandos[0])+Double.parseDouble(operandos[1]))/2;
            
            double fact = factorial(Double.parseDouble(operandos[0]));
            
            double fibo = fibonacci(Double.parseDouble(operandos[0]));
            
            out.println(suma+";"+resta+";"+multiplicacion+";"+division+";"+modulo+";"+max+";"+desv+";"+prom+";"+fact+";"+fibo);
            insocket.close();
        }
        catch (Exception e) {} 
    } 
    
    public static double desviacion ( int [ ] v ) {
    double prom, sum = 0; int i, n = v.length;
    prom = promedio ( v );

    for ( i = 0; i < n; i++ ) 
      sum += Math.pow ( v [ i ] - prom, 2 );

    return Math.sqrt ( sum / ( double ) n );
    }

    public static double promedio ( int [ ] v ) {
    double prom = 0.0;
    for ( int i = 0; i < v.length; i++ )
      prom += v[i];

    return prom / ( double ) v.length;  
    }
    
    public static double factorial (double numero) {
        if (numero==0)
          return 1;
        else
        return numero * factorial(numero-1);
    }
    
    public static double fibonacci(double n)
    {
        if (n>1){
           return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1; 
        }
    }
}