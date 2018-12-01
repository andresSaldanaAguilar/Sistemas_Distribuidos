/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.services;


import Modelos.Carrera;
import controladores.CarreraOps;
import controladores.NewHibernateUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author andressaldana
 */
@RequestScoped
@Path("carrera")
@Produces("application/json")
@Consumes("application/json")

public class CarreraEndPoint {

    CarreraOps crudCarrera = new CarreraOps();
    
    @POST
    public Response create(@QueryParam("nombre") String nombre, @QueryParam("descripcion") String descripcion){
        Carrera carrera = crudCarrera.create(nombre, descripcion);
        String json = carrera.toString();
        return Response.ok("success").build();
    }
    
    @PUT
    public Response update(@QueryParam("id") int id, @QueryParam("nombre") String nombre, @QueryParam("descripcion") String descripcion){
        Carrera carrera = crudCarrera.update(id, nombre, descripcion);
        String json = carrera.toString();
        return Response.ok("success").build();
    }
    
    @DELETE
    public Response delete(@QueryParam("id") int id){
        Carrera carrera = crudCarrera.delete(id);
        String json = carrera.toString();
        return Response.ok("success").build();
    }
    
    @GET
    @Path("/all")
    public Response list(){
        String carreras = crudCarrera.listAll();
        return Response.ok(carreras).build();
    }
    
    @GET
    public Response list(@QueryParam("id") int id){
        String carrera = crudCarrera.listOne(id);
        return Response.ok(carrera).build();
    }
}
