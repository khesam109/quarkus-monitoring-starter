package com.khesam.monitoring.controller;

import jakarta.ws.rs.core.Response;

import java.util.Random;

public class MonitoredController implements MonitoredRestResource {

    private static final int[] FAILED_STATUS = new int[] {400, 401, 402, 403, 415, 500, 501, 502, 503};
    private static final Random RANDOM = new Random();

    @Override
    public Response success() {
        return Response.noContent().build();
    }

    @Override
    public Response failed() {
        return Response.status(
                FAILED_STATUS[RANDOM.nextInt(FAILED_STATUS.length - 1)]
        ).build();
    }

    @Override
    public Response random() {
        if (RANDOM.nextInt(10) % 2 == 0)
            return Response.noContent().build();
        return Response.status(
                FAILED_STATUS[RANDOM.nextInt(FAILED_STATUS.length - 1)]
        ).build();
    }
}
