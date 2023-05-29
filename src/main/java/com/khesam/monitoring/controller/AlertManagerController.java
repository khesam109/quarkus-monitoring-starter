package com.khesam.monitoring.controller;

import jakarta.ws.rs.core.Response;

public class AlertManagerController implements AlertManagerRestResource {

    @Override
    public Response webhook(Object body) {
        System.out.println("alert received");
        System.out.println(body);
        return Response.noContent().build();
    }
}
