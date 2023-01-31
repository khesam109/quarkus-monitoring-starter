package com.khesam.monitoring.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/monitor")
public interface TestMonitoringRestResource {

    @GET
    @Path("/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    Response count(@PathParam("input") String failed);

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    Response anotherTest();
}
