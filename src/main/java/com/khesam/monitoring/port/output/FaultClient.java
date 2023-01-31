package com.khesam.monitoring.port.output;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "fault-client")
@RequestScoped
@Path("/error")
public interface FaultClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Void getError();
}
