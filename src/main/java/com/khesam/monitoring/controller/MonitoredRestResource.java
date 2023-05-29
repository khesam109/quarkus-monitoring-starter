package com.khesam.monitoring.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public interface MonitoredRestResource {

    @GET
    @Path("/success")
    @Produces(MediaType.APPLICATION_JSON)
    Response success();

    @GET
    @Path("/failed")
    @Produces(MediaType.APPLICATION_JSON)
    Response failed();

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    Response random();
}
