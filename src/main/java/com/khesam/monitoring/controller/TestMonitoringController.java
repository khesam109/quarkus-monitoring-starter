package com.khesam.monitoring.controller;

import com.khesam.monitoring.service.TestMonitorService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * https://quarkus.io/guides/smallrye-metrics#quarkus-smallrye-metrics_quarkus.smallrye-metrics.path
 */
@ApplicationScoped
public class TestMonitoringController implements TestMonitoringRestResource {

    private final TestMonitorService testMonitorService;
    private final MeterRegistry meterRegistry;

    @Inject
    public TestMonitoringController(TestMonitorService testMonitorService, MeterRegistry meterRegistry) {
        this.testMonitorService = testMonitorService;
        this.meterRegistry = meterRegistry;
    }

    @Override
//    @Counted(value = "com.khesam.monitoring", description = "count requests count!", recordFailuresOnly = true)
    public Response count(String failed) {
        if (failed.equalsIgnoreCase("failed"))
            throw new WebApplicationException(
                    Response.status(500).build()
            );
        return Response.noContent().build();
    }

    @Override
    public Response anotherTest() {
        testMonitorService.errorTest();
        return Response.noContent().build();
    }
}
