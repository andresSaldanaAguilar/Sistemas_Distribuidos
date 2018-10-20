/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andressaldana
 */
@WebService(serviceName = "Operaciones")
public class Operaciones {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "numeroUno") int numeroUno, @WebParam(name = "numeroDos") int numeroDos) {
        //TODO write your implementation code here:
        return numeroUno+numeroDos;
    }
    
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "multiplica")
    public int multiplica(@WebParam(name = "numeroUno") int numeroUno, @WebParam(name = "numeroDos") int numeroDos) {
        //TODO write your implementation code here:
        return numeroUno*numeroDos;
    }
    
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "resta")
    public int resta(@WebParam(name = "numeroUno") int numeroUno, @WebParam(name = "numeroDos") int numeroDos) {
        //TODO write your implementation code here:
        return numeroUno-numeroDos;
    }
    
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "divide")
    public double divide(@WebParam(name = "numeroUno") double numeroUno, @WebParam(name = "numeroDos") double numeroDos) {
        //TODO write your implementation code here:
        return numeroUno/numeroDos;
    }
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "maximo")
    public double maximo(@WebParam(name = "numeroUno") double numeroUno, @WebParam(name = "numeroDos") double numeroDos) {
        //TODO write your implementation code here:
        return Math.max(numeroUno, numeroDos);
    }    
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "promedio")
    public double promedio(@WebParam(name = "numeroUno") double numeroUno, @WebParam(name = "numeroDos") double numeroDos) {
        //TODO write your implementation code here:
        return (numeroUno*numeroDos)/2;
    }
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "paridad")
    public String paridad(@WebParam(name = "numeroUno") double numeroUno) {
        //TODO write your implementation code here:
        return numeroUno%2 == 0 ? "Es par":"Es impar";
    }
    
    /**
     * Web service operation
     * @param numeroUno
     * @param numeroDos
     */
    @WebMethod(operationName = "fibonacci")
    public String fibonacci(@WebParam(name = "numeroUno") double numeroUno) {
        int x =0;
        int y =0;
        int solucion;
        String fibo = "";
        for(int i=1;i<numeroUno+1;i++){
            if(i==1 || i==2){
                fibo += "1, ";
                x=1;
                y=1;
            }
            else{
                solucion=x+y;
                fibo += solucion+" ,";
                x=y;
                y=solucion;
             }
        }
        return fibo;
    }    
    
    @WebMethod(operationName = "cuadrado")
    public double cuadrado(@WebParam(name = "numeroUno") double numeroUno) {
        //TODO write your implementation code here:
        return Math.pow(numeroUno, 2);
    }
    
    @WebMethod(operationName = "raiz")
    public double raiz(@WebParam(name = "numeroUno") double numeroUno) {
        //TODO write your implementation code here:
        return Math.sqrt(numeroUno);
    }   
    
    public static void main(String[] args) {
        Operaciones o = new Operaciones();
        System.out.println(o.fibonacci(5));
    }
    
 
                    
    
}
