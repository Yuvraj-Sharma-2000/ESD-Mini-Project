package com.controller;

import com.bean.alumni;
import com.service.alumniService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/alumni")
public class alumniController {
    alumniService alumniService = new alumniService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(alumni alumni){
        alumni alumniLogin = alumniService.login(alumni);
        if(alumniLogin==null)
            return Response.status(202 ).build();
        return Response.ok().entity(alumniLogin).build();
    }

    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumniById(@QueryParam("id") int id){
        alumni alumni1 = alumniService.getAlumniById(id);
        return Response.ok().entity(alumni1).build();
    }

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info(){
        List<alumni> alumniList = alumniService.info();
        if (alumniList==null)
            return Response.status(401).build();
        return Response.ok().entity(alumniList).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(alumni alumni){
        alumni alumni1 = alumniService.update(alumni);
        if (alumni1==null)
            return Response.status(401).build();
        return Response.ok().entity(alumni1).build();
    }
}
