package com.khesam.monitoring;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.faulttolerance.api.CircuitBreakerMaintenance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {

    private final CircuitBreakerMaintenance maintenance;

    @Inject
    public AppLifecycleBean(CircuitBreakerMaintenance maintenance) {
        this.maintenance = maintenance;
        maintenance.onStateChange("asghar", circuitBreakerState -> {
            switch (circuitBreakerState) {
                case OPEN:
                case HALF_OPEN:
                    System.out.println("ridi");
                    break;
                case CLOSED:
                    System.out.println("aftabeh");
                    break;
            }
        });
    }

    void onStart(@Observes StartupEvent ev) {
    }

    void onStop(@Observes ShutdownEvent ev) {
    }

}
