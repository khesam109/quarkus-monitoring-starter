package com.khesam.monitoring.service;

import com.khesam.monitoring.port.output.FaultClient;
import io.micrometer.core.instrument.MeterRegistry;
import io.smallrye.faulttolerance.api.CircuitBreakerMaintenance;
import io.smallrye.faulttolerance.api.CircuitBreakerName;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestMonitorService {

    private final FaultClient faultClient;
    private final CircuitBreakerMaintenance maintenance;
    private final MeterRegistry meterRegistry;


    public TestMonitorService(
            @RestClient FaultClient faultClient,
            CircuitBreakerMaintenance maintenance,
            MeterRegistry meterRegistry
    ) {
        this.faultClient = faultClient;
        this.maintenance = maintenance;
        this.meterRegistry = meterRegistry;
//        maintenance.onStateChange("asghar", circuitBreakerState -> {
//            switch (circuitBreakerState) {
//                case OPEN:
//                case HALF_OPEN:
//                    System.out.println("ridi");
//                    break;
//                case CLOSED:
//                    System.out.println("aftabeh");
//                    break;
//            }
//        });
    }

//    @Retry(maxRetries = 2)
    @CircuitBreaker(requestVolumeThreshold = 2)
    @CircuitBreakerName("asghar")
    public void errorTest() {
        System.out.println("I am here!");
        faultClient.getError();
//        try {
//
//            System.out.println("I am here!");
//            faultClient.getError();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
