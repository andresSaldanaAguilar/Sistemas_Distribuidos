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
    
}
