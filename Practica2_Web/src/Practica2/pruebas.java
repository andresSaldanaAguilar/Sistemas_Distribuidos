/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import Interfaces.CentrodetrabajoInt;
import Modelo.Centrodetrabajo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

/**
 *
 * @author sam-y
 */
public class pruebas {

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static void main(String[] args) throws ParseException {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date fecha = simpleDateFormat.parse("03-02-2007");
        System.out.println("");
    }

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
