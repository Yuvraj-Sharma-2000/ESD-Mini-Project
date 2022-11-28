package com.controller;

import com.bean.alumniOrganisation;
import com.service.alumniOrgService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/org")
public class alumniOrgController {
    alumniOrgService service = new alumniOrgService();

    @DELETE
    @Path("/delete")
    public Response delete(@QueryParam("id") int id){
        boolean done = service.delete(id);
        if (done==false)
            return Response.status(401).build();
        return Response.ok().entity("Done").build();
    }

    @POST
    @Path("/add")
    public Response add(alumniOrganisation organisation){
        alumniOrganisation org = service.add(organisation);
        if (org==null)
            return Response.status(401).build();
        return Response.ok().entity(org).build();
    }

    @PUT
    @Path("update")
    public Response update(alumniOrganisation organisation){
        alumniOrganisation org = service.update(organisation);
        if (org==null)
            return Response.status(401).build();
        return Response.ok().entity(org).build();
    }

    @POST
    @Path("details")
    public Response details(@QueryParam("id") int id){
        List<alumniOrganisation> org = service.details(id);
        if (org==null)
            return Response.status(401).build();
        return Response.ok().entity(org).build();
    }

    @GET
    @Path("/info")
    public Response info(){
        return Response.ok().entity(service.info()).build();
    }
}
