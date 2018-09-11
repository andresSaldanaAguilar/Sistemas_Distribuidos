package paquete;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet 
{
    Operaciones ope;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        rmi();
        
        String cadena = request.getParameter("select");
        String numero1 = request.getParameter("x");
        String numero2 = request.getParameter("y");
        String espacio = request.getParameter("area");
                
        double nume1 , nume2 , resultado = 0;
   
        if( cadena.equals("1") ||  cadena.equals("2") || cadena.equals("3") || cadena.equals("4") )
        {   
            if( numero1.equals("") )
            {
                nume1 = 0;
            }
            else
            {
                nume1 = Double.parseDouble(numero1);
            }

            if( numero2.equals("") )
            {
                nume2 = 0;
            }
            else
            {
                nume2 = Double.parseDouble(numero2);
            }

            if( cadena.equals("4") && nume2==0 )
            {
                nume2 = 1;
            }

            if( cadena.equals("1") )
            {
                resultado = ope.Sumar(nume1, nume2);
            }
            if( cadena.equals("2") )
            {
                resultado = ope.Restar(nume1, nume2);
            }
            if( cadena.equals("3") )
            {
                resultado = ope.Multiplicar(nume1, nume2);
            }
            if( cadena.equals("4") )
            {
                resultado = ope.Dividir(nume1, nume2);
            }
        }

        if( cadena.equals("5") || cadena.equals("6") )
        {
            String cad , x[];
            double ar[];
            int i;

            if( espacio.equals("") )
            {
                espacio = "1";
            }

            cad = espacio;

            String y[] = cad.split("\n");

            ar = new double[y.length];

            for( i=0 ; i<y.length ; i++)
            {
                ar[i] = Double.parseDouble(y[i]);
            }

            if( cadena.equals("5") )
            {
                resultado = ope.Promedio( ar);
            }
            if( cadena.equals("6") )
            {
                resultado = ope.Desviacion( ar);
            }
        }
        if( cadena.equals("7") ||  cadena.equals("8")  )
        {   
            if( numero1.equals("") )
            {
                nume1 = 0;
            }
            else
            {
                nume1 = Integer.parseInt(numero1);
            }

            if( cadena.equals("7") )
            {
                resultado = ope.Factorial( (int) nume1);
            }
            if( cadena.equals("8") )
            {
                resultado = ope.Fibonacci((int) nume1);
            }
        }
        if( cadena.equals("9") ||  cadena.equals("10")  )
        {
            if( numero1.equals("") )
            {
                nume1 = 0;
            }
            else
            {
                nume1 = Double.parseDouble(numero1);
            }

            if( cadena.equals("9") )
            {
                resultado = ope.Cuadrado( nume1);
            }
            if( cadena.equals("10") )
            {
                resultado = ope.Raizcuadrada( nume1);
            }
        }
        
        
        
        response.setContentType("text/html");
        request.setAttribute("Resultado",""+resultado);
        request.getRequestDispatcher("Resultado.jsp").forward(request, response);
    }

    //RMI
    public void rmi()
    {
        try
        {
            ope = (Operaciones) Naming.lookup("rmi://localhost/operaciones");
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex) 
        {
             Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
