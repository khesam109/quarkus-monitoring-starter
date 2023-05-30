package com.khesam.monitoring.controller;

import jakarta.ws.rs.core.Response;

public class AlertManagerController implements AlertManagerRestResource {

    @Override
    public Response alert(Object body) {
        System.out.println("alert received");
        System.out.println(body);
        return Response.noContent().build();
    }

    @Override
    public Response resolved(Object body) {
        System.out.println("resolved received");
        System.out.println(body);
        return Response.noContent().build();
    }

}
