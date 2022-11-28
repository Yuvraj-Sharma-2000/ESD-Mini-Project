package com.controller;


import com.bean.alumniEducation;
import com.service.alumniEduService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/edu")
public class alumniEduController {
    alumniEduService service = new alumniEduService();

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(alumniEducation education){
        alumniEducation education1 = service.update(education);
        if (education1==null)
            return Response.status(401).build();
        return Response.ok().entity(education1).build();
    }

    @POST
    @Path("details")
    public Response details(@QueryParam("id") int id){
        List<alumniEducation> list = service.details(id);
        if (list==null)
            return Response.status(401).build();
        return Response.ok().entity(list).build();
    }
}
